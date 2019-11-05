package org.aterd.city.Activity;

import org.aterd.city.R;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.media.Image;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class ActivityReportNew extends Activity {

    public EditText edit_fname, edit_lname, edit_bio, edit_username, edit_phone;
    public ImageView button_cancel;
    public Dialog alert;
    public ImageView image;
    public Button button_file, button_location;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_new);
        image=(ImageView) findViewById(R.id.image);
//        edit_fname=(EditText) findViewById(R.id.edit_fname);
        button_cancel=(ImageView) findViewById(R.id.button_cancel);
        button_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityReportNew.super.onBackPressed();
            }
        });
        button_file=(Button) findViewById(R.id.button_file);
        button_file.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogCapture();
            }
        });
        button_location=(Button) findViewById(R.id.button_location);
        button_location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogCapture();
            }
        });
    }

    public void dialogCapture() {
        LayoutInflater inflater = getLayoutInflater();
        View alertLayout = inflater.inflate(R.layout.dialog_avatar_upload, null);
        alert = new Dialog(this, R.style.MyDialogTheme);
        alert.setContentView(alertLayout);
        alert.setCancelable(true);
        Button button_gallery=(Button) alertLayout.findViewById(R.id.button_gallery);
        Button button_camera=(Button) alertLayout.findViewById(R.id.button_camera);
        button_gallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
//                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
                Intent intent = new Intent();
                intent.setType("image/*");
                if (Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT) {
                    intent.setAction(Intent.ACTION_GET_CONTENT);
                }
                else {
                    intent.setAction(Intent.ACTION_PICK);
                    intent.setData(android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                }
                intent.putExtra(MediaStore.EXTRA_OUTPUT, MediaStore.Images.Media.EXTERNAL_CONTENT_URI.toString());
                intent.putExtra("crop", "true");
                intent.putExtra("scale", true);
                intent.putExtra("scaleUpIfNeeded", true);
                intent.putExtra("aspectX", 1);
                intent.putExtra("aspectY", 1);
                intent.putExtra("outputX", 500);
                intent.putExtra("outputY", 500);
                intent.putExtra("outputFormat", Bitmap.CompressFormat.PNG.toString());
                intent.putExtra("return-data", true);
                startActivityForResult(Intent.createChooser(intent,"آنرا کامل کنید."), 100);
            }
        });
        button_camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                intent.putExtra("crop", "true");
                intent.putExtra("scale", true);
                intent.putExtra("aspectX", 1);
                intent.putExtra("aspectY", 1);
                intent.putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString());
                startActivityForResult(intent, 2);
            }
        });
        alert.show();
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent imageReturnedIntent) {
        super.onActivityResult(requestCode, resultCode, imageReturnedIntent);
        switch(requestCode) {
            case 100:
            case 2:
                if(resultCode == RESULT_OK){
                    alert.cancel();
                    Uri selectedImage = imageReturnedIntent.getData();
                    image.setVisibility(View.VISIBLE);
                    image.setImageURI(selectedImage);
                }
                break;
        }
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}

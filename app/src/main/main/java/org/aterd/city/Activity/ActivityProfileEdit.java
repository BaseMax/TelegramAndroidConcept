package org.aterd.city.Activity;

import org.aterd.city.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class ActivityProfileEdit extends Activity {

    public EditText edit_fname, edit_lname, edit_bio, edit_username, edit_phone;
    public ImageView button_cancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_edit);
        edit_fname=(EditText) findViewById(R.id.edit_fname);
        edit_lname=(EditText) findViewById(R.id.edit_lname);
        edit_bio=(EditText) findViewById(R.id.edit_bio);
        edit_username=(EditText) findViewById(R.id.edit_username);
        edit_phone=(EditText) findViewById(R.id.edit_phone);
        button_cancel=(ImageView) findViewById(R.id.button_cancel);
        button_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityProfileEdit.super.onBackPressed();
            }
        });
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}

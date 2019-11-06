package org.aterd.city.Activity;

import org.aterd.city.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class ActivityProfile extends Activity {

    public TextView text_bio, text_username, text_phone;
    public LinearLayout box_bio, box_username, box_phone;
    public ImageView button_cancel, button_navigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        text_bio=(TextView) findViewById(R.id.text_bio);
        text_username=(TextView) findViewById(R.id.text_username);
        text_phone=(TextView) findViewById(R.id.text_phone);
        box_bio=(LinearLayout) findViewById(R.id.box_bio);
        box_username=(LinearLayout) findViewById(R.id.box_username);
        box_phone=(LinearLayout) findViewById(R.id.box_phone);

        box_bio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        box_username.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        box_phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        button_cancel=(ImageView) findViewById(R.id.button_cancel);
        button_navigation=(ImageView) findViewById(R.id.button_navigation);
        button_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityProfile.super.onBackPressed();
            }
        });
        button_navigation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), ActivityProfileEdit.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}

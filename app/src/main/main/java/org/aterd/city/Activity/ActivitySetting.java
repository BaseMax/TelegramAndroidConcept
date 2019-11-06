package org.aterd.city.Activity;

import org.aterd.city.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class ActivitySetting extends Activity {

    public LinearLayout box_account, box_profile, box_notification, box_privacy, box_language, box_signout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        box_profile=(LinearLayout) findViewById(R.id.box_profile);
        box_notification=(LinearLayout) findViewById(R.id.box_notification);
        box_privacy=(LinearLayout) findViewById(R.id.box_privacy);
        box_language=(LinearLayout) findViewById(R.id.box_language);
        box_signout=(LinearLayout) findViewById(R.id.box_signout);

        box_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), ActivityProfileEdit.class);
                startActivity(intent);
            }
        });
        box_notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), ActivitySettingNotification.class);
                startActivity(intent);
            }
        });
        box_privacy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), ActivitySettingPrivacy.class);
                startActivity(intent);
            }
        });
        box_language.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), ActivityLanguage.class);
                startActivity(intent);
            }
        });
        box_signout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), ActivityLogin.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}

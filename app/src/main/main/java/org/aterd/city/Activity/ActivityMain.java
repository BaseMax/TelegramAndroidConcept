package org.aterd.city.Activity;

import org.aterd.city.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class ActivityMain extends Activity {

    public LinearLayout tab_setting, tab_chat, tab_test, tab_profile, tab_paytax, tab_report;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tab_setting=(LinearLayout) findViewById(R.id.tab_setting);
        tab_chat=(LinearLayout) findViewById(R.id.tab_chat);
//        tab_test=(LinearLayout) findViewById(R.id.tab_test);
        tab_profile=(LinearLayout) findViewById(R.id.tab_profile);
        tab_paytax=(LinearLayout) findViewById(R.id.tab_paytax);
        tab_report=(LinearLayout) findViewById(R.id.tab_report);

        tab_setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), ActivitySetting.class);
                startActivity(intent);
            }
        });
        tab_chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), ActivityChat.class);
                startActivity(intent);
            }
        });
//        tab_test.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
        tab_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), ActivityProfile.class);
                startActivity(intent);
            }
        });
        tab_paytax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), ActivityPaytax.class);
                startActivity(intent);
            }
        });
        tab_report.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), ActivityReport.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}

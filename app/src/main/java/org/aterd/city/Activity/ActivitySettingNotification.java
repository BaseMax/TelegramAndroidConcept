package org.aterd.city.Activity;

import org.aterd.city.R;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class ActivitySettingNotification extends Activity {

    public LinearLayout box_private, box_group, box_blog, box_gallery, box_contact;
    public ImageView checkbox_private, checkbox_group, checkbox_blog, checkbox_gallery, checkbox_contact;

    public boolean[] checkboxs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_notification);

        checkboxs=new boolean[50];
        box_private=(LinearLayout) findViewById(R.id.box_private);
        box_group=(LinearLayout) findViewById(R.id.box_group);
        box_blog=(LinearLayout) findViewById(R.id.box_blog);
        box_gallery=(LinearLayout) findViewById(R.id.box_gallery);
        box_contact=(LinearLayout) findViewById(R.id.box_contact);

        checkbox_private=(ImageView) findViewById(R.id.checkbox_private);
        checkbox_group=(ImageView) findViewById(R.id.checkbox_group);
        checkbox_blog=(ImageView) findViewById(R.id.checkbox_blog);
        checkbox_gallery=(ImageView) findViewById(R.id.checkbox_gallery);
        checkbox_contact=(ImageView) findViewById(R.id.checkbox_contact);
        int i=0;
        CheckBoxInit(++i, box_private, checkbox_private, true);
        CheckBoxInit(++i, box_group, checkbox_group, false);
        CheckBoxInit(++i, box_blog, checkbox_blog, false);
        CheckBoxInit(++i, box_gallery, checkbox_gallery, true);
        CheckBoxInit(++i,box_contact, checkbox_contact, false);
    }

    public void CheckBoxSet(final int i, final View view, boolean value) {
        checkboxs[i]=value;
        int drawable=value == true ? R.drawable.checkbox_active : R.drawable.checkbox_normal;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            ((ImageView) view).setImageDrawable(getResources().getDrawable(drawable, getApplicationContext().getTheme()));
        } else {
            ((ImageView) view).setImageDrawable(getResources().getDrawable(drawable));
        }
    }

    public void CheckBoxInit(final int i, final View view, final View checkbox, boolean value) {
        CheckBoxSet(i, checkbox, value);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkboxs[i] == false) {
                    CheckBoxSet(i, checkbox, true);
                }
                else {
                    CheckBoxSet(i, checkbox, false);
                }
            }
        });
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}

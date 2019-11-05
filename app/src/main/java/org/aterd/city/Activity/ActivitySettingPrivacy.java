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

public class ActivitySettingPrivacy extends Activity {
    public boolean[] checkboxs1, checkboxs2;
    public View[] checkbox_box1, checkbox_box2;
    public View[] checkbox_element1, checkbox_element2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_privacy);
        /////////////////////////////////
        checkboxs1=new boolean[3];
        checkbox_box1=new View[3];
        checkbox_element1=new View[3];

        checkbox_box1[0]=(LinearLayout) findViewById(R.id.box_lastseen_all);
        checkbox_box1[1]=(LinearLayout) findViewById(R.id.box_lastseen_contact);
        checkbox_box1[2]=(LinearLayout) findViewById(R.id.box_lastseen_none);

        checkbox_element1[0]=(ImageView) findViewById(R.id.radiobox_lastseen_all);
        checkbox_element1[1]=(ImageView) findViewById(R.id.radiobox_lastseen_contact);
        checkbox_element1[2]=(ImageView) findViewById(R.id.radiobox_lastseen_none);

        checkboxs1[0]=true;
        checkboxs1[1]=false;
        checkboxs1[2]=false;
        CheckBoxInits(checkbox_box1, checkbox_element1, checkboxs1);
        /////////////////////////////////
        checkboxs2=new boolean[3];
        checkbox_box2=new View[3];
        checkbox_element2=new View[3];

        checkbox_box2[0]=(LinearLayout) findViewById(R.id.box_profilepic_all);
        checkbox_box2[1]=(LinearLayout) findViewById(R.id.box_profilepic_contact);
        checkbox_box2[2]=(LinearLayout) findViewById(R.id.box_profilepic_none);

        checkbox_element2[0]=(ImageView) findViewById(R.id.radiobox_profilepic_all);
        checkbox_element2[1]=(ImageView) findViewById(R.id.radiobox_profilepic_contact);
        checkbox_element2[2]=(ImageView) findViewById(R.id.radiobox_profilepic_none);

        checkboxs2[0]=true;
        checkboxs2[1]=false;
        checkboxs2[2]=false;
        CheckBoxInits(checkbox_box2, checkbox_element2, checkboxs2);
    }

    public void CheckBoxSet(final int i, final View[] views, final View[] checkboxs, final boolean[] values, final View box, final View element, boolean value) {
        values[i]=value;
        int drawable=value == true ? R.drawable.radiobutton_active : R.drawable.radiobutton_normal;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            ((ImageView) element).setImageDrawable(getResources().getDrawable(drawable, getApplicationContext().getTheme()));
        } else {
            ((ImageView) element).setImageDrawable(getResources().getDrawable(drawable));
        }
    }

    public void CheckBoxInit(final int i,final View[] boxs, final View[] elements, final boolean[] values, final View box, final View element, final boolean value) {
        boxs[i].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean[] checkboxs_false=new boolean[50];
                CheckBoxInits(boxs, elements, checkboxs_false);
                if(values[i] == false) {
                    CheckBoxSet(i, boxs, elements, values, box, element, true);
                }
                else {
                    CheckBoxSet(i, boxs, elements, values, box, element, false);
                }
            }
        });
    }

    public void CheckBoxInits(final View[] boxs, final View[] elements, final boolean[] values) {
        for(int i = 0; i<boxs.length; i++) {
            CheckBoxSet(i, boxs, elements, values, boxs[i], elements[i], values[i]);
            CheckBoxInit(i, boxs, elements, values, boxs[i], elements[i], values[i]);
        }
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}

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

public class ActivityLanguage extends Activity {
    public boolean[] checkboxs;
    public View[] checkbox_box;
    public View[] checkbox_element;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language);
        checkboxs=new boolean[2];
        checkbox_box=new View[2];
        checkbox_element=new View[2];

        checkbox_box[0]=(LinearLayout) findViewById(R.id.box_persian);
        checkbox_box[1]=(LinearLayout) findViewById(R.id.box_arabic);

        checkbox_element[0]=(ImageView) findViewById(R.id.radiobox_persian);
        checkbox_element[1]=(ImageView) findViewById(R.id.radiobox_arabic);

        checkboxs[0]=true;
        checkboxs[1]=false;

        CheckBoxInits(checkbox_box, checkbox_element, checkboxs);
    }

    public void CheckBoxSet(final int i, final View view, boolean value) {
        checkboxs[i]=value;
        int drawable=value == true ? R.drawable.radiobutton_active : R.drawable.radiobutton_normal;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            ((ImageView) view).setImageDrawable(getResources().getDrawable(drawable, getApplicationContext().getTheme()));
        } else {
            ((ImageView) view).setImageDrawable(getResources().getDrawable(drawable));
        }
    }

    public void CheckBoxInits(View[] box, View[] element, boolean[] value) {
        for(int i=0; i<box.length;i++) {
            CheckBoxInit(i, box[i], element[i],value[i]);
        }
    }

    public void CheckBoxInit(final int i, final View view, final View checkbox, boolean value) {
        CheckBoxSet(i, checkbox, value);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean[] checkboxs_false=new boolean[50];
                CheckBoxInits(checkbox_box, checkbox_element, checkboxs_false);
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

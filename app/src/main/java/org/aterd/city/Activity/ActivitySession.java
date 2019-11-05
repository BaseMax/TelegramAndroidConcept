package org.aterd.city.Activity;

import org.aterd.city.R;
import org.aterd.city.Utility.DataAdapter;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class ActivitySession extends Activity {

    public ListView list_current, list_other;
    public ArrayList<HashMap<String, Object>> listdata_current, listdata_other;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_session);
        list_current=(ListView) findViewById(R.id.list_current);
        list_other=(ListView) findViewById(R.id.list_other);
        listdata_current = new ArrayList<>();
        listdata_other = new ArrayList<>();
        ListAdd(listdata_current, "اپی اندروید 9.0.0", "Android 4.0.2، Xiaomi redmi 7A", "192.168.1.1", "19:25", "Iran, Tehran");
        ListAdd(listdata_other, "اپی اندروید 1.0.0", "Android 4.0.2، Xiaomi redmi 7A", "192.168.1.1", "19:25", "Iran, Tehran");
        ListAdd(listdata_other, "اپی اندروید 1.0.0", "Android 4.0.2، Xiaomi redmi 7A", "192.168.1.1", "19:25", "Iran, Tehran");
        ListAdd(listdata_other, "اپی اندروید 1.0.0", "Android 4.0.2، Xiaomi redmi 7A", "192.168.1.1", "19:25", "Iran, Tehran");
        ListAdd(listdata_other, "اپی اندروید 1.0.0", "Android 4.0.2، Xiaomi redmi 7A", "192.168.1.1", "19:25", "Iran, Tehran");
        ListAdd(listdata_other, "اپی اندروید 1.0.0", "Android 4.0.2، Xiaomi redmi 7A", "192.168.1.1", "19:25", "Iran, Tehran");

        final DataAdapter adapter_other = new DataAdapter(this, R.layout.list_session, listdata_other);
        list_other.setAdapter(adapter_other);
        list_other.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "Click " + position, Toast.LENGTH_LONG).show();
            }
        });
        final DataAdapter adapter_current = new DataAdapter(this, R.layout.list_session, listdata_current);
        list_current.setAdapter(adapter_current);
        list_current.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "Click " + position, Toast.LENGTH_LONG).show();
            }
        });
    }

    public void ListAdd(ArrayList<HashMap<String, Object>> listdata, String app, String device, String ip, String time, String location) {
        HashMap<String, Object> map=new HashMap<>();
        map.put("app", app);
        map.put("device", device);
        map.put("time", time);
        map.put("ip", ip);
        map.put("location", location);
        listdata.add(map);
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}

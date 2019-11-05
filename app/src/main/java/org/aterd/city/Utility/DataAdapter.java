package org.aterd.city.Utility;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.aterd.city.R;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataAdapter extends ArrayAdapter<HashMap<String, Object>> {
    public int Layout;
    public DataAdapter(Context context, int layout, ArrayList<HashMap<String, Object>> data) {
        super(context, 0, data);
        Layout=layout;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        HashMap<String, Object> item = getItem(position);
        if (view == null) {
            view = LayoutInflater.from(getContext()).inflate(Layout, parent, false);
        }
        if(Layout == R.layout.list_chat) {
            ImageView avatar=view.findViewById(R.id.avatar);
            TextView name=view.findViewById(R.id.name);
            TextView message=view.findViewById(R.id.message);
            TextView time=view.findViewById(R.id.time);
            TextView unread=view.findViewById(R.id.unread_number);
            avatar.setImageResource((int) item.get("avatar"));
            name.setText((String) item.get("name"));
            message.setText((String) item.get("message"));
            time.setText((String) item.get("time"));
            if((Integer) item.get("unread") > 0) {
                unread.setText(((Integer) item.get("unread")).toString());
            }
            else {
                unread.setVisibility(View.GONE);
            }
        }
        else if(Layout == R.layout.list_session) {
            TextView name=view.findViewById(R.id.name);
            TextView device=view.findViewById(R.id.device);
            TextView detail=view.findViewById(R.id.detail);
            TextView time=view.findViewById(R.id.time);
            name.setText((String) item.get("app"));
            device.setText((String) item.get("device"));
            time.setText((String) item.get("time"));
            detail.setText((String) item.get("ip") + " - " + (String) item.get("location"));
        }
        else if(Layout == R.layout.list_report) {
            TextView name=view.findViewById(R.id.name);
            TextView message=view.findViewById(R.id.message);
            TextView time=view.findViewById(R.id.time);
            TextView unread=view.findViewById(R.id.unread_number);
            name.setText((String) item.get("name"));
            message.setText((String) item.get("message"));
            time.setText((String) item.get("time"));
            if((Integer) item.get("unread") > 0) {
                unread.setText(((Integer) item.get("unread")).toString());
            }
            else {
                unread.setVisibility(View.GONE);
            }
        }
        return view;
    }
}
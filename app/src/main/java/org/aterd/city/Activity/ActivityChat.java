package org.aterd.city.Activity;

import org.aterd.city.R;
import org.aterd.city.Utility.DataAdapter;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class ActivityChat extends Activity {

    public ListView list_chat;
    public ArrayList<HashMap<String, Object>> listdata_chat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        list_chat=(ListView) findViewById(R.id.list_chat);
        listdata_chat = new ArrayList<>();
        ListAdd("جواد ثابت", "از زرد به نقره ای کم رنگ تغییر دادم", "3:46", 0, R.drawable.chat_avatar);
        ListAdd("سیدمجیدحسینی", "شيرآباد، برای سه هزار دانش آموز باز مانده از تحصيل مدرسه\u200Cای ندارد، طفلک زيبا ميان آشغال\u200Cهای محل می\u200Cچرخد فقط؛ \n", "1:39", 0, R.drawable.chat_avatar2);
        ListAdd("◦•●◉✿گروه ولایی و علمی فرهنگی کاشان ✿◉●•◦", "مصاحبه با #جانبازسرافرازانقلاب \uD83C\uDDEE\uD83C\uDDF7 \uD83C\uDDEE\uD83C\uDDF7\n" + "\uD83C\uDF37\uD83C\uDF37 #سیدعلی_پیامبرپور ، امام جماعت محترم مسجد محتشم کاشان در مورد اهمیت زیاد کتاب انسانیّت و شرافت گفت : کتاب قرآن و عاشورا ، بزرگترین و بهترین", "1:39", 0, R.drawable.chat_avatar3);
        ListAdd("رضا حیدری", "اولین شارژ تا دهمین شارژ خیلی مهمه با ولتاژ مناسب باشه بیشتر ۹۰ ۹۵ نشه", "3:46", 1, R.drawable.chat_avatar4);
        ListAdd("کامبیز اسد زاده", "دقیقا برا همین دهن مایکروسافت رو قشنگ صاف کرده", "3:46", 0, R.drawable.chat_avatar5);
        ListAdd("سیاوش دشتی", "فعلا همینارو برسون به دستم", "3:46", 3, R.drawable.chat_avatar6);
        ListAdd("محمديه بٓكس", "سلام \n" +
                "\n" +
                "\uD83D\uDD34دوستانی که بدون فیلترشکن نمیتونن به تلگرام وصل بشن گپ گرام ضدفیلتر رو دانلود کنن با سرعت بالا متصل بشن", "3:46", 0, R.drawable.chat_avatar7);
        final DataAdapter adapter = new DataAdapter(this, R.layout.list_chat, listdata_chat);
        list_chat.setAdapter(adapter);
        list_chat.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "Click " + position, Toast.LENGTH_LONG).show();
            }
        });
    }

    public void ListAdd(String name, String message, String time, Integer unread, Integer avatar) {
        HashMap<String, Object> map=new HashMap<>();
        map.put("name", name);
        map.put("message", message.toString().trim().replace("\n", " ").replace("  ", "").replace("  ", " "));
        map.put("time", time);
        map.put("unread", unread);
        map.put("avatar", avatar);
        listdata_chat.add(map);
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}

package com.example.a140438.todo3;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by 140438 on 2017/12/18.
 */

public class Debug extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.debug);

        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        setContentView(layout);

        OpenHelper openHelper = new OpenHelper(this);
        SQLiteDatabase db = openHelper.getReadableDatabase();

        Cursor c = null;

        String sql = "SELECT * FROM goal;";
        c = db.rawQuery(sql, new String[]{});

        boolean mov = c.moveToFirst();

        while(mov){
            TextView tv = new TextView(this);
            tv.setText(String.format("%d, %s, %s, %d, %d/%d/%d %d-%d, %d",
                    c.getInt(0), c.getString(1), c.getString(2), c.getInt(3), c.getInt(4),
                    c.getInt(5), c.getInt(6), c.getInt(7), c.getInt(8), c.getInt(9)));
            mov = c.moveToNext();
            layout.addView(tv);
        }

        c.close();
        db.close();
    }
}

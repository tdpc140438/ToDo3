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
        Cursor c2 = null;
        Cursor c3 = null;
        Cursor c4 = null;
        Cursor c5 = null;

        String sql = "SELECT * FROM goal;";
        c = db.rawQuery(sql, new String[]{});

        String sql2 = "SELECT * FROM user;";
        c2 = db.rawQuery(sql2, new String[]{});

        String sql3 = "SELECT * FROM package;";
        c3 = db.rawQuery(sql3, new String[]{});

        String sql4 = "SELECT * FROM picture;";
        c4 = db.rawQuery(sql4, new String[]{});

        String sql5 = "SELECT * FROM past;";
        c5 = db.rawQuery(sql5, new String[]{});


        boolean mov = c.moveToFirst();

        while(mov){
            TextView tv = new TextView(this);
            tv.setText(String.format("%d, %s, %s, %d, %d/%d/%d %d-%d, %d",
                    c.getInt(0), c.getString(1), c.getString(2), c.getInt(3), c.getInt(4),
                    c.getInt(5), c.getInt(6), c.getInt(7), c.getInt(8), c.getInt(9)));
            mov = c.moveToNext();
            layout.addView(tv);
        }

        boolean mov2 = c2.moveToFirst();

        while(mov2){
            TextView tv2 = new TextView(this);
            tv2.setText(String.format("%d, %s, %d, %d, %s",
                    c2.getInt(0), c2.getString(1), c2.getInt(2), c2.getInt(3), c2.getString(4)));
            mov2 = c2.moveToNext();
            layout.addView(tv2);
        }

        boolean mov3 = c3.moveToFirst();

        while(mov3){
            TextView tv3 = new TextView(this);
            tv3.setText(String.format("%s, %s, %d",
                    c3.getString(0), c3.getString(1), c3.getInt(2)));
            mov3 = c3.moveToNext();
            layout.addView(tv3);
        }

        boolean mov4 = c4.moveToFirst();

        while(mov4){
            TextView tv4 = new TextView(this);
            tv4.setText(String.format("%d, %s",
                    c4.getInt(0), c4.getString(1)));
            mov4 = c4.moveToNext();
            layout.addView(tv4);
        }

        boolean mov5 = c5.moveToFirst();

        while(mov5){
            TextView tv5 = new TextView(this);
            tv5.setText(String.format("%d, %s, %d, %d, %d, %d ",
                    c5.getInt(0), c5.getString(1),c5.getInt(2),c5.getInt(3),c5.getInt(4),c5.getInt(5)));
            mov5 = c5.moveToNext();
            layout.addView(tv5);
        }


        c.close();
        c2.close();
        c3.close();
        c4.close();
        db.close();
    }
}

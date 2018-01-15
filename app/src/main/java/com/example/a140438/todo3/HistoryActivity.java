package com.example.a140438.todo3;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

public class HistoryActivity extends AppCompatActivity {

    private CheckBox checkBox[] = new CheckBox[50];
    private TextView goal_name[] = new TextView[50];
    private TextView success_days[] = new TextView[50];
    private LinearLayout width_Layout [] = new LinearLayout[50];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        //SQLite
        OpenHelper helper = new OpenHelper(this);
        final SQLiteDatabase db = helper.getWritableDatabase();

        //forでpastテーブルの件数ぶん取得し、1件ごとにチェックボタンと2つのテキストビューを横並びにしたレイアウトを history_length_layout に追加する

        Cursor c_past = null;
        //select
        String sql_past = "SELECT * FROM past;";
        c_past = db.rawQuery(sql_past, new String[]{});
        boolean mov_past = c_past.moveToFirst();
        /*for(int i = 0;){
        }*/






    }
}

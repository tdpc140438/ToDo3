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

        Cursor c_count = null;
        //select
        /*      String sql_count = "SELECT COUNT(*) FROM past;";
        c_count = db.rawQuery(sql_count, new String[]{});
        int cnt = c_count.getInt(0);
        */
        boolean mov_count = c_past.moveToFirst();
        //縦レイアウト作成
        LinearLayout history_length_layout = (LinearLayout) findViewById(R.id.history_length_layout);

        LinearLayout.LayoutParams buttonLayoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);



        for(int i = 1 ; i < checkBox.length ;i++) {
            if (mov_past) {
                checkBox[i] = new CheckBox(this);
                goal_name[i] = new TextView(this);
                success_days[i] = new TextView(this);
                width_Layout[i] = new LinearLayout(HistoryActivity.this);

                // Tagを設定する,チェックボックスにTagを設定し、削除するときに使用する。
                checkBox[i].setTag(c_past.getInt(0));

                //それぞれのビューにそれぞれの対応テキストを追加
                goal_name[i].setText(String.format("%s",c_past.getString(1)));
                success_days[i].setText(String.format("    %d/%d/%d",c_past.getInt(2),c_past.getInt(3),c_past.getInt(4)));


                //横レイアウトの作成
                width_Layout[i].setOrientation(width_Layout[i].HORIZONTAL);
                width_Layout[i].setLayoutParams(
                        new LinearLayout.LayoutParams(
                                LinearLayout.LayoutParams.WRAP_CONTENT,    //文字列の幅に合わせる
                                LinearLayout.LayoutParams.WRAP_CONTENT));  //文字列の高さに合わせる

                //ボタンのレイアウト設定
                checkBox[i].setLayoutParams(buttonLayoutParams);

                //横レイアウトに目標名を追加,横レイアウトにチェックボックスを追加
                width_Layout[i].addView(checkBox[i]);
                width_Layout[i].addView(goal_name[i]);
                width_Layout[i].addView(success_days[i]);

                history_length_layout.addView(width_Layout[i]);
                goal_name[i].setLayoutParams(buttonLayoutParams);


                mov_past = c_past.moveToNext();
            }
            else{
                break;
            }
         }
        }
    }

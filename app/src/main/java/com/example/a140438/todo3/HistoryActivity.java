package com.example.a140438.todo3;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import static android.app.ProgressDialog.show;

public class HistoryActivity extends AppCompatActivity {

    private static final int HISTORY_SIZE = 50;

    private CheckBox checkBox[] = new CheckBox[HISTORY_SIZE];
    private TextView goal_name[] = new TextView[HISTORY_SIZE];
    private TextView success_days[] = new TextView[HISTORY_SIZE];
    private TextView TorF[] = new TextView[HISTORY_SIZE];
    private LinearLayout width_Layout [] = new LinearLayout[HISTORY_SIZE];
    private int del_array [] = new int [HISTORY_SIZE];
    private Button delete_btn;
/*チェックボックスの件数文のカウント用の変数、チェック状態を取得するときのループ回数の条件にする。ループで取得したtagの数字をdel_arrayに挿入し、delete処理のループで順番にキーとして使用して削除を行う*/
    public int checkBox_cnt;
//    public int x,y;


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
        //縦レイアウト作成
        LinearLayout history_length_layout = (LinearLayout) findViewById(R.id.history_length_layout);

        LinearLayout.LayoutParams buttonLayoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);



        for(int i = 0 ; mov_past  && i < checkBox.length ;i++) {
            checkBox[i] = new CheckBox(this);
            goal_name[i] = new TextView(this);
            success_days[i] = new TextView(this);
            width_Layout[i] = new LinearLayout(HistoryActivity.this);
            TorF[i] = new TextView(HistoryActivity.this);

            // Tagを設定する,チェックボックスにTagを設定し、削除するときに使用する。
            checkBox[i].setTag(c_past.getInt(0));
            //ボタンid
            int checkBoxid = View.generateViewId();
            //idセット
            checkBox[i].setId(checkBoxid);

            //それぞれのビューにそれぞれの対応テキストを追加
            goal_name[i].setText(String.format("%s", c_past.getString(1)));
            success_days[i].setText(String.format("    %d/%d/%d", c_past.getInt(2), c_past.getInt(3), c_past.getInt(4)));
            int y = (c_past.getInt(5));
            if (y == 0) {
                TorF[i].setText("   成功");
            } else {
                TorF[i].setText("   失敗");

            }

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
            width_Layout[i].addView(TorF[i]);


            history_length_layout.addView(width_Layout[i]);
            goal_name[i].setLayoutParams(buttonLayoutParams);

            //チェックボックス取得と削除
            //チェックボックスの件数を取得
            checkBox_cnt++;

            mov_past = c_past.moveToNext();
        }

//            for (y = 1; y < i; y++) {
//                Log.d(" i ", "変数 i は「" + i + "」");
//                Log.d(" checkBox[y] ", "配列 checkBox[y] は「" + checkBox[y] + "」");
//                checkBox[y].setOnClickListener(new View.OnClickListener() {
//                    // タップされると呼び出される
//                    @Override
//                    public void onClick(View v) {
//                        // チェックステータス取得
//                        boolean check = checkBox[y].isChecked();
//                        Log.d(" check ", "変数 check は「" + check + "」");
//
//                        if (check) {
//                            Log.d(" v.getTag()", "変数  v.getTag() は「" + v.getTag() + "」");
//                            del_array[y] = (Integer) v.getTag();
//                        } else {
//
//                        }
//                    }
//                });
//
//
//            }

            //削除ボタン
            delete_btn = (Button) findViewById(R.id.delete_btn);
            delete_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    boolean check = false;
                    for (int i = 0; !check && i < HISTORY_SIZE; i++) {
                        check = checkBox[i].isChecked();
                        if (checkBox[i] == null) {
                            break;
                        }

                        //チェックボックス生成数だけループして、チェックが入っているものをdel_arrayに挿入する。
                        // リスナーを登録
                    }
                    Log.d("checkBox", "変数 checkBoxは「" + checkBox_cnt + "」");
                    for (int i = 0; i < checkBox_cnt; i++) {

                        boolean t_check = checkBox[i].isChecked();

                        if (t_check) {

                            del_array[i] = (Integer) checkBox[i].getTag();

                        } else {

                        }
                    }

                    //boolean check = checkBox[y].isChecked();
                    if (check) {
                        //ダイアログを表示
                        new AlertDialog.Builder(HistoryActivity.this)
                                .setTitle("履歴削除確認")
                                .setMessage("チェックされた履歴を削除します。よろしいですか？")
                                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        //Log.d("del_array.length", "変数 del_array.length は「" + del_array.length + "」");
                                        // OKをタップしたときの処理
                                        //del_arrayの中身をキーとして、pastテーブルを削除
                                        for (int i = 0; i < checkBox_cnt; i++) {
                                            //boolean check = checkBox[i].isChecked();
                                            //Log.d("check", "変数 checkは「" + check + "」");

                                            String delete_sql = "DELETE FROM past WHERE past_id = " + del_array[i] + ";";
                                            Log.d("SQL_DELETE", "SQLは「" + delete_sql + "」");
                                            db.execSQL(delete_sql);
                                        }
                                        Intent history_del = new Intent(HistoryActivity.this, MainActivity.class);
                                        startActivity(history_del);

                                    }
                                })
                                .setNegativeButton("Cancel", null)
                                .show();
                        }
                }
            });
         }
       }


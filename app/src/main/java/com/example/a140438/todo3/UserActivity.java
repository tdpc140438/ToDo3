package com.example.a140438.todo3;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class UserActivity extends AppCompatActivity {
    String use_package = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        OpenHelper helper = new OpenHelper(this);
        final SQLiteDatabase db = helper.getWritableDatabase();

        Cursor c = null;
        Cursor c2 = null;

        String package_sql = "SELECT * FROM package;";
        c = db.rawQuery(package_sql, new String[]{});

        String user_sql = "SELECT * FROM user WHERE user_id = 1;";
        c2 = db.rawQuery(user_sql, new String[]{});

        boolean mov = c.moveToFirst();
        c2.moveToFirst();


        //Spinnerのプログラム
        ArrayAdapter adapter = new ArrayAdapter(this,
                android.R.layout.simple_spinner_item);

        //現在設定している言語パック名を初期値(先頭)に設定する
        adapter.add(c2.getString(4));

        //残りの言語パック名をリストに設定
        while (mov){
            //使用中の言語パック名と登録しようとしている言語パック名を照合
            //同じならば、何もせず次へ(重複の防止)
            //違うならば、その言語パック名を登録
            if(c.getString(1).equals(c2.getString(4))){
                mov = c.moveToNext();
            }
            else{
                adapter.add(c.getString(1));
                mov = c.moveToNext();
            }
        }

        Spinner word_spinner = (Spinner)findViewById(R.id.word_spinner);
        word_spinner.setAdapter(adapter);

        //選んだ言語パックを変数に格納する
        word_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                use_package = String.valueOf(adapterView.getSelectedItem());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        //EditTextに値を設置
        final EditText user_name_edit = (EditText)findViewById(R.id.user_name_edit);
        user_name_edit.setText(c2.getString(1));


        Button user_submit = (Button)findViewById(R.id.user_submit);
        user_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent dbIntent = new Intent(UserActivity.this,
                        MainActivity.class);

                //userテーブルをアップデート
                String update_sql = "UPDATE user SET user_name = '" +  user_name_edit.getText().toString() + "', " +
                                    " use_package = '" + use_package + "' WHERE user_id = 1;";

                db.execSQL(update_sql);


                //MainActivityへ受け渡すパック情報(package_id)を検索
                Cursor c3 = null;
                String id_sql = "SELECT * FROM package WHERE package_name = '" + use_package + "';";
                c3 = db.rawQuery(id_sql, new String[]{});
                c3.moveToFirst();

                //idで受け渡し
                dbIntent.putExtra("user_name", user_name_edit.getText().toString());
                dbIntent.putExtra("use_package_id", c3.getString(0));
                startActivity(dbIntent);
            }
        });
    }
}

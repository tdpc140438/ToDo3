package com.example.a140438.todo3;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SuccessActivity extends AppCompatActivity {

    private  String package_def;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);

        //SQLite使用のため
        OpenHelper helper = new OpenHelper(this);
        final SQLiteDatabase db = helper.getWritableDatabase();

        //現在使用中の言語パック選択の処理
        Cursor c_pack = null;
        //select
        String sql_pack = "SELECT * FROM package WHERE package_name IN (SELECT use_package FROM user);";
        c_pack = db.rawQuery(sql_pack, new String[]{});
        boolean mov_pack = c_pack.moveToFirst();
        package_def =c_pack.getString(0);
        Log.d("def","変数 package_def は「" + package_def + "」");

        //更新画面から目標名を、DBから言語パックごとの完了メッセージを取得する。
        //目標名の取得
        Intent success = getIntent();
        String goal_name = success.getStringExtra("goal_name");

        //完了メッセージの取得
        Cursor c5 = null;
        Cursor c_User_Name = null;

        //進捗率に応じてテキストを取得する。
        String sql5 = "SELECT * FROM words WHERE switch = 24 AND package_id = '" + package_def + "';";
        c5 = db.rawQuery(sql5, new String[]{});

        //設定しているユーザー名を取得する。
        String sql_User_Name = "SELECT * FROM user ;";
        c_User_Name = db.rawQuery(sql_User_Name, new String[]{});
        boolean mov5 = c5.moveToFirst();
        boolean mov_User = c_User_Name.moveToFirst();

        String str = c5.getString(2);
        String regex = "name";

        Pattern p = Pattern.compile(regex);

        Matcher m = p.matcher(str);

        String result = m.replaceAll(c_User_Name.getString(1));

        c_User_Name.close();
        
        TextView succ_mess = findViewById(R.id.succ_mess);
        succ_mess.setText(result);




    }
};







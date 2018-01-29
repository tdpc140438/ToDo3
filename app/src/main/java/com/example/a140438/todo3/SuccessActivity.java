package com.example.a140438.todo3;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;

import java.io.FileInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SuccessActivity extends AppCompatActivity {

    private  String package_def;
    private String fileName = "picture_now";
    private ImageView success_image;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);

        success_image = (ImageView)findViewById(R.id.success_image);
        try(FileInputStream fileInputStream = openFileInput(fileName);){
            if(fileInputStream != null){
                Bitmap bitmap = BitmapFactory.decodeStream(fileInputStream);
                success_image.setImageBitmap(bitmap);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }


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
        final String goal_name = success.getStringExtra("goal_name");
        final int goal_id = success.getIntExtra("goal_id",0);
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
        TextView succ_name = findViewById(R.id.succ_name);

        //メッセージ表示
        succ_mess.setText(result);
        succ_name.setText("「" + goal_name+"」を達成しました！おめでとうございます！");

        /*テスト用*/
        // 現在日時の取得
        /*
        Date now = new Date(System.currentTimeMillis());
        // 日時のフォーマットオブジェクト作成
        DateFormat formatter = new SimpleDateFormat("yyyy年MM月dd日");
        // フォーマット
        String nowText = formatter.format(now);
        */
        //ボタンに処理を追加
        Button com_button = (Button) findViewById(R.id.com_button);
        //タップした時にする処理
        com_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent SuccessIntent = new Intent(SuccessActivity.this,
                        MainActivity.class);
                //目標を達成した場合の手順として,対象の目標名と登録日の情報を取得し、成否に0を入れてpastテーブルにINSERTする。

                //登録日の情報を取得する。
                Calendar calendar = Calendar.getInstance();
                int now_year = calendar.get(Calendar.YEAR);
                int now_month = calendar.get(Calendar.MONTH)+1;
                int now_day = calendar.get(Calendar.DAY_OF_MONTH);
                //成否は0
                int TorF = 0;
                //pastテーブルに挿入
                String insertsql = "INSERT INTO past(past_name, year, month, day, TorF)" +
                        " VALUES('" + goal_name + "', '" + now_year +
                        "', " + now_month + ", "  + now_day + ", "+ TorF +")";
                db.execSQL(insertsql);

                //goalテーブルより削除
                String delete_sql = "DELETE FROM goal WHERE goal_id = " + goal_id + ";";
                db.execSQL(delete_sql);

                startActivity(SuccessIntent);

                /*墓場
                //デバッグ
                Log.d("now_year","変数 now_year は「" + now_year + "」");
                // 表示
                TextView test_textView = (TextView)findViewById(R.id.test_textView);
                test_textView.setText(""+now_year);
                * */
            }
        });

        ImageView imageView = (ImageView) findViewById(R.id.check);
        GlideDrawableImageViewTarget target = new GlideDrawableImageViewTarget(imageView);
        Glide.with(this).load(R.raw.check).into(target);

    }
};







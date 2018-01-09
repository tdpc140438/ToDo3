package com.example.a140438.todo3;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.widget.Button;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private static final String TAG = MainActivity.class.getSimpleName();

    private boolean flag = false;
    private float scale;
    private Button button[] = new Button[50];
    private TextView g_View[] = new TextView[50];
    private LinearLayout linearLayout [] = new LinearLayout[50];
    private  int progres_key = 0 ;
    private int ram;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //SQLite
        OpenHelper helper = new OpenHelper(this);
        final SQLiteDatabase db = helper.getWritableDatabase();

        Cursor c = null;
        //select
        String sql1 = "SELECT * FROM user;";
        c = db.rawQuery(sql1, new String[]{});

        boolean mov = c.moveToFirst();

        while(mov){
            TextView textView3 = findViewById(R.id.textView3);
            textView3.setText(String.format("user_name : %s,  user_level : %d",
                    c.getString(1), c.getInt(2)));
            mov = c.moveToNext();
            //layout.addView(textView);
        }


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //mailbutton 削除
        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);



        //下に書くようにする。
        //setContentView(R.layout.activity_main);
        //ScrollViewにテキストの生成、テキストとボタン


        //setContentViewは一つのみ
// TODO:scrollView一時退避
//        ScrollView scrollView = new ScrollView(this);
//        setContentView(scrollView);


        // リラティブレイアウトの設定//
// TODO:relactive一時退避
//        RelativeLayout relative = new RelativeLayout(this);
//        relative.setLayoutParams(new RelativeLayout.LayoutParams(
//                RelativeLayout.LayoutParams.MATCH_PARENT,
//                RelativeLayout.LayoutParams.MATCH_PARENT));

        //縦レイアウト
        LinearLayout layout = (LinearLayout) findViewById(R.id.length_layout);

        // dp 設定
        scale = getResources().getDisplayMetrics().density;


        // TextView インスタンス生成（本実装時はループを利用して設定）
        final TextView textView = new TextView(this);
        textView.setText("テスト目標1");

        // setMargins (int left, int top, int right, int bottom)

        RelativeLayout.LayoutParams textLayoutParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);

        textLayoutParams.setMargins((int) (150 * scale), (int) (300 * scale), 0, 0);
        textView.setLayoutParams(textLayoutParams);


            //id生成
            int Textid = View.generateViewId();
            //idセット
            textView.setId(Textid);
            // TODO:relactive一時退避
            // relative.addView(textView);

        //横レイアウトへ追加
        //layout2.addView(textView);
//
//

        LinearLayout.LayoutParams buttonLayoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);

        Cursor c3 = null;
        //select
        String sql3 = "SELECT * FROM goal;";
        c3 = db.rawQuery(sql3, new String[]{});
        boolean mov3 = c3.moveToFirst();




        //動的ボタン生成部分
        for(int i = 1 ; i < button.length;i++) {
            TextView words_textView =findViewById(R.id.words_textView);
         if(mov3) {
             button[i] = new Button(this);
             g_View[i] = new TextView(this);
             linearLayout[i] = new LinearLayout(MainActivity.this);

             //ボタンid
             int Buttonid = View.generateViewId();
             //idセット
             button[i].setId(Buttonid);

             // Tagを設定する,ボタンとビューそれぞれに目標idを設定
             button[i].setTag(c3.getInt(0));
             button[i].setText(String.format(Locale.US, "…", i));
             g_View[i].setTag(c3.getInt(0));
             g_View[i].setText(String.format("%d.%s",i, c3.getString(1)));
             //横レイアウトの作成
             linearLayout[i].setOrientation(linearLayout[i].HORIZONTAL);
             linearLayout[i].setLayoutParams(
                     new LinearLayout.LayoutParams(
                             LinearLayout.LayoutParams.WRAP_CONTENT,    //文字列の幅に合わせる
                             LinearLayout.LayoutParams.WRAP_CONTENT));  //文字列の高さに合わせる

             //ボタンのレイアウト設定
             button[i].setLayoutParams(buttonLayoutParams);

             //横レイアウトに目標用ビューを追加
             linearLayout[i].addView(g_View[i]);
             layout.addView(linearLayout[i]);


             //横レイアウトにボタンを追加
             linearLayout[i].addView(button[i]);
             g_View[i].setLayoutParams(buttonLayoutParams);

             //遷移する際のデータ渡し用
             mov3 = c3.moveToNext();
             //目標詳細画面への遷移
             button[i].setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {

                    //Tagでidを取得する
                     Intent intent = new Intent(getApplication(), UpdateActivity.class);
                     intent.putExtra("goal_id", (Integer) v.getTag());
                     //返しのデータを受け取るため            startActivity(intent);
                     int requestCode = 1000;
                     startActivityForResult( intent, requestCode );
                 }
             });

             //目標名をタップした時のテキスト表示
             g_View[i].setOnClickListener(new View.OnClickListener() {
                     @Override
                     public void onClick(View v) {
                         TextView words_textView =findViewById(R.id.words_textView);
                         //Tagでidを取得する
                     //1.idから進捗率を取得する。
                     //2.progres_keyに進捗率に対応した値をセットする。
                     //3.progres_keyを検索条件としてセリフテーブルからデータを取得する。
                         //ToDo:package_id
                     Cursor c4 = null;
                     //select
                     String sql4 = "SELECT * FROM goal WHERE goal_id = " + v.getTag() + ";";
                     c4 = db.rawQuery(sql4, new String[]{});
                     boolean mov4 = c4.moveToFirst();
                     progres_key = c4.getInt(3);
                     c4.close();

                     //progres_keyを変換
                     switch (progres_key){
                         case 0:
                             progres_key=14;
                             break;
                         case 10:
                             progres_key=15;
                             break;
                         case 20:
                             progres_key=16;
                             break;
                         case 30:
                             progres_key=17;
                             break;
                         case 40:
                             progres_key=18;
                             break;
                         case 50:
                             progres_key=19;
                             break;
                         case 60:
                             progres_key=20;
                             break;
                         case 70:
                             progres_key=21;
                             break;
                         case 80:
                             progres_key=22;
                             break;
                         case 90:
                             progres_key=23;
                             break;
                     }

                     Cursor c5 = null;
                     Cursor c_User_Name = null;
                     //進捗率に応じてテキストを取得する。
                     String sql5 = "SELECT * FROM words WHERE switch = " + progres_key + ";";
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
                     words_textView.setText(result);
                     //words_textView.setText(String.format("%s", c5.getString(2)));
                     c_User_Name.close();
                 }
             });
             //進捗率を変更した際の台詞
             Intent intent = getIntent();
             int seekInt = intent.getIntExtra("seekInt",0);
             //seekintを変換
             switch (seekInt) {
                 case 0:
                     seekInt = 4;
                     break;
                 case 10:
                     seekInt = 5;
                     break;
                 case 20:
                     seekInt = 6;
                     break;
                 case 30:
                     seekInt = 7;
                     break;
                 case 40:
                     seekInt = 8;
                     break;
                 case 50:
                     seekInt = 9;
                     break;
                 case 60:
                     seekInt = 10;
                     break;
                 case 70:
                     seekInt = 11;
                     break;
                 case 80:
                     seekInt = 12;
                     break;
                 case 90:
                     seekInt = 13;
                     break;
             }

             Cursor c_progres = null;
             Cursor c_User_Name = null;
             //進捗率に応じてテキストを取得する。
             String sql_progres = "SELECT * FROM words WHERE switch = " + seekInt + ";";
             c_progres = db.rawQuery(sql_progres, new String[]{});
             //設定しているユーザー名を取得する。
             String sql_User_Name = "SELECT * FROM user ;";
             c_User_Name = db.rawQuery(sql_User_Name, new String[]{});
             boolean mov5 = c_progres.moveToFirst();
             boolean mov_User = c_User_Name.moveToFirst();

             String str = c_progres.getString(2);
             String regex = "name";

             Pattern p = Pattern.compile(regex);

             Matcher m = p.matcher(str);

             String result = m.replaceAll(c_User_Name.getString(1));
             words_textView.setText(result);
             //words_textView.setText(String.format("%s", c5.getString(2)));
             c_User_Name.close();


         }
         else {
            break;
         }
        }
        c3.close();


        //起動後のテキスト表示 1/9 プロト完成

        TextView words_textView =findViewById(R.id.words_textView);
        ram=(int)(Math.random()*3)+26;
        //乱数生成確認
        Log.d("Ram","変数 ram は「" + ram + "」");
        Cursor c_Ramdom = null;
        Cursor c_User_Name = null;
        //乱数に応じてテキストを取得する。
        String sql_ram = "SELECT * FROM words WHERE switch = " + ram + ";";
        c_Ramdom = db.rawQuery(sql_ram, new String[]{});
        //設定しているユーザー名を取得する。
        String sql_User_Name = "SELECT * FROM user ;";
        c_User_Name = db.rawQuery(sql_User_Name, new String[]{});
        boolean mov_Ram = c_Ramdom.moveToFirst();
        boolean mov_User = c_User_Name.moveToFirst();

        String str = c_Ramdom.getString(2);
        String regex = "name";

        Pattern p = Pattern.compile(regex);

        Matcher m = p.matcher(str);

        String result = m.replaceAll(c_User_Name.getString(1));
        words_textView.setText(result);
        c_User_Name.close();




        //TODO:12/12
        //生成したボタンの動き（遷移）
        //画像の入れ替え
        //テキストビューとボタンのレイアウト

        //dbチェックボタン
        Button checkButton = (Button)findViewById(R.id.checkButton);
        checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent dbIntent = new Intent(MainActivity.this,
                        Debug.class);

                startActivity(dbIntent);
            }
        });


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }




    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();


        if (id == R.id.nav_camera) {
            // Handle the camera action
            //遷移するためのインテント作成
            Intent a = new Intent(this, com.example.a140438.todo3.AddActivity.class);
            //アクティビティ起動
            startActivity(a);
        } else if (id == R.id.nav_gallery) {
            Intent b = new Intent(this, com.example.a140438.todo3.HistoryActivity.class);
            startActivity(b);
        } else if (id == R.id.nav_slideshow) {
            Intent c = new Intent(this, com.example.a140438.todo3.UserActivity.class);
            startActivity(c);
        } else if (id == R.id.nav_manage) {
            Intent d = new Intent(this, com.example.a140438.todo3.ImageActivity.class);
            startActivity(d);
        } /*else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }*/

        /*メニューバーのヘッダー部分の実装*/
        //naivigationMenuの各メニューがタップされた場合のリスナーを指定する

        //メニュー：今日の日付をリアルタイムで取得する。

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    /**
     * 現在日時をyyyy/MM/dd HH:mm:ss形式で取得する.<br>
     */
    public static String getNowDate(){
        final DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        final Date date = new Date(System.currentTimeMillis());
        return df.format(date);
    }

    //進捗を変更した場合の処理の理想
    protected void onActivityResult(int requestCode , int RESULT_OK , Intent dbIntent_update){
        if(RESULT_OK!=0) {
            TextView words_textView = findViewById(R.id.words_textView);
            //SQLite
            OpenHelper helper = new OpenHelper(this);
            final SQLiteDatabase db = helper.getWritableDatabase();

            super.onActivityResult(requestCode, RESULT_OK, dbIntent_update);
            Log.d("RESULT", "変数 RESULT_OK は「" + RESULT_OK + "」");
            //Intent intent = getIntent();
            int seekInt = dbIntent_update.getIntExtra("seekInt", 0);
            //seekintを変換
            switch (seekInt) {
                case 0:
                    seekInt = 4;
                    break;
                case 10:
                    seekInt = 5;
                    break;
                case 20:
                    seekInt = 6;
                    break;
                case 30:
                    seekInt = 7;
                    break;
                case 40:
                    seekInt = 8;
                    break;
                case 50:
                    seekInt = 9;
                    break;
                case 60:
                    seekInt = 10;
                    break;
                case 70:
                    seekInt = 11;
                    break;
                case 80:
                    seekInt = 12;
                    break;
                case 90:
                    seekInt = 13;
                    break;
            }

            Cursor c_progres = null;
            Cursor c_User_Name = null;
            //進捗率に応じてテキストを取得する。
            String sql_progres = "SELECT * FROM words WHERE switch = " + seekInt + ";";
            c_progres = db.rawQuery(sql_progres, new String[]{});
            //設定しているユーザー名を取得する。
            String sql_User_Name = "SELECT * FROM user ;";
            c_User_Name = db.rawQuery(sql_User_Name, new String[]{});
            boolean mov5 = c_progres.moveToFirst();
            boolean mov_User = c_User_Name.moveToFirst();

            String str = c_progres.getString(2);
            String regex = "name";

            Pattern p = Pattern.compile(regex);

            Matcher m = p.matcher(str);

            String result = m.replaceAll(c_User_Name.getString(1));
            words_textView.setText(result);
            //words_textView.setText(String.format("%s", c5.getString(2)));
            c_User_Name.close();
        }

        }


    }


package com.example.a140438.todo3;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
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

import android.widget.Button;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private static final String TAG = MainActivity.class.getSimpleName();

    private boolean flag = false;
    private float scale;
    private Button button[] = new Button[10];
    private TextView g_View[] = new TextView[10];
    private LinearLayout linearLayout [] = new LinearLayout[10];


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




//        setContentView(R.layout.content_main);
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
        //12/8


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

//        //横レイアウト
//        LinearLayout layout2 = new LinearLayout(MainActivity.this);
//        layout2.setOrientation(LinearLayout.HORIZONTAL);
//        layout2.setLayoutParams(
//                new LinearLayout.LayoutParams(
//                        LinearLayout.LayoutParams.WRAP_CONTENT,    //文字列の幅に合わせる
//                        LinearLayout.LayoutParams.WRAP_CONTENT));  //文字列の高さに合わせる


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
//        // ボタンの設定
            Button button1 = new Button(this);
            button1.setText("…");
            //id生成
            //int Buttonid = View.generateViewId();
            //idセット
            //button1.setId(Buttonid);



        LinearLayout.LayoutParams buttonLayoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);


        // TODO:relactive一時退避
        // relative.addView(button);

        //横レイアウトへ追加
       //layout2.addView(button1);
        //縦レイアウトへ横レイアウトを追加
        //layout.addView(layout2);

        //レイアウトの整列
        // TODO:relactive一時退避
//        relative.setGravity(Gravity.CENTER);
//        setContentView(relative);


        // リスナーをボタンに登録
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // flagがtrueの時
                if (flag) {
                    //上のテキストビューを変更する処理をかけば

                    TextView textView1 =findViewById(R.id.textView7);
                    textView1.setText("テキストが");
                    flag = false;
                }
                // flagがfalseの時
                else {
                    TextView textView2 =findViewById(R.id.textView7);
                    textView2.setText("変わるよ");
                    flag = true;
                }
            }
        });
        //テキスト変更
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // flagがtrueの時
                if (flag) {
                    //上のテキストビューを変更する処理をかけば

                    TextView textView1 =findViewById(R.id.textView7);
                    textView1.setText("テキストが");
                    flag = false;
                }
                // flagがfalseの時
                else {
                    TextView textView2 =findViewById(R.id.textView7);
                    textView2.setText("変わるよ");
                    flag = true;
                }
            }
        });
        //ボタンリスナ生成カウンタ初期化
        int y = 0;


        Cursor c2 = null;
        //select
        String sql2 = "SELECT goal_name FROM goal;";
        c2 = db.rawQuery(sql2, new String[]{});

        boolean mov2 = c2.moveToFirst();


        //動的ボタン生成部分
        for(int i = 1 ; i < button.length ; i++) {
         if(mov2) {

             y++;
             button[i] = new Button(this);
             g_View[i] = new TextView(this);
             linearLayout[i] = new LinearLayout(MainActivity.this);

             //ボタンid
             int Buttonid = View.generateViewId();
             //idセット
             button[i].setId(Buttonid);

             // Tagを設定する
             button[i].setTag(String.valueOf(i));
             button[i].setText(String.format(Locale.US, "…", i));
             g_View[i].setTag(String.valueOf(i));
             //g_View[i].setText(String.format(Locale.US, "%d.", i));
             //TextView textView7 = findViewById(R.id.textView7);
             g_View[i].setText(String.format("%d.%s", i, c2.getString(0)));
             mov2 = c2.moveToNext();

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


             // Listnerをセット
//            button[i].setOnClickListener(new View.OnClickListener() {
//                public void onClick(View view) {
//                    // View からTagを取り出す
//                    textView.setText(String.format(Locale.US,
//                            "Button: %s", view.getTag().toString()));
//                }
//            });
             button[i].setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {
                     Intent intent = new Intent(getApplication(), UpdateActivity.class);
                     startActivity(intent);
                 }
             });
         }
         else {
            break;
         }
        }

//        //目標名表示
//
//        Cursor c2 = null;
//        //select
//        String sql2 = "SELECT goal_name FROM goal;";
//        c2 = db.rawQuery(sql2, new String[]{});
//
//        boolean mov2 = c2.moveToFirst();
//
//        while(mov2){
//            TextView textView7 = findViewById(R.id.textView7);
//            textView7.setText(String.format("目標名 : %s", c2.getString(0)));
//            mov2 = c2.moveToNext();
//            //layout.addView(textView);
//        }

        c2.close();
        db.close();



        //TODO:12/12
        //生成したボタンの動き（遷移）
        //画像の入れ替え
        //テキストビューとボタンのレイアウト


        // TODO:scrollView一時退避
        //scrollView.addView(relative);

        //S



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

}
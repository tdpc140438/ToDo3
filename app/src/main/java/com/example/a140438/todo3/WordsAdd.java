package com.example.a140438.todo3;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by 140154 on 2018/01/19.
 */

public class WordsAdd extends Activity {
    String err_msg = "";
    boolean error_check = false;
    boolean c0,c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15,
            c16,c17,c18,c19,c20,c21,c22,c23,c24,c25,c26,c27,c28,c29;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.words_add);

        //DBの使用宣言
        OpenHelper helper = new OpenHelper(this);
        final SQLiteDatabase db = helper.getWritableDatabase();

        final EditText add_package_id = (EditText)findViewById(R.id.add_package_id);
        final EditText add_package_name = (EditText)findViewById(R.id.add_package_name);
        final EditText add_CHAR_A = (EditText)findViewById(R.id.add_CHAR_A);
        final EditText add_CHAR_B = (EditText)findViewById(R.id.add_CHAR_B);
        final EditText add_CHAR_C = (EditText)findViewById(R.id.add_CHAR_C);
        final EditText add_PER0 = (EditText)findViewById(R.id.add_PER0);
        final EditText add_PER10 = (EditText)findViewById(R.id.add_PER10);
        final EditText add_PER20 = (EditText)findViewById(R.id.add_PER20);
        final EditText add_PER30 = (EditText)findViewById(R.id.add_PER30);
        final EditText add_PER40 = (EditText)findViewById(R.id.add_PER40);
        final EditText add_PER50 = (EditText)findViewById(R.id.add_PER50);
        final EditText add_PER60 = (EditText)findViewById(R.id.add_PER60);
        final EditText add_PER70 = (EditText)findViewById(R.id.add_PER70);
        final EditText add_PER80 = (EditText)findViewById(R.id.add_PER80);
        final EditText add_PER90 = (EditText)findViewById(R.id.add_PER90);
        final EditText add_GOAL_PER0 = (EditText)findViewById(R.id.add_GOAL_PER0);
        final EditText add_GOAL_PER10 = (EditText)findViewById(R.id.add_GOAL_PER10);
        final EditText add_GOAL_PER20 = (EditText)findViewById(R.id.add_GOAL_PER20);
        final EditText add_GOAL_PER30 = (EditText)findViewById(R.id.add_GOAL_PER30);
        final EditText add_GOAL_PER40 = (EditText)findViewById(R.id.add_GOAL_PER40);
        final EditText add_GOAL_PER50 = (EditText)findViewById(R.id.add_GOAL_PER50);
        final EditText add_GOAL_PER60 = (EditText)findViewById(R.id.add_GOAL_PER60);
        final EditText add_GOAL_PER70 = (EditText)findViewById(R.id.add_GOAL_PER70);
        final EditText add_GOAL_PER80 = (EditText)findViewById(R.id.add_GOAL_PER80);
        final EditText add_GOAL_PER90 = (EditText)findViewById(R.id.add_GOAL_PER90);
        final EditText add_SUCC = (EditText)findViewById(R.id.add_SUCC);
        final EditText add_FAIL = (EditText)findViewById(R.id.add_FAIL);
        final EditText add_NORM_A = (EditText)findViewById(R.id.add_NORM_A);
        final EditText add_NORM_B = (EditText)findViewById(R.id.add_NORM_B);
        final EditText add_NORM_C = (EditText)findViewById(R.id.add_NORM_C);


        Button words_add_button = (Button)findViewById(R.id.words_add_button);
        words_add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Intent dbIntent = new Intent(WordsAdd.this,
                        MainActivity.class);

                final String package_add = "INSERT INTO package(package_id, package_name, unlock)" +
                        "VALUES('" + add_package_id.getText().toString() +"', '" + add_package_name.getText().toString() + "', 1);";

                final String CHAR_A_add = "INSERT INTO words(words_id, package_id, words_text, switch)" +
                        "VALUES('" + add_package_id.getText().toString() + "_CHAR_A', '" + add_package_id.getText().toString() + "', '" + add_CHAR_A.getText().toString() + "', 1)";
                final String CHAR_B_add = "INSERT INTO words(words_id, package_id, words_text, switch)" +
                        "VALUES('" + add_package_id.getText().toString() + "_CHAR_B', '" + add_package_id.getText().toString() + "', '" + add_CHAR_B.getText().toString() + "', 2)";
                final String CHAR_C_add = "INSERT INTO words(words_id, package_id, words_text, switch)" +
                        "VALUES('" + add_package_id.getText().toString() + "_CHAR_C', '" + add_package_id.getText().toString() + "', '" + add_CHAR_C.getText().toString() + "', 3)";
                final String PER0_add = "INSERT INTO words(words_id, package_id, words_text, switch)" +
                        "VALUES('PER0', '" + add_package_id.getText().toString() + "', '" + add_PER0.getText().toString() + "', 4)";
                final String PER10_add = "INSERT INTO words(words_id, package_id, words_text, switch)" +
                        "VALUES('PER10', '" + add_package_id.getText().toString() + "', '" + add_PER10.getText().toString() + "', 5)";
                final String PER20_add = "INSERT INTO words(words_id, package_id, words_text, switch)" +
                        "VALUES('PER20', '" + add_package_id.getText().toString() + "', '" + add_PER20.getText().toString() + "', 6)";
                final String PER30_add = "INSERT INTO words(words_id, package_id, words_text, switch)" +
                        "VALUES('PER30', '" + add_package_id.getText().toString() + "', '" + add_PER30.getText().toString() + "', 7)";
                final String PER40_add = "INSERT INTO words(words_id, package_id, words_text, switch)" +
                        "VALUES('PER40', '" + add_package_id.getText().toString() + "', '" + add_PER40.getText().toString() + "', 8)";
                final String PER50_add = "INSERT INTO words(words_id, package_id, words_text, switch)" +
                        "VALUES('PER50', '" + add_package_id.getText().toString() + "', '" + add_PER50.getText().toString() + "', 9)";
                final String PER60_add = "INSERT INTO words(words_id, package_id, words_text, switch)" +
                        "VALUES('PER60', '" + add_package_id.getText().toString() + "', '" + add_PER60.getText().toString() + "', 10)";
                final String PER70_add = "INSERT INTO words(words_id, package_id, words_text, switch)" +
                        "VALUES('PER70', '" + add_package_id.getText().toString() + "', '" + add_PER70.getText().toString() + "', 11)";
                final String PER80_add = "INSERT INTO words(words_id, package_id, words_text, switch)" +
                        "VALUES('PER80', '" + add_package_id.getText().toString() + "', '" + add_PER80.getText().toString() + "', 12)";
                final String PER90_add = "INSERT INTO words(words_id, package_id, words_text, switch)" +
                        "VALUES('PER90', '" + add_package_id.getText().toString() + "', '" + add_PER90.getText().toString() + "', 13)";

                final String PER0_GOAL_add = "INSERT INTO words(words_id, package_id, words_text, switch)" +
                        "VALUES('" + add_package_id.getText().toString() + "_PER0_GOAL', '" + add_package_id.getText().toString() + "', '" + add_GOAL_PER0.getText().toString() + "', 14)";
                final String PER10_GOAL_add = "INSERT INTO words(words_id, package_id, words_text, switch)" +
                        "VALUES('" + add_package_id.getText().toString() + "_PER10_GOAL', '" + add_package_id.getText().toString() + "', '" + add_GOAL_PER10.getText().toString() + "', 15)";
                final String PER20_GOAL_add = "INSERT INTO words(words_id, package_id, words_text, switch)" +
                        "VALUES('" + add_package_id.getText().toString() + "_PER20_GOAL', '" + add_package_id.getText().toString() + "', '" + add_GOAL_PER20.getText().toString() + "', 16)";
                final String PER30_GOAL_add = "INSERT INTO words(words_id, package_id, words_text, switch)" +
                        "VALUES('" + add_package_id.getText().toString() + "_PER30_GOAL', '" + add_package_id.getText().toString() + "', '" + add_GOAL_PER30.getText().toString() + "', 17)";
                final String PER40_GOAL_add = "INSERT INTO words(words_id, package_id, words_text, switch)" +
                        "VALUES('" + add_package_id.getText().toString() + "_PER40_GOAL', '" + add_package_id.getText().toString() + "', '" + add_GOAL_PER40.getText().toString() + "', 18)";
                final String PER50_GOAL_add = "INSERT INTO words(words_id, package_id, words_text, switch)" +
                        "VALUES('" + add_package_id.getText().toString() + "_PER50_GOAL', '" + add_package_id.getText().toString() + "', '" + add_GOAL_PER50.getText().toString() + "', 19)";
                final String PER60_GOAL_add = "INSERT INTO words(words_id, package_id, words_text, switch)" +
                        "VALUES('" + add_package_id.getText().toString() + "_PER60_GOAL', '" + add_package_id.getText().toString() + "', '" + add_GOAL_PER60.getText().toString() + "', 20)";
                final String PER70_GOAL_add = "INSERT INTO words(words_id, package_id, words_text, switch)" +
                        "VALUES('" + add_package_id.getText().toString() + "_PER70_GOAL', '" + add_package_id.getText().toString() + "', '" + add_GOAL_PER70.getText().toString() + "', 21)";
                final String PER80_GOAL_add = "INSERT INTO words(words_id, package_id, words_text, switch)" +
                        "VALUES('" + add_package_id.getText().toString() + "_PER80_GOAL', '" + add_package_id.getText().toString() + "', '" + add_GOAL_PER80.getText().toString() + "', 22)";
                final String PER90_GOAL_add = "INSERT INTO words(words_id, package_id, words_text, switch)" +
                        "VALUES('" + add_package_id.getText().toString() + "_PER90_GOAL', '" + add_package_id.getText().toString() + "', '" + add_GOAL_PER90.getText().toString() + "', 23)";
                final String SUCC_add = "INSERT INTO words(words_id, package_id, words_text, switch)" +
                        "VALUES('" + add_package_id.getText().toString() + "_SUCC', '" + add_package_id.getText().toString() + "', '" + add_SUCC.getText().toString() + "', 24)";
                final String FAIL_add = "INSERT INTO words(words_id, package_id, words_text, switch)" +
                        "VALUES('" + add_package_id.getText().toString() + "_FAIL', '" + add_package_id.getText().toString() + "', '" + add_FAIL.getText().toString() + "', 25)";
                final String NORM_A_add = "INSERT INTO words(words_id, package_id, words_text, switch)" +
                        "VALUES('" + add_package_id.getText().toString() + "_NORM_A', '" + add_package_id.getText().toString() + "', '" + add_NORM_A.getText().toString() + "', 26)";
                final String NORM_B_add = "INSERT INTO words(words_id, package_id, words_text, switch)" +
                        "VALUES('" + add_package_id.getText().toString() + "_NORM_B', '" + add_package_id.getText().toString() + "', '" + add_NORM_B.getText().toString() + "', 27)";
                final String NORM_C_add = "INSERT INTO words(words_id, package_id, words_text, switch)" +
                        "VALUES('" + add_package_id.getText().toString() + "_NORM_C', '" + add_package_id.getText().toString() + "', '" + add_NORM_C.getText().toString() + "', 28)";

                /*
                Log.d("SQL", "SQL1 : " + package_add);
                Log.d("SQL", "SQL2 : " + CHAR_A_add);
                Log.d("SQL", "SQL3 : " + CHAR_B_add);
                Log.d("SQL", "SQL4 : " + CHAR_C_add);
                Log.d("SQL", "SQL5 : " + PER0_add);
                Log.d("SQL", "SQL6 : " + PER10_add);
                Log.d("SQL", "SQL7 : " + PER20_add);
                Log.d("SQL", "SQL8 : " + PER30_add);
                Log.d("SQL", "SQL9 : " + PER40_add);
                Log.d("SQL", "SQL10 : " + PER50_add);
                Log.d("SQL", "SQL11 : " + PER60_add);
                Log.d("SQL", "SQL12 : " + PER70_add);
                Log.d("SQL", "SQL13 : " + PER80_add);
                Log.d("SQL", "SQL14 : " + PER90_add);
                Log.d("SQL", "SQL15 : " + PER0_GOAL_add);
                Log.d("SQL", "SQL16 : " + PER10_GOAL_add);
                Log.d("SQL", "SQL17 : " + PER20_GOAL_add);
                Log.d("SQL", "SQL18 : " + PER30_GOAL_add);
                Log.d("SQL", "SQL19 : " + PER40_GOAL_add);
                Log.d("SQL", "SQL20 : " + PER50_GOAL_add);
                Log.d("SQL", "SQL21 : " + PER60_GOAL_add);
                Log.d("SQL", "SQL22 : " + PER70_GOAL_add);
                Log.d("SQL", "SQL23 : " + PER80_GOAL_add);
                Log.d("SQL", "SQL24 : " + PER90_GOAL_add);
                Log.d("SQL", "SQL25 : " + SUCC_add);
                Log.d("SQL", "SQL26 : " + FAIL_add);
                Log.d("SQL", "SQL27 : " + NORM_A_add);
                Log.d("SQL", "SQL28 : " + NORM_B_add);
                Log.d("SQL", "SQL29 : " + NORM_C_add);
                */

                if(add_package_id.getText().toString().equals("") || add_package_id.getText().toString().equals(null)){
                    c0 = true;
                    err_msg = err_msg + "パッケージＩＤ" + "\n";
                    error_check = true;
                }

                if(add_package_name.getText().toString().equals("") || add_package_name.getText().toString().equals(null)){
                    c1 = true;
                    err_msg = err_msg + "パッケージ名" + "\n";
                    error_check = true;
                }

                if(add_CHAR_A.getText().toString().equals("") || add_CHAR_A.getText().toString().equals(null)){
                    c2 = true;
                    err_msg = err_msg + "キャラクタータッチ台詞Ａ" + "\n";
                    error_check = true;
                }

                if(add_CHAR_B.getText().toString().equals("") || add_CHAR_B.getText().toString().equals(null)){
                    c3 = true;
                    err_msg = err_msg + "キャラクタータッチ台詞Ｂ" + "\n";
                    error_check = true;
                }

                if(add_CHAR_C.getText().toString().equals("") || add_CHAR_C.getText().toString().equals(null)){
                    c4 = true;
                    err_msg = err_msg + "キャラクタータッチ台詞Ｃ" + "\n";
                    error_check = true;
                }

                if(add_PER0.getText().toString().equals("") || add_PER0.getText().toString().equals(null)){
                    c5 = true;
                    err_msg = err_msg + "進捗率０％" + "\n";
                    error_check = true;
                }

                if(add_PER10.getText().toString().equals("") || add_PER10.getText().toString().equals(null)){
                    c6 = true;
                    err_msg = err_msg + "進捗率１０％" + "\n";
                    error_check = true;
                }

                if(add_PER20.getText().toString().equals("") || add_PER20.getText().toString().equals(null)){
                    c7 = true;
                    err_msg = err_msg + "進捗率２０％" + "\n";
                    error_check = true;
                }

                if(add_PER30.getText().toString().equals("") || add_PER30.getText().toString().equals(null)){
                    c8 = true;
                    err_msg = err_msg + "進捗率３０％" + "\n";
                    error_check = true;
                }

                if(add_PER40.getText().toString().equals("") || add_PER40.getText().toString().equals(null)){
                    c9 = true;
                    err_msg = err_msg + "進捗率４０％" + "\n";
                    error_check = true;
                }

                if(add_PER50.getText().toString().equals("") || add_PER50.getText().toString().equals(null)){
                    c10 = true;
                    err_msg = err_msg + "進捗率５０％" + "\n";
                    error_check = true;
                }

                if(add_PER60.getText().toString().equals("") || add_PER60.getText().toString().equals(null)){
                    c11 = true;
                    err_msg = err_msg + "進捗率６０％" + "\n";
                    error_check = true;
                }

                if(add_PER70.getText().toString().equals("") || add_PER70.getText().toString().equals(null)){
                    c12 = true;
                    err_msg = err_msg + "進捗率７０％" + "\n";
                    error_check = true;
                }

                if(add_PER80.getText().toString().equals("") || add_PER80.getText().toString().equals(null)){
                    c13 = true;
                    err_msg = err_msg + "進捗率８０％" + "\n";
                    error_check = true;
                }

                if(add_PER90.getText().toString().equals("") || add_PER90.getText().toString().equals(null)){
                    c14 = true;
                    err_msg = err_msg + "進捗率９０％" + "\n";
                    error_check = true;
                }

                if(add_GOAL_PER0.getText().toString().equals("") || add_GOAL_PER0.getText().toString().equals(null)){
                    c15 = true;
                    err_msg = err_msg + "進捗率０％(目標タップ時)" + "\n";
                    error_check = true;
                }

                if(add_GOAL_PER10.getText().toString().equals("") || add_GOAL_PER10.getText().toString().equals(null)){
                    c16 = true;
                    err_msg = err_msg + "進捗率１０％(目標タップ時)" + "\n";
                    error_check = true;
                }

                if(add_GOAL_PER20.getText().toString().equals("") || add_GOAL_PER20.getText().toString().equals(null)){
                    c17 = true;
                    err_msg = err_msg + "進捗率２０％(目標タップ時)" + "\n";
                    error_check = true;
                }

                if(add_GOAL_PER30.getText().toString().equals("") || add_GOAL_PER30.getText().toString().equals(null)){
                    c18 = true;
                    err_msg = err_msg + "進捗率３０％(目標タップ時)" + "\n";
                    error_check = true;
                }

                if(add_GOAL_PER40.getText().toString().equals("") || add_GOAL_PER40.getText().toString().equals(null)){
                    c19 = true;
                    err_msg = err_msg + "進捗率４０％(目標タップ時)" + "\n";
                    error_check = true;
                }

                if(add_GOAL_PER50.getText().toString().equals("") || add_GOAL_PER50.getText().toString().equals(null)){
                    c20 = true;
                    err_msg = err_msg + "進捗率５０％(目標タップ時)" + "\n";
                    error_check = true;
                }

                if(add_GOAL_PER60.getText().toString().equals("") || add_GOAL_PER60.getText().toString().equals(null)){
                    c21 = true;
                    err_msg = err_msg + "進捗率６０％(目標タップ時)" + "\n";
                    error_check = true;
                }

                if(add_GOAL_PER70.getText().toString().equals("") || add_GOAL_PER70.getText().toString().equals(null)){
                    c22 = true;
                    err_msg = err_msg + "進捗率７０％(目標タップ時)" + "\n";
                    error_check = true;
                }

                if(add_GOAL_PER80.getText().toString().equals("") || add_GOAL_PER80.getText().toString().equals(null)){
                    c23 = true;
                    err_msg = err_msg + "進捗率８０％(目標タップ時)" + "\n";
                    error_check = true;
                }

                if(add_GOAL_PER90.getText().toString().equals("") || add_GOAL_PER90.getText().toString().equals(null)){
                    c24 = true;
                    err_msg = err_msg + "進捗率９０％(目標タップ時)" + "\n";
                    error_check = true;
                }

                if(add_SUCC.getText().toString().equals("") || add_SUCC.getText().toString().equals(null)){
                    c25 = true;
                    err_msg = err_msg + "目標達成成功(進捗率１００％)" + "\n";
                    error_check = true;
                }

                if(add_FAIL.getText().toString().equals("") || add_FAIL.getText().toString().equals(null)){
                    c26 = true;
                    err_msg = err_msg + "目標達成失敗" + "\n";
                    error_check = true;
                }

                if(add_NORM_A.getText().toString().equals("") || add_NORM_A.getText().toString().equals(null)){
                    c27 = true;
                    err_msg = err_msg + "汎用台詞Ａ" + "\n";
                    error_check = true;
                }

                if(add_NORM_B.getText().toString().equals("") || add_NORM_B.getText().toString().equals(null)){
                    c28 = true;
                    err_msg = err_msg + "汎用台詞Ｂ" + "\n";
                    error_check = true;
                }

                if(add_NORM_C.getText().toString().equals("") || add_NORM_C.getText().toString().equals(null)){
                    c29 = true;
                    err_msg = err_msg + "汎用台詞Ｃ" + "\n";
                    error_check = true;
                }

                Log.d("Error", "error_check : " + error_check);

                if(error_check){
                    new AlertDialog.Builder(WordsAdd.this)
                            .setTitle("入力エラー")
                            .setMessage("以下の項目が未入力です。\n \n=====================\n \n" + err_msg)
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    err_msg = "";
                                    error_check = false;
                                }
                            })
                            .show();
                }
                else{
                    new AlertDialog.Builder(WordsAdd.this)
                            .setTitle("言語パック登録確認")
                            .setMessage("言語パック" + add_package_name.getText().toString() + "を登録します。よろしいですか？")
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    db.execSQL(package_add);
                                    db.execSQL(CHAR_A_add);
                                    db.execSQL(CHAR_B_add);
                                    db.execSQL(CHAR_C_add);
                                    db.execSQL(PER0_add);
                                    db.execSQL(PER10_add);
                                    db.execSQL(PER20_add);
                                    db.execSQL(PER30_add);
                                    db.execSQL(PER40_add);
                                    db.execSQL(PER50_add);
                                    db.execSQL(PER60_add);
                                    db.execSQL(PER70_add);
                                    db.execSQL(PER80_add);
                                    db.execSQL(PER90_add);
                                    db.execSQL(PER0_GOAL_add);
                                    db.execSQL(PER10_GOAL_add);
                                    db.execSQL(PER20_GOAL_add);
                                    db.execSQL(PER30_GOAL_add);
                                    db.execSQL(PER40_GOAL_add);
                                    db.execSQL(PER50_GOAL_add);
                                    db.execSQL(PER60_GOAL_add);
                                    db.execSQL(PER70_GOAL_add);
                                    db.execSQL(PER80_GOAL_add);
                                    db.execSQL(PER90_GOAL_add);
                                    db.execSQL(SUCC_add);
                                    db.execSQL(FAIL_add);
                                    db.execSQL(NORM_A_add);
                                    db.execSQL(NORM_B_add);
                                    db.execSQL(NORM_C_add);

                                    startActivity(dbIntent);
                                }
                            })
                            .setNegativeButton("Cancel", null)
                            .show();
                }
            }
        });
    }
}

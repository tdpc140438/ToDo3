package com.example.a140438.todo3;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by 140154 on 2018/01/19.
 */

public class WordsAdd extends Activity {

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
                Intent dbIntent = new Intent(WordsAdd.this,
                        MainActivity.class);

                String package_add = "INSERT INTO package(package_id, package_name, unlock)" +
                        "VALUES('" + add_package_id.getText().toString() +"', '" + add_package_name.getText().toString() + "', 1);";

                String CHAR_A_add = "INSERT INTO words(words_id, package_id, words_text, switch)" +
                        "VALUES('" + add_package_id.getText().toString() + "_CHAR_A', '" + add_package_id.getText().toString() + "', '" + add_CHAR_A.getText().toString() + "', 1)";
                String CHAR_B_add = "INSERT INTO words(words_id, package_id, words_text, switch)" +
                        "VALUES('" + add_package_id.getText().toString() + "_CHAR_B', '" + add_package_id.getText().toString() + "', '" + add_CHAR_B.getText().toString() + "', 2)";
                String CHAR_C_add = "INSERT INTO words(words_id, package_id, words_text, switch)" +
                        "VALUES('" + add_package_id.getText().toString() + "_CHAR_C', '" + add_package_id.getText().toString() + "', '" + add_CHAR_C.getText().toString() + "', 3)";
                String PER0_add = "INSERT INTO words(words_id, package_id, words_text, switch)" +
                        "VALUES('PER0', '" + add_package_id.getText().toString() + "', '" + add_PER0.getText().toString() + "', 4)";
                String PER10_add = "INSERT INTO words(words_id, package_id, words_text, switch)" +
                        "VALUES('PER10', '" + add_package_id.getText().toString() + "', '" + add_PER10.getText().toString() + "', 5)";
                String PER20_add = "INSERT INTO words(words_id, package_id, words_text, switch)" +
                        "VALUES('PER20', '" + add_package_id.getText().toString() + "', '" + add_PER20.getText().toString() + "', 6)";
                String PER30_add = "INSERT INTO words(words_id, package_id, words_text, switch)" +
                        "VALUES('PER30', '" + add_package_id.getText().toString() + "', '" + add_PER30.getText().toString() + "', 7)";
                String PER40_add = "INSERT INTO words(words_id, package_id, words_text, switch)" +
                        "VALUES('PER40', '" + add_package_id.getText().toString() + "', '" + add_PER40.getText().toString() + "', 8)";
                String PER50_add = "INSERT INTO words(words_id, package_id, words_text, switch)" +
                        "VALUES('PER50', '" + add_package_id.getText().toString() + "', '" + add_PER50.getText().toString() + "', 9)";
                String PER60_add = "INSERT INTO words(words_id, package_id, words_text, switch)" +
                        "VALUES('PER60', '" + add_package_id.getText().toString() + "', '" + add_PER60.getText().toString() + "', 10)";
                String PER70_add = "INSERT INTO words(words_id, package_id, words_text, switch)" +
                        "VALUES('PER70', '" + add_package_id.getText().toString() + "', '" + add_PER70.getText().toString() + "', 11)";
                String PER80_add = "INSERT INTO words(words_id, package_id, words_text, switch)" +
                        "VALUES('PER80', '" + add_package_id.getText().toString() + "', '" + add_PER80.getText().toString() + "', 12)";
                String PER90_add = "INSERT INTO words(words_id, package_id, words_text, switch)" +
                        "VALUES('PER90', '" + add_package_id.getText().toString() + "', '" + add_PER90.getText().toString() + "', 13)";

                String PER0_GOAL_add = "INSERT INTO words(words_id, package_id, words_text, switch)" +
                        "VALUES('" + add_package_id.getText().toString() + "_PER0_GOAL', '" + add_package_id.getText().toString() + "', '" + add_GOAL_PER0.getText().toString() + "', 14)";
                String PER10_GOAL_add = "INSERT INTO words(words_id, package_id, words_text, switch)" +
                        "VALUES('" + add_package_id.getText().toString() + "_PER10_GOAL', '" + add_package_id.getText().toString() + "', '" + add_GOAL_PER10.getText().toString() + "', 15)";
                String PER20_GOAL_add = "INSERT INTO words(words_id, package_id, words_text, switch)" +
                        "VALUES('" + add_package_id.getText().toString() + "_PER20_GOAL', '" + add_package_id.getText().toString() + "', '" + add_GOAL_PER20.getText().toString() + "', 16)";
                String PER30_GOAL_add = "INSERT INTO words(words_id, package_id, words_text, switch)" +
                        "VALUES('" + add_package_id.getText().toString() + "_PER30_GOAL', '" + add_package_id.getText().toString() + "', '" + add_GOAL_PER30.getText().toString() + "', 17)";
                String PER40_GOAL_add = "INSERT INTO words(words_id, package_id, words_text, switch)" +
                        "VALUES('" + add_package_id.getText().toString() + "_PER40_GOAL', '" + add_package_id.getText().toString() + "', '" + add_GOAL_PER40.getText().toString() + "', 18)";
                String PER50_GOAL_add = "INSERT INTO words(words_id, package_id, words_text, switch)" +
                        "VALUES('" + add_package_id.getText().toString() + "_PER50_GOAL', '" + add_package_id.getText().toString() + "', '" + add_GOAL_PER50.getText().toString() + "', 19)";
                String PER60_GOAL_add = "INSERT INTO words(words_id, package_id, words_text, switch)" +
                        "VALUES('" + add_package_id.getText().toString() + "_PER60_GOAL', '" + add_package_id.getText().toString() + "', '" + add_GOAL_PER60.getText().toString() + "', 20)";
                String PER70_GOAL_add = "INSERT INTO words(words_id, package_id, words_text, switch)" +
                        "VALUES('" + add_package_id.getText().toString() + "_PER70_GOAL', '" + add_package_id.getText().toString() + "', '" + add_GOAL_PER70.getText().toString() + "', 21)";
                String PER80_GOAL_add = "INSERT INTO words(words_id, package_id, words_text, switch)" +
                        "VALUES('" + add_package_id.getText().toString() + "_PER80_GOAL', '" + add_package_id.getText().toString() + "', '" + add_GOAL_PER80.getText().toString() + "', 22)";
                String PER90_GOAL_add = "INSERT INTO words(words_id, package_id, words_text, switch)" +
                        "VALUES('" + add_package_id.getText().toString() + "_PER90_GOAL', '" + add_package_id.getText().toString() + "', '" + add_GOAL_PER90.getText().toString() + "', 23)";
                String SUCC_add = "INSERT INTO words(words_id, package_id, words_text, switch)" +
                        "VALUES('" + add_package_id.getText().toString() + "_SUCC', '" + add_package_id.getText().toString() + "', '" + add_SUCC.getText().toString() + "', 24)";
                String FAIL_add = "INSERT INTO words(words_id, package_id, words_text, switch)" +
                        "VALUES('" + add_package_id.getText().toString() + "_FAIL', '" + add_package_id.getText().toString() + "', '" + add_FAIL.getText().toString() + "', 25)";
                String NORM_A_add = "INSERT INTO words(words_id, package_id, words_text, switch)" +
                        "VALUES('" + add_package_id.getText().toString() + "_NORM_A', '" + add_package_id.getText().toString() + "', '" + add_NORM_A.getText().toString() + "', 26)";
                String NORM_B_add = "INSERT INTO words(words_id, package_id, words_text, switch)" +
                        "VALUES('" + add_package_id.getText().toString() + "_NORM_B', '" + add_package_id.getText().toString() + "', '" + add_NORM_B.getText().toString() + "', 27)";
                String NORM_C_add = "INSERT INTO words(words_id, package_id, words_text, switch)" +
                        "VALUES('" + add_package_id.getText().toString() + "_NORM_C', '" + add_package_id.getText().toString() + "', '" + add_NORM_C.getText().toString() + "', 28)";

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

                /*
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
                */
            }
        });
    }
}

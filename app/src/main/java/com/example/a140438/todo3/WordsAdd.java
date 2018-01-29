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
    String new_package_id, new_package_name,
            new_CHAR_A, new_CHAR_B, new_CHAR_C,
            new_PER0, new_PER10, new_PER20, new_PER30, new_PER40,
            new_PER50, new_PER60, new_PER70, new_PER80, new_PER90,
            new_GOAL_PER0, new_GOAL_PER10, new_GOAL_PER20, new_GOAL_PER30, new_GOAL_PER40,
            new_GOAL_PER50, new_GOAL_PER60, new_GOAL_PER70, new_GOAL_PER80, new_GOAL_PER90,
            new_SUCC, new_FAIL, new_NORM_A, new_NORM_B, new_NORM_C;

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

        new_package_id = add_package_id.getText().toString();
        new_package_name = add_package_name.getText().toString();
        new_CHAR_A = add_CHAR_A.getText().toString();
        new_CHAR_B = add_CHAR_B.getText().toString();
        new_CHAR_C = add_CHAR_C.getText().toString();
        new_PER0 = add_PER0.getText().toString();
        new_PER10 = add_PER10.getText().toString();
        new_PER20 = add_PER20.getText().toString();
        new_PER30 = add_PER30.getText().toString();
        new_PER40 = add_PER40.getText().toString();
        new_PER50 = add_PER50.getText().toString();
        new_PER60 = add_PER60.getText().toString();
        new_PER70 = add_PER70.getText().toString();
        new_PER80 = add_PER80.getText().toString();
        new_PER90 = add_PER90.getText().toString();
        new_GOAL_PER0 = add_GOAL_PER0.getText().toString();
        new_GOAL_PER10 = add_GOAL_PER10.getText().toString();
        new_GOAL_PER20 = add_GOAL_PER20.getText().toString();
        new_GOAL_PER30 = add_GOAL_PER30.getText().toString();
        new_GOAL_PER40 = add_GOAL_PER40.getText().toString();
        new_GOAL_PER50 = add_GOAL_PER50.getText().toString();
        new_GOAL_PER60 = add_GOAL_PER60.getText().toString();
        new_GOAL_PER70 = add_GOAL_PER70.getText().toString();
        new_GOAL_PER80 = add_GOAL_PER80.getText().toString();
        new_GOAL_PER90 = add_GOAL_PER90.getText().toString();
        new_SUCC = add_SUCC.getText().toString();
        new_FAIL = add_FAIL.getText().toString();
        new_NORM_A = add_NORM_A.getText().toString();
        new_NORM_B = add_NORM_B.getText().toString();
        new_NORM_C = add_NORM_C.getText().toString();


        Button words_add_button = (Button)findViewById(R.id.words_add_button);
        words_add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent dbIntent = new Intent(WordsAdd.this,
                        MainActivity.class);

                String package_add = "INSERT INTO package(package_id, package_name, unlock)" +
                        "VALUES('" + new_package_id +"', '" + new_package_name + "', 1);";

                String CHAR_A_add = "INSERT INTO words(words_id, package_id, words_text, switch)" +
                        "VALUES('" + new_package_id + "_CHAR_A', '" + new_package_id + "', '" + new_CHAR_A + "', 1)";
                String CHAR_B_add = "INSERT INTO words(words_id, package_id, words_text, switch)" +
                        "VALUES('" + new_package_id + "_CHAR_B', '" + new_package_id + "', '" + new_CHAR_B + "', 2)";
                String CHAR_C_add = "INSERT INTO words(words_id, package_id, words_text, switch)" +
                        "VALUES('" + new_package_id + "_CHAR_C', '" + new_package_id + "', '" + new_CHAR_C + "', 3)";
                String PER0_add = "INSERT INTO words(words_id, package_id, words_text, switch)" +
                        "VALUES('PER0', '" + new_package_id + "', '" + new_PER0 + "', 4)";
                String PER10_add = "INSERT INTO words(words_id, package_id, words_text, switch)" +
                        "VALUES('PER10', '" + new_package_id + "', '" + new_PER10 + "', 5)";
                String PER20_add = "INSERT INTO words(words_id, package_id, words_text, switch)" +
                        "VALUES('PER20', '" + new_package_id + "', '" + new_PER20 + "', 6)";
                String PER30_add = "INSERT INTO words(words_id, package_id, words_text, switch)" +
                        "VALUES('PER30', '" + new_package_id + "', '" + new_PER30 + "', 7)";
                String PER40_add = "INSERT INTO words(words_id, package_id, words_text, switch)" +
                        "VALUES('PER40', '" + new_package_id + "', '" + new_PER40 + "', 8)";
                String PER50_add = "INSERT INTO words(words_id, package_id, words_text, switch)" +
                        "VALUES('PER50', '" + new_package_id + "', '" + new_PER50 + "', 9)";
                String PER60_add = "INSERT INTO words(words_id, package_id, words_text, switch)" +
                        "VALUES('PER60', '" + new_package_id + "', '" + new_PER60 + "', 10)";
                String PER70_add = "INSERT INTO words(words_id, package_id, words_text, switch)" +
                        "VALUES('PER70', '" + new_package_id + "', '" + new_PER70 + "', 11)";
                String PER80_add = "INSERT INTO words(words_id, package_id, words_text, switch)" +
                        "VALUES('PER80', '" + new_package_id + "', '" + new_PER80 + "', 12)";
                String PER90_add = "INSERT INTO words(words_id, package_id, words_text, switch)" +
                        "VALUES('PER90', '" + new_package_id + "', '" + new_PER90 + "', 13)";

                String PER0_GOAL_add = "INSERT INTO words(words_id, package_id, words_text, switch)" +
                        "VALUES('" + new_package_id + "_PER0_GOAL', '" + new_package_id + "', '" + new_GOAL_PER0 + "', 14)";
                String PER10_GOAL_add = "INSERT INTO words(words_id, package_id, words_text, switch)" +
                        "VALUES('" + new_package_id + "_PER10_GOAL', '" + new_package_id + "', '" + new_GOAL_PER10 + "', 15)";
                String PER20_GOAL_add = "INSERT INTO words(words_id, package_id, words_text, switch)" +
                        "VALUES('" + new_package_id + "_PER20_GOAL', '" + new_package_id + "', '" + new_GOAL_PER20 + "', 16)";
                String PER30_GOAL_add = "INSERT INTO words(words_id, package_id, words_text, switch)" +
                        "VALUES('" + new_package_id + "_PER30_GOAL', '" + new_package_id + "', '" + new_GOAL_PER30 + "', 17)";
                String PER40_GOAL_add = "INSERT INTO words(words_id, package_id, words_text, switch)" +
                        "VALUES('" + new_package_id + "_PER40_GOAL', '" + new_package_id + "', '" + new_GOAL_PER40 + "', 18)";
                String PER50_GOAL_add = "INSERT INTO words(words_id, package_id, words_text, switch)" +
                        "VALUES('" + new_package_id + "_PER50_GOAL', '" + new_package_id + "', '" + new_GOAL_PER50 + "', 19)";
                String PER60_GOAL_add = "INSERT INTO words(words_id, package_id, words_text, switch)" +
                        "VALUES('" + new_package_id + "_PER60_GOAL', '" + new_package_id + "', '" + new_GOAL_PER60 + "', 20)";
                String PER70_GOAL_add = "INSERT INTO words(words_id, package_id, words_text, switch)" +
                        "VALUES('" + new_package_id + "_PER70_GOAL', '" + new_package_id + "', '" + new_GOAL_PER70 + "', 21)";
                String PER80_GOAL_add = "INSERT INTO words(words_id, package_id, words_text, switch)" +
                        "VALUES('" + new_package_id + "_PER80_GOAL', '" + new_package_id + "', '" + new_GOAL_PER80 + "', 22)";
                String PER90_GOAL_add = "INSERT INTO words(words_id, package_id, words_text, switch)" +
                        "VALUES('" + new_package_id + "_PER90_GOAL', '" + new_package_id + "', '" + new_GOAL_PER90 + "', 23)";
                String SUCC_add = "INSERT INTO words(words_id, package_id, words_text, switch)" +
                        "VALUES('" + new_package_id + "_SUCC', '" + new_package_id + "', '" + new_SUCC + "', 24)";
                String FAIL_add = "INSERT INTO words(words_id, package_id, words_text, switch)" +
                        "VALUES('" + new_package_id + "_FAIL', '" + new_package_id + "', '" + new_FAIL + "', 25)";
                String NORM_A_add = "INSERT INTO words(words_id, package_id, words_text, switch)" +
                        "VALUES('" + new_package_id + "_NORM_A', '" + new_package_id + "', '" + new_NORM_A + "', 26)";
                String NORM_B_add = "INSERT INTO words(words_id, package_id, words_text, switch)" +
                        "VALUES('" + new_package_id + "_NORM_B', '" + new_package_id + "', '" + new_NORM_B + "', 27)";
                String NORM_C_add = "INSERT INTO words(words_id, package_id, words_text, switch)" +
                        "VALUES('" + new_package_id + "_NORM_C', '" + new_package_id + "', '" + new_NORM_C + "', 28)";

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

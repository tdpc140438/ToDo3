package com.example.a140438.todo3;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
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
        final Button words_add_Button = (Button)findViewById(R.id.words_add_button);

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

    }
}

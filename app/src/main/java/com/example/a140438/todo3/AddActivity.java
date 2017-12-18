package com.example.a140438.todo3;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.view.View.OnClickListener;
import android.widget.RadioButton;
import android.widget.SeekBar;

public class AddActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        //numberpickerの数値挿入
        initViews();

        //DB登録処理
        //各要素の取り込み
        OpenHelper helper = new OpenHelper(this);
        final SQLiteDatabase db = helper.getWritableDatabase();
        final EditText goal_text = (EditText) findViewById(R.id.goal_text);
        final EditText memo_text = (EditText) findViewById(R.id.goal_text);
        final SeekBar seek = (SeekBar) findViewById(R.id.seekBar);
        final NumberPicker number1 = (NumberPicker) findViewById(R.id.numberPicker1);
        final NumberPicker number2 = (NumberPicker) findViewById(R.id.numberPicker2);
        final NumberPicker number3 = (NumberPicker) findViewById(R.id.numberPicker3);
        final NumberPicker number4 = (NumberPicker) findViewById(R.id.numberPicker4);
        final NumberPicker number5 = (NumberPicker) findViewById(R.id.numberPicker5);
        final RadioButton radio0 = (RadioButton) findViewById(R.id.radioButton0);
        final RadioButton radio1 = (RadioButton) findViewById(R.id.radioButton1);
        final RadioButton radio2 = (RadioButton) findViewById(R.id.radioButton2);
        final RadioButton radio3 = (RadioButton) findViewById(R.id.radioButton3);

        Button add_button = (Button) findViewById(R.id.add_button);
        //タップした時にする処理
        add_button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                String goal = goal_text.getText().toString();
                String memo = memo_text.getText().toString();
                ContentValues insertValues = new ContentValues();
                insertValues.put("goal_name", goal);
                insertValues.put("memo", memo);
                insertValues.put("progress", 0);
                insertValues.put("year", 0);
                insertValues.put("month", 0);
                insertValues.put("day", 0);
                insertValues.put("hour", 0);
                insertValues.put("minutes", 0);
                insertValues.put("category", 0);
                long id = db.insert("goal", null, insertValues);
                //画面遷移
                //startActivity();
            }
        });


    }

    //Sato

    private void initViews(){
        //numberPickerの設定
        //年
        NumberPicker numberPicker1 = (NumberPicker) findViewById(R.id.numberPicker1);
        numberPicker1.setMaxValue(2027);
        numberPicker1.setMinValue(2017);
        //月
        NumberPicker numberPicker2 = (NumberPicker) findViewById(R.id.numberPicker2);
        numberPicker2.setMaxValue(12);
        numberPicker2.setMinValue(1);
        //日
        NumberPicker numberPicker3 = (NumberPicker) findViewById(R.id.numberPicker3);
        numberPicker3.setMaxValue(31);
        numberPicker3.setMinValue(1);
        //時間
        NumberPicker numberPicker4 = (NumberPicker) findViewById(R.id.numberPicker4);
        numberPicker4.setMaxValue(23);
        numberPicker4.setMinValue(0);
        //分
        NumberPicker numberPicker5 = (NumberPicker) findViewById(R.id.numberPicker5);
        numberPicker5.setMaxValue(59);
        numberPicker5.setMinValue(0);
    }
}

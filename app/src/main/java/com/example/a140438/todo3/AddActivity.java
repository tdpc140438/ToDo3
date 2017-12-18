package com.example.a140438.todo3;

import android.content.ContentValues;
import android.content.Intent;
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
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.Calendar;

public class AddActivity extends AppCompatActivity {
    String goal = "";
    String memo = "";
    int seekInt = 0;
    int year = 0;
    int month = 0;
    int day = 0;
    int hour = 0;
    int minutes = 0;
    int category = 0;
    private int year_now = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        //DBの使用宣言
        OpenHelper helper = new OpenHelper(this);
        final SQLiteDatabase db = helper.getWritableDatabase();



        // <各Activityの宣言、初期設定>

        //Activityの使用宣言
        final EditText goal_text = (EditText) findViewById(R.id.goal_text);
        final EditText memo_text = (EditText) findViewById(R.id.goal_text);
        final SeekBar seekBar = (SeekBar) findViewById(R.id.seekBar);
        final NumberPicker yearPicker = (NumberPicker) findViewById(R.id.numberPicker1);
        final NumberPicker monthPicker = (NumberPicker) findViewById(R.id.numberPicker2);
        final NumberPicker dayPicker = (NumberPicker) findViewById(R.id.numberPicker3);
        final NumberPicker hourPicker = (NumberPicker) findViewById(R.id.numberPicker4);
        final NumberPicker minutesPicker = (NumberPicker) findViewById(R.id.numberPicker5);
        final RadioGroup radioGroup = (RadioGroup)findViewById(R.id.radioGroup);
        final RadioButton radio0 = (RadioButton) findViewById(R.id.radioButton0);
        final RadioButton radio1 = (RadioButton) findViewById(R.id.radioButton1);
        final RadioButton radio2 = (RadioButton) findViewById(R.id.radioButton2);
        final RadioButton radio3 = (RadioButton) findViewById(R.id.radioButton3);
        final TextView textView10 = (TextView) findViewById(R.id.textView10);

        //NumberPickerの範囲指定
        //年は現在年～10年後を設定する
        Calendar cal = Calendar.getInstance();
        year_now = cal.get(Calendar.YEAR);
        yearPicker.setMaxValue(year_now + 10);
        yearPicker.setMinValue(year_now);
        monthPicker.setMaxValue(12);
        monthPicker.setMinValue(1);
        dayPicker.setMaxValue(31);
        dayPicker.setMinValue(1);
        hourPicker.setMaxValue(23);
        hourPicker.setMinValue(0);
        minutesPicker.setMaxValue(59);
        minutesPicker.setMinValue(0);

        //RadioButtonの初期設定
        radioGroup.check(R.id.radioButton0);



        // <Activity操作から値を変数に格納>

        //EditTextから値を受け取り、変数に格納
        goal = goal_text.getText().toString();
        memo = memo_text.getText().toString();

        //SeekBarから値を受け取り、変数に格納
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                //見た目を10刻みにする処理
                textView10.setText(seekBar.getProgress() * 10 + " %");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // seekIntに0～100の10刻みの値を格納
                seekInt = seekBar.getProgress() * 10;
            }
        });

        //NumberPickerから値を受け取り、変数に格納
        year = yearPicker.getValue();
        month = monthPicker.getValue();
        day = dayPicker.getValue();
        hour = hourPicker.getValue();
        minutes = minutesPicker.getValue();

        //RadioGroupから値を受け取り、変数に格納
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                int checkedId = radioGroup.getCheckedRadioButtonId();

                switch(checkedId){
                    case R.id.radioButton0:
                        category = 0;
                        break;
                    case  R.id.radioButton1:
                        category = 1;
                        break;
                    case R.id.radioButton2:
                        category = 2;
                        break;
                    case R.id.radioButton3:
                        category = 3;
                        break;
                }
            }
        });

        // <DB登録処理・遷移>

        Button add_button = (Button) findViewById(R.id.add_button);
        //タップした時にする処理
        add_button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent dbIntent = new Intent(AddActivity.this,
                        MainActivity.class);

                String sql = "INSERT INTO goal(goal_name, memo, progress, " +
                             "year, month, day, hour, minutes, category)" +
                             "VALUES('" + goal + "', '" + memo + "', " + seekInt +
                             ", "  + year + ", "+ month + ", " + day + ", " + hour +
                             ", " + minutes + ", " + category + ")";

                db.execSQL(sql);

                startActivity(dbIntent);
            }
        });

    }
}

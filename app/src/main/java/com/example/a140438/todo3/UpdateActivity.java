package com.example.a140438.todo3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;

public class UpdateActivity extends AppCompatActivity {

    String goal_name,goal_memo;
    int goal_progres,goal_year,goal_month,goal_day,goal_hour,goal_minutes,goal_category;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        //値受け取り
        //目標名
        Intent intent = getIntent();
        goal_name = intent.getStringExtra("goal_name");
        EditText edit_goal =findViewById(R.id.goal_text0);
        edit_goal.setText(goal_name);
        //メモ
        goal_memo = intent.getStringExtra("goal_memo");
        EditText edit_memo =findViewById(R.id.memo_text);
        edit_memo.setText(goal_memo);
        //進捗率
        goal_progres = intent.getIntExtra("goal_progres",0);
        SeekBar seekBar =findViewById(R.id.seekBar);
        seekBar.setProgress(goal_progres);
        //年
        goal_year = intent.getIntExtra("goal_year",0);
        NumberPicker Year_Picker =findViewById(R.id.numberPicker1);
        Year_Picker.setValue(goal_year);
        //月
        goal_month = intent.getIntExtra("goal_month",0);
        NumberPicker Month_Picker =findViewById(R.id.numberPicker2);
        Month_Picker.setValue(goal_year);
        //日
        goal_day = intent.getIntExtra("goal_month",0);
        NumberPicker Day_Picker =findViewById(R.id.numberPicker3);
        Day_Picker.setValue(goal_year);
        //時
        goal_hour = intent.getIntExtra("goal_month",0);
        NumberPicker Hour_Picker =findViewById(R.id.numberPicker4);
        Hour_Picker.setValue(goal_year);
        //分
        goal_minutes = intent.getIntExtra("goal_month",0);
        NumberPicker Minutes_Picker =findViewById(R.id.numberPicker5);
        Minutes_Picker.setValue(goal_year);
        //カテゴリー
        goal_category = intent.getIntExtra("goal_name",0);
        RadioGroup RadioGrouop =findViewById(R.id.UpdateRadio);
        RadioGrouop.check(goal_category);


    }
}

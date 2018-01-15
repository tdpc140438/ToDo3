package com.example.a140438.todo3;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.Calendar;

public class UpdateActivity extends AppCompatActivity {
    int seekInt,goal_category,year_now;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        final TextView textView100 = (TextView)findViewById(R.id.textView100);

        //前の画面から引き継いだgoal_idでデータ取得
        Intent intent = getIntent();
        final int goal_id = intent.getIntExtra("goal_id",0);

        OpenHelper helper = new OpenHelper(this);
        final SQLiteDatabase db = helper.getWritableDatabase();

        Cursor c = null;

        String sql = "SELECT * FROM goal WHERE goal_id = " + goal_id + ";";
        c = db.rawQuery(sql, new String[]{});

        c.moveToFirst();


        //取得したデータを初期値として各項目にセット
        Calendar cal = Calendar.getInstance();
        year_now = cal.get(Calendar.YEAR);

        final EditText edit_goal = findViewById(R.id.goal_text0);
        edit_goal.setText(c.getString(1));

        final EditText edit_memo = findViewById(R.id.memo_text0);
        edit_memo.setText(c.getString(2));

//        String str = null;
//        final EditText edit_memo =findViewById(R.id.memo_text);
//
//        if(str.equals(c.getString(2))){
//            edit_memo.setText("");
//        }
//        else{
//            edit_memo.setText(c.getString(2));
//        }

        SeekBar seekBar =findViewById(R.id.seekBar0);
        seekBar.setProgress(c.getInt(3) / 10);

        final NumberPicker Year_Picker =findViewById(R.id.numberPicker10);
        Year_Picker.setMaxValue(year_now + 10);
        Year_Picker.setMinValue(year_now);
        Year_Picker.setValue(c.getInt(4));

        final NumberPicker Month_Picker =findViewById(R.id.numberPicker20);
        Month_Picker.setMaxValue(12);
        Month_Picker.setMinValue(1);
        Month_Picker.setValue(c.getInt(5));

        final NumberPicker Day_Picker =findViewById(R.id.numberPicker30);
        Day_Picker.setMaxValue(31);
        Day_Picker.setMinValue(1);
        Day_Picker.setValue(c.getInt(6));

        final NumberPicker Hour_Picker =findViewById(R.id.numberPicker40);
        Hour_Picker.setMaxValue(23);
        Hour_Picker.setMinValue(0);
        Hour_Picker.setValue(c.getInt(7));

        final NumberPicker Minutes_Picker =findViewById(R.id.numberPicker50);
        Minutes_Picker.setMaxValue(59);
        Minutes_Picker.setMinValue(0);
        Minutes_Picker.setValue(c.getInt(8));

        final RadioGroup RadioGroup =findViewById(R.id.UpdateRadio);

        if(c.getInt(9) == 0){
            RadioGroup.check(R.id.radioButton00);
        }
        else if(c.getInt(9) == 1){
            RadioGroup.check(R.id.radioButton10);
        }
        else if(c.getInt(9) == 2){
            RadioGroup.check(R.id.radioButton20);
        }
        else{
            RadioGroup.check(R.id.radioButton30);
        }


        //値の格納
        textView100.setText(seekBar.getProgress() * 10 + " %");
        seekInt = seekBar.getProgress() * 10;
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                textView100.setText(seekBar.getProgress() * 10 + " %");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                seekInt = seekBar.getProgress() * 10;
            }
        });

        RadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                int checkedId = RadioGroup.getCheckedRadioButtonId();

                switch (checkedId){
                    case R.id.radioButton00:
                        goal_category = 0;
                        break;
                    case R.id.radioButton10:
                        goal_category = 1;
                        break;
                    case R.id.radioButton20:
                        goal_category = 2;
                        break;
                    case R.id.radioButton30:
                        goal_category = 3;
                        break;
                }
            }
        });


        //削除ボタンの機能
        Button delete_Button = (Button)findViewById(R.id.delete_button);
        delete_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AlertDialog.Builder(UpdateActivity.this)
                        .setTitle("目標削除確認")
                        .setMessage("目標を削除します。よろしいですか？")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // OKをタップしたときの処理

                                Intent dbIntent_delete = new Intent(UpdateActivity.this, MainActivity.class);

                String delete_sql = "DELETE FROM goal WHERE goal_id = " + goal_id + ";";

                db.execSQL(delete_sql);

                startActivity(dbIntent_delete);
                            }
                        })
                        .setNegativeButton("Cancel", null)
                        .show();

            }
        });


        //完了ボタンの機能
        Button add_Button20 = (Button)findViewById(R.id.add_button20);
        add_Button20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                                Intent dbIntent_update = new Intent(UpdateActivity.this,
                                        MainActivity.class);

                                String update_sql = "UPDATE goal SET goal_name = '" + edit_goal.getText().toString() + "'," +
                                        " memo = '" + edit_memo.getText().toString() + "', progress = " + seekInt + "," +
                                        " year = " + Year_Picker.getValue() + ", month = " + Month_Picker.getValue() + "," +
                                        " day = " + Day_Picker.getValue() + ", hour = " + Hour_Picker.getValue() + "," +
                                        " minutes = " + Minutes_Picker.getValue() + ", category = " + goal_category + "" +
                                        " WHERE goal_id = " + goal_id + ";";

                                db.execSQL(update_sql);
                                //進捗率が100％のときに完了画面へ遷移する。
                                if(seekInt!=100) {
                                    dbIntent_update.putExtra("seekInt", seekInt);
                                    setResult(RESULT_OK, dbIntent_update);
                                    //startActivity(dbIntent_update);
                                    finish();
                                }

                                else{
                                    Intent success = new Intent(UpdateActivity.this,SuccessActivity.class);
                                    success.putExtra("goal_name",edit_goal.getText().toString());
                                    success.putExtra("goal_id",goal_id);
                                    startActivity(success);
                                }
             }
          });
     }
}

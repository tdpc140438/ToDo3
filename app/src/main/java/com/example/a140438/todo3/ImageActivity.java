package com.example.a140438.todo3;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;

public class ImageActivity extends AppCompatActivity {
    private static final int RESULT_PICK_IMAGEFILE = 1001;
    private TextView textView5 = (TextView)findViewById(R.id.textView5);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        Button imageButton = findViewById(R.id.imageButton);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // ACTION_OPEN_DOCUMENT is the intent to choose a file via the system's file browser.
                Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);

                // Filter to only show results that can be "opened", such as a
                // file (as opposed to a list of contacts or timezones)
                intent.addCategory(Intent.CATEGORY_OPENABLE);

                // Filter to show only images, using the image MIME data type.
                // it would be "*/*".
                intent.setType("*/*");

                startActivityForResult(intent, RESULT_PICK_IMAGEFILE);
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent resultData){
        if(requestCode == RESULT_PICK_IMAGEFILE && resultCode == Activity.RESULT_OK){
            if(resultData.getData() != null){
                ParcelFileDescriptor pfDescriptor = null;

                try{
                    Uri uri = resultData.getData();

                    textView5.setText(String.format("Uri: %s", uri.toString()));

                    OpenHelper helper = new OpenHelper(this);
                    final SQLiteDatabase db = helper.getWritableDatabase();

                    Cursor c = null;

                    String update_picture = "UPDATE picture SET picture_url = '" + uri.toString() + "'";
                }
                catch(Exception e){
                    e.printStackTrace();
                }
                finally{
                    try{
                        if(pfDescriptor != null){
                            pfDescriptor.close();
                        }
                    }
                    catch(Exception e){
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}

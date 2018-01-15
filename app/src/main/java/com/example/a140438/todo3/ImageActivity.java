package com.example.a140438.todo3;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.InputStream;

public class ImageActivity extends AppCompatActivity {
    private static final int RESULT_PICK_IMAGEFILE = 2001;
    private TextView text_acImage;
    private ImageView selectImage;
    private Button imageButton;
    private Button imageSetEnd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        text_acImage = (TextView)findViewById(R.id.text_acImage);
        selectImage = (ImageView)findViewById(R.id.selectImage);
        imageButton = (Button)findViewById(R.id.imageButton);
        imageSetEnd = (Button)findViewById(R.id.imageSetEnd);

        OpenHelper helper = new OpenHelper(this);
        final SQLiteDatabase db_uriCheck = helper.getWritableDatabase();
        Cursor c = null;
        String sql = "SELECT picture_url FROM picture WHERE picture_id = 1;";
        c = db_uriCheck.rawQuery(sql, new String[]{});
        c.moveToFirst();

        if(!c.getString(1).equals("aaa") && !c.getString(1).equals("")){
            Uri picture_now = Uri.parse(c.getString(1));

            File file = new File(picture_now.getPath());

            try{
                InputStream stream = new FileInputStream(file);
                Bitmap bitmap = BitmapFactory.decodeStream(new BufferedInputStream(stream));
                selectImage.setImageBitmap(bitmap);
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }

        db_uriCheck.close();

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

        imageSetEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent dbIntent = new Intent(ImageActivity.this,
                        MainActivity.class);

                startActivity(dbIntent);
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

                    text_acImage.setText(String.format("Uri: %s", uri.toString()));

                    pfDescriptor = getContentResolver().openFileDescriptor(uri, "r");

                    if(pfDescriptor != null){
                        FileDescriptor fileDescriptor = pfDescriptor.getFileDescriptor();
                        Bitmap bmp = BitmapFactory.decodeFileDescriptor(fileDescriptor);
                        pfDescriptor.close();
                        selectImage.setImageBitmap(bmp);

                        OpenHelper helper = new OpenHelper(this);
                        final SQLiteDatabase db = helper.getWritableDatabase();
                        String update_picture = "UPDATE picture SET picture_url = '" + uri.toString() + "' WHERE picture_id = 1";
                        db.execSQL(update_picture);
                        db.close();
                    }
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

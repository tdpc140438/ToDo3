package com.example.a140438.todo3;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.isseiaoki.simplecropview.CropImageView;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.InputStream;

public class ImageActivity extends AppCompatActivity {
    private static final int RESULT_PICK_IMAGEFILE = 2001;
    private TextView text_acImage;
    private ImageView selectImage;
    private Button imageButton;
    private Button imageSetEnd;
    private String fileName = "picture_now";
    public Bitmap crop_bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        text_acImage = (TextView)findViewById(R.id.text_acImage);
        selectImage = (ImageView)findViewById(R.id.selectImage);
        imageButton = (Button)findViewById(R.id.imageButton);
        imageSetEnd = (Button)findViewById(R.id.imageSetEnd);



        //既に画像を設定してあるなら、その画像を表示
        try(FileInputStream fileInputStream = openFileInput(fileName);){
            if(fileInputStream != null){
                crop_bitmap = BitmapFactory.decodeStream(fileInputStream);
                Drawable draw = new BitmapDrawable(getResources(),crop_bitmap);
                selectImage.setImageDrawable(draw);
               // selectImage.setImageBitmap(bitmap);

                //1/29追加
                final CropImageView cropImageView = (CropImageView)findViewById(R.id.cropImageView);
                cropImageView.setImageBitmap(crop_bitmap);
                Button cropButton = (Button)findViewById(R.id.crop);
                cropButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // フレームに合わせてトリミング
                        //selectImage.setImageBitmap(cropImageView.getCroppedBitmap());

                        crop_bitmap = (cropImageView.getCroppedBitmap());
                        ByteArrayOutputStream baos = new ByteArrayOutputStream();
                        crop_bitmap.compress(Bitmap.CompressFormat.PNG,100,baos);
                        String bitmapStr = Base64.encodeToString(baos.toByteArray(),Base64.DEFAULT);

                        SharedPreferences data = getSharedPreferences("hogehoge", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = data.edit();
                        editor.putString("key", bitmapStr);
                        editor.apply();

                        Intent image_intent = new Intent(getApplication(),MainActivity.class);
                        image_intent.putExtra("img",crop_bitmap);
                        selectImage.setImageBitmap(crop_bitmap);

                    }
                });

            }
        }
        catch(Exception e){
            e.printStackTrace();
        }






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

                    //text_acImage.setText(String.format("Uri: %s", uri.toString()));

                    pfDescriptor = getContentResolver().openFileDescriptor(uri, "r");

                    if(pfDescriptor != null){
                        FileDescriptor fileDescriptor = pfDescriptor.getFileDescriptor();

                        Bitmap bmp = BitmapFactory.decodeFileDescriptor(fileDescriptor);
                        pfDescriptor.close();

                        //Bitmapをbyteに変換
                        ByteArrayOutputStream bos = new ByteArrayOutputStream();
                        bmp.compress(Bitmap.CompressFormat.PNG, 100, bos);

                        //内部ストレージにバイナリで保存
                        try(FileOutputStream fileOutputStream = openFileOutput(fileName,
                                Context.MODE_PRIVATE);){
                            fileOutputStream.write(bos.toByteArray());
                        }
                        catch(Exception e){
                            e.printStackTrace();
                        }

                        //取得した画像を表示
                        try(FileInputStream fileInputStream = openFileInput(fileName);){
                            Bitmap bitmap = BitmapFactory.decodeStream(fileInputStream);
                            CropImageView cropImageView = (CropImageView)findViewById(R.id.cropImageView);
                            selectImage.setImageBitmap(bitmap);
                            cropImageView.setImageBitmap(bitmap);
                        }


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

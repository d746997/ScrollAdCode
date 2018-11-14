package com.duanc.scrolladcode.view.VIEW;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.app.scrolllibrary.tools.ScreenShotUtils;
import com.duanc.scrolladcode.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ScreenActivity extends AppCompatActivity {

    @BindView(R.id.btn_kc)
    Button btnKc;
    @BindView(R.id.img)
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen);
        ButterKnife.bind(this);

        btnKc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Bitmap bitmap = ScreenShotUtils.captureScreen(ScreenActivity.this);
                img.setImageBitmap(bitmap);

                //判断权限
                if (ContextCompat.checkSelfPermission(ScreenActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                        == PackageManager.PERMISSION_DENIED) {
                    ActivityCompat.requestPermissions(ScreenActivity.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,
                            Manifest.permission.READ_EXTERNAL_STORAGE}, 1);
                } else {
                    ScreenShotUtils.SavePic(ScreenActivity.this, bitmap);
                }

            }
        });


    }


}

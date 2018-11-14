package com.duanc.scrolladcode.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.duanc.scrolladcode.R;
import com.duanc.scrolladcode.view.VIEW.AdActivity;
import com.duanc.scrolladcode.view.VIEW.ScreenActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author 74699
 */
public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


    }

    @OnClick({R.id.btn_ad, R.id.btn_screen})
    public void onCLicked(View v) {
        switch (v.getId()) {
            case R.id.btn_ad:
                startActivity(new Intent(this, AdActivity.class));
                break;
            case R.id.btn_screen:
                startActivity(new Intent(this, ScreenActivity.class));
                break;
        }

    }

}

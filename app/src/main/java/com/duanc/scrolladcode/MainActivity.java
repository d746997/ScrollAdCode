package com.duanc.scrolladcode;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.app.scrolllibrary.AdScrollView;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 74699
 */
public class MainActivity extends AppCompatActivity {

    List<String> list = new ArrayList<>();

    int j = 6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AdScrollView view = (AdScrollView) findViewById(R.id.ad_view);

        for (int i = 1; i < j; i++) {
            list.add("第" + i + "个信息没看到那就算了吧");
        }

        view.setFlipMill(3000)
                .setViewclid(list)
                .setOnTvClick(new AdScrollView.onTvClick() {
                    @Override
                    public void onItemClick(int pos, String title) {
                        Toast.makeText(MainActivity.this, "" + pos + title, Toast.LENGTH_SHORT).show();
                    }

                });
        view.setInAnimation(this, R.anim.ad_in);
        view.setOutAnimation(this, R.anim.ad_out);
        view.startFlipping();

    }
}

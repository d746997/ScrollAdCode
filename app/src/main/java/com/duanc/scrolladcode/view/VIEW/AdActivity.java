package com.duanc.scrolladcode.view.VIEW;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.app.scrolllibrary.AdScrollView;
import com.duanc.scrolladcode.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdActivity extends AppCompatActivity {

    @BindView(R.id.ad_view)
    AdScrollView view;

    List<String> list = new ArrayList<>();

    int j = 6;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ad);
        ButterKnife.bind(this);


        for (int i = 1; i < j; i++) {
            list.add("第" + i + "个信息,没看到那就算了吧");
        }

        view.setFlipMill(3000)
                .setViewclid(list)
                .setOnTvClick(new AdScrollView.onTvClick() {
                    @Override
                    public void onItemClick(int pos, String title) {
                        Toast.makeText(AdActivity.this, "" + pos + title, Toast.LENGTH_SHORT).show();
                    }

                });
        view.setInAnimation(this, R.anim.ad_in);
        view.setOutAnimation(this, R.anim.ad_out);
        view.startFlipping();
    }
}

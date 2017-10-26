package com.app.scrolllibrary;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.ViewFlipper;

import java.util.List;

/**
 * 上下循环滚动广告
 * Created by duanc on 2017/10/23.
 */

public class AdScrollView extends ViewFlipper {

    private Context mContext;
    private onTvClick onTvClick;

    private int color;
    private float size;

    public AdScrollView(Context context) {
        super(context);
    }


    public AdScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        TypedArray type = context.obtainStyledAttributes(attrs, R.styleable.adScrollView);
        color = type.getColor(R.styleable.adScrollView_tvcolor, 0x000000);
        size = type.getDimension(R.styleable.adScrollView_tvsize, 18);
        type.recycle();
    }

    @Override
    public boolean isAutoStart() {
        return true;
    }

    public AdScrollView setFlipMill(int milliseconds) {
        setFlipInterval(milliseconds);
        return this;
    }


    public AdScrollView setViewclid(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.list_flipper_item, null);
            TextView tv = view.findViewById(R.id.tv_title);
            tv.setTextSize(size);
            tv.setTextColor(color);
            final String aa = list.get(i);
            final int finalI = i;
            tv.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    onTvClick.onItemClick(finalI, aa);
                }
            });
            tv.setText(aa);
            addView(view);
        }

        return this;
    }


    public void setOnTvClick(onTvClick onTvClick) {
        this.onTvClick = onTvClick;
    }

    public interface onTvClick {
        void onItemClick(int pos, String title);
    }

}

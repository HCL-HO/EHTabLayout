package com.example.ericho.ehtabbar.tablayout;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.ericho.ehtabbar.R;


import java.util.LinkedHashMap;
import java.util.Map;

public class UnderlineTabLayout extends MyTabLayout implements IconTabBar {

    private float textSize = getResources().getDimensionPixelSize(R.dimen.findpw_main3_title);
    private float largeTextsize = Math.round(textSize * 1.1);

    public UnderlineTabLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        if (attrs != null) {
            TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.UnderlineTabLayout);
            textSize = typedArray.getDimensionPixelSize(R.styleable.UnderlineTabLayout_textSize, getResources().getDimensionPixelSize(R.dimen.findpw_main3_title));
            largeTextsize = Math.round(textSize * 1.1);
            typedArray.recycle();
        }
    }

    @Override
    void setSelectLedLayout(View tab) {
        TextView textView = getTextView((RelativeLayout) tab);
        textView.setTextColor(getResources().getColor(R.color.white));
        textView.setTextSize(TypedValue.COMPLEX_UNIT_PX, largeTextsize);
        textView.setTypeface(null, Typeface.BOLD);
        getImageView((RelativeLayout) tab).setImageResource(R.mipmap.tab_blue_bar);
    }

    @Override
    View getTabItem(String text) {
        RelativeLayout tab = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.custom_tab_view, null);
        getTextView(tab).setText(text);
        setDefaultTabLayout(tab);
        setTabLayouParam(tab);
        return tab;
    }

    @Override
    protected View getTabItem(Map.Entry<String, Integer> tabData) {
        return null;
    }

    @Override
    public TextView getTextView(ViewGroup tab) {
        TextView textView = (TextView) tab.findViewById(R.id.text1);
        return getTabTextView(textView);
    }

    @Override
    public ImageView getImageView(ViewGroup tab) {
        return (ImageView) tab.findViewById(R.id.icon);
    }

    @Override
    void setDefaultTabLayout(View tab) {
        TextView textView = getTextView((RelativeLayout) tab);
        textView.setTextColor(Color.parseColor("#71767B"));
        textView.setTextSize(TypedValue.COMPLEX_UNIT_PX, textSize);
        textView.setTypeface(null, Typeface.NORMAL);
        getImageView((RelativeLayout) tab).setImageResource(0);

    }

    public void demo() {
        inflateTabs(new Inflater() {
            @Override
            public String[] getTabTitles() {
                return new String[]{
                        "tab", "tab", "tab", "tab", "tab"
                };
            }

            @Override
            public void onSelected(int position) {

            }

            @Override
            public void onUnSelected(int position) {

            }
        });
    }
}
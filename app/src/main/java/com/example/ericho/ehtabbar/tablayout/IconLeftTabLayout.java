package com.example.ericho.ehtabbar.tablayout;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.ericho.ehtabbar.R;

import java.util.LinkedHashMap;
import java.util.Map;

public class IconLeftTabLayout extends MyTabLayout implements IconTabBar {

    public IconLeftTabLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected View getTabItem(Map.Entry<String, Integer> tabData) {
        RelativeLayout tabContainer = (RelativeLayout) LayoutInflater.from(context).inflate(R.layout.icon_left_tab, null);
        getTextView(tabContainer).setText(tabData.getKey());
        getImageView(tabContainer).setImageDrawable(getResources().getDrawable(tabData.getValue()));
        setTabLayouParam(tabContainer);
        return tabContainer;
    }

    @Override
    void setSelectLedLayout(View tab) {
        getImageView((ViewGroup) tab).setSelected(true);
        getTextView((ViewGroup) tab).setTextColor(Color.parseColor("#0B93AE"));
    }


    @Override
    void setDefaultTabLayout(View tab) {
        getImageView((ViewGroup) tab).setSelected(false);
        getTextView((ViewGroup) tab).setTextColor(Color.parseColor("#5D636E"));
    }

    @Override
    public TextView getTextView(ViewGroup parent) {
        return (TextView) parent.findViewById(R.id.text1);
    }

    @Override
    public ImageView getImageView(ViewGroup parent) {
        return (ImageView) parent.findViewById(R.id.icon);
    }

    @Override
    View getTabItem(String text) {
        return null;
    }

    public void demo() {
        inflateTabs(new IconInflater() {

            LinkedHashMap<String, Integer> map = new LinkedHashMap<String, Integer>() {{
                put("tab", R.drawable.ic_android_black_24dp);
                put("tab1", R.drawable.ic_android_black_24dp);
                put("tab2", R.drawable.ic_android_black_24dp);
                put("tab3", R.drawable.ic_android_black_24dp);
                put("tab4", R.drawable.ic_android_black_24dp);
            }};

            @Override
            public LinkedHashMap<String, Integer> getTabData() {
                return map;
            }

            @Override
            public void onSelected(int position) {

            }

            @Override
            public void onUnSelected(int position) {

            }

            @Override
            public String[] getTabTitles() {
                return new String[0];
            }
        });
    }
}

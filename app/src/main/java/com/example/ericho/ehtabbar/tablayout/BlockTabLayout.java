package com.example.ericho.ehtabbar.tablayout;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.example.ericho.ehtabbar.R;

import java.util.Map;

public class BlockTabLayout extends MyTabLayout {

    public BlockTabLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setBackground(getResources().getDrawable(R.drawable.background_rounded_corner_gray_common));
    }

    @Override
    protected View getTabItem(Map.Entry<String, Integer> tabData) {
        return null;
    }

    @Override
    void setSelectLedLayout(View view) {
        TextView tab = (TextView) view;
        tab.setTextColor(Color.WHITE);
        tab.setBackground(context.getResources().getDrawable(R.drawable.gradient_green));
    }

    TextView getTabItem(String text) {
        TextView tab = new TextView(context);
        tab.setText(text);
        tab.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimensionPixelSize(R.dimen.findpw_main4_title));
        tab.setTextAlignment(TEXT_ALIGNMENT_CENTER);
        tab.setGravity(Gravity.CENTER_VERTICAL);
        setTabLayouParam(tab);
        setDefaultTabLayout(tab);
        return tab;
    }

    @Override
    void setDefaultTabLayout(View view) {
        TextView tab = (TextView) view;
        tab.setTextColor(Color.parseColor("#8E8E93"));
        tab.setBackground(context.getResources().getDrawable(R.color.transparent));
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

package com.example.ericho.ehtabbar.tablayout;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.ericho.ehtabbar.R;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public abstract class MyTabLayout extends LinearLayout {
    // error
    private static final String ERR_NULL_TAB = "Tab view is null, check using the correct inflater and inflation of view";

    protected final Context context;
    private MyTabLayout.Inflater inflater;
    //    protected JXLog logger;
    private MyTabLayout.UIUpdater uiUpdater;

    // program
    private int CURRENT_TAB = -1;
    private Set<View> tabList = new HashSet<>();

    public MyTabLayout(Context context) {
        super(context);
        this.context = context;
    }

//    public JXLog getJXLogger() {
//        if (logger == null) {
//            logger = new JXLog(getClass().getSimpleName());
//        }
//        return logger;
//    }

    public interface Inflater {
        String[] getTabTitles();

        void onSelected(int position);

        void onUnSelected(int position);
    }

    public interface IconInflater extends Inflater {
        LinkedHashMap<String, Integer> getTabData();

        void onSelected(int position);

        void onUnSelected(int position);
    }

    public interface UIUpdater {
        void onSelect(View textView);

        void onUnSelect(View textView);
    }

    public MyTabLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
//        setBackground(getResources().getDrawable(R.drawable.background_rounded_corner_gray_common));
        setOrientation(HORIZONTAL);
    }

    public void inflateTabs(final MyTabLayout.Inflater inflater) {
        this.inflater = inflater;
        String[] tabs = inflater.getTabTitles();
        for (int i = 0; i < tabs.length; i++) {
            View tab = getTabItem(tabs[i]);
            if (tab == null) {
                debugLog(ERR_NULL_TAB);
                return;
            }
            final int posistion = i;
            tab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    select(posistion);
                }
            });
            tabList.add(tab);
            addView(tab);
        }
    }

    private void debugLog(String errNullTab) {
        Log.d(getClass().getSimpleName(), errNullTab);
    }

    public void inflateTabs(final MyTabLayout.IconInflater inflater) {
        this.inflater = inflater;
        LinkedHashMap<String, Integer> tabs = inflater.getTabData();
        int i = 0;
        for (Map.Entry<String, Integer> set : tabs.entrySet()) {
            View tab = getTabItem(set);
            if (tab == null) {
                debugLog(ERR_NULL_TAB);
                return;
            }
            final int posistion = i++;
            tab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    select(posistion);
                }
            });
            tabList.add(tab);
            addView(tab);
        }
    }

    protected abstract View getTabItem(Map.Entry<String, Integer> tabData);

    public void select(int pos) {
        View tab = getChildAt(pos);
        tab.setEnabled(false);
        if (CURRENT_TAB > -1) {
            unSelect(CURRENT_TAB);
        }

        if (uiUpdater == null) {
            setSelectLedLayout(tab);
        } else {
            uiUpdater.onSelect(tab);
        }

        CURRENT_TAB = pos;
        inflater.onSelected(pos);
        tab.setEnabled(true);
    }

    abstract void setSelectLedLayout(View tab);

    abstract View getTabItem(String text);

    abstract void setDefaultTabLayout(View tab);

    protected TextView getTabTextView(TextView tab) {
        tab.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimensionPixelSize(R.dimen.findpw_main4_title));
        tab.setTextAlignment(TEXT_ALIGNMENT_CENTER);
        tab.setGravity(Gravity.CENTER_VERTICAL);
        return tab;
    }

    protected void setTabLayouParam(View view) {
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
        params.weight = 1;
        view.setLayoutParams(params);
    }


//    private void defaultLayout(TextView tab) {
//        if (uiUpdater == null) {
//            tab.setTextColor(Color.parseColor("#8E8E93"));
//            tab.setBackground(context.getResources().getDrawable(R.color.transparent));
//        } else {
//            uiUpdater.onUnSelect(tab);
//        }
//    }


    private void unSelect(int pos) {
        View tab = getChildAt(pos);
        setDefaultTabLayout(tab);
        inflater.onUnSelected(pos);
    }

    public void setUiUpdater(MyTabLayout.UIUpdater uiUpdater) {
        this.uiUpdater = uiUpdater;
    }
}


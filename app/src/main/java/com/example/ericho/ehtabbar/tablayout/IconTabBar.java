package com.example.ericho.ehtabbar.tablayout;

import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public interface IconTabBar {
    TextView getTextView(ViewGroup parent);

    ImageView getImageView(ViewGroup parent);
}

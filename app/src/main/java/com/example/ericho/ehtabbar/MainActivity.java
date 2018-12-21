package com.example.ericho.ehtabbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.ericho.ehtabbar.tablayout.BlockTabLayout;
import com.example.ericho.ehtabbar.tablayout.IconLeftTabLayout;
import com.example.ericho.ehtabbar.tablayout.UnderlineTabLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BlockTabLayout blockTabLayout = findViewById(R.id.blockTab);
        blockTabLayout.demo();

        UnderlineTabLayout underlineTabLayout = findViewById(R.id.underlinetab);
        underlineTabLayout.demo();
        IconLeftTabLayout iconLeftTabLayout = findViewById(R.id.icontab);
        iconLeftTabLayout.demo();
    }
}

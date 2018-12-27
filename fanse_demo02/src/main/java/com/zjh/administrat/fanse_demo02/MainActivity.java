package com.zjh.administrat.fanse_demo02;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.but_one)
    Button butOne;
    @BindView(R.id.but_two)
    Button butTwo;
    @BindView(R.id.but_three)
    Button butThree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        InJectViewParser.bind(this);
    }

    @OnClick(R.id.but_one)
    public void butOne() {
        Toast.makeText(MainActivity.this, "点击一", Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.but_two)
    public void butTwo() {
        Toast.makeText(MainActivity.this, "点击二", Toast.LENGTH_SHORT).show();
    }
    @OnClick(R.id.but_three)
    public void butThree() {
        Toast.makeText(MainActivity.this, "点击三", Toast.LENGTH_SHORT).show();
    }





}

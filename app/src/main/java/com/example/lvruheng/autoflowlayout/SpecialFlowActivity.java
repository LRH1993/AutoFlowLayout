package com.example.lvruheng.autoflowlayout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.library.AutoFlowLayout;
import com.example.library.FlowAdapter;

import java.util.Arrays;

/**
 * Created by lvruheng on 2017/8/4.
 */

public class SpecialFlowActivity extends AppCompatActivity {
    private Button mChangeButton;
    private Button mLongClickButton;
    private AutoFlowLayout mFlowLayout;
    private String[] mData = {"Java", "C++", "Python", "JavaScript", "Ruby", "Swift", "MATLAB", "Scratch", "Drat", "ABAP", "COBOL", "Fortran", "Scala", "Lisp",
            "Kotlin", "Erlang", "Groovy", "Scheme", "Rust", "Logo", "Prolog", "LabVIEW"};
    private LayoutInflater mLayoutInflater;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.special_flow);
        mChangeButton = (Button) findViewById(R.id.bt_change);
        mLayoutInflater = LayoutInflater.from(this);
        mLongClickButton = (Button) findViewById(R.id.bt_long_click);
        mFlowLayout = (AutoFlowLayout) findViewById(R.id.afl_cotent);
        mFlowLayout.setAdapter(new FlowAdapter(Arrays.asList(mData)) {
            @Override
            public View getView(int position) {
                View item = mLayoutInflater.inflate(R.layout.special_item, null);
                TextView tvAttrTag = (TextView) item.findViewById(R.id.tv_attr_tag);
                tvAttrTag.setText(mData[position]);
                return item;
            }
        });
        mFlowLayout.setOnItemClickListener(new AutoFlowLayout.OnItemClickListener() {
            @Override
            public void onItemClick(int position, View view) {
                Toast.makeText(SpecialFlowActivity.this, mData[position], Toast.LENGTH_SHORT).show();
            }
        });
        mFlowLayout.setOnLongItemClickListener(new AutoFlowLayout.OnLongItemClickListener() {
            @Override
            public void onLongItemClick(int position, View view) {
                ImageView imageView = view.findViewById(R.id.iv_delete);
                imageView.setVisibility(View.VISIBLE);
            }
        });
    }
}

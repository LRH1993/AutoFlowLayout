package com.example.lvruheng.autoflowlayout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.library.AutoFlowLayout;

/**
 * Created by lvruheng on 2017/8/4.
 */

public class NormalFlowActivity extends AppCompatActivity implements View.OnClickListener {
    private AutoFlowLayout mFlowLayout;
    private String[] mData = {"Java","C++","Python","JavaScript","Ruby","Swift","MATLAB","Scratch","Drat","ABAP","COBOL","Fortran","Scala","Lisp",
    "Kotlin","Erlang","Groovy","Scheme","Rust","Logo","Prolog","LabVIEW"};
    private LayoutInflater mLayoutInflater;
    private Button mSingleButton;
    private Button mMultiLineButton;
    private Button mAddButton;
    private Button mDeleteButton;
    private Button mMultiSelectedButton;
    private Button mCenterButton;
    private int count = 10;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.normal_flow);
        mFlowLayout = (AutoFlowLayout) findViewById(R.id.afl_cotent);
        mLayoutInflater = LayoutInflater.from(this);
        mSingleButton = (Button) findViewById(R.id.bt_single);
        mMultiLineButton = (Button) findViewById(R.id.bt_multi);
        mAddButton = (Button) findViewById(R.id.bt_add);
        mDeleteButton = (Button) findViewById(R.id.bt_delete);
        mMultiSelectedButton = (Button) findViewById(R.id.bt_checked);
        mCenterButton = (Button) findViewById(R.id.bt_center);
        mSingleButton.setOnClickListener(this);
        mMultiLineButton.setOnClickListener(this);
        mAddButton.setOnClickListener(this);
        mDeleteButton.setOnClickListener(this);
        mMultiSelectedButton.setOnClickListener(this);
        mCenterButton.setOnClickListener(this);
        for (int i = 0; i< 10; i ++ ){
            View item = mLayoutInflater.inflate(R.layout.sub_item, null);
            TextView tvAttrTag = (TextView) item.findViewById(R.id.tv_attr_tag);
            tvAttrTag.setText(mData[i]);
            mFlowLayout.addView(item);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_single:{
                mFlowLayout.setLineCenter(false);
                mFlowLayout.setSingleLine(true);
                mFlowLayout.setMaxLines(1);
                break;
            }
            case R.id.bt_multi:{
                mFlowLayout.setLineCenter(false);
                mFlowLayout.setSingleLine(false);
                mFlowLayout.setMaxLines(2);
                break;
            }
            case R.id.bt_add:{
                mFlowLayout.setLineCenter(false);
                if (count>=mData.length){
                    return;
                }
                View item = mLayoutInflater.inflate(R.layout.sub_item, null);
                TextView tvAttrTag = (TextView) item.findViewById(R.id.tv_attr_tag);
                tvAttrTag.setText(mData[count]);
                mFlowLayout.setSingleLine(false);
                mFlowLayout.setMaxLines(Integer.MAX_VALUE);
                mFlowLayout.addView(item);
                count++;
                break;
            }
            case R.id.bt_delete:{
                mFlowLayout.setLineCenter(false);
                mFlowLayout.deleteView();
                break;
            }

            case R.id.bt_checked:{
                mFlowLayout.setLineCenter(false);
                mFlowLayout.setMultiChecked(true);
                break;
            }
            case R.id.bt_center:{
                mFlowLayout.setLineCenter(true);
                break;
            }




        }
    }
}

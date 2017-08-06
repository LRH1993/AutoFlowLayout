package com.example.lvruheng.autoflowlayout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import com.example.library.AutoFlowLayout;
import com.example.library.FlowAdapter;

import java.util.Arrays;

/**
 * Created by lvruheng on 2017/8/4.
 */

public class NormalGridActivity extends AppCompatActivity implements View.OnClickListener{
    private Button mAddButton;
    private Button mDeleteButton;
    private AutoFlowLayout mFlowLayout;
    private int count =6;
    private String[] mData = {"Java", "C++", "Python", "JavaScript", "Ruby", "Swift"};
    private LayoutInflater mLayoutInflater;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.normal_grid);
        mAddButton = (Button) findViewById(R.id.bt_add);
        mDeleteButton = (Button) findViewById(R.id.bt_delete);
        mAddButton.setOnClickListener(this);
        mDeleteButton.setOnClickListener(this);
        mLayoutInflater = LayoutInflater.from(this);
        mFlowLayout = (AutoFlowLayout) findViewById(R.id.afl_cotent);
        mFlowLayout.setAdapter(new FlowAdapter(Arrays.asList(mData)) {
            @Override
            public View getView(int position) {
                View item = mLayoutInflater.inflate(R.layout.grid_item, null);
                return item;
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_add:{
                count++;
                mFlowLayout.setRowNumbers(count%3 == 0 ? count/3 : count/3 + 1);
                View item = mLayoutInflater.inflate(R.layout.grid_item, null);
                mFlowLayout.addView(item);
                break;
            }
            case R.id.bt_delete:{
                count--;
                mFlowLayout.setRowNumbers(count%3 == 0 ? count/3 : count/3 + 1);
                mFlowLayout.deleteView();
                break;
            }
        }
    }
}

package com.example.lvruheng.autoflowlayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private AutoFlowLayout mFlowLayout;
    private String[] mData = {"连载小说","娱乐八卦","短篇小说","美食","书单","历史","今夜日记","书法","互联网","同人志"};
    private LayoutInflater mLayoutInflater;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFlowLayout = (AutoFlowLayout) findViewById(R.id.afl_cotent);
        mLayoutInflater = LayoutInflater.from(this);
        for(int i = 0; i<mData.length; i++){
            View item = mLayoutInflater.inflate(R.layout.sub_item, null);
            TextView tvAttrTag = (TextView) item.findViewById(R.id.tv_attr_tag);
            tvAttrTag.setText(mData[i]);
            final String content = mData[i];
            mFlowLayout.addView(item);
        }
        mFlowLayout.setOnItemClickListener(new AutoFlowLayout.OnItemClickListener() {
            @Override
            public void onItemClick(int position,View view) {
                Toast.makeText(MainActivity.this,mData[position],Toast.LENGTH_SHORT).show();
            }
        });
    }
}

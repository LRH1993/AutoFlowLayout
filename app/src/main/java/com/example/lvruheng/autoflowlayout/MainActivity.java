package com.example.lvruheng.autoflowlayout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button normalFlow = (Button) findViewById(R.id.tv_normal_flow);
        Button specialFlow = (Button) findViewById(R.id.tv_special_flow);
        Button normalGrid = (Button) findViewById(R.id.tv_normal_grid);
        Button specialGrid = (Button) findViewById(R.id.tv_special_grid);
        normalFlow.setOnClickListener(this);
        specialFlow.setOnClickListener(this);
        normalGrid.setOnClickListener(this);
        specialGrid.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_normal_flow :{
                Intent intent = new Intent(MainActivity.this,NormalFlowActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.tv_special_flow :{
                Intent intent = new Intent(MainActivity.this,SpecialFlowActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.tv_normal_grid :{
                Intent intent = new Intent(MainActivity.this,NormalGridActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.tv_special_grid :{
                Intent intent = new Intent(MainActivity.this,SpecialGridActivity.class);
                startActivity(intent);
                break;
            }
        }
    }
}

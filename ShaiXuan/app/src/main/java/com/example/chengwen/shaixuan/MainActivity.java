package com.example.chengwen.shaixuan;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.chengwen.shaixuan.view.FlowLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mBtnSelect;
    private FlowLayout mFlTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtnSelect = (Button) findViewById(R.id.btn_select);
        mFlTest = (FlowLayout) findViewById(R.id.fl_test);
        mBtnSelect.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_select){
            showSelectView();
        }
    }

    private void showSelectView() {
        
    }
}

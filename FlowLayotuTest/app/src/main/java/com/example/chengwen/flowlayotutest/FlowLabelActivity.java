package com.example.chengwen.flowlayotutest;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.chengwen.flowlayotutest.view.LabelMode;
import com.example.chengwen.flowlayotutest.view.LabelsView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chengwen on 2017/11/2.
 */

public class FlowLabelActivity extends Activity {

    private List<String> mList = new ArrayList<>();
    String mNames[] = {
            "welcome","android","TextView",
            "apple","jamy","kobe bryant",
            "jordan","layout","viewgroup",
            "margin","padding","text",
            "name","type","search","logcat"
    };
    LabelsView mLabelsView;
    Button mBtnLabelsize;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flowlabel);
        mLabelsView = findViewById(R.id.fl_labels);
        findViewById(R.id.btn_labelsize).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<LabelMode> list = mLabelsView.getLabels();
                Toast.makeText(FlowLabelActivity.this, list.size() + "", Toast.LENGTH_SHORT).show();
            }
        });
        mLabelsView.setDatas(mNames);
    }
}

package com.example.chengwen.textviewgravity;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextPaint;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private RelativeLayout mReala;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mReala = (RelativeLayout) findViewById(R.id.rl_rootView);
//        test1();
        test2();
    }

    private void test2() {
        RelativeLayout.LayoutParams layoutParmas = new RelativeLayout.LayoutParams(400, 150);
        layoutParmas.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        layoutParmas.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        RelativeLayout rl = new RelativeLayout(this);
        TextView textView = new TextView(this);
        textView.setText("筛选");
        textView.setTextSize(14);
        textView.setId(0);
        textView.setBackgroundColor(Color.parseColor("#ff24db"));
        TextPaint tp = textView.getPaint();
        textView.setGravity(Gravity.RIGHT|Gravity.CENTER_VERTICAL);
        RelativeLayout.LayoutParams tvParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        tvParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        tvParams.addRule(RelativeLayout.CENTER_VERTICAL);
        textView.setLayoutParams(tvParams);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "123", Toast.LENGTH_SHORT).show();
            }
        });
        ImageView im = new ImageView(this);
        im.setImageResource(R.mipmap.no_select2);
        RelativeLayout.LayoutParams ivParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        ivParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        ivParams.addRule(RelativeLayout.CENTER_VERTICAL);
        ivParams.addRule(RelativeLayout.LEFT_OF, textView.getId());
        im.setLayoutParams(ivParams);
        rl.setBackgroundColor(Color.parseColor("#ff2d4b"));
        rl.addView(textView);
        rl.addView(im);
        mReala.addView(rl, layoutParmas);
    }

    private void test1() {
        RelativeLayout.LayoutParams layoutParmas = new RelativeLayout.LayoutParams(500, 104);
        layoutParmas.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        layoutParmas.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        TextView textView = new TextView(this);
        RelativeLayout.LayoutParams tvParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        textView.setText("筛选");
        textView.setTextSize(14);
        textView.setBackgroundColor(Color.parseColor("#ff24db"));
        TextPaint tp = textView.getPaint();
        Drawable drawable;
        tp.setFakeBoldText(true);
        drawable = getResources().getDrawable(R.mipmap.no_select2);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        textView.setCompoundDrawables(drawable, null, null, null);
        textView.setGravity(Gravity.RIGHT|Gravity.CENTER_VERTICAL);
        textView.setLayoutParams(tvParams);
        addContentView(textView, layoutParmas);
    }
}

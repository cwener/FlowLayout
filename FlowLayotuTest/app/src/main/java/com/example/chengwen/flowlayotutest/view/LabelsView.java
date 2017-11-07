package com.example.chengwen.flowlayotutest.view;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.chengwen.flowlayotutest.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by chengwen on 2017/11/2.
 */

public class LabelsView extends LinearLayout {

    private Context mContext;
    private TextView mTvHeader;
    private FlowLayout mFlLabels;
    private List<String> mListLabelText;
    private List<LabelMode> mListLabelModes = new ArrayList<>();
    private static final int DEFUALT_LEFTMARGIN = 20;
    private static final int DEFUALT_RIGHTMARGIN = 20;
    private static final int DEFUALT_TOPMARGIN = 20;
    private static final int DEFUALT_BOTTOMMARGIN = 20;

    public LabelsView(Context context) {
        super(context);
        mContext = context;
        init();
    }

    public LabelsView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        init();
    }

    private void init() {
        View layout = LayoutInflater.from(mContext).inflate(R.layout.item_flow_labels, null, false);
        mTvHeader = layout.findViewById(R.id.tv_header);
        mFlLabels = layout.findViewById(R.id.fl_labels);
        addView(layout);
    }

    //设置各标签显示数据
    public void setDatas(String[] strings) {
        setDatas(Arrays.asList(strings));
    }

    public void setDatas(List<String> list) {
        mListLabelText = list;
        initChildViews(mListLabelText);
        invalidate();
    }

    //设置标题头信息
    public void setHeaderText(String text) {
        if (!"".equals(text)) {
            mTvHeader.setText(text);
        }
    }

    //初始化标签内容
    private void initChildViews(List<String> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        lp.leftMargin = DEFUALT_LEFTMARGIN;
        lp.rightMargin = DEFUALT_RIGHTMARGIN;
        lp.bottomMargin = DEFUALT_BOTTOMMARGIN;
        for (int i = 0; i < list.size(); i++) {
            TextView view = new TextView(mContext);
            view.setText(list.get(i));
            view.setTextColor(Color.parseColor("#ff24db"));
            view.setOnClickListener(listener);
            /**此处设置id是因为通过new出来的view的id默认都是-1，因此在监听的时候无法通过v.getId判断是点击了哪个view。在布局文件中可以不这样做是因为如果你在布局文件中设置了@+id值**/
            view.setId(i);
            addLabelMode(view, i);
            mFlLabels.addView(view, lp);
        }
    }

    private void addLabelMode(TextView view, int i) {
        LabelMode mode = new LabelMode();
        mode.setPosition(i);
        if (view.getText() != null) {
            mode.setText(view.getText().toString());
        }
        mode.setViewId(view.getId());
        mode.setSelected(false);
        mListLabelModes.add(mode);
    }

    private boolean isContainsLabelMode(TextView v){
        for (LabelMode mode : mListLabelModes) {
            if (mode.getViewId() == v.getId()){
                return true;
            }
        }
        return false;
    }

    private LabelMode setLabelSelectedState(TextView v){
        for (int i = 0; i < mListLabelModes.size(); i++){
            if (v.getId() == mListLabelModes.get(i).getViewId()){
                return mListLabelModes.get(i);
            }
        }
        return null;
    }

    private View.OnClickListener listener = new OnClickListener() {
        @Override
        public void onClick(View v) {
            TextView tv = ((TextView) v);
            LabelMode mode = setLabelSelectedState(tv);
            if (!mode.isSelected()){
                Toast.makeText(mContext, mode.getText() + "被选中" + mode.getPosition(), Toast.LENGTH_SHORT).show();
                mode.setSelected(true);
            }else {
                Toast.makeText(mContext, mode.getText() + "取消选中" + mode.getPosition(), Toast.LENGTH_SHORT).show();
                mode.setSelected(false);
            }

        }
    };

    public List<LabelMode> getLabels(){
        return mListLabelModes;
    }
}

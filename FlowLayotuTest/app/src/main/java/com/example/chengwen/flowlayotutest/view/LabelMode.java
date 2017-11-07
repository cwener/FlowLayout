package com.example.chengwen.flowlayotutest.view;

/**
 * Created by chengwen on 2017/11/3.
 */

public class LabelMode {
    private int viewId;
    private int position;
    private String text;
    private boolean isSelected = false;

    public int getViewId() {
        return viewId;
    }

    public int getPosition() {
        return position;
    }

    public String getText() {
        return text;
    }

    public void setViewId(int viewId) {
        this.viewId = viewId;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}

package eason.linyuzai.rxeason.listener.view;

import android.view.View;

public class OnLayoutChangeInfo {
    private View view;
    private int left;
    private int top;
    private int right;
    private int bottom;
    private int oldLeft;
    private int oldTop;
    private int oldRight;
    private int oldBottom;

    OnLayoutChangeInfo(View view, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
        this.view = view;
        this.left = left;
        this.top = top;
        this.right = right;
        this.bottom = bottom;
        this.oldLeft = oldLeft;
        this.oldTop = oldTop;
        this.oldRight = oldRight;
        this.oldBottom = oldBottom;
    }

    public void setView(View view) {
        this.view = view;
    }

    public void setLeft(int left) {
        this.left = left;
    }

    public void setTop(int top) {
        this.top = top;
    }

    public void setRight(int right) {
        this.right = right;
    }

    public void setBottom(int bottom) {
        this.bottom = bottom;
    }

    public void setOldLeft(int oldLeft) {
        this.oldLeft = oldLeft;
    }

    public void setOldTop(int oldTop) {
        this.oldTop = oldTop;
    }

    public void setOldRight(int oldRight) {
        this.oldRight = oldRight;
    }

    public void setOldBottom(int oldBottom) {
        this.oldBottom = oldBottom;
    }
}

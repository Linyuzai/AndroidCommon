package eason.linyuzai.rxeason.listener.view;

import android.view.View;

import eason.linyuzai.rxeason.ExtraInfo;

public class OnLayoutChangeInfo<E> extends ExtraInfo<E> {
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

    public View getView() {
        return view;
    }

    public int getLeft() {
        return left;
    }

    public int getTop() {
        return top;
    }

    public int getRight() {
        return right;
    }

    public int getBottom() {
        return bottom;
    }

    public int getOldLeft() {
        return oldLeft;
    }

    public int getOldTop() {
        return oldTop;
    }

    public int getOldRight() {
        return oldRight;
    }

    public int getOldBottom() {
        return oldBottom;
    }
}

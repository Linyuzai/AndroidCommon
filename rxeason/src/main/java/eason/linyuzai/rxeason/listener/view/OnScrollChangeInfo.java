package eason.linyuzai.rxeason.listener.view;

import android.view.View;

public class OnScrollChangeInfo {
    private View view;
    private int scrollX;
    private int scrollY;
    private int oldScrollX;
    private int oldScrollY;

    OnScrollChangeInfo(View view, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
        this.view = view;
        this.scrollX = scrollX;
        this.scrollY = scrollY;
        this.oldScrollX = oldScrollX;
        this.oldScrollY = oldScrollY;
    }

    public View getView() {
        return view;
    }

    public int getScrollX() {
        return scrollX;
    }

    public int getScrollY() {
        return scrollY;
    }

    public int getOldScrollX() {
        return oldScrollX;
    }

    public int getOldScrollY() {
        return oldScrollY;
    }
}

package eason.linyuzai.rxeason.listener.view;

import android.view.View;

public class OnFocusChangeInfo {

    private View view;
    private boolean hasFocus;

    OnFocusChangeInfo(View view, boolean hasFocus) {
        this.view = view;
        this.hasFocus = hasFocus;
    }

    public View getView() {
        return view;
    }

    public boolean isHasFocus() {
        return hasFocus;
    }
}

package eason.linyuzai.rxeason.listener.view;

import android.view.View;

import eason.linyuzai.rxeason.ExtraInfo;

public class OnFocusChangeInfo<E> extends ExtraInfo<E> {

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

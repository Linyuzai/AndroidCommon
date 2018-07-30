package eason.linyuzai.rxeason.listener.view;

import android.view.View;

import eason.linyuzai.rxeason.ExtraInfo;

public class OnClickInfo<E> extends ExtraInfo<E> {
    private View view;

    public OnClickInfo(View view) {
        this.view = view;
    }

    public View getView() {
        return view;
    }
}

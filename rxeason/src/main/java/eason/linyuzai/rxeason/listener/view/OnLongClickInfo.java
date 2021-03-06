package eason.linyuzai.rxeason.listener.view;

import android.view.View;

import eason.linyuzai.rxeason.ReturnedInfo;

public class OnLongClickInfo<E> extends ReturnedInfo<Boolean, E> {
    private View view;

    OnLongClickInfo(View view) {
        super(false);
        this.view = view;
    }

    public View getView() {
        return view;
    }
}

package eason.linyuzai.rxeason.listener.view;

import android.view.View;

import eason.linyuzai.rxeason.ReturnedInfo;

public class OnContextClickInfo<E> extends ReturnedInfo<Boolean, E> {

    private View view;

    OnContextClickInfo(View view) {
        super(false);
        this.view = view;
    }

    public View getView() {
        return view;
    }
}

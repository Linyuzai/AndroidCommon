package eason.linyuzai.rxeason.listener.view;

import android.view.View;

import eason.linyuzai.rxeason.ReturnedInfo;

public class OnLongClickInfo extends ReturnedInfo<Boolean> {
    private View view;

    OnLongClickInfo(View view) {
        super(false);
        this.view = view;
    }

    public View getView() {
        return view;
    }
}

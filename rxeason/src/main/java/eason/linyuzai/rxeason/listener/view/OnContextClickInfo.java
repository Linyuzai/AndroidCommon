package eason.linyuzai.rxeason.listener.view;

import android.view.View;

import eason.linyuzai.rxeason.ReturnedInfo;

public class OnContextClickInfo extends ReturnedInfo<Boolean> {

    private View view;

    OnContextClickInfo(View view) {
        super(false);
        this.view = view;
    }

    public View getView() {
        return view;
    }

    public void setView(View view) {
        this.view = view;
    }
}

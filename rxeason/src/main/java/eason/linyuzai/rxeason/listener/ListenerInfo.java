package eason.linyuzai.rxeason.listener;

import android.view.View;

public class ListenerInfo {
    private View view;

    public ListenerInfo(View view) {
        this.view = view;
    }

    @SuppressWarnings("unchecked")
    public <V extends View> V getView() {
        return (V) view;
    }
}

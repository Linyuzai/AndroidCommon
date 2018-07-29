package eason.linyuzai.rxeason.listener;

import android.view.View;

public class ListenerInfo<V extends View> {
    private V view;
    private boolean isEffect;

    public ListenerInfo(V view) {
        this.view = view;
        this.isEffect = true;
    }

    public V getView() {
        return view;
    }

    public boolean isEffect() {
        return isEffect;
    }

    public void setEffect(boolean effect) {
        isEffect = effect;
    }
}

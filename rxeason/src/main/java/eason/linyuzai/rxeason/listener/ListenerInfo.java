package eason.linyuzai.rxeason.listener;

import android.view.View;

public class ListenerInfo<V extends View> {
    private V view;
    private boolean isFiltered;

    public ListenerInfo(V view) {
        this.view = view;
        this.isFiltered = true;

    }

    public V getView() {
        return view;
    }

    public boolean isFiltered() {
        return isFiltered;
    }

    public void setFiltered(boolean filtered) {
        isFiltered = filtered;
    }
}

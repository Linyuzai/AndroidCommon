package eason.linyuzai.rxeason.listener.viewgroup;

import android.view.ViewGroup;

import eason.linyuzai.rxeason.listener.view.ViewInfo;

public class ViewGroupInfo<V extends ViewGroup> extends ViewInfo<V> {

    public ViewGroupInfo(V view) {
        super(view);
    }
}

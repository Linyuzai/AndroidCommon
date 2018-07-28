package eason.linyuzai.rxeason.listener.view;

import android.view.View;

import java.util.ArrayList;
import java.util.List;

import eason.linyuzai.rxeason.listener.ListenerInfo;

public class ViewInfo<V extends View> extends ListenerInfo<V> {
    private List<View.OnAttachStateChangeListener> onAttachStateChangeListeners = new ArrayList<>();
    private List<View.OnLayoutChangeListener> onLayoutChangeListeners = new ArrayList<>();

    public ViewInfo(V view) {
        super(view);
    }

    public List<View.OnLayoutChangeListener> getOnLayoutChangeListeners() {
        return onLayoutChangeListeners;
    }

    public List<View.OnAttachStateChangeListener> getOnAttachStateChangeListeners() {
        return onAttachStateChangeListeners;
    }
}


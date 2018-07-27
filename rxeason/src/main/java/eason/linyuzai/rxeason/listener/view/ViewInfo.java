package eason.linyuzai.rxeason.listener.view;

import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class ViewInfo {
    private View view;
    private List<View.OnAttachStateChangeListener> onAttachStateChangeListeners = new ArrayList<>();
    private List<View.OnLayoutChangeListener> onLayoutChangeListeners = new ArrayList<>();

    ViewInfo(View view) {
        this.view = view;
    }

    public View getView() {
        return view;
    }

    public List<View.OnAttachStateChangeListener> getOnAttachStateChangeListeners() {
        return onAttachStateChangeListeners;
    }

    public List<View.OnLayoutChangeListener> getOnLayoutChangeListeners() {
        return onLayoutChangeListeners;
    }
}

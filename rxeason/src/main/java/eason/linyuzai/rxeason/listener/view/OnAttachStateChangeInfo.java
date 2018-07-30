package eason.linyuzai.rxeason.listener.view;

import android.view.View;

import eason.linyuzai.rxeason.ExtraInfo;

public class OnAttachStateChangeInfo<E> extends ExtraInfo<E> {
    private View view;
    private boolean isOnViewAttachedToWindow;
    private boolean isOnViewDetachedFromWindow;

    OnAttachStateChangeInfo(View view, boolean isOnViewAttachedToWindow, boolean isOnViewDetachedFromWindow) {
        this.view = view;
        this.isOnViewAttachedToWindow = isOnViewAttachedToWindow;
        this.isOnViewDetachedFromWindow = isOnViewDetachedFromWindow;
    }

    public View getView() {
        return view;
    }

    public boolean isOnViewAttachedToWindow() {
        return isOnViewAttachedToWindow;
    }

    public boolean isOnViewDetachedFromWindow() {
        return isOnViewDetachedFromWindow;
    }
}

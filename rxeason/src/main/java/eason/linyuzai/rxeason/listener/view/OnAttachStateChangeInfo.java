package eason.linyuzai.rxeason.listener.view;

import android.view.View;

public class OnAttachStateChangeInfo {
    private View view;
    private boolean isViewAttachedToWindow;
    private boolean isViewDetachedFromWindow;

    OnAttachStateChangeInfo(View view, boolean isViewAttachedToWindow, boolean isViewDetachedFromWindow) {
        this.view = view;
        this.isViewAttachedToWindow = isViewAttachedToWindow;
        this.isViewDetachedFromWindow = isViewDetachedFromWindow;
    }

    public View getView() {
        return view;
    }

    public boolean isViewAttachedToWindow() {
        return isViewAttachedToWindow;
    }

    public boolean isViewDetachedFromWindow() {
        return isViewDetachedFromWindow;
    }
}

package eason.linyuzai.rxeason.listener.view;

import android.view.View;
import android.view.WindowInsets;

import eason.linyuzai.rxeason.ReturnedInfo;

public class OnApplyWindowInsetsInfo extends ReturnedInfo<WindowInsets> {
    private View view;
    private WindowInsets windowInsets;

    OnApplyWindowInsetsInfo(View view, WindowInsets windowInsets) {
        super(windowInsets);
        this.view = view;
        this.windowInsets = windowInsets;
    }

    public View getView() {
        return view;
    }

    public WindowInsets getWindowInsets() {
        return windowInsets;
    }
}

package eason.linyuzai.rxeason.listener.view;

import eason.linyuzai.rxeason.ExtraInfo;

public class OnSystemUiVisibilityChangeInfo<E> extends ExtraInfo<E> {
    private int visibility;

    public OnSystemUiVisibilityChangeInfo(int visibility) {
        this.visibility = visibility;
    }

    public int getVisibility() {
        return visibility;
    }
}

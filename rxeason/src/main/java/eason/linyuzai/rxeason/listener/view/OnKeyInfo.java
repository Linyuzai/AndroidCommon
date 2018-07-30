package eason.linyuzai.rxeason.listener.view;

import android.view.KeyEvent;
import android.view.View;

import eason.linyuzai.rxeason.ReturnedInfo;

public class OnKeyInfo<E> extends ReturnedInfo<Boolean, E> {
    private View view;
    private int keyCode;
    private KeyEvent keyEvent;

    OnKeyInfo(View view, int keyCode, KeyEvent keyEvent) {
        super(false);
        this.view = view;
        this.keyCode = keyCode;
        this.keyEvent = keyEvent;
    }

    public View getView() {
        return view;
    }

    public int getKeyCode() {
        return keyCode;
    }

    public KeyEvent getKeyEvent() {
        return keyEvent;
    }
}

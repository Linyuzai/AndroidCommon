package eason.linyuzai.rxeason.listener.view;

import android.view.MotionEvent;
import android.view.View;

import eason.linyuzai.rxeason.ReturnedInfo;

public class OnHoverInfo<E> extends ReturnedInfo<Boolean, E> {

    private View view;
    private MotionEvent motionEvent;

    OnHoverInfo(View view, MotionEvent motionEvent) {
        super(false);
        this.view = view;
        this.motionEvent = motionEvent;
    }

    public View getView() {
        return view;
    }

    public MotionEvent getMotionEvent() {
        return motionEvent;
    }
}

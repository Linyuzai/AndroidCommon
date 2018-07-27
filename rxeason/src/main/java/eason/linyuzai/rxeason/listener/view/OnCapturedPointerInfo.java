package eason.linyuzai.rxeason.listener.view;

import android.view.MotionEvent;
import android.view.View;

import eason.linyuzai.rxeason.ReturnedInfo;

public class OnCapturedPointerInfo extends ReturnedInfo<Boolean> {

    private View view;
    private MotionEvent motionEvent;

    OnCapturedPointerInfo(View view, MotionEvent motionEvent) {
        super(false);
        this.view = view;
        this.motionEvent = motionEvent;
    }

    public View getView() {
        return view;
    }

    public void setView(View view) {
        this.view = view;
    }

    public MotionEvent getMotionEvent() {
        return motionEvent;
    }

    public void setMotionEvent(MotionEvent motionEvent) {
        this.motionEvent = motionEvent;
    }
}

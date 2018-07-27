package eason.linyuzai.rxeason.listener.view;

import android.view.MotionEvent;
import android.view.View;

import eason.linyuzai.rxeason.ReturnedInfo;

public class OnGenericMotionInfo extends ReturnedInfo<Boolean> {

    private View view;
    private MotionEvent motionEvent;

    OnGenericMotionInfo(View view, MotionEvent motionEvent) {
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

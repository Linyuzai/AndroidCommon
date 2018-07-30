package eason.linyuzai.rxeason.listener.view;

import android.view.DragEvent;
import android.view.View;

import eason.linyuzai.rxeason.ReturnedInfo;

public class OnDragInfo<E> extends ReturnedInfo<Boolean, E> {

    private View view;
    private DragEvent dragEvent;

    OnDragInfo(View view, DragEvent dragEvent) {
        super(false);
        this.view = view;
        this.dragEvent = dragEvent;
    }

    public View getView() {
        return view;
    }

    public DragEvent getDragEvent() {
        return dragEvent;
    }
}

package eason.linyuzai.rxeason.listener.textview;

import android.view.KeyEvent;
import android.widget.TextView;

import eason.linyuzai.rxeason.ReturnedInfo;

public class OnEditorActionInfo extends ReturnedInfo<Boolean> {
    private TextView textView;
    private int actionId;
    private KeyEvent keyEvent;

    OnEditorActionInfo(TextView textView, int actionId, KeyEvent keyEvent) {
        super(false);
        this.textView = textView;
        this.actionId = actionId;
        this.keyEvent = keyEvent;
    }

    public TextView getTextView() {
        return textView;
    }

    public int getActionId() {
        return actionId;
    }

    public KeyEvent getKeyEvent() {
        return keyEvent;
    }
}

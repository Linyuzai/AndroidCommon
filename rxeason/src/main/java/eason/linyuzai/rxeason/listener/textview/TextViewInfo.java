package eason.linyuzai.rxeason.listener.textview;

import android.text.TextWatcher;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import eason.linyuzai.rxeason.listener.view.ViewInfo;

public class TextViewInfo<V extends TextView> extends ViewInfo<V> {

    private List<TextWatcher> textWatchers = new ArrayList<>();

    public TextViewInfo(V view) {
        super(view);
    }

    public List<TextWatcher> getTextWatchers() {
        return textWatchers;
    }
}

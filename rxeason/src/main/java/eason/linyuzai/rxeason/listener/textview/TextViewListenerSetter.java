package eason.linyuzai.rxeason.listener.textview;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import eason.linyuzai.rxeason.RxEason;
import eason.linyuzai.rxeason.listener.view.ViewListenerSetter;
import io.reactivex.Flowable;

public class TextViewListenerSetter extends ViewListenerSetter {

    @Override
    public TextViewInfo[] getViewInfos() {
        return (TextViewInfo[]) super.getViewInfos();
    }

    public Flowable<OnEditorActionInfo> onEditorAction() {
        return Flowable.create(emitter -> {
            for (TextViewInfo vi : getViewInfos()) {
                vi.getView().setOnEditorActionListener((v, actionId, event) -> {
                    OnEditorActionInfo info = new OnEditorActionInfo(v, actionId, event);
                    emitter.onNext(info);
                    return info.getReturnValue();
                });
            }
        }, RxEason.globalBackpressureStrategy);

    }

    public void removeEditorAction() {
        for (TextViewInfo vi : getViewInfos()) {
            vi.getView().setOnEditorActionListener(null);
        }
    }

    public Flowable<OnTextChangedInfo> onTextChanged() {
        return Flowable.create(emitter -> {
            for (TextViewInfo vi : getViewInfos()) {
                TextWatcher watcher = new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                        emitter.onNext(new OnTextChangedInfo(s, start, count, -1, after, true, false));
                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                        emitter.onNext(new OnTextChangedInfo(s, start, count, before, -1, false, true));
                    }

                    @Override
                    public void afterTextChanged(Editable s) {
                        emitter.onNext(new OnTextChangedInfo(s));
                    }
                };
                vi.getView().addTextChangedListener(watcher);
                vi.textWatchers.add(watcher);
            }
        }, RxEason.globalBackpressureStrategy);
    }

    public void removeTextChanged() {
        for (TextViewInfo vi : getViewInfos()) {
            for (TextWatcher watcher : vi.textWatchers) {
                vi.getView().removeTextChangedListener(watcher);
            }
        }
    }

    public static class TextViewInfo extends ViewInfo {

        private List<TextWatcher> textWatchers = new ArrayList<>();

        public TextViewInfo(View view) {
            super(view);
        }

        @Override
        public TextView getView() {
            return (TextView) super.getView();
        }
    }
}

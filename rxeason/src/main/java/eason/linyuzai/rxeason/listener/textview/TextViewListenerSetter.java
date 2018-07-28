package eason.linyuzai.rxeason.listener.textview;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;

import eason.linyuzai.rxeason.listener.RxListener;
import eason.linyuzai.rxeason.listener.view.ViewListenerSetter;
import io.reactivex.Flowable;

public class TextViewListenerSetter<Setter extends TextViewListenerSetter, V extends TextView, Info extends TextViewInfo<V>>
        extends ViewListenerSetter<Setter, V, Info> {

    @SuppressWarnings("unchecked")
    @Override
    public Info newViewInfo(V view) {
        return (Info) new TextViewInfo(view);
    }

    public Flowable<OnEditorActionInfo> onEditorAction() {
        return Flowable.create(emitter -> {
            for (Info vi : getViewInfos()) {
                vi.getView().setOnEditorActionListener((v, actionId, event) -> {
                    OnEditorActionInfo info = new OnEditorActionInfo(v, actionId, event);
                    emitter.onNext(info);
                    return info.getReturnValue();
                });
            }
        }, RxListener.getListenerBackpressureStrategy());

    }

    public void removeEditorAction() {
        for (Info vi : getViewInfos()) {
            vi.getView().setOnEditorActionListener(null);
        }
    }

    public Flowable<OnTextChangedInfo> onTextChanged() {
        return Flowable.create(emitter -> {
            for (Info vi : getViewInfos()) {
                TextWatcher watcher = new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                        emitter.onNext(new OnTextChangedInfo(new OnTextChangedInfo.BeforeTextChangedMethodParam(
                                s, start, count, after)));
                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                        emitter.onNext(new OnTextChangedInfo(new OnTextChangedInfo.OnTextChangedMethodParam(
                                s, start, count, before)));
                    }

                    @Override
                    public void afterTextChanged(Editable s) {
                        emitter.onNext(new OnTextChangedInfo(new OnTextChangedInfo.AfterTextChangedMethodParam(s)));
                    }
                };
                vi.getView().addTextChangedListener(watcher);
                vi.getTextWatchers().add(watcher);
            }
        }, RxListener.getListenerBackpressureStrategy());
    }

    public void removeTextChanged() {
        for (Info vi : getViewInfos()) {
            for (TextWatcher watcher : vi.getTextWatchers()) {
                vi.getView().removeTextChangedListener(watcher);
            }
            vi.getTextWatchers().clear();
        }
    }
}

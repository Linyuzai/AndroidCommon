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

    @Override
    public void destroy() {
        removeEditorAction();
        removeTextChanged();
        super.destroy();
    }

    public Flowable<OnEditorActionInfo> onEditorAction() {
        return Flowable.create(emitter -> getViewInfo().getView().setOnEditorActionListener((v, actionId, event) -> {
            OnEditorActionInfo info = new OnEditorActionInfo(v, actionId, event);
            emitter.onNext(info);
            return info.getReturnValue();
        }), RxListener.getListenerBackpressureStrategy());

    }

    public void removeEditorAction() {
        getViewInfo().getView().setOnEditorActionListener(null);
    }

    public Flowable<OnTextChangedInfo> onTextChanged() {
        return Flowable.create(emitter -> {
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
            getViewInfo().getView().addTextChangedListener(watcher);
            getViewInfo().getTextWatchers().add(watcher);
        }, RxListener.getListenerBackpressureStrategy());
    }

    public void removeTextChanged() {
        for (TextWatcher watcher : getViewInfo().getTextWatchers()) {
            getViewInfo().getView().removeTextChangedListener(watcher);
        }
        getViewInfo().getTextWatchers().clear();
    }
}

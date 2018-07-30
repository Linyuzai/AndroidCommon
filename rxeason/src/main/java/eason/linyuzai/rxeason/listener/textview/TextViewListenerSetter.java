package eason.linyuzai.rxeason.listener.textview;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;

import eason.linyuzai.rxeason.ExtraGetter;
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

    public <E> Flowable<OnEditorActionInfo<E>> onEditorAction() {
        return onEditorAction(null);
    }

    public <E> Flowable<OnEditorActionInfo<E>> onEditorAction(ExtraGetter<E> getter) {
        return Flowable.create(emitter -> getViewInfo().getView().setOnEditorActionListener((v, actionId, event) -> {
            OnEditorActionInfo<E> info = new OnEditorActionInfo<>(v, actionId, event);
            if (getter != null) {
                info.setExtra(getter.getExtra());
            }
            emitter.onNext(info);
            return info.getReturnValue();
        }), RxListener.getListenerBackpressureStrategy());

    }

    public void removeEditorAction() {
        getViewInfo().getView().setOnEditorActionListener(null);
    }

    public <E> Flowable<OnTextChangedInfo<E>> onTextChanged() {
        return onTextChanged(null);
    }

    public <E> Flowable<OnTextChangedInfo<E>> onTextChanged(ExtraGetter<E> getter) {
        return Flowable.create(emitter -> {
            TextWatcher watcher = new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                    OnTextChangedInfo<E> info = new OnTextChangedInfo<>(new OnTextChangedInfo.BeforeTextChangedMethodParam(
                            s, start, count, after));
                    if (getter != null) {
                        info.setExtra(getter.getExtra());
                    }
                    emitter.onNext(info);
                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    OnTextChangedInfo<E> info = new OnTextChangedInfo<>(new OnTextChangedInfo.OnTextChangedMethodParam(
                            s, start, count, before));
                    if (getter != null) {
                        info.setExtra(getter.getExtra());
                    }
                    emitter.onNext(info);
                }

                @Override
                public void afterTextChanged(Editable s) {
                    OnTextChangedInfo<E> info = new OnTextChangedInfo<>(new OnTextChangedInfo.AfterTextChangedMethodParam(s));
                    if (getter != null) {
                        info.setExtra(getter.getExtra());
                    }
                    emitter.onNext(info);
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

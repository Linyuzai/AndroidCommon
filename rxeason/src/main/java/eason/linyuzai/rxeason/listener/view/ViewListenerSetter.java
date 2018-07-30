package eason.linyuzai.rxeason.listener.view;

import android.annotation.SuppressLint;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.View;

import eason.linyuzai.rxeason.ExtraGetter;
import eason.linyuzai.rxeason.listener.ListenerSetter;
import eason.linyuzai.rxeason.listener.RxListener;
import io.reactivex.Flowable;

public class ViewListenerSetter<Setter extends ViewListenerSetter, V extends View, Info extends ViewInfo<V>>
        extends ListenerSetter<Setter, V, Info> {

    @SuppressWarnings("unchecked")
    @Override
    public Info newViewInfo(V view) {
        return (Info) new ViewInfo(view);
    }

    @Override
    public void destroy() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT_WATCH) {
            removeApplyWindowInsets();
        }
        removeAttachStateChange();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            removeCapturedPointer();
        }
        removeClick();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            removeContextClick();
        }
        removeCreateContextMenu();
        removeDrag();
        removeFocusChange();
        removeGenericMotion();
        removeHover();
        removeKey();
        removeLayoutChange();
        removeLongClick();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            removeScrollChange();
        }
        removeSystemUiVisibilityChange();
        removeTouch();
        super.destroy();
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT_WATCH)
    public <E> Flowable<OnApplyWindowInsetsInfo<E>> onApplyWindowInsets() {
        return onApplyWindowInsets(null);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT_WATCH)
    public <E> Flowable<OnApplyWindowInsetsInfo<E>> onApplyWindowInsets(ExtraGetter<E> getter) {
        return Flowable.create(emitter -> getViewInfo().getView().setOnApplyWindowInsetsListener((v, insets) -> {
            OnApplyWindowInsetsInfo<E> info = new OnApplyWindowInsetsInfo<>(v, insets);
            if (getter != null) {
                info.setExtra(getter.getExtra());
            }
            emitter.onNext(info);
            return info.getReturnValue();
        }), RxListener.getListenerBackpressureStrategy());
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT_WATCH)
    public void removeApplyWindowInsets() {
        getViewInfo().getView().setOnApplyWindowInsetsListener(null);
    }

    public <E> Flowable<OnAttachStateChangeInfo<E>> onAttachStateChange() {
        return onAttachStateChange(null);
    }

    public <E> Flowable<OnAttachStateChangeInfo<E>> onAttachStateChange(ExtraGetter<E> getter) {
        return Flowable.create(emitter -> {
            View.OnAttachStateChangeListener listener = new View.OnAttachStateChangeListener() {
                @Override
                public void onViewAttachedToWindow(View v) {
                    OnAttachStateChangeInfo<E> info = new OnAttachStateChangeInfo<>(v, true,
                            false);
                    if (getter != null) {
                        info.setExtra(getter.getExtra());
                    }
                    emitter.onNext(info);
                }

                @Override
                public void onViewDetachedFromWindow(View v) {
                    OnAttachStateChangeInfo<E> info = new OnAttachStateChangeInfo<>(v, false,
                            true);
                    if (getter != null) {
                        info.setExtra(getter.getExtra());
                    }
                    emitter.onNext(info);
                }
            };
            getViewInfo().getView().addOnAttachStateChangeListener(listener);
            getViewInfo().getOnAttachStateChangeListeners().add(listener);
        }, RxListener.getListenerBackpressureStrategy());
    }

    public void removeAttachStateChange() {
        for (View.OnAttachStateChangeListener listener : getViewInfo().getOnAttachStateChangeListeners()) {
            getViewInfo().getView().removeOnAttachStateChangeListener(listener);
        }
        getViewInfo().getOnAttachStateChangeListeners().clear();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public <E> Flowable<OnCapturedPointerInfo<E>> onCapturedPointer() {
        return onCapturedPointer(null);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public <E> Flowable<OnCapturedPointerInfo<E>> onCapturedPointer(ExtraGetter<E> getter) {
        return Flowable.create(emitter -> getViewInfo().getView().setOnCapturedPointerListener((v, event) -> {
            OnCapturedPointerInfo<E> info = new OnCapturedPointerInfo<>(v, event);
            if (getter != null) {
                info.setExtra(getter.getExtra());
            }
            emitter.onNext(info);
            return info.getReturnValue();
        }), RxListener.getListenerBackpressureStrategy());
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void removeCapturedPointer() {
        getViewInfo().getView().setOnCapturedPointerListener(null);
    }

    public <E> Flowable<OnClickInfo<E>> onClick() {
        return onClick(null);
    }

    public <E> Flowable<OnClickInfo<E>> onClick(ExtraGetter<E> getter) {
        return Flowable.create(emitter -> getViewInfo().getView().setOnClickListener(v -> {
            OnClickInfo<E> info = new OnClickInfo<>(v);
            if (getter != null) {
                info.setExtra(getter.getExtra());
            }
            emitter.onNext(info);
        }), RxListener.getListenerBackpressureStrategy());
    }

    public void removeClick() {
        getViewInfo().getView().setOnClickListener(null);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public <E> Flowable<OnContextClickInfo<E>> onContextClick() {
        return onContextClick(null);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public <E> Flowable<OnContextClickInfo<E>> onContextClick(ExtraGetter<E> getter) {
        return Flowable.create(emitter -> getViewInfo().getView().setOnContextClickListener(v -> {
            OnContextClickInfo<E> info = new OnContextClickInfo<>(v);
            if (getter != null) {
                info.setExtra(getter.getExtra());
            }
            emitter.onNext(info);
            return info.getReturnValue();
        }), RxListener.getListenerBackpressureStrategy());
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void removeContextClick() {
        getViewInfo().getView().setOnContextClickListener(null);
    }

    public <E> Flowable<OnCreateContextMenuInfo<E>> onCreateContextMenu() {
        return onCreateContextMenu(null);
    }

    public <E> Flowable<OnCreateContextMenuInfo<E>> onCreateContextMenu(ExtraGetter<E> getter) {
        return Flowable.create(emitter -> getViewInfo().getView().setOnCreateContextMenuListener((menu, v, menuInfo) -> {
            OnCreateContextMenuInfo<E> info = new OnCreateContextMenuInfo<>(menu, v, menuInfo);
            if (getter != null) {
                info.setExtra(getter.getExtra());
            }
            emitter.onNext(info);
        }), RxListener.getListenerBackpressureStrategy());
    }

    public void removeCreateContextMenu() {
        getViewInfo().getView().setOnCreateContextMenuListener(null);
    }

    public <E> Flowable<OnDragInfo<E>> onDrag() {
        return onDrag(null);
    }

    public <E> Flowable<OnDragInfo<E>> onDrag(ExtraGetter<E> getter) {
        return Flowable.create(emitter -> getViewInfo().getView().setOnDragListener((v, event) -> {
            OnDragInfo<E> info = new OnDragInfo<>(v, event);
            if (getter != null) {
                info.setExtra(getter.getExtra());
            }
            emitter.onNext(info);
            return info.getReturnValue();
        }), RxListener.getListenerBackpressureStrategy());
    }

    public void removeDrag() {
        getViewInfo().getView().setOnDragListener(null);
    }

    public <E> Flowable<OnFocusChangeInfo<E>> onFocusChange() {
        return onFocusChange(null);
    }

    public <E> Flowable<OnFocusChangeInfo<E>> onFocusChange(ExtraGetter<E> getter) {
        return Flowable.create(emitter -> getViewInfo().getView().setOnFocusChangeListener((v, hasFocus) -> {
            OnFocusChangeInfo<E> info = new OnFocusChangeInfo<>(v, hasFocus);
            if (getter != null) {
                info.setExtra(getter.getExtra());
            }
            emitter.onNext(info);
        }), RxListener.getListenerBackpressureStrategy());
    }

    public void removeFocusChange() {
        getViewInfo().getView().setOnFocusChangeListener(null);
    }

    public <E> Flowable<OnGenericMotionInfo<E>> onGenericMotion() {
        return onGenericMotion(null);
    }

    public <E> Flowable<OnGenericMotionInfo<E>> onGenericMotion(ExtraGetter<E> getter) {
        return Flowable.create(emitter -> getViewInfo().getView().setOnGenericMotionListener((v, event) -> {
            OnGenericMotionInfo<E> info = new OnGenericMotionInfo<>(v, event);
            if (getter != null) {
                info.setExtra(getter.getExtra());
            }
            emitter.onNext(info);
            return info.getReturnValue();
        }), RxListener.getListenerBackpressureStrategy());
    }

    public void removeGenericMotion() {
        getViewInfo().getView().setOnGenericMotionListener(null);
    }

    public <E> Flowable<OnHoverInfo<E>> onHover() {
        return onHover(null);
    }

    public <E> Flowable<OnHoverInfo<E>> onHover(ExtraGetter<E> getter) {
        return Flowable.create(emitter -> getViewInfo().getView().setOnHoverListener((v, event) -> {
            OnHoverInfo<E> info = new OnHoverInfo<>(v, event);
            if (getter != null) {
                info.setExtra(getter.getExtra());
            }
            emitter.onNext(info);
            return info.getReturnValue();
        }), RxListener.getListenerBackpressureStrategy());
    }

    public void removeHover() {
        getViewInfo().getView().setOnHoverListener(null);
    }

    public <E> Flowable<OnKeyInfo<E>> onKey() {
        return onKey(null);
    }

    public <E> Flowable<OnKeyInfo<E>> onKey(ExtraGetter<E> getter) {
        return Flowable.create(emitter -> getViewInfo().getView().setOnKeyListener((v, keyCode, event) -> {
            OnKeyInfo<E> info = new OnKeyInfo<>(v, keyCode, event);
            if (getter != null) {
                info.setExtra(getter.getExtra());
            }
            emitter.onNext(info);
            return info.getReturnValue();
        }), RxListener.getListenerBackpressureStrategy());
    }

    public void removeKey() {
        getViewInfo().getView().setOnKeyListener(null);
    }

    public <E> Flowable<OnLayoutChangeInfo<E>> onLayoutChange() {
        return onLayoutChange(null);
    }

    public <E> Flowable<OnLayoutChangeInfo<E>> onLayoutChange(ExtraGetter<E> getter) {
        return Flowable.create(emitter -> {
            View.OnLayoutChangeListener listener = (v, left, top, right, bottom, oldLeft, oldTop, oldRight, oldBottom) -> {
                OnLayoutChangeInfo<E> info = new OnLayoutChangeInfo<>(v, left, top, right, bottom,
                        oldLeft, oldTop, oldRight, oldBottom);
                if (getter != null) {
                    info.setExtra(getter.getExtra());
                }
                emitter.onNext(info);
            };
            getViewInfo().getView().addOnLayoutChangeListener(listener);
            getViewInfo().getOnLayoutChangeListeners().add(listener);
        }, RxListener.getListenerBackpressureStrategy());
    }

    public void removeLayoutChange() {
        for (View.OnLayoutChangeListener listener : getViewInfo().getOnLayoutChangeListeners()) {
            getViewInfo().getView().removeOnLayoutChangeListener(listener);
        }
        getViewInfo().getOnLayoutChangeListeners().clear();
    }

    public <E> Flowable<OnLongClickInfo<E>> onLongClick() {
        return onLongClick(null);
    }

    public <E> Flowable<OnLongClickInfo<E>> onLongClick(ExtraGetter<E> getter) {
        return Flowable.create(emitter -> getViewInfo().getView().setOnLongClickListener(v -> {
            OnLongClickInfo<E> info = new OnLongClickInfo<>(v);
            if (getter != null) {
                info.setExtra(getter.getExtra());
            }
            emitter.onNext(info);
            return info.getReturnValue();
        }), RxListener.getListenerBackpressureStrategy());
    }

    public void removeLongClick() {
        getViewInfo().getView().setOnLongClickListener(null);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public <E> Flowable<OnScrollChangeInfo<E>> onScrollChange() {
        return onScrollChange(null);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public <E> Flowable<OnScrollChangeInfo<E>> onScrollChange(ExtraGetter<E> getter) {
        return Flowable.create(emitter -> getViewInfo().getView().setOnScrollChangeListener((v, scrollX, scrollY,
                                                                                             oldScrollX, oldScrollY) -> {
            OnScrollChangeInfo<E> info = new OnScrollChangeInfo<>(v, scrollX, scrollY, oldScrollX, oldScrollY);
            if (getter != null) {
                info.setExtra(getter.getExtra());
            }
            emitter.onNext(info);
        }), RxListener.getListenerBackpressureStrategy());
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void removeScrollChange() {
        getViewInfo().getView().setOnScrollChangeListener(null);
    }

    public <E> Flowable<OnSystemUiVisibilityChangeInfo<E>> onSystemUiVisibilityChange() {
        return onSystemUiVisibilityChange(null);
    }

    public <E> Flowable<OnSystemUiVisibilityChangeInfo<E>> onSystemUiVisibilityChange(ExtraGetter<E> getter) {
        return Flowable.create(emitter -> getViewInfo().getView().setOnSystemUiVisibilityChangeListener(visibility -> {
            OnSystemUiVisibilityChangeInfo<E> info = new OnSystemUiVisibilityChangeInfo<>(visibility);
            if (getter != null) {
                info.setExtra(getter.getExtra());
            }
            emitter.onNext(info);
        }), RxListener.getListenerBackpressureStrategy());
    }

    public void removeSystemUiVisibilityChange() {
        getViewInfo().getView().setOnSystemUiVisibilityChangeListener(null);
    }

    @SuppressLint("ClickableViewAccessibility")
    public <E> Flowable<OnTouchInfo<E>> onTouch() {
        return onTouch(null);
    }

    @SuppressLint("ClickableViewAccessibility")
    public <E> Flowable<OnTouchInfo<E>> onTouch(ExtraGetter<E> getter) {
        return Flowable.create(emitter -> getViewInfo().getView().setOnTouchListener((v, event) -> {
            OnTouchInfo<E> info = new OnTouchInfo<>(v, event);
            if (getter != null) {
                info.setExtra(getter.getExtra());
            }
            emitter.onNext(info);
            return info.getReturnValue();
        }), RxListener.getListenerBackpressureStrategy());
    }

    @SuppressLint("ClickableViewAccessibility")
    public void removeTouch() {
        getViewInfo().getView().setOnTouchListener(null);
    }
}

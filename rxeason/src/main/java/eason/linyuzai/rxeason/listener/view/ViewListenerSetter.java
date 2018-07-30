package eason.linyuzai.rxeason.listener.view;

import android.annotation.SuppressLint;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.View;

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
    public Flowable<OnApplyWindowInsetsInfo> onApplyWindowInsets() {
        return Flowable.create(emitter -> getViewInfo().getView().setOnApplyWindowInsetsListener((v, insets) -> {
            OnApplyWindowInsetsInfo info = new OnApplyWindowInsetsInfo(v, insets);
            emitter.onNext(info);
            return info.getReturnValue();
        }), RxListener.getListenerBackpressureStrategy());
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT_WATCH)
    public void removeApplyWindowInsets() {
        getViewInfo().getView().setOnApplyWindowInsetsListener(null);
    }

    public Flowable<OnAttachStateChangeInfo> onAttachStateChange() {
        return Flowable.create(emitter -> {
            View.OnAttachStateChangeListener listener = new View.OnAttachStateChangeListener() {
                @Override
                public void onViewAttachedToWindow(View v) {
                    emitter.onNext(new OnAttachStateChangeInfo(v, true, false));
                }

                @Override
                public void onViewDetachedFromWindow(View v) {
                    emitter.onNext(new OnAttachStateChangeInfo(v, false, true));
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
    public Flowable<OnCapturedPointerInfo> onCapturedPointer() {
        return Flowable.create(emitter -> getViewInfo().getView().setOnCapturedPointerListener((v, event) -> {
            OnCapturedPointerInfo info = new OnCapturedPointerInfo(v, event);
            emitter.onNext(info);
            return info.getReturnValue();
        }), RxListener.getListenerBackpressureStrategy());
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void removeCapturedPointer() {
        getViewInfo().getView().setOnCapturedPointerListener(null);
    }

    public Flowable<View> onClick() {
        return Flowable.create(emitter ->
                getViewInfo().getView().setOnClickListener(emitter::onNext), RxListener.getListenerBackpressureStrategy());
    }

    public void removeClick() {
        getViewInfo().getView().setOnClickListener(null);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public Flowable<OnContextClickInfo> onContextClick() {
        return Flowable.create(emitter -> getViewInfo().getView().setOnContextClickListener(v -> {
            OnContextClickInfo info = new OnContextClickInfo(v);
            emitter.onNext(info);
            return info.getReturnValue();
        }), RxListener.getListenerBackpressureStrategy());
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void removeContextClick() {
        getViewInfo().getView().setOnContextClickListener(null);
    }

    public Flowable<OnCreateContextMenuInfo> onCreateContextMenu() {
        return Flowable.create(emitter -> getViewInfo().getView().setOnCreateContextMenuListener((menu, v, menuInfo) ->
                emitter.onNext(new OnCreateContextMenuInfo(menu, v, menuInfo))
        ), RxListener.getListenerBackpressureStrategy());
    }

    public void removeCreateContextMenu() {
        getViewInfo().getView().setOnCreateContextMenuListener(null);
    }

    public Flowable<OnDragInfo> onDrag() {
        return Flowable.create(emitter -> getViewInfo().getView().setOnDragListener((v, event) -> {
            OnDragInfo info = new OnDragInfo(v, event);
            emitter.onNext(info);
            return info.getReturnValue();
        }), RxListener.getListenerBackpressureStrategy());
    }

    public void removeDrag() {
        getViewInfo().getView().setOnDragListener(null);
    }

    public Flowable<OnFocusChangeInfo> onFocusChange() {
        return Flowable.create(emitter ->
                getViewInfo().getView().setOnFocusChangeListener((v, hasFocus) ->
                        emitter.onNext(new OnFocusChangeInfo(v, hasFocus))), RxListener.getListenerBackpressureStrategy());
    }

    public void removeFocusChange() {
        getViewInfo().getView().setOnFocusChangeListener(null);
    }

    public Flowable<OnGenericMotionInfo> onGenericMotion() {
        return Flowable.create(emitter -> getViewInfo().getView().setOnGenericMotionListener((v, event) -> {
            OnGenericMotionInfo info = new OnGenericMotionInfo(v, event);
            emitter.onNext(info);
            return info.getReturnValue();
        }), RxListener.getListenerBackpressureStrategy());
    }

    public void removeGenericMotion() {
        getViewInfo().getView().setOnGenericMotionListener(null);
    }

    public Flowable<OnHoverInfo> onHover() {
        return Flowable.create(emitter -> getViewInfo().getView().setOnHoverListener((v, event) -> {
            OnHoverInfo info = new OnHoverInfo(v, event);
            emitter.onNext(info);
            return info.getReturnValue();
        }), RxListener.getListenerBackpressureStrategy());
    }

    public void removeHover() {
        getViewInfo().getView().setOnHoverListener(null);
    }

    public Flowable<OnKeyInfo> onKey() {
        return Flowable.create(emitter -> {
            getViewInfo().getView().setOnKeyListener((v, keyCode, event) -> {
                OnKeyInfo info = new OnKeyInfo(v, keyCode, event);
                emitter.onNext(info);
                return info.getReturnValue();
            });
        }, RxListener.getListenerBackpressureStrategy());
    }

    public void removeKey() {
        getViewInfo().getView().setOnKeyListener(null);
    }

    public Flowable<OnLayoutChangeInfo> onLayoutChange() {
        return Flowable.create(emitter -> {
            View.OnLayoutChangeListener listener = (v, left, top, right, bottom, oldLeft, oldTop, oldRight, oldBottom) ->
                    emitter.onNext(new OnLayoutChangeInfo(v, left, top, right, bottom, oldLeft, oldTop, oldRight, oldBottom));
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

    public Flowable<OnLongClickInfo> onLongClick() {
        return Flowable.create(emitter -> getViewInfo().getView().setOnLongClickListener(v -> {
            OnLongClickInfo info = new OnLongClickInfo(v);
            emitter.onNext(info);
            return info.getReturnValue();
        }), RxListener.getListenerBackpressureStrategy());
    }

    public void removeLongClick() {
        getViewInfo().getView().setOnLongClickListener(null);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public Flowable<OnScrollChangeInfo> onScrollChange() {
        return Flowable.create(emitter -> getViewInfo().getView().setOnScrollChangeListener((v, scrollX, scrollY, oldScrollX, oldScrollY) ->
                emitter.onNext(new OnScrollChangeInfo(v, scrollX, scrollY, oldScrollX, oldScrollY))), RxListener.getListenerBackpressureStrategy());
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void removeScrollChange() {
        getViewInfo().getView().setOnScrollChangeListener(null);
    }

    public Flowable<Integer> onSystemUiVisibilityChange() {
        return Flowable.create(emitter ->
                getViewInfo().getView().setOnSystemUiVisibilityChangeListener(emitter::onNext), RxListener.getListenerBackpressureStrategy());
    }

    public void removeSystemUiVisibilityChange() {
        getViewInfo().getView().setOnSystemUiVisibilityChangeListener(null);
    }

    @SuppressLint("ClickableViewAccessibility")
    public Flowable<OnTouchInfo> onTouch() {
        return Flowable.create(emitter -> getViewInfo().getView().setOnTouchListener((v, event) -> {
            OnTouchInfo info = new OnTouchInfo(v, event);
            emitter.onNext(info);
            return info.getReturnValue();
        }), RxListener.getListenerBackpressureStrategy());
    }

    @SuppressLint("ClickableViewAccessibility")
    public void removeTouch() {
        getViewInfo().getView().setOnTouchListener(null);
    }
}

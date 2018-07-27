package eason.linyuzai.rxeason.listener.view;

import android.annotation.SuppressLint;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.View;

import eason.linyuzai.rxeason.RxEason;
import io.reactivex.Flowable;

public class ViewListenerSetter {

    private ViewInfo[] viewInfos;

    public ViewListenerSetter(View[] views) {
        viewInfos = new ViewInfo[views.length];
        for (int i = 0; i < views.length; i++)
            viewInfos[i] = new ViewInfo(views[i]);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT_WATCH)
    public Flowable<OnApplyWindowInsetsInfo> onApplyWindowInsets() {
        return Flowable.create(emitter -> {
            for (ViewInfo vi : viewInfos) {
                vi.getView().setOnApplyWindowInsetsListener((v, insets) -> {
                    OnApplyWindowInsetsInfo info = new OnApplyWindowInsetsInfo(v, insets);
                    emitter.onNext(info);
                    return info.getReturnValue();
                });
            }
        }, RxEason.globalBackpressureStrategy);

    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT_WATCH)
    public void removeApplyWindowInsets() {
        for (ViewInfo vi : viewInfos) {
            vi.getView().setOnApplyWindowInsetsListener(null);
        }
    }

    public Flowable<OnAttachStateChangeInfo> onAttachStateChange() {
        return Flowable.create(emitter -> {
            for (ViewInfo vi : viewInfos) {
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
                vi.getView().addOnAttachStateChangeListener(listener);
                vi.getOnAttachStateChangeListeners().add(listener);
            }
        }, RxEason.globalBackpressureStrategy);
    }

    public void removeAttachStateChange() {
        for (ViewInfo vi : viewInfos) {
            for (View.OnAttachStateChangeListener listener : vi.getOnAttachStateChangeListeners()) {
                vi.getView().removeOnAttachStateChangeListener(listener);
            }
            vi.getOnAttachStateChangeListeners().clear();
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public Flowable<OnCapturedPointerInfo> onCapturedPointer() {
        return Flowable.create(emitter -> {
            for (ViewInfo vi : viewInfos) {
                vi.getView().setOnCapturedPointerListener((v, event) -> {
                    OnCapturedPointerInfo info = new OnCapturedPointerInfo(v, event);
                    emitter.onNext(info);
                    return info.getReturnValue();
                });
            }
        }, RxEason.globalBackpressureStrategy);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void removeCapturedPointer() {
        for (ViewInfo vi : viewInfos) {
            vi.getView().setOnCapturedPointerListener(null);
        }
    }

    public Flowable<View> onClick() {
        return Flowable.create(emitter -> {
            for (ViewInfo vi : viewInfos) {
                vi.getView().setOnClickListener(emitter::onNext);
            }
        }, RxEason.globalBackpressureStrategy);
    }

    public void removeClick() {
        for (ViewInfo vi : viewInfos) {
            vi.getView().setOnClickListener(null);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public Flowable<OnContextClickInfo> onContextClick() {
        return Flowable.create(emitter -> {
            for (ViewInfo vi : viewInfos) {
                vi.getView().setOnContextClickListener(v -> {
                    OnContextClickInfo info = new OnContextClickInfo(v);
                    emitter.onNext(info);
                    return info.getReturnValue();
                });
            }
        }, RxEason.globalBackpressureStrategy);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void removeContextClick() {
        for (ViewInfo vi : viewInfos) {
            vi.getView().setOnContextClickListener(null);
        }
    }

    public Flowable<OnCreateContextMenuInfo> onCreateContextMenu() {
        return Flowable.create(emitter -> {
            for (ViewInfo vi : viewInfos) {
                vi.getView().setOnCreateContextMenuListener((menu, v, menuInfo) ->
                        emitter.onNext(new OnCreateContextMenuInfo(menu, v, menuInfo))
                );
            }
        }, RxEason.globalBackpressureStrategy);
    }

    public void removeCreateContextMenu() {
        for (ViewInfo vi : viewInfos) {
            vi.getView().setOnCreateContextMenuListener(null);
        }
    }

    public Flowable<OnDragInfo> onDrag() {
        return Flowable.create(emitter -> {
            for (ViewInfo vi : viewInfos) {
                vi.getView().setOnDragListener((v, event) -> {
                    OnDragInfo info = new OnDragInfo(v, event);
                    emitter.onNext(info);
                    return info.getReturnValue();
                });
            }
        }, RxEason.globalBackpressureStrategy);
    }

    public void removeDrag() {
        for (ViewInfo vi : viewInfos) {
            vi.getView().setOnDragListener(null);
        }
    }

    public Flowable<OnFocusChangeInfo> onFocusChange() {
        return Flowable.create(emitter -> {
            for (ViewInfo vi : viewInfos) {
                vi.getView().setOnFocusChangeListener((v, hasFocus) -> emitter.onNext(new OnFocusChangeInfo(v, hasFocus)));
            }
        }, RxEason.globalBackpressureStrategy);
    }

    public void removeFocusChange() {
        for (ViewInfo vi : viewInfos) {
            vi.getView().setOnFocusChangeListener(null);
        }
    }

    public Flowable<OnGenericMotionInfo> onGenericMotion() {
        return Flowable.create(emitter -> {
            for (ViewInfo vi : viewInfos) {
                vi.getView().setOnGenericMotionListener((v, event) -> {
                    OnGenericMotionInfo info = new OnGenericMotionInfo(v, event);
                    emitter.onNext(info);
                    return info.getReturnValue();
                });
            }
        }, RxEason.globalBackpressureStrategy);
    }

    public void removeGenericMotion() {
        for (ViewInfo vi : viewInfos) {
            vi.getView().setOnGenericMotionListener(null);
        }
    }

    public Flowable<OnHoverInfo> onHover() {
        return Flowable.create(emitter -> {
            for (ViewInfo vi : viewInfos) {
                vi.getView().setOnHoverListener((v, event) -> {
                    OnHoverInfo info = new OnHoverInfo(v, event);
                    emitter.onNext(info);
                    return info.getReturnValue();
                });
            }
        }, RxEason.globalBackpressureStrategy);
    }

    public void removeHover() {
        for (ViewInfo vi : viewInfos) {
            vi.getView().setOnHoverListener(null);
        }
    }

    public Flowable<OnKeyInfo> onKey() {
        return Flowable.create(emitter -> {
            for (ViewInfo vi : viewInfos) {
                vi.getView().setOnKeyListener((v, keyCode, event) -> {
                    OnKeyInfo info = new OnKeyInfo(v, keyCode, event);
                    emitter.onNext(info);
                    return info.getReturnValue();
                });
            }
        }, RxEason.globalBackpressureStrategy);
    }

    public void removeKey() {
        for (ViewInfo vi : viewInfos) {
            vi.getView().setOnKeyListener(null);
        }
    }

    public Flowable<OnLayoutChangeInfo> onLayoutChange() {
        return Flowable.create(emitter -> {
            for (ViewInfo vi : viewInfos) {
                View.OnLayoutChangeListener listener = (v, left, top, right, bottom, oldLeft, oldTop, oldRight, oldBottom) ->
                        emitter.onNext(new OnLayoutChangeInfo(v, left, top, right, bottom, oldLeft, oldTop, oldRight, oldBottom));
                vi.getView().addOnLayoutChangeListener(listener);
                vi.getOnLayoutChangeListeners().add(listener);
            }
        }, RxEason.globalBackpressureStrategy);
    }

    public void removeLayoutChange() {
        for (ViewInfo vi : viewInfos) {
            for (View.OnLayoutChangeListener listener : vi.getOnLayoutChangeListeners()) {
                vi.getView().removeOnLayoutChangeListener(listener);
            }
            vi.getOnLayoutChangeListeners().clear();
        }
    }

    public Flowable<OnLongClickInfo> onLongClick() {
        return Flowable.create(emitter -> {
            for (ViewInfo vi : viewInfos) {
                vi.getView().setOnLongClickListener(v -> {
                    OnLongClickInfo info = new OnLongClickInfo(v);
                    emitter.onNext(info);
                    return info.getReturnValue();
                });
            }
        }, RxEason.globalBackpressureStrategy);
    }

    public void removeLongClick() {
        for (ViewInfo vi : viewInfos) {
            vi.getView().setOnLongClickListener(null);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public Flowable<OnScrollChangeInfo> onScrollChange() {
        return Flowable.create(emitter -> {
            for (ViewInfo vi : viewInfos) {
                vi.getView().setOnScrollChangeListener((v, scrollX, scrollY, oldScrollX, oldScrollY) ->
                        emitter.onNext(new OnScrollChangeInfo(v, scrollX, scrollY, oldScrollX, oldScrollY)));
            }
        }, RxEason.globalBackpressureStrategy);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void removeScrollChange() {
        for (ViewInfo vi : viewInfos) {
            vi.getView().setOnScrollChangeListener(null);
        }
    }

    public Flowable<Integer> onSystemUiVisibilityChange() {
        return Flowable.create(emitter -> {
            for (ViewInfo vi : viewInfos) {
                vi.getView().setOnSystemUiVisibilityChangeListener(emitter::onNext);
            }
        }, RxEason.globalBackpressureStrategy);
    }

    public void removeSystemUiVisibilityChange() {
        for (ViewInfo vi : viewInfos) {
            vi.getView().setOnSystemUiVisibilityChangeListener(null);
        }
    }

    @SuppressLint("ClickableViewAccessibility")
    public Flowable<OnTouchInfo> onTouch() {
        return Flowable.create(emitter -> {
            for (ViewInfo vi : viewInfos) {
                vi.getView().setOnTouchListener((v, event) -> {
                    OnTouchInfo info = new OnTouchInfo(v, event);
                    emitter.onNext(info);
                    return info.getReturnValue();
                });
            }
        }, RxEason.globalBackpressureStrategy);
    }

    public void removeTouch() {
        for (ViewInfo vi : viewInfos) {
            vi.getView().setOnTouchListener(null);
        }
    }
}

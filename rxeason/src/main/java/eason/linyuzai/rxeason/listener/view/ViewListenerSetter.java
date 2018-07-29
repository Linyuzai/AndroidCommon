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

    @RequiresApi(api = Build.VERSION_CODES.KITKAT_WATCH)
    public Flowable<OnApplyWindowInsetsInfo> onApplyWindowInsets() {
        return Flowable.create(emitter -> {
            for (Info vi : getViewInfos()) {
                if (vi.isEffect()) {
                    vi.getView().setOnApplyWindowInsetsListener((v, insets) -> {
                        OnApplyWindowInsetsInfo info = new OnApplyWindowInsetsInfo(v, insets);
                        emitter.onNext(info);
                        return info.getReturnValue();
                    });
                }
            }
        }, RxListener.getListenerBackpressureStrategy());

    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT_WATCH)
    public void removeApplyWindowInsets() {
        for (Info vi : getViewInfos()) {
            if (vi.isEffect()) {
                vi.getView().setOnApplyWindowInsetsListener(null);
            }
        }
    }

    public Flowable<OnAttachStateChangeInfo> onAttachStateChange() {
        return Flowable.create(emitter -> {
            for (Info vi : getViewInfos()) {
                if (vi.isEffect()) {
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
            }
        }, RxListener.getListenerBackpressureStrategy());
    }

    public void removeAttachStateChange() {
        for (Info vi : getViewInfos()) {
            if (vi.isEffect()) {
                for (View.OnAttachStateChangeListener listener : vi.getOnAttachStateChangeListeners()) {
                    vi.getView().removeOnAttachStateChangeListener(listener);
                }
                vi.getOnAttachStateChangeListeners().clear();
            }
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public Flowable<OnCapturedPointerInfo> onCapturedPointer() {
        return Flowable.create(emitter -> {
            for (Info vi : getViewInfos()) {
                if (vi.isEffect()) {
                    vi.getView().setOnCapturedPointerListener((v, event) -> {
                        OnCapturedPointerInfo info = new OnCapturedPointerInfo(v, event);
                        emitter.onNext(info);
                        return info.getReturnValue();
                    });
                }
            }
        }, RxListener.getListenerBackpressureStrategy());
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void removeCapturedPointer() {
        for (Info vi : getViewInfos()) {
            if (vi.isEffect()) {
                vi.getView().setOnCapturedPointerListener(null);
            }
        }
    }

    public Flowable<View> onClick() {
        return Flowable.create(emitter -> {
            for (Info vi : getViewInfos()) {
                if (vi.isEffect()) {
                    vi.getView().setOnClickListener(emitter::onNext);
                }
            }
        }, RxListener.getListenerBackpressureStrategy());
    }

    public void removeClick() {
        for (Info vi : getViewInfos()) {
            if (vi.isEffect()) {
                vi.getView().setOnClickListener(null);
            }
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public Flowable<OnContextClickInfo> onContextClick() {
        return Flowable.create(emitter -> {
            for (Info vi : getViewInfos()) {
                if (vi.isEffect()) {
                    vi.getView().setOnContextClickListener(v -> {
                        OnContextClickInfo info = new OnContextClickInfo(v);
                        emitter.onNext(info);
                        return info.getReturnValue();
                    });
                }
            }
        }, RxListener.getListenerBackpressureStrategy());
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void removeContextClick() {
        for (Info vi : getViewInfos()) {
            if (vi.isEffect()) {
                vi.getView().setOnContextClickListener(null);
            }
        }
    }

    public Flowable<OnCreateContextMenuInfo> onCreateContextMenu() {
        return Flowable.create(emitter -> {
            for (Info vi : getViewInfos()) {
                if (vi.isEffect()) {
                    vi.getView().setOnCreateContextMenuListener((menu, v, menuInfo) ->
                            emitter.onNext(new OnCreateContextMenuInfo(menu, v, menuInfo))
                    );
                }
            }
        }, RxListener.getListenerBackpressureStrategy());
    }

    public void removeCreateContextMenu() {
        for (Info vi : getViewInfos()) {
            if (vi.isEffect()) {
                vi.getView().setOnCreateContextMenuListener(null);
            }
        }
    }

    public Flowable<OnDragInfo> onDrag() {
        return Flowable.create(emitter -> {
            for (Info vi : getViewInfos()) {
                if (vi.isEffect()) {
                    vi.getView().setOnDragListener((v, event) -> {
                        OnDragInfo info = new OnDragInfo(v, event);
                        emitter.onNext(info);
                        return info.getReturnValue();
                    });
                }
            }
        }, RxListener.getListenerBackpressureStrategy());
    }

    public void removeDrag() {
        for (Info vi : getViewInfos()) {
            if (vi.isEffect()) {
                vi.getView().setOnDragListener(null);
            }
        }
    }

    public Flowable<OnFocusChangeInfo> onFocusChange() {
        return Flowable.create(emitter -> {
            for (Info vi : getViewInfos()) {
                if (vi.isEffect()) {
                    vi.getView().setOnFocusChangeListener((v, hasFocus) -> emitter.onNext(new OnFocusChangeInfo(v, hasFocus)));
                }
            }
        }, RxListener.getListenerBackpressureStrategy());
    }

    public void removeFocusChange() {
        for (Info vi : getViewInfos()) {
            if (vi.isEffect()) {
                vi.getView().setOnFocusChangeListener(null);
            }
        }
    }

    public Flowable<OnGenericMotionInfo> onGenericMotion() {
        return Flowable.create(emitter -> {
            for (Info vi : getViewInfos()) {
                if (vi.isEffect()) {
                    vi.getView().setOnGenericMotionListener((v, event) -> {
                        OnGenericMotionInfo info = new OnGenericMotionInfo(v, event);
                        emitter.onNext(info);
                        return info.getReturnValue();
                    });
                }
            }
        }, RxListener.getListenerBackpressureStrategy());
    }

    public void removeGenericMotion() {
        for (Info vi : getViewInfos()) {
            if (vi.isEffect()) {
                vi.getView().setOnGenericMotionListener(null);
            }
        }
    }

    public Flowable<OnHoverInfo> onHover() {
        return Flowable.create(emitter -> {
            for (Info vi : getViewInfos()) {
                if (vi.isEffect()) {
                    vi.getView().setOnHoverListener((v, event) -> {
                        OnHoverInfo info = new OnHoverInfo(v, event);
                        emitter.onNext(info);
                        return info.getReturnValue();
                    });
                }
            }
        }, RxListener.getListenerBackpressureStrategy());
    }

    public void removeHover() {
        for (Info vi : getViewInfos()) {
            if (vi.isEffect()) {
                vi.getView().setOnHoverListener(null);
            }
        }
    }

    public Flowable<OnKeyInfo> onKey() {
        return Flowable.create(emitter -> {
            for (Info vi : getViewInfos()) {
                if (vi.isEffect()) {
                    vi.getView().setOnKeyListener((v, keyCode, event) -> {
                        OnKeyInfo info = new OnKeyInfo(v, keyCode, event);
                        emitter.onNext(info);
                        return info.getReturnValue();
                    });
                }
            }
        }, RxListener.getListenerBackpressureStrategy());
    }

    public void removeKey() {
        for (Info vi : getViewInfos()) {
            if (vi.isEffect()) {
                vi.getView().setOnKeyListener(null);
            }
        }
    }

    public Flowable<OnLayoutChangeInfo> onLayoutChange() {
        return Flowable.create(emitter -> {
            for (Info vi : getViewInfos()) {
                if (vi.isEffect()) {
                    View.OnLayoutChangeListener listener = (v, left, top, right, bottom, oldLeft, oldTop, oldRight, oldBottom) ->
                            emitter.onNext(new OnLayoutChangeInfo(v, left, top, right, bottom, oldLeft, oldTop, oldRight, oldBottom));
                    vi.getView().addOnLayoutChangeListener(listener);
                    vi.getOnLayoutChangeListeners().add(listener);
                }
            }
        }, RxListener.getListenerBackpressureStrategy());
    }

    public void removeLayoutChange() {
        for (Info vi : getViewInfos()) {
            if (vi.isEffect()) {
                for (View.OnLayoutChangeListener listener : vi.getOnLayoutChangeListeners()) {
                    vi.getView().removeOnLayoutChangeListener(listener);
                }
                vi.getOnLayoutChangeListeners().clear();
            }
        }
    }

    public Flowable<OnLongClickInfo> onLongClick() {
        return Flowable.create(emitter -> {
            for (Info vi : getViewInfos()) {
                if (vi.isEffect()) {
                    vi.getView().setOnLongClickListener(v -> {
                        OnLongClickInfo info = new OnLongClickInfo(v);
                        emitter.onNext(info);
                        return info.getReturnValue();
                    });
                }
            }
        }, RxListener.getListenerBackpressureStrategy());
    }

    public void removeLongClick() {
        for (Info vi : getViewInfos()) {
            if (vi.isEffect()) {
                vi.getView().setOnLongClickListener(null);
            }
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public Flowable<OnScrollChangeInfo> onScrollChange() {
        return Flowable.create(emitter -> {
            for (Info vi : getViewInfos()) {
                if (vi.isEffect()) {
                    vi.getView().setOnScrollChangeListener((v, scrollX, scrollY, oldScrollX, oldScrollY) ->
                            emitter.onNext(new OnScrollChangeInfo(v, scrollX, scrollY, oldScrollX, oldScrollY)));
                }
            }
        }, RxListener.getListenerBackpressureStrategy());
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void removeScrollChange() {
        for (Info vi : getViewInfos()) {
            if (vi.isEffect()) {
                vi.getView().setOnScrollChangeListener(null);
            }
        }
    }

    public Flowable<Integer> onSystemUiVisibilityChange() {
        return Flowable.create(emitter -> {
            for (Info vi : getViewInfos()) {
                if (vi.isEffect()) {
                    vi.getView().setOnSystemUiVisibilityChangeListener(emitter::onNext);
                }
            }
        }, RxListener.getListenerBackpressureStrategy());
    }

    public void removeSystemUiVisibilityChange() {
        for (Info vi : getViewInfos()) {
            if (vi.isEffect()) {
                vi.getView().setOnSystemUiVisibilityChangeListener(null);
            }
        }
    }

    @SuppressLint("ClickableViewAccessibility")
    public Flowable<OnTouchInfo> onTouch() {
        return Flowable.create(emitter -> {
            for (Info vi : getViewInfos()) {
                if (vi.isEffect()) {
                    vi.getView().setOnTouchListener((v, event) -> {
                        OnTouchInfo info = new OnTouchInfo(v, event);
                        emitter.onNext(info);
                        return info.getReturnValue();
                    });
                }
            }
        }, RxListener.getListenerBackpressureStrategy());
    }

    @SuppressLint("ClickableViewAccessibility")
    public void removeTouch() {
        for (Info vi : getViewInfos()) {
            if (vi.isEffect()) {
                vi.getView().setOnTouchListener(null);
            }
        }
    }

}

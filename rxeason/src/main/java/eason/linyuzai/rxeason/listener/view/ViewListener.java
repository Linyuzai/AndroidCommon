package eason.linyuzai.rxeason.listener.view;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.View;

import io.reactivex.Flowable;

@Deprecated
public interface ViewListener {

    @RequiresApi(api = Build.VERSION_CODES.KITKAT_WATCH)
    Flowable<OnApplyWindowInsetsInfo> onApplyWindowInsets();

    @RequiresApi(api = Build.VERSION_CODES.KITKAT_WATCH)
    void removeApplyWindowInsets();

    @RequiresApi(api = Build.VERSION_CODES.O)
    Flowable<OnCapturedPointerInfo> onCapturedPointer();

    @RequiresApi(api = Build.VERSION_CODES.O)
    void removeCapturedPointer();

    Flowable<View> onClick();

    void removeClick();

    @RequiresApi(api = Build.VERSION_CODES.M)
    Flowable<OnContextClickInfo> onContextClick();

    @RequiresApi(api = Build.VERSION_CODES.M)
    void removeContextClick();

    Flowable<OnCreateContextMenuInfo> onCreateContextMenu();

    void removeCreateContextMenu();

    Flowable<OnDragInfo> onDrag();

    void removeDrag();

    Flowable<OnFocusChangeInfo> onFocusChange();

    void removeFocusChange();

    Flowable<OnGenericMotionInfo> onGenericMotion();

    void removeGenericMotion();

    Flowable<OnHoverInfo> onHover();

    void removeHover();

    Flowable<OnKeyInfo> onKey();

    void removeKey();

    public Flowable<OnLongClickInfo> onLongClick();

    void removeLongClick();

    @RequiresApi(api = Build.VERSION_CODES.M)
    Flowable<OnScrollChangeInfo> onScrollChange();

    @RequiresApi(api = Build.VERSION_CODES.M)
    void removeScrollChange();
}

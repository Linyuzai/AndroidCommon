package eason.linyuzai.androidcommon;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.widget.ScrollView;

public class EScrollView extends ScrollView {
    public OnScrollChangedListener listener;

    public EScrollView(Context context) {
        super(context);
    }

    public EScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public EScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public EScrollView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        if (listener != null)
            listener.onScroll(l, t);
    }

    public interface OnScrollChangedListener {
        void onScroll(int l, int t);
    }
}

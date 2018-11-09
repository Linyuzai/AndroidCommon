package eason.linyuzai.easonicon.extension;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;

@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class DstInImageView extends EasonImageView {
    public DstInImageView(Context context) {
        super(context);
    }

    public DstInImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DstInImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void init(Context context, AttributeSet attrs, Paint paint) {
        super.init(context, attrs, paint);
        paint.setStyle(Paint.Style.FILL);
        setMode(PorterDuff.Mode.DST_IN);
    }
}

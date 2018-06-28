package eason.linyuzai.easonicon.extension;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;

import eason.linyuzai.easonicon.painter.basic.circle.OvalPainter;

@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class OvalImageView extends EasonImageView {
    public OvalImageView(Context context) {
        super(context);
    }

    public OvalImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public OvalImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public OvalImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void init(Context context, AttributeSet attrs, Paint paint) {
        super.init(context, attrs, paint);
        paint.setStyle(Paint.Style.FILL);
        setPainter(new OvalPainter());
        setMode(PorterDuff.Mode.DST_IN);
    }
}

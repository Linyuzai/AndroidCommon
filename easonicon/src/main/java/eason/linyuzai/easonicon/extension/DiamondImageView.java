package eason.linyuzai.easonicon.extension;

import android.content.Context;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;

import eason.linyuzai.easonicon.painter.basic.polygon.PolygonPainter;

@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class DiamondImageView extends DstInImageView {
    public DiamondImageView(Context context) {
        super(context);
    }

    public DiamondImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DiamondImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public DiamondImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void init(Context context, AttributeSet attrs, Paint paint) {
        super.init(context, attrs, paint);
        setPainter(new PolygonPainter(4));
    }
}

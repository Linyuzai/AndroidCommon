package eason.linyuzai.easonicon.extension;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;

import eason.linyuzai.easonicon.R;
import eason.linyuzai.easonicon.painter.basic.rect.RectPainter;

@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class RectImageView extends DstInImageView {

    private RectPainter rectPainter;

    public RectImageView(Context context) {
        super(context);
    }

    public RectImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public RectImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public RectImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void init(Context context, AttributeSet attrs, Paint paint) {
        super.init(context, attrs, paint);
        rectPainter = new RectPainter();
        if (attrs != null) {
            TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.RectImageView);
            float radius = a.getDimension(R.styleable.RectImageView_round_radius, 0f);
            setRadius(radius);
            a.recycle();
        }
        setPainter(rectPainter);
    }

    public void setRadius(float radius) {
        rectPainter.setRoundAll(radius);
    }
}

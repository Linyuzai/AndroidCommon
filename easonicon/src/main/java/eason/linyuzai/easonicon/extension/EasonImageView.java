package eason.linyuzai.easonicon.extension;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.RectF;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import eason.linyuzai.easonicon.open.Painter;
import eason.linyuzai.easonicon.open.PainterInterceptor;
import eason.linyuzai.easonicon.open.PainterSet;
import eason.linyuzai.easonicon.painter.interceptor.mode.PorterDuffModeInterceptor;

@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
@SuppressLint("AppCompatCustomView")
public class EasonImageView extends ImageView {

    private Paint paint = new Paint();
    private RectF draw = new RectF();
    private RectF original = new RectF();

    private Painter painter;

    private PorterDuffModeInterceptor modeInterceptor = new PorterDuffModeInterceptor() {

        @Override
        protected boolean ifRestoreMode(Painter painter, int index) {
            return true;
        }

        @Override
        protected boolean ifRestoreCanvas(Painter painter, int index) {
            return true;
        }
    };

    private List<PainterInterceptor> interceptors = new ArrayList<>();

    public EasonImageView(Context context) {
        super(context);
        init(context, null, paint);
    }

    public EasonImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, paint);
    }

    public EasonImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, paint);
    }

    public EasonImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context, attrs, paint);
    }

    protected void init(Context context, AttributeSet attrs, Paint paint) {
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);
    }

    public Painter getPainter() {
        return painter;
    }

    public void setPainter(Painter painter) {
        this.painter = painter;
    }

    public PorterDuff.Mode getMode() {
        return modeInterceptor.getMode();
    }

    public void setMode(PorterDuff.Mode mode) {
        modeInterceptor.setMode(mode);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        modeInterceptor.beforeDraw(painter, canvas, paint, draw, 0);
        super.onDraw(canvas);
        modeInterceptor.beforeDraw(painter, canvas, paint, draw, 1);
        if (painter != null) {
            final Bitmap bitmap = painter.transformBitmap(draw, original, paint);
            painter.drawBitmap(canvas, bitmap, draw, original, modeInterceptor.getPaint());
        }
        modeInterceptor.afterDraw(painter, canvas, paint, draw, 1);
    }

    public List<PainterInterceptor> getInterceptors() {
        return interceptors;
    }

    public void addInterceptor(PainterInterceptor interceptor) {
        addInterceptor(interceptor, false);
    }

    public void addInterceptor(PainterInterceptor interceptor, boolean recursiveSet) {
        interceptors.add(interceptor);
        if (recursiveSet) {
            if (painter instanceof PainterSet) {
                ((PainterSet) painter).addInterceptor(interceptor, true);
            }
        }
    }

    public void removeInterceptor(PainterInterceptor interceptor) {
        removeInterceptor(interceptor, false);
    }

    public void removeInterceptor(PainterInterceptor interceptor, boolean recursiveSet) {
        interceptors.remove(interceptor);
        if (recursiveSet) {
            if (painter instanceof PainterSet) {
                ((PainterSet) painter).removeInterceptor(interceptor, true);
            }
        }
    }

    public void clearInterceptor() {
        clearInterceptor(false);
    }

    public void clearInterceptor(boolean recursiveSet) {
        interceptors.clear();
        if (recursiveSet) {
            if (painter instanceof PainterSet) {
                ((PainterSet) painter).clearInterceptor(true);
            }
        }
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        int top = getPaddingTop();
        int bottom = h - getPaddingBottom();
        int left = getPaddingLeft();
        int right = w - getPaddingRight();
        original.set(0f, 0f, w, h);
        draw.set(left, top, right, bottom);
    }
}

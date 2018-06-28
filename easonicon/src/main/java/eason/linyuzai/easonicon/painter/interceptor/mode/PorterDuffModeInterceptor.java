package eason.linyuzai.easonicon.painter.interceptor.mode;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.os.Build;
import android.support.annotation.RequiresApi;

import eason.linyuzai.easonicon.open.Painter;
import eason.linyuzai.easonicon.open.PainterInterceptor;

@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class PorterDuffModeInterceptor implements PainterInterceptor {

    private PorterDuff.Mode mode;
    private Xfermode xfermode;

    private Paint paint = new Paint();

    private int layerId;

    public PorterDuffModeInterceptor() {

    }

    public PorterDuffModeInterceptor(PorterDuff.Mode mode) {
        setMode(mode);
    }

    public void setMode(PorterDuff.Mode mode) {
        this.mode = mode;
        xfermode = new PorterDuffXfermode(mode);
    }

    public PorterDuff.Mode getMode() {
        return mode;
    }

    @Override
    public void beforeDraw(Painter painter, Canvas canvas, Paint paint, RectF rectF, int index) {
        if (ifSaveCanvas(painter, index))
            canvas.saveLayer(rectF, paint);
        if (xfermode != null && ifSetMode(painter, index))
            this.paint.setXfermode(xfermode);
    }

    @Override
    public void afterDraw(Painter painter, Canvas canvas, Paint paint, RectF rectF, int index) {
        if (ifRestoreMode(painter, index))
            paint.setXfermode(null);
        if (ifRestoreCanvas(painter, index))
            canvas.restore();
    }

    public Paint getPaint() {
        return paint;
    }

    /**
     * 绘制者绘制之前是否新建图层
     *
     * @param painter 绘制者
     * @return 是否新建图层
     */
    protected boolean ifSaveCanvas(Painter painter, int index) {
        return index == 0;
    }

    /**
     * 绘制者绘制之后是否合成图层
     *
     * @param painter 绘制者
     * @return 是否合成图层
     */
    protected boolean ifRestoreCanvas(Painter painter, int index) {
        return index == 1;
    }

    /**
     * 绘制者绘制之前是否设置mode
     *
     * @param painter 绘制者
     * @return 是否设置mode
     */
    protected boolean ifSetMode(Painter painter, int index) {
        return index == 1;
    }

    /**
     * 绘制者绘制之后是否清除mode
     *
     * @param painter 绘制者
     * @return 是否清除mode
     */
    protected boolean ifRestoreMode(Painter painter, int index) {
        return index == 1;
    }
}

package eason.linyuzai.androidcommon;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

import eason.linyuzai.easonicon.painter.combine.AddPainter;
import eason.linyuzai.easonicon.painter.basic.circle.OvalPainter;

public class EView extends View {

    private int width;
    private int height;

    private Paint paint = new Paint();
    private RectF rectF = new RectF();

    public EView(Context context) {
        super(context);
    }

    public EView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @SuppressLint({"DrawAllocation", "WrongConstant"})
    @Override
    protected void onDraw(Canvas canvas) {
        setLabelFor(View.LAYER_TYPE_SOFTWARE);
        /*canvas.saveLayer(0, 0, width, height, null,
                Canvas.MATRIX_SAVE_FLAG |
                        Canvas.CLIP_SAVE_FLAG |
                        Canvas.HAS_ALPHA_LAYER_SAVE_FLAG |
                        Canvas.FULL_COLOR_LAYER_SAVE_FLAG |
                        Canvas.CLIP_TO_LAYER_SAVE_FLAG);*/
        canvas.saveLayer(0, 0, width, height, null);

        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.YELLOW);
        paint.setStrokeWidth(20);
        //canvas.drawCircle(width / 3, height / 3, width / 3, paint);
        //canvas.drawBitmap(new RoundRectPainter(50).transformBitmap(rectF, rectF, paint), null, rectF, paint);
        Paint xPaint = new Paint();
        canvas.drawBitmap(new OvalPainter().transformBitmap(rectF, rectF, paint), 0, 0, xPaint);
        paint.setColor(Color.BLUE);

        //canvas.drawRect(width / 3, height / 3, width, height, paint);
        //canvas.drawLine(0, 0, width, height, paint);

        xPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.XOR));
        canvas.drawBitmap(new AddPainter().transformBitmap(rectF, rectF, paint), 0, 0, xPaint);
        //canvas.drawBitmap(new OvalPainter().transformBitmap(rectF, rectF, paint), null, rectF, paint);
        //canvas.drawBitmap(new AddPainter().transformBitmap(rectF, rectF, paint), null, rectF, paint);
        paint.setXfermode(null);
        canvas.restore();
    }

    private Bitmap getCircle() {
        Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        canvas.drawCircle(width / 3, height / 3, width / 3, paint);
        return bitmap;
    }

    private Bitmap getRect() {
        Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        canvas.drawRect(width / 3, height / 3, width, height, paint);
        return bitmap;
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        width = w;
        height = h;
        rectF.right = w;
        rectF.bottom = h;
    }
}

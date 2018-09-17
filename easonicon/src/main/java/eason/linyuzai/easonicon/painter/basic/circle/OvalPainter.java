package eason.linyuzai.easonicon.painter.basic.circle;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

import eason.linyuzai.easonicon.painter.EasonPainter;

/**
 * Created by linyuzai on 2018/5/21.
 * （椭）圆
 *
 * @author linyuzai
 */

public class OvalPainter extends EasonPainter {

    @Override
    public void draw(Canvas canvas, RectF draw, RectF original, Paint paint) {
        canvas.drawOval(getRectF(draw, paint), paint);
    }
}

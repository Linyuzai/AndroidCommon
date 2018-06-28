package eason.linyuzai.easonicon.painter.basic.rect;

import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;

import eason.linyuzai.easonicon.annotation.RoundField;
import eason.linyuzai.easonicon.painter.basic.path.PathPainter;

public class RectPainter extends PathPainter {

    private float[] radii = new float[8];

    public RectPainter() {
    }

    public RectPainter(@RoundField float leftTop, @RoundField float leftBottom, @RoundField float rightTop,
                       @RoundField float rightBottom) {
        setLeftTop(leftTop);
        setLeftBottom(leftBottom);
        setRightTop(rightTop);
        setRightBottom(rightBottom);
    }

    @Override
    public void configurePath(Path path, RectF draw, RectF original, Paint paint) {
        path.addRoundRect(getTransformRectF(draw, paint), radii, Path.Direction.CW);
    }

    public void setRoundAll(@RoundField float r) {
        setRoundAll(r, r);
    }

    public void setRoundAll(@RoundField float x, @RoundField float y) {
        setTop(x, y);
        setBottom(x, y);
    }

    public void setTop(@RoundField float r) {
        setTop(r, r);
    }

    public void setTop(@RoundField float x, @RoundField float y) {
        setLeftTop(x, y);
        setRightTop(x, y);
    }

    public void setLeft(@RoundField float r) {
        setLeft(r, r);
    }

    public void setLeft(@RoundField float x, @RoundField float y) {
        setLeftTop(x, y);
        setLeftBottom(x, y);
    }

    public void setRight(@RoundField float r) {
        setRight(r, r);
    }

    public void setRight(@RoundField float x, @RoundField float y) {
        setRightTop(x, y);
        setRightBottom(x, y);
    }

    public void setBottom(@RoundField float r) {
        setBottom(r, r);
    }

    public void setBottom(@RoundField float x, @RoundField float y) {
        setLeftBottom(x, y);
        setRightBottom(x, y);
    }

    public void setLeftTop(@RoundField float r) {
        setLeftTop(r, r);
    }

    public void setLeftTop(@RoundField float x, @RoundField float y) {
        radii[0] = x;
        radii[1] = y;
    }

    public void setRightTop(@RoundField float r) {
        setRightTop(r, r);
    }

    public void setRightTop(@RoundField float x, @RoundField float y) {
        radii[2] = x;
        radii[3] = y;
    }

    public void setLeftBottom(@RoundField float r) {
        setLeftBottom(r, r);
    }

    public void setLeftBottom(@RoundField float x, @RoundField float y) {
        radii[6] = x;
        radii[7] = y;
    }

    public void setRightBottom(@RoundField float r) {
        setRightBottom(r, r);
    }

    public void setRightBottom(@RoundField float x, @RoundField float y) {
        radii[4] = x;
        radii[5] = y;
    }

    public void setLeftTopRightBottom(@RoundField float r) {
        setLeftTopRightBottom(r, r);
    }

    public void setLeftTopRightBottom(@RoundField float x, @RoundField float y) {
        setLeftTop(x, y);
        setRightBottom(x, y);
    }

    public void setRightTopLeftBottom(@RoundField float r) {
        setRightTopLeftBottom(r, r);
    }

    public void setRightTopLeftBottom(@RoundField float x, @RoundField float y) {
        setRightTop(x, y);
        setLeftBottom(x, y);
    }
}

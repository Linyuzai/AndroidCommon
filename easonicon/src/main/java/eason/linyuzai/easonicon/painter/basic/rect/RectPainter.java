package eason.linyuzai.easonicon.painter.basic.rect;

import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;

import eason.linyuzai.easonicon.annotation.RoundRectField;
import eason.linyuzai.easonicon.painter.basic.path.PathPainter;

@RoundRectField
public class RectPainter extends PathPainter {

    private float[] radii = new float[8];

    public RectPainter() {
    }

    public RectPainter(float leftTop, float leftBottom, float rightTop, float rightBottom) {
        setLeftTop(leftTop);
        setLeftBottom(leftBottom);
        setRightTop(rightTop);
        setRightBottom(rightBottom);
    }

    @Override
    public void configurePath(Path path, RectF draw, RectF original, Paint paint) {
        path.addRoundRect(getTransformRectF(draw, paint), radii, Path.Direction.CW);
    }

    public void setRoundAll(float r) {
        setRoundAll(r, r);
    }

    public void setRoundAll(float x, float y) {
        setTop(x, y);
        setBottom(x, y);
    }

    public void setTop(float r) {
        setTop(r, r);
    }

    public void setTop(float x, float y) {
        setLeftTop(x, y);
        setRightTop(x, y);
    }

    public void setLeft(float r) {
        setLeft(r, r);
    }

    public void setLeft(float x, float y) {
        setLeftTop(x, y);
        setLeftBottom(x, y);
    }

    public void setRight(float r) {
        setRight(r, r);
    }

    public void setRight(float x, float y) {
        setRightTop(x, y);
        setRightBottom(x, y);
    }

    public void setBottom(float r) {
        setBottom(r, r);
    }

    public void setBottom(float x, float y) {
        setLeftBottom(x, y);
        setRightBottom(x, y);
    }

    public void setLeftTop(float r) {
        setLeftTop(r, r);
    }

    public void setLeftTop(float x, float y) {
        radii[0] = x;
        radii[1] = y;
    }

    public void setRightTop(float r) {
        setRightTop(r, r);
    }

    public void setRightTop(float x, float y) {
        radii[2] = x;
        radii[3] = y;
    }

    public void setLeftBottom(float r) {
        setLeftBottom(r, r);
    }

    public void setLeftBottom(float x, float y) {
        radii[6] = x;
        radii[7] = y;
    }

    public void setRightBottom(float r) {
        setRightBottom(r, r);
    }

    public void setRightBottom(float x, float y) {
        radii[4] = x;
        radii[5] = y;
    }

    public void setLeftTopRightBottom(float r) {
        setLeftTopRightBottom(r, r);
    }

    public void setLeftTopRightBottom(float x, float y) {
        setLeftTop(x, y);
        setRightBottom(x, y);
    }

    public void setRightTopLeftBottom(float r) {
        setRightTopLeftBottom(r, r);
    }

    public void setRightTopLeftBottom(float x, float y) {
        setRightTop(x, y);
        setLeftBottom(x, y);
    }
}

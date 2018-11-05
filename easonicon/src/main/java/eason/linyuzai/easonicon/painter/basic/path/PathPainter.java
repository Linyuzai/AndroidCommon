package eason.linyuzai.easonicon.painter.basic.path;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;

import eason.linyuzai.easonicon.painter.EasonPainter;

public abstract class PathPainter extends EasonPainter {

    private Path path = new Path();

    @Override
    public void draw(Canvas canvas, RectF draw, RectF original, Paint paint) {
        path.reset();
        configurePath(path, draw, original, paint);
        canvas.drawPath(path, paint);
    }

    public void addPath(Path path) {
        this.path.addPath(path);
    }

    public Path getPath() {
        return path;
    }

    public abstract void configurePath(Path path, RectF draw, RectF original, Paint paint);
}

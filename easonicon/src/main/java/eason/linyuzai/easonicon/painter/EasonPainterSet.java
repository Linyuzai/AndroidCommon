package eason.linyuzai.easonicon.painter;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import eason.linyuzai.easonicon.open.Painter;
import eason.linyuzai.easonicon.open.PainterInterceptor;
import eason.linyuzai.easonicon.open.PainterSet;
import eason.linyuzai.easonicon.painter.interceptor.mode.PorterDuffModeInterceptor;
import eason.linyuzai.easonicon.painter.interceptor.rect.PainterSetRectSupportInterceptor;

/**
 * Created by linyuzai on 2018/5/21.
 * 绘制组
 *
 * @author linyuzai
 */

public class EasonPainterSet extends EasonPainter implements PainterSet {

    private boolean isFillHue;

    private List<Painter> painters = new ArrayList<>();

    private List<PainterInterceptor> interceptors = new ArrayList<>();

    private PainterSetRectSupportInterceptor rectSupportInterceptor = new PainterSetRectSupportInterceptor();

    @Override
    public List<Painter> getPainters() {
        return painters;
    }

    @Override
    public Painter getPainter(int index) {
        return painters.get(index);
    }

    /**
     * 添加绘制者
     *
     * @param painter 绘制者
     */
    @Override
    public void addPainter(Painter painter) {
        painters.add(painter);
    }

    /**
     * 添加绘制者
     *
     * @param index   位置
     * @param painter 绘制者
     */
    @Override
    public void addPainter(int index, Painter painter) {
        painters.add(index, painter);
    }

    /**
     * 移除绘制者
     *
     * @param painter 绘制者
     */
    @Override
    public void removePainter(Painter painter) {
        painters.remove(painter);
    }

    /**
     * 移除绘制者
     *
     * @param index 位置
     */
    @Override
    public void removePainter(int index) {
        painters.remove(index);
    }

    /**
     * 清除绘制者
     */
    @Override
    public void clearPainter() {
        painters.clear();
    }

    /**
     * 获得拦截器
     *
     * @return 拦截器List
     */
    public List<PainterInterceptor> getInterceptors() {
        return interceptors;
    }

    /**
     * 添加拦截器
     *
     * @param interceptor 拦截器
     */
    @Override
    public void addInterceptor(PainterInterceptor interceptor) {
        addInterceptor(interceptor, false);
    }

    /**
     * 添加拦截器
     *
     * @param interceptor  拦截器
     * @param recursiveSet 是否循环添加所有绘制组
     */
    @Override
    public void addInterceptor(PainterInterceptor interceptor, boolean recursiveSet) {
        interceptors.add(interceptor);
        if (recursiveSet) {
            for (Painter painter : painters) {
                if (painter.isPainterSet()) {
                    painter.toPainterSet().addInterceptor(interceptor, true);
                }
            }
        }
    }

    @Override
    public void removeInterceptor(PainterInterceptor interceptor) {
        removeInterceptor(interceptor, false);
    }

    @Override
    public void removeInterceptor(PainterInterceptor interceptor, boolean recursiveSet) {
        interceptors.remove(interceptor);
        if (recursiveSet) {
            for (Painter painter : painters) {
                if (painter.isPainterSet()) {
                    painter.toPainterSet().removeInterceptor(interceptor, true);
                }
            }
        }
    }

    @Override
    public void clearInterceptor() {
        clearInterceptor(false);
    }

    @Override
    public void clearInterceptor(boolean recursiveSet) {
        interceptors.clear();
        if (recursiveSet) {
            for (Painter painter : painters) {
                if (painter.isPainterSet()) {
                    painter.toPainterSet().clearInterceptor(true);
                }
            }
        }
    }

    @Override
    public boolean isFillHue() {
        return isFillHue;
    }

    @Override
    public void fillHue(boolean fill) {
        isFillHue = fill;
        for (Painter painter : painters) {
            if (painter.isPainterSet()) {
                painter.toPainterSet().fillHue(fill);
            }
        }
    }

    @Override
    public void draw(Canvas canvas, RectF draw, RectF original, Paint paint) {
        boolean xmodeFlag = false;
        Paint modePaint = null;
        for (int index = 0; index < painters.size(); index++) {
            Painter painter = painters.get(index);
            if (null == painter || !painter.canDraw())
                continue;
            rectSupportInterceptor.beforeDraw(painter, draw, index);
            for (PainterInterceptor interceptor : interceptors) {
                if (null == interceptor || !isFillHue && interceptor.isHueFiller())
                    continue;
                if (interceptor instanceof PorterDuffModeInterceptor) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        xmodeFlag = true;
                        modePaint = ((PorterDuffModeInterceptor) interceptor).getPaint();
                    }
                }
                interceptor.beforeDraw(painter, canvas, paint, draw, index);
            }
            //painter.draw(canvas, draw, original, paint);
            if (xmodeFlag) {
                final Bitmap bitmap = painter.transformBitmap(draw, original, paint);
                painter.drawBitmap(canvas, bitmap, draw, original, modePaint);
            } else {
                painter.draw(canvas, draw, original, paint);
            }
            for (PainterInterceptor interceptor : interceptors) {
                if (null == interceptor || !isFillHue && interceptor.isHueFiller())
                    continue;
                interceptor.afterDraw(painter, canvas, paint, draw, index);
            }
            rectSupportInterceptor.afterDraw(painter, draw, index);
        }
    }

    @Override
    public void setOffsetPercentX(float offsetPercentX) {
        rectSupportInterceptor.setOffsetPercentX(offsetPercentX);
    }

    @Override
    public void setOffsetPercentY(float offsetPercentY) {
        rectSupportInterceptor.setOffsetPercentY(offsetPercentY);
    }

    @Override
    public void setOffsetX(float offsetX) {
        rectSupportInterceptor.setOffsetX(offsetX);
    }

    @Override
    public void setOffsetY(float offsetY) {
        rectSupportInterceptor.setOffsetY(offsetY);
    }

    @Override
    public void setPercentX(float percentX) {
        rectSupportInterceptor.setPercentX(percentX);
    }

    @Override
    public void setPercentY(float percentY) {
        rectSupportInterceptor.setPercentY(percentY);
    }

    @Override
    public void recursivePainter(OnRecursivePainterCallback callback) {
        for (Painter painter : painters) {
            callback.onPainterRecursive(painter);
            if (painter.isPainterSet()) {
                painter.toPainterSet().recursivePainter(callback);
            }
        }
    }

    @Override
    public void printStructure(int deep, boolean includeInterceptor) {
        super.printStructure(deep, includeInterceptor);
        StringBuilder space = new StringBuilder();
        for (int i = 0; i < deep; i++) {
            space.append("    ");
        }
        if (includeInterceptor) {
            StringBuilder inter = new StringBuilder();
            for (int j = 0; j < interceptors.size(); j++) {
                if (j != 0) {
                    inter.append(",");
                }
                inter.append(interceptors.get(j).getClass().toString());
            }
            Log.i("printStructure", space.toString() + "(" + inter.toString() + ")");
        }
        Log.i("printStructure", space.toString() + "{");
        for (Painter painter : painters) {
            painter.printStructure(deep + 1, includeInterceptor);
        }
        Log.i("printStructure", space.toString() + "}");
    }
}

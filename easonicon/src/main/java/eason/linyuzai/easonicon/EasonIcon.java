package eason.linyuzai.easonicon;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.CornerPathEffect;
import android.graphics.Paint;
import android.graphics.PathEffect;
import android.graphics.RectF;
import android.os.Build;
import android.support.annotation.ColorInt;
import android.support.annotation.Nullable;
import android.support.annotation.Px;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

import eason.linyuzai.easonicon.annotation.ArcField;
import eason.linyuzai.easonicon.annotation.AuxiliaryColorField;
import eason.linyuzai.easonicon.annotation.AuxiliaryScaleField;
import eason.linyuzai.easonicon.annotation.BitmapField;
import eason.linyuzai.easonicon.annotation.PolygonField;
import eason.linyuzai.easonicon.annotation.RoundField;
import eason.linyuzai.easonicon.open.Painter;
import eason.linyuzai.easonicon.painter.EasonPainterSet;
import eason.linyuzai.easonicon.painter.combine.AddHollowOvalPainter;
import eason.linyuzai.easonicon.painter.combine.AddPainter;
import eason.linyuzai.easonicon.painter.combine.AddSolidOvalPainter;
import eason.linyuzai.easonicon.painter.combine.BackPainter;
import eason.linyuzai.easonicon.painter.combine.CorrectPainter;
import eason.linyuzai.easonicon.painter.combine.ErrorPainter;
import eason.linyuzai.easonicon.painter.basic.arc.ArcPainter;
import eason.linyuzai.easonicon.painter.basic.bitmap.BitmapPainter;
import eason.linyuzai.easonicon.painter.basic.circle.CirclePainter;
import eason.linyuzai.easonicon.painter.basic.circle.OvalPainter;
import eason.linyuzai.easonicon.painter.basic.line.HorizontalLinePainter;
import eason.linyuzai.easonicon.painter.basic.line.SlopeNegativeLinePainter;
import eason.linyuzai.easonicon.painter.basic.line.SlopePositiveLinePainter;
import eason.linyuzai.easonicon.painter.basic.line.VerticalLinePainter;
import eason.linyuzai.easonicon.painter.basic.polygon.ExtraPolygonPainter;
import eason.linyuzai.easonicon.painter.basic.polygon.PolygonPainter;
import eason.linyuzai.easonicon.painter.basic.polygon.QuadPolygonPainter;
import eason.linyuzai.easonicon.painter.basic.rect.RectPainter;
import eason.linyuzai.easonicon.painter.combine.NextPainter;
import eason.linyuzai.easonicon.painter.combine.QuadFlower5;

/**
 * Created by linyuzai on 2018/5/19.
 *
 * @author linyuzai
 */

public class EasonIcon extends View {
    public static final String TAG = "EasonIcon";

    private int width;
    private int height;

    //private Rect rect;
    private RectF drawRectF = new RectF();//绘制区域，不包括padding
    private RectF originalRectF = new RectF();//原始区域

    private int type = Type.NONE;
    private EasonPainterSet painterSet = new EasonPainterSet();//需要绘制的集合

    private Paint paint = new Paint();

    @AuxiliaryColorField
    private int auxiliaryColor;
    @AuxiliaryScaleField
    private float auxiliaryScale;
    @RoundField
    private float leftTopRound;
    @RoundField
    private float leftBottomRound;
    @RoundField
    private float rightTopRound;
    @RoundField
    private float rightBottomRound;
    @ArcField
    private float startAngle;
    @ArcField
    private float sweepAngle;
    @ArcField
    private boolean useCenter;
    @BitmapField
    private Bitmap bitmap;
    @PolygonField
    private int edgeCount;
    @PolygonField
    private float extraOffset;

    public EasonIcon(Context context) {
        super(context);
        init(context, null);
    }

    public EasonIcon(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public EasonIcon(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public EasonIcon(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context, attrs);
    }

    /**
     * 初始化画笔
     *
     * @param context 上下文
     * @param attrs   自定义属性
     */
    private void init(Context context, AttributeSet attrs) {
        paint.setAntiAlias(true);
        paint.setDither(true);
        if (attrs != null) {
            TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.EasonIcon);
            int color = a.getColor(R.styleable.EasonIcon_icon_color, Color.WHITE);
            int penSize = a.getDimensionPixelSize(R.styleable.EasonIcon_icon_pen_size, 0);
            int type = a.getInt(R.styleable.EasonIcon_icon_type, Type.NONE);
            int cap = a.getInt(R.styleable.EasonIcon_icon_pen_cap, 1);
            int join = a.getInt(R.styleable.EasonIcon_icon_pen_join, 0);
            int style = a.getInt(R.styleable.EasonIcon_icon_pen_style, 1);
            float roundAll = a.getDimension(R.styleable.EasonIcon_icon_round_all, 0f);

            auxiliaryColor = a.getColor(R.styleable.EasonIcon_icon_auxiliary_color, Color.WHITE);
            auxiliaryScale = a.getFloat(R.styleable.EasonIcon_icon_auxiliary_scale, 0.5f);

            leftTopRound = a.getDimension(R.styleable.EasonIcon_icon_round_left_top, roundAll);
            leftBottomRound = a.getDimension(R.styleable.EasonIcon_icon_round_left_bottom, roundAll);
            rightTopRound = a.getDimension(R.styleable.EasonIcon_icon_round_right_top, roundAll);
            rightBottomRound = a.getDimension(R.styleable.EasonIcon_icon_round_right_bottom, roundAll);

            startAngle = a.getFloat(R.styleable.EasonIcon_icon_arc_angle_start, 0f);
            sweepAngle = a.getFloat(R.styleable.EasonIcon_icon_arc_angle_sweep, 0f);
            useCenter = a.getBoolean(R.styleable.EasonIcon_icon_arc_center, false);

            int imageRes = a.getInt(R.styleable.EasonIcon_icon_image_res, NO_ID);
            if (imageRes != NO_ID)
                bitmap = BitmapFactory.decodeResource(getResources(), imageRes);

            edgeCount = a.getInt(R.styleable.EasonIcon_icon_polygon_edge_count, 3);
            extraOffset = a.getDimension(R.styleable.EasonIcon_icon_polygon_extra_offset, 0f);

            float pathEffectCorner = a.getDimension(R.styleable.EasonIcon_icon_path_effect_corner, 0);

            float percentCenter = a.getFloat(R.styleable.EasonIcon_icon_percent_center, -1f);
            float percent = a.getFloat(R.styleable.EasonIcon_icon_percent, -1f);
            float percentX = a.getFloat(R.styleable.EasonIcon_icon_percent_x, -1f);
            float percentY = a.getFloat(R.styleable.EasonIcon_icon_percent_y, -1f);
            float percentOffset = a.getFloat(R.styleable.EasonIcon_icon_percent_offset, -1f);
            float percentOffsetX = a.getFloat(R.styleable.EasonIcon_icon_percent_offset_x, -1f);
            float percentOffsetY = a.getFloat(R.styleable.EasonIcon_icon_percent_offset_y, -1f);
            float offset = a.getDimension(R.styleable.EasonIcon_icon_offset, -1f);
            float offsetX = a.getDimension(R.styleable.EasonIcon_icon_offset_x, -1f);
            float offsetY = a.getDimension(R.styleable.EasonIcon_icon_offset_y, -1f);

            a.recycle();
            setType(type, false);
            setColor(color, false);
            setPenSize(penSize, false);
            setPenCap(Paint.Cap.values()[cap], false);
            setPenJoin(Paint.Join.values()[join], false);
            setPenStyle(Paint.Style.values()[style], false);
            setPathEffect(new CornerPathEffect(pathEffectCorner), false);

            if (percentCenter >= 0f)
                painterSet.setCenterPercent(percentCenter);
            if (percent >= 0f)
                painterSet.setPercent(percent);
            if (percentX >= 0f)
                painterSet.setPercentX(percentX);
            if (percentY >= 0f)
                painterSet.setOffsetY(percentY);
            if (percentOffset >= 0f)
                painterSet.setOffsetPercent(percentOffset);
            if (percentOffsetX >= 0f)
                painterSet.setOffsetPercentX(percentOffsetX);
            if (percentOffsetY >= 0f)
                painterSet.setOffsetPercentY(percentOffsetY);
            if (offset >= 0f)
                painterSet.setOffset(offset);
            if (offsetX >= 0f)
                painterSet.setOffsetX(offsetX);
            if (offsetY >= 0f)
                painterSet.setOffsetY(offsetY);
        }
    }

    public int getAuxiliaryColor() {
        return auxiliaryColor;
    }

    public void setAuxiliaryColor(int auxiliaryColor) {
        this.auxiliaryColor = auxiliaryColor;
    }

    public float getAuxiliaryScale() {
        return auxiliaryScale;
    }

    public void setAuxiliaryScale(float auxiliaryScale) {
        this.auxiliaryScale = auxiliaryScale;
    }

    public float getLeftTopRound() {
        return leftTopRound;
    }

    public void setLeftTopRound(float leftTopRound) {
        this.leftTopRound = leftTopRound;
    }

    public float getLeftBottomRound() {
        return leftBottomRound;
    }

    public void setLeftBottomRound(float leftBottomRound) {
        this.leftBottomRound = leftBottomRound;
    }

    public float getRightTopRound() {
        return rightTopRound;
    }

    public void setRightTopRound(float rightTopRound) {
        this.rightTopRound = rightTopRound;
    }

    public float getRightBottomRound() {
        return rightBottomRound;
    }

    public void setRightBottomRound(float rightBottomRound) {
        this.rightBottomRound = rightBottomRound;
    }

    public float getStartAngle() {
        return startAngle;
    }

    public void setStartAngle(float startAngle) {
        this.startAngle = startAngle;
    }

    public float getSweepAngle() {
        return sweepAngle;
    }

    public void setSweepAngle(float sweepAngle) {
        this.sweepAngle = sweepAngle;
    }

    public boolean isUseCenter() {
        return useCenter;
    }

    public void setUseCenter(boolean useCenter) {
        this.useCenter = useCenter;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public int getEdgeCount() {
        return edgeCount;
    }

    public void setEdgeCount(int edgeCount) {
        this.edgeCount = edgeCount;
    }

    public float getExtraOffset() {
        return extraOffset;
    }

    public void setExtraOffset(float extraOffset) {
        this.extraOffset = extraOffset;
    }

    /**
     * 获得Icon类型
     *
     * @return Icon类型
     */
    public int getType() {
        return type;
    }

    /**
     * 设置Icon类型
     *
     * @param type Icon类型
     */
    public void setType(int type) {
        setType(type, true);
    }

    /**
     * 设置Icon类型
     *
     * @param type       Icon类型
     * @param invalidate 是否重绘
     */
    public void setType(int type, boolean invalidate) {
        if (this.type == type)
            return;
        this.type = type;
        painterSet.clearPainter();
        switch (type) {
            case Type.NONE:
                break;
            case Type.LINE_VERTICAL:
                painterSet.addPainter(new VerticalLinePainter());
                break;
            case Type.LINE_HORIZONTAL:
                painterSet.addPainter(new HorizontalLinePainter());
                break;
            case Type.LINE_SLOPE_POSITIVE:
                painterSet.addPainter(new SlopePositiveLinePainter());
                break;
            case Type.LINE_SLOPE_NEGATIVE:
                painterSet.addPainter(new SlopeNegativeLinePainter());
                break;
            case Type.CIRCLE:
                painterSet.addPainter(new CirclePainter());
                break;
            case Type.OVAL:
                painterSet.addPainter(new OvalPainter());
                break;
            case Type.RECT:
                painterSet.addPainter(new RectPainter(leftTopRound, leftBottomRound, rightTopRound, rightBottomRound));
                break;
            case Type.ARC:
                painterSet.addPainter(new ArcPainter(startAngle, sweepAngle, useCenter));
                break;
            case Type.BITMAP:
                painterSet.addPainter(new BitmapPainter(bitmap));
                break;
            case Type.POLYGON:
                painterSet.addPainter(new PolygonPainter(edgeCount));
                break;
            case Type.POLYGON_EXTRA:
                painterSet.addPainter(new ExtraPolygonPainter(edgeCount, extraOffset));
                break;
            case Type.POLYGON_QUAD:
                painterSet.addPainter(new QuadPolygonPainter(edgeCount, extraOffset));
                break;
            case Type.BACK:
                painterSet.addPainter(new BackPainter());
                break;
            case Type.NEXT:
                painterSet.addPainter(new NextPainter());
                break;
            case Type.ADD:
                painterSet.addPainter(new AddPainter());
                break;
            case Type.ADD_HOLLOW_OVAL:
                painterSet.addPainter(new AddHollowOvalPainter(auxiliaryScale));
                break;
            case Type.ADD_SOLID_OVAL:
                painterSet.addPainter(new AddSolidOvalPainter(auxiliaryScale, auxiliaryColor, paint.getColor()));
                break;
            case Type.CORRECT:
                painterSet.addPainter(new CorrectPainter());
                break;
            case Type.ERROR:
                painterSet.addPainter(new ErrorPainter());
                break;
            case Type.QUAD_FLOWER_5:
                painterSet.addPainter(new QuadFlower5());
                break;
        }
        if (invalidate)
            update();
    }

    public void addPainter(Painter painter) {
        addPainter(painter, true);
    }

    public void addPainter(Painter painter, boolean invalidate) {
        painterSet.addPainter(painter);
        if (invalidate)
            update();
    }

    public void addPainter(int index, Painter painter) {
        addPainter(index, painter, true);
    }

    public void addPainter(int index, Painter painter, boolean invalidate) {
        painterSet.addPainter(index, painter);
        if (invalidate)
            update();
    }

    public void removePainter(Painter painter) {
        removePainter(painter, true);
    }

    public void removePainter(Painter painter, boolean invalidate) {
        painterSet.removePainter(painter);
        if (invalidate)
            update();
    }

    public void removePainter(int index) {
        removePainter(index, true);
    }

    public void removePainter(int index, boolean invalidate) {
        painterSet.removePainter(index);
        if (invalidate)
            update();
    }

    public void clearPainter() {
        clearPainter(true);
    }

    public void clearPainter(boolean invalidate) {
        painterSet.clearPainter();
        if (invalidate)
            update();
    }

    /**
     * 获得画笔宽度
     *
     * @return 画笔宽度
     */
    public int getPenSize() {
        return (int) paint.getStrokeWidth();
    }

    /**
     * 设置画笔宽度
     *
     * @param size 画笔宽度
     */
    public void setPenSize(@Px int size) {
        setPenSize(size, true);
    }

    /**
     * 设置画笔宽度
     *
     * @param size       画笔宽度
     * @param invalidate 是否重绘
     */
    public void setPenSize(@Px int size, boolean invalidate) {
        paint.setStrokeWidth(size);
        if (invalidate)
            update();
    }

    /**
     * 获得画笔颜色
     *
     * @return 画笔颜色
     */
    public int getColor() {
        return paint.getColor();
    }

    /**
     * 设置画笔颜色
     *
     * @param color 画笔颜色
     */
    public void setColor(@ColorInt int color) {
        setColor(color, true);
    }

    /**
     * 设置画笔颜色
     *
     * @param color      画笔颜色
     * @param invalidate 是否重绘
     */
    public void setColor(@ColorInt int color, boolean invalidate) {
        paint.setColor(color);
        if (invalidate)
            update();
    }

    public Paint.Cap getPenCap() {
        return paint.getStrokeCap();
    }

    public void setPenCap(Paint.Cap cap) {
        setPenCap(cap, true);
    }

    public void setPenCap(Paint.Cap cap, boolean invalidate) {
        paint.setStrokeCap(cap);
        if (invalidate)
            update();
    }

    public Paint.Join getPenJoin() {
        return paint.getStrokeJoin();
    }

    public void setPenJoin(Paint.Join join) {
        setPenJoin(join, true);
    }

    public void setPenJoin(Paint.Join join, boolean invalidate) {
        paint.setStrokeJoin(join);
        if (invalidate)
            update();
    }

    public PathEffect setPathEffect() {
        return paint.getPathEffect();
    }

    public void setPathEffect(PathEffect effect) {
        setPathEffect(effect, true);
    }

    public void setPathEffect(PathEffect effect, boolean invalidate) {
        paint.setPathEffect(effect);
        if (invalidate)
            update();
    }

    public Paint.Style getPenStyle() {
        return paint.getStyle();
    }

    public void setPenStyle(Paint.Style style) {
        setPenStyle(style, true);
    }

    public void setPenStyle(Paint.Style style, boolean invalidate) {
        paint.setStyle(style);
        if (invalidate)
            update();
    }

    public Paint getPaint() {
        return paint;
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        width = w;
        height = h;
        originalRectF.right = w;
        originalRectF.bottom = h;
        updateRectF(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom());
    }

    @Override
    public void setPadding(@Px int left, @Px int top, @Px int right, @Px int bottom) {
        updateRectF(left, top, right, bottom);
        super.setPadding(left, top, right, bottom);
    }

    private void updateRectF(@Px int left, @Px int top, @Px int right, @Px int bottom) {
        drawRectF = new RectF(left, top, width - right, height - bottom);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        painterSet.draw(canvas, drawRectF, originalRectF, paint);
    }

    /**
     * 重绘
     */
    public void update() {
        invalidate();
    }

    public void printStructure() {
        printStructure(false);
    }

    public void printStructure(boolean includeInterceptor) {
        painterSet.printStructure(0, includeInterceptor);
    }

    public static void printStructure(Painter painter) {
        printStructure(painter, false);
    }

    public static void printStructure(Painter painter, boolean includeInterceptor) {
        painter.printStructure(0, includeInterceptor);
    }

    public static final class Type {
        /**
         * 不绘制
         */
        public static final int NONE = 0;
        /**
         * 竖直线
         */
        public static final int LINE_VERTICAL = 10;
        /**
         * 水平线
         */
        public static final int LINE_HORIZONTAL = 20;
        /**
         * 左上右下斜线
         */
        public static final int LINE_SLOPE_POSITIVE = 30;
        /**
         * 左下右上斜线
         */
        public static final int LINE_SLOPE_NEGATIVE = 40;
        /**
         * 圆
         */
        public static final int CIRCLE = 50;
        /**
         * 椭圆
         */
        public static final int OVAL = 60;

        public static final int RECT = 70;

        public static final int ARC = 80;

        public static final int BITMAP = 90;

        public static final int POLYGON = 100;

        public static final int POLYGON_EXTRA = 110;

        public static final int POLYGON_QUAD = 120;
        /**
         * 返回
         */
        public static final int BACK = 11;

        public static final int COLLAPSE = 21;

        public static final int EXPAND = 31;

        public static final int NEXT = 41;

        public static final int ARROW_DOWN = 51;

        public static final int ARROW_LEFT = 61;

        public static final int ARROW_RIGHT = 71;

        public static final int ARROW_UP = 81;

        public static final int ADD = 91;

        public static final int ADD_HOLLOW_OVAL = 101;

        public static final int ADD_SOLID_OVAL = 111;

        public static final int ADD_HOLLOW_RECT = 121;

        public static final int ADD_SOLID_RECT = 131;

        public static final int CORRECT = 141;

        public static final int CORRECT_HOLLOW_OVAL = 151;

        public static final int CORRECT_SOLID_OVAL = 161;

        public static final int CORRECT_HOLLOW_RECT = 171;

        public static final int CORRECT_SOLID_RECT = 181;

        public static final int ERROR = 191;

        public static final int ERROR_HOLLOW_OVAL = 201;

        public static final int ERROR_SOLID_OVAL = 211;

        public static final int ERROR_HOLLOW_RECT = 221;

        public static final int ERROR_SOLID_RECT = 231;

        public static final int QUAD_FLOWER_5 = 241;
    }
}

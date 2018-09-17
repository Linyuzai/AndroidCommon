package eason.linyuzai.easonicon;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.CornerPathEffect;
import android.graphics.Paint;
import android.graphics.PathEffect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.ColorInt;
import android.support.annotation.Nullable;
import android.support.annotation.Px;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

import java.lang.annotation.Annotation;

import eason.linyuzai.easonicon.annotation.ArcField;
import eason.linyuzai.easonicon.annotation.AuxiliaryColorField;
import eason.linyuzai.easonicon.annotation.AuxiliaryScaleField;
import eason.linyuzai.easonicon.annotation.BitmapField;
import eason.linyuzai.easonicon.annotation.EdgeCountField;
import eason.linyuzai.easonicon.annotation.ExtraOffsetField;
import eason.linyuzai.easonicon.annotation.PenSizeScaleField;
import eason.linyuzai.easonicon.annotation.RoundRectField;
import eason.linyuzai.easonicon.annotation.TextField;
import eason.linyuzai.easonicon.open.Painter;
import eason.linyuzai.easonicon.open.PainterSet;
import eason.linyuzai.easonicon.painter.EasonPainterSet;
import eason.linyuzai.easonicon.painter.basic.NonePainter;
import eason.linyuzai.easonicon.painter.basic.arc.ArcPainter;
import eason.linyuzai.easonicon.painter.basic.bitmap.BitmapPainter;
import eason.linyuzai.easonicon.painter.basic.circle.CirclePainter;
import eason.linyuzai.easonicon.painter.basic.circle.OvalPainter;
import eason.linyuzai.easonicon.painter.basic.line.HorizontalLinePainter;
import eason.linyuzai.easonicon.painter.basic.line.SlopeNegativeLinePainter;
import eason.linyuzai.easonicon.painter.basic.line.SlopePositiveLinePainter;
import eason.linyuzai.easonicon.painter.basic.line.VerticalLinePainter;
import eason.linyuzai.easonicon.painter.basic.point.PointPainter;
import eason.linyuzai.easonicon.painter.basic.polygon.ExtraPolygonPainter;
import eason.linyuzai.easonicon.painter.basic.polygon.PolygonPainter;
import eason.linyuzai.easonicon.painter.basic.polygon.QuadPolygonPainter;
import eason.linyuzai.easonicon.painter.basic.rect.RectPainter;
import eason.linyuzai.easonicon.painter.basic.text.TextPainter;
import eason.linyuzai.easonicon.painter.combine.AddOvalPainter;
import eason.linyuzai.easonicon.painter.combine.AddPainter;
import eason.linyuzai.easonicon.painter.combine.AddRectPainter;
import eason.linyuzai.easonicon.painter.combine.BackOvalPainter;
import eason.linyuzai.easonicon.painter.combine.BackPainter;
import eason.linyuzai.easonicon.painter.combine.BackRectPainter;
import eason.linyuzai.easonicon.painter.combine.ClockPainter;
import eason.linyuzai.easonicon.painter.combine.CollapseOvalPainter;
import eason.linyuzai.easonicon.painter.combine.CollapsePainter;
import eason.linyuzai.easonicon.painter.combine.CollapseRectPainter;
import eason.linyuzai.easonicon.painter.combine.CorrectOvalPainter;
import eason.linyuzai.easonicon.painter.combine.CorrectPainter;
import eason.linyuzai.easonicon.painter.combine.CorrectRectPainter;
import eason.linyuzai.easonicon.painter.combine.DownArrowOvalPainter;
import eason.linyuzai.easonicon.painter.combine.DownArrowPainter;
import eason.linyuzai.easonicon.painter.combine.DownArrowRectPainter;
import eason.linyuzai.easonicon.painter.combine.DownloadPainter;
import eason.linyuzai.easonicon.painter.combine.EnvelopePainter;
import eason.linyuzai.easonicon.painter.combine.ErrorOvalPainter;
import eason.linyuzai.easonicon.painter.combine.ErrorPainter;
import eason.linyuzai.easonicon.painter.combine.ErrorRectPainter;
import eason.linyuzai.easonicon.painter.combine.ExpandOvalPainter;
import eason.linyuzai.easonicon.painter.combine.ExpandPainter;
import eason.linyuzai.easonicon.painter.combine.ExpandRectPainter;
import eason.linyuzai.easonicon.painter.combine.ExtraFlower;
import eason.linyuzai.easonicon.painter.combine.FemalePainter;
import eason.linyuzai.easonicon.painter.combine.LeftArrowOvalPainter;
import eason.linyuzai.easonicon.painter.combine.LeftArrowPainter;
import eason.linyuzai.easonicon.painter.combine.LeftArrowRectPainter;
import eason.linyuzai.easonicon.painter.combine.LovePainter;
import eason.linyuzai.easonicon.painter.combine.MalePainter;
import eason.linyuzai.easonicon.painter.combine.MenuPainter;
import eason.linyuzai.easonicon.painter.combine.MinusOvalPainter;
import eason.linyuzai.easonicon.painter.combine.MinusPainter;
import eason.linyuzai.easonicon.painter.combine.MinusRectPainter;
import eason.linyuzai.easonicon.painter.combine.NextOvalPainter;
import eason.linyuzai.easonicon.painter.combine.NextPainter;
import eason.linyuzai.easonicon.painter.combine.NextRectPainter;
import eason.linyuzai.easonicon.painter.combine.QuadFlower;
import eason.linyuzai.easonicon.painter.combine.RightArrowOvalPainter;
import eason.linyuzai.easonicon.painter.combine.RightArrowPainter;
import eason.linyuzai.easonicon.painter.combine.RightArrowRectPainter;
import eason.linyuzai.easonicon.painter.combine.SearchPainter;
import eason.linyuzai.easonicon.painter.combine.SettingPainter;
import eason.linyuzai.easonicon.painter.combine.SettingV21Painter;
import eason.linyuzai.easonicon.painter.combine.SignPainter;
import eason.linyuzai.easonicon.painter.combine.StarPainter;
import eason.linyuzai.easonicon.painter.combine.UpArrowOvalPainter;
import eason.linyuzai.easonicon.painter.combine.UpArrowPainter;
import eason.linyuzai.easonicon.painter.combine.UpArrowRectPainter;
import eason.linyuzai.easonicon.painter.combine.UploadPainter;
import eason.linyuzai.easonicon.painter.combine.UserPainter;

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

    private Type type = Type.NONE;
    private PainterSet painterSet = new EasonPainterSet();//需要绘制的集合

    private Paint paint = new Paint();

    @AuxiliaryColorField
    private int auxiliaryColor;
    @AuxiliaryScaleField
    private float auxiliaryScale;
    @RoundRectField
    private float leftTopRound;
    @RoundRectField
    private float leftBottomRound;
    @RoundRectField
    private float rightTopRound;
    @RoundRectField
    private float rightBottomRound;
    @ArcField
    private float startAngle;
    @ArcField
    private float sweepAngle;
    @ArcField
    private boolean useCenter;
    @BitmapField
    private Bitmap bitmap;
    @EdgeCountField
    private int edgeCount;
    @ExtraOffsetField
    private float extraOffset;
    @PenSizeScaleField
    float penSizeScale;
    @TextField
    private String text;

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
     * 获得默认百分比
     *
     * @param type type下标
     * @return 百分比
     */
    public static float getDefaultPercent(int type) {
        return getDefaultPercent(getType(type));
    }

    /**
     * 获得默认百分比
     *
     * @param type Icon类型
     * @return 默认百分比
     */
    public static float getDefaultPercent(Type type) {
        return type.getDefaultPercent();
    }

    /**
     * 某个type是否有某个Annotation
     *
     * @param type Icon类型
     * @param cls  Annotation cls
     * @return 是否有该Annotation
     */
    public static boolean hasAnnotation(int type, Class<? extends Annotation> cls) {
        return hasAnnotation(getType(type), cls);
    }

    /**
     * 某个type是否有某个Annotation
     *
     * @param type Icon类型
     * @param cls  Annotation cls
     * @return 是否有该Annotation
     */
    public static boolean hasAnnotation(Type type, Class<? extends Annotation> cls) {
        return type.getPainterClass().getAnnotation(cls) != null;
    }

    /**
     * 递归Painter
     *
     * @param painter  需要递归的Painter
     * @param callback 回调
     */
    public static void recursivePainter(Painter painter, PainterSet.OnRecursivePainterCallback callback) {
        if (painter instanceof PainterSet) {
            ((PainterSet) painter).recursivePainter(callback);
        } else {
            callback.onPainterRecursive(painter);
        }
    }

    /**
     * 打印Painter结构
     *
     * @param painter 需要打印结构的Painter
     */
    public static void printStructure(Painter painter) {
        printStructure(painter, false);
    }

    /**
     * 打印Painter结构
     *
     * @param painter            需要打印结构的Painter
     * @param includeInterceptor 是否打印Interceptor
     */
    public static void printStructure(Painter painter, boolean includeInterceptor) {
        painter.printStructure(0, includeInterceptor);
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
            int color = a.getColor(R.styleable.EasonIcon_eic_color, Color.WHITE);
            int penSize = a.getDimensionPixelSize(R.styleable.EasonIcon_eic_pen_size, 5);
            int type = a.getInt(R.styleable.EasonIcon_eic_type, Type.NONE.value);
            int cap = a.getInt(R.styleable.EasonIcon_eic_pen_cap, 1);
            int join = a.getInt(R.styleable.EasonIcon_eic_pen_join, 0);
            int style = a.getInt(R.styleable.EasonIcon_eic_pen_style, 1);
            float roundAll = a.getDimension(R.styleable.EasonIcon_eic_round_all, 0f);

            auxiliaryColor = a.getColor(R.styleable.EasonIcon_eic_auxiliary_color, color);
            auxiliaryScale = a.getFloat(R.styleable.EasonIcon_eic_auxiliary_scale, 0.5f);

            leftTopRound = a.getDimension(R.styleable.EasonIcon_eic_round_left_top, roundAll);
            leftBottomRound = a.getDimension(R.styleable.EasonIcon_eic_round_left_bottom, roundAll);
            rightTopRound = a.getDimension(R.styleable.EasonIcon_eic_round_right_top, roundAll);
            rightBottomRound = a.getDimension(R.styleable.EasonIcon_eic_round_right_bottom, roundAll);

            startAngle = a.getFloat(R.styleable.EasonIcon_eic_arc_angle_start, 0f);
            sweepAngle = a.getFloat(R.styleable.EasonIcon_eic_arc_angle_sweep, 0f);
            useCenter = a.getBoolean(R.styleable.EasonIcon_eic_arc_center, false);

            int imageRes = a.getInt(R.styleable.EasonIcon_eic_image_res, NO_ID);
            if (imageRes != NO_ID) {
                Drawable drawable = getResources().getDrawable(imageRes);
                bitmap = BitmapPainter.getBitmapFromDrawable(drawable);
                //bitmap = BitmapFactory.decodeResource(getResources(), imageRes);
            }

            edgeCount = a.getInt(R.styleable.EasonIcon_eic_polygon_edge_count, 3);
            extraOffset = a.getDimension(R.styleable.EasonIcon_eic_polygon_extra_offset, 0f);
            penSizeScale = a.getFloat(R.styleable.EasonIcon_eic_polygon_pen_size_scale, 1f);

            text = a.getString(R.styleable.EasonIcon_eic_text);

            float textSize = a.getDimension(R.styleable.EasonIcon_eic_text_size, 0f);

            float pathEffectCorner = a.getDimension(R.styleable.EasonIcon_eic_path_effect_corner, 0f);

            float percentCenter = a.getFloat(R.styleable.EasonIcon_eic_percent_center, -1f);
            float percentCenterX = a.getFloat(R.styleable.EasonIcon_eic_percent_center_x, -1f);
            float percentCenterY = a.getFloat(R.styleable.EasonIcon_eic_percent_center_y, -1f);
            float percent = a.getFloat(R.styleable.EasonIcon_eic_percent, -1f);
            float percentX = a.getFloat(R.styleable.EasonIcon_eic_percent_x, -1f);
            float percentY = a.getFloat(R.styleable.EasonIcon_eic_percent_y, -1f);
            float percentOffset = a.getFloat(R.styleable.EasonIcon_eic_percent_offset, -1f);
            float percentOffsetX = a.getFloat(R.styleable.EasonIcon_eic_percent_offset_x, -1f);
            float percentOffsetY = a.getFloat(R.styleable.EasonIcon_eic_percent_offset_y, -1f);
            float offset = a.getDimension(R.styleable.EasonIcon_eic_offset, -1f);
            float offsetX = a.getDimension(R.styleable.EasonIcon_eic_offset_x, -1f);
            float offsetY = a.getDimension(R.styleable.EasonIcon_eic_offset_y, -1f);

            a.recycle();

            setType(type);
            setColor(color);
            setPenSize(penSize);
            setPenCap(Paint.Cap.values()[cap]);
            setPenJoin(Paint.Join.values()[join]);
            setPenStyle(Paint.Style.values()[style]);
            if (pathEffectCorner > 0f)
                setPathEffect(new CornerPathEffect(pathEffectCorner));
            setTextSize(textSize);

            if (percentCenter >= 0f)
                painterSet.setCenterPercent(percentCenter);
            if (percentCenterX >= 0f)
                painterSet.setCenterPercentX(percentCenterX);
            if (percentCenterY >= 0f)
                painterSet.setCenterPercentY(percentCenterY);
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
        } else {
            setColor(Color.WHITE);
            setPenSize(5);
            setPenStyle(Paint.Style.STROKE);
            setPenCap(Paint.Cap.ROUND);
            auxiliaryColor = Color.WHITE;
            auxiliaryScale = 0.5f;
            edgeCount = 3;
            penSizeScale = 1f;
        }
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
        paint.setStrokeWidth(size);
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
        paint.setColor(color);
    }


    /**
     * 根据type下标获得Type
     *
     * @param type type下标
     * @return Type
     */
    public static Type getType(int type) {
        return Type.values()[type];
    }

    /**
     * 设置画笔颜色
     *
     * @param color               画笔颜色
     * @param ifSetAuxiliaryColor 是否同时设置AuxiliaryColor
     */
    public void setColor(@ColorInt int color, boolean ifSetAuxiliaryColor) {
        paint.setColor(color);
        if (ifSetAuxiliaryColor)
            setAuxiliaryColor(color);
    }

    /**
     * 获得画笔Cap
     *
     * @return 画笔Cap
     */
    public Paint.Cap getPenCap() {
        return paint.getStrokeCap();
    }

    /**
     * 设置画笔Cap
     *
     * @param cap 画笔Cap
     */
    public void setPenCap(Paint.Cap cap) {
        paint.setStrokeCap(cap);
    }

    /**
     * 获得画笔Join
     *
     * @return 画笔Join
     */
    public Paint.Join getPenJoin() {
        return paint.getStrokeJoin();
    }

    /**
     * 设置画笔Join
     *
     * @param join 画笔Join
     */
    public void setPenJoin(Paint.Join join) {
        paint.setStrokeJoin(join);
    }

    /**
     * 获得画笔PathEffect
     *
     * @return 画笔PathEffect
     */
    public PathEffect setPathEffect() {
        return paint.getPathEffect();
    }

    /**
     * 设置画笔PathEffect
     *
     * @param effect 画笔PathEffect
     */
    public void setPathEffect(PathEffect effect) {
        paint.setPathEffect(effect);
    }

    /**
     * 获得Icon类型
     *
     * @return Icon类型
     */
    public Type getType() {
        return type;
    }

    /**
     * 设置Icon类型
     *
     * @param type Icon类型
     * @return 是否成功
     */
    public boolean setType(int type) {
        return setType(Type.values()[type], false);
    }

    /**
     * 设置Icon类型
     *
     * @param type  Icon类型
     * @param force type相同时强制重绘
     * @return 是否成功
     */
    public boolean setType(int type, boolean force) {
        return setType(Type.values()[type], force);
    }

    /**
     * 设置Icon类型
     *
     * @param type Icon类型
     * @return 是否成功
     */
    public boolean setType(Type type) {
        return setType(type, false);
    }

    /**
     * 设置Icon类型
     *
     * @param type  Icon类型
     * @param force 是否强制重绘
     * @return 是否成功
     */
    public boolean setType(Type type, boolean force) {
        if (!force && this.type == type)
            return true;
        this.type = type;
        painterSet.clearPainter();
        switch (type) {
            case NONE:
                break;
            case LINE_VERTICAL:
                painterSet.addPainter(new VerticalLinePainter());
                break;
            case LINE_HORIZONTAL:
                painterSet.addPainter(new HorizontalLinePainter());
                break;
            case LINE_SLOPE_POSITIVE:
                painterSet.addPainter(new SlopePositiveLinePainter());
                break;
            case LINE_SLOPE_NEGATIVE:
                painterSet.addPainter(new SlopeNegativeLinePainter());
                break;
            case CIRCLE:
                painterSet.addPainter(new CirclePainter());
                break;
            case OVAL:
                painterSet.addPainter(new OvalPainter());
                break;
            case RECT:
                painterSet.addPainter(new RectPainter(leftTopRound, leftBottomRound, rightTopRound, rightBottomRound));
                break;
            case ARC:
                painterSet.addPainter(new ArcPainter(startAngle, sweepAngle, useCenter));
                break;
            case BITMAP:
                painterSet.addPainter(new BitmapPainter(bitmap));
                break;
            case POLYGON:
                painterSet.addPainter(new PolygonPainter(edgeCount));
                break;
            case POLYGON_EXTRA:
                painterSet.addPainter(new ExtraPolygonPainter(edgeCount, extraOffset));
                break;
            case POLYGON_QUAD:
                painterSet.addPainter(new QuadPolygonPainter(edgeCount, extraOffset));
                break;
            case TEXT:
                painterSet.addPainter(new TextPainter(text));
                break;
            case POINT:
                painterSet.addPainter(new PointPainter());
                break;
            case BACK:
                painterSet.addPainter(new BackPainter());
                break;
            case NEXT:
                painterSet.addPainter(new NextPainter());
                break;
            case COLLAPSE:
                painterSet.addPainter(new CollapsePainter());
                break;
            case EXPAND:
                painterSet.addPainter(new ExpandPainter());
                break;
            case BACK_OVAL:
                painterSet.addPainter(new BackOvalPainter(auxiliaryScale, auxiliaryColor));
                break;
            case NEXT_OVAL:
                painterSet.addPainter(new NextOvalPainter(auxiliaryScale, auxiliaryColor));
                break;
            case COLLAPSE_OVAL:
                painterSet.addPainter(new CollapseOvalPainter(auxiliaryScale, auxiliaryColor));
                break;
            case EXPAND_OVAL:
                painterSet.addPainter(new ExpandOvalPainter(auxiliaryScale, auxiliaryColor));
                break;
            case BACK_RECT:
                painterSet.addPainter(new BackRectPainter(auxiliaryScale, auxiliaryColor, leftTopRound, leftBottomRound, rightTopRound, rightBottomRound));
                break;
            case NEXT_RECT:
                painterSet.addPainter(new NextRectPainter(auxiliaryScale, auxiliaryColor, leftTopRound, leftBottomRound, rightTopRound, rightBottomRound));
                break;
            case COLLAPSE_RECT:
                painterSet.addPainter(new CollapseRectPainter(auxiliaryScale, auxiliaryColor, leftTopRound, leftBottomRound, rightTopRound, rightBottomRound));
                break;
            case EXPAND_RECT:
                painterSet.addPainter(new ExpandRectPainter(auxiliaryScale, auxiliaryColor, leftTopRound, leftBottomRound, rightTopRound, rightBottomRound));
                break;
            case ARROW_LEFT:
                painterSet.addPainter(new LeftArrowPainter());
                break;
            case ARROW_RIGHT:
                painterSet.addPainter(new RightArrowPainter());
                break;
            case ARROW_UP:
                painterSet.addPainter(new UpArrowPainter());
                break;
            case ARROW_DOWN:
                painterSet.addPainter(new DownArrowPainter());
                break;
            case ARROW_LEFT_OVAL:
                painterSet.addPainter(new LeftArrowOvalPainter(auxiliaryScale, auxiliaryColor));
                break;
            case ARROW_RIGHT_OVAL:
                painterSet.addPainter(new RightArrowOvalPainter(auxiliaryScale, auxiliaryColor));
                break;
            case ARROW_UP_OVAL:
                painterSet.addPainter(new UpArrowOvalPainter(auxiliaryScale, auxiliaryColor));
                break;
            case ARROW_DOWN_OVAL:
                painterSet.addPainter(new DownArrowOvalPainter(auxiliaryScale, auxiliaryColor));
                break;
            case ARROW_LEFT_RECT:
                painterSet.addPainter(new LeftArrowRectPainter(auxiliaryScale, auxiliaryColor, leftTopRound, leftBottomRound, rightTopRound, rightBottomRound));
                break;
            case ARROW_RIGHT_RECT:
                painterSet.addPainter(new RightArrowRectPainter(auxiliaryScale, auxiliaryColor, leftTopRound, leftBottomRound, rightTopRound, rightBottomRound));
                break;
            case ARROW_UP_RECT:
                painterSet.addPainter(new UpArrowRectPainter(auxiliaryScale, auxiliaryColor, leftTopRound, leftBottomRound, rightTopRound, rightBottomRound));
                break;
            case ARROW_DOWN_RECT:
                painterSet.addPainter(new DownArrowRectPainter(auxiliaryScale, auxiliaryColor, leftTopRound, leftBottomRound, rightTopRound, rightBottomRound));
                break;
            case ADD:
                painterSet.addPainter(new AddPainter());
                break;
            case MINUS:
                painterSet.addPainter(new MinusPainter());
                break;
            case CORRECT:
                painterSet.addPainter(new CorrectPainter());
                break;
            case ERROR:
                painterSet.addPainter(new ErrorPainter());
                break;
            case ADD_OVAL:
                painterSet.addPainter(new AddOvalPainter(auxiliaryScale, auxiliaryColor));
                break;
            case MINUS_OVAL:
                painterSet.addPainter(new MinusOvalPainter(auxiliaryScale, auxiliaryColor));
                break;
            case CORRECT_OVAL:
                painterSet.addPainter(new CorrectOvalPainter(auxiliaryScale, auxiliaryColor));
                break;
            case ERROR_OVAL:
                painterSet.addPainter(new ErrorOvalPainter(auxiliaryScale, auxiliaryColor));
                break;
            case ADD_RECT:
                painterSet.addPainter(new AddRectPainter(auxiliaryScale, auxiliaryColor, leftTopRound, leftBottomRound, rightTopRound, rightBottomRound));
                break;
            case MINUS_RECT:
                painterSet.addPainter(new MinusRectPainter(auxiliaryScale, auxiliaryColor, leftTopRound, leftBottomRound, rightTopRound, rightBottomRound));
                break;
            case CORRECT_RECT:
                painterSet.addPainter(new CorrectRectPainter(auxiliaryScale, auxiliaryColor, leftTopRound, leftBottomRound, rightTopRound, rightBottomRound));
                break;
            case ERROR_RECT:
                painterSet.addPainter(new ErrorRectPainter(auxiliaryScale, auxiliaryColor, leftTopRound, leftBottomRound, rightTopRound, rightBottomRound));
                break;
            case SETTING:
                painterSet.addPainter(new SettingPainter(auxiliaryScale, auxiliaryColor, penSizeScale));
                break;
            case SETTING_V21:
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    painterSet.addPainter(new SettingV21Painter(auxiliaryScale, penSizeScale));
                } else {
                    return false;
                }
                break;
            case FLOWER_EXTRA:
                painterSet.addPainter(new ExtraFlower(edgeCount, penSizeScale));
                break;
            case FLOWER_QUAD:
                painterSet.addPainter(new QuadFlower(edgeCount, penSizeScale));
                break;
            case MENU:
                painterSet.addPainter(new MenuPainter());
                break;
            case USER:
                painterSet.addPainter(new UserPainter(leftTopRound, leftBottomRound, rightTopRound, rightBottomRound));
                break;
            case MALE:
                painterSet.addPainter(new MalePainter());
                break;
            case FEMALE:
                painterSet.addPainter(new FemalePainter());
                break;
            case SIGN:
                painterSet.addPainter(new SignPainter(auxiliaryColor));
                break;
            case SEARCH:
                painterSet.addPainter(new SearchPainter());
                break;
            case STAR:
                painterSet.addPainter(new StarPainter());
                break;
            case LOVE:
                painterSet.addPainter(new LovePainter());
                break;
            case ENVELOPE:
                painterSet.addPainter(new EnvelopePainter(leftTopRound, leftBottomRound, rightTopRound, rightBottomRound));
                break;
            case CLOCK:
                painterSet.addPainter(new ClockPainter());
                break;
            case DOWNLOAD:
                painterSet.addPainter(new DownloadPainter());
                break;
            case UPLOAD:
                painterSet.addPainter(new UploadPainter());
                break;
        }
        return true;
    }

    public int getAuxiliaryColor() {
        return auxiliaryColor;
    }

    public void setAuxiliaryColor(int auxiliaryColor) {
        this.auxiliaryColor = auxiliaryColor;
        painterSet.recursivePainter(painter -> {
            if (painter.isSupportAuxiliaryColor()) {
                painter.toAuxiliaryColorSupport().setAuxiliaryColor(auxiliaryColor);
            }
        });
    }

    public float getAuxiliaryScale() {
        return auxiliaryScale;
    }

    public void setAuxiliaryScale(float auxiliaryScale) {
        this.auxiliaryScale = auxiliaryScale;
        painterSet.recursivePainter(painter -> {
            if (painter.isSupportAuxiliaryScale()) {
                painter.toAuxiliaryScaleSupport().setAuxiliaryScale(auxiliaryScale);
            }
        });
    }

    public float getLeftTopRound() {
        return leftTopRound;
    }

    public void setLeftTopRound(float leftTopRound) {
        this.leftTopRound = leftTopRound;
        painterSet.recursivePainter(painter -> {
            if (painter.isSupportRoundRect()) {
                painter.toRoundRectSupport().setLeftTop(leftTopRound);
            }
        });
    }

    public float getLeftBottomRound() {
        return leftBottomRound;
    }

    public void setLeftBottomRound(float leftBottomRound) {
        this.leftBottomRound = leftBottomRound;
        painterSet.recursivePainter(painter -> {
            if (painter.isSupportRoundRect()) {
                painter.toRoundRectSupport().setLeftBottom(leftBottomRound);
            }
        });
    }

    public float getRightTopRound() {
        return rightTopRound;
    }

    public void setRightTopRound(float rightTopRound) {
        this.rightTopRound = rightTopRound;
        painterSet.recursivePainter(painter -> {
            if (painter.isSupportRoundRect()) {
                painter.toRoundRectSupport().setRightTop(rightTopRound);
            }
        });
    }

    public float getRightBottomRound() {
        return rightBottomRound;
    }

    public void setRightBottomRound(float rightBottomRound) {
        this.rightBottomRound = rightBottomRound;
        painterSet.recursivePainter(painter -> {
            if (painter.isSupportRoundRect()) {
                painter.toRoundRectSupport().setRightBottom(rightBottomRound);
            }
        });
    }

    public float getStartAngle() {
        return startAngle;
    }

    public void setStartAngle(float startAngle) {
        this.startAngle = startAngle;
        painterSet.recursivePainter(painter -> {
            if (painter.isSupportArc())
                painter.toArcSupport().setStartAngle(startAngle);
        });
    }

    public float getSweepAngle() {
        return sweepAngle;
    }

    public void setSweepAngle(float sweepAngle) {
        this.sweepAngle = sweepAngle;
        painterSet.recursivePainter(painter -> {
            if (painter.isSupportArc())
                painter.toArcSupport().setSweepAngle(sweepAngle);
        });
    }

    public boolean isUseCenter() {
        return useCenter;
    }

    public void setUseCenter(boolean useCenter) {
        this.useCenter = useCenter;
        painterSet.recursivePainter(painter -> {
            if (painter.isSupportArc())
                painter.toArcSupport().setUseCenter(useCenter);
        });
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
        painterSet.recursivePainter(painter -> {
            if (painter.isSupportBitmap())
                painter.toBitmapSupport().setBitmap(bitmap);
        });
    }

    public int getEdgeCount() {
        return edgeCount;
    }

    public void setEdgeCount(int edgeCount) {
        this.edgeCount = edgeCount;
        painterSet.recursivePainter(painter -> {
            if (painter.isSupportEdgeCount())
                painter.toEdgeCountSupport().setEdgeCount(edgeCount);
        });
    }

    /**
     * 添加Painter
     *
     * @param painter 需要添加的Painter
     */
    public void addPainter(Painter painter) {
        painterSet.addPainter(painter);
    }

    /**
     * 添加Painter
     *
     * @param index   添加的位置
     * @param painter 需要添加的Painter
     */
    public void addPainter(int index, Painter painter) {
        painterSet.addPainter(index, painter);
    }

    /**
     * 移除Painter
     *
     * @param painter 需要移除的Painter
     */
    public void removePainter(Painter painter) {
        painterSet.removePainter(painter);
    }

    /**
     * 移除Painter
     *
     * @param index 移除的位置
     */
    public void removePainter(int index) {
        painterSet.removePainter(index);
    }

    /**
     * 清空Painter
     */
    public void clearPainter() {
        painterSet.clearPainter();
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

    /**
     * 获得画笔Style
     *
     * @return 画笔Style
     */
    public Paint.Style getPenStyle() {
        return paint.getStyle();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        painterSet.draw(canvas, drawRectF, originalRectF, paint);
    }

    /**
     * 设置画笔Style
     *
     * @param style 画笔Style
     */
    public void setPenStyle(Paint.Style style) {
        paint.setStyle(style);
    }

    /**
     * 获得画笔字体大小
     *
     * @return 画笔字体大小
     */
    public float getTextSize() {
        return paint.getTextSize();
    }

    /**
     * 设置画笔字体大小
     *
     * @param textSize 画笔字体大小
     */
    public void setTextSize(float textSize) {
        paint.setTextSize(textSize);
    }

    /**
     * 获得画笔
     *
     * @return 画笔
     */
    public Paint getPaint() {
        return paint;
    }

    /**
     * 获得PainterSet
     *
     * @return PainterSet
     */
    public PainterSet getPainterSet() {
        return painterSet;
    }

    /**
     * 获得Painter
     *
     * @param index painter的位置
     * @return Painter
     */
    public Painter getPainter(int index) {
        return painterSet.getPainter(index);
    }

    /**
     * 更新绘制区域
     *
     * @param left   左区域
     * @param top    上区域
     * @param right  右区域
     * @param bottom 下区域
     */
    private void updateRectF(@Px int left, @Px int top, @Px int right, @Px int bottom) {
        drawRectF = new RectF(left, top, width - right, height - bottom);
        //drawRectF = new RectF(0, 0, width, height);
    }

    /**
     * 重绘，保留以后可能需要额外操作
     */
    public void update() {
        invalidate();
    }

    public float getExtraOffset() {
        return extraOffset;
    }

    public void setExtraOffset(float extraOffset) {
        this.extraOffset = extraOffset;
        painterSet.recursivePainter(painter -> {
            if (painter.isSupportExtraOffset())
                painter.toExtraOffsetSupport().setExtraOffset(extraOffset);
        });
    }

    /**
     * 是否有某个Annotation
     *
     * @param cls Annotation cls
     * @return 是否有该Annotation
     */
    public boolean hasAnnotation(Class<? extends Annotation> cls) {
        return hasAnnotation(type, cls);
    }

    public float getPenSizeScale() {
        return penSizeScale;
    }

    public void setPenSizeScale(float penSizeScale) {
        this.penSizeScale = penSizeScale;
        painterSet.recursivePainter(painter -> {
            if (painter.isSupportPenSizeScale())
                painter.toPenSizeScaleSupport().setPenSizeScale(penSizeScale);
        });
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
        painterSet.recursivePainter(painter -> {
            if (painter.isSupportText())
                painter.toTextSupport().setText(text);
        });
    }

    /**
     * 设置Painter，会清空之前的所有Painter
     *
     * @param painter 需要设置的Painter
     */
    public void setPainter(Painter painter) {
        painterSet.clearPainter();
        painterSet.addPainter(painter);
    }

    /**
     * 打印Painter结构
     */
    public void printStructure() {
        printStructure(false);
    }

    /**
     * 打印Painter结构
     *
     * @param includeInterceptor 是否打印Interceptor
     */
    public void printStructure(boolean includeInterceptor) {
        painterSet.printStructure(0, includeInterceptor);
    }

    /**
     * Type枚举
     */
    public enum Type {
        /**
         * 默认
         */
        NONE(0, "none", NonePainter.class),
        /**
         * 竖线
         */
        LINE_VERTICAL(1, "line_vertical", VerticalLinePainter.class),
        /**
         * 横线
         */
        LINE_HORIZONTAL(2, "line_horizontal", HorizontalLinePainter.class),
        /**
         * 斜率为正的斜线
         */
        LINE_SLOPE_POSITIVE(3, "line_slope_positive", SlopePositiveLinePainter.class),
        /**
         * 斜率为负的斜线
         */
        LINE_SLOPE_NEGATIVE(4, "line_slope_negative", SlopeNegativeLinePainter.class),
        /**
         * 圆
         */
        CIRCLE(5, "circle", CirclePainter.class),
        /**
         * 椭圆
         */
        OVAL(6, "oval", OvalPainter.class),
        /**
         * 矩形
         */
        RECT(7, "rect", RectPainter.class),
        /**
         * 圆弧
         */
        ARC(8, "arc", ArcPainter.class),
        /**
         * 位图
         */
        BITMAP(9, "bitmap", BitmapPainter.class),
        /**
         * 多边形
         */
        POLYGON(10, "polygon", PolygonPainter.class),
        POLYGON_EXTRA(11, "polygon_extra", ExtraPolygonPainter.class),
        POLYGON_QUAD(12, "polygon_quad", QuadPolygonPainter.class),
        /**
         * 文本
         */
        TEXT(13, "text", TextPainter.class),
        /**
         * 点
         */
        POINT(14, "point", PointPainter.class),
        TODO_15(15, "", NonePainter.class),
        TODO_16(16, "", NonePainter.class),
        /**
         * 返回
         */
        BACK(17, "back", BackPainter.class),
        /**
         * 下一步
         */
        NEXT(18, "next", NextPainter.class),
        /**
         * 收缩
         */
        COLLAPSE(19, "collapse", CollapsePainter.class),
        /**
         * 展开
         */
        EXPAND(20, "expand", ExpandPainter.class),
        /**
         * 返回（圆框）
         */
        BACK_OVAL(21, "back_oval", BackOvalPainter.class),
        /**
         * 下一步（圆框）
         */
        NEXT_OVAL(22, "next_oval", NextOvalPainter.class),
        /**
         * 收缩（圆框）
         */
        COLLAPSE_OVAL(23, "collapse_oval", CollapseOvalPainter.class),
        /**
         * 展开（圆框）
         */
        EXPAND_OVAL(24, "expand_oval", ExpandOvalPainter.class),
        /**
         * 返回（矩形框）
         */
        BACK_RECT(25, "back_rect", BackRectPainter.class),
        /**
         * 下一步（矩形框）
         */
        NEXT_RECT(26, "next_rect", NextRectPainter.class),
        /**
         * 收缩（矩形框）
         */
        COLLAPSE_RECT(27, "collapse_rect", CollapseRectPainter.class),
        /**
         * 展开（矩形框）
         */
        EXPAND_RECT(28, "expand_rect", ExpandRectPainter.class),
        /**
         * 左箭头
         */
        ARROW_LEFT(29, "arrow_left", LeftArrowPainter.class),
        /**
         * 右箭头
         */
        ARROW_RIGHT(30, "arrow_right", RightArrowPainter.class),
        /**
         * 上箭头
         */
        ARROW_UP(31, "arrow_up", UpArrowPainter.class),
        /**
         * 下箭头
         */
        ARROW_DOWN(32, "arrow_down", DownArrowPainter.class),
        /**
         * 左箭头（圆框）
         */
        ARROW_LEFT_OVAL(33, "arrow_left_oval", LeftArrowOvalPainter.class),
        /**
         * 右箭头（圆框）
         */
        ARROW_RIGHT_OVAL(34, "arrow_right_oval", RightArrowOvalPainter.class),
        /**
         * 上箭头（圆框）
         */
        ARROW_UP_OVAL(35, "arrow_up_oval", UpArrowOvalPainter.class),
        /**
         * 下箭头（圆框）
         */
        ARROW_DOWN_OVAL(36, "arrow_down_oval", DownArrowOvalPainter.class),
        /**
         * 左箭头（矩形框）
         */
        ARROW_LEFT_RECT(37, "arrow_left_rect", LeftArrowRectPainter.class),
        /**
         * 右箭头（矩形框）
         */
        ARROW_RIGHT_RECT(38, "arrow_right_rect", RightArrowRectPainter.class),
        /**
         * 上箭头（矩形框）
         */
        ARROW_UP_RECT(39, "arrow_up_rect", UpArrowRectPainter.class),
        /**
         * 下箭头（矩形框）
         */
        ARROW_DOWN_RECT(40, "arrow_down_rect", DownArrowRectPainter.class),
        /**
         * 加号
         */
        ADD(41, "add", AddPainter.class),
        /**
         * 减号
         */
        MINUS(42, "minus", MinusPainter.class),
        /**
         * 勾
         */
        CORRECT(43, "correct", CorrectPainter.class),
        /**
         * 叉
         */
        ERROR(44, "error", ErrorPainter.class),
        /**
         * 加号（圆框）
         */
        ADD_OVAL(45, "add_oval", AddOvalPainter.class),
        /**
         * 减号（圆框）
         */
        MINUS_OVAL(46, "minus_oval", MinusOvalPainter.class),
        /**
         * 勾（圆框）
         */
        CORRECT_OVAL(47, "correct_oval", CorrectOvalPainter.class),
        /**
         * 叉（圆框）
         */
        ERROR_OVAL(48, "error_oval", ErrorOvalPainter.class),
        /**
         * 加号（矩形框）
         */
        ADD_RECT(49, "add_rect", AddRectPainter.class),
        /**
         * 减号（矩形框）
         */
        MINUS_RECT(50, "minus_rect", MinusRectPainter.class),
        /**
         * 勾（矩形框）
         */
        CORRECT_RECT(51, "correct_rect", CorrectRectPainter.class),
        /**
         * 叉（矩形框）
         */
        ERROR_RECT(52, "error_rect", ErrorRectPainter.class),
        /**
         * 设置
         */
        SETTING(53, "setting", SettingPainter.class, 0.5f),
        /**
         * 设置（api 21）
         */
        SETTING_V21(54, "setting_v21", SettingV21Painter.class, 0.5f),
        /**
         * 花型
         */
        FLOWER_EXTRA(55, "flower_extra", ExtraFlower.class),
        FLOWER_QUAD(56, "flower_quad", QuadFlower.class),
        /**
         * 菜单
         */
        MENU(57, "menu", MenuPainter.class),
        /**
         * 用户
         */
        USER(58, "user", UserPainter.class),
        /**
         * 男性
         */
        MALE(59, "male", MalePainter.class),
        /**
         * 女性
         */
        FEMALE(60, "female", FemalePainter.class),
        /**
         * 标记
         */
        SIGN(61, "sign", SignPainter.class),
        /**
         * 搜索
         */
        SEARCH(62, "search", SearchPainter.class),
        /**
         * 星星
         */
        STAR(63, "star", StarPainter.class),
        /**
         * 爱心
         */
        LOVE(64, "love", LovePainter.class, 0.5f),
        /**
         * 信封
         */
        ENVELOPE(65, "envelope", EnvelopePainter.class),
        /**
         * 时钟
         */
        CLOCK(66, "clock", ClockPainter.class),
        /**
         * 下载
         */
        DOWNLOAD(67, "download", DownloadPainter.class),
        /**
         * 上传
         */
        UPLOAD(68, "upload", UploadPainter.class);

        private int value;
        private String attrName;
        private Class<? extends Painter> painterClass;
        private float defaultPercent;

        Type(int value, String attrName, Class<? extends Painter> painterClass) {
            this(value, attrName, painterClass, 1f);
        }

        Type(int value, String attrName, Class<? extends Painter> painterClass, float defaultPercent) {
            this.value = value;
            this.attrName = attrName;
            this.painterClass = painterClass;
            this.defaultPercent = defaultPercent;
        }

        public int getValue() {
            return value;
        }

        public String getAttrName() {
            return attrName;
        }

        public Class<? extends Painter> getPainterClass() {
            return painterClass;
        }

        public float getDefaultPercent() {
            return defaultPercent;
        }
    }
}

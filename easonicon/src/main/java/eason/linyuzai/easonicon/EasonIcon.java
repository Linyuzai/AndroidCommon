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
import eason.linyuzai.easonicon.open.PainterSet;
import eason.linyuzai.easonicon.painter.EasonPainterSet;
import eason.linyuzai.easonicon.painter.combine.AddHollowOvalPainter;
import eason.linyuzai.easonicon.painter.combine.AddHollowRectPainter;
import eason.linyuzai.easonicon.painter.combine.AddPainter;
import eason.linyuzai.easonicon.painter.combine.AddSolidOvalPainter;
import eason.linyuzai.easonicon.painter.combine.AddSolidRectPainter;
import eason.linyuzai.easonicon.painter.combine.BackHollowOvalPainter;
import eason.linyuzai.easonicon.painter.combine.BackHollowRectPainter;
import eason.linyuzai.easonicon.painter.combine.BackPainter;
import eason.linyuzai.easonicon.painter.combine.BackSolidOvalPainter;
import eason.linyuzai.easonicon.painter.combine.BackSolidRectPainter;
import eason.linyuzai.easonicon.painter.combine.CollapseHollowOvalPainter;
import eason.linyuzai.easonicon.painter.combine.CollapseHollowRectPainter;
import eason.linyuzai.easonicon.painter.combine.CollapsePainter;
import eason.linyuzai.easonicon.painter.combine.CollapseSolidOvalPainter;
import eason.linyuzai.easonicon.painter.combine.CollapseSolidRectPainter;
import eason.linyuzai.easonicon.painter.combine.CorrectHollowOvalPainter;
import eason.linyuzai.easonicon.painter.combine.CorrectHollowRectPainter;
import eason.linyuzai.easonicon.painter.combine.CorrectPainter;
import eason.linyuzai.easonicon.painter.combine.CorrectSolidOvalPainter;
import eason.linyuzai.easonicon.painter.combine.CorrectSolidRectPainter;
import eason.linyuzai.easonicon.painter.combine.DownArrowHollowOvalPainter;
import eason.linyuzai.easonicon.painter.combine.DownArrowHollowRectPainter;
import eason.linyuzai.easonicon.painter.combine.DownArrowPainter;
import eason.linyuzai.easonicon.painter.combine.DownArrowSolidOvalPainter;
import eason.linyuzai.easonicon.painter.combine.DownArrowSolidRectPainter;
import eason.linyuzai.easonicon.painter.combine.ErrorHollowOvalPainter;
import eason.linyuzai.easonicon.painter.combine.ErrorHollowRectPainter;
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
import eason.linyuzai.easonicon.painter.combine.ErrorSolidOvalPainter;
import eason.linyuzai.easonicon.painter.combine.ErrorSolidRectPainter;
import eason.linyuzai.easonicon.painter.combine.ExpandHollowOvalPainter;
import eason.linyuzai.easonicon.painter.combine.ExpandHollowRectPainter;
import eason.linyuzai.easonicon.painter.combine.ExpandPainter;
import eason.linyuzai.easonicon.painter.combine.ExpandSolidOvalPainter;
import eason.linyuzai.easonicon.painter.combine.ExpandSolidRectPainter;
import eason.linyuzai.easonicon.painter.combine.LeftArrowHollowOvalPainter;
import eason.linyuzai.easonicon.painter.combine.LeftArrowHollowRectPainter;
import eason.linyuzai.easonicon.painter.combine.LeftArrowPainter;
import eason.linyuzai.easonicon.painter.combine.LeftArrowSolidOvalPainter;
import eason.linyuzai.easonicon.painter.combine.LeftArrowSolidRectPainter;
import eason.linyuzai.easonicon.painter.combine.MinusHollowOvalPainter;
import eason.linyuzai.easonicon.painter.combine.MinusHollowRectPainter;
import eason.linyuzai.easonicon.painter.combine.MinusPainter;
import eason.linyuzai.easonicon.painter.combine.MinusSolidOvalPainter;
import eason.linyuzai.easonicon.painter.combine.MinusSolidRectPainter;
import eason.linyuzai.easonicon.painter.combine.NextHollowOvalPainter;
import eason.linyuzai.easonicon.painter.combine.NextHollowRectPainter;
import eason.linyuzai.easonicon.painter.combine.NextPainter;
import eason.linyuzai.easonicon.painter.combine.NextSolidOvalPainter;
import eason.linyuzai.easonicon.painter.combine.NextSolidRectPainter;
import eason.linyuzai.easonicon.painter.combine.QuadFlower;
import eason.linyuzai.easonicon.painter.combine.RightArrowHollowOvalPainter;
import eason.linyuzai.easonicon.painter.combine.RightArrowHollowRectPainter;
import eason.linyuzai.easonicon.painter.combine.RightArrowPainter;
import eason.linyuzai.easonicon.painter.combine.RightArrowSolidOvalPainter;
import eason.linyuzai.easonicon.painter.combine.RightArrowSolidRectPainter;
import eason.linyuzai.easonicon.painter.combine.SettingPainter;
import eason.linyuzai.easonicon.painter.combine.UpArrowHollowOvalPainter;
import eason.linyuzai.easonicon.painter.combine.UpArrowHollowRectPainter;
import eason.linyuzai.easonicon.painter.combine.UpArrowPainter;
import eason.linyuzai.easonicon.painter.combine.UpArrowSolidOvalPainter;
import eason.linyuzai.easonicon.painter.combine.UpArrowSolidRectPainter;

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
            int penSize = a.getDimensionPixelSize(R.styleable.EasonIcon_icon_pen_size, 5);
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
            setType(type);
            setColor(color);
            setPenSize(penSize);
            setPenCap(Paint.Cap.values()[cap]);
            setPenJoin(Paint.Join.values()[join]);
            setPenStyle(Paint.Style.values()[style]);
            setPathEffect(new CornerPathEffect(pathEffectCorner));

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
        } else {
            setColor(Color.WHITE);
            setPenSize(5);
            setPenStyle(Paint.Style.STROKE);
            setPenCap(Paint.Cap.ROUND);
            auxiliaryColor = Color.WHITE;
            auxiliaryScale = 0.5f;
            edgeCount = 3;
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
            case Type.TEXT:
                // TODO: 2018/7/4
                break;
            case Type.BACK:
                painterSet.addPainter(new BackPainter());
                break;
            case Type.NEXT:
                painterSet.addPainter(new NextPainter());
                break;
            case Type.COLLAPSE:
                painterSet.addPainter(new CollapsePainter());
                break;
            case Type.EXPAND:
                painterSet.addPainter(new ExpandPainter());
                break;
            case Type.BACK_HOLLOW_OVAL:
                painterSet.addPainter(new BackHollowOvalPainter(auxiliaryScale));
                break;
            case Type.NEXT_HOLLOW_OVAL:
                painterSet.addPainter(new NextHollowOvalPainter(auxiliaryScale));
                break;
            case Type.COLLAPSE_HOLLOW_OVAL:
                painterSet.addPainter(new CollapseHollowOvalPainter(auxiliaryScale));
                break;
            case Type.EXPAND_HOLLOW_OVAL:
                painterSet.addPainter(new ExpandHollowOvalPainter(auxiliaryScale));
                break;
            case Type.BACK_SOLID_OVAL:
                painterSet.addPainter(new BackSolidOvalPainter(auxiliaryScale, auxiliaryColor));
                break;
            case Type.NEXT_SOLID_OVAL:
                painterSet.addPainter(new NextSolidOvalPainter(auxiliaryScale, auxiliaryColor));
                break;
            case Type.COLLAPSE_SOLID_OVAL:
                painterSet.addPainter(new CollapseSolidOvalPainter(auxiliaryScale, auxiliaryColor));
                break;
            case Type.EXPAND_SOLID_OVAL:
                painterSet.addPainter(new ExpandSolidOvalPainter(auxiliaryScale, auxiliaryColor));
                break;
            case Type.BACK_HOLLOW_RECT:
                painterSet.addPainter(new BackHollowRectPainter(auxiliaryScale, leftTopRound, leftBottomRound, rightTopRound, rightBottomRound));
                break;
            case Type.NEXT_HOLLOW_RECT:
                painterSet.addPainter(new NextHollowRectPainter(auxiliaryScale, leftTopRound, leftBottomRound, rightTopRound, rightBottomRound));
                break;
            case Type.COLLAPSE_HOLLOW_RECT:
                painterSet.addPainter(new CollapseHollowRectPainter(auxiliaryScale, leftTopRound, leftBottomRound, rightTopRound, rightBottomRound));
                break;
            case Type.EXPAND_HOLLOW_RECT:
                painterSet.addPainter(new ExpandHollowRectPainter(auxiliaryScale, leftTopRound, leftBottomRound, rightTopRound, rightBottomRound));
                break;
            case Type.BACK_SOLID_RECT:
                painterSet.addPainter(new BackSolidRectPainter(auxiliaryScale, auxiliaryColor, leftTopRound, leftBottomRound, rightTopRound, rightBottomRound));
                break;
            case Type.NEXT_SOLID_RECT:
                painterSet.addPainter(new NextSolidRectPainter(auxiliaryScale, auxiliaryColor, leftTopRound, leftBottomRound, rightTopRound, rightBottomRound));
                break;
            case Type.COLLAPSE_SOLID_RECT:
                painterSet.addPainter(new CollapseSolidRectPainter(auxiliaryScale, auxiliaryColor, leftTopRound, leftBottomRound, rightTopRound, rightBottomRound));
                break;
            case Type.EXPAND_SOLID_RECT:
                painterSet.addPainter(new ExpandSolidRectPainter(auxiliaryScale, auxiliaryColor, leftTopRound, leftBottomRound, rightTopRound, rightBottomRound));
                break;
            case Type.ARROW_LEFT:
                painterSet.addPainter(new LeftArrowPainter());
                break;
            case Type.ARROW_RIGHT:
                painterSet.addPainter(new RightArrowPainter());
                break;
            case Type.ARROW_UP:
                painterSet.addPainter(new UpArrowPainter());
                break;
            case Type.ARROW_DOWN:
                painterSet.addPainter(new DownArrowPainter());
                break;
            case Type.ARROW_LEFT_HOLLOW_OVAL:
                painterSet.addPainter(new LeftArrowHollowOvalPainter(auxiliaryScale));
                break;
            case Type.ARROW_RIGHT_HOLLOW_OVAL:
                painterSet.addPainter(new RightArrowHollowOvalPainter(auxiliaryScale));
                break;
            case Type.ARROW_UP_HOLLOW_OVAL:
                painterSet.addPainter(new UpArrowHollowOvalPainter(auxiliaryScale));
                break;
            case Type.ARROW_DOWN_HOLLOW_OVAL:
                painterSet.addPainter(new DownArrowHollowOvalPainter(auxiliaryScale));
                break;
            case Type.ARROW_LEFT_SOLID_OVAL:
                painterSet.addPainter(new LeftArrowSolidOvalPainter(auxiliaryScale, auxiliaryColor));
                break;
            case Type.ARROW_RIGHT_SOLID_OVAL:
                painterSet.addPainter(new RightArrowSolidOvalPainter(auxiliaryScale, auxiliaryColor));
                break;
            case Type.ARROW_UP_SOLID_OVAL:
                painterSet.addPainter(new UpArrowSolidOvalPainter(auxiliaryScale, auxiliaryColor));
                break;
            case Type.ARROW_DOWN_SOLID_OVAL:
                painterSet.addPainter(new DownArrowSolidOvalPainter(auxiliaryScale, auxiliaryColor));
                break;
            case Type.ARROW_LEFT_HOLLOW_RECT:
                painterSet.addPainter(new LeftArrowHollowRectPainter(auxiliaryScale, leftTopRound, leftBottomRound, rightTopRound, rightBottomRound));
                break;
            case Type.ARROW_RIGHT_HOLLOW_RECT:
                painterSet.addPainter(new RightArrowHollowRectPainter(auxiliaryScale, leftTopRound, leftBottomRound, rightTopRound, rightBottomRound));
                break;
            case Type.ARROW_UP_HOLLOW_RECT:
                painterSet.addPainter(new UpArrowHollowRectPainter(auxiliaryScale, leftTopRound, leftBottomRound, rightTopRound, rightBottomRound));
                break;
            case Type.ARROW_DOWN_HOLLOW_RECT:
                painterSet.addPainter(new DownArrowHollowRectPainter(auxiliaryScale, leftTopRound, leftBottomRound, rightTopRound, rightBottomRound));
                break;
            case Type.ARROW_LEFT_SOLID_RECT:
                painterSet.addPainter(new LeftArrowSolidRectPainter(auxiliaryScale, auxiliaryColor, leftTopRound, leftBottomRound, rightTopRound, rightBottomRound));
                break;
            case Type.ARROW_RIGHT_SOLID_RECT:
                painterSet.addPainter(new RightArrowSolidRectPainter(auxiliaryScale, auxiliaryColor, leftTopRound, leftBottomRound, rightTopRound, rightBottomRound));
                break;
            case Type.ARROW_UP_SOLID_RECT:
                painterSet.addPainter(new UpArrowSolidRectPainter(auxiliaryScale, auxiliaryColor, leftTopRound, leftBottomRound, rightTopRound, rightBottomRound));
                break;
            case Type.ARROW_DOWN_SOLID_RECT:
                painterSet.addPainter(new DownArrowSolidRectPainter(auxiliaryScale, auxiliaryColor, leftTopRound, leftBottomRound, rightTopRound, rightBottomRound));
                break;
            case Type.ADD:
                painterSet.addPainter(new AddPainter());
                break;
            case Type.MINUS:
                painterSet.addPainter(new MinusPainter());
                break;
            case Type.CORRECT:
                painterSet.addPainter(new CorrectPainter());
                break;
            case Type.ERROR:
                painterSet.addPainter(new ErrorPainter());
                break;
            case Type.ADD_HOLLOW_OVAL:
                painterSet.addPainter(new AddHollowOvalPainter(auxiliaryScale));
                break;
            case Type.MINUS_HOLLOW_OVAL:
                painterSet.addPainter(new MinusHollowOvalPainter(auxiliaryScale));
                break;
            case Type.CORRECT_HOLLOW_OVAL:
                painterSet.addPainter(new CorrectHollowOvalPainter(auxiliaryScale));
                break;
            case Type.ERROR_HOLLOW_OVAL:
                painterSet.addPainter(new ErrorHollowOvalPainter(auxiliaryScale));
                break;
            case Type.ADD_SOLID_OVAL:
                painterSet.addPainter(new AddSolidOvalPainter(auxiliaryScale, auxiliaryColor));
                break;
            case Type.MINUS_SOLID_OVAL:
                painterSet.addPainter(new MinusSolidOvalPainter(auxiliaryScale, auxiliaryColor));
                break;
            case Type.CORRECT_SOLID_OVAL:
                painterSet.addPainter(new CorrectSolidOvalPainter(auxiliaryScale, auxiliaryColor));
                break;
            case Type.ERROR_SOLID_OVAL:
                painterSet.addPainter(new ErrorSolidOvalPainter(auxiliaryScale, auxiliaryColor));
                break;
            case Type.ADD_HOLLOW_RECT:
                painterSet.addPainter(new AddHollowRectPainter(auxiliaryScale, leftTopRound, leftBottomRound, rightTopRound, rightBottomRound));
                break;
            case Type.MINUS_HOLLOW_RECT:
                painterSet.addPainter(new MinusHollowRectPainter(auxiliaryScale, leftTopRound, leftBottomRound, rightTopRound, rightBottomRound));
                break;
            case Type.CORRECT_HOLLOW_RECT:
                painterSet.addPainter(new CorrectHollowRectPainter(auxiliaryScale, leftTopRound, leftBottomRound, rightTopRound, rightBottomRound));
                break;
            case Type.ERROR_HOLLOW_RECT:
                painterSet.addPainter(new ErrorHollowRectPainter(auxiliaryScale, leftTopRound, leftBottomRound, rightTopRound, rightBottomRound));
                break;
            case Type.ADD_SOLID_RECT:
                painterSet.addPainter(new AddSolidRectPainter(auxiliaryScale, auxiliaryColor, leftTopRound, leftBottomRound, rightTopRound, rightBottomRound));
                break;
            case Type.MINUS_SOLID_RECT:
                painterSet.addPainter(new MinusSolidRectPainter(auxiliaryScale, auxiliaryColor, leftTopRound, leftBottomRound, rightTopRound, rightBottomRound));
                break;
            case Type.CORRECT_SOLID_RECT:
                painterSet.addPainter(new CorrectSolidRectPainter(auxiliaryScale, auxiliaryColor, leftTopRound, leftBottomRound, rightTopRound, rightBottomRound));
                break;
            case Type.ERROR_SOLID_RECT:
                painterSet.addPainter(new ErrorSolidRectPainter(auxiliaryScale, auxiliaryColor, leftTopRound, leftBottomRound, rightTopRound, rightBottomRound));
                break;
            case Type.SETTING:
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    painterSet.addPainter(new SettingPainter());
                }
                break;
            case Type.QUAD_FLOWER:
                painterSet.addPainter(new QuadFlower(edgeCount));
                break;
        }
    }

    public void addPainter(Painter painter) {
        painterSet.addPainter(painter);
    }

    public void addPainter(int index, Painter painter) {
        painterSet.addPainter(index, painter);
    }

    public void removePainter(Painter painter) {
        painterSet.removePainter(painter);
    }

    public void removePainter(int index) {
        painterSet.removePainter(index);
    }

    public void clearPainter() {
        painterSet.clearPainter();
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

    public Paint.Cap getPenCap() {
        return paint.getStrokeCap();
    }

    public void setPenCap(Paint.Cap cap) {
        paint.setStrokeCap(cap);
    }

    public Paint.Join getPenJoin() {
        return paint.getStrokeJoin();
    }

    public void setPenJoin(Paint.Join join) {
        paint.setStrokeJoin(join);
    }

    public PathEffect setPathEffect() {
        return paint.getPathEffect();
    }

    public void setPathEffect(PathEffect effect) {
        paint.setPathEffect(effect);
    }

    public Paint.Style getPenStyle() {
        return paint.getStyle();
    }

    public void setPenStyle(Paint.Style style) {
        paint.setStyle(style);
    }

    public Paint getPaint() {
        return paint;
    }

    public PainterSet getPainterSet() {
        return painterSet;
    }

    public Painter getPainter(int index) {
        return painterSet.getPainter(index);
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
        //drawRectF = new RectF(0, 0, width, height);
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
        public static final int LINE_VERTICAL = 1;
        /**
         * 水平线
         */
        public static final int LINE_HORIZONTAL = 2;
        /**
         * 左上右下斜线
         */
        public static final int LINE_SLOPE_POSITIVE = 3;
        /**
         * 左下右上斜线
         */
        public static final int LINE_SLOPE_NEGATIVE = 4;
        /**
         * 圆
         */
        public static final int CIRCLE = 5;
        /**
         * 椭圆
         */
        public static final int OVAL = 6;

        public static final int RECT = 7;

        public static final int ARC = 8;

        public static final int BITMAP = 9;

        public static final int POLYGON = 10;

        public static final int POLYGON_EXTRA = 11;

        public static final int POLYGON_QUAD = 12;

        public static final int TEXT = 13;

        //组合
        /**
         * 返回
         */
        public static final int BACK = 17;

        public static final int NEXT = 18;

        public static final int COLLAPSE = 19;

        public static final int EXPAND = 20;

        public static final int BACK_HOLLOW_OVAL = 21;

        public static final int NEXT_HOLLOW_OVAL = 22;

        public static final int COLLAPSE_HOLLOW_OVAL = 23;

        public static final int EXPAND_HOLLOW_OVAL = 24;

        public static final int BACK_SOLID_OVAL = 25;

        public static final int NEXT_SOLID_OVAL = 26;

        public static final int COLLAPSE_SOLID_OVAL = 27;

        public static final int EXPAND_SOLID_OVAL = 28;

        public static final int BACK_HOLLOW_RECT = 29;

        public static final int NEXT_HOLLOW_RECT = 30;

        public static final int COLLAPSE_HOLLOW_RECT = 31;

        public static final int EXPAND_HOLLOW_RECT = 32;

        public static final int BACK_SOLID_RECT = 33;

        public static final int NEXT_SOLID_RECT = 34;

        public static final int COLLAPSE_SOLID_RECT = 35;

        public static final int EXPAND_SOLID_RECT = 36;

        public static final int ARROW_LEFT = 37;

        public static final int ARROW_RIGHT = 38;

        public static final int ARROW_UP = 39;

        public static final int ARROW_DOWN = 40;

        public static final int ARROW_LEFT_HOLLOW_OVAL = 41;

        public static final int ARROW_RIGHT_HOLLOW_OVAL = 42;

        public static final int ARROW_UP_HOLLOW_OVAL = 43;

        public static final int ARROW_DOWN_HOLLOW_OVAL = 44;

        public static final int ARROW_LEFT_SOLID_OVAL = 45;

        public static final int ARROW_RIGHT_SOLID_OVAL = 46;

        public static final int ARROW_UP_SOLID_OVAL = 47;

        public static final int ARROW_DOWN_SOLID_OVAL = 48;

        public static final int ARROW_LEFT_HOLLOW_RECT = 49;

        public static final int ARROW_RIGHT_HOLLOW_RECT = 50;

        public static final int ARROW_UP_HOLLOW_RECT = 51;

        public static final int ARROW_DOWN_HOLLOW_RECT = 52;

        public static final int ARROW_LEFT_SOLID_RECT = 53;

        public static final int ARROW_RIGHT_SOLID_RECT = 54;

        public static final int ARROW_UP_SOLID_RECT = 55;

        public static final int ARROW_DOWN_SOLID_RECT = 56;

        public static final int ADD = 57;

        public static final int MINUS = 58;

        public static final int CORRECT = 59;

        public static final int ERROR = 60;

        public static final int ADD_HOLLOW_OVAL = 61;

        public static final int MINUS_HOLLOW_OVAL = 62;

        public static final int CORRECT_HOLLOW_OVAL = 63;

        public static final int ERROR_HOLLOW_OVAL = 64;

        public static final int ADD_SOLID_OVAL = 65;

        public static final int MINUS_SOLID_OVAL = 66;

        public static final int CORRECT_SOLID_OVAL = 67;

        public static final int ERROR_SOLID_OVAL = 68;

        public static final int ADD_HOLLOW_RECT = 69;

        public static final int MINUS_HOLLOW_RECT = 70;

        public static final int CORRECT_HOLLOW_RECT = 71;

        public static final int ERROR_HOLLOW_RECT = 72;

        public static final int ADD_SOLID_RECT = 73;

        public static final int MINUS_SOLID_RECT = 74;

        public static final int CORRECT_SOLID_RECT = 75;

        public static final int ERROR_SOLID_RECT = 76;

        public static final int SETTING = 77;

        public static final int QUAD_FLOWER = 78;
    }
}

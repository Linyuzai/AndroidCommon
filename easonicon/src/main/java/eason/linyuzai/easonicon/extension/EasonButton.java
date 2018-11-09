package eason.linyuzai.easonicon.extension;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.TextView;

import eason.linyuzai.easonicon.R;
import eason.linyuzai.easonicon.open.Painter;

public class EasonButton extends AppCompatButton implements View.OnClickListener {

    private int oldWidth;
    private int oldHeight;

    private Paint paint = new Paint();
    private RectF draw = new RectF();
    private RectF original = new RectF();

    private Painter painter;

    private int state = State.TEXT_DISPLAY;
    private boolean isIconStyle = false;

    private AnimatorSet beforeIconLayoutAnim;
    private AnimatorSet afterIconLayoutAnim;

    private boolean isClickToChangeIconStyle = false;

    private boolean onAnim = false;

    public EasonButton(Context context) {
        super(context);
        init(context, null, paint);
    }

    public EasonButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, paint);
    }

    public EasonButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, paint);
    }

    protected void init(Context context, AttributeSet attrs, Paint paint) {
        if (attrs != null) {
            TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.EasonButton);
            isClickToChangeIconStyle = a.getBoolean(R.styleable.EasonButton_eic_click_to_change_icon_style, false);
            a.recycle();
        }
        setOnClickListener(this);
        paint.setAntiAlias(true);
        beforeIconLayoutAnim = new AnimatorSet();

        beforeIconLayoutAnim.setDuration(300);
        beforeIconLayoutAnim.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationStart(Animator animation) {
                onAnim = true;
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                state = State.ICON_DISPLAY;
                onAnim = false;
                invalidate();
            }
        });

        afterIconLayoutAnim = new AnimatorSet();
        afterIconLayoutAnim.setDuration(300);
        afterIconLayoutAnim.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationStart(Animator animation) {
                onAnim = true;
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                state = State.TEXT_DISPLAY;
                onAnim = false;
                invalidate();
            }
        });
    }

    public boolean isIconStyle() {
        return isIconStyle;
    }

    public void setIconStyle(boolean isIconStyle) {
        this.isIconStyle = isIconStyle;
        if (isIconStyle) {
            if (state == State.TEXT_DISPLAY) {
                state = State.BEFORE_ICON_LAYOUT_ANIM;
                invalidate();
            } else {

            }
        } else {
            if (state == State.ICON_DISPLAY) {
                state = State.AFTER_ICON_LAYOUT_ANIM;
                invalidate();
            } else {

            }
        }
    }

    public int getState() {
        return state;
    }

    public Painter getPainter() {
        return painter;
    }

    public void setPainter(Painter painter) {
        this.painter = painter;
    }

    public boolean isClickToChangeIconStyle() {
        return isClickToChangeIconStyle;
    }

    public void setClickToChangeIconStyle(boolean clickToChangeIconStyle) {
        isClickToChangeIconStyle = clickToChangeIconStyle;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        switch (state) {
            case State.TEXT_DISPLAY:
                setEnabled(true);
                break;
            case State.BEFORE_ICON_LAYOUT_ANIM:
                if (onAnim) {

                } else {
                    beforeIconLayoutAnim.start();
                }
                break;
            case State.ICON_DISPLAY:
                if (painter != null) {
                    painter.draw(canvas, draw, original, paint);
                }
                break;
            case State.AFTER_ICON_LAYOUT_ANIM:
                if (onAnim) {

                } else {
                    afterIconLayoutAnim.start();
                }
                break;
        }
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        if (oldWidth == 0 && oldHeight == 0) {
            oldWidth = w;
            oldHeight = h;
            int size = Math.min(w, h);
            int top = getPaddingTop();
            int bottom = size - getPaddingBottom();
            int left = getPaddingLeft();
            int right = size - getPaddingRight();
            original.set(0f, 0f, size, size);
            draw.set(left, top, right, bottom);

            int oldTextColor = getCurrentTextColor();
            WidthWrapper widthWrapper = new WidthWrapper(this);
            TextColorWrapper textColorWrapper = new TextColorWrapper(this);

            ObjectAnimator wba = ObjectAnimator.ofInt(widthWrapper, "wrapperWidth", oldWidth, size);
            ObjectAnimator tba = ObjectAnimator.ofInt(textColorWrapper, "wrapperTextColor", oldTextColor, Color.TRANSPARENT);
            tba.setInterpolator(new LinearInterpolator());
            tba.setEvaluator(new ArgbEvaluator());
            beforeIconLayoutAnim.playTogether(wba, tba);

            ObjectAnimator waa = ObjectAnimator.ofInt(widthWrapper, "wrapperWidth", size, oldWidth);
            ObjectAnimator taa = ObjectAnimator.ofInt(textColorWrapper, "wrapperTextColor", Color.TRANSPARENT, oldTextColor);
            taa.setInterpolator(new LinearInterpolator());
            taa.setEvaluator(new ArgbEvaluator());
            afterIconLayoutAnim.playTogether(waa, taa);
        }
    }

    @Override
    public void onClick(View v) {
        if (isClickToChangeIconStyle && state == State.TEXT_DISPLAY) {
            setEnabled(false);
            //getLayoutParams().width = size;
            //requestLayout();//必须调用，否则宽度改变但UI没有刷新
            //beforeIconLayoutAnim.start();
            setIconStyle(true);
        }
    }

    private static class TextColorWrapper {
        private TextView textView;

        private TextColorWrapper(TextView textView) {
            this.textView = textView;
        }

        public int getWrapperTextColor() {
            return textView.getCurrentTextColor();
        }

        public void setWrapperTextColor(int color) {
            textView.setTextColor(color);
        }
    }

    private static class WidthWrapper {
        private View view;

        private WidthWrapper(View view) {
            this.view = view;
        }

        public int getWrapperWidth() {
            return view.getLayoutParams().width;
        }

        public void setWrapperWidth(int width) {
            //ViewGroup.LayoutParams lp = view.getLayoutParams();
            //lp.width = width;
            //view.setLayoutParams(lp);
            view.getLayoutParams().width = width;
            view.requestLayout();//必须调用，否则宽度改变但UI没有刷新
        }
    }

    public static class State {
        public static final int TEXT_DISPLAY = 0;
        public static final int BEFORE_ICON_LAYOUT_ANIM = 1;
        public static final int ICON_DISPLAY = 2;
        public static final int AFTER_ICON_LAYOUT_ANIM = 3;
    }
}

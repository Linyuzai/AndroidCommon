package eason.linyuzai.easonbar.nav;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.annotation.StyleRes;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import eason.linyuzai.easonbar.entity.EasonEntity;
import eason.linyuzai.easonbar.nav.component.EasonNavActionButtonClickListener;
import eason.linyuzai.easonbar.nav.component.EasonNavController;

/**
 * Created by linyuzai on 2018/5/9.
 *
 * @author linyuzai
 */

public class EasonNav extends FrameLayout implements View.OnClickListener {

    public static final int ACTION_BUTTON_LEFT_LEFT = 0;
    public static final int ACTION_BUTTON_LEFT_RIGHT = 1;
    public static final int ACTION_BUTTON_RIGHT_LEFT = 2;
    public static final int ACTION_BUTTON_RIGHT_RIGHT = 3;
    public static final int ACTION_BUTTON_CENTER = 4;

    private ActionButton leftLeft;
    private ActionButton leftRight;
    private ActionButton rightLeft;
    private ActionButton rightRight;

    private ActionButton center;

    private EasonNavController controller = new Controller();

    private EasonNavActionButtonClickListener listener;

    public EasonNav(@NonNull Context context) {
        super(context);
        initialize();
    }

    public EasonNav(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initialize();
    }

    public EasonNav(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initialize();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public EasonNav(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr, @StyleRes int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initialize();
    }

    private void initialize() {
        setBackgroundColor(Color.WHITE);
    }

    public EasonNavController getController() {
        return controller;
    }

    public EasonNavActionButtonClickListener getOnActionButtonClickListener() {
        return listener;
    }

    public void setOnActionButtonClickListener(EasonNavActionButtonClickListener listener) {
        this.listener = listener;
    }

    public ActionButton getActionButton(int location) {
        switch (location) {
            case ACTION_BUTTON_LEFT_LEFT:
                return leftLeft;
            case ACTION_BUTTON_LEFT_RIGHT:
                return leftRight;
            case ACTION_BUTTON_RIGHT_LEFT:
                return rightLeft;
            case ACTION_BUTTON_RIGHT_RIGHT:
                return rightRight;
            case ACTION_BUTTON_CENTER:
                return center;
        }
        return null;
    }

    private class Controller implements EasonNavController {

        @SuppressWarnings("unchecked")
        @Override
        public <T extends BaseEntity> T getEntity(int location) {
            ActionButton button = getActionButton(location);
            if (button == null)
                return null;
            if (button.getType() == ActionButton.TYPE_TEXT)
                return (T) ((TextActionButton) button).getEntity();
            else if (button.getType() == ActionButton.TYPE_IMAGE)
                return (T) ((ImageActionButton) button).getEntity();
            return null;
        }

        @Override
        public <T extends BaseEntity> void setEntity(T entity, int location) {
            ActionButton button = null;
            int height = getLayoutParams().height;
            if (entity instanceof TextEntity) {
                button = new TextActionButton(getContext()).setEntity((TextEntity) entity);
            } else if (entity instanceof ImageEntity) {
                button = new ImageActionButton(getContext()).setEntity((ImageEntity) entity);
            }
            if (button != null) {
                button.initialize(height, location);
                button.setOnClickListener(EasonNav.this);
                switch (location) {
                    case ACTION_BUTTON_LEFT_LEFT:
                        leftLeft = button;
                        break;
                    case ACTION_BUTTON_LEFT_RIGHT:
                        leftRight = button;
                        break;
                    case ACTION_BUTTON_RIGHT_LEFT:
                        rightLeft = button;
                        break;
                    case ACTION_BUTTON_RIGHT_RIGHT:
                        rightRight = button;
                        break;
                    case ACTION_BUTTON_CENTER:
                        center = button;
                        break;
                }
            }
        }

        @Override
        public <T extends BaseEntity> void setEntityWithLayout(T entity, int location) {
            setEntity(entity, location);
            initialize(location);
        }

        @Override
        public void initialize(int location) {
            switch (location) {
                case ACTION_BUTTON_LEFT_LEFT:
                    if (leftLeft != null && !leftLeft.isInitialized()) {
                        addView(leftLeft);
                        leftLeft.setInitialized(true);
                    }
                    break;
                case ACTION_BUTTON_LEFT_RIGHT:
                    if (leftRight != null && !leftRight.isInitialized()) {
                        addView(leftRight);
                        leftRight.setInitialized(true);
                    }
                    break;
                case ACTION_BUTTON_RIGHT_LEFT:
                    if (rightLeft != null && !rightLeft.isInitialized()) {
                        addView(rightLeft);
                        rightLeft.setInitialized(true);
                    }
                    break;
                case ACTION_BUTTON_RIGHT_RIGHT:
                    if (rightRight != null && !rightRight.isInitialized()) {
                        addView(rightRight);
                        rightRight.setInitialized(true);
                    }
                    break;
                case ACTION_BUTTON_CENTER:
                    if (center != null && !center.isInitialized()) {
                        addView(center);
                        center.setInitialized(true);
                    }
                    break;
            }
        }

        @Override
        public void initialize() {
            initialize(ACTION_BUTTON_LEFT_LEFT);
            initialize(ACTION_BUTTON_LEFT_RIGHT);
            initialize(ACTION_BUTTON_RIGHT_LEFT);
            initialize(ACTION_BUTTON_RIGHT_RIGHT);
            initialize(ACTION_BUTTON_CENTER);
        }
    }

    public static class BaseEntity extends EasonEntity {
        private static final String BACKGROUND_DRAWABLE = "background_drawable";
        private static final String MARGIN_LEFT = "margin_left";
        private static final String MARGIN_RIGHT = "margin_right";

        public BaseEntity() {
            setMarginLeft(0);
            setMarginRight(0);
            setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        }

        public Drawable getBackgroundDrawable() {
            return get(getKey(BACKGROUND_DRAWABLE));
        }

        public void setBackgroundDrawable(Drawable drawable) {
            add(getKey(BACKGROUND_DRAWABLE), drawable);
        }

        public int getMarginLeft() {
            return get(getKey(MARGIN_LEFT));
        }

        public void setMarginLeft(int marginLeft) {
            add(getKey(MARGIN_LEFT), marginLeft);
        }

        public int getMarginRight() {
            return get(getKey(MARGIN_RIGHT));
        }

        public void setMarginRight(int marginRight) {
            add(getKey(MARGIN_RIGHT), marginRight);
        }
    }

    public static class TextEntity extends BaseEntity {
        private static final String TEXT = "text";
        private static final String TEXT_COLOR = "text_color";
        private static final String TEXT_SIZE = "text_size";
        private static final String PADDING_LEFT = "padding_left";
        private static final String PADDING_RIGHT = "padding_right";

        public TextEntity() {
            super();
            setText("");
            setTextColor(Color.BLACK);
            setTextSize(14f);
            setPaddingLeft(0);
            setPaddingRight(0);
        }

        public String getText() {
            return get(getKey(TEXT));
        }

        public void setText(String text) {
            add(getKey(TEXT), text);
        }

        public int getTextColor() {
            return get(getKey(TEXT_COLOR));
        }

        public void setTextColor(int color) {
            add(getKey(TEXT_COLOR), color);
        }

        public float getTextSize() {
            return get(getKey(TEXT_SIZE));
        }

        public void setTextSize(float textSize) {
            add(getKey(TEXT_SIZE), textSize);
        }

        public int getPaddingLeft() {
            return get(getKey(PADDING_LEFT));
        }

        public void setPaddingLeft(int paddingLeft) {
            add(getKey(PADDING_LEFT), paddingLeft);
        }

        public int getPaddingRight() {
            return get(getKey(PADDING_RIGHT));
        }

        public void setPaddingRight(int paddingRight) {
            add(getKey(PADDING_RIGHT), paddingRight);
        }
    }

    public static class ImageEntity extends BaseEntity {
        private static final String DRAWABLE = "drawable";
        private static final String RATIO = "ratio";

        public ImageEntity() {
            super();
            setRatio(0.7f);
        }

        public Drawable getDrawable() {
            return get(getKey(DRAWABLE));
        }

        public void setDrawable(Drawable drawable) {
            add(getKey(DRAWABLE), drawable);
        }

        public float getRatio() {
            return get(getKey(RATIO));
        }

        public void setRatio(float ratio) {
            add(getKey(RATIO), ratio);
        }
    }

    public static class ActionButton<T extends BaseEntity> extends FrameLayout {

        public static final int TYPE_NONE = 0;
        public static final int TYPE_TEXT = 1;
        public static final int TYPE_IMAGE = 2;

        private int type;
        private int location;

        private T entity;

        private boolean isInitialized;

        public ActionButton(@NonNull Context context) {
            super(context);
        }

        public ActionButton(@NonNull Context context, @Nullable AttributeSet attrs) {
            super(context, attrs);
        }

        public ActionButton(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
            super(context, attrs, defStyleAttr);
        }

        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        public ActionButton(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr, @StyleRes int defStyleRes) {
            super(context, attrs, defStyleAttr, defStyleRes);
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getLocation() {
            return location;
        }

        public void setLocation(int location) {
            this.location = location;
        }

        public ActionButton setEntity(T entity) {
            this.entity = entity;
            return this;
        }

        public T getEntity() {
            return entity;
        }

        public boolean isInitialized() {
            return isInitialized;
        }

        public void setInitialized(boolean initialized) {
            isInitialized = initialized;
        }

        @SuppressLint("RtlHardcoded")
        public void initialize(int height, int location) {
            type = TYPE_NONE;
            this.location = location;
            int gravity = Gravity.NO_GRAVITY;
            int marginLeft = entity.getMarginLeft();
            int marginRight = entity.getMarginRight();
            switch (location) {
                case ACTION_BUTTON_LEFT_LEFT:
                    gravity = Gravity.LEFT;
                    break;
                case ACTION_BUTTON_LEFT_RIGHT:
                    gravity = Gravity.LEFT;
                    marginLeft += height;
                    break;
                case ACTION_BUTTON_RIGHT_LEFT:
                    gravity = Gravity.RIGHT;
                    marginRight += height;
                    break;
                case ACTION_BUTTON_RIGHT_RIGHT:
                    gravity = Gravity.RIGHT;
                    break;
                case ACTION_BUTTON_CENTER:
                    gravity = Gravity.CENTER;
                    break;
            }
            int width = height;
            if (entity instanceof TextEntity)
                width = LayoutParams.WRAP_CONTENT;
            LayoutParams params = new LayoutParams(width, LayoutParams.MATCH_PARENT, gravity);
            params.leftMargin = marginLeft;
            params.rightMargin = marginRight;
            setLayoutParams(params);
            setBackgroundDrawable(entity.getBackgroundDrawable());
        }
    }

    public static class TextActionButton extends ActionButton<TextEntity> {

        private TextView text;

        public TextActionButton(@NonNull Context context) {
            super(context);
        }

        public TextActionButton(@NonNull Context context, @Nullable AttributeSet attrs) {
            super(context, attrs);
        }

        public TextActionButton(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
            super(context, attrs, defStyleAttr);
        }

        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        public TextActionButton(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr, @StyleRes int defStyleRes) {
            super(context, attrs, defStyleAttr, defStyleRes);
        }

        @Override
        public void initialize(int height, int location) {
            super.initialize(height, location);
            TextEntity entity = getEntity();
            setType(TYPE_TEXT);
            text = new TextView(getContext());
            text.setText(entity.getText());
            text.setTextColor(entity.getTextColor());
            text.setTextSize(entity.getTextSize());
            text.setPadding(entity.getPaddingLeft(), 0, entity.getPaddingRight(), 0);
            addView(text, new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, Gravity.CENTER_VERTICAL));
        }

        public TextView getTextView() {
            return text;
        }
    }

    public static class ImageActionButton extends ActionButton<ImageEntity> {

        private ImageView image;

        public ImageActionButton(@NonNull Context context) {
            super(context);
        }

        public ImageActionButton(@NonNull Context context, @Nullable AttributeSet attrs) {
            super(context, attrs);
        }

        public ImageActionButton(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
            super(context, attrs, defStyleAttr);
        }

        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        public ImageActionButton(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr, @StyleRes int defStyleRes) {
            super(context, attrs, defStyleAttr, defStyleRes);
        }

        @Override
        public void initialize(int height, int location) {
            super.initialize(height, location);
            ImageEntity entity = getEntity();
            setType(TYPE_IMAGE);
            image = new ImageView(getContext());
            image.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            image.setImageDrawable(entity.getDrawable());
            int widthAndHeight = (int) (height * entity.getRatio());
            addView(image, new LayoutParams(widthAndHeight, widthAndHeight, Gravity.CENTER));
        }

        public ImageView getImageView() {
            return image;
        }
    }

    @Override
    public void onClick(View v) {
        if (listener != null && v instanceof ActionButton) {
            listener.onActionButtonClick((ActionButton) v, ((ActionButton) v).getLocation());
        }
    }
}

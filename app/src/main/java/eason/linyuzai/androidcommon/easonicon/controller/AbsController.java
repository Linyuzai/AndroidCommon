package eason.linyuzai.androidcommon.easonicon.controller;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.text.method.DigitsKeyListener;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import eason.linyuzai.androidcommon.R;
import eason.linyuzai.androidcommon.easonicon.entity.TargetEntity;
import eason.linyuzai.easonicon.EasonIcon;
import eason.linyuzai.easonicon.open.Painter;
import eason.linyuzai.elib.component.EasonActivity;

public abstract class AbsController extends LinearLayout {
    public static final int TEXT_WIDTH = 117;
    public static final int VALUE_WIDTH = 43;

    private EasonActivity eason;
    private TextView value;

    private EasonIcon icon;

    private SeekBar seekBar;
    private Painter painter;
    private TargetEntity entity;

    private EditText et;
    private AlertDialog dialog;

    public AbsController(Context context, EasonIcon icon) {
        super(context);

        this.icon = icon;
        painter = icon.getPainterSet();

        setOrientation(LinearLayout.HORIZONTAL);
        setGravity(Gravity.CENTER_VERTICAL);
        eason = (EasonActivity) context;

        int padding = eason.dip(8);
        setPadding(padding, padding, padding, padding);

        int textColor = Color.parseColor("#888888");

        TextView textView = new TextView(context);
        textView.setText(getAttrName());
        textView.setTextColor(textColor);
        textView.setTextSize(15f);
        addView(textView, new LayoutParams(eason.dip(AbsController.TEXT_WIDTH), LayoutParams.WRAP_CONTENT));
        initValueDialog();
        value = new TextView(context);
        value.setTextColor(textColor);
        value.setTextSize(15f);
        value.setOnClickListener(v -> {
            if (dialog != null)
                dialog.show();
        });
        addView(value, new LayoutParams(eason.dip(AbsController.VALUE_WIDTH), LayoutParams.WRAP_CONTENT));
    }

    private void initValueDialog() {
        if (dialog != null)
            return;
        et = new EditText(getContext());
        et.setKeyListener(new DigitsKeyListener() {
            @NonNull
            @Override
            protected char[] getAcceptedChars() {
                return new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '.'};
            }
        });
        dialog = new AlertDialog.Builder(getContext(), AlertDialog.THEME_HOLO_LIGHT)
                .setTitle("Value")
                .setView(et)
                .setCancelable(false)
                .setPositiveButton("Ok", (dialog, which) -> {
                    String input = et.getText().toString().trim();
                    if (!TextUtils.isEmpty(input)) {
                        int p = getProgressFromValue(input);
                        if (p >= 0 && p <= getMaxProgress()) {
                            seekBar.setProgress(p);
                        } else {
                            Toast.makeText(getContext(), "数值过大或过小", Toast.LENGTH_SHORT).show();
                        }
                        //onUpdate();
                    }
                })
                .setNegativeButton("Cancel", null)
                .create();
    }

    public void addSeekBar() {
        int iconSize = eason.dip(20);
        EasonIcon minus = new EasonIcon(eason);
        minus.setColor(eason.color(R.color.colorPrimary), true);
        minus.setType(EasonIcon.Type.MINUS_OVAL);
        minus.setPenSize(eason.dip(1));
        addView(minus, new LayoutParams(iconSize, iconSize));
        seekBar = new UnClickableSeekBar(eason);
        seekBar.setMax(getMaxProgress());
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                onUpdate(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        seekBar.setProgress(getInitProgress());
        addView(seekBar, new LayoutParams(0, LayoutParams.WRAP_CONTENT, 1f));
        EasonIcon add = new EasonIcon(eason);
        add.setColor(eason.color(R.color.colorPrimary), true);
        add.setType(EasonIcon.Type.ADD_OVAL);
        add.setPenSize(eason.dip(1));
        addView(add, new LayoutParams(iconSize, iconSize));
        minus.setOnClickListener(v -> {
            int mv = seekBar.getProgress();
            if (mv - 1 >= 0) {
                seekBar.setProgress(mv - 1);
            }
        });
        add.setOnClickListener(v -> {
            int av = seekBar.getProgress();
            if (av + 1 <= getMaxProgress()) {
                seekBar.setProgress(av + 1);
            }
        });
    }

    public abstract int getProgressFromValue(String value);

    public abstract int getMaxProgress();

    public int getInitProgress() {
        return 0;
    }

    public abstract void onUpdate(int progress);

    public EasonActivity eason() {
        return eason;
    }

    public EasonIcon icon() {
        return icon;
    }

    public Painter painter() {
        return painter;
    }

    public TargetEntity entity() {
        return entity;
    }

    public abstract String getAttrName();

    public void setValue(String val) {
        value.setText(val);
    }

    public void setEntity(TargetEntity entity) {
        this.entity = entity;
        painter = entity.getPainter();
        updateProgress(seekBar, entity);
        if (ifVisible(painter)) {
            setVisibility(View.VISIBLE);
        } else {
            setVisibility(View.GONE);
        }
    }

    public abstract void updateProgress(SeekBar seekBar, TargetEntity entity);

    public boolean ifVisible(Painter painter) {
        return false;
    }

    @SuppressLint({"ViewConstructor", "AppCompatCustomView"})
    public static class UnClickableSeekBar extends SeekBar {

        private boolean isMove;

        public UnClickableSeekBar(Context context) {
            super(context);
        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    isMove = false;
                    break;
                case MotionEvent.ACTION_MOVE:
                    isMove = true;
                    break;
                case MotionEvent.ACTION_UP:
                    if (!isMove)
                        return true;
                    break;
            }
            return super.onTouchEvent(event);
        }
    }
}

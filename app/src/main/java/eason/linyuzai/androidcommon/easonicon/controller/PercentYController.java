package eason.linyuzai.androidcommon.easonicon.controller;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import eason.linyuzai.androidcommon.R;
import eason.linyuzai.androidcommon.easonicon.entity.TargetEntity;
import eason.linyuzai.easonicon.EasonIcon;
import eason.linyuzai.easonicon.open.Painter;
import eason.linyuzai.elib.component.EasonActivity;

public class PercentYController extends LinearLayout implements AbsController {

    private SeekBar seekBar;
    private Painter painter;
    private TargetEntity entity;


    public PercentYController(Context context, EasonIcon icon) {
        super(context);
        painter = icon.getPainterSet();
        setOrientation(LinearLayout.HORIZONTAL);
        setGravity(Gravity.CENTER_VERTICAL);
        EasonActivity eason = (EasonActivity) context;
        int padding = eason.dip(8);
        setPadding(padding, padding, padding, padding);
        TextView textView = new TextView(context);
        textView.setText("Percent Y:");
        textView.setTextColor(Color.parseColor("#888888"));
        textView.setTextSize(15f);
        //textView.setBackgroundColor(Color.YELLOW);
        addView(textView, new LayoutParams(eason.dip(AbsController.TEXT_WIDTH), LayoutParams.WRAP_CONTENT));
        TextView value = new TextView(context);
        value.setText("1.0");
        value.setTextColor(Color.parseColor("#888888"));
        value.setTextSize(15f);
        //value.setBackgroundColor(Color.RED);
        addView(value, new LayoutParams(eason.dip(AbsController.VALUE_WIDTH), LayoutParams.WRAP_CONTENT));
        int iconSize = eason.dip(20);
        EasonIcon minus = new EasonIcon(eason);
        minus.setColor(eason.color(R.color.colorPrimary), true);
        minus.setType(EasonIcon.Type.MINUS_OVAL);
        minus.setPenSize(eason.dip(1));
        addView(minus, new LayoutParams(iconSize, iconSize));
        seekBar = new SeekBar(context);
        seekBar.setMax(100);
        seekBar.setProgress(100);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                float val = progress / 100f;
                value.setText(String.valueOf(val));
                if (entity != null)
                    entity.setPercentY(progress);
                painter.setPercentY(val);
                if (icon.getType() != EasonIcon.Type.NONE) {
                    icon.setType(icon.getType(), true);
                }
                icon.update();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
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
            if (av + 1 <= 100) {
                seekBar.setProgress(av + 1);
            }
        });
    }

    @Override
    public void setEntity(TargetEntity entity) {
        this.entity = entity;
        painter = entity.getPainter();
        seekBar.setProgress(entity.getPercentY());
    }
}

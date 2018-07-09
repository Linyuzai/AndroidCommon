package eason.linyuzai.androidcommon.easonicon.controller;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import eason.linyuzai.easonicon.EasonIcon;
import eason.linyuzai.easonicon.open.Painter;
import eason.linyuzai.elib.component.EasonActivity;

public class OffsetYController extends LinearLayout implements AbsController {

    public OffsetYController(Context context, EasonIcon icon) {
        super(context);
        setOrientation(LinearLayout.HORIZONTAL);
        setGravity(Gravity.CENTER_VERTICAL);
        EasonActivity eason = (EasonActivity) context;
        int padding = eason.dip(8);
        setPadding(padding, padding, padding, padding);
        TextView textView = new TextView(context);
        textView.setText("Offset Y:");
        textView.setTextColor(Color.parseColor("#888888"));
        textView.setTextSize(15f);
        //textView.setBackgroundColor(Color.YELLOW);
        addView(textView, new LayoutParams(eason.dip(AbsController.TEXT_WIDTH), LayoutParams.WRAP_CONTENT));
        TextView value = new TextView(context);
        value.setText("0");
        value.setTextColor(Color.parseColor("#888888"));
        value.setTextSize(15f);
        //value.setBackgroundColor(Color.RED);
        addView(value, new LayoutParams(eason.dip(AbsController.VALUE_WIDTH), LayoutParams.WRAP_CONTENT));
        SeekBar seekBar = new SeekBar(context);
        seekBar.setMax(100);
        seekBar.setProgress(50);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int val = progress - 50;
                value.setText(String.valueOf(val));
                if (fromUser) {
                    icon.getPainterSet().setOffsetY(eason.dip(val));
                    icon.update();
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        addView(seekBar, new LayoutParams(0, LayoutParams.WRAP_CONTENT, 1f));
    }

    @Override
    public void setPainter(Painter painter) {

    }
}

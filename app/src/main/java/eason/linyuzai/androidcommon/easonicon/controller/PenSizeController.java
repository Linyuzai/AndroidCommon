package eason.linyuzai.androidcommon.easonicon.controller;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import eason.linyuzai.easonicon.EasonIcon;
import eason.linyuzai.elib.component.EasonActivity;

public class PenSizeController extends LinearLayout implements AbsController {

    public PenSizeController(Context context, EasonIcon icon) {
        super(context);
        setOrientation(LinearLayout.HORIZONTAL);
        setGravity(Gravity.CENTER_VERTICAL);
        EasonActivity eason = (EasonActivity) context;
        int padding = eason.dip(8);
        setPadding(padding, padding, padding, padding);
        TextView textView = new TextView(context);
        textView.setText("Pen Size:");
        textView.setTextColor(Color.parseColor("#888888"));
        textView.setTextSize(15f);
        //textView.setBackgroundColor(Color.YELLOW);
        addView(textView, new LayoutParams(eason.dip(AbsController.TEXT_WIDTH), LayoutParams.WRAP_CONTENT));
        TextView value = new TextView(context);
        value.setText("3");
        value.setTextColor(Color.parseColor("#888888"));
        value.setTextSize(15f);
        //value.setBackgroundColor(Color.RED);
        addView(value, new LayoutParams(eason.dip(AbsController.VALUE_WIDTH), LayoutParams.WRAP_CONTENT));
        SeekBar seekBar = new SeekBar(context);
        seekBar.setMax(100);
        seekBar.setProgress(30);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                float val = progress * 1f / 10f;
                value.setText(String.valueOf(val));
                icon.setPenSize(eason.dip(val));
                //icon.setType(icon.getType(), true);
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
    }
}

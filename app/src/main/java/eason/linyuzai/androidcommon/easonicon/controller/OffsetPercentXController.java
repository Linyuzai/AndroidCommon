package eason.linyuzai.androidcommon.easonicon.controller;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.SeekBar;

import eason.linyuzai.androidcommon.easonicon.entity.TargetEntity;
import eason.linyuzai.easonicon.EasonIcon;

@SuppressLint("ViewConstructor")
public class OffsetPercentXController extends AbsController {

    public OffsetPercentXController(Context context, EasonIcon icon) {
        super(context, icon);
        addSeekBar();
    }

    @Override
    public String getAttrName() {
        return "Offset Percent X:";
    }

    @Override
    public int getMaxProgress() {
        return 200;
    }

    @Override
    public int getInitProgress() {
        return 100;
    }

    @Override
    public void updateProgress(SeekBar seekBar, TargetEntity entity) {
        seekBar.setProgress(entity.getOffsetPercentX());
    }

    @Override
    public void onUpdate(int progress) {
        float val = (progress - 100) / 100f;
        setValue(String.valueOf(val));
        if (entity() != null)
            entity().setOffsetPercentX(progress);
        painter().setOffsetPercentX(val);
        icon().update();
    }
}

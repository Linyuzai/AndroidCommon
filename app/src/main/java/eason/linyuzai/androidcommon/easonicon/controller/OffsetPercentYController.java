package eason.linyuzai.androidcommon.easonicon.controller;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.SeekBar;

import eason.linyuzai.androidcommon.easonicon.entity.TargetEntity;
import eason.linyuzai.easonicon.EasonIcon;
import eason.linyuzai.easonicon.open.Painter;

@SuppressLint("ViewConstructor")
public class OffsetPercentYController extends AbsController {

    public OffsetPercentYController(Context context, EasonIcon icon) {
        super(context, icon);
        addSeekBar();
    }

    @Override
    public String getAttrName() {
        return "Offset Percent Y:";
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
        seekBar.setProgress(entity.getOffsetPercentY());
    }

    @Override
    public boolean ifVisible(Painter painter) {
        return true;
    }

    @Override
    public void onUpdate(int progress) {
        float val = (progress - 100) / 100f;
        setValue(String.valueOf(val));
        if (entity() != null)
            entity().setOffsetPercentY(progress);
        painter().setOffsetPercentY(val);
        icon().update();
    }
}

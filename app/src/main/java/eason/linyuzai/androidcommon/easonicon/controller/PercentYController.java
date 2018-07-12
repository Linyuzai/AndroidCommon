package eason.linyuzai.androidcommon.easonicon.controller;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.SeekBar;

import eason.linyuzai.androidcommon.easonicon.entity.TargetEntity;
import eason.linyuzai.easonicon.EasonIcon;

@SuppressLint("ViewConstructor")
public class PercentYController extends AbsController {

    public PercentYController(Context context, EasonIcon icon) {
        super(context, icon);
        addSeekBar();
    }


    @Override
    public String getAttrName() {
        return "Percent Y:";
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
        seekBar.setProgress(entity.getPercentY());
    }

    @Override
    public void onUpdate(int progress) {
        float val = progress / 100f;
        setValue(String.valueOf(val));
        if (entity() != null)
            entity().setPercentY(progress);
        painter().setPercentY(val);
        /*if (icon().getType() != EasonIcon.Type.NONE) {
            icon().setType(icon().getType(), true);
        }*/
        icon().update();
    }
}

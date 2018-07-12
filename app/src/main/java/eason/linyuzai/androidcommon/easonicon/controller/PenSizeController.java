package eason.linyuzai.androidcommon.easonicon.controller;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.SeekBar;

import eason.linyuzai.androidcommon.easonicon.entity.TargetEntity;
import eason.linyuzai.easonicon.EasonIcon;

@SuppressLint("ViewConstructor")
public class PenSizeController extends AbsController {

    public PenSizeController(Context context, EasonIcon icon) {
        super(context, icon);
        addSeekBar();
    }

    @Override
    public String getAttrName() {
        return "Pen Size:";
    }

    @Override
    public int getMaxProgress() {
        return 100;
    }

    @Override
    public int getInitProgress() {
        return 30;
    }

    @Override
    public void updateProgress(SeekBar seekBar, TargetEntity entity) {

    }

    @Override
    public void onUpdate(int progress) {
        float val = progress / 10f;
        setValue(String.valueOf(val));
        icon().setPenSize(eason().dip(val));
        //icon.setType(icon.getType(), true);
        icon().update();
    }
}

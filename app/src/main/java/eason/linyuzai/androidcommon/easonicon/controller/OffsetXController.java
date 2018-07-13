package eason.linyuzai.androidcommon.easonicon.controller;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.SeekBar;

import eason.linyuzai.androidcommon.easonicon.entity.TargetEntity;
import eason.linyuzai.easonicon.EasonIcon;
import eason.linyuzai.easonicon.open.Painter;

@SuppressLint("ViewConstructor")
public class OffsetXController extends AbsController {

    public OffsetXController(Context context, EasonIcon icon) {
        super(context, icon);
        addSeekBar();
    }

    @Override
    public String getAttrName() {
        return "Offset X:";
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

    }

    @Override
    public boolean ifVisible(Painter painter) {
        return true;
    }

    @Override
    public void onUpdate(int progress) {
        int val = progress - 100;
        setValue(String.valueOf(val));
        painter().setOffsetX(eason().dip(val));
        icon().update();
    }
}

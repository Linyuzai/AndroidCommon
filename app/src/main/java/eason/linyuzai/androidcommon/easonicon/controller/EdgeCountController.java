package eason.linyuzai.androidcommon.easonicon.controller;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.SeekBar;

import eason.linyuzai.androidcommon.easonicon.entity.TargetEntity;
import eason.linyuzai.easonicon.EasonIcon;
import eason.linyuzai.easonicon.annotation.EdgeCountField;
import eason.linyuzai.easonicon.open.Painter;

@SuppressLint("ViewConstructor")
public class EdgeCountController extends AbsController {

    public EdgeCountController(Context context, EasonIcon icon) {
        super(context, icon);
        addSeekBar();
    }

    @Override
    public String getAttrName() {
        return "Edge Count:";
    }

    @Override
    public int getMaxProgress() {
        return 100;
    }

    @Override
    public int getInitProgress() {
        return 3;
    }

    @Override
    public void updateProgress(SeekBar seekBar, TargetEntity entity) {

    }

    @Override
    public boolean ifVisible(Painter painter) {
        return painter.getClass().getAnnotation(EdgeCountField.class) != null;
    }

    @Override
    public void onUpdate(int progress) {
        int val = progress;
        setValue(String.valueOf(val));
        EasonIcon.recursivePainter(painter(), painter -> {
            if (painter.isSupportEdgeCount())
                painter.toEdgeCountSupport().setEdgeCount(val);
        });
        //icon().setEdgeCount(val);
        //icon().setType(icon().getType(), true);
        icon().update();
    }
}

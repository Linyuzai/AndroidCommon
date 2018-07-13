package eason.linyuzai.androidcommon.easonicon.controller;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.SeekBar;

import eason.linyuzai.androidcommon.easonicon.entity.TargetEntity;
import eason.linyuzai.easonicon.EasonIcon;
import eason.linyuzai.easonicon.annotation.EdgeCountField;
import eason.linyuzai.easonicon.open.Painter;
import eason.linyuzai.easonicon.painter.SupportEasonPainterSet;

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
        if (val < 3)
            val = 3;
        setValue(String.valueOf(val));
        int finalVal = val;
        EasonIcon.recursivePainter(painter(), painter -> {
            if (painter instanceof SupportEasonPainterSet && painter.isSupportEdgeCount())
                painter.toEdgeCountSupport().setEdgeCount(finalVal);
        });
        //icon().setEdgeCount(val);
        //icon().setType(icon().getType(), true);
        icon().update();
    }
}

package eason.linyuzai.androidcommon.test;

import android.animation.ObjectAnimator;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.animation.LinearInterpolator;
import android.widget.LinearLayout;


import eason.linyuzai.androidcommon.R;
import eason.linyuzai.blurring.BlurringView;
import eason.linyuzai.easonicon.EasonIcon;

public class MainActivity extends AppCompatActivity {

    BlurringView blurringView;
    LinearLayout ll;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EasonIcon icon = findViewById(R.id.ei);
        //icon.setPadding(30, 30, 30, 30);
        //BackPainter painter = new BackPainter();
        //painter.setCenterPercent(0.5f);
        //painter.setOffsetPercentX(0.3f);
        //painter.setPercent(0.5f);
        //painter.addDrawAdapter();
        //icon.getPainterSet().addPainter(painter);
        //icon.update();
        /*AddPainter painter = new AddPainter();
        painter.addInterceptor(new PenColorInterceptor() {
            @Override
            public int getColor(Painter painter, int index) {
                return 0 == index ? Color.RED : Color.BLUE;
            }
        });
        painter.addInterceptor(new PorterDuffModeInterceptor(PorterDuff.Mode.SRC_ATOP));*/
        /*AddSolidOvalPainter painter = new AddSolidOvalPainter(Color.YELLOW, Color.RED);
        painter.addInterceptor(new PorterDuffModeInterceptor(PorterDuff.Mode.ADD));*/
        //EImageView imageView = new EImageView(this);
        //imageView.setImageResource(R.mipmap.ic_launcher_round);
        //imageView.measure(0, 0);
        //icon.addPainter(imageView, false);
        //CorrectPainter painter = new CorrectPainter();
        /*RectPainter painter = new RectPainter();
        painter.setRoundAll(20f);
        painter.setCenterPercent(0.5f);*/
        /*PainterSet set = new EasonPainterSet();
        set.addInterceptor(new PorterDuffModeInterceptor(PorterDuff.Mode.XOR));
        set.addInterceptor(new PenColorInterceptor() {
            @Override
            public int getColor(Painter painter, int index) {
                return 0 == index ? Color.RED : Color.BLUE;
            }
        });
        Painter c = new CorrectPainter();
        Painter e = new ErrorPainter();
        set.addPainter(c);
        set.addPainter(e);*/
        //PolygonPainter painter = new PolygonPainter(12);
        //ExtraPolygonPainter painter = new ExtraPolygonPainter(5, -30);
        //icon.addPainter(painter);
        float r = 20;
        //icon.addPainter(new SettingPainter());
        //Painter painter = new AddSolidOvalPainter(Color.YELLOW, Color.RED);
        //EasonIcon.printStructure(painter, true);
        ObjectAnimator animator = ObjectAnimator.ofFloat(icon, "rotationY", 0f, 180f);
        animator.setDuration(1800).setRepeatCount(-1);
        animator.setInterpolator(new LinearInterpolator());
        //animator.start();
        blurringView = findViewById(R.id.bv);
        ll = findViewById(R.id.ll);
        blurringView.setBlurredView(ll);
        blurringView.invalidate();
        ((EScrollView) findViewById(R.id.sv)).listener = new EScrollView.OnScrollChangedListener() {
            @Override
            public void onScroll(int l, int t) {
                Log.d("onScroll", "l:" + l + ",t:" + t);
                blurringView.invalidate(l, t);
            }
        };
    }
}

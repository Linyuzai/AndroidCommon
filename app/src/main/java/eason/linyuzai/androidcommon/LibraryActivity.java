package eason.linyuzai.androidcommon;

import android.animation.ArgbEvaluator;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import eason.linyuzai.androidcommon.easonicon.IconDisplayActivity;
import eason.linyuzai.easonicon.EasonIcon;
import eason.linyuzai.easonicon.open.Painter;
import eason.linyuzai.easonicon.painter.EasonPainterSet;
import eason.linyuzai.easonicon.painter.basic.line.HorizontalLinePainter;
import eason.linyuzai.easonicon.painter.basic.rect.BottomRoundRectPainter;
import eason.linyuzai.easonicon.painter.basic.rect.TopRoundRectPainter;
import eason.linyuzai.easonicon.painter.basic.text.TextPainter;
import eason.linyuzai.easonicon.painter.interceptor.paint.PenStyleInterceptor;
import eason.linyuzai.elib.component.EasonActivity;
import eason.linyuzai.rxeason.RxEason;

public class LibraryActivity extends EasonActivity {

    private TextView title;
    private ArgbEvaluator evaluator = new ArgbEvaluator();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Log.d("LibraryActivity", SupportEasonPainterSet.NOT_SUPPORT_FLOAT + "");
        EasonIcon ei = new EasonIcon(this);
        ei.setType(EasonIcon.Type.BACK_RECT);
        Painter painter = ei.getPainter(0);
        Log.d("LibraryActivity", painter.isSupportRoundRect() + "");
        Log.d("LibraryActivity", painter.toAuxiliaryScaleSupport() + "");
        LibraryHelper.init(this);
        LibraryHelper.LibraryParam initParam = getLibraryParam().get(0);
        setStatusBarColor(initParam.getTitleColor());
        setContentView(R.layout.activity_library);
        title = id(R.id.title);
        title.setBackgroundColor(initParam.getTitleColor());
        RecyclerView recyclerView = id(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new LibraryAdapter());
        final int unitLength = screenHeight() - dip(55) - statusBarHeight();
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                LinearLayoutManager layoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
                int position = layoutManager.findFirstVisibleItemPosition();
                View firstVisibleChildView = layoutManager.findViewByPosition(position);
                int itemHeight = firstVisibleChildView.getHeight();
                int scrollY = (position) * itemHeight - firstVisibleChildView.getTop();
                //Log.d("onScrolled", "scrollY:" + scrollY + ",unitLength:" + unitLength);

                int t = scrollY / unitLength + 1;


                if (scrollY >= 0 && scrollY < unitLength - 0.1f * unitLength) {

                } else if (scrollY >= unitLength - 0.1f * unitLength && scrollY <= unitLength) {
                    float fraction = (unitLength * 1f - scrollY * 1f) / (unitLength * 1f);
                    //Log.d("onScrolled", "fraction:" + fraction);
                    int color = (int) evaluator.evaluate(fraction * 10f, Color.parseColor("#FFFFB61E"),
                            Color.parseColor("#FFFF6666"));
                    title.setBackgroundColor(color);
                    setStatusBarColor(color);
                } else if (scrollY >= 2 * unitLength - 0.1f * unitLength && scrollY <= 2 * unitLength) {
                    float fraction = (2 * unitLength * 1f - scrollY * 1f) / (unitLength * 1f);
                    //Log.d("onScrolled", "fraction:" + fraction);
                    int color = (int) evaluator.evaluate(fraction * 10f, Color.BLACK,
                            Color.parseColor("#FFFFB61E"));
                    title.setBackgroundColor(color);
                    setStatusBarColor(color);
                }
            }
        });
    }

    private List<LibraryHelper.LibraryParam> getLibraryParam() {
        return LibraryHelper.getLibraryParam(this);
    }

    private class LibraryAdapter extends RecyclerView.Adapter<LibraryViewHolder> {

        @NonNull
        @Override
        public LibraryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            EasonIcon icon = new EasonIcon(parent.getContext());
            //icon.setColor(Color.BLACK);
            icon.setPenSize(dip(3));
            icon.addPainter(new LibraryPainter());
            icon.getPaint().setTextSize(dip(55));
            int padding = dip(10);
            icon.setPadding(padding, padding, padding, padding);
            RecyclerView.LayoutParams params = new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT,
                    RecyclerView.LayoutParams.MATCH_PARENT);
            icon.setLayoutParams(params);
            return new LibraryViewHolder(icon);
        }

        @SuppressLint("CheckResult")
        @Override
        public void onBindViewHolder(@NonNull LibraryViewHolder holder, int position) {
            LibraryHelper.LibraryParam param = getLibraryParam().get(position);
            holder.setText(param.getText());
            holder.icon.addPainter(param.getPainter());
            holder.icon.setColor(param.getContentColor());
            //RxEason.view(holder.itemView).onTouch().subscribe();
            RxEason.listener().view(holder.itemView).onClick().subscribe(view ->
                    new Intent(LibraryActivity.this, IconDisplayActivity.class));
            /*holder.itemView.setOnClickListener(v ->
                    startActivity(new Intent(LibraryActivity.this, IconDisplayActivity.class)));*/
        }

        @Override
        public int getItemCount() {
            return 1;
        }
    }

    private static class LibraryViewHolder extends RecyclerView.ViewHolder {
        private EasonIcon icon;

        public LibraryViewHolder(View itemView) {
            super(itemView);
            icon = (EasonIcon) itemView;
        }

        public void setText(String text) {
            ((LibraryPainter) icon.getPainter(0)).text.setText(text);
        }
    }

    private class LibraryPainter extends EasonPainterSet {
        private TextPainter text;

        public LibraryPainter() {
            Painter top = new TopRoundRectPainter(dip(12));
            top.setPercentY(0.66f);
            addPainter(top);
            Painter btm = new BottomRoundRectPainter(dip(12));
            btm.setPercentY(0.35f);
            btm.setOffsetPercentY(0.65f);
            addPainter(btm);
            text = new TextPainter();
            text.setOffsetPercentY(0.7f);
            text.setOffsetPercentX(0.1f);
            addPainter(text);

            Painter h1 = new HorizontalLinePainter();
            h1.setPercent(0.8f);
            h1.setOffsetPercentY(0.87f);
            h1.setOffsetPercentX(0.1f);
            addPainter(h1);
            Painter h2 = new HorizontalLinePainter();
            h2.setPercent(0.6f);
            h2.setOffsetPercentY(0.93f);
            h2.setOffsetPercentX(0.3f);
            addPainter(h2);

            addInterceptor(new PenStyleInterceptor() {
                @Override
                public Paint.Style getStyle(Painter painter, int index, Paint.Style original) {
                    if (painter instanceof TopRoundRectPainter || painter instanceof TextPainter)
                        return Paint.Style.FILL_AND_STROKE;
                    else return Paint.Style.STROKE;
                }
            });

        }
    }
}

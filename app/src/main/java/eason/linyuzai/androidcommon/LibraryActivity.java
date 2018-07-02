package eason.linyuzai.androidcommon;

import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import eason.linyuzai.easonicon.EasonIcon;
import eason.linyuzai.easonicon.open.Painter;
import eason.linyuzai.easonicon.painter.EasonPainterSet;
import eason.linyuzai.easonicon.painter.basic.rect.BottomRoundRectPainter;
import eason.linyuzai.easonicon.painter.basic.rect.TopRoundRectPainter;
import eason.linyuzai.easonicon.painter.interceptor.paint.PenStyleInterceptor;
import eason.linyuzai.elib.component.EasonActivity;

public class LibraryActivity extends EasonActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);
        RecyclerView recyclerView = id(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new LibraryAdapter());
    }

    private class LibraryAdapter extends RecyclerView.Adapter<LibraryViewHolder> {

        @NonNull
        @Override
        public LibraryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            EasonIcon icon = new EasonIcon(parent.getContext());
            icon.setColor(Color.BLACK);
            icon.setPenSize(dip(3));
            icon.addPainter(new LibraryPainter(), false);
            int padding = dip(10);
            icon.setPadding(padding, padding, padding, padding);
            RecyclerView.LayoutParams params = new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT,
                    RecyclerView.LayoutParams.MATCH_PARENT);
            icon.setLayoutParams(params);
            return new LibraryViewHolder(icon);
        }

        @Override
        public void onBindViewHolder(@NonNull LibraryViewHolder holder, int position) {
            holder.itemView.setOnClickListener(v -> {

            });
        }

        @Override
        public int getItemCount() {
            return 2;
        }
    }

    private static class LibraryViewHolder extends RecyclerView.ViewHolder {

        public LibraryViewHolder(View itemView) {
            super(itemView);
        }
    }

    private class LibraryPainter extends EasonPainterSet {
        Painter painter;

        public LibraryPainter() {
            Painter top = new TopRoundRectPainter(dip(12));
            top.setPercentY(0.66f);
            addPainter(top);
            Painter btm = new BottomRoundRectPainter(dip(12));
            btm.setPercentY(0.35f);
            btm.setOffsetPercentY(0.65f);
            addPainter(btm);
            addInterceptor(new PenStyleInterceptor() {
                @Override
                public Paint.Style getStyle(Painter painter, int index) {
                    return index == 0 ? Paint.Style.FILL_AND_STROKE : Paint.Style.STROKE;
                }
            });
        }
    }
}

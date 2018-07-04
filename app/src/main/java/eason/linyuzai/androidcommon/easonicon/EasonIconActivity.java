package eason.linyuzai.androidcommon.easonicon;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import java.util.List;

import eason.linyuzai.androidcommon.LibraryHelper;
import eason.linyuzai.androidcommon.R;
import eason.linyuzai.easonicon.EasonIcon;
import eason.linyuzai.elib.component.EasonActivity;

public class EasonIconActivity extends EasonActivity {

    LibraryHelper.LibraryParam param;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        param = getLibraryParam().get(0);
        setStatusBarColor(param.getTitleColor());
        setContentView(R.layout.activity_eason_icon);
        id(R.id.back).setOnClickListener(v -> finish());
        id(R.id.title).setBackgroundColor(param.getTitleColor());
        RecyclerView recyclerView = id(R.id.rv);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 4));
        recyclerView.setAdapter(new EasonIconAdapter());
    }

    private List<LibraryHelper.LibraryParam> getLibraryParam() {
        return LibraryHelper.getLibraryParam(this);
    }

    private class EasonIconAdapter extends RecyclerView.Adapter<EasonIconViewHolder> {

        @NonNull
        @Override
        public EasonIconViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            EasonIcon icon = new EasonIcon(parent.getContext());
            icon.setBackgroundColor(Color.WHITE);
            //icon.setColor(Color.BLACK);
            icon.setPenSize(dip(3));
            icon.setColor(param.getContentColor());
            icon.setEdgeCount(5);
            icon.setExtraOffset(-dip(4));
            icon.setSweepAngle(120f);
            icon.setLeftTopRound(dip(5));
            icon.setLeftBottomRound(dip(5));
            icon.setRightTopRound(dip(5));
            icon.setRightBottomRound(dip(5));
            //icon.getPainterSet().setCenterPercent(0.9f);
            icon.getPaint().setTextSize(dip(15));
            int padding = dip(5);
            icon.setPadding(padding, padding, padding, padding);
            //RecyclerView.LayoutParams params = new RecyclerView.LayoutParams(dip(50), dip(50));
            icon.setLayoutParams(new FrameLayout.LayoutParams(dip(50), dip(50), Gravity.CENTER));
            FrameLayout layout = new FrameLayout(parent.getContext());
            layout.setPadding(0, dip(10), 0, dip(10));
            layout.addView(icon);
            return new EasonIconViewHolder(layout);
        }

        @Override
        public void onBindViewHolder(@NonNull EasonIconViewHolder holder, int position) {
            holder.icon.setType(position + 1);
        }

        @Override
        public int getItemCount() {
            return 78;
        }
    }

    private static class EasonIconViewHolder extends RecyclerView.ViewHolder {

        private EasonIcon icon;

        private EasonIconViewHolder(View itemView) {
            super(itemView);
            icon = (EasonIcon) ((FrameLayout) itemView).getChildAt(0);
        }
    }
}
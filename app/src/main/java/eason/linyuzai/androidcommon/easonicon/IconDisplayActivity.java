package eason.linyuzai.androidcommon.easonicon;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
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
import eason.linyuzai.easonicon.painter.basic.NonePainter;
import eason.linyuzai.easonicon.painter.basic.bitmap.BitmapPainter;
import eason.linyuzai.elib.component.EasonActivity;

public class IconDisplayActivity extends EasonActivity {

    private LibraryHelper.LibraryParam param;

    private Bitmap bitmap;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        param = getLibraryParam().get(0);
        setStatusBarColor(param.getTitleColor());
        setContentView(R.layout.activity_icon_display);
        id(R.id.back).setOnClickListener(v -> finish());
        id(R.id.create).setOnClickListener(v -> startActivity(new Intent(this, IconCreateActivity.class)));
        id(R.id.title).setBackgroundColor(param.getTitleColor());
        RecyclerView recyclerView = id(R.id.rv);
        recyclerView.setBackgroundColor(param.getBackgroundColor());
        recyclerView.setLayoutManager(new GridLayoutManager(this, 4));
        recyclerView.setAdapter(new EasonIconAdapter());
    }

    private List<LibraryHelper.LibraryParam> getLibraryParam() {
        return LibraryHelper.getLibraryParam(this);
    }

    private class EasonIconAdapter extends RecyclerView.Adapter<EasonIconViewHolder> {

        private int padding = dip(5);

        @NonNull
        @Override
        public EasonIconViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            EasonIcon icon = new EasonIcon(parent.getContext());
            icon.setBackgroundColor(Color.WHITE);
            //icon.setColor(Color.BLACK);
            icon.setPenSize(dip(3));
            icon.setColor(param.getContentColor(), true);
            //icon.setAuxiliaryColor(param.getContentColor());
            icon.setEdgeCount(3);
            icon.setExtraOffset(-dip(4));
            icon.setSweepAngle(120f);
            icon.setLeftTopRound(dip(5));
            icon.setLeftBottomRound(dip(5));
            icon.setRightTopRound(dip(5));
            icon.setRightBottomRound(dip(5));
            icon.setTextSize(dip(45));
            icon.setText("Text");
            if (bitmap == null) {
                Drawable drawable = drawable(R.mipmap.pic);
                //Log.d("drawable", drawable.getClass().toString());
                //bitmap = BitmapFactory.decodeResource(getResources(), );
                bitmap = BitmapPainter.getBitmapFromDrawable(drawable);
            }
            icon.setBitmap(bitmap);
            //icon.getPainterSet().setCenterPercent(0.9f);
            icon.getPaint().setTextSize(dip(15));
            //RecyclerView.LayoutParams params = new RecyclerView.LayoutParams(dip(50), dip(50));
            int size = (screenWidth() - dip(160)) / 4;
            icon.setLayoutParams(new FrameLayout.LayoutParams(size, size, Gravity.CENTER));
            FrameLayout layout = new FrameLayout(parent.getContext());
            layout.setPadding(0, dip(20), 0, dip(20));
            layout.addView(icon);
            /*TextView textView = new TextView(parent.getContext());
            textView.setTextColor(param.getContentColor());
            layout.addView(textView);*/
            return new EasonIconViewHolder(layout);
        }

        @Override
        public void onBindViewHolder(@NonNull EasonIconViewHolder holder, int position) {
            if (EasonIcon.getDefaultPercent(position + 1) == 1f) {
                holder.icon.setPadding(padding, padding, padding, padding);
            } else {
                holder.icon.setPadding(0, 0, 0, 0);
                holder.icon.setAuxiliaryColor(Color.WHITE);
            }
            holder.icon.setType(position + 1);
            holder.icon.setOnClickListener(v -> {
                if (EasonIcon.getType(position + 1).getPainterClass() == NonePainter.class) {
                    toast("No icon to display");
                } else {
                    Intent intent = new Intent(IconDisplayActivity.this, IconAttrActivity.class);
                    intent.putExtra("type", position + 1);
                    startActivity(intent);
                }
            });
        }

        @Override
        public int getItemCount() {
            return 61;
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

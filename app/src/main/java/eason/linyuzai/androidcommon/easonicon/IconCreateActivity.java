package eason.linyuzai.androidcommon.easonicon;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import eason.linyuzai.androidcommon.LibraryHelper;
import eason.linyuzai.androidcommon.R;
import eason.linyuzai.androidcommon.easonicon.controller.AbsController;
import eason.linyuzai.androidcommon.easonicon.controller.CenterPercentController;
import eason.linyuzai.androidcommon.easonicon.controller.CenterPercentXController;
import eason.linyuzai.androidcommon.easonicon.controller.CenterPercentYController;
import eason.linyuzai.androidcommon.easonicon.controller.OffsetPercentController;
import eason.linyuzai.androidcommon.easonicon.controller.OffsetPercentXController;
import eason.linyuzai.androidcommon.easonicon.controller.OffsetPercentYController;
import eason.linyuzai.androidcommon.easonicon.controller.PercentController;
import eason.linyuzai.androidcommon.easonicon.controller.PercentXController;
import eason.linyuzai.androidcommon.easonicon.controller.PercentYController;
import eason.linyuzai.androidcommon.easonicon.entity.TargetEntity;
import eason.linyuzai.easonicon.EasonIcon;
import eason.linyuzai.easonicon.open.Painter;
import eason.linyuzai.elib.component.EasonActivity;

public class IconCreateActivity extends EasonActivity {

    LibraryHelper.LibraryParam param;

    private DrawerLayout drawerLayout;
    private EasonIcon drawerSwitch;
    private TextView targetName;
    private TargetAdapter targetAdapter;
    private AlertDialog dialog;

    private EasonIcon creator;

    private TargetEntity currentEntity;
    private int selectIndex = 0;

    private ViewGroup controlGroup;
    private List<AbsController> controllers = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        param = getLibraryParam().get(0);
        setStatusBarColor(param.getTitleColor());
        setContentView(R.layout.activity_icon_create);
        id(R.id.back).setOnClickListener(v -> finish());
        id(R.id.title).setBackgroundColor(param.getTitleColor());
        creator = id(R.id.creator);
        drawerLayout = id(R.id.drawer);
        drawerLayout.setScrimColor(Color.TRANSPARENT);
        drawerLayout.addDrawerListener(new DrawerLayout.SimpleDrawerListener() {
            @Override
            public void onDrawerOpened(View drawerView) {
                drawerSwitch.setType(EasonIcon.Type.NEXT);
                drawerSwitch.update();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                drawerSwitch.setType(EasonIcon.Type.BACK);
                drawerSwitch.update();
            }
        });
        drawerSwitch = id(R.id.drawer_switch);
        drawerSwitch.setOnClickListener(v -> {
            if (drawerLayout.isDrawerOpen(Gravity.RIGHT)) {
                drawerLayout.closeDrawer(Gravity.RIGHT);
            } else {
                drawerLayout.openDrawer(Gravity.RIGHT);
            }
        });
        targetName = id(R.id.target_name);
        initDialog();
        id(R.id.add_painter).setOnClickListener(v -> dialog.show());
        RecyclerView recyclerView = id(R.id.target_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        targetAdapter = new TargetAdapter();
        recyclerView.setAdapter(targetAdapter);
        TargetEntity.setIcon(new EasonIcon(this));
        initController();
    }

    private List<LibraryHelper.LibraryParam> getLibraryParam() {
        return LibraryHelper.getLibraryParam(this);
    }

    private void initController() {
        controlGroup = id(R.id.control_group);
        /*CenterPercentController centerPercentController = new CenterPercentController(this, creator);
        controllers.add(centerPercentController);
        controlGroup.addView(centerPercentController);
        CenterPercentXController centerPercentXController = new CenterPercentXController(this, creator);
        controllers.add(centerPercentXController);
        controlGroup.addView(centerPercentXController);
        CenterPercentYController centerPercentYController = new CenterPercentYController(this, creator);
        controllers.add(centerPercentYController);
        controlGroup.addView(centerPercentYController);*/
        /*PercentController percentController = new PercentController(this, creator);
        controllers.add(percentController);
        controlGroup.addView(percentController);*/
        PercentXController percentXController = new PercentXController(this, creator);
        controllers.add(percentXController);
        controlGroup.addView(percentXController);
        PercentYController percentYController = new PercentYController(this, creator);
        controllers.add(percentYController);
        controlGroup.addView(percentYController);
        /*OffsetPercentController offsetPercentController = new OffsetPercentController(this, creator);
        controllers.add(offsetPercentController);
        controlGroup.addView(offsetPercentController);*/
        OffsetPercentXController offsetPercentXController = new OffsetPercentXController(this, creator);
        controllers.add(offsetPercentXController);
        controlGroup.addView(offsetPercentXController);
        OffsetPercentYController offsetPercentYController = new OffsetPercentYController(this, creator);
        controllers.add(offsetPercentYController);
        controlGroup.addView(offsetPercentYController);
    }

    private void updateTarget(TargetEntity entity) {
        for (AbsController controller : controllers) {
            controller.setEntity(entity);
        }
    }

    private void initDialog() {
        String[] types = new String[EasonIcon.Type.values().length - 1];
        for (int i = 0; i < types.length; i++) {
            types[i] = EasonIcon.getType(i + 1).getPainterClass().getSimpleName();
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this, AlertDialog.THEME_HOLO_LIGHT);
        builder.setTitle("Painter Select");
        builder.setSingleChoiceItems(types, 0, (dialog, which) -> selectIndex = which);
        builder.setPositiveButton("Ok", (dialog, which) -> {
            targetAdapter.addTarget(new TargetEntity(selectIndex + 1));
            creator.addPainter(currentEntity.getPainter());
            creator.update();
            dialog.dismiss();
        });
        builder.setNegativeButton("Cancel", (dialog, which) -> dialog.dismiss());
        dialog = builder.create();
    }

    private class TargetAdapter extends RecyclerView.Adapter<TargetViewHolder> {

        private int select = -1;

        private int defaultColor;

        private int selectColor;

        private List<TargetEntity> targetEntities = new ArrayList<>();

        public TargetAdapter() {
            defaultColor = Color.parseColor("#888888");
            selectColor = color(R.color.colorPrimaryDark);
        }

        @NonNull
        @Override
        public TargetViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            TextView textView = new TextView(parent.getContext());
            textView.setGravity(Gravity.CENTER);
            textView.setTextSize(15f);
            textView.setLayoutParams(new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT, dip(40)));
            return new TargetViewHolder(textView);
        }

        @Override
        public void onBindViewHolder(@NonNull TargetViewHolder holder, int position) {
            TargetEntity entity = targetEntities.get(position);
            if (entity.isSelect()) {
                holder.text.setBackgroundColor(selectColor);
                holder.text.setTextColor(Color.WHITE);
            } else {
                holder.text.setBackgroundColor(Color.WHITE);
                holder.text.setTextColor(defaultColor);
            }
            holder.text.setText(entity.getTargetName());
            holder.text.setOnClickListener(v -> setSelect(position));
        }

        @Override
        public int getItemCount() {
            return targetEntities.size();
        }

        public void addTarget(TargetEntity entity) {
            targetEntities.add(entity);
            notifyItemInserted(targetEntities.size() - 1);
            if (select != -1) {
                targetEntities.get(select).setSelect(false);
                notifyItemChanged(select);
            }
            select = targetEntities.size() - 1;
            currentEntity = entity;
            targetName.setText(currentEntity.getTargetName());
            updateTarget(currentEntity);
        }

        public void setSelect(int position) {
            if (select != -1) {
                targetEntities.get(select).setSelect(false);
                notifyItemChanged(select);
            }
            select = position;
            targetEntities.get(select).setSelect(true);
            notifyItemChanged(select);
            currentEntity = targetEntities.get(select);
            targetName.setText(currentEntity.getTargetName());
            updateTarget(currentEntity);
        }
    }

    private static class TargetViewHolder extends RecyclerView.ViewHolder {

        private TextView text;

        private TargetViewHolder(View itemView) {
            super(itemView);
            text = (TextView) itemView;
        }
    }
}

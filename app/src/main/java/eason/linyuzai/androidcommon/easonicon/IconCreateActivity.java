package eason.linyuzai.androidcommon.easonicon;

import android.app.AlertDialog;
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
import android.widget.LinearLayout;
import android.widget.TextView;

import com.shizhefei.view.hvscrollview.HVScrollView;

import java.util.ArrayList;
import java.util.List;

import eason.linyuzai.androidcommon.LibraryHelper;
import eason.linyuzai.androidcommon.R;
import eason.linyuzai.androidcommon.easonicon.controller.AbsController;
import eason.linyuzai.androidcommon.easonicon.controller.LeftBottomController;
import eason.linyuzai.androidcommon.easonicon.controller.LeftTopController;
import eason.linyuzai.androidcommon.easonicon.controller.OffsetPercentXController;
import eason.linyuzai.androidcommon.easonicon.controller.OffsetPercentYController;
import eason.linyuzai.androidcommon.easonicon.controller.PercentXController;
import eason.linyuzai.androidcommon.easonicon.controller.PercentYController;
import eason.linyuzai.androidcommon.easonicon.controller.RightBottomController;
import eason.linyuzai.androidcommon.easonicon.controller.RightTopController;
import eason.linyuzai.androidcommon.easonicon.entity.TargetEntity;
import eason.linyuzai.easonicon.EasonIcon;
import eason.linyuzai.elib.component.EasonActivity;

public class IconCreateActivity extends EasonActivity {

    LibraryHelper.LibraryParam param;

    private DrawerLayout drawerLayout;
    private TextView targetName;
    private TargetAdapter targetAdapter;
    private AlertDialog dialog;

    private EasonIcon creator;

    private TargetEntity currentEntity;
    private int selectIndex = 0;

    private AlertDialog codeDialog;
    private TextView codeText;

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
        View drawerSwitch = id(R.id.drawer_switch);
        drawerSwitch.setOnClickListener(v -> {
            if (drawerLayout.isDrawerOpen(Gravity.LEFT)) {
                drawerLayout.closeDrawer(Gravity.LEFT);
            } else {
                drawerLayout.openDrawer(Gravity.LEFT);
            }
        });
        targetName = id(R.id.target_name);
        initDialog();
        id(R.id.add_painter).setOnClickListener(v -> dialog.show());
        RecyclerView recyclerView = id(R.id.target_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        targetAdapter = new TargetAdapter();
        recyclerView.setAdapter(targetAdapter);
        EasonIcon easonIcon = new EasonIcon(this);
        easonIcon.setColor(color(R.color.colorPrimary), true);
        TargetEntity.setIcon(easonIcon);
        initController();
        id(R.id.generate).setOnClickListener(v -> {
            StringBuilder builder = new StringBuilder();
            builder.append("public class CustomPainter extends EasonPainterSet {\n");
            builder.append("    public CustomPainter() {\n");
            for (int i = 1; i < targetAdapter.targetEntities.size(); i++) {
                TargetEntity entity = targetAdapter.targetEntities.get(i);
                String painterName = entity.getPainter().getClass().getSimpleName();
                builder.append("        ").append(painterName).append(" painter").append(i).append(" = new ").append(painterName).append("();\n");
                if (entity.getPercentX() != 100) {
                    builder.append("        painter").append(i).append(".setPercentX(").append(entity.getPercentX() / 100f).append("f);\n");
                }
                if (entity.getPercentY() != 100) {
                    builder.append("        painter").append(i).append(".setPercentY(").append(entity.getPercentY() / 100f).append("f);\n");
                }
                if (entity.getOffsetPercentX() != 100) {
                    builder.append("        painter").append(i).append(".setOffsetPercentX(").append((entity.getOffsetPercentX() - 100) / 100f).append("f);\n");
                }
                if (entity.getOffsetPercentY() != 100) {
                    builder.append("        painter").append(i).append(".setOffsetPercentY(").append((entity.getOffsetPercentY() - 100) / 100f).append("f);\n");
                }
                builder.append("        ").append("addPainter(painter").append(i).append(");\n");
            }
            builder.append("    }\n");
            builder.append("}\n");
            showCodeDialog(builder.toString());
        });
    }

    private List<LibraryHelper.LibraryParam> getLibraryParam() {
        return LibraryHelper.getLibraryParam(this);
    }

    private void initController() {
        ViewGroup controlGroup = id(R.id.control_group);
        PercentXController percentXController = new PercentXController(this, creator);
        controllers.add(percentXController);
        controlGroup.addView(percentXController);
        PercentYController percentYController = new PercentYController(this, creator);
        controllers.add(percentYController);
        controlGroup.addView(percentYController);
        OffsetPercentXController offsetPercentXController = new OffsetPercentXController(this, creator);
        controllers.add(offsetPercentXController);
        controlGroup.addView(offsetPercentXController);
        OffsetPercentYController offsetPercentYController = new OffsetPercentYController(this, creator);
        controllers.add(offsetPercentYController);
        controlGroup.addView(offsetPercentYController);
        LeftTopController leftTopController = new LeftTopController(this, creator);
        controllers.add(leftTopController);
        controlGroup.addView(leftTopController);
        LeftBottomController leftBottomController = new LeftBottomController(this, creator);
        controllers.add(leftBottomController);
        controlGroup.addView(leftBottomController);
        RightTopController rightTopController = new RightTopController(this, creator);
        controllers.add(rightTopController);
        controlGroup.addView(rightTopController);
        RightBottomController rightBottomController = new RightBottomController(this, creator);
        controllers.add(rightBottomController);
        controlGroup.addView(rightBottomController);
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

    private void showCodeDialog(String code) {
        if (codeDialog == null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this, AlertDialog.THEME_HOLO_LIGHT);
            builder.setTitle("Code");
            HVScrollView scrollView = new HVScrollView(this);
            scrollView.setOverScrollMode(View.OVER_SCROLL_NEVER);
            //builder.setMessage(code);
            codeText = new TextView(this);
            codeText.setTextIsSelectable(true);
            codeText.setTextSize(13f);
            int padding = dip(8);
            codeText.setPadding(padding, padding, padding, padding);
            scrollView.addView(codeText);
            builder.setView(scrollView);
            builder.setPositiveButton("确定", (dialog, which) -> dialog.dismiss());
            codeDialog = builder.create();
        }
        //code = "```\n" + code + "```\n";
        //RichText.fromMarkdown(code).into(codeText);
        codeText.setText(code);
        codeDialog.show();
    }

    private static class TargetViewHolder extends RecyclerView.ViewHolder {

        private TextView text;
        private EasonIcon sign;
        private EasonIcon remove;

        private TargetViewHolder(View itemView) {
            super(itemView);
            text = (TextView) ((ViewGroup) itemView).getChildAt(0);
            sign = (EasonIcon) ((ViewGroup) itemView).getChildAt(1);
            remove = (EasonIcon) ((ViewGroup) itemView).getChildAt(2);
        }
    }

    private class TargetAdapter extends RecyclerView.Adapter<TargetViewHolder> {

        private int select = -1;

        private int defaultColor;

        private int selectColor;

        private List<TargetEntity> targetEntities = new ArrayList<>();

        private TargetAdapter() {
            defaultColor = Color.parseColor("#888888");
            selectColor = color(R.color.colorPrimaryDark);
            addTarget(new TargetEntity(creator));
        }

        @NonNull
        @Override
        public TargetViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LinearLayout linearLayout = new LinearLayout(parent.getContext());
            linearLayout.setOrientation(LinearLayout.HORIZONTAL);
            TextView textView = new TextView(parent.getContext());
            textView.setGravity(Gravity.CENTER);
            textView.setTextSize(15f);
            linearLayout.addView(textView, new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT, 1f));
            EasonIcon sign = new EasonIcon(parent.getContext());
            sign.setType(EasonIcon.Type.SIGN);
            sign.getPainterSet().setCenterPercent(0.4f);
            linearLayout.addView(sign, new LinearLayout.LayoutParams(dip(40), dip(40)));
            EasonIcon remove = new EasonIcon(parent.getContext());
            remove.setType(EasonIcon.Type.ERROR);
            remove.getPainterSet().setCenterPercent(0.3f);
            linearLayout.addView(remove, new LinearLayout.LayoutParams(dip(40), dip(40)));
            linearLayout.setLayoutParams(new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT, dip(40)));
            return new TargetViewHolder(linearLayout);
        }

        @Override
        public void onBindViewHolder(@NonNull TargetViewHolder holder, int position) {
            TargetEntity entity = targetEntities.get(position);
            if (entity.isSelect()) {
                holder.itemView.setBackgroundColor(selectColor);
                holder.text.setTextColor(Color.WHITE);
                holder.sign.setColor(Color.WHITE, true);
                holder.remove.setColor(Color.WHITE);
            } else {
                holder.itemView.setBackgroundColor(Color.WHITE);
                holder.text.setTextColor(defaultColor);
                holder.sign.setColor(selectColor, true);
                holder.remove.setColor(selectColor);
            }
            holder.text.setText(entity.getTargetName());
            holder.text.setOnClickListener(v -> setSelect(position));

            if (position == 0) {
                holder.sign.setVisibility(View.GONE);
                holder.remove.setVisibility(View.GONE);
            } else {
                holder.sign.setVisibility(View.VISIBLE);
                holder.remove.setVisibility(View.VISIBLE);
            }

        }

        @Override
        public int getItemCount() {
            return targetEntities.size();
        }

        private void addTarget(TargetEntity entity) {
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

        private void setSelect(int position) {
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
}

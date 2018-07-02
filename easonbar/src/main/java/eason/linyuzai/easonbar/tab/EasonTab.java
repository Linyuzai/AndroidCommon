package eason.linyuzai.easonbar.tab;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.annotation.StyleRes;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import eason.linyuzai.easonbar.entity.EasonEntity;
import eason.linyuzai.easonbar.tab.component.EasonTabFragmentAdapter;
import eason.linyuzai.easonbar.tab.component.EasonTabItemClickListener;
import eason.linyuzai.easonbar.tab.impl.adapter.DefaultEasonTabAdapter;
import eason.linyuzai.easonbar.tab.component.EasonTabAdapter;
import eason.linyuzai.easonbar.common.Checker;
import eason.linyuzai.easonbar.tab.component.EasonTabController;
import eason.linyuzai.easonbar.tab.component.EasonTabRecycler;
import eason.linyuzai.easonbar.tab.impl.layout.DefaultEasonTabLayoutManager;
import eason.linyuzai.easonbar.tab.component.EasonTabLayoutManager;

/**
 * Created by linyuzai on 2018/5/4.
 *
 * @author linyuzai
 */

public class EasonTab extends LinearLayout implements View.OnClickListener {

    private EasonTabAdapter adapter;

    private EasonTabFragmentAdapter fragmentAdapter;

    private EasonTabLayoutManager layoutManager;

    private EasonTabItemClickListener listener;

    private EasonTabController controller = new Controller();

    private EasonTabRecycler recycler = new Recycler();

    private int activeIndex = 0;

    public EasonTab(Context context) {
        super(context);
        initialize();
    }

    public EasonTab(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initialize();
    }

    public EasonTab(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initialize();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public EasonTab(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initialize();
    }

    private void initialize() {
        setOrientation(LinearLayout.HORIZONTAL);
        setBackgroundColor(Color.WHITE);
        setAdapter(new DefaultEasonTabAdapter());
        setLayoutManager(new DefaultEasonTabLayoutManager());
    }

    public EasonTabAdapter getAdapter() {
        return adapter;
    }

    public void setAdapter(EasonTabAdapter adapter) {
        this.adapter = adapter;
    }

    public EasonTabFragmentAdapter getFragmentAdapter() {
        return fragmentAdapter;
    }

    public void setFragmentAdapter(EasonTabFragmentAdapter fragmentAdapter) {
        this.fragmentAdapter = fragmentAdapter;
    }

    public EasonTabLayoutManager getLayoutManager() {
        return layoutManager;
    }

    public void setLayoutManager(EasonTabLayoutManager layoutManager) {
        this.layoutManager = layoutManager;
    }

    public EasonTabItemClickListener getOnItemClickListener() {
        return listener;
    }

    public void setOnItemClickListener(EasonTabItemClickListener listener) {
        this.listener = listener;
    }

    public EasonTabController getController() {
        return controller;
    }

    public int getActiveIndex() {
        return activeIndex;
    }

    public static class Entity extends EasonEntity {
        private static final String ACTIVE_DRAWABLE = "active_drawable";
        private static final String DEFAULT_DRAWABLE = "default_drawable";
        private static final String ACTIVE_COLOR = "active_color";
        private static final String DEFAULT_COLOR = "default_color";
        private static final String TEXT = "text";
        private static final String MESSAGE_COUNT_TEXT = "message_count_text";
        private static final String FRAGMENT = "fragment";
        private static final String FRAGMENT_TAG = "fragment_tag";

        public void setActiveDrawable(Drawable drawable) {
            add(getKey(ACTIVE_DRAWABLE), drawable);
        }

        public Drawable getActiveDrawable() {
            return get(getKey(ACTIVE_DRAWABLE));
        }

        public void setDefaultDrawable(Drawable drawable) {
            add(getKey(DEFAULT_DRAWABLE), drawable);
        }

        public Drawable getDefaultDrawable() {
            return get(getKey(DEFAULT_DRAWABLE));
        }

        public void setText(String text) {
            add(getKey(TEXT), text);
        }

        public String getText() {
            return get(getKey(TEXT));
        }

        public void setActiveColor(int color) {
            add(getKey(ACTIVE_COLOR), color);
        }

        public int getActiveColor() {
            return get(getKey(ACTIVE_COLOR));
        }

        public void setDefaultColor(int color) {
            add(getKey(DEFAULT_COLOR), color);
        }

        public int getDefaultColor() {
            return get(getKey(DEFAULT_COLOR));
        }

        public void setMessageCountText(String count) {
            add(getKey(MESSAGE_COUNT_TEXT), count);
        }

        public String getMessageCountText() {
            return get(getKey(MESSAGE_COUNT_TEXT));
        }

        public void setFragment(String tag, Object fragment) {
            add(getKey(FRAGMENT), fragment);
            add(getKey(FRAGMENT_TAG), tag);
        }

        public Object getFragment() {
            return get(getKey(FRAGMENT));
        }

        public String getFragmentTag() {
            return get(getKey(FRAGMENT_TAG));
        }
    }

    public static class DefaultTabItem extends TabItem {
        private ImageView image;

        public DefaultTabItem(@NonNull Context context) {
            super(context);
        }

        public DefaultTabItem(@NonNull Context context, @Nullable AttributeSet attrs) {
            super(context, attrs);
        }

        public DefaultTabItem(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
            super(context, attrs, defStyleAttr);
        }

        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        public DefaultTabItem(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
            super(context, attrs, defStyleAttr, defStyleRes);
        }

        @Override
        public View getIconView(Context context, int height) {
            image = new ImageView(getContext());
            image.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            return image;
        }

        @Override
        public void active() {
            image.setImageDrawable(getEntity().getActiveDrawable());
            getTextView().setTextColor(getEntity().getActiveColor());
        }

        @Override
        public void reset() {
            image.setImageDrawable(getEntity().getDefaultDrawable());
            getTextView().setTextColor(getEntity().getDefaultColor());
        }
    }

    public static abstract class TabItem extends FrameLayout {

        private TextView text;

        private Entity entity;

        private boolean isRecycled;

        public TabItem(@NonNull Context context) {
            super(context);
        }

        public TabItem(@NonNull Context context, @Nullable AttributeSet attrs) {
            super(context, attrs);
        }

        public TabItem(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
            super(context, attrs, defStyleAttr);
        }

        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        public TabItem(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr, @StyleRes int defStyleRes) {
            super(context, attrs, defStyleAttr, defStyleRes);
        }

        public void initialize(int height, OnClickListener l) {
            if (isRecycled)
                return;
            int space = (int) (height * getSpaceHeightScale());
            LinearLayout layout = new LinearLayout(getContext());
            layout.setOrientation(LinearLayout.VERTICAL);
            LayoutParams params = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
            params.gravity = Gravity.CENTER;
            params.topMargin = space;
            params.bottomMargin = space;
            addView(layout, params);
            int iconSize = (int) (height * getIconHeightScale());
            layout.addView(getIconView(getContext(), height), new LinearLayout.LayoutParams(iconSize, iconSize));
            text = new TextView(getContext());
            text.setGravity(Gravity.CENTER);
            layout.addView(text, new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, (int) (height * getTextHeightScale())));
            setLayoutParams(new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT, 1f));
            setOnClickListener(l);
        }

        public void update(Entity entity) {
            setEntity(entity);
            text.setText(entity.getText());
        }

        public abstract void active();

        public abstract void reset();

        public Entity getEntity() {
            return entity;
        }

        public void setEntity(Entity entity) {
            this.entity = entity;
        }

        public abstract View getIconView(Context context, int height);

        public float getSpaceHeightScale() {
            return 0.05f;
        }

        public float getIconHeightScale() {
            return 0.6f;
        }

        public float getTextHeightScale() {
            return 0.3f;
        }

        public TextView getTextView() {
            return text;
        }

        public boolean isRecycled() {
            return isRecycled;
        }

        public void setRecycled(boolean recycled) {
            isRecycled = recycled;
        }
    }

    private class Recycler implements EasonTabRecycler<TabItem> {
        private Queue<TabItem> recycleItems = new LinkedList<>();

        @Override
        public TabItem getRecycleView() {
            return recycleItems.poll();
        }

        @Override
        public void recycle(TabItem view) {
            view.setRecycled(true);
            recycleItems.offer(view);
        }
    }

    private class Controller implements EasonTabController {
        private List<Entity> entities = new ArrayList<>();

        @Override
        @NonNull
        public List<EasonTab.Entity> entities() {
            return entities;
        }

        @Override
        public void add(@NonNull EasonTab.Entity... entities) {
            for (Entity entity : entities)
                this.entities.add(Checker.checkNull(entity));
        }

        @Override
        public void add(int index, @NonNull EasonTab.Entity entity) {
            entities.add(index, entity);
        }

        @Override
        public void remove(int index) {
            entities.remove(index);
        }

        @Override
        public void swap(int i, int j) {
            Collections.swap(entities, i, j);
        }

        @Override
        public void addWithLayout(@NonNull Entity... entities) {
            add(entities);
            update();
        }

        @Override
        public void addWithLayout(int index, @NonNull Entity entity) {
            add(index, entity);
            update();
        }

        @Override
        public void removeWithLayout(int index) {
            remove(index);
            update();
        }

        @Override
        public void swapWithLayout(int i, int j) {
            swap(i, j);
            update();
        }

        @SuppressWarnings("unchecked")
        @Override
        public void update() {
            layoutManager.layoutItems(EasonTab.this, entities, recycler);
        }

        @SuppressWarnings("unchecked")
        @Override
        public void active(int index) {
            activeIndex = index;
            adapter.onActiveTabItem((TabItem) getChildAt(index), entities.get(index));
        }

        @SuppressWarnings("unchecked")
        @Override
        public void reset(int index) {
            adapter.onResetTabItem((TabItem) getChildAt(index), entities.get(index));
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public void onClick(View v) {
        int index = indexOfChild(v);
        Entity entity = controller.entities().get(index);
        if (listener == null || !listener.intercept(this, (TabItem) v, entity)) {
            controller.reset(activeIndex);
            controller.active(index);
            if (fragmentAdapter != null) {
                for (int i = 0; i < controller.entities().size(); i++) {
                    Entity e = controller.entities().get(i);
                    Object f = fragmentAdapter.onAttachFragment(e);
                    fragmentAdapter.onBindFragment(f, e);
                    if (i == activeIndex) {
                        fragmentAdapter.onShowFragment(f, e);
                    } else {
                        fragmentAdapter.onHideFragment(f, e);
                    }
                }
            }
        }
        if (listener != null)
            listener.onItemClick(this, (TabItem) v, entity);
    }
}

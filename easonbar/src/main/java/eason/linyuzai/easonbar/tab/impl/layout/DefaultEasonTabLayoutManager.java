package eason.linyuzai.easonbar.tab.impl.layout;

import android.view.View;

import java.util.List;

import eason.linyuzai.easonbar.tab.EasonTab;
import eason.linyuzai.easonbar.tab.component.EasonTabAdapter;
import eason.linyuzai.easonbar.tab.component.EasonTabFragmentAdapter;
import eason.linyuzai.easonbar.tab.component.EasonTabLayoutManager;
import eason.linyuzai.easonbar.tab.component.EasonTabRecycler;

/**
 * Created by linyuzai on 2018/5/7.
 *
 * @author linyuzai
 */

public class DefaultEasonTabLayoutManager implements EasonTabLayoutManager<EasonTab.TabItem> {

    @Override
    public void layoutItems(EasonTab parent, List<EasonTab.Entity> entities, EasonTabRecycler<EasonTab.TabItem> recycler) {
        layoutChildren(parent, parent.getChildCount(), entities.size(), recycler);
        bindChildren(parent, entities);
    }

    public void layoutChildren(EasonTab parent, int childrenCount, int entitySize, EasonTabRecycler<EasonTab.TabItem> recycler) {
        if (childrenCount > entitySize) {
            for (int index = entitySize; index < childrenCount; index++) {
                View v = parent.getChildAt(index);
                parent.removeView(v);
                recycler.recycle((EasonTab.TabItem) v);
            }
        } else if (childrenCount < entitySize) {
            int height = parent.getLayoutParams().height;
            for (int index = childrenCount; index < entitySize; index++) {
                EasonTab.TabItem item = recycler.getRecycleView();
                if (item == null)
                    item = parent.getAdapter().onCreateTabItem(parent);
                item.initialize(height, parent);
                parent.addView(item);
            }
        }
    }

    @SuppressWarnings("unchecked")
    public void bindChildren(EasonTab parent, List<EasonTab.Entity> entities) {
        EasonTabAdapter adapter = parent.getAdapter();
        for (int index = 0; index < entities.size(); index++) {
            View v = parent.getChildAt(index);
            EasonTab.Entity entity = entities.get(index);
            boolean checkIndex = checkIndex(parent, entity, index);
            if (v instanceof EasonTab.TabItem) {
                adapter.onBindTabItem((EasonTab.TabItem) v, entity);
                if (checkIndex) {
                    adapter.onActiveTabItem((EasonTab.TabItem) v, entity);
                } else {
                    adapter.onResetTabItem((EasonTab.TabItem) v, entity);
                }
            }
            attachFragment(parent, entity, checkIndex);
        }
    }

    @SuppressWarnings("unchecked")
    public void attachFragment(EasonTab parent, EasonTab.Entity entity, boolean checkIndex) {
        EasonTabFragmentAdapter fragmentAdapter = parent.getFragmentAdapter();
        if (fragmentAdapter != null) {
            Object f = fragmentAdapter.onAttachFragment(entity);
            fragmentAdapter.onBindFragment(f, entity);
            if (checkIndex) {
                fragmentAdapter.onShowFragment(f, entity);
            } else {
                fragmentAdapter.onHideFragment(f, entity);
            }
        }
    }

    public boolean checkIndex(EasonTab parent, EasonTab.Entity entity, int index) {
        return index == 0;
    }
}

package eason.linyuzai.easonbar.tab.impl.adapter;

import android.view.ViewGroup;

import eason.linyuzai.easonbar.tab.EasonTab;
import eason.linyuzai.easonbar.tab.component.EasonTabAdapter;

/**
 * Created by linyuzai on 2018/5/5.
 *
 * @author linyuzai
 */

public class DefaultEasonTabAdapter implements EasonTabAdapter<EasonTab.TabItem> {

    @Override
    public EasonTab.TabItem onCreateTabItem(ViewGroup parent) {
        return new EasonTab.DefaultTabItem(parent.getContext());
    }

    @Override
    public void onBindTabItem(EasonTab.TabItem view, EasonTab.Entity entity) {
        view.update(entity);
    }

    @Override
    public void onActiveTabItem(EasonTab.TabItem view, EasonTab.Entity entity) {
        view.active();
    }

    @Override
    public void onResetTabItem(EasonTab.TabItem view, EasonTab.Entity entity) {
        view.reset();
    }
}

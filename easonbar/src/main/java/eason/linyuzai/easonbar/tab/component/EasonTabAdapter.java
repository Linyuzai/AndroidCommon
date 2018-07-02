package eason.linyuzai.easonbar.tab.component;

import android.view.ViewGroup;

import eason.linyuzai.easonbar.tab.EasonTab;

/**
 * Created by linyuzai on 2018/5/5.
 *
 * @author linyuzai
 */

public interface EasonTabAdapter<V extends EasonTab.TabItem> {
    V onCreateTabItem(ViewGroup parent);

    void onBindTabItem(V view, EasonTab.Entity entity);

    void onActiveTabItem(V view, EasonTab.Entity entity);

    void onResetTabItem(V view, EasonTab.Entity entity);
}

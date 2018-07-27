package eason.linyuzai.rxeason.listener.viewgroup;

import android.view.View;

public class OnHierarchyChangeInfo {
    private View parent;
    private View child;
    private boolean isOnChildViewAdded;
    private boolean isOnChildViewRemoved;

    OnHierarchyChangeInfo(View parent, View child, boolean isOnChildViewAdded, boolean isOnChildViewRemoved) {
        this.parent = parent;
        this.child = child;
        this.isOnChildViewAdded = isOnChildViewAdded;
        this.isOnChildViewRemoved = isOnChildViewRemoved;
    }

    public View getParent() {
        return parent;
    }

    public View getChild() {
        return child;
    }

    public boolean isOnChildViewAdded() {
        return isOnChildViewAdded;
    }

    public boolean isOnChildViewRemoved() {
        return isOnChildViewRemoved;
    }
}

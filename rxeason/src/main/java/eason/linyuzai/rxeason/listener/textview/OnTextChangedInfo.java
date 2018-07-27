package eason.linyuzai.rxeason.listener.textview;

import android.text.Editable;

public class OnTextChangedInfo {
    private CharSequence charSequence;
    private Editable editable;
    private int start;
    private int count;
    private int before;
    private int after;
    private boolean isBeforeTextChanged;
    private boolean isOnTextChanged;
    private boolean isAfterTextChanged;

    OnTextChangedInfo(CharSequence charSequence, int start, int count, int before, int after,
                      boolean isBeforeTextChanged, boolean isOnTextChanged) {
        this(charSequence, null, start, count, before, after,
                isBeforeTextChanged, isOnTextChanged, false);
    }

    OnTextChangedInfo(Editable editable) {
        this(null, editable, -1, -1, -1, -1,
                false, false, true);
    }

    OnTextChangedInfo(CharSequence charSequence, Editable editable, int start, int count, int before, int after,
                      boolean isBeforeTextChanged, boolean isOnTextChanged, boolean isAfterTextChanged) {
        this.charSequence = charSequence;
        this.editable = editable;
        this.start = start;
        this.count = count;
        this.before = before;
        this.after = after;
        this.isBeforeTextChanged = isBeforeTextChanged;
        this.isOnTextChanged = isOnTextChanged;
        this.isAfterTextChanged = isAfterTextChanged;
    }

    public CharSequence getCharSequence() {
        return charSequence;
    }

    public void setCharSequence(CharSequence charSequence) {
        this.charSequence = charSequence;
    }

    public Editable getEditable() {
        return editable;
    }

    public void setEditable(Editable editable) {
        this.editable = editable;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getBefore() {
        return before;
    }

    public void setBefore(int before) {
        this.before = before;
    }

    public int getAfter() {
        return after;
    }

    public void setAfter(int after) {
        this.after = after;
    }

    public boolean isBeforeTextChanged() {
        return isBeforeTextChanged;
    }

    public void setBeforeTextChanged(boolean beforeTextChanged) {
        isBeforeTextChanged = beforeTextChanged;
    }

    public boolean isOnTextChanged() {
        return isOnTextChanged;
    }

    public void setOnTextChanged(boolean onTextChanged) {
        isOnTextChanged = onTextChanged;
    }

    public boolean isAfterTextChanged() {
        return isAfterTextChanged;
    }

    public void setAfterTextChanged(boolean afterTextChanged) {
        isAfterTextChanged = afterTextChanged;
    }
}

package eason.linyuzai.rxeason.listener.textview;

import android.text.Editable;

public class OnTextChangedInfo {
    private BeforeTextChangedMethodParam beforeTextChangedMethodParam;
    private OnTextChangedMethodParam onTextChangedMethodParam;
    private AfterTextChangedMethodParam afterTextChangedMethodParam;
    private boolean isBeforeTextChanged;
    private boolean isOnTextChanged;
    private boolean isAfterTextChanged;

    OnTextChangedInfo(BeforeTextChangedMethodParam beforeTextChangedMethodParam) {
        this.beforeTextChangedMethodParam = beforeTextChangedMethodParam;
        isBeforeTextChanged = true;
    }

    OnTextChangedInfo(OnTextChangedMethodParam onTextChangedMethodParam) {
        this.onTextChangedMethodParam = onTextChangedMethodParam;
        isOnTextChanged = true;
    }

    OnTextChangedInfo(AfterTextChangedMethodParam afterTextChangedMethodParam) {
        this.afterTextChangedMethodParam = afterTextChangedMethodParam;
        isAfterTextChanged = true;
    }

    public BeforeTextChangedMethodParam getBeforeTextChangedMethodParam() {
        return beforeTextChangedMethodParam;
    }

    public OnTextChangedMethodParam getOnTextChangedMethodParam() {
        return onTextChangedMethodParam;
    }

    public AfterTextChangedMethodParam getAfterTextChangedMethodParam() {
        return afterTextChangedMethodParam;
    }

    public boolean isBeforeTextChanged() {
        return isBeforeTextChanged;
    }

    public boolean isOnTextChanged() {
        return isOnTextChanged;
    }

    public boolean isAfterTextChanged() {
        return isAfterTextChanged;
    }

    public static class BeforeTextChangedMethodParam {
        private CharSequence charSequence;
        private int start;
        private int count;
        private int after;

        BeforeTextChangedMethodParam(CharSequence charSequence, int start, int count, int after) {
            this.charSequence = charSequence;
            this.start = start;
            this.count = count;
            this.after = after;
        }

        public CharSequence getCharSequence() {
            return charSequence;
        }

        public int getStart() {
            return start;
        }

        public int getCount() {
            return count;
        }

        public int getAfter() {
            return after;
        }
    }

    public static class OnTextChangedMethodParam {
        private CharSequence charSequence;
        private int start;
        private int count;
        private int before;

        OnTextChangedMethodParam(CharSequence charSequence, int start, int count, int before) {
            this.charSequence = charSequence;
            this.start = start;
            this.count = count;
            this.before = before;
        }

        public CharSequence getCharSequence() {
            return charSequence;
        }

        public int getStart() {
            return start;
        }

        public int getCount() {
            return count;
        }

        public int getBefore() {
            return before;
        }
    }

    public static class AfterTextChangedMethodParam {
        private Editable editable;

        public AfterTextChangedMethodParam(Editable editable) {
            this.editable = editable;
        }

        public Editable getEditable() {
            return editable;
        }
    }
}

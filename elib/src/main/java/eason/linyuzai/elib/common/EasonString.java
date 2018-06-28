package eason.linyuzai.elib.common;

import android.support.annotation.Nullable;

import java.util.Collection;

public class EasonString {

    public static String join(@Nullable Collection<? extends CharSequence> strings) {
        return join(strings, ",");
    }

    public static String join(@Nullable Collection<? extends CharSequence> strings, CharSequence delimiter) {
        if (strings == null)
            return "";
        StringBuilder builder = new StringBuilder();
        int i = 0;
        for (CharSequence string : strings) {
            if (i != 0)
                builder.append(delimiter);
            builder.append(string);
            i++;
        }
        return builder.toString();
    }
}

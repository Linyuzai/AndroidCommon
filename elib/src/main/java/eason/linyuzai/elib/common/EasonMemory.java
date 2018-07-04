package eason.linyuzai.elib.common;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@SuppressWarnings("unchecked")
public class EasonMemory {

    private static EasonMemory memory = new EasonMemory();

    private Map<String, Object> safe = new ConcurrentHashMap<>();
    private Map<String, Object> unsafe = new HashMap<>();

    public static EasonMemory getInstance() {
        return memory;
    }

    public <T> void safe(String key, T value) {
        safe.put(key, value);
    }

    public <T> T safe(String key) {
        return (T) safe.get(key);
    }

    public <T> void unsafe(String key, T value) {
        unsafe.put(key, value);
    }

    public <T> T unsafe(String key) {
        return (T) unsafe.get(key);
    }
}

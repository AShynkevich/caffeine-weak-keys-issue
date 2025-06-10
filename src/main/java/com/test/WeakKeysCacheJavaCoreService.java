package com.test;

import java.util.WeakHashMap;

public class WeakKeysCacheJavaCoreService {
    private final WeakHashMap<Key, String> cache;

    public WeakKeysCacheJavaCoreService() {
        this.cache = new WeakHashMap<>();
    }

    public void put(Key key, String value) {
        cache.put(key, value);
    }

    public String get(Key key) {
        return cache.get(key);
    }
}

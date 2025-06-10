package com.test;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;

public class CaffeineWeakKeysService {

    private final Cache<Key, Long> cache;

    public CaffeineWeakKeysService() {
        cache = Caffeine.newBuilder()
                .weakKeys()
                .build();
    }

    public Long get(Key key) {
        return cache.getIfPresent(key);
    }

    public void put(Key key, Long value) {
        cache.put(key, value);
    }
}

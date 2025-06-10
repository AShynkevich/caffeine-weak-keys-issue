package com.test;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;

public class CaffeineNoWeakKeysService {

    private final Cache<Key, Long> cache;

    public CaffeineNoWeakKeysService() {
        cache = Caffeine.newBuilder()
                .build();
    }

    public Long get(Key key) {
        return cache.getIfPresent(key);
    }

    public void put(Key key, Long value) {
        cache.put(key, value);
    }
}

package com.test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CaffeineServiceTest {

    private final CaffeineWeakKeysService caffeineWeakKeysService = new CaffeineWeakKeysService();
    private final CaffeineNoWeakKeysService caffeineNoWeakService = new CaffeineNoWeakKeysService();
    private final WeakKeysCacheJavaCoreService javaCoreWeakCache = new WeakKeysCacheJavaCoreService();

    // The test is failed because the null is coming from the cache
    @Test
    void testGetWithWeakKeys() {
        caffeineWeakKeysService.put(new Key(1), 1L);
        caffeineWeakKeysService.put(new Key(2), 2L);
        caffeineWeakKeysService.put(new Key(3), 3L);

        assertEquals(1L, caffeineWeakKeysService.get(new Key(1)));
        assertEquals(2L, caffeineWeakKeysService.get(new Key(2)));
        assertEquals(3L, caffeineWeakKeysService.get(new Key(3)));
    }

    // The test is passed
    @Test
    void testGetNoWeakKeys() {
        caffeineNoWeakService.put(new Key(1), 1L);
        caffeineNoWeakService.put(new Key(2), 2L);
        caffeineNoWeakService.put(new Key(3), 3L);

        assertEquals(1L, caffeineNoWeakService.get(new Key(1)));
        assertEquals(2L, caffeineNoWeakService.get(new Key(2)));
        assertEquals(3L, caffeineNoWeakService.get(new Key(3)));
    }

    // The test is passed
    @Test
    void testJavaCoreWeakKeys() {
        javaCoreWeakCache.put(new Key(1), "1");
        javaCoreWeakCache.put(new Key(2), "2");
        javaCoreWeakCache.put(new Key(3), "3");

        assertEquals("1", javaCoreWeakCache.get(new Key(1)));
        assertEquals("2", javaCoreWeakCache.get(new Key(2)));
        assertEquals("3", javaCoreWeakCache.get(new Key(3)));
    }
}
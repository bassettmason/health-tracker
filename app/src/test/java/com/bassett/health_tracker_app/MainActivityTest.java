package com.bassett.health_tracker_app;

import org.junit.Test;

import static org.junit.Assert.*;

public class MainActivityTest {

    @Test
    public void lifeTest() {
        assertEquals("hello world",MainActivity.life);
    }
}
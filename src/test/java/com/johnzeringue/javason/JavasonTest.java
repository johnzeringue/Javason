package com.johnzeringue.javason;

import org.json.JSONObject;
import org.junit.Test;

import static com.johnzeringue.javason.Javason.json;
import static org.junit.Assert.*;

public class JavasonTest {

    @Test
    public void testEmptyCallCreatesEmptyObject() {
        JSONObject jsonObject = json();
        assertTrue(jsonObject.keySet().isEmpty());
    }

    @Test
    public void testCreatesSimpleObject() {
        JSONObject jsonObject = json(
                key1 -> 1,
                key2 -> "two",
                key3 -> 3.0
        );

        assertEquals(1, jsonObject.getInt("key1"));
        assertEquals("two", jsonObject.getString("key2"));
        assertEquals(3.0, jsonObject.getDouble("key3"), 0);
    }

    @Test
    public void testCreatesNestedObject() {
        JSONObject jsonObject = json(
                nested -> json(key -> "value")
        );

        assertEquals("value", jsonObject
                .getJSONObject("nested")
                .getString("key"));
    }

}
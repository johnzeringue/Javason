package com.johnzeringue.javason;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by johnzeringue on 8/19/15.
 */
public class FieldTest {

    private Field field;

    @Before
    public void setUp() {
        this.field = new Field(key -> "value");
    }

    @Test
    public void testGetKey() {
        assertEquals("key", field.getKey());
    }

    @Test
    public void testGetValue() {
        assertEquals("value", field.getValue());
    }

}

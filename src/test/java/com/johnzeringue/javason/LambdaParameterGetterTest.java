package com.johnzeringue.javason;

import org.junit.Before;
import org.junit.Test;

import java.io.Serializable;
import java.lang.reflect.Parameter;
import java.util.function.Function;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by johnzeringue on 9/7/15.
 */
public class LambdaParameterGetterTest {

    private LambdaParameterGetter lambdaParameterGetter;

    @Before
    public void setUp() {
        lambdaParameterGetter = new LambdaParameterGetter();
    }

    private static interface LambdaInterface
            extends Function<String, String>, Serializable {
    }

    @Test
    public void testGetParameter() throws Exception {
        LambdaInterface lambda = key -> "value";
        Parameter parameter = lambdaParameterGetter.getParameter(lambda);

        assertNotNull(parameter);
        assertEquals("key", parameter.getName());
        assertEquals(String.class, parameter.getType());
    }

}
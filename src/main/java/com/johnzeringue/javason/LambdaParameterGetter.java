package com.johnzeringue.javason;

import java.io.Serializable;
import java.lang.invoke.SerializedLambda;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Objects;

import static java.util.Arrays.asList;

/**
 * A getter for lambda function parameters.
 */
public class LambdaParameterGetter {

    private SerializedLambda serializeLambda(Serializable lambda) {
        try {
            Method writeReplace = lambda
                    .getClass()
                    .getDeclaredMethod("writeReplace");

            writeReplace.setAccessible(true);
            return (SerializedLambda) writeReplace.invoke(lambda);
        } catch (ReflectiveOperationException ex) {
            throw new RuntimeException(ex);
        }
    }

    private Class<?> getImplClass(SerializedLambda serializedLambda) {
        try {
            String implClassName = serializedLambda
                    .getImplClass()
                    .replaceAll("/", ".");

            return Class.forName(implClassName);
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }
    }

    private Method getImplMethod(SerializedLambda serializedLambda) {
        Class<?> implClass = getImplClass(serializedLambda);

        return asList(implClass.getDeclaredMethods())
                .stream()
                .filter(method -> Objects.equals(
                        method.getName(),
                        serializedLambda.getImplMethodName()))
                .findFirst()
                .orElseThrow(RuntimeException::new);
    }

    /**
     * Returns the first parameter for a serializable lambda function.
     *
     * @param lambda the lambda function
     * @return the lambda function's first parameter, if it exists
     */
    public Parameter getParameter(Serializable lambda) {
        SerializedLambda serializedLambda = serializeLambda(lambda);
        Method implMethod = getImplMethod(serializedLambda);
        return implMethod.getParameters()[0];
    }

}

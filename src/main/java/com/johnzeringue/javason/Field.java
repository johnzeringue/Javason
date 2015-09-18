package com.johnzeringue.javason;

/**
 * A key-value field.
 */
public class Field {

    private static final LambdaParameterGetter lambdaParameterGetter
            = new LambdaParameterGetter();

    private SerializableVoidFunction<?> lambda;

    /**
     * Creates a new field.
     *
     * @param lambda the lambda from which to create the field
     */
    public Field(SerializableVoidFunction<?> lambda) {
        this.lambda = lambda;
    }

    /**
     * Returns this field's key.
     *
     * @return this field's key
     */
    public String getKey() {
        return lambdaParameterGetter.getParameter(lambda).getName();
    }

    /**
     * Returns this field's value.
     *
     * @return this field's value
     */
    public Object getValue() {
        return lambda.apply(null);
    }

}

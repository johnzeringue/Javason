package com.johnzeringue.javason;

import org.json.JSONObject;

import java.util.Collection;

/**
 * Javason is a Java DSL that makes it easy to specify JSON directly inside of
 * Java source code.
 */
public class Javason {

    /**
     * Creates a {@link JSONObject} out of a list of lambda functions.
     * <p>
     * Example:
     * <pre>{@code
     * String testPayload = json(
     *    key -> "value",
     *    with -> json(
     *        escapeCharacters -> true
     *    )
     * ).toString();
     * }</pre>
     *
     * @param fields a list of fields as lambda functions
     * @return the JSON interpretation of the Javason DSL
     */
    public static JSONObject json(SerializableVoidFunction... fields) {
        JSONObject jsonObject = new JSONObject();

        for (SerializableVoidFunction fieldLambda : fields) {
            Field field = new Field(fieldLambda);
            Object fieldValue = field.getValue();

            if (fieldValue instanceof Collection) {
                jsonObject.put(field.getKey(), fieldValue);
            } else {
                jsonObject.put(field.getKey(), fieldValue);
            }
        }

        return jsonObject;
    }

}

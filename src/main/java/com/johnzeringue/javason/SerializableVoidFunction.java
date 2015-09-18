package com.johnzeringue.javason;

import java.io.Serializable;
import java.util.function.Function;

/**
 * A serializable function that does not use its argument.
 */
public interface SerializableVoidFunction<R>
        extends Function<Void, R>, Serializable {
}

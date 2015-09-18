/**
 * Javason is a Java DSL that makes it easy to specify JSON directly inside of
 * Java source code.
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
 */
package com.johnzeringue.javason;
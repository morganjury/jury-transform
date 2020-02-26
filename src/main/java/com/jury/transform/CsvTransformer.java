package com.jury.transform;

import com.jury.exception.TransformerException;

/**
 * This will either consume or produce an object to produce or consume a String in CSV format.
 *
 * @param <T> The object type
 */
public interface CsvTransformer<T> extends FileTransformer<T> {

    String COMMA_IN_QUOTES_REGEX = ",(?=(?:[^\\\"]*\\\"[^\\\"]*\\\")*[^\\\"]*$)";

    /**
     * This method consumes a single line of CSV to produce an object.
     *
     * @param csv the single line of CSV representing a single DatabaseObject
     * @return the object represented
     * @throws TransformerException if the object cannot be produced
     */
    @Override
    T consume(String csv) throws TransformerException;

    /**
     * This method consumes an object to produce a String in CSV format.
     *
     * @param object
     * @return a String in CSV format
     * @throws TransformerException if the object cannot be consumed
     */
    @Override
    String produce(T object) throws TransformerException;

}

package com.jury.transform;

import com.jury.exception.TransformerException;

/**
 * This will either consume or produce an object to produce or consume a String in some format e.g. CSV, pipe delimited file.
 *
 * This class is intended for generating strings that can be used for exporting and importing data to/from a file.
 *
 * @param <T>
 */
public interface FileTransformer<T> extends Transformer<String, T> {

    /**
     * This method consumes a single line of a file to produce an object.
     *
     * @param fileLine the single line of the file representing a single DatabaseObject
     * @return the object represented
     * @throws TransformerException if the object cannot be produced
     */
    @Override
    T consume(String fileLine) throws TransformerException;

    /**
     * This method consumes an object to produce a String in some format.
     *
     * @param object
     * @return a String in some format
     * @throws TransformerException if the object cannot be consumed
     */
    @Override
    String produce(T object) throws TransformerException;

}

package com.jury.transform;

import com.jury.exception.TransformerException;

import java.sql.ResultSet;

public interface ResultSetTransformer<T> extends Transformer<T, ResultSet> {

	String NO_OP_MESSAGE = "Cannot generate ResultSet object, use insertString method";

	/**
	 * This method consumes a DatabaseObject to produce a String that can be used in a SQL insert statement.
	 *
	 * @param object the DatabaseObject
	 * @return A String ready for use in an insert statement
	 * @throws TransformerException if the object cannot be consumed
	 */
	String insertString(T object) throws TransformerException;

}

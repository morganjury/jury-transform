package com.jury.transform.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.jury.exception.TransformerException;
import com.jury.transform.Transformer;

import java.io.IOException;

public class JsonTransformer<T> implements Transformer<T, String> {

	private ObjectMapper mapper = new ObjectMapper();
	private Class<T> clazz;

	public JsonTransformer(Class<T> clazz) {
		this.clazz = clazz;
	}

	// this or add @JsonSerialize(using = ItemSerializer.class) to T
	public void addSerializer(JsonSerializer<T> serializer) {
		mapper.registerModule(new SimpleModule().addSerializer(clazz, serializer));
	}

	// this or add @JsonDeserialize(using = ItemDeserializer.class) to T
	public void addDeserializer(JsonDeserializer<T> deserializer) {
		mapper.registerModule(new SimpleModule().addDeserializer(clazz, deserializer));
	}

	@Override
	public String consume(T object) throws TransformerException {
		try {
			return mapper.writeValueAsString(object);
		} catch (JsonProcessingException e) {
			throw new TransformerException(clazz, String.class, e);
		}
	}

	@Override
	public T produce(String object) throws TransformerException {
		try {
			return mapper.readValue(object, clazz);
		} catch (IOException e) {
			throw new TransformerException(String.class, clazz, e);
		}
	}

}

package com.raghu.JacksonSerializations.Jackson_Serializationsdemo.filters;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class HideableSerializer extends JsonSerializer<Hidable> {

	private JsonSerializer<Object> defaultSerializer;

	public HideableSerializer(JsonSerializer<Object> serializer) {
	        defaultSerializer = serializer;
	    }

	@Override
	public void serialize(Hidable value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
		if (value.isHidden())
			return;
		defaultSerializer.serialize(value, gen, serializers);

	}

	@Override
	public boolean isEmpty(SerializerProvider provider, Hidable value) {
		// TODO Auto-generated method stub
		return (value == null || value.isHidden());
	}

}

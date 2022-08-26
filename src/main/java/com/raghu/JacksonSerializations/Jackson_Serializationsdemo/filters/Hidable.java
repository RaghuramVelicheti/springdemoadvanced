package com.raghu.JacksonSerializations.Jackson_Serializationsdemo.filters;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties("hidden")
public interface Hidable {
	
	boolean isHidden();

}

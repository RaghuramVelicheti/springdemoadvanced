package com.raghu.JacksonSerializations.Jackson_Serializationsdemo.dto;

import com.raghu.JacksonSerializations.Jackson_Serializationsdemo.filters.Hidable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address implements Hidable{
	
	private String addressLine1;
	
	private String city;
	
	private String state;
	
	private String country;
	
	private boolean hidden;

	@Override
	public boolean isHidden() {
		// TODO Auto-generated method stub
		return this.hidden;
	}

}

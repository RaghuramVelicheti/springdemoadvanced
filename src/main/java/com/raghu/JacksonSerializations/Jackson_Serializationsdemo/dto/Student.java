package com.raghu.JacksonSerializations.Jackson_Serializationsdemo.dto;

import java.util.List;

import com.raghu.JacksonSerializations.Jackson_Serializationsdemo.filters.Hidable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student implements Hidable{
	
	private int id;
	
	private String name;
	
	private String department;
	
	private Address address;
	
	private List<Course> courses;
	
	private boolean hidden;

	@Override
	public boolean isHidden() {
		// TODO Auto-generated method stub
		return this.hidden;
	}

}

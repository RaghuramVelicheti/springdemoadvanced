package com.raghu.JacksonSerializations.Jackson_Serializationsdemo.dto;

import com.raghu.JacksonSerializations.Jackson_Serializationsdemo.filters.Hidable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course implements Hidable{
	
	private int courseId;
	
	private String courseName;
	
	private double cousrseDuration;
	private boolean hidden;

	@Override
	public boolean isHidden() {
		// TODO Auto-generated method stub
		return this.hidden;
	}
	

}

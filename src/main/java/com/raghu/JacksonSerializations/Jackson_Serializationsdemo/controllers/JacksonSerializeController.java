package com.raghu.JacksonSerializations.Jackson_Serializationsdemo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.BeanSerializerModifier;
import com.raghu.JacksonSerializations.Jackson_Serializationsdemo.dto.Address;
import com.raghu.JacksonSerializations.Jackson_Serializationsdemo.dto.Course;
import com.raghu.JacksonSerializations.Jackson_Serializationsdemo.dto.Student;
import com.raghu.JacksonSerializations.Jackson_Serializationsdemo.filters.Hidable;
import com.raghu.JacksonSerializations.Jackson_Serializationsdemo.filters.HideableSerializer;

@RestController
public class JacksonSerializeController {

	@GetMapping("/getAllValues")
	public ResponseEntity<?> getJsonResponse() throws JsonProcessingException {
		System.out.println("Controller Init");
		Course c1 = new Course(1, "Java Serialization", 3.50, false);
		Course c2 = new Course(2, "Java De Serialization", 3.57, false);
		Course c3 = new Course(3, "Java Multi Threading", 5.5, true);
		List<Course> courses = new ArrayList<>();
		courses.add(c3);
		courses.add(c2);
		courses.add(c1);

		Address address = new Address("Test Address", "Hyderabad", "Telangaga", "India", false);

		Student s1 = new Student(1, "Test Student", "IT", address, courses, false);

		Course c4 = new Course(1, "Java Serialization", 3.50, true);
		Course c5 = new Course(2, "Java De Serialization", 3.57, false);
		Course c6 = new Course(3, "Java Multi Threading", 5.5, true);
		List<Course> courses1 = new ArrayList<>();
		courses1.add(c4);
		courses1.add(c5);
		courses1.add(c6);

		Address address1 = new Address("Test Address", "Hyderabad", "Telangaga", "India", true);

		Student s2 = new Student(1, "Test Student", "IT", address, courses, false);

		ObjectMapper mapper = new ObjectMapper();
		mapper.setSerializationInclusion(Include.NON_EMPTY);
		mapper.registerModule(new SimpleModule() {

			@Override
			public void setupModule(SetupContext context) {
				super.setupModule(context);
				context.addBeanSerializerModifier(new BeanSerializerModifier() {

					@Override
					public JsonSerializer<?> modifySerializer(SerializationConfig config, BeanDescription beanDesc,
							JsonSerializer<?> serializer) {
						if (Hidable.class.isAssignableFrom(beanDesc.getClass())) {
							return new HideableSerializer((JsonSerializer<Object>) serializer);
						}
						return super.modifySerializer(config, beanDesc, serializer);
					}

				});
			}

		});
		System.out.println(mapper.writeValueAsString(s1));
		System.out.println(mapper.writeValueAsString(s2));
		System.out.println("Controller Exit");
		return ResponseEntity.ok(s1);
	}

}

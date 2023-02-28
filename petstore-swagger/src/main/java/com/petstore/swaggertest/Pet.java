package com.petstore.swaggertest;

import io.swagger.annotations.ApiModelProperty;

public class Pet {
	@ApiModelProperty(notes = "Name of the Pet",name="name",required=true,value="test name")
	private String name;
	@ApiModelProperty(notes = "Class of the Student",name="cls",required=true,value="test class")
	private String id;
	
	public Pet(String name, String id) {
		super();
		this.name = name;
		this.id = id;
	}


	public String getId() {
		return id;
	}


	public String getName() {
		return name;
	}

	
}

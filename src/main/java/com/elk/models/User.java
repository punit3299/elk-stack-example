package com.elk.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Data
public class User {
	
	private int id;
	private String name;
	
	public User() {
		
	}

}

package backend;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UserModel {
	//Variables
	private int id;
	private String name;
	private String password;
	
	//Lists + Maps
	
	//Methods
	public UserModel() {
		
	}
	
	@JsonCreator
	public UserModel(@JsonProperty("name")String name, @JsonProperty("password")String password) {
		this.name = name;
		this.password = password;
	}
	
	public UserModel(int id,String name, String password) {
		this.id = id;
		this.name = name;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}

package com.Account.Account;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Accounts")
public class AccountModel {
    
	@Id
	public  String id;
	public  String name;
	public  String email;
	
	
	public AccountModel(String name, String email) {
	
		
		this.name=name;
		this.email=email;
	}
	
	public AccountModel()
	{
		
	}
	

	public String getId() {
		return id;
	}
	
	public String toString() {
		return "AccountModel [id=" + id + ", name=" + name + ", email=" + email + "]";
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}

package cn.com.zlqf.spittr.entity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Spitter {
	private String id;
	@NotNull
	@Size(min=1,max=5)
	private String firstName;
	@NotNull
	@Size(min=1,max=5)
	private String lastName;
	@NotNull
	@Size(min=5,max=10)
	private String username;
	@NotNull
	@Size(min=6,max=20)
	private String password;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Spitter [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", username=" + username
				+ ", password=" + password + "]";
	}
}

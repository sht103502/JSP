package dto;

public class MemberDTO {
/*
 * DTO (Data Transfer Object)
 * VO (Value Object)
 */
	
private String id;
private String password;
private String jsname;
private String birth;
private String gender;
private String email;
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getJsname() {
	return jsname;
}
public void setJsname(String jsname) {
	this.jsname = jsname;
}
public String getBirth() {
	return birth;
}
public void setBirth(String birth) {
	this.birth = birth;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}

}

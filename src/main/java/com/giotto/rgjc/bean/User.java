package com.giotto.rgjc.bean;



//用户信息

public class User {

  private Long id;

  private String username;

  private String password;
  
  private String pos;
  

public String getUsername() {
	// TODO Auto-generated method stub
	return this.username;
}

public String getPassword() {
	// TODO Auto-generated method stub
	return this.password;
}

public Long getId() {
	// TODO Auto-generated method stub
	return this.id;
}

public String getPos(){
	return this.pos;
}

public void setPos(String p) {
	this.pos=p;
}

public void setId(Long userId) {
	// TODO Auto-generated method stub
	this.id=userId;
}

public void setUsername(String str) {
	// TODO Auto-generated method stub
	this.username=str;
}
public void setPassword(String str) {
	// TODO Auto-generated method stub
	this.password=str;
}


  //... getter and setter

}



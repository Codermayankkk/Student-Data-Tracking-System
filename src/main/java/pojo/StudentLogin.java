package pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student_login")
public class StudentLogin 
{
   @Id
   private int username;
   private String password;
   
public int getUsername() 
{
	return username;
}

public void setUsername(int username) 
{
	this.username = username;
}

public String getPassword() 
{
	return password;
}

public void setPassword(String password) 
{
	this.password = password;
}
   
}
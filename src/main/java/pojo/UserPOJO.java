package pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class UserPOJO 
{
	@Id
	private int username;
	private String name, section;
	private String address;
	private String mobile;

	public String getSection() 
	{
		return section;
	}

	public void setSection(String section) 
	{
		this.section = section;
	}

	public UserPOJO() 
	{
		
	}

	public UserPOJO(int username, String name, String section, String address, String mobile) 
	{

		this.username = username;
		this.name = name;
		this.section = section;
		this.address = address;
		this.mobile = mobile;
	}

	public int getUsername() 
	{
		return username;
	}

	public void setUsername(int username) 
	{
		this.username = username;
	}

	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public String getAddress() 
	{
		return address;
	}

	public void setAddress(String address) 
	{
		this.address = address;
	}

	public String getMobile() 
	{
		return mobile;
	}

	public void setMobile(String mobile) 
	{
		this.mobile = mobile;
	}

}

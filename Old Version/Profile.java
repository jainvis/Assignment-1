package assignment;
import java.awt.image.BufferedImage;
import java.util.*;

/**
 * Abstract Profile class to define basic information of a Profile
 * @version 8.0 28 Mar 2018
 * @author Vishesh Jain
 */

public abstract class Profile {
	
	private String name;
	private int age;
	private String status;
	private BufferedImage photo;
	private ArrayList<String> friendlist = new ArrayList<String>();
	
	public Profile (String name, int age, String status, BufferedImage photo, ArrayList<String> friendlist){
		
		this.name = name;
		this.age = age;
		this.status = status;
		this.photo = photo;
		this.friendlist.addAll(friendlist);
	}
	
	public Profile(String name, int age, BufferedImage photo, ArrayList<String> friendlist){
		
		this(name, age, null, photo, friendlist);	//If Status not given
	}
	
	public Profile(String name, int age, String status){

		this(name, age, status, null, new ArrayList<String>()); //Constructor if photo and friend list is not given
	}
	
	public Profile(String name, int age, String status, ArrayList<String> friendlist){

		this(name, age, status, null, friendlist);
	}
	
//	public Profile(String name, int age, ArrayList<String> friendlist){
//
//		this(name, age, null, null, friendlist); //Constructor if only name and age are used
//	}
//	
//	public Profile(String name, int age){
//
//		this(name, age, null, null, new ArrayList<String>() ); //Constructor if only name and age are used
//	}
	
	//Getters for the Class	
	public String getName() { return name; }
	
	public int getAge() {return age;} 
	
	public String getStatus() {return status;}
	
	public BufferedImage getPhoto(){return photo;}
	
	public ArrayList<String> getFriendlist(){return friendlist;}
	
	//Setters for the Class
	public void setName(String name){this.name = name;}
	
	public void setAge(int age) throws NoSuchAgeException{
		if (age <0 | age >150) {
			throw new NoSuchAgeException("This age is not possible in today's world");
		}
		else {
			this.age = age;
			}
		}
	
	public void setStatus(String status){this.status = status;}
	
	public void setFriend(String friend){
		this.friendlist.add(friend);
			
	}
		
}

package backend;

import java.util.*;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	//Variables
	List<UserModel> list = new LinkedList<UserModel>();
	
	//Methods
	@RequestMapping("/")
	public String greeting() {
		return "Hello Esslingen SS23";
	}
	
	@GetMapping("/users/{id}")
	public String getUser(@PathVariable int id) {
		if(list.isEmpty()) {
			return "no users available!";
		}
		
		for(UserModel user : list) {
			if(user.getId() == id) {
				return "User found for ID " + id + ": " + user.getName();
			}
		}
		return "no user found for this ID";
	}
	
	@GetMapping("/users")
	public String getUsers() {
		if(list.isEmpty()) return "No user found";
		
		String output = new String("");
		for(UserModel user : list) {
			output = output + user.getId() + ", " + user.getName() + "; ";
		} 
		
		return output;
	}
	
	@PostMapping("/user")
	public String createUser(@RequestBody UserModel input) {
		UserModel newUser = new UserModel();
		newUser.setId(list.size() + 1);
		newUser.setName(input.getName());
		newUser.setPassword(input.getPassword());
		
		list.add(newUser);
		
		return "User successfully created";
	}
	
	@PutMapping("/user/{id}")
	public String updateUser(@PathVariable int id, @RequestBody UserModel input) {
		for(UserModel user : list) {
			if(user.getId() == id) {
				user.setName(input.getName());
				user.setPassword(input.getPassword());
				return "User Data for " + user.getId() + " successfully changed!";
			}
		}
		return "No user found with ID " + input.getId();
	}
	
	@DeleteMapping("/user/{id}")
	public String deleteUser(@PathVariable int id) {
		for(UserModel user : list) {
			if(user.getId() == id) {
				list.remove(user);
				return "User successfully removed";
			}
		}
		
		return "No user found with ID " + id;
	}
	
}

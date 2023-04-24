package backend;

import java.util.*;

import org.springframework.http.MediaType;
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
	
	@PostMapping(path = "/user",
	consumes={MediaType.APPLICATION_JSON_VALUE},
	produces= {MediaType.APPLICATION_JSON_VALUE})
	public String createUser(@RequestBody UserModel model) {
		UserModel newUser = new UserModel();
		newUser.setId(list.size() + 1);
		newUser.setName(model.getName());
		newUser.setPassword(model.getPassword());
		
		list.add(newUser);
		
		return "User successfully created";
	}
	
}

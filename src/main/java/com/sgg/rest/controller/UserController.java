package com.sgg.rest.controller;



import java.util.HashMap;
import java.util.List;
import java.util.Map;


//curl -i -H "Content-Type: application/json" -X POST -d '{
//    "name": "hxw",
//    "password": "520"
//}' http://localhost:8080/login
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sgg.rest.model.ApplicationUser;
import com.sgg.rest.model.UserQuery;
import com.sgg.rest.repository.UserRepository;
import com.sgg.rest.service.UserService;
import static com.sgg.rest.util.SystemConstants.PAGESIZE;
@RestController
@RequestMapping("/user") // This means URL's start with /user (after Application path)
public class UserController {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired  
    UserService userService;  

//curl -H "Authorization: Bearer xxx.yyy.zzz" localhost:8080/user/all （带 token认证）
	// curl localhost:8080/user/all
	@GetMapping(path="/userlist")
//	public Iterable<ApplicationUser> getAllUsers() {
//		// This returns a JSON or XML with the users
////		return userRepository.findAll();
//		return userRepository.findallAccounts();
//	}
	public ResponseEntity<Map<String,Object>> getAllUsers() {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("userList",userRepository.findallAccounts() );
		return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
	}
//	@RequestMapping(value="/sign-up", method=RequestMethod.POST)
//	public ResponseEntity<Map<String,Object>>  getNewUser( @RequestBody ApplicationUser u) {
//		Map<String,Object> map = new HashMap<String,Object>();
//		ApplicationUser f_user = userRepository.findByName(u.getName());
////		List <ApplicationUser> userList = null;
//		if (f_user!=null) {
//			map.put("result", "user sign up failed,user exists");
//		return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
//		}
//		u.setPassword(bCryptPasswordEncoder.encode(u.getPassword()));
//		userRepository.save(u);
//		map.put("result", "user sign up success");
//		return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
//	}

//    @RequestMapping(value = "userQuery",method = RequestMethod.POST)  
//    public Page<ApplicationUser> findUserQuery(@RequestBody UserQuery userQuery){  
//    	int page =0; //页码
//    	int 	size =10; //页面大小
//        Page<ApplicationUser> datas = userService.findUserCriteria(page, size,userQuery);  
//        return datas;  
//    }
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public ResponseEntity<Map<String,Object>> UpdateUser(@RequestBody ApplicationUser u) {
		Map<String,Object> map = new HashMap<String,Object>();
		boolean res = userService.updateApplicationUser(u.getId(), u);
		map.put("result", res);
		return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
	}
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public ResponseEntity<Map<String,Object>> DeleteUser(@RequestParam int id) {
		Map<String,Object> map = new HashMap<String,Object>();
		userRepository.delete(id);
		map.put("result", "delete success");
		return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
	}
    @RequestMapping(value = "list",method = RequestMethod.GET)  
    public  ResponseEntity<Map<String,Object>> getUserList(@RequestParam Integer page){  
    		Map<String,Object> map = new HashMap<String,Object>();
        Page<ApplicationUser> paginationUser = userService.findUserNoCriteria(page, PAGESIZE);
        map.put("result", paginationUser);
        return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);  
    }
    @RequestMapping(value = "querylist",method = RequestMethod.POST)  
    public  ResponseEntity<Map<String,Object>> getUserQueryList(@RequestParam Integer page, @RequestBody UserQuery userQuery){  
    		Map<String,Object> map = new HashMap<String,Object>();
        Page<ApplicationUser> paginationUser = userService.findUserCriteria(page, PAGESIZE, userQuery);
        map.put("result", paginationUser);
        return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);  
    }
	@RequestMapping(value="/query", method=RequestMethod.GET)
	public ResponseEntity<Map<String,Object>> GetUserByName(@RequestParam String name) {
		Map<String,Object> map = new HashMap<String,Object>();
		ApplicationUser user = userRepository.findByName(name);
		map.put("result", user);
		return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
	}
	@RequestMapping(value="/userList", method=RequestMethod.GET)
	public ResponseEntity<Map<String,Object>> getUserListByRole(@RequestParam Integer role) {
		Map<String,Object> map = new HashMap<String,Object>();
		List<ApplicationUser> userList = userRepository.findUsersByRole(role);
		map.put("result", userList);
		return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
	}
	@RequestMapping(value="/sign-up", method=RequestMethod.POST)
	public ResponseEntity<Map<String,Object>>  CreateUserList( @RequestBody List<ApplicationUser> userList) {
		Map<String,Object> map = new HashMap<String,Object>();
//		ApplicationUser f_user = userRepository.findByName(u.getName());
//		List <ApplicationUser> userList = null;
//		if (f_user!=null) {
//			map.put("result", "user sign up failed,user exists");
//		return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
//		}
		for(ApplicationUser user: userList) {
			user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
			userRepository.save(user);
		}
		map.put("result", "userList sign up success");
		return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
	}
	@RequestMapping(value="/queryBySno", method=RequestMethod.GET)
	public ResponseEntity<Map<String,Object>> GetUserBySno(@RequestParam String sno) {
		Map<String,Object> map = new HashMap<String,Object>();
		ApplicationUser user = userRepository.findBySno(sno);
		map.put("result", user);
		return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
	}
}

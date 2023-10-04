package com.sample.controller;



import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.sample.model.Employee;
import com.sample.model.UserDto;

import com.sample.model.Repository.UserRep;
import com.sample.service.UserService;

import jakarta.servlet.http.HttpServletResponse;





@RestController
@RequestMapping("/employees")
public class UserControl {

	@Autowired
	private UserService ser;

	@Autowired
	private UserRep rep;
	

	
	@GetMapping("/list")
	public List<Map<String,String>> hp(){
		return rep.getwithrole();
	}
	
	@GetMapping("/list1")
	public Map<String,String> hp1(@RequestParam (value="name")String name){
		return rep.getwithrole1(name);
	}

	@PostMapping("/save")
	public ResponseEntity<Object> savingUserDetails(@RequestBody Employee em){
	rep.save(em);
		return new ResponseEntity<>("inserted",HttpStatus.OK);
	}
	
	
	
	@DeleteMapping("/delete")
	public ResponseEntity<Object> Deletebyid(@RequestParam(value="id")int id) {
		rep.deleteById(id);
		return new ResponseEntity<>("Deleted Successfully",HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	
//	@GetMapping("/list")
//	public ResponseEntity<Object> getUsers(
//			@RequestParam(name = "page", required = false) Integer page,
//			@RequestParam(name = "size", required = false ) Integer size,
//			@RequestParam(name = "name", required = false) String name,
//			@RequestParam(name = "searchTerm", required = false) String searchTerm) {
//		if (searchTerm != null) {
//			List<UserDto> users = ser.getUsersWithName(searchTerm);
//			return ResponseEntity.ok(users);
//		} 
//		else if (name != null) 
//		{
//			List<UserDto> user = ser.getUsersWithName(name);
//			if (user != null) 
//			{
//				return ResponseEntity.ok(user);
//			} else 
//			{
//				return ResponseEntity.notFound().build();
//			}
//
//	    } else {
//	    	if (page != null) {
//	    		List<UserDto> users = ser.getUsersWithPageable(page, size);
//	    		return ResponseEntity.ok(users);
//	    		} 
//	    	else {
//	    		List<UserDto> users = ser.getUsersWithRoles();
//	    		return ResponseEntity.ok(users);
//	    		}
//	    }
//}
//
//	
//	
//	 @GetMapping("/lists")
//	    public List<Employee> getUsersBySorting(
//	        @RequestParam("pageno") int pageno,
//	        @RequestParam("count") int count,
//	        @RequestParam("sort") String sort
//	    ) {
//	        return ser.findBysorting(pageno, count);
//	    }
//	
//	 @RequestMapping("/delete")
//		public String del(@RequestParam(value="id") int id,Employee user) {
//			ser.del(user);
//			return "success";
//		}
//	 
//
//	 @GetMapping("/find")
//	 public Optional<Employee> findid(@RequestParam(value="id") int id){
//		 return ser.findusingID(id);
//	 }
//	 
//	 
//	 @GetMapping("/download")
//     public void downloadUsers(HttpServletResponse response) throws IOException {
//		 response.setContentType("text/csv");
//		 response.setHeader("Content-Disposition", "attachment; filename=\"users.csv\"");
//		 List<Employee> users = rep.findAll();
//		 try (PrintWriter writer = response.getWriter()) {
//			 writer.write("ID,Username,Email\n");
//			 for (Employee user : users) {
//				 writer.write(user.getId() + "," + user.getName() + "," + user.getEmail() + "\n");
//			 }
// }
//
//     }
//	 
//	 
//	 
//	 
//	 @PostMapping("/upload")
//	    public void uploadCSV(@RequestParam("file") MultipartFile file) {
//	        try {
//	            BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()));
//	            
//	            String line;
//				while ((line = br.readLine()) != null) {
//	                String[] data = line.split(",");
//	                Employee entity = new Employee();
//	                entity.setName(data[0]);
//	                entity.setEmail(data[1]);
//	                entity.setRole_id(Integer.parseInt(data[2]));
//	                entity.setStatus(Integer.parseInt(data[3]));
//	                rep.save(entity);
//	            }
//	        } catch (Exception e) {
//	            e.printStackTrace();
//	        }
//	    }
//	 
//	 
	 
	 
}
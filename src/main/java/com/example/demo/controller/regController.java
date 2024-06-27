package com.example.demo.controller;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.Repositry.registRepo;
import com.example.demo.Repositry.fir.DistrictRepo;
import com.example.demo.pojo.Registration;
import com.example.demo.pojo.district.District;

@RestController
@RequestMapping("settribe")
@CrossOrigin("http://localhost:4200/")
public class regController {
	@Autowired
	registRepo rgrpo;
	@Autowired
	DistrictRepo districtRepo;
	@PostMapping("/login")
	public Registration lingin(@RequestBody Registration reg) {
		String email=reg.getEmail().toLowerCase();
		reg.setEmail(email);
		List<Registration> rj=rgrpo.findAll();
		for(Registration i:rj) {
			if(i.getEmail().equals(reg.getEmail()) && i.getPassword().equals(reg.getPassword())) {
				return i;
			}
		}
		return null;
	}
	 @PostMapping("/upload")
	    public ResponseEntity<String> uploadImage(@RequestParam("image") MultipartFile image) {
	        if (image.isEmpty()) {
	            return new ResponseEntity<>("File is empty", HttpStatus.BAD_REQUEST);
	        }

	        try {
	            // Process the image as needed
	            byte[] imageBytes = image.getBytes();
	            // For example, you could save the image to a directory or database

	            return new ResponseEntity<>("Image uploaded successfully", HttpStatus.OK);
	        } catch (IOException e) {
	            return new ResponseEntity<>("Failed to upload image", HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }
	@GetMapping("/get-all")
	public List<Registration> getData()
	{
		List<Registration> rg=rgrpo.findAll();
		return rg;	
	}
	@GetMapping("/get-dist")
	public List<District> displayDistrict()
	{
		List<District> districts=districtRepo.findAll();
		return districts;
	}
	@PostMapping("/post-data")
	public Registration setData(@RequestBody Registration reg) {
		String first=reg.getFirstName();
		String lastname=reg.getLastName();
		String middlename=reg.getMiddleName();
		String fullName=first+" "+middlename+" "+lastname;
		
		reg.setFullName(fullName);
		String email=reg.getEmail().toLowerCase();
		reg.setEmail(email);
		//rgrpo.save(reg);
		return reg;
	}
	@GetMapping("/captcha")
	public char[] capcha() {
		 String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
		    Random random=new Random();
		    int a=(int)(random.nextInt(6 - 3 + 1) + 3);
		    char []select=new char[a];
		    
		    for(int i=0;i<a;i++){
		       
		        select[i]=CHARACTERS.charAt((int)random.nextInt(CHARACTERS.length()-0+1)+1);
		        
		    }
		   
		    return  select;
	}
	
}

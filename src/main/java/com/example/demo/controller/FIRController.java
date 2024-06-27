package com.example.demo.controller;


import java.io.File;
import java.io.FileWriter;
import java.time.LocalDateTime;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Repositry.fir.FirRepo;
import com.example.demo.controller.fir.Complainant;
import com.example.demo.controller.fir.Fir;
import com.opencsv.CSVWriter;




@RestController
@RequestMapping("settribe/fir")
@CrossOrigin("http://localhost:4200/")
public class FIRController {
	
	@Autowired
	private FirRepo firRepo;
	@GetMapping("/get-by-id/{id}")
	public Fir getbyId(@PathVariable("id") int id)
	{
		Fir fir=firRepo.findById(id).get();
		
		return fir;
	}
	@GetMapping("/")
	public List<Fir> display() {
		List<Fir> fir=firRepo.findAll();
		return fir;
	}
	@PostMapping("/sub-data")
	public Fir saveFir(@RequestBody Fir fir) {
		 LocalDateTime time = LocalDateTime.now();
		if(fir.getCurrentDateTime()==null)
		 fir.setCurrentDateTime(time);
		firRepo.save(fir);
		return fir;
	}
	@GetMapping("/exportcsv")
	public void export()throws Exception{
		 List<Fir> users = firRepo.findAll();
		 String filePath="file.csv";
		 File myObj = new File(filePath);
		 if(myObj.exists()) {
			 myObj.delete();
		 }
	        try (CSVWriter writer = new CSVWriter(new FileWriter(filePath))) {
	            String[] header = { "ID", "Informer Name", "Date of Fir" ,"Place Occurrence","Adhar Card number","Mobile number","Informer Adress","Informer Nationality","Informer Occupation","Informer Information","Informer DOB","District","Enquiry Officer Name","Enquiry Officer Role","Suspect Name","Suspect Address"};
	            writer.writeNext(header);

	            for (Fir user : users) {
	                String[] data = {
	                    String.valueOf(user.getFIR_Number()),
	                    user.getComplainant().getConame(),
	                    user.getCurrentDateTime().toString(),
	                    user.getPlaceOccurrence(),
	                    user.getComplainant().getAadharNumber(),
	                    user.getComplainant().getMobileNumber(),
	                    user.getComplainant().getAddress(),
	                    user.getComplainant().getNationality(),
	                    user.getComplainant().getOccupation(),
	                    user.getComplainant().getInformation().toString(),
	                    user.getComplainant().getDob().toString(),
	                    user.getDistrict().getName(),
	                    user.getEnquiry().getName(),
	                    user.getEnquiry().getRole().toString(),
	                    user.getSuspect().getName(),
	                    user.getSuspect().getAddress(),
	                };
	                writer.writeNext(data);
	            }
	        }
	}
	@GetMapping("/find-by-id/{id}")
	public Fir displayByFir(@PathVariable("id")  int id) {
		Fir fir=firRepo.findById(id).get();
		return fir;
	}
	@GetMapping("/delete/{id}")
	public Fir deleteData(@PathVariable("id")  int id) {
		Fir fir=firRepo.findById(id).get();
		firRepo.deleteById(id);
		
		return fir;
	}
	
}

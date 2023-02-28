package com.petstore.swaggertest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@RestController
public class HelloController {

	HashMap<Integer,String> map=new HashMap<Integer,String>();

	List<Pet> pets = new ArrayList<Pet>();
	{
		pets.add(new Pet("Tiger", "11"));
		pets.add(new Pet("Sushi", "12"));
		pets.add(new Pet("Lucy",  "13"));
		pets.add(new Pet("Daisy", "14"));
	}
	

	@ApiOperation(value = "Get specific pet in the System ", response = Pet.class, tags = "getPetByName")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Suceess|OK"),
			@ApiResponse(code = 401, message = "not authorized!"), 
			@ApiResponse(code = 403, message = "forbidden!!!"),
			@ApiResponse(code = 404, message = "not found!!!") })
	@RequestMapping(method = RequestMethod.GET,  value = "/petstore/getPetByName/{name}") 
	public Pet getPetByName(@PathVariable(value = "name") String name) {
		Pet pet = (Pet)pets.stream().filter(x->x.getName().equalsIgnoreCase(name)).collect(Collectors.toList()).get(0);
		return pet;
	}
	
//	@RequestMapping(method = RequestMethod.GET, value = "/petstore/getPetByName") 
//	public String getPetByName(@RequestParam String petName ) { return "Hello Pet's : " + petName; }


//	@ApiOperation(value = "Get specific Student in the System ", response = Student.class, tags = "getStudent")
//	@RequestMapping(value = "/getStudent/{name}")
//	public Student getStudent(@PathVariable(value = "name") String name) {
//		return students.stream().filter(x -> x.getName().equalsIgnoreCase(name)).collect(Collectors.toList()).get(0);
//	}
	
//	@RequestMapping(method = RequestMethod.POST, value = "/petstore/addpet")
//	public void addPet(@RequestParam int petID, @RequestParam String petName) {
//		map.put(petID, petName);
//		
//	}
	
	@ApiOperation(value = "Add new pet in the System ", response = Pet.class, tags = "addpet")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Suceess|OK"),
			@ApiResponse(code = 401, message = "not authorized!"), 
			@ApiResponse(code = 403, message = "forbidden!!!"),
			@ApiResponse(code = 404, message = "not found!!!") })
	@RequestMapping(method = RequestMethod.POST, value = "/petstore/addpet/{petName},{petId}")
	public void addPet(@PathVariable(value = "petName") String petName, @PathVariable(value = "petId") String petId) {
		pets.add(new  Pet(petName,petId));		
	}
	
	
	@ApiOperation(value = "Get pet based on ID from the System ", response = Pet.class, tags = "getPetById")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Suceess|OK"),
			@ApiResponse(code = 401, message = "not authorized!"), 
			@ApiResponse(code = 403, message = "forbidden!!!"),
			@ApiResponse(code = 404, message = "not found!!!") })	
	@RequestMapping(method = RequestMethod.GET, value = "/petstore/getPetById/{petID}") 
	public Pet getPetById(@PathVariable(value = "petID") String petID) {		
		Pet pet = (Pet)pets.stream().filter(x->x.getId().equalsIgnoreCase(petID)).collect(Collectors.toList()).get(0);
		return pet;
	}
	
//	@RequestMapping(method = RequestMethod.GET, value = "/petstore/getPetById") 
//	public String getPetById(@RequestParam int petID ) { return "Hello Pet's : " + map.get(petID); }
	
	@ApiOperation(value = "Get all pet in the System ", response = Pet.class, tags = "getAllPet")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Suceess|OK"),
			@ApiResponse(code = 401, message = "not authorized!"), 
			@ApiResponse(code = 403, message = "forbidden!!!"),
			@ApiResponse(code = 404, message = "not found!!!") })
	@RequestMapping(method = RequestMethod.GET, value = "/petstore/getAllPet") 
	public List<Pet> getAllPet() {
		return pets;
	}


	//	@RequestMapping(method = RequestMethod.GET, value = "/petstore/{petName}" , headers="Accept=application/json") 
	//	public String getPet(@PathVariable("petName") String petName ) { 
	//		return "Hello Pet's : " + petName; 
	//	}


	@ApiOperation(value = "Remove pet based on ID from the System ", response = Pet.class, tags = "removePetById")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Suceess|OK"),
			@ApiResponse(code = 401, message = "not authorized!"), 
			@ApiResponse(code = 403, message = "forbidden!!!"),
			@ApiResponse(code = 404, message = "not found!!!") })	
	@RequestMapping(method = RequestMethod.DELETE, value = "/petstore/removePetById/{petID}") 
	public List<Pet> removePetById(@PathVariable(value = "petID") String petID) {	
		
		Pet pet = (Pet)pets.stream().filter(x->x.getId().equalsIgnoreCase(petID)).collect(Collectors.toList()).get(0);
		//return pet;
		
		pets.remove(pet);
		for(Pet p:pets) {
			System.out.println(p.getId());
		}
		return pets;
		
	}
	

}

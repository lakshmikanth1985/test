package com.vmware.calc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vmware.calc.bean.InputParams;
import com.vmware.calc.bean.OutputParams;

@RestController
public class CalcController {

	
	

	  @PostMapping("/api/add")
	  OutputParams add(@RequestBody InputParams newInputParams) {
		  OutputParams outputParams = new OutputParams();
		  outputParams.setResult(newInputParams.getX() + newInputParams.getY());
	    return outputParams;
	  }

	  @PostMapping("/api/diff")
	  OutputParams diff(@RequestBody InputParams newInputParams) {
		  OutputParams outputParams = new OutputParams();
		  outputParams.setResult(newInputParams.getX() - newInputParams.getY());
	    return outputParams;
	  }
	  
	  // Single item
//
//	  @GetMapping("/test/{id}")
//	  InputParams one(@PathVariable String id) {
//		  InputParams newInputParams = new InputParams();
//		  newInputParams.setMessage("Hello dear, "+id +"!!!");
//	    return newInputParams;
//	  }
//	  
//	  
//
//	  @PostMapping("/")
//	  InputParams two() {
//		  InputParams newInputParams = new InputParams();
//		  newInputParams.setMessage("Hello dear, ABC !!!");
//	    return newInputParams;
//	  }
}

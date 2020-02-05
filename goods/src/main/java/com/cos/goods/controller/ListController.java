package com.cos.goods.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;
import javax.xml.ws.BindingType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.goods.dto.ReqProInsertDto;
import com.cos.goods.dto.ReqProUpdateDto;
import com.cos.goods.dto.ResDto;
import com.cos.goods.model.Pro;
import com.cos.goods.repository.ProRepository;

@Controller
public class ListController {

	@Autowired
	private ProRepository proRepository;

	@GetMapping("/goods")
	public String proInsert() {
		return "goods/save";
	}
	@PostMapping("/goods")
	public @ResponseBody String proInsert(@RequestBody ReqProInsertDto reqProInsertDto) {
		
		int result = proRepository.save(reqProInsertDto);
		
		if(result == 1) {
			return "ok"; // 뷰리졸브가 컨트롤러 타서 인식함 그래서 인트 앞에 리스폰스바디 붙여야
		}else {
			return "fail";
		}
		
		
	}

//	// username, password, email
//	@PostMapping("/goods/list")
//	public @ResponseBody ResponseEntity<?> proApiInsert(@Valid @RequestBody 
//											ReqProInsertDto reqProInsertDto, BindingResult bindResult) {
//
//		if(bindResult.hasErrors()) {
//			Map<String, String> errorMap = new HashMap<>();
//			
//			for(FieldError error : bindResult.getFieldErrors()) {
//				errorMap.put(error.getField(), error.getDefaultMessage());
//			}
//			return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
//		}
//		
//		int result = proRepository.save(reqProInsertDto);
//		System.out.println(result);
//
//		if (result == 1) {
//			
//			return new ResponseEntity<ResDto>(new ResDto(200,"ok"), HttpStatus.CREATED); // 뷰리졸브가 컨트롤러 타서 인식함 그래서 인트 앞에 리스폰스바디 붙여야
//		} else {
//			return new ResponseEntity<ResDto>(new ResDto(500,"fail"), HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//		 
//	}

	@GetMapping("/")
	public String pros(Model model) {
		List<Pro> pros = proRepository.findAll();

		model.addAttribute("pros", pros);

		return "/list";
	}
	
	@GetMapping("/all")
	public @ResponseBody List<Pro> all_list() {
		
		List<Pro> pros = proRepository.findAll();
		
		return pros;
	}
	
	@GetMapping({"/type/{type}"})
	public ResponseEntity<?> prodtype(@PathVariable String type) {
		
		List<Pro> protypes = proRepository.findByType(type);		

		return new ResponseEntity<List<Pro>>(protypes, HttpStatus.OK);
	}
	
	@GetMapping({"/sort/{sort}"})
	public ResponseEntity<?> prodsort(@PathVariable String sort) {
		
		List<Pro> prosorts = proRepository.findBySort(sort);		

		return new ResponseEntity<List<Pro>>(prosorts, HttpStatus.OK);
	}
	
	@GetMapping("/order/{type}")
	public @ResponseBody List<Pro> order_type_list(@PathVariable String type) {
		
		List<Pro> pros = proRepository.findByOrderType(type);
		
		return pros;
	}
	
	@GetMapping("/price/{type}")
	public @ResponseBody List<Pro> price_type_list(@PathVariable String type) {
		
		List<Pro> pros = proRepository.findByPriceType(type);
		
		return pros;
	}

	@GetMapping({"/price"})
	public @ResponseBody List<Pro> all_pricelist() {
		
		List<Pro> pros = proRepository.findByPrice();
		
		return pros;
	}
	
	@GetMapping({"/order"})
	public @ResponseBody List<Pro> all_ordercount() {
		
		List<Pro> pros = proRepository.findByOrdercount();
		
		return pros;
	}

	@GetMapping("/goods/{id}")
	public String update(@PathVariable int id, Model model) {
		Pro pro = proRepository.findById(id);

		model.addAttribute("pro", pro);

		return "goods/update";
	}

	@PutMapping("/goods/api/update")
	public @ResponseBody ResponseEntity<?> updateProc(@RequestBody ReqProUpdateDto reqProUpdateDto) {

		int result = proRepository.update(reqProUpdateDto);
		System.out.println(result);
		if (result == 1) {
			return new ResponseEntity<String>("ok", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("fail", HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/goods/api/delete/{id}")
	public @ResponseBody ResponseEntity<?> deleteProc(@PathVariable int id) {
		int result = proRepository.delete(id);
		
		if (result == 1) {
			return new ResponseEntity<String>("ok", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("fail", HttpStatus.BAD_REQUEST);
	
		}
 }
}
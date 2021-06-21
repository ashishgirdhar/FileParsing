package com.abn.controller;

import com.abn.service.FileParsingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/file")
public class FileController {
	 @Autowired
	 private FileParsingService fileParserService;
	 
	
	
	@GetMapping(value="/load/{fileName}")
	public String load(@PathVariable final String fileName) {
		return fileParserService.load(fileName);
		
	}
	
	
	
}

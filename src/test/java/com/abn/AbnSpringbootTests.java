package com.Abn;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import com.abn.controller.FileController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import com.abn.controller.FileController;
import com.abn.service.FileParsingService;

@SpringBootTest
@RunWith(SpringRunner.class)
public class AbnSpringbootTests {
	

	private MockMvc mvc;	
	
	MockMvc mockMvc;
    
    @Autowired
	FileController fileController;
    @MockBean
    FileParsingService fileService;
	
	
	
	 @Before
	    public void setup() throws Exception {
	        this.mockMvc = standaloneSetup(this.fileController).build();// Standalone context
	        // mockMvc = MockMvcBuilders.webAppContextSetup(wac)
	        // .build();
	        
	    }

	 @Test
	    public void testFileUpload() throws Exception {
	        // Mocking service
	        when(fileService.load(any(String.class))).thenReturn("All data loaded");
	        mockMvc.perform(get("/file/load/input.txt").contentType(MediaType.APPLICATION_JSON))
	            .andExpect(status().isOk());
	           
	            
	    }
}


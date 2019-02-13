package com.Account.Account;

import org.junit.Before;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;

import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.Account.Account.AccountModel;
import com.Account.Account.AccountRepository;


import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;


import static org.junit.Assert.*;


@RunWith(SpringRunner.class)

@WebMvcTest

public class AccountApplicationTests {
 
	@Autowired
	private MockMvc mockmvc;
	
	@MockBean
	private AccountRepository acctrepo;
	

	
	 @Before
	    public void init() throws Exception {
	        MockitoAnnotations.initMocks(this);
	      
	  
	    }
	
	
	@Test
	public void getAccountidTest() throws Exception 
	{
		  AccountModel  mockmodel=new AccountModel();
	        mockmodel.setId("5c3d1a2b0512359c4478beec");
	        mockmodel.setName("priyaA");
	        mockmodel.setEmail("pa@gmail.com");
        
       
		  Mockito.when(acctrepo.findOne(Mockito.anyString())).thenReturn(mockmodel);
		  RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
					"/Accounts/id").accept(
					MediaType.APPLICATION_JSON);
		  MvcResult result = mockmvc.perform(requestBuilder).andReturn();
			System.out.println("result is "+result.getResponse());
			//String expected = "{id:5c3d1a2b0512359c4478beec,name:priyaA,description:pa@gmail.com}";
			
			MockHttpServletResponse output=result.getResponse();
			
			String output1=result.getResponse().getContentAsString();
		//	assertThat(expected,output1);
			System.out.print("Output is "+output1);
			assertEquals(HttpStatus.OK.value(),output.getStatus());
		
	}
	
/*	@Test
	public void saveAccountsTest() throws Exception
	{
		  AccountModel  mockmodel=new AccountModel();
	   //     mockmodel.setId("5c3d1a2b0512359c4478beec ");
	        mockmodel.setName("subbu");
	        mockmodel.setEmail("subbu@gmail.com");
      
		//Mockito.when(acctrepo.save(mockmodel))
	       Mockito.when(acctrepo.save(mockmodel)).thenReturn();
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post(
				"/Accounts/add").accept(
				MediaType.APPLICATION_JSON);
	  MvcResult result = mockmvc.perform(requestBuilder).andReturn();
		System.out.println("result is "+result.getResponse());
		//String expected = "{id:5c3d1a2b0512359c4478beec,name:priyaA,description:pa@gmail.com}";
		
		MockHttpServletResponse output=result.getResponse();
		
		String output1=result.getResponse().getContentAsString();
	//	assertThat(expected,output1);
		//System.out.print("Output is "+output1);
		assertEquals(,);
		
	}*/

} 


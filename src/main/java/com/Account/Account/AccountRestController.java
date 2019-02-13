package com.Account.Account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController

@RequestMapping("/Accounts")
public class AccountRestController
{
	 @Autowired
     private AccountRepository acctInfo;
	 
	@RequestMapping(value = "/", method = RequestMethod.GET)
    public Iterable<AccountModel> getAccount()
    { 
  
     return acctInfo.findAll();
    	
    }
    
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public AccountModel getAllid(@PathVariable("id") String id)
    {
	  
       return  acctInfo.findOne(id);
	  
    }
    

    @RequestMapping(value="/add",method = RequestMethod.POST)
    public String addDetails(@RequestBody AccountModel details) {
     

     acctInfo.save(details);
       return details.getId();
    	
    }
    

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteAccount(@PathVariable("id") String id) {
 
	    acctInfo.delete(id);
	   return "Deleted";
    }
   
/*    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
   public void putDetails(@PathVariable("id") String id , @RequestBody AccountModel details) {
       details.setId(id);
      acctInfo.save(details);
 
      	
   }
   */
    @RequestMapping(value = "/{id}", method = RequestMethod.PATCH)
   public String patchDetails(@PathVariable String id ,@RequestBody AccountModel details){
	   
	  
	   AccountModel acctdetails = acctInfo.findOne(id);
	   
	   if(details.getName()!=null)
	   {
	      acctdetails.setName(details.getName());       
	   }
	   	 
	    if(details.getEmail()!=null)
	    	
	    {
	    	 acctdetails.setEmail(details.getEmail());
	    }
	    
	    
	
	   acctInfo.save(acctdetails);
	   return "resource updated!";
	 
	   
   }
   
   @RequestMapping(value="/{id}",method=RequestMethod.HEAD)
   public String getdetails(@PathVariable String id)
   {
	 
	   return "Successful";
	
   }
}

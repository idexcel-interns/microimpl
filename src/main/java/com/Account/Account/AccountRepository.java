package com.Account.Account;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface AccountRepository extends MongoRepository<AccountModel,String> {

	AccountModel findOne(String id);

	
	
	


}

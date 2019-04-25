package ua.procamp.web.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import ua.procamp.dao.AccountDao;
import ua.procamp.dao.impl.InMemoryAccountDao;
import ua.procamp.model.Account;

/**
 * <p>
 * todo: 1. Configure rest controller that handles requests with url "/accounts"
 * todo: 2. Inject {@link AccountDao} implementation
 * todo: 3. Implement method that handles GET request and returns a list of accounts
 * todo: 4. Implement method that handles GET request with id as path variable and returns account by id
 * todo: 5. Implement method that handles POST request, receives account as request body, saves account and returns it
 * todo:    Configure HTTP response status code 201 - CREATED
 * todo: 6. Implement method that handles PUT request with id as path variable and receives account as request body.
 * todo:    It check if account id and path variable are the same and throws {@link IllegalStateException} otherwise.
 * todo:    Then it saves received account. Configure HTTP response status code 204 - NO CONTENT
 * todo: 7. Implement method that handles DELETE request with id as path variable removes an account by id
 * todo:    Configure HTTP response status code 204 - NO CONTENT
 */
@RestController
@RequestMapping("/accounts")
public class AccountRestController {

	private InMemoryAccountDao inMemoryAccountDao;

	public AccountRestController(InMemoryAccountDao inMemoryAccountDao) {
		this.inMemoryAccountDao = inMemoryAccountDao;
	}

	@GetMapping
	public List<Account> getAll(){
		return inMemoryAccountDao.findAll();
	}

	@GetMapping("/{id}")
	public Account getById(@PathVariable Long id){
		return inMemoryAccountDao.findById(id);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Account saveAcc(Account account){
		return inMemoryAccountDao.save(account);
	}


	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public Account getByIdPut(@PathVariable Long id,Account account){
		if(account.getId().equals(id)){
			return inMemoryAccountDao.save(account);
		}else {
			throw new IllegalStateException();
		}
	}
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void removeAcc(@PathVariable Long id){
		Optional.ofNullable(inMemoryAccountDao.findById(id))
			.ifPresent(account -> inMemoryAccountDao.remove(account));
	}

}

package org.study.spring.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.study.spring.rest.exceptions.BadDataException;
import org.study.spring.rest.exceptions.ResourceNotFoundException;
import org.study.spring.rest.pojo.Product;
import org.study.spring.rest.service.ProductService;

/**
 * This controller class uses the MVC HTTP annotations to provide rest endpoints.
 * The crude way is to use the "ModelAndView" approach to fit the rest specifications.
 * The correct way is to used the @RestController instead of just using @Controller
 *
 */
@Controller
@RequestMapping("/mvcRest")
class MvcRestController {

	@Autowired
	private ProductService service;
	
	private static class RestPreconditions {
		public static <T> T checkFound(T resource) {
			if(resource == null)
				throw new ResourceNotFoundException("Resource not found");
			
			return resource;
		}
		
		public static <T> void checkNotNull(T resource) {
			if(resource == null)
				throw new BadDataException("Input resource is null");
		}
	}
	
	/**
	 * FINDALL
	 * Simple response conversion from Product list to a Json output
	 */
	@ResponseBody
	@RequestMapping(method = RequestMethod.GET)
	public List<Product> getProducts() {
		return service.findAll();
	}
	
	/**
	 * FIND-ONE
	 * Usage of @PathVariable to annotate a method parameter, and to link it with the 
	 * incoming request parameter
	 * 
	 */
	@ResponseBody
	@RequestMapping(method = RequestMethod.GET, value="/{id}")
	public Product findOne(@PathVariable("id") Long id) {
		Product prod;
		prod = RestPreconditions.checkFound(service.findOne(id));
		
		return prod;
	}
	
	/**
	 * CREATE - Using POST
	 * Using @ResponseStatus to notify creation status codes
	 */
	@ResponseBody
	@ResponseStatus(HttpStatus.CREATED)
	@RequestMapping(method = RequestMethod.POST)
	public Long create(@RequestBody Product resource) {
		try {
			RestPreconditions.checkNotNull(resource);
		} catch (Exception e) {
			e.printStackTrace();
			return -1l;
		}
		
		return service.create(resource);
	}
	
	/**
	 * UPDATE - Using PUT
	 * 
	 */
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(method = RequestMethod.PUT, value = "/{id}")
	public void update(@PathVariable("id") Long id, @RequestBody Product product) {
		try {
			RestPreconditions.checkNotNull(product);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		RestPreconditions.checkFound(service.getById(product.getId()));
		
		service.update(product);
	}
	
	/**
	 * DELETE - Using DELETE
	 * 
	 */
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public void delete(@PathVariable("id") Long id) {
		service.deleteById(id);
	}
}

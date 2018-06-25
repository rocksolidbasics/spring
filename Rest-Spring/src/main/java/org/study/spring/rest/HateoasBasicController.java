package org.study.spring.rest;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.study.spring.rest.pojo.Product;
import org.study.spring.rest.pojo.hateoas.OrderResource;
import org.study.spring.rest.pojo.hateoas.ProductResource;
import org.study.spring.rest.service.OrderService;
import org.study.spring.rest.service.ProductService;

@RestController
@RequestMapping("/basicH")
public class HateoasBasicController {

	@Autowired
	private ProductService service;
	
	@Autowired
	private OrderService oService;
	
	/**
	 * > Method returning a simple list of Resource types (ProductResource)
	 * > Publishes a self link for each product as follows:
	 * 	{"name":"P1","prodId":1,"price":25.5,"sku":"SKU-101",
	 *		"links":[
	 *			{"rel":"self",
	 *			"href":"http://localhost:8080/spring-rest/mvcRest/1",
	 *			"hreflang":null,"media":null,"title":null,"type":null,"deprecation":null}
	 *		]
	 *	}
	 */
	@ResponseBody
	@RequestMapping(method = RequestMethod.GET)
	public List<ProductResource> getAll() {
		List<ProductResource> list = new LinkedList<ProductResource>();
		for(Product p : service.findAll()) {
			ProductResource pr = new ProductResource(p);
			//Method to add self links should not be part of the resource object itself, it should
			//be out of it, as the controller reference may change without anything changing in the
			//resource class
			pr.addSelfLink();
			list.add(pr);
		}
		
		return list;
	}
	
	@ResponseBody
	@RequestMapping(method = RequestMethod.GET, value="/prod/{prodId}")
	public ProductResource getProduct(@PathVariable("prodId") Long prodId) {
		Product prod = service.findOne(prodId);
		ProductResource prodRes = new ProductResource(prod);
		prodRes.addSelfLink();
		
		return prodRes;
	}
	
	@ResponseBody
	@RequestMapping(method = RequestMethod.GET, value="/order/{orderId}")
	public OrderResource getOrder(@PathVariable("orderId") Long orderId) {
		OrderResource or = oService.getOrder(orderId);
		Link ol = linkTo(this.getClass()).slash(or.getOrderId()).withSelfRel();
		or.add(ol);
		return or;
	}
	
	/**
	 * Using HATEOS to insert links using the methodOn() calls, which will fetch the @RequestMapping for
	 * the given controller method and insert the correct contextual link
	 * > This method serializes child line jsons alongwith its self links
	 */
	@ResponseBody
	@RequestMapping(method = RequestMethod.GET, value = "/{prodId}/orders", produces = {"application/hal+json"})
	public Resources<OrderResource> getOrdersForProduct(@PathVariable("prodId") Long prodId) {
		List<OrderResource> orders = oService.getAllOrders(prodId);
		for(final OrderResource o : orders) {
			Link selfLink = linkTo(methodOn(this.getClass()).getOrder(o.getOrderId())).withSelfRel();
			for(ProductResource p : o.getLines()) {
				/*
				 * The commented code below causes two links to be added in the output JSON, because the target
				 * method getProduct() on this controller is called from with the "methodOn" call, as well as 
				 * the method itself add a "Link" to the ProductResource
				 */
				//p.add(linkTo(methodOn(this.getClass()).getProduct(p.getProdId())).withSelfRel());
				p.addSelfLink();
			}
			
			o.add(selfLink);
		}
		
		Link link = linkTo(methodOn(this.getClass()).getOrdersForProduct(prodId)).withSelfRel();
		Resources<OrderResource> result = new Resources<OrderResource>(orders, link);
		
		return result;
	}
	
	/**
	 * Using HATEOAS to insert links using the methodOn() as well as using the "withRel()" method to 
	 * insert non-self links which are used to refer to child entities of the parent json entity
	 * TODO: How to exclude the product serialization and only include the "rel" links
	 */
	@ResponseBody
	@RequestMapping(method = RequestMethod.GET, value = "/{prodId}/orders/rel", produces = {"application/hal+json"})
	public Resources<OrderResource> getOrderForProductWithRelLinks(@PathVariable("prodId") Long prodId) {
		List<OrderResource> orders = oService.getAllOrders(prodId);
		for(final OrderResource o : orders) {
			Link selfLink = linkTo(methodOn(this.getClass()).getOrder(o.getOrderId())).withSelfRel();
			o.add(selfLink);
			
			for(ProductResource p : o.getLines()) {
				Link prodLink = linkTo(methodOn(this.getClass()).getProduct(prodId)).withRel("lines");
				o.add(prodLink);
			}
		}
		
		Link link = linkTo(methodOn(this.getClass()).getOrdersForProduct(prodId)).withSelfRel();
		Resources<OrderResource> result = new Resources<OrderResource>(orders, link);
		
		return result;
	}
}

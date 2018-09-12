package hello;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import Model.ServiceProduct;

@RestController
public class ProductController {
	
	//ServiceProduct serviceProduct;

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<Product> create(@RequestBody Product product) {

		System.out.println("test appel create produit" + product);

		return new ResponseEntity<Product>(product, HttpStatus.OK);

	}

	@RequestMapping(value = "/creates", method = RequestMethod.POST)
	public ResponseEntity<List<Product>> creates(@RequestBody List<Product> products) {

		for (Product product : products) {

			System.out.println("test appel create plusieurs produit" + product);
		}

		return new ResponseEntity<List<Product>>(products, HttpStatus.OK);

	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<List<Product>> get() {

		
		return new ResponseEntity<List<Product>>( serviceProduct.getListeProducts(), HttpStatus.OK);

	}
	
	@RequestMapping(value = "/testRest", method = RequestMethod.GET)
	public String testRest() {
		return "ok";

	}
}
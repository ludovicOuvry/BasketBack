package hello;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.JsonbHttpMessageConverter;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
	@Autowired
	ServiceProduct serviceProduct;
	
	@Autowired
	private ProviderRepository providerRepo;
	
	@CrossOrigin()
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<Product> create(@RequestBody Product product) {

		System.out.println("test appel create produit" + product);
		serviceProduct.add(product);
		return new ResponseEntity<Product>(product, HttpStatus.OK);

	}

	@RequestMapping(value = "/creates", method = RequestMethod.POST)
	public ResponseEntity<List<Product>> creates(@RequestBody List<Product> products) {
		
		
		for (Product product : products) {
			serviceProduct.add(product);
			System.out.println("test appel create plusieurs produit" + product);
			
		}

		return new ResponseEntity<List<Product>>(products, HttpStatus.OK);

	}
	@CrossOrigin()
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<Product> get() {

		System.out.println("get");
		return serviceProduct.getListeProducts();

	}
	
	
	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public ResponseEntity<List<Product>> delete(int id) {

		serviceProduct.del(id);
		return new ResponseEntity<List<Product>>( serviceProduct.getListeProducts(), HttpStatus.OK);

	}
	
	@RequestMapping(value = "/testRest", method = RequestMethod.GET)
	public String testRest() {
		return "ok";

	}
	
	@RequestMapping(value = "/fini", method = RequestMethod.GET)
	public ResponseEntity<List<Product>> fin() {
		
		for (Product p : serviceProduct.getListeProducts() ) {
			if(providerRepo.existsById(p.getCompagny())) {
				//update
				int amout = providerRepo.findById(p.getCompagny()).get().getAmount();
				
				providerRepo.save(new Provider(p.getCompagny(), amout+p.getPrice()));
				
			}else {
				providerRepo.save(new Provider(p.getCompagny(), p.getPrice()));
			}
		}
		return new ResponseEntity<List<Product>>( serviceProduct.getListeProducts(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/products", method = RequestMethod.POST)
	public ResponseEntity<List<Product>> productsPost(@RequestBody List<Product> products) {
		
		for (Product p : products ) {
			if(providerRepo.existsById(p.getCompagny())) {
				//update
				int amout = providerRepo.findById(p.getCompagny()).get().getAmount();
				
				providerRepo.save(new Provider(p.getCompagny(), amout+p.getPrice()));
				
			}else {
				providerRepo.save(new Provider(p.getCompagny(), p.getPrice()));
			}
		}
		return new ResponseEntity<List<Product>>( serviceProduct.getListeProducts(), HttpStatus.OK);
	}
	
	
}
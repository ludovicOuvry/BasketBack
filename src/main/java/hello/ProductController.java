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
	private ProviderRepository providerRepo;
	
	@CrossOrigin()
	@RequestMapping(value = "/valide", method = RequestMethod.POST)
	public ResponseEntity valide(@RequestBody Product[] products) {
		
		System.out.println("post");
		System.out.println(products.length);
		for (Product p : products ) {
			if(providerRepo.existsById(p.getCompagny())) {
				//update
				int amout = providerRepo.findById(p.getCompagny()).get().getAmount();
				providerRepo.save(new Provider(p.getCompagny(), amout+(p.getPrice()*p.getQuantity())));
				
			}else {
				providerRepo.save(new Provider(p.getCompagny(), (p.getPrice())*p.getQuantity()));
			}
		}
		return new ResponseEntity(HttpStatus.OK);
	}
	
	
	@CrossOrigin()
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity valide(@RequestBody Product products) {
		
			Product p = products;
			if(providerRepo.existsById(p.getCompagny())) {
				//update
				System.out.println("produit existant");
				int amout = providerRepo.findById(p.getCompagny()).get().getAmount();
				providerRepo.save(new Provider(p.getCompagny(), amout+(p.getPrice()*p.getQuantity())));
				
			}else {
				providerRepo.save(new Provider(p.getCompagny(), (p.getPrice())*p.getQuantity()));
			}
		
		return new ResponseEntity(HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public Iterable<Provider> get() {
		System.out.println("get ");
		return  providerRepo.findAll();
	}
	
	
}
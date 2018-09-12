package hello;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
@Service
public class ServiceProduct {
	
	List<Product> listeProducts; 
	
	
	public ServiceProduct() {
		super();
		listeProducts = new ArrayList<Product>();
	}
	public void add(Product p) {
		listeProducts.add(p);
	}
	public void del(int id) {
		Product p= null;
		for (Product product : listeProducts) {
			if(product.getId()==id) {
				p=product;
			}
		}
		listeProducts.remove(p);
	}
	
	public List<Product> getListeProducts() {
		return listeProducts;
	}
	public void setListeProducts(List<Product> listeProducts) {
		this.listeProducts = listeProducts;
	}

}

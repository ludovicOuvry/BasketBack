package hello;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public class ProductDAO {
	@Transactional
	public interface UserDao extends CrudRepository<Product, Long> {

	  /**
	   * This method will find an User instance in the database by its email.
	   * Note that this method is not implemented and its working code will be
	   * automagically generated from its signature by Spring Data JPA.
	   */
	  public Product findById(int id);

	}
}

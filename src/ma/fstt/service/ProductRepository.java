package ma.fstt.service;

import java.util.List;
import ma.fstt.entities.Product;


public interface ProductRepository {
	
	public void save(Product prod);
	public void update(Product prod);
	public void delete(Product prod);
	
	public List<Product> Products();
	
	public Product getById(int id);

}

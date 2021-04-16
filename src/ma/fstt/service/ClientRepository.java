package ma.fstt.service;

import java.util.List;
import ma.fstt.entities.Client;

public interface ClientRepository {
	
	 
	public void save(Client client);
	public void update(Client client);
	public void delete(Client client);
	
	public List<Client> Clients();
	
	public Client getById(int id);
	

}

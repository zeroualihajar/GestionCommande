package ma.fstt.service;

import java.util.List;

import ma.fstt.entities.Client;
import ma.fstt.entities.Command;

public interface CommandRepository {
	
	public void save(Command cmd, Client client);
	public void update(Command cmd, Client client);
	public void delete(Command cmd);
	
	public List<Command> Commands(int id);
	
	
	public Command getById(int id);

}

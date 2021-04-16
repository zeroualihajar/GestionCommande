package ma.fstt.service;

import java.util.List;

import ma.fstt.entities.Command;
import ma.fstt.entities.CommandLine;
import ma.fstt.entities.Product;

public interface CommandLineRepository {
	
	public void save(CommandLine commandLine, Command cmd, Product prod);
	public void update(CommandLine commandLine);
	public void delete(CommandLine commandLine);
	
	public List<CommandLine> CommandLines(int id);
	
	public CommandLine getById(int id);

}

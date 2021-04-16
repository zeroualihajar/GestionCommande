package ma.fstt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ma.fstt.entities.Command;
import ma.fstt.entities.CommandLine;
import ma.fstt.entities.Product;
import ma.fstt.service.CommandLineRepository;
import ma.fstt.tools.ConnectionManager;

public class CommandLineDao implements CommandLineRepository{
	
	private Connection cnx;
	private Statement statement;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;
	
	//----- se conencter a la base de donnee
	public CommandLineDao() throws SQLException
	{
		cnx = ConnectionManager.getConnection();
	}
	

	//----- Requete d'insertion dans la BDD
	@Override
	public void save(CommandLine commandLine, Command cmd, Product prod) {
		
		
		String req = "insert into command_line(qty, fk_id_cmd, fk_id_prod) values (?,?,?)";
		try {
			this.preparedStatement = this.cnx.prepareStatement(req);
			this.preparedStatement.setInt(1, commandLine.getQty());
			this.preparedStatement.setInt(2, cmd.getIdCmd());
			this.preparedStatement.setInt(3, prod.getIdProd());
			
			this.preparedStatement.execute();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	//----- Requete de la mise a jour dans la BDD
	@Override
	public void update(CommandLine commandLine) {
		
		String req = "update command_line set qty = ?, fk_id_prod = ? where id_cmd_line = ?";
		try {
			this.preparedStatement = this.cnx.prepareStatement(req);
			this.preparedStatement.setInt(1, commandLine.getQty());
			this.preparedStatement.setInt(2, commandLine.getIdProd());
			this.preparedStatement.setInt(3, commandLine.getIdCmdLine());
			
			this.preparedStatement.execute();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	//----- Requete de suppression dans la BDD
	@Override
	public void delete(CommandLine commandLine) {

		String req = "delete from command_line where id_cmd_line = ?";
		try {
			this.preparedStatement = this.cnx.prepareStatement(req);
			this.preparedStatement.setInt(1, commandLine.getIdCmdLine());
			
			
			this.preparedStatement.execute();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	//----- Retourner la liste de tous les commandLines de meme command existant dans la BDD
	@Override
	public List<CommandLine> CommandLines(int id) {
		
		List<CommandLine> list = new ArrayList<CommandLine>();
		try {
			this.statement = this.cnx.createStatement();
			this.resultSet =this.statement.executeQuery("select * from command_line where fk_id_cmd = "+id);
			
			
			while(this.resultSet.next())
			{
				list.add(new CommandLine(this.resultSet.getInt(1),
						this.resultSet.getInt(2), this.resultSet.getInt(3), this.resultSet.getInt(4)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	//----- Retourner le commandLine tel que : id_cmd_line = id
	@Override
	public CommandLine getById(int id) {

		CommandLine cmd = null;
		String req = "select * from command_line where id_cmd_line = ?";
		
		try {
			this.preparedStatement = this.cnx.prepareStatement(req);
			this.preparedStatement.setInt(1, id);
			this.resultSet = this.preparedStatement.executeQuery();			
			
			while(this.resultSet.next())
			{
				cmd = new CommandLine(this.resultSet.getInt(1), 
						this.resultSet.getInt(2), this.resultSet.getInt(3), this.resultSet.getInt(4));
				break;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cmd;
	}


}

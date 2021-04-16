package ma.fstt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ma.fstt.entities.Client;
import ma.fstt.entities.Command;
import ma.fstt.service.CommandRepository;
import ma.fstt.tools.ConnectionManager;

public class CommandDao implements CommandRepository{

	
	private Connection cnx;
	private Statement statement;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;
	
	
	//----- Se connecter
	public CommandDao() throws SQLException
	{
		cnx = ConnectionManager.getConnection();
	}
	
	//----- Requete d'insertion dans la BDD
	@Override
	public void save(Command cmd, Client client) {
		
		
		String req = "insert into command(date_command, fk_id_client) values (?,?)";
		try {
			this.preparedStatement = this.cnx.prepareStatement(req);
			this.preparedStatement.setDate(1, cmd.getDateCmd());
			this.preparedStatement.setInt(2, client.getIdClient());
			
			this.preparedStatement.execute();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	//----- Requete de la mise a jour dans la BDD
	@Override
	public void update(Command cmd, Client client) {
		
		String req = "update command set date_command = ?, fk_id_client = ? where id_cmd = ?";
		try {
			this.preparedStatement = this.cnx.prepareStatement(req);
			this.preparedStatement.setDate(1, cmd.getDateCmd());
			this.preparedStatement.setInt(2, client.getIdClient());
			this.preparedStatement.setInt(3, cmd.getIdCmd());
			
			this.preparedStatement.execute();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	//----- Requete de suppression dans la BDD
	@Override
	public void delete(Command cmd) {
		String req = "delete from command where id_cmd = ?";
		try {
			this.preparedStatement = this.cnx.prepareStatement(req);
			this.preparedStatement.setInt(1, cmd.getIdCmd());
			
			
			this.preparedStatement.execute();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	//----- Retourner la liste de tous les commandes de meme client existant dans la BDD
	@Override
	public List<Command> Commands(int id) {

		List<Command> list = new ArrayList<Command>();
		try {
			this.statement = this.cnx.createStatement();
			this.resultSet = this.statement.executeQuery("select * from command where fk_id_client = "+id);
			
			while(this.resultSet.next())
			{
				list.add(new Command(this.resultSet.getInt(1), this.resultSet.getDate(2), this.resultSet.getInt(3)));
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return list;
	}

	//----- Retourner le command tel que : id_cmd = id
	@Override
	public Command getById(int id) {

		Command cmd = null;
		String req = "select * from command where id_cmd = ?";
		
		try {
			this.preparedStatement = this.cnx.prepareStatement(req);
			this.preparedStatement.setInt(1, id);
			this.resultSet = this.preparedStatement.executeQuery();			
			
			while(this.resultSet.next())
			{
				cmd = new Command(this.resultSet.getInt(1), this.resultSet.getDate(2), this.resultSet.getInt(3));
				break;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cmd;
	}
}

package ma.fstt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import ma.fstt.entities.Client;
import ma.fstt.service.ClientRepository;
import ma.fstt.tools.ConnectionManager;


public class ClientDao implements ClientRepository{
	
	private Connection cnx;
	private Statement statement;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;
	

	//----- se conencter a la base de donnee
	public ClientDao() throws SQLException
	{
		cnx = ConnectionManager.getConnection();
	}

	//----- Requete d'insertion dans la BDD
	@Override
	public void save(Client client) 
	{
		
		String req = "insert into client(name_client, email_client, adress_client) values (?,?,?)";
		try {
			this.preparedStatement = this.cnx.prepareStatement(req);
			this.preparedStatement.setString(1, client.getName());
			this.preparedStatement.setString(2, client.getEmail());
			this.preparedStatement.setString(3, client.getAdress());
			
			this.preparedStatement.execute();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	//----- Requete de la mise a jour dans la BDD
	@Override
	public void update(Client client) {

		String req = "update client set name_client = ? , email_client = ?, adress_client = ? where id_client = ?";
		try {
			this.preparedStatement = this.cnx.prepareStatement(req);
			this.preparedStatement.setString(1, client.getName());
			this.preparedStatement.setString(2, client.getEmail());
			this.preparedStatement.setString(3, client.getAdress());
			this.preparedStatement.setInt(4, client.getIdClient());
			
			
			this.preparedStatement.execute();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	//----- Requete de suppression dans la BDD
	@Override
	public void delete(Client client) {
		
		String req = "delete from client where id_client = ?";
		try {
			this.preparedStatement = this.cnx.prepareStatement(req);
			this.preparedStatement.setInt(1, client.getIdClient());
			
			
			this.preparedStatement.execute();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	//----- Retourner la liste de tous les clients existant dans la BDD
	@Override
	public List<Client> Clients() {
		
		List<Client> list = new ArrayList<Client>();
		try {
			this.statement = this.cnx.createStatement();
			this.resultSet = this.statement.executeQuery("select * from client");
			
			while(this.resultSet.next())
			{
				list.add(new Client(this.resultSet.getInt(1), 
						this.resultSet.getString(2),
						this.resultSet.getString(3),
						this.resultSet.getString(4)));

				Client clt = new Client(this.resultSet.getInt(1), 
						this.resultSet.getString(2),
						this.resultSet.getString(3),
						this.resultSet.getString(4));
				clt.toString();
				}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("117");
			e.printStackTrace();
		}
		return list;
	}

	//----- Retourner le client tel que : id_client = id
	@Override
	public Client getById(int id) {
		
		Client clt = null;
		String req = "select * from client where id_client = ?";
		
		try {
			this.preparedStatement = this.cnx.prepareStatement(req);
			this.preparedStatement.setInt(1, id);
			this.resultSet = this.preparedStatement.executeQuery();			
			
			while(this.resultSet.next())
			{
				clt = new Client(this.resultSet.getInt(1), 
						this.resultSet.getString(2),
						this.resultSet.getString(3),
						this.resultSet.getString(4));
				break;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return clt;
	}
}

package ma.fstt.tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	
	private static Connection connection;
	private String url = "jdbc:mysql://localhost:3306/cmd_management";
	private String user = "root";
	private String password = "";
	
	
	//----- Creation de Singleton: Connexion à la base de donnee
	
	private ConnectionManager() throws SQLException
	{
	
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			
			System.out.println("La class ConnectionManager");
			e.printStackTrace();
		}
		connection = DriverManager.getConnection(url, user, password);
	}
	
	public static Connection getConnection() throws SQLException
	{
		if(connection == null)
		{
			new ConnectionManager();
			
		}
		return connection;
		
	}
	
	
}

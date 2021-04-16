package ma.fstt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ma.fstt.entities.Product;
import ma.fstt.service.ProductRepository;
import ma.fstt.tools.ConnectionManager;

public class ProductDao implements ProductRepository{

	
	private Connection cnx;
	private Statement statement;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;
	
	//----- se conencter a la base de donnee
	public ProductDao() throws SQLException
	{
		cnx = ConnectionManager.getConnection();
	}
	
	//----- Requete d'insertion dans la BDD
	@Override
	public void save(Product prod) {
		String req = "insert into product (name_prod, price) values (?,?)";
		
		try {
			this.preparedStatement = this.cnx.prepareStatement(req);
			this.preparedStatement.setString(1, prod.getNameProd());
			this.preparedStatement.setDouble(2, prod.getPrice());
			
			this.preparedStatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	//----- Requete de la mise a jour dans la BDD
	@Override
	public void update(Product prod) {


		String req = "update product set name_prod = ?, price = ? where id_prod = ?";
		try {
			this.preparedStatement = this.cnx.prepareStatement(req);
			this.preparedStatement.setString(1, prod.getNameProd());
			this.preparedStatement.setDouble(2, prod.getPrice());
			this.preparedStatement.setInt(3, prod.getIdProd());
			
			this.preparedStatement.execute();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//----- Requete de suppression dans la BDD
	@Override
	public void delete(Product prod) {
		
		String req ="delete from product where id_prod =?";
		
		try {
			this.preparedStatement = this.cnx.prepareStatement(req);
			this.preparedStatement.setInt(1, prod.getIdProd());
			
			this.preparedStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	//----- Retourner la liste de tous les produits existant dans la BDD
	@Override
	public List<Product> Products() {
		List<Product> list = new ArrayList<Product>();
		try {
			this.statement = this.cnx.createStatement();
			this.resultSet =this.statement.executeQuery("select * from product");
			
			while(this.resultSet.next())
			{
				list.add(new Product(this.resultSet.getInt(1),
						this.resultSet.getString(2),
						this.resultSet.getDouble(3))
						);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	//----- Retourner le produit tel que : id_prod = id
	@Override
	public Product getById(int id) {

		Product prod = null;
		String req = "select * from product where id_prod=?";
		
		try {
			this.preparedStatement = this.cnx.prepareStatement(req);
			this.preparedStatement.setInt(1, id);
			this.resultSet = this.preparedStatement.executeQuery();
			
			while(this.resultSet.next())
			{
				prod = new Product(this.resultSet.getInt(1),
						this.resultSet.getString(2),
						this.resultSet.getDouble(3));
				break;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return prod;
	}
}

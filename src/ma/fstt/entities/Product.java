package ma.fstt.entities;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Product {
	
	private int idProd;
	private String nameProd;
	private double price;
	
	//----- Constructeur -------
	public Product(int idProd, String nameProd, double price) {
		super();
		this.idProd = idProd;
		this.nameProd = nameProd;
		this.price = price;
	}

	//----- Constructeur -------
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	//----- getters & setters -------
	public int getIdProd() {
		return idProd;
	}


	public String getNameProd() {
		return nameProd;
	}


	public void setNameProd(String nameProd) {
		this.nameProd = nameProd;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	@Override
	public String toString() {
		return "Product [idProd=" + idProd + ", nameProd=" + nameProd + ", price=" + price + "]";
	}
	
	
	
	
}

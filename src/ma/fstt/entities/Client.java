package ma.fstt.entities;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Client {
	
	private int idClient;
	private String name;
	private String email;
	private String adress;
	
	
	//----- Constructeur -------
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//----- Constructeur -------
	public Client(int idClient, String name, String email, String adress) {
		super();
		this.idClient = idClient;
		this.name = name;
		this.email = email;
		this.adress = adress;
	}

	
	//----- getters & setters -------
	public int getIdClient() {
		return idClient;
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	@Override
	public String toString() {
		return "Client [idClient=" + idClient + ", name=" + name + ", email=" + email + ", adress=" + adress + "]";
	}



	
	
	

}

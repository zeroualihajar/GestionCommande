package ma.fstt.entities;

import java.sql.Date;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Command {
	
	private int idCmd;
	private Date dateCmd;
	private int idClient;
	
	
	//----- Constructeur -------
	public Command() {
		super();
		
	}

	//----- Constructeur -------
	public Command(int idCmd, Date dateCmd) {
		super();
		this.idCmd = idCmd;
		this.dateCmd = dateCmd;
		
	}

	//----- Constructeur -------
	public Command(int idCmd, Date dateCmd, int idClient) {
		super();
		this.idCmd = idCmd;
		this.dateCmd = dateCmd;
		this.idClient = idClient;
	}

	//----- getters $ setters -------
	public int getIdCmd() {
		return idCmd;
	}


	public void setIdCmd(int idCmd) {
		this.idCmd = idCmd;
	}


	public Date getDateCmd() {
		return dateCmd;
	}


	public void setDateCmd(Date dateCmd) {
		this.dateCmd = dateCmd;
	}

	public int getIdClient() {
		return idClient;
	}


	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}
	
	

	
	
}

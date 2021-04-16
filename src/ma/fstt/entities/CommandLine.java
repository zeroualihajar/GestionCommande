package ma.fstt.entities;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CommandLine {
	
	private int idCmdLine;
	private int qty;
	private int idCmd;
	private int idProd;
	
	
	//----- Constructeur -------
	public CommandLine() {
		super();
		// TODO Auto-generated constructor stub
	}
		
	
	//----- Constructeur -------
	public CommandLine(int idCmdLine, int qty, int idCmd, int idProd) {
		super();
		this.idCmdLine = idCmdLine;
		this.qty = qty;
		this.idCmd = idCmd;
		this.idProd = idProd;
	}


	//----- getters & setters -------
	public int getIdCmdLine() {
		return idCmdLine;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}

	public int getIdCmd() {
		return idCmd;
	}

	public void setIdCmd(int idCmd) {
		this.idCmd = idCmd;
	}

	public int getIdProd() {
		return idProd;
	}

	public void setIdProd(int idProd) {
		this.idProd = idProd;
	}

	public void setIdCmdLine(int idCmdLine) {
		this.idCmdLine = idCmdLine;
	}
	
	
	
}

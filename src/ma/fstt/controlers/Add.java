package ma.fstt.controlers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ma.fstt.dao.CommandDao;
import ma.fstt.dao.CommandLineDao;
import ma.fstt.dao.ProductDao;
import ma.fstt.entities.Command;
import ma.fstt.entities.CommandLine;
import ma.fstt.entities.Product;

/**
 * Servlet implementation class Add
 */
@WebServlet("/Add")
public class Add extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Inject private ProductDao productdao;
	@Inject private CommandDao cmdDao;
	@Inject private CommandLineDao cmdLineDao;
	@Inject private Command cmd;
	@Inject private Product prod;
	
	
	public Add() throws SQLException {
		super();
		
		productdao = new ProductDao();
		cmdDao = new CommandDao();
		cmdLineDao = new CommandLineDao();
		
		cmd = new Command();
		prod = new Product();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("doGet : Add");

		//---- Reccuperation des donnees a partir de la page jsp
		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println("id : " + id);

		//----- List de tous les produits
		List<Product> list = productdao.Products();

		request.setAttribute("id", id);
		request.setAttribute("list", list);

		this.getServletContext().getRequestDispatcher("/commandLine.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//---- Reccuperation des donnees a partir de la page jsp
		int id = Integer.parseInt(request.getParameter("id"));
		int qty = Integer.parseInt(request.getParameter("qty"));
		int idProd = Integer.parseInt(request.getParameter("option"));

		System.out.println("id : " + id);
		System.out.println("option : " + idProd);
		System.out.println("qty : " + qty);

		cmd = cmdDao.getById(id);
		prod = productdao.getById(idProd);
		
		//----- creation de la commandLine
		CommandLine cmdLine = new CommandLine(0, qty, cmd.getIdCmd(), idProd);
		
		//----- Insertion dans la BDD
		cmdLineDao.save(cmdLine, cmd, prod);

		//----- List de tous les commandLines de la command n = id
		List<CommandLine> list = cmdLineDao.CommandLines(id);
				
		
		request.setAttribute("id", id);
		request.setAttribute("list", list);
		this.getServletContext().getRequestDispatcher("/detailsLine.jsp").forward(request, response);

	}

}

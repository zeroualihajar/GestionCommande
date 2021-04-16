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
import javax.servlet.http.HttpSession;

import ma.fstt.dao.ClientDao;
import ma.fstt.dao.CommandDao;
import ma.fstt.dao.CommandLineDao;
import ma.fstt.dao.ProductDao;
import ma.fstt.entities.Client;
import ma.fstt.entities.Command;
import ma.fstt.entities.CommandLine;
import ma.fstt.entities.Product;


@WebServlet("/DeleteCon")
public class DeleteCon extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Inject private Product product;
	@Inject private ProductDao productdao;
	
	@Inject private Client client;
	@Inject private ClientDao clientdao;
	
	@Inject private Command cmd;
	@Inject private CommandDao cmddao;
	
	@Inject private CommandLine cmdLine;
	@Inject private CommandLineDao cmdLinedao;
	
	public DeleteCon() throws SQLException {
		super();

		product = new Product();
		productdao = new ProductDao();
		
		client = new Client();
		clientdao = new ClientDao();
		
		cmd = new Command();
		cmddao = new CommandDao();
		
		cmdLine = new CommandLine();
		cmdLinedao = new CommandLineDao();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// ------ creation des varibles de session
		HttpSession session = request.getSession(true);
		String action = (String) session.getAttribute("page");

		int id = Integer.parseInt(request.getParameter("id"));

		if (action.equals("product")) {
			
			//----- Reccuperation de produit ayant l'id = id
			product = productdao.getById(id);
			
			//----- Suppression de produit
			productdao.delete(product);

			//----- List de tous les produits
			List<Product> list = productdao.Products();

			request.setAttribute("list", list);
			this.getServletContext().getRequestDispatcher("/product.jsp").forward(request, response);
		}

		else if (action.equals("client")) 
		{
			//----- Reccuperation de client ayant l'id = id
			client = clientdao.getById(id);
			
			//----- Suppression de produit
			clientdao.delete(client);

			//----- List de tous les clients
			List<Client> list = clientdao.Clients();

			request.setAttribute("list", list);
			this.getServletContext().getRequestDispatcher("/client.jsp").forward(request, response);
		}

		else if (action.equals("command")) 
		{
			//----- Reccuperation de command ayant l'id = id
			cmd = cmddao.getById(id);
			
			//----- Suppression de produit
			cmddao.delete(cmd);

			//----- List de tous les commands
			List<Command> list = cmddao.Commands(cmd.getIdClient());

			request.setAttribute("list", list);
			this.getServletContext().getRequestDispatcher("/command.jsp").forward(request, response);
		}
		
		else if(action.equals("cmdLine"))
		{
			System.out.println("id : "+id);

			//----- Reccuperation de commandLine ayant l'id = id
			cmdLine = cmdLinedao.getById(id);
			
			//----- Suppression de produit
			cmdLinedao.delete(cmdLine);

			//----- List de tous les commands
			List<CommandLine> list = cmdLinedao.CommandLines(cmdLine.getIdCmd());

			request.setAttribute("list", list);
			this.getServletContext().getRequestDispatcher("/detailsLine.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}

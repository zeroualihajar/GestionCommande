package ma.fstt.controlers;

import java.io.IOException;
import java.sql.Date;
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


@WebServlet("/UpdateCon")
public class UpdateCon extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Inject private Product product;
	@Inject private ProductDao productdao;
	@Inject private Client client;
	@Inject private ClientDao cltdao;
	@Inject private Command cmd;
	@Inject private CommandDao cmddao;
	@Inject private CommandLine cmdLine;
	@Inject private CommandLineDao cmdLinedao;
	
	public UpdateCon() throws SQLException {
		super();
		
		product = new Product();
		productdao = new ProductDao();
		
		client = new Client();
		cltdao = new ClientDao();
		
		cmd = new Command();
		cmddao = new CommandDao();
		
		cmdLine = new CommandLine();
		cmdLinedao = new CommandLineDao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("doGet : UpdateCon");
		
		//---- Reccuperation des donnees a partir de la page jsp
		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println("id : "+id);
		
		//------ creation des varibles de session
		HttpSession session = request.getSession(true);
		String action = (String) session.getAttribute("page");
		
		
		System.out.println("action :" +action);
		if(action.equals("product"))
		{
			//----- Reccuperation de produit ayant l'id = id
			product = productdao.getById(id);
			request.setAttribute("product", product);
			
			this.getServletContext().getRequestDispatcher("/updateProd.jsp").forward(request, response);
		}
		
		else if(action.equals("client"))
		{
			//----- Reccuperation de client ayant l'id = id
			client = cltdao.getById(id);
			request.setAttribute("client", client);
			
			this.getServletContext().getRequestDispatcher("/updateClient.jsp").forward(request, response);
		}
		
		else if(action.equals("command"))
		{
			System.out.println("idClient : "+cmd.getIdClient());
			
			//----- Reccuperation de command ayant l'id = id
			cmd = cmddao.getById(id);
			
			//----- Reccuperation de client ayant l'id = id
			client = cltdao.getById(cmd.getIdClient());
			
			//----- List de tous les clients
			List<Client> list = cltdao.Clients();
			
			request.setAttribute("cmd", cmd);
			request.setAttribute("list", list);
			request.setAttribute("clt", client);
			this.getServletContext().getRequestDispatcher("/updateCommand.jsp").forward(request, response);
		}
		
		else if(action.equals("cmdLine"))
		{
			//----- Reccuperation de commandLine ayant l'id = id
			cmdLine = cmdLinedao.getById(id);

			//----- List de tous les produits
			List<Product> prod = productdao.Products();
			
			//----- List de tous les commanLines
			List<CommandLine> list = cmdLinedao.CommandLines(cmdLine.getIdCmd());
			
			request.setAttribute("prod", prod);
			request.setAttribute("list", list);
			request.setAttribute("cmdLine", cmdLine);
			this.getServletContext().getRequestDispatcher("/updateLine.jsp").forward(request, response);
			
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("UpdateCon doPost");
		
		//------ creation des varibles de session
		HttpSession session = request.getSession(true);
		String action = (String) session.getAttribute("page");
		
		if(action.equals("product"))
		{
			//---- Reccuperation des donnees a partir de la page jsp
			String name = request.getParameter("name");
			float price = Float.parseFloat(request.getParameter("price"));

			//----- Creation de produit
			product = new Product(0, name, price);
			
			//----- update de produit
			productdao.update(product);
			
			//----- List de tous les produits
			List<Product> list = productdao.Products();
			
			request.setAttribute("list", list);
			this.getServletContext().getRequestDispatcher("/product.jsp").forward(request, response);
		}
		
		else if(action.equals("client"))
		{
			//---- Reccuperation des donnees a partir de la page jsp
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String adress = request.getParameter("adress");
			

			//----- Creation de client
			Client client = new Client(0, name, email, adress);
			
			//----- update de client
			cltdao.update(client);
			
			//----- List de tous les clients
			List<Client> list = cltdao.Clients();
			
			request.setAttribute("list", list);
			this.getServletContext().getRequestDispatcher("/client.jsp").forward(request, response);
		}
		
		else if(action.equals("command"))
		{
			//---- Reccuperation des donnees a partir de la page jsp
			String dt = request.getParameter("date");
			Date date = Date.valueOf(dt);
			int idClient = Integer.parseInt(request.getParameter("usr"));
			

			//----- Creation de command
			Command cmd = new Command(0, date, idClient);
			
			//----- Reccuperation de client ayant l'id = id
			client = cltdao.getById(idClient);
			
			//----- update de client
			cmddao.update(cmd, client);
			
			//----- List de tous les clients
			List<Client> list = cltdao.Clients();
			
			request.setAttribute("list", list);
			this.getServletContext().getRequestDispatcher("/client.jsp").forward(request, response);
		}
		
		else if(action.equals("cmdLine"))
		{
			//---- Reccuperation des donnees a partir de la page jsp
			int idCmd = Integer.parseInt(request.getParameter("idCmd"));
			int idProd = Integer.parseInt(request.getParameter("option"));
			int qty = Integer.parseInt(request.getParameter("qty"));
			

			//----- Creation de comamndLine
			CommandLine cmdLine = new CommandLine(0, qty, idCmd, idProd);
			
			//----- Reccuperation de client ayant l'id = id
			cmd = cmddao.getById(idCmd);
			
			//----- update de commandLine
			cmdLinedao.update(cmdLine);

			//----- List de tous les commandLines
			List<CommandLine> list = cmdLinedao.CommandLines(idCmd);
			
			request.setAttribute("list", list);
			this.getServletContext().getRequestDispatcher("/detailsLine.jsp").forward(request, response);
		}
		
	}

}

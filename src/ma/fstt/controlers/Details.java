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
import ma.fstt.dao.CommandLineDao;
import ma.fstt.entities.Client;
import ma.fstt.entities.CommandLine;


@WebServlet("/Details")
public class Details extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Inject Client client;
	@Inject ClientDao clientdao;
	@Inject CommandLineDao cmdLinedao;
	
	
	public Details() throws SQLException {
		super();
		
		client = new Client();
	    clientdao = new ClientDao();
	    cmdLinedao = new CommandLineDao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("doGet Details");

		// ------ creation des varibles de session
		HttpSession session = request.getSession(true);
		String action = (String) session.getAttribute("page");
		
		
		if(action.equals("client"))
		{

			//---- Reccuperation des donnees a partir de la page jsp
			int id = Integer.parseInt(request.getParameter("id"));
			System.out.println("id : " + id);

			//----- Reccuperation de client ayant l'id = id
			client = clientdao.getById(id);
			request.setAttribute("client", client);

			this.getServletContext().getRequestDispatcher("/details.jsp").forward(request, response);
		}
		
		else if(action.equals("command"))
		{
			System.out.println("Details : command");
			
			//---- Reccuperation des donnees a partir de la page jsp
			int id = Integer.parseInt(request.getParameter("id"));
			System.out.println("id : " + id);
		
			//----- List de tous les commandLines
			List<CommandLine> list = cmdLinedao.CommandLines(id);
			request.setAttribute("list", list);
			request.setAttribute("id", id);
			
			this.getServletContext().getRequestDispatcher("/detailsLine.jsp").forward(request, response);	
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("doPost: Details");

		//---- Reccuperation des donnees a partir de la page jsp
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String adress = request.getParameter("adress");

		//----- Creation de client
		Client client = new Client(0, name, email, adress);
		
		//----- Insertion dans la BDD
		clientdao.save(client);

		doGet(request, response);

	}

}

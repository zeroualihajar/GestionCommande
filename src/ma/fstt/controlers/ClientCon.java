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

import ma.fstt.dao.ClientDao;
import ma.fstt.entities.Client;

/**
 * Servlet implementation class ClientCon
 */
@WebServlet("/ClientCon")
public class ClientCon extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject private ClientDao cltdao;
	

	public ClientCon() throws SQLException {
		super();

		cltdao = new ClientDao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("doGet ClienCon");

		//----- List de tous les clients
		List<Client> list = cltdao.Clients();

		request.setAttribute("list", list);

		this.getServletContext().getRequestDispatcher("/client.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("doPost: ClientCon");

		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String adress = request.getParameter("adress");

		//----- Creation de client
		Client client = new Client(0, name, email, adress);
		
		//----- Insertion dans la BDD
		cltdao.save(client);

		doGet(request, response);

	}

}

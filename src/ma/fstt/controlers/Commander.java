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

import ma.fstt.dao.ClientDao;
import ma.fstt.dao.CommandDao;
import ma.fstt.entities.Client;
import ma.fstt.entities.Command;

@WebServlet("/Commander")
public class Commander extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject private CommandDao cmddao;
	@Inject private ClientDao clientdao;
	@Inject private Client client;

	public Commander() throws SQLException {
		super();

		cmddao = new CommandDao();
		clientdao = new ClientDao();
		client = new Client();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("doGet Commander");
		
		//---- Reccuperation des donnees a partir de la page jsp
		int id = Integer.parseInt(request.getParameter("id"));

		//----- List de tous les commands
		List<Command> list = cmddao.Commands(id);

		request.setAttribute("list", list);
		request.setAttribute("id", id);
		this.getServletContext().getRequestDispatcher("/command.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("doPost Commander");

		//---- Reccuperation des donnees a partir de la page jsp
		int id = Integer.parseInt(request.getParameter("id"));
		
		//---- la date actuel
		long millis = System.currentTimeMillis();
		Date date = new Date(millis);

		System.out.println("id : " + id);
		System.out.println("date : " + date);

		//----- Reccuperation de client ayant l'id = id
		client = clientdao.getById(id);

		//----- Creation de command
		Command cmd = new Command(0, date);
		
		//----- Insertion dans la BDD
		cmddao.save(cmd, client);

		doGet(request, response);
	}

}

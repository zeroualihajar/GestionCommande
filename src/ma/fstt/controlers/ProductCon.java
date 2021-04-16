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

import ma.fstt.dao.ProductDao;
import ma.fstt.entities.Product;



@WebServlet("/ProductCon")
public class ProductCon extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Inject private ProductDao productdao;
	
    public ProductCon() throws SQLException {
        super();

        productdao = new ProductDao();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("doGet : ProductCon");
		
		//----- List de tous les produits
		List<Product> list = productdao.Products();
		
		request.setAttribute("list", list);
		this.getServletContext().getRequestDispatcher("/product.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("doPost : conection");
		
		//---- Reccuperation des donnees a partir de la page jsp
		String name = request.getParameter("name");
		Double price = Double.parseDouble(request.getParameter("price"));
		
		//----- Creation de produit
		Product product = new Product(0, name, price);
		
		//----- Insertion dans la BDD
		productdao.save(product);
		
		doGet(request, response);
		
	}

}

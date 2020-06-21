package sabina.com;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class ControllerSab
 */
@SuppressWarnings("unused")
@WebServlet("/ControllerSab")
public class ControllerSab extends HttpServlet {
	private static final long serialVersionUID = 1L;
	SabDAO test;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerSab() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void init() throws ServletException{
    	String jdbcURL=getServletContext().getInitParameter("jdbcURL");
    	String jdbcUserName=getServletContext().getInitParameter("jdbcUserName");
    	String jdbcPassword=getServletContext().getInitParameter("jdbcPassword");
    	System.out.println(jdbcURL);
    	try {
			test= new SabDAO(jdbcURL,jdbcUserName,jdbcPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String op=request.getParameter("opcion");
		switch(op) {
		case "1":
			Articulo articulo=new Articulo(1,"Baraja","Rider W.",150);
			if(test.registrar(articulo)) {
				System.out.println("Articulo ingresado");
			}else {
				System.out.println("Articulo no ingresado");
			}
			break;
		
		case "2":
			Articulo a1=new Articulo(2,"Baraja","Española",90);
			if(test.editar(a1)) {
				System.out.println("Articulo actualizado");
			}else {
				System.out.println("Articulo no actualizado");
			}
			break;
		
		case "3":
			Articulo a2=new Articulo(3,"Baraja","Egipcia",130);
			if(test.eliminar(a2)) {
				System.out.println("Articulo eliminado");
			}else {
				System.out.println("Articulo no eliminado");
			}
			break;
		
		case "4":
			test.obtenerArticulo(2);
			break;
		case "5":
			test.obtenerArticulos();
			break;
		default:
			break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}













package sabina.com;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SabDAO {
	private Sabconexion con;
	
	public SabDAO(String jdbcURL, String jdbcUserName, String jdbcPassword) throws SQLException {
		con=new Sabconexion(jdbcURL,jdbcUserName,jdbcPassword);
		//con.connection();
		System.out.println(con.getjdbcConnection());
	}
	public boolean registrar(Articulo a) {
		boolean estado=false;
		Statement stm;
		String sql="INSERT INTO articulos VALUES (NULL,'"+a.getNombre()+"','"+a.getDescripcion()+"'+"+ a.getPrecio()+")";
		
		try {
			con.connection();
			stm=con.getjdbcConnection().createStatement();
			stm.executeUpdate(sql);
			estado=true;
			stm.close();
			con.discconect();
		}catch (SQLException e) {
			estado=false;
			e.printStackTrace();
		
		}
		return estado;
	}
	public boolean editar(Articulo a) {
		boolean estado=false;
		Statement stm;
		
		String sql="UPDATE articulos SET nombre='" + a.getNombre()+"' WHERE id=" + a.getId();
		
		try {
			con.connection();
			stm=con.getjdbcConnection().createStatement();
			stm.executeUpdate(sql);
			estado= true;
			stm.close();
			con.discconect();
		}catch (SQLException e) {
			estado=true;
			e.printStackTrace();
		}
		return estado;
	}
	public boolean eliminar(Articulo a) {
		boolean estado=false;
		Statement stm;
		
		String sql="DELETE FROM articulos  WHERE id=" + a.getId();
		
		try {
			con.connection();
			stm=con.getjdbcConnection().createStatement();
			stm.executeUpdate(sql);
			estado= true;
			stm.close();
			con.discconect();
		}catch (SQLException e) {
			estado=true;
			e.printStackTrace();
		}
		return estado;
	}	
	
	@SuppressWarnings("null")
	public void obtenerArticulos() {
		Statement stm;
		ResultSet res=null;
		Articulo a;
		
		String sql="SELECT * FROM articulos";
		
		try {
			con.connection();
			stm=con.getjdbcConnection().createStatement();
			stm.executeQuery(sql);
			while(res.next()) {
				a=new Articulo(res.getInt("id"),res.getString("nombre"),res.getString("descripcion"),res.getDouble("precio"));
				System.out.println(a);
			}
			stm.close();
			con.discconect();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@SuppressWarnings("null")
	public void obtenerArticulo(int id) {
		Statement stm;
		ResultSet rs=null;
		
		String sql="SELECT * FROM articulos WHERE id=" +id;
		
		try {
			con.connection();
			stm=con.getjdbcConnection().createStatement();
			stm.executeQuery(sql);
			Articulo a;
			if(rs.next()) {
				a=new Articulo(rs.getInt("id"),rs.getString("nombre"),rs.getString("description"),rs.getDouble("precio"));
				System.out.println(a);
			}
			stm.close();
			con.discconect();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}	
	}
}



































































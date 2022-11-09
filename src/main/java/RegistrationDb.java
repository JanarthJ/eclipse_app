import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class RegistrationDb {
	private String dbUrl = "jdbc:mysql://localhost:3306/ebbill";
	private String dbuname = "root";
	private String dbpassword = "JanarthananRoot@2002";
	private String dbDriver = "com.mysql.cj.jdbc.Driver";
	
	public void loadDriver(String dbDriver) {
		try {
			Class.forName(dbDriver);
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	public Connection getConnection() throws SQLException {
		Connection con = DriverManager.getConnection(dbUrl, dbuname , dbpassword);		
		return con;
		
	}
	
	public String insert(Registration user) {
		
		loadDriver(dbDriver);
		try {
			Connection con;
			con = getConnection();
		
			String sql = "insert into users values(?,?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(2, user.getUsername());
			ps.setString(3, user.getPassword());
			ps.setString(1, user.getName());
			ps.setString(4, user.getUsertype());
			ps.setString(5, user.getUnit());
			ps.setString(6, user.getDuedate());
			ps.setString(7, user.getAmount());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "Data not entered successfully";
		}	
		
		return "Data entered successfully";
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ArrayList login(String username,String password,String usertype) {
//		ArrayList consumers = new ArrayList();
		
		ArrayList list = new ArrayList();
		loadDriver(dbDriver);
		try {
			Connection con;
			con = getConnection();
		
			String sql = "select * from users where username='"+username+"' and password='"+password+"' and usertype='"+usertype+"'";
			System.out.println(sql);
			PreparedStatement ps = con.prepareStatement(sql);			
			ResultSet rs = ps.executeQuery();
			System.out.println(rs.getFetchSize());
			
			if(rs.next()) {
				ArrayList rb = new ArrayList();
				System.out.println(rs.getString(1));
				if(usertype.equals("consumer")) {
					System.out.println("If part");
					rb.add(rs.getString(1));
					rb.add(rs.getString(2));
//					rb.add(rs.getString(4));
					rb.add(rs.getString(5));
					rb.add(rs.getString(6));
					rb.add(rs.getString(7));
					System.out.println(rb);
					list.add(rb);
					return list;
				}
				else {					
					System.out.println("else part");
					String sqls = "select * from users where usertype='consumer'";
					PreparedStatement pss = con.prepareStatement(sqls);			
					ResultSet res = pss.executeQuery();
					
					while(res.next()) {
						ArrayList rbs = new ArrayList();
						rbs.add(res.getString(1));
						rbs.add(res.getString(2));
//						rbs.add(res.getString(4));
						rbs.add(res.getString(5));
						rbs.add(res.getString(6));
						rbs.add(res.getString(7));
						System.out.println(rbs);
						list.add(rbs);
					}					
					return list;
				}
			}
			else {
				return list;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return list;
		}		
		
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ArrayList UpdateBill(String username,String duedate,String unit) {
			ArrayList list = new ArrayList();
			loadDriver(dbDriver);
			try {
				Connection con;
				con = getConnection();
				String sql = "UPDATE users SET unit ='"+unit+"', duedate ='"+duedate+"'WHERE username = '"+username+"'";				
				System.out.println(sql);
				PreparedStatement ps = con.prepareStatement(sql);	
//				ps.executeQuery();
				ps.executeUpdate();				
				
			} catch (SQLException e) {
				e.printStackTrace();
				return list;
			}	
			try {
				Connection con;
				con = getConnection();
				String sqls = "select * from users where usertype='consumer'";
				PreparedStatement pss = con.prepareStatement(sqls);			
				ResultSet res = pss.executeQuery();
			
				while(res.next()) {
					ArrayList rbs = new ArrayList();
					rbs.add(res.getString(1));
					rbs.add(res.getString(2));
	//				rbs.add(res.getString(4));
					rbs.add(res.getString(5));
					rbs.add(res.getString(6));
					rbs.add(res.getString(7));
					System.out.println(rbs);
					list.add(rbs);
				}					
				return list;
			} catch (SQLException e) {
				e.printStackTrace();
				return list;
			}	
		}
	

	
}

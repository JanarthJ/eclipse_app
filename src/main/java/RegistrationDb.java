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
	
	public List<Registration> login(String username,String password,String usertype) {
		ArrayList<Registration> consumers = new ArrayList<>();
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
				System.out.println(rs.getString(1));
				if(usertype.equals("consumer")) {
					Registration rb = new Registration(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7));
					consumers.add(rb);
					return consumers;
				}
				else {
					System.out.println("else part");
					String sqls = "select * from users where usertype='consumer'";
					PreparedStatement pss = con.prepareStatement(sqls);			
					ResultSet res = pss.executeQuery();
					ArrayList<Registration> users = new ArrayList<>();
					while(res.next()) {
						Registration rbs = new Registration(res.getString(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5),res.getString(6),res.getString(7));
						System.out.println(rbs);
						users.add(rbs);
					}					
					return users;
				}
			}
			else {
				return consumers;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return consumers;
		}		
		
	}

	
}

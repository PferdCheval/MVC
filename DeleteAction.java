import java.util.*;
import java.sql.*;

public class DeleteAction {
	private String ISBN;
	
	public void setISBN(String ISBN){
		this.ISBN = new String(ISBN);
	}
	public String getISBN(){
		return ISBN;
	}
	
	Connection con;
	Statement st;
	public static Connection getConnection(){
		Connection con = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://w.rdc.sae.sina.com.cn:3307/app_yjclab2","ljyk54wlnn","y45052xl1mwjwz4wkmzkhm1jh51xh15hwk02yjjj");
		}catch(Exception e){
			System.out.println("Connect Fail:"+e.getMessage());
		}
		return con;
	}
	
	public String execute()throws Exception{
		con = getConnection();
		try{
			String sql = "delete from Book where ISBN="+"'"+ISBN+"'";
			System.out.println(sql);
			st = (Statement)con.createStatement();
			int count = st.executeUpdate(sql);
			System.out.println("Delete Successful.Delete DataNum:"+count);
			con.close();
			return "Success";
		}catch(SQLException e){
			return "Failed";
		}
	}
}

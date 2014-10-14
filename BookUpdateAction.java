import java.util.*;
import java.sql.*;

public class BookUpdateAction {
	private String Name;
	private String Publisher;
	private String PublishDate;
	private int Price;
	private String ISBN;
	
	public void setName(String Name){
		this.Name=new String(Name);
	}
	public void setPublisher(String Publisher){
		this.Publisher=new String(Publisher);
	}
	public void setPublishDate(String PublishDate){
		this.PublishDate=new String(PublishDate);
	}
	public void setPrice(int Price){
		this.Price=Price;
	}
	public void setISBN(String ISBN){
		this.ISBN=new String(ISBN);
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
			String sql1="update Book set Publisher='"+Publisher+"',PublishDate='"+PublishDate+"',Price='"+Price+"' where ISBN='"+ISBN+"'";
			st = (Statement)con.createStatement();
			System.out.println(sql1);
			int count = st.executeUpdate(sql1);
			String IDtemp = null;
			String sql2="select * from Book";
			ResultSet res = st.executeQuery(sql2);
			while(res.next()){
				if(ISBN.equals(res.getString("ISBN"))){
					IDtemp=new String(res.getString("AuthorID"));
					break;
				}
			}
			String sql3="update Author set Name='"+Name+"' where AuthorID='"+IDtemp+"'";
			int count2 = st.executeUpdate(sql3);
			System.out.println("Update Successful.DataNum is:"+(count+count2));
			con.close();
			return "Success";
		}catch(SQLException e){
			System.out.println("Update Failed.");
			return "Failed";
		}
	}
}
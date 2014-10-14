import java.util.*;
import java.sql.*;

public class getDetails {
	private String ISBN;
	private String AuthorID;
	private String Publisher;
	private String PublishDate;
	private int Price;
	
	private String BookTitle = null;
	public String getBookTitle(){
		return BookTitle;
	}
	public void setBookTitle(String BookTitle){
		this.BookTitle = new String(BookTitle);
	}
	
	public String getISBN(){
		return ISBN;
	}
	public String getAuthorID(){
		return AuthorID;
	}
	public String getPublisher(){
		return Publisher;
	}
	public String getPublishDate(){
		return PublishDate;
	}
	public int getPrice(){
		return Price;
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
		System.out.println(BookTitle);
		try{
			String sql = "select * from Book";
			st = (Statement)con.createStatement();
			ResultSet res = st.executeQuery(sql);
			while(res.next()){
				if(BookTitle.equals(res.getString("Title"))){
					ISBN = new String(res.getString("ISBN"));
					AuthorID = new String(res.getString("AuthorID"));
					Publisher = new String(res.getString("Publisher"));
					PublishDate = new String(res.getString("PublishDate"));
					Price = res.getInt("Price");
				}
			}
			con.close();
			return "Success";
		}catch(SQLException e){
			System.out.println("Connect Failed."+e.getMessage());
			return "Failed";
		}
	}
}

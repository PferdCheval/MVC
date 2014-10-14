import java.util.*;
import java.sql.*;

public class Query{
	Connection con;
	Statement st;

	private String Authorname;
	private ArrayList<String> BookList = new ArrayList<String>();
	
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
	
	public String getAuthorname(){
		return Authorname;
	}
	
	public void setAuthorname(String Author){
		this.Authorname = new String(Author);
	}
	
	public ArrayList<String> getBookList(){
		return BookList;
	}
	
	public String execute()throws Exception{
		con = getConnection();
		try{
			String sql = "select * from Author";
			st = (Statement)con.createStatement();
			ResultSet res = st.executeQuery(sql);
			boolean flag = false;
			String TeAuthorID = null;
			
			while(res.next()){
				if(Authorname.equals(res.getString("Name"))){
					TeAuthorID=new String(res.getString("AuthorID"));
					flag = true;
					break;
				}
			}
			if(flag){
				String sq2 = "select * from Book";
				res = st.executeQuery(sq2);
				while(res.next())
					if(TeAuthorID.equals(res.getString("AuthorID")))
						BookList.add(new String(res.getString("Title")));
				con.close();
				return "Success";
			}	
			else{ 
				con.close();
				return "Failed";
			}
		}catch(Exception e){
			System.out.println("Errors."+e.getMessage());
			return "Else";
		}
	}
}

import java.util.*;
import java.sql.*;

public class ChooseAction {
	private String ISBN;
	
	public void setISBN(String ISBN){
		this.ISBN=new String(ISBN);
	}
	public String getISBN(){
		return ISBN;
	}
	
	public String execute()throws Exception{
		return "Success";
	}
}

package step6;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class showRating {
	public String show(String language) {
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/step6","root","");  
			Statement stmt=con.createStatement(); 
			String op="SELECT * FROM doctor_name INNER JOIN doctor_language ON doctor_name.emp_id=doctor_language.emp_id";  
		    ResultSet rs = stmt.executeQuery(op);
		    while(rs.next())  
	    	{
		    	String doctorsLanguage = rs.getString("language");
		    	if(doctorsLanguage.contentEquals(language))
		    	{return("id: "+rs.getInt(1)+" Name: " +rs.getString(2)+" Surname: " +rs.getString(3)+" Language: "+rs.getString("language") );}
	        
			}
		    con.close();  
		    }catch(Exception e){ return ("Error");} 
		
			
		
		
		return ("Not Found!");
	}


}
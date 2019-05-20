package step6;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;



public class showHospital {
	public String showRanks() {
		
		try{  
			
		

			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/step6","root","");  
			Statement stmt=con.createStatement(); 
			String op="SELECT * FROM hospital INNER JOIN city ON city.city_id=hospital.city_id ORDER by rank DESC";  
		    ResultSet rs = stmt.executeQuery(op);
		
		    while(rs.next())  
	    	{
		  
		    return("id: "+rs.getInt(1)+"  name: "+rs.getString(2)+" rank: "+rs.getString(3)+" city: "+rs.getString("city_name")+" country: "+rs.getString("country_name"));
			}
		    
		    con.close();  
		    }catch(Exception e){ System.out.println("Error Database Connection is not valid");} 
		
		return ("Not Found");

}
	
}

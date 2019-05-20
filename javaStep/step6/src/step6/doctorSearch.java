package step6;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class doctorSearch {
	public String search(String doctorSpeciality) {
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/step6","root","");  
			Statement stmt=con.createStatement(); 
			String op="SELECT * FROM doctor_name INNER JOIN surgeon_speciality ON surgeon_speciality.emp_id=doctor_name.emp_id;";  
		    ResultSet rs = stmt.executeQuery(op);
		    while(rs.next())  
		    	{
	
		    	String spec = rs.getString("speciality");
	
		    	if (doctorSpeciality.contentEquals(spec))
    			{return("id: "+rs.getInt(1)+"  name: "+rs.getString(2)+" lastname: "+rs.getString(3)); }			
		    	
		    	}
		    
		        con.close();  
				}catch(Exception e){ return ("Error");} 
		
			
		
		
		return ("Not Found!");
	}

}

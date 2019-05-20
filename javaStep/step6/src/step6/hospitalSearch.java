package step6;


import java.sql.*;

public class hospitalSearch {
	public String search(String hospitalName) {
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/step6","root","");  
			Statement stmt=con.createStatement(); 
			String op="SELECT * FROM hospital";  
		    ResultSet rs = stmt.executeQuery(op);
		    while(rs.next()) {   
		    	String name = rs.getString("hospital_name");
		    	String id= rs.getString("hospital_id");
		    	String rank=rs.getString("rank");
		    	if (hospitalName.contentEquals(name))
		    			{return ("id: "+ id+" name: "+name+" rank: "+rank);}
	         }
		        con.close();  
				}catch(Exception e){ return ("Error");} 
		
			
		
		
		return ("Not Found!");
	}

}

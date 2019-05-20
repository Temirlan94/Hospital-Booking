package step6;


import java.sql.*;



public class rateHospital {
	public String rate(String hospitalName,String userId,String locationRate,String serviceRate,String gentilityRate,String commentRate) {
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/step6","root","");  
			Statement stmt=con.createStatement(); 
			String op="SELECT * FROM rating INNER JOIN hospital ON hospital.hospital_id=rating.hospital_id";  
		
			int columnsNumber =0;
			int rate=0;
			int rate1=0;
			ResultSet rs = stmt.executeQuery(op);
			while (rs.next())
			{
				int locationInt=Integer.parseInt(locationRate);	
		    	int serviceInt=Integer.parseInt(serviceRate);
		    	int gentilityInt=Integer.parseInt(gentilityRate);
		    	int userInt=Integer.parseInt(userId);
		    	int comingRate=(locationInt+serviceInt+gentilityInt)/3;

		    	
		    		String name = rs.getString("hospital_name");
			    	int location=rs.getInt("location");
			    	int service=rs.getInt("Service");
			    	int gentility=rs.getInt("Gentility");
		    		rate1=comingRate;
		    		if (hospitalName.contentEquals(name))
	    			{
		    		
		    		columnsNumber++;
		    		int newRate=(location+service+gentility)/3;
		    		rate+=newRate;
		    		int r=rankCalculator(rate,rate1,columnsNumber);
		    		String queryRank="UPDATE hospital SET rank=? WHERE hospital_name=?";
		    		java.sql.PreparedStatement preparedStmt = con.prepareStatement(queryRank);
		    		preparedStmt.setInt (1, r);
		    		preparedStmt.setString (2, hospitalName);
		    		preparedStmt.execute();
		    		System.out.println(r);
	    			}
		    	 	if (hospitalName.contentEquals(name))
	    			{
			    		
			    		
			    		int hospitalId=rs.getInt("hospital_id");
			    		
			    		String query = "insert into `rating` (location,Service,Gentility,Comment,user_id,hospital_id)"+"values (?, ?, ?, ?, ?, ?)";
			    		java.sql.PreparedStatement preparedStmt = con.prepareStatement(query);
			    		
			    		preparedStmt.setInt (1, locationInt);
			    		preparedStmt.setInt (2, serviceInt);
			    		preparedStmt.setInt (3, gentilityInt);
			    		preparedStmt.setString (4,commentRate );
			    		preparedStmt.setInt (5, userInt);
			    		preparedStmt.setInt (6, hospitalId);
			    		preparedStmt.execute();
			    		return ("Thank You!");
			   	
			    	}
		    	 	
				
			}
			
		    
		 

		
		        con.close();  
				}catch(Exception e){ return ("Error");} 
		
			
		
		
		
			
		
		
		return ("Not found!");

}

	public int rankCalculator(int r1,int r2,int columnsNumber)
	{
		int rank=(r1+r2)/(columnsNumber+1);
	    return rank;
		
	}
}
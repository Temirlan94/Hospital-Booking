package step6;

import java.awt.event.*; 
import javax.swing.*;

public class main {
 
	
	public static void main(String args[]){  
		System.out.println("Welcome!");
		//=================================================
		//Creating buttons for operations==================
		JFrame f=new JFrame(); 
		
		JButton b1=new JButton("1.Search for a hospital");//creating instance of JButton  
		b1.setBounds(20,20,200, 40);//x axis, y axis, width, height  
		f.add(b1);//adding button in JFrame 
		JTextField hospitalName = new JTextField("Enter Hospital name");
		hospitalName.setBounds(250,20,150, 30);
		f.add(hospitalName);
		
		b1.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){  
					   String hospital = hospitalName.getText();
					   String result=hospitalSearch(hospital);  
			           System.out.println(result);
			           JTextField output = new JTextField(result);
			           output.setBounds(300,600,400, 100);
			           f.add(output);
			       }  
			     });  
		
		   
		JButton b2=new JButton("2.Search for a doctor");
		b2.setBounds(20,80,200, 40);
		f.add(b2);
		JTextField doctorSpeciality = new JTextField("Enter Doctor Speciality");
		doctorSpeciality.setBounds(250,80,150, 30);
		f.add(doctorSpeciality);
		
		b2.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){  
					String speciality = doctorSpeciality.getText();
					 String result=doctorSearch(speciality);  
					 System.out.println(result);
					 JTextField output = new JTextField(result);
			           output.setBounds(300,600,400, 100);
			           f.add(output);
			       }  
			     });  
		
		JButton b3=new JButton("3.Show Doctor with language");//creating instance of JButton  
		b3.setBounds(20,140,200, 40);
		f.add(b3);
		JTextField doctorLanguage = new JTextField("Enter Language");
		doctorLanguage.setBounds(250,150,150, 30);
		f.add(doctorLanguage);
		
		b3.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){
					 String language = doctorLanguage.getText();
					 String result=doctorLanguage(language);  
					 System.out.println(result);
					 JTextField output = new JTextField(result);
			           output.setBounds(300,600,400, 100);
			           f.add(output);
			       }  
			     });  
		
		
		JButton b4=new JButton("4.Rate Hospital");//creating instance of JButton  
		b4.setBounds(20,200,200, 40);
		f.add(b4);
		
		JTextField hospitalName2 = new JTextField("Enter Hospital name");
		hospitalName2.setBounds(250,205,150, 30);
		f.add(hospitalName2);
		
		JTextField userId = new JTextField("Enter user id");
		userId.setBounds(420,205,80, 30);	
		f.add(userId);
		
		
		JTextField location = new JTextField("Rate location");
		location.setBounds(520,205,80, 30);
		f.add(location);
		
		JTextField service = new JTextField("Rate service");
		service.setBounds(620,205,80, 30);
		f.add(service);
		
		JTextField gentility = new JTextField("Rate gentility");
		gentility.setBounds(720,205,80, 30);
		f.add(gentility);
		
		JTextField comment = new JTextField("Comment");
		comment.setBounds(820,205,80, 30);
		f.add(comment);
		
		b4.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){  
				   String hospital = hospitalName2.getText();
				   String user = userId.getText();
				   String locationRate = location.getText();
				   String serviceRate = location.getText();
				   String gentilityRate = gentility.getText();
				   String commentRate=comment.getText();
				   
				   String result=hospitalRank(hospital,user,locationRate,serviceRate,gentilityRate,commentRate);  
		           System.out.println(result);
		           JTextField output = new JTextField(result);
		           output.setBounds(300,600,400, 100);
		           f.add(output);
				
			       }  
			     });
		
		
		JButton b5=new JButton("5.Most popular hospital");//creating instance of JButton  
		b5.setBounds(20,270,200, 40);
		f.add(b5);
		
		b5.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){  
					 String result=showHospital();  
					 System.out.println(result);
					 JTextField output = new JTextField(result);
			           output.setBounds(300,600,400, 100);
			           f.add(output);
			       }  
			     }); 
		
		JButton b6=new JButton("6.Least popular hospital");//creating instance of JButton  
		b6.setBounds(20,330,200, 40);
		f.add(b6);
		
		b6.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){  
					 String result=showLeastHospital();  
					 System.out.println(result);
					 JTextField output = new JTextField(result);
			           output.setBounds(300,600,400, 100);
			           f.add(output);
			       }  
			     }); 
	
		
		JButton b7=new JButton("7.Quit");//creating instance of JButton  
		b7.setBounds(20,380,200, 40);
		f.add(b7);
		
		b7.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){  
						
				f.dispose();		
				System.out.println("Frame Closed.");	
			       }  
			     }); 
		
		f.setSize(1000,1000);
		f.setLayout(null);
		f.setVisible(true);
		
	
	}
	

	

	public static String hospitalSearch(String hospitalName){
		
		hospitalSearch h1= new hospitalSearch();
		String result=h1.search(hospitalName);
		
		return (result);
	}
	
	public static String doctorSearch(String doctorSpeciality){
		
		doctorSearch h1= new doctorSearch();
		String result=h1.search(doctorSpeciality);
		
		return (result);
	}
	
	public static String doctorLanguage(String language){
		
		showRating h1= new showRating();
		String result=h1.show(language);
		
		return (result);
	}
	public static String hospitalRank(String hospitalName,String userId,String locationRate,String serviceRate,String gentilityRate,String commentRate){
	
		rateHospital h1= new rateHospital();
		String result=h1.rate(hospitalName,userId,locationRate,serviceRate,gentilityRate,commentRate);
		
		return (result);
	}
	public static String showHospital(){
		
		showHospital h1= new showHospital();
		String result=h1.showRanks();
		
		return (result);
	}
public static String showLeastHospital(){
		
		leastPopular h1= new leastPopular();
		String result=h1.showRanks();
		
		return (result);
	}
}

package com.Heart;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.JSONArray;

public class Learn {

	public Learn() {
		// TODO Auto-generated constructor stub
	}

	public void add_knowledge_frame(String talk) {
		
		JFrame frame=new JFrame("Learn");
		frame.setSize(500, 400);
		frame.setVisible(true);
		frame.setResizable(false);
	
		frame.setLayout(null);
		
		
		
		JPanel panel=new  JPanel();
		panel.setSize(400,400);
		
	JLabel label=new JLabel("Question");
	label.setSize(400, 100);
	label.setLocation(70,50);
	frame.add(label);
		
		JTextField fi=new JTextField();
		fi.setSize(400, 30);
		fi.setLocation(70,150);
		fi.setBackground(Color.cyan);
		frame.add(fi);
		
		JTextField fx=new JTextField();
		fx.setSize(400, 30);
		fx.setLocation(70,200);
		fx.setBackground(Color.cyan);
		frame.add(fx);
		
		JTextField fy=new JTextField();
		fy.setSize(400, 30);
		fy.setLocation(70,250);
		fy.setBackground(Color.cyan);
		frame.add(fy);
		
		JButton butt=new JButton("ok");
		butt.setSize(50,50);
		butt.setLocation(70, 300);
		frame.add(butt);
		
		butt.addActionListener(new ActionListener() {
	        
	      
			@Override
			public void actionPerformed(ActionEvent e) {
				
				//System.out.println(fi.getText()+fx.getText()+fy.getText());
				
				//-----------------------------------------------------
				//----------------------------------
				
				

				 try {
					 
					 JSONObject objo = new JSONObject();
					 System.out.println(objo.toString());
					 
					 objo.put("name", talk);
					 
				        JSONArray list = new JSONArray();

				  		
				  		list.add(fi.getText());
				  		list.add(fx.getText());
				  		list.add(fy.getText());
				  		 
				  		
					       
					        objo.put("messages", list);
				        
				        System.out.println(objo.toString());
				        
				        add_Knowledge(objo.toString());
					 
					 
					objo.put("name",talk);
				} catch (JSONException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				 
			
				
				
				//------------------------------------------------------
				
				
			} });
	}
	
	
	public   void add_Knowledge(String new_question) throws IOException 
	{
		
		
		BufferedReader abc = new BufferedReader(new FileReader("DB.json"));
		List<String> lines = new ArrayList<String>();

		String line;
		while((line = abc.readLine()) != null) {
		    lines.add(line);
		  
		}
		abc.close();
			//
		//{"name"          :"knpp"},
		// If you want to convert to a String[]
		String[] data = lines.toArray(new String[]{});
		
		String new_knoledge=new_question;
		String new_anchor="{\"name\":\"knpp\"},";
	
		//System.out.println(data[data.length-2]);
		data[data.length-2]=String.valueOf(","+new_knoledge+""+"\n");
		
		
		try (FileWriter file = new FileWriter("DB.json")) {
				
			for (String ta :data) {
				
				file.write(ta+"\n");
		
			
		}
            
           // file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }

	}
	
	
	
	
	
	
}

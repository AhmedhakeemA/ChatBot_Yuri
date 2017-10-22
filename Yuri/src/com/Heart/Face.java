package com.Heart;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.JSONArray;

public class Face {

	public Face() {
	
		Color color=new Color(0, 96, 128);
    	
	   //153, 230, 255
		JFrame frame=new JFrame("Face");
		frame.setSize(500, 500);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.getContentPane().setBackground( color );
		
		
		
		JTextField fi=new JTextField();
		fi.setSize(480, 30);
		fi.setLocation(5,400);
		fi.setBackground(Color.cyan);
		
		JTextArea area=new JTextArea();
		area.setSize(455,330);
		area.setLocation(8, 5);
		area.setBackground(Color.white);
		area.setBackground(color);
		
		JScrollPane msgScroller = new JScrollPane(area,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);        
		
		
	
		
		
		
	 Font font = new Font("ARIAL", Font.TYPE1_FONT, 12);
		 area.setFont(font);
		 area.setForeground(Color.BLACK);
		//-------------------------------------------------
		
		
		
		
		
		
		
		//--------------------------------------------------
		
		fi.addActionListener(new ActionListener() {
	        
	      
			@Override
			public void actionPerformed(ActionEvent e) {
				Brain br=new Brain();
				
				String talk=fi.getText();
				try {
					
					String a=br.tunnel(talk);
					
					//--------------------
					if (a==null) {
						area.append("Ahmed"+":  "+talk+"\n");
						area.append("Yuri"+":  "+"i don't know !"+"\n");
						area.append("Yuri"+":  "+"could you Please tell me about"+"  "+talk+"\n");
						String anS=talk;
						System.out.println(anS);
					
							
							
					
						        
						        
						        Learn leo=new Learn(); 
							
							leo.add_knowledge_frame(anS);
							
							
							area.append("Yuri"+":  "+"Thanks for new info"+"  "+talk+"\n");
							//---------------------------------
							///do learn here
							
					}
						
					
					//--------------------
					else if(a!=null){
						area.append("Ahmed"+":  "+talk+"\n");
						area.append("Yuri"+":  "+a+"\n");
						
					}
					
					fi.setText("");
					
				} catch (JSONException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
								
				
				
				
				
			}
				
				
				
	    });
		
		frame.add(fi);
		frame.add(area);
		frame.add(msgScroller);
		
	}

}

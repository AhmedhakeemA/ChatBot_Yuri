package com.Heart;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;

import javax.print.DocFlavor.STRING;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Brain {

	public Brain() {
		
			}
	
	
	
	public String  tunnel(String s) throws JSONException, IOException
	{
		
		//JSONParser parser = new JSONParser();
		
			String text = new String(Files.readAllBytes(Paths.get("DB.json")), StandardCharsets.UTF_8);
			String o = null;
		//System.out.println(text);
		JSONObject obj=new JSONObject(text);
		
		JSONArray arr = obj.getJSONArray("Brain");
	
		for(int i = 0; i < arr.length(); i++)
		{
		    JSONObject object = arr.getJSONObject(i);
		    String n = object.getString("name");
		    //System.out.println(n);
			if(n.equals(s))
			{
				JSONArray array = object.getJSONArray("messages");

				Random r = new Random();
				int i1 = r.nextInt(array.length()- 0) + 0;
					 //System.out.println(array.getString(i1));
					
					
					
					o= array.getString(i1);

			}
				
		
	}
		if(o==null)
		{
			//String p="sorry bmy answers is limited.";
			return null;
		}
		else
		{return o;}
	    //return o;

	}
	


   


}

package com.hand.Exam3;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class CreateJson {
	
	String[] result;
	
	public CreateJson(String[] str) {
		this.result = str;
	}
	
	public void newJson(){
		JsonArray array = new JsonArray();
		
		JsonObject object = new JsonObject();
		object.addProperty("name", result[0]);
		object.addProperty("open", result[1]);
		object.addProperty("close", result[2]);
		object.addProperty("current", result[3]);
		object.addProperty("high", result[4]);
		object.addProperty("low", result[5]);
		
		array.add(object);
		try {
			FileOutputStream fos = new FileOutputStream("newJson.json");
			byte[] b = array.toString().getBytes("UTF-8");
			fos.write(b);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(array.toString());
	}
	
	
	
}

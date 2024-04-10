package com.sanket.serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SaveToFile {

	public static void serialize(Object o) {
		FileOutputStream fs;
		ObjectOutputStream ob;
		try {
			fs = new FileOutputStream("Employees.txt");
			ob = new ObjectOutputStream(fs);
			ob.writeObject(o);
			ob.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static Object deserialise(String filename) {
		Object object = null;
		try {
			FileInputStream fs = new FileInputStream(filename);
			ObjectInputStream obj = new ObjectInputStream(fs);
			object = obj.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return object;
	}
	
	
}

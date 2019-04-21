package genericCheckpointing.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileProcessor {

		String filename;
		BufferedReader br;
		FileReader fr;
		BufferedWriter bw;
		FileWriter fw;
	
		public void openFileSerialize(String filenameIn) {
			
			if(filenameIn!=null){
				
				filename=filenameIn;
				
				File f=new File(filename);
				try {
					fw=new FileWriter(filename);
					bw=new BufferedWriter(fw);
				} catch (FileNotFoundException 
						e) {
					System.err.println("Enter correct filename");
					System.exit(1);
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
		}
		
		public void openFileDeserialize(String filenameIn) {
			
			if(filenameIn!=null){
				
				filename=filenameIn;
				
				File f=new File(filename);
				try {
					fr=new FileReader(f);
					br=new BufferedReader(fr);
				} catch (IOException e) {
					System.err.println("Enter correct filename");
					System.exit(1);
					e.printStackTrace();
				}
				
			}
			
		}
		
		public String readLine(){
			
			String str=null;
			try {
				str=br.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return str;
		}
		
		public void writeLine(String line) {
			
			try {
				
				bw.write(line);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public void closeFileSerialize() {
			try {
				fw.flush();
				bw.flush();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
		public void closeFileDeserialize() {
			try {
				fr.close();
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	public String toString() {
		String s="Processing on file-"+filename;
		return s;
	}
	}


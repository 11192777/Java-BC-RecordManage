package export;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileDispose {
	
	public static void main(String[] args) {
		
	}
	
	private void buildMajor () {
		StringBuffer sb = new StringBuffer();
		try {
			BufferedReader br = new BufferedReader(new FileReader(new File("ExportFiles\\majors")));
			String line = br.readLine();
			while (line != null) {
				sb.append(line.replaceAll(" ", "") + " ");
				line = br.readLine();
			}
			String surname = sb.toString();
//			surname = surname.replaceAll("|", "?");
			System.out.println(surname);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void buildNation () {
		StringBuffer sb = new StringBuffer();
		try {
			BufferedReader br = new BufferedReader(new FileReader(new File("ExportFiles\\nation")));
			String line = br.readLine();
			while (line != null) {
				sb.append(line);
				line = br.readLine();
			}
			String surname = sb.toString();
			surname = surname.replaceAll("¡¢", " ");
			System.out.println(surname);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void buildName () {
		StringBuffer sb = new StringBuffer();
		try {
			BufferedReader br = new BufferedReader(new FileReader(new File("ExportFiles\\name")));
			String line = br.readLine();
			while (line != null) {
				sb.append(line);
				line = br.readLine();
			}
			String surname = sb.toString();
			surname = surname.replaceAll("¡¡", "");
			System.out.println(surname);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void buildSurnames () {
		StringBuffer sb = new StringBuffer();
		try {
			BufferedReader br = new BufferedReader(new FileReader(new File("ExportFiles\\surname")));
			String line = br.readLine();
			while (line != null) {
				sb.append(line);
				line = br.readLine();
			}
			String surname = sb.toString();
			surname = surname.replaceAll("£¬", "");
			surname = surname.replaceAll("¡£", "");
			System.out.println(surname);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

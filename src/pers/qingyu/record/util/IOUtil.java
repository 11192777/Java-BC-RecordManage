package pers.qingyu.record.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import pers.qingyu.record.po.StaffFile;
import pers.qingyu.record.po.StudentFile;
import pers.qingyu.record.po.TeacherFile;

public class IOUtil {
	
	public static void writeStudentToFile(ArrayList<StudentFile> students, String path) {
		File file = null;
		FileOutputStream out = null;
		ObjectOutputStream oos = null;
		try {
			file = new File(path);
			out = new FileOutputStream(file);
			oos = new ObjectOutputStream(out);

			for (StudentFile s : students) {
				oos.writeObject(s);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static ArrayList<StudentFile> readStudentToFile(String path) {
		ArrayList<StudentFile> students = null;

		File file = null;
		FileInputStream in = null;
		ObjectInputStream ois = null;

		try {
			file = new File(path);
			in = new FileInputStream(file);
			ois = new ObjectInputStream(in);

			StudentFile s = (StudentFile) ois.readObject();
			while (s != null) {
				students.add(s);
				s = (StudentFile) ois.readObject();
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return students;
	}
	public static void writeTeacherToFile(ArrayList<TeacherFile> teachers, String path) {
		File file = null;
		FileOutputStream out = null;
		ObjectOutputStream oos = null;
		try {
			file = new File(path);
			out = new FileOutputStream(file);
			oos = new ObjectOutputStream(out);

			for (TeacherFile s : teachers) {
				oos.writeObject(s);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static ArrayList<TeacherFile> readTeacherToFile(String path) {
		ArrayList<TeacherFile> teachers = null;

		File file = null;
		FileInputStream in = null;
		ObjectInputStream ois = null;

		try {
			file = new File(path);
			in = new FileInputStream(file);
			ois = new ObjectInputStream(in);

			TeacherFile t = (TeacherFile) ois.readObject();
			while (t != null) {
				teachers.add(t);
				t = (TeacherFile) ois.readObject();
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return teachers;
	}
	public static void writeStaffToFile(ArrayList<StaffFile> staffs, String path) {
		File file = null;
		FileOutputStream out = null;
		ObjectOutputStream oos = null;
		try {
			file = new File(path);
			out = new FileOutputStream(file);
			oos = new ObjectOutputStream(out);

			for (StaffFile s : staffs) {
				oos.writeObject(s);
				System.out.println("11");
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static ArrayList<StaffFile> readStaffToFile(String path) {
		ArrayList<StaffFile> staffs = null;

		File file = null;
		FileInputStream in = null;
		ObjectInputStream ois = null;

		try {
			file = new File(path);
			in = new FileInputStream(file);
			ois = new ObjectInputStream(in);

			StaffFile s = (StaffFile) ois.readObject();
			while (s != null) {
				staffs.add(s);
				s = (StaffFile) ois.readObject();
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return staffs;
	}
}

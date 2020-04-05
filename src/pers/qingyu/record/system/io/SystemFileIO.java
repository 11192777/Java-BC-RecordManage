package pers.qingyu.record.system.io;

import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.HorizontalAlignment;

import pers.qingyu.record.po.StudentFile;

public class SystemFileIO {

	public static void outPutFileToExcel(ArrayList<StudentFile> files, String path) {
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet("ѧ����һ");
		HSSFRow row = sheet.createRow((int) 0);
		HSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(HorizontalAlignment.CENTER);
		
		HSSFCell cell = row.createCell((short) 0);
		cell.setCellValue("ѧ��");
		cell.setCellStyle(style);
		
		cell = row.createCell((short) 1);
		cell.setCellValue("����");
		cell.setCellStyle(style);
		
		cell = row.createCell((short) 2);
		cell.setCellValue("�Ա�");
		cell.setCellStyle(style);
		
		cell = row.createCell((short) 3);
		cell.setCellValue("����");
		cell.setCellStyle(style);
		
		cell = row.createCell((short) 4);
		cell.setCellValue("רҵ");
		cell.setCellStyle(style);
		
		cell = row.createCell((short) 5);
		cell.setCellValue("ʡ��֤��");
		cell.setCellStyle(style);
		
		cell = row.createCell((short) 6);
		cell.setCellValue("����");
		cell.setCellStyle(style);

		for (int i = 0; i < files.size(); i++) {
			row = sheet.createRow((int) i + 1);
			StudentFile file = files.get(i);
			row.createCell((short) 0).setCellValue(file.getNumber());
			row.createCell((short) 1).setCellValue(file.getSex());
			row.createCell((short) 2).setCellValue(file.getName());
			row.createCell((short) 3).setCellValue(file.getNation());
			row.createCell((short) 4).setCellValue(file.getMajor());
			row.createCell((short) 5).setCellValue(file.getIdnumber());
			cell = row.createCell((short) 6);
			cell.setCellValue(new SimpleDateFormat("yyyy-mm-dd").format(file.getBirthday()));
		}

		try {
			FileOutputStream fout = new FileOutputStream(path+".xls");
			wb.write(fout);
			fout.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
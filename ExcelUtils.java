 package excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	public static List <String> excelread(String filename, String sheetname) throws IOException {
		File f=new File(filename);
		FileInputStream fi=new FileInputStream(f);
		XSSFWorkbook work= new XSSFWorkbook(fi);
		XSSFSheet sheet=work.getSheet(sheetname);
		
		List<String>list=new ArrayList();
		
		for(int i=1;i<sheet.getPhysicalNumberOfRows();i++) {
			XSSFRow row=sheet.getRow(i);
			for(int j=0;j<row.getPhysicalNumberOfCells();j++) {
				XSSFCell cell =row.getCell(j);
				String cellString=cell.toString();
				list.add(cellString);
			}
		}
	return list;  
	
	}

	
		
	}



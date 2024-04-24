package miniProject;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel 
{
	XSSFWorkbook workBook = new XSSFWorkbook();
	FileOutputStream fos;
    String filePath = "C:\\Users\\2318582\\eclipse-workspace\\MiniProject\\ExcelFile\\Output.xlsx";
	public void sendFirstResult(String result) {
		 
		  XSSFSheet sheet = workBook.createSheet("Sheet1");

		  XSSFRow row = sheet.createRow(1); 
		  row.createCell(0).setCellValue(result);
		  try(FileOutputStream fos = new FileOutputStream(filePath))
		  {
			  workBook.write(fos);
		  }
		  catch (IOException e)
		  {
			  e.printStackTrace();
		  }
	}
	public void sendSecondfResult(String result) {
		 
		  XSSFSheet sheet = workBook.getSheet("Sheet1");

		  XSSFRow row = sheet.createRow(2); 
		  row.createCell(0).setCellValue(result);
		  try(FileOutputStream fos = new FileOutputStream(filePath))
		  {
			  workBook.write(fos);
		  }
		  catch (IOException e)
		  {
			  e.printStackTrace();
		  }
	}
	public void sendThirdfResult(String result) {
		 
		  XSSFSheet sheet = workBook.getSheet("Sheet1");

		  XSSFRow row = sheet.createRow(3); 
		  row.createCell(0).setCellValue(result);
		  try(FileOutputStream fos = new FileOutputStream(filePath))
		  {
			  workBook.write(fos);
		  }
		  catch (IOException e)
		  {
			  e.printStackTrace();
		  }
	}
	public void sendFourthfResult(String result) {
		 
		  XSSFSheet sheet = workBook.getSheet("Sheet1");

		  XSSFRow row = sheet.createRow(4); 
		  row.createCell(0).setCellValue(result);
		  try(FileOutputStream fos = new FileOutputStream(filePath))
		  {
			  workBook.write(fos);
		  }
		  catch (IOException e)
		  {
			  e.printStackTrace();
		  }
	}
	public void sendFifthResult(String result) {
		 
		  XSSFSheet sheet = workBook.getSheet("Sheet1");

		  XSSFRow row = sheet.createRow(5); 
		  row.createCell(0).setCellValue(result);
		  try(FileOutputStream fos = new FileOutputStream(filePath))
		  {
			  workBook.write(fos);
		  }
		  catch (IOException e)
		  {
			  e.printStackTrace();
		  }
	}
	public void sendSixthResult(List<String> result) {
		 
		  XSSFSheet sheet = workBook.getSheet("Sheet1");
		  
		  for(int r=6, i=0; r<(6+result.size())&& i<result.size(); r++, i++)
		  {
			  XSSFRow row = sheet.createRow(r); 
			  row.createCell(0).setCellValue(result.get(i));
		  }
		   
		  try(FileOutputStream fos = new FileOutputStream(filePath))
		  {
			  workBook.write(fos);
		  }
		  catch (IOException e)
		  {
			  e.printStackTrace();
		  }
	}
}

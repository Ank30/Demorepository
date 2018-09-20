package Excel01;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	
	private static XSSFSheet ExcelWSheet;
	private static XSSFWorkbook ExcelWBook;
	private static XSSFCell Cell;
	private static XSSFRow Row;
	static String system_path=System.getProperty("user.dir");
	public static String excelsheetpath = system_path + "\\src\\test\\resources\\out.xlsx";
	//This method is used to set the file path and to open the excel file, Pass excel path and sheet name as arguments to this method

	/**
	* Sets the excel file.
	* @param Path the path
	* @param SheetName the sheet name
	* @return
	* @throws Exception the exception
	*/
	public static void setExcelFile(String SheetName, String newSheetName)
	throws Exception {
	try{
	//Open the excel file
	System.out.println("excelsheetpath "+excelsheetpath);
	FileInputStream ExcelFile = new FileInputStream(excelsheetpath);
	//Access the required test data sheet
	ExcelWBook = new XSSFWorkbook(ExcelFile);
	ExcelWBook.createSheet(newSheetName);
	ExcelWSheet = ExcelWBook.getSheet(SheetName);
	}
	catch (Exception e){
	throw(e);
	}
	}
	//This method is to read the test data from the Excel cell, in this we are passing parameters as RowNum and ColNum
	public static String getCellData(int RowNum, int ColNum) throws Exception
	{
	try{
	int columns=ExcelWSheet.getRow(RowNum).getLastCellNum();
	System.out.println("No. of Columns "+columns);
	Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
	String CellData = Cell.getStringCellValue();
	return CellData;
	}
	catch(Exception e)
	{
	return "";
	}
	}
	public static void setCellData(String Result, int RowNum, int ColNum) 	throws Exception{
	try{
	Row=ExcelWSheet.getRow(RowNum);
	Cell=Row.getCell(ColNum, Row.RETURN_BLANK_AS_NULL);
	if (Cell == null){
	Cell = Row.createCell(ColNum);
	Cell.setCellValue(Result);
	} else{
	Cell.setCellValue(Result);
	}
	//Constant variables Test Data path and Test Data file name
	FileOutputStream fileOut = new FileOutputStream(excelsheetpath);
	ExcelWBook.write(fileOut);
	fileOut.flush();
	fileOut.close();
	}
	catch(Exception e)
	{throw(e);
	}
	}

	
	

}

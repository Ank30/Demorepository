package Excel01;

public class CallExcelUtility {

			public static void main(String[] args) throws Exception {
			// TODO Auto-generated method stub
			ExcelUtility.setExcelFile("Sheet1", "TestNewSheet2");
			String Employeeid = ExcelUtility.getCellData(1, 1);
			System.out.println("Employee id is:"+Employeeid);
			ExcelUtility.setCellData("Shikha", 1, 1);

		// TODO Auto-generated method stub

	}

}

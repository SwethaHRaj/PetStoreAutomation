package api.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

public class ExcelOperations {
	
	private Sheet s;
	
	public ExcelOperations(String s) {
		String filePath=System.getProperty("user.dir")+"/TestData/users.xlsx"; 
		File f=new File(filePath);
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(f);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Workbook wb = null;
		try {
			wb = WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.s=wb.getSheet(s);
	}
	
	public HashMap<String, String> getDataInHashMap(int row) throws EncryptedDocumentException, IOException {
		
		HashMap<String, String> hm=new HashMap<String, String>();
		for(int i=0;i<s.getRow(0).getLastCellNum();i++) {
			hm.put(s.getRow(0).getCell(i).toString(), s.getRow(row).getCell(i).toString());
		}	
		return hm;
	}
	
	public String getValueOfCell(int row, int cell) throws EncryptedDocumentException, IOException {
		String cellValue=s.getRow(row).getCell(cell).toString();
		return cellValue;		
	}
	
	public int getRowCount() {
		return s.getLastRowNum();
	}

	public int getCellCount() {
		return s.getRow(0).getLastCellNum();
	}
	
	@DataProvider(name="test1")
	public Object[][] dataProviderForTest1() throws EncryptedDocumentException, IOException {
		ExcelOperations excel=new ExcelOperations("sheet1");
		Object[][] obj=new String[excel.getRowCount()][1];
		for(int i=0;i<excel.getRowCount();i++) {
			HashMap<String, String> hm=excel.getDataInHashMap(i);
			obj[i][0]=hm;
		}
		return obj;
	}
}


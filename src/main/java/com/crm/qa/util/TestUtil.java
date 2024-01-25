package com.crm.qa.util;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import static com.crm.qa.base.TestBase.driver;

public class TestUtil {

    public static long PAGE_TIME_OUT = 30;
    public static long IMPLICIT_WAIT = 20;
    public static String TESTDATA_SHEET_PATH ="src/main/java/com/crm/qa/testdata/testDataSheet.xlsx";
    static Workbook book;
    static Sheet sheet;


    public static Object[][] getTestData(String sheetName) throws IOException {
        FileInputStream file = null;
        try {
            file = new FileInputStream(TESTDATA_SHEET_PATH);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
          book = WorkbookFactory.create(file);
          sheet = book.getSheet(sheetName);

        Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
        for(int i =0; i<sheet.getLastRowNum(); i++) {   //this is for Rows
           for(int k =0; k <sheet.getRow(0).getLastCellNum(); k++) {   // this is for columns
               data[i][k] = sheet.getRow(i +1).getCell(k).toString();  // Row value is stating from i+1 to omit header value

              }
           }

        return data;

    }


    public static void takeScreenshotAtEndOfTest() throws IOException {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String currentDir = System.getProperty("user.dir");
        FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
    }
}

/*
 * POIExcelReader.java
 *
 * Created on 7 October, 2007, 9:05 PM
 */

package com.test;

//~--- non-JDK imports --------------------------------------------------------

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

//~--- JDK imports ------------------------------------------------------------
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * This java program is used to read the data from a Excel file and display them
 * on the console output.
 *
 * @author dhanago
 */
public class POIExcelReader {

	/** Creates a new instance of POIExcelReader */
	public POIExcelReader() {
	}

	/**
	 * This method is used to display the Excel content to command line.
	 *
	 * @param xlsPath
	 */
	@SuppressWarnings("unchecked")
	public void displayFromExcel(String xlsPath) {
		InputStream inputStream = null;

		try {
			inputStream = new FileInputStream(xlsPath);
		} catch (FileNotFoundException e) {
			System.out.println("File not found in the specified path.");
			e.printStackTrace();
		}

		POIFSFileSystem fileSystem = null;

		try {
			fileSystem = new POIFSFileSystem(inputStream);

			HSSFWorkbook workBook = new HSSFWorkbook(fileSystem);
			HSSFSheet sheet = workBook.getSheetAt(0);
			Iterator rows = sheet.rowIterator();

			while (rows.hasNext()) {
				HSSFRow row = (HSSFRow) rows.next();

				// display row number in the console.
				System.out.println("Row No.: " + row.getRowNum());

				// once get a row its time to iterate through cells.
				List<String> list = new ArrayList<String>();

				Iterator cells = row.cellIterator();

				while (cells.hasNext()) {
					
				   	
					HSSFCell cell = (HSSFCell) cells.next();


					System.out.println("Cell No.: " + cell.getCellNum());

					/*
					 * Now we will get the cell type and display the values
					 * accordingly.
					 */
					switch (cell.getCellType()) {
					case HSSFCell.CELL_TYPE_NUMERIC: {

						// cell type numeric.
						System.out.println("Numeric value: "
								+ cell.getNumericCellValue());

						break;
					}

					case HSSFCell.CELL_TYPE_STRING: {

						// cell type string.
						String richTextString = cell.getStringCellValue();

						System.out.println("String value: "
								+ richTextString.toString());

						break;
					}

					default: {

						// types other than String and Numeric.
						System.out.println("Type not supported.");

						break;
					}
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * The main executable method to test displayFromExcel method.
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		POIExcelReader poiExample = new POIExcelReader();
		String xlsPath = "/home/srikanth/excelreadjava/excelsample.xls";

		poiExample.displayFromExcel(xlsPath);
	}
}
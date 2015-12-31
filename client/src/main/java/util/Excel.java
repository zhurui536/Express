package util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.filechooser.FileFilter;
import javax.swing.table.TableModel;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;

/**
 * Created by Away 2015/12/19
 */

public class Excel {

	private HSSFWorkbook workbook;

	private HSSFCellStyle style;

	private HSSFCellStyle style2;
	
	private OutputStream outputStream;
	
	private JFileChooser jfc = new JFileChooser();
	
	public Excel() {
		workbook = new HSSFWorkbook();
		showFileChooser();
	}

	private void showFileChooser() {
		jfc.addChoosableFileFilter(new FileFilter() {
		      public boolean accept(File file) {
		        return (file.getName().indexOf("xls") != -1);
		      }

		      public String getDescription() {
		        return "Excel";
		      }
		    });
		jfc.showSaveDialog(null);
		
		File file = jfc.getSelectedFile();
		try {
			outputStream = new FileOutputStream(file + ".xls");
		}
		catch (FileNotFoundException ex) {
			ex.printStackTrace();
		}
	}

	public void createSheet(JTable table, String title) {
		HSSFSheet sheet = workbook.createSheet(title);
		// 设置表格默认列宽度为15个字节
		sheet.setDefaultColumnWidth(15);
		// 生成一个样式
		style = workbook.createCellStyle();
		// 设置这些样式
		style.setFillForegroundColor(HSSFColor.SKY_BLUE.index);
		style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		style.setBorderRight(HSSFCellStyle.BORDER_THIN);
		style.setBorderTop(HSSFCellStyle.BORDER_THIN);
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		// 生成一个字体
		HSSFFont font = workbook.createFont();
		font.setColor(HSSFColor.VIOLET.index);
		font.setFontHeightInPoints((short) 12);
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		// 把字体应用到当前的样式
		style.setFont(font);
		// 生成并设置另一个样式
		style2 = workbook.createCellStyle();
		style2.setFillForegroundColor(HSSFColor.LIGHT_YELLOW.index);
		style2.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		style2.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		style2.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		style2.setBorderRight(HSSFCellStyle.BORDER_THIN);
		style2.setBorderTop(HSSFCellStyle.BORDER_THIN);
		style2.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		style2.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		// 生成另一个字体
		HSSFFont font2 = workbook.createFont();
		font2.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);
		// 把字体应用到当前的样式
		style2.setFont(font2);

		processList(table, sheet);
	}

	private void processList(JTable table, HSSFSheet sheet) {
		TableModel tm = table.getModel();
		int row = tm.getRowCount();
		int cloumn = tm.getColumnCount();

		for (int i = 0; i < row + 1; i++) {
			HSSFRow hr = sheet.createRow(i);
			for (int j = 0; j < cloumn; j++) {
				if (i == 0) {
					String value = tm.getColumnName(j);
					HSSFRichTextString srts = new HSSFRichTextString(value);
					HSSFCell hc = hr.createCell(j);
					hc.setCellStyle(style);
					hc.setCellValue(srts);
				} else {
					System.out.println("vlue  " + tm.getValueAt(i - 1, j));
					if (tm.getValueAt(i - 1, j) != null) {
						String value = tm.getValueAt(i - 1, j).toString();
						HSSFRichTextString srts = new HSSFRichTextString(value);
						HSSFCell hc = hr.createCell(j);
						hc.setCellStyle(style2);
						if (value.equals("") || value == null) {
							hc.setCellValue(new HSSFRichTextString(""));
						} else {
							hc.setCellValue(srts);
						}
					}
				}
			}
		}
	}

	public boolean export() {
		try {
			workbook.write(outputStream);
			outputStream.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

}

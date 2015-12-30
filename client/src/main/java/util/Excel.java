package util;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;

/**
 * Created by Away
 * 2015/12/19
 */

public class Excel {

    private HSSFWorkbook workbook;

    public Excel() {
        workbook = new HSSFWorkbook();
    }

    public void createSheet(Object data, String title, String[] headers) {
        List<Object> dataList = new ArrayList<>();
        dataList.add(data);
        createSheet(dataList, title, headers);
    }

    public void createSheet(List dataList, String title, String[] headers) {
        HSSFSheet sheet = workbook.createSheet(title);
        // 设置表格默认列宽度为15个字节
        sheet.setDefaultColumnWidth(15);
        // 生成一个样式
        HSSFCellStyle style = workbook.createCellStyle();
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
        HSSFCellStyle style2 = workbook.createCellStyle();
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

        // 产生表格标题行
        HSSFRow row = sheet.createRow(0);
        for (int i = 0; i < headers.length; i++)
        {
            HSSFCell cell = row.createCell(i);
            cell.setCellStyle(style);
            HSSFRichTextString text = new HSSFRichTextString(headers[i]);
            cell.setCellValue(text);
        }

        processList(dataList, sheet, style2);
    }

    private void processList(List dataList, HSSFSheet sheet, HSSFCellStyle style2) {
        // 遍历集合数据，产生数据行
//        if (dataList == null) return;
        Iterator it = dataList.iterator();
        int index = 0;
        while (it.hasNext())
        {
            index++;
            HSSFRow row = sheet.createRow(index);
            Object t = it.next();
            // 利用反射，根据javabean属性的先后顺序，动态调用getXxx()方法得到属性值
            Field[] fields = t.getClass().getDeclaredFields();
            for (int i = 0; i < fields.length; i++)
            {
                HSSFCell cell = row.createCell(i);
                cell.setCellStyle(style2);
                Field field = fields[i];
                String fieldName = field.getName();
                String getMethodName = "get"
                        + fieldName.substring(0, 1).toUpperCase()
                        + fieldName.substring(1);
                try {
                    Class cls = t.getClass();
                    @SuppressWarnings("unchecked")
                    Method getMethod = cls.getMethod(getMethodName);
                    Object value = getMethod.invoke(t);
                    System.out.println(value);
                    // 判断值的类型后进行强制类型转换
                    if (value instanceof BigDecimal) {
                        DecimalFormat df = new DecimalFormat("#.00");
                        Double doubleValue = ((BigDecimal) value).doubleValue();
                        cell.setCellValue(df.format(doubleValue));
                    }
                    else if (value instanceof Time) {
                        String time = value.toString();
                        cell.setCellValue(time);
                    }
                    else if (value instanceof String) {
                        String str = (String) value;
                        cell.setCellValue(str);
                    }
                    else if (value instanceof Enum) {
                        Enum e = (Enum) value;
                        cell.setCellValue(e.toString());
                    }
                    else if (value instanceof List) {
                        processList((List) value, sheet, style2);
                    }
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        }
    }

    public void export(OutputStream out) {
        try {
            workbook.write(out);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}









package com.zhj.util;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

public class ReadExcel {
    /**
     * 对外提供读取excel 的方法
     * */
    public static List<List<Object>> readExcel(File file) throws IOException {
        String fileName = file.getName();
        String extension = fileName.lastIndexOf(".") == -1 ? "" : fileName
                .substring(fileName.lastIndexOf(".") + 1);
        if ("xls".equals(extension)) {
            return read2003Excel(file);
        } else if ("xlsx".equals(extension)) {
            return read2007Excel(file);
        } else {
            throw new IOException("不支持的文件类型");
        }
    }

    /**
     * 读取 office 2003 excel
     * 
     * @throws IOException
     * @throws
     */
    private  static List<List<Object>> read2003Excel(File file) throws IOException {
        List<List<Object>> list = new LinkedList<List<Object>>();
        HSSFWorkbook hwb = new HSSFWorkbook(new FileInputStream(file));
        HSSFSheet sheet = hwb.getSheetAt(0);
        Object value = null;
        HSSFRow row = null;
        HSSFCell cell = null;
        int counter = 0;
        for (int i = sheet.getFirstRowNum(); counter < sheet
                .getPhysicalNumberOfRows(); i++) {
            row = sheet.getRow(i);
            if (row == null) {
                continue;
            } else {
                counter++;
            }
            List<Object> linked = new LinkedList<Object>();
            for (int j = row.getFirstCellNum(); j <= row.getLastCellNum(); j++) {
                cell = row.getCell(j);
                if (cell == null) {
                    continue;
                }
                DecimalFormat df = new DecimalFormat("0");// 格式化 number String
                                                            // 字符
                SimpleDateFormat sdf = new SimpleDateFormat(
                        "yyyy-MM-dd HH:mm:ss");// 格式化日期字符串
                DecimalFormat nf = new DecimalFormat("0.00");// 格式化数字
                switch (cell.getCellType()) {
                case XSSFCell.CELL_TYPE_STRING:
                    value = cell.getStringCellValue();
                    break;
                case XSSFCell.CELL_TYPE_NUMERIC:
                    if ("@".equals(cell.getCellStyle().getDataFormatString())) {
                        value = df.format(cell.getNumericCellValue());
                    } else if ("General".equals(cell.getCellStyle()
                            .getDataFormatString())) {
                        value = df.format(cell.getNumericCellValue());
                    } else {
                        value = sdf.format(HSSFDateUtil.getJavaDate(cell
                                .getNumericCellValue()));
                    }
                    break;
                case XSSFCell.CELL_TYPE_BOOLEAN:
                    value = cell.getBooleanCellValue();
                    break;
                case XSSFCell.CELL_TYPE_BLANK:
                    value = "";
                    break;
                default:
                    value = cell.toString();
                }
                /*if (value == null || "".equals(value)) {
                    continue;
                }*/
                linked.add(value);
            }
            list.add(linked);
        }
        return list;
    }

    /**
     * 读取Office 2007 excel
     * */
    private   static  List<List<Object>> read2007Excel(File file) throws IOException {
        List<List<Object>> list = new LinkedList<List<Object>>();
        // 构造 XSSFWorkbook 对象，strPath 传入文件路径
        XSSFWorkbook xwb = new XSSFWorkbook(new FileInputStream(file));
        // 读取第一章表格内容
        XSSFSheet sheet = xwb.getSheetAt(0);
        Object value = null;
        XSSFRow row = null;
        XSSFCell cell = null;
        int counter = 0;
        for (int i = sheet.getFirstRowNum(); counter < sheet
                .getPhysicalNumberOfRows(); i++) {
            row = sheet.getRow(i);
            if (row == null) {
                continue;
            } else {
                counter++;
            }
            List<Object> linked = new LinkedList<Object>();
            for (int j = row.getFirstCellNum(); j <= row.getLastCellNum(); j++) {
                cell = row.getCell(j);
                if (cell == null) {
                    continue;
                }
                DecimalFormat df = new DecimalFormat("0");// 格式化 number String                                          // 字符
                SimpleDateFormat sdf = new SimpleDateFormat(
                        "yyyy-MM-dd HH:mm:ss");// 格式化日期字符串
                switch (cell.getCellType()) {
                case XSSFCell.CELL_TYPE_STRING:
                    value = cell.getStringCellValue();
                    break;
                case XSSFCell.CELL_TYPE_NUMERIC:
                    if ("@".equals(cell.getCellStyle().getDataFormatString())) {
                        value = df.format(cell.getNumericCellValue());
                    } else if ("General".equals(cell.getCellStyle()
                            .getDataFormatString())) {
                        value = df.format(cell.getNumericCellValue());
                    } else {
                        value = sdf.format(HSSFDateUtil.getJavaDate(cell
                                .getNumericCellValue()));
                    }
                    break;
                case XSSFCell.CELL_TYPE_BOOLEAN:
                    value = cell.getBooleanCellValue();
                    break;
                case XSSFCell.CELL_TYPE_BLANK:
                    value = "";
                    break;
                default:
                    value = cell.toString();
                }
                /*if (value == null || "".equals(value)) {
                    continue;
                }*/
                linked.add(value);
            }
            list.add(linked);
        }
        return list;
    }

    public static void main(String[] args) {
        try {
            List<List<Object>> excleDataList=readExcel(new File("C:\\Users\\wu\\Desktop\\test.xlsx"));
            for(int i=1;i<excleDataList.size();i++){
            if(i==1){
            System.out.println("excel中的第二行,第二列的值是"+excleDataList.get(0).get(1).toString());
            }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
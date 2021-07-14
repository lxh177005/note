package com.xingxin.utils;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.*;

/**
 * 读取Excel数据
 *
 * @author zql
 * @version 1.1
 * @createTime 2020-11-30 22:54:21
 * @modifyLog 1.1 优化代码
 */
public class ReadExcelUtils {

    /**
     * 读取Excel
     *
     * @param filepath 文件路径
     * @param filename 文件名，包括扩展名
     * @param startrow 开始行号，索引从0开始
     * @param startcol 开始列号，索引从0开始
     * @param sheetnum 工作簿，索引从0开始
     * @return
     * @author zql
     * @createTime 2020-11-30 22:54:34
     */
    public static List<Map<String, String>> readExcel(String filepath, String filename, int startrow, int startcol, int sheetnum) {
        List<Map<String, String>> varList = new ArrayList<Map<String, String>>();
        if (filename.endsWith(".xls")) {
            varList = readExcel2003(filepath, filename, startrow, startcol, sheetnum);
        } else if (filename.endsWith(".xlsx")) {
            varList = readExcel2007(filepath, filename, startrow, startcol, sheetnum);
        } else {
            System.out.println("Only excel files with XLS or XLSX suffixes are allowed to be read!");
            return null;
        }
        return varList;
    }

    /**
     * 读取2003Excel
     *
     * @param filepath 文件路径
     * @param filename 文件名，包括扩展名
     * @param startrow 开始行号，索引从0开始
     * @param startcol 开始列号，索引从0开始
     * @param sheetnum 工作簿，索引从0开始
     * @return
     * @author zql
     * @createTime 2020-11-30 22:57:35
     */
    public static List<Map<String, String>> readExcel2003(String filepath, String filename, int startrow, int startcol, int sheetnum) {
        List<Map<String, String>> varList = new ArrayList<Map<String, String>>();
        try {
            File target = new File(filepath, filename);
            FileInputStream fis = new FileInputStream(target);
            HSSFWorkbook wb = new HSSFWorkbook(fis);
            fis.close();
            // sheet 从0开始
            HSSFSheet sheet = wb.getSheetAt(sheetnum);
            // 取得最后一行的行号
            int rowNum = sheet.getLastRowNum() + 1;

            HSSFRow rowTitle = sheet.getRow(0);
            // 标题行的最后一个单元格位置
            int cellTitleNum = rowTitle.getLastCellNum();
            String[] title = new String[cellTitleNum];
            for (int i = startcol; i < cellTitleNum; i++) {
                HSSFCell cell = rowTitle.getCell(Short.parseShort(String.valueOf(i)));
                if (Objects.nonNull(cell)) {
                    cell.setCellType(CellType.STRING);
                    title[i] = cell.getStringCellValue();
                } else {
                    title[i] = "";
                }
            }

            // 行循环开始
            for (int i = startrow + 1; i < rowNum; i++) {
                Map<String, String> varpd = new HashMap<String, String>();
                // 行
                HSSFRow row = sheet.getRow(i);
                // 列循环开始
                for (int j = startcol; j < cellTitleNum; j++) {
                    HSSFCell cell = row.getCell(Short.parseShort(String.valueOf(j)));
                    String cellValue = "";
                    if (Objects.nonNull(cell)) {
                        // 把类型先设置为字符串类型
                        cell.setCellType(CellType.STRING);
                        cellValue = cell.getStringCellValue();
                    }
                    varpd.put(title[j], cellValue);
                }
                varList.add(varpd);
            }
            wb.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return varList;
    }

    /**
     * 读取2007Excel
     *
     * @param filepath 文件路径
     * @param filename 文件名，包括扩展名
     * @param startrow 开始行号，索引从0开始
     * @param startcol 开始列号，索引从0开始
     * @param sheetnum 工作簿，索引从0开始
     * @return
     * @author zql
     * @createTime 2020-11-30 23:23:20
     */
    public static List<Map<String, String>> readExcel2007(String filepath, String filename, int startrow, int startcol, int sheetnum) {
        List<Map<String, String>> varList = new ArrayList<Map<String, String>>();
        try {
            File target = new File(filepath, filename);
            InputStream ins = new FileInputStream(target);
            XSSFWorkbook wb = new XSSFWorkbook(ins);
            ins.close();
            // 得到Excel工作表对象
            XSSFSheet sheet = wb.getSheetAt(sheetnum);
            // 取得最后一行的行号
            int rowNum = sheet.getLastRowNum() + 1;

            XSSFRow rowTitle = sheet.getRow(0);
            int cellTitleNum = rowTitle.getLastCellNum();
            String[] title = new String[cellTitleNum];
            for (int i = startcol; i < cellTitleNum; i++) {
                XSSFCell cell = rowTitle.getCell(Short.parseShort(String.valueOf(i)));
                if (Objects.nonNull(cell)) {
                    // 把类型先设置为字符串类型
                    cell.setCellType(CellType.STRING);
                    title[i] = cell.getStringCellValue();
                } else {
                    title[i] = "";
                }
            }

            // 行循环开始
            for (int i = startrow + 1; i < rowNum; i++) {
                Map<String, String> varpd = new HashMap<String, String>();
                // 得到Excel工作表的行
                XSSFRow row = sheet.getRow(i);
                // 列循环开始
                for (int j = startcol; j < cellTitleNum; j++) {
                    // 得到Excel工作表指定行的单元格
                    XSSFCell cell = row.getCell(j);
                    String cellValue = "";
                    if (Objects.nonNull(cell)) {
                        // 把类型先设置为字符串类型
                        cell.setCellType(CellType.STRING);
                        cellValue = cell.getStringCellValue();
                    }
                    varpd.put(title[j], cellValue);
                }
                varList.add(varpd);
            }
            wb.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return varList;
    }

}




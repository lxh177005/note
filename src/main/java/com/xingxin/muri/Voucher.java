package com.xingxin.muri;

import com.xingxin.utils.CSVFileUtil;
import com.xingxin.utils.ReadExcelUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author liuxh
 * @date 2021/7/14
 */
public class Voucher {
    public static void main(String[] args) {
        //读取文件
        List<Map<String, String>> mapList = ReadExcelUtils.readExcel(
                "E:\\guyi", "银行对账单.xls", 2, 0, 0);
        System.out.println("mapList = " + mapList);
    }
}

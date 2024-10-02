package com.sky.test;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

/**
 * 使用POI操作Excel文件
 */
public class POITest {

    /**
     * 通过POI创建Excel文件并且写入文件内容
     */
    public static void write() throws IOException {
        //在内存中创建一个Excel文件
        XSSFWorkbook excel = new XSSFWorkbook();
        //在Excel文件中创建一个sheet页
        XSSFSheet sheet = excel.createSheet("info");
        //在sheet页创建行对象
        XSSFRow row = sheet.createRow(1);
        row.createCell(1).setCellValue("姓名");
        row.createCell(2).setCellValue("城市");

        //创建一个新行
        row = sheet.createRow(2);
        row.createCell(1).setCellValue("张三");
        row.createCell(2).setCellValue("南京");

        row = sheet.createRow(3);
        row.createCell(1).setCellValue("李四");
        row.createCell(2).setCellValue("北京");

        //通过输出流将内存中的Excel文件写入到磁盘
        FileOutputStream out =new FileOutputStream(new File("D:\\info.xlsx"));
        excel.write(out);

        //关闭资源
        out.close();
        excel.close();
    }

    /**
     * 通过POI创建Excel文件并且读取文件内容
     */
    public static void read() throws IOException {
        FileInputStream in = new FileInputStream(new File("D:\\info.xlsx"));
        //读取磁盘上已经存在的Excel文件
        XSSFWorkbook excel = new XSSFWorkbook(in);
        //读取Excel文件中的第一个sheet页
        XSSFSheet sheet = excel.getSheetAt(0);

        //获取sheet页中最后一行的行号
        int lastRowNum = sheet.getLastRowNum();

        for (int i = 1; i <= lastRowNum; i++) {
            //获得某一行
            XSSFRow row = sheet.getRow(i);
            //获得单元格对象
            String cellValue1 = row.getCell(1).getStringCellValue();
            String cellValue2 = row.getCell(2).getStringCellValue();

            System.out.println(cellValue1+" "+cellValue2);
        }

        //关闭资源
        in.close();
        excel.close();
    }

    public static void main(String[] args) throws IOException {
//        write();
        read();
    }
}

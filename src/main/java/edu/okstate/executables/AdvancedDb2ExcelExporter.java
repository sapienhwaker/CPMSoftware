/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.okstate.executables;

import java.io.*;
import java.sql.*;
 
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;
 
/**
 * A simple Java program that exports data from database to Excel file.
 * @author Nam Ha Minh
 * (C) Copyright codejava.net
 */
public class AdvancedDb2ExcelExporter {
 
    public static void goToExport(int description) {
        new AdvancedDb2ExcelExporter().export(description);
    }
     
    public void export(int description) {
        String jdbcURL = "jdbc:mysql://10.227.113.64:3306/stepbystep?allowPublicKeyRetrieval=TRUE";
        String username = "username";
        String password = "password";
 
        String excelFilePath = "Reviews"+ CurrentDateTime.get()+"-export.xlsx";
 
        try (Connection connection = DriverManager.getConnection(jdbcURL, username, password)) {
            String sql = "SELECT Project_ID, Template_Activity_Name, Activity_Duration, Activity_Task_Predecessor_Logic FROM project_data_full where Project_ID="+description;
 
            Statement statement = connection.createStatement();
 
            ResultSet result = statement.executeQuery(sql);
 
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("Reviews");
 
            writeHeaderLine(sheet);
 
            writeDataLines(result, workbook, sheet);
 
            FileOutputStream outputStream = new FileOutputStream(excelFilePath);
            workbook.write(outputStream);
            workbook.close();
 
            statement.close();
 
        } catch (SQLException e) {
            System.out.println("Datababse error:");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("File IO error:");
            e.printStackTrace();
        }
    }
 
    private void writeHeaderLine(XSSFSheet sheet) {
 
        Row headerRow = sheet.createRow(0);
 
        Cell headerCell = headerRow.createCell(0);
        headerCell.setCellValue("Task Mode");
 
        headerCell = headerRow.createCell(1);
        headerCell.setCellValue("Name");
 
        headerCell = headerRow.createCell(2);
        headerCell.setCellValue("Duration");
 
        headerCell = headerRow.createCell(3);
        headerCell.setCellValue("Predecessors");
 
    }
 
    private void writeDataLines(ResultSet result, XSSFWorkbook workbook,
            XSSFSheet sheet) throws SQLException {
        int rowCount = 1;
 
        while (result.next()) {
            String taskMode = "Auto Schedule";
            String taskName = result.getString("Template_Activity_Name");
            String duration = Double.toString(result.getDouble("Activity_Duration"));
            String predecessors = result.getString("Activity_Task_PredecesSor_Logic");
 
            Row row = sheet.createRow(rowCount++);
 
            int columnCount = 0;
            Cell cell = row.createCell(columnCount++);
            cell.setCellValue(taskMode);
 
            cell = row.createCell(columnCount++);
            cell.setCellValue(taskName);
 
            cell = row.createCell(columnCount++);
            cell.setCellValue(duration);
 
            cell = row.createCell(columnCount++);
            cell.setCellValue(predecessors);
        }
    }
 
}
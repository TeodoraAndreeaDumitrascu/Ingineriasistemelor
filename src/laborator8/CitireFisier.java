package laborator8;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

public class CitireFisier {

    public static void main(String[] args) {
        readFile();
        generateFile();
    }

    public static void readFile() {
        XSSFWorkbook workbook = null;
        try {
            FileInputStream file = new FileInputStream(new
                    File("laborator8_input.xlsx"));
            //Create Workbook instance holding reference to .xlsx file
            workbook = new XSSFWorkbook(file);
            //Get first/desired sheet from the workbook
            XSSFSheet sheet = workbook.getSheetAt(0);
            //Iterate through each rows one by one
            for (Row row : sheet) {
                //For each row, iterate through all the columns
                for (Cell cell : row) {
                    //Check the cell type and format accordingly
                    switch (cell.getCellType()) {
                        case NUMERIC:
                            System.out.print(cell.getNumericCellValue() + "\t");
                            break;
                        case STRING:
                            System.out.print(cell.getStringCellValue() + "\t");
                            break;
                    }
                }
                System.out.println();
            }
            file.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void generateFile() {
        XSSFWorkbook workbook1 = new XSSFWorkbook();
        XSSFSheet sheet1 = workbook1.createSheet("Students");

        // Definim stilurile pentru formatare
        // Stil pentru header (bold)
        XSSFFont headerFont = workbook1.createFont();
        headerFont.setBold(true);
        XSSFCellStyle headerStyle = workbook1.createCellStyle();
        headerStyle.setFont(headerFont);


        // Stil pentru fundal galben pe ultimele două coloane
        XSSFCellStyle yellowCellStyle = workbook1.createCellStyle();
        yellowCellStyle.setFillForegroundColor(IndexedColors.LIGHT_YELLOW.getIndex());
        yellowCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        // Stil pentru fundal verde pe primul rând
        XSSFCellStyle headerGreenStyle = workbook1.createCellStyle();
        headerGreenStyle.setFont(headerFont); // Aplicăm fontul bold
        headerGreenStyle.setFillForegroundColor(IndexedColors.LIGHT_GREEN.getIndex());
        headerGreenStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        // Structura de date pentru stocarea informațiilor
        Map<String, Object[]> data = new TreeMap<String, Object[]>();
        data.put("1", new Object[]{"Name", "Surname", "Grade 1", "Grade 2", "Grade 3", "Grade 4", "Max", "Average"});
        data.put("2", new Object[]{"Amit", "Shukla", 9, 8, 7, 5, 9, 7});
        data.put("3", new Object[]{"Lokesh", "Gupta", 8, 9, 6, 7, 9, 7.5});
        data.put("4", new Object[]{"John", "Adwards", 8, 8, 7, 6, 8, 7});
        data.put("5", new Object[]{"Brian", "Schultz", 7, 6, 8, 9, 9, 8});
        data.put("6", new Object[]{"Andreea", "Dumitrascu", 7, 6, 8, 9, 9, 8});
        data.put("7", new Object[]{"Radu","Nicolae",10,10,9,9,2,3});

        // Scriem datele în fișierul Excel
        int rowNum = 0;
        for (String key : data.keySet()) {
            Row row = sheet1.createRow(rowNum++);
            Object[] objArr = data.get(key);
            int cellNum = 0;

            for (Object obj : objArr) {
                Cell cell = row.createCell(cellNum);

                // Aplicăm formatarea
                if (rowNum == 1) {
                    // Header bold
                    cell.setCellStyle(headerStyle);
                    cell.setCellStyle(headerGreenStyle);
                }

                // Aplicăm formatare pentru celule
                if (cellNum == 6 || cellNum == 7) { // Coloanele G și H (Max și Average)
                    if (rowNum > 1) { // Nu aplicăm pe header
                        cell.setCellStyle(yellowCellStyle);
                    }
                }

                // Setăm valoarea celulei
                if (obj instanceof String) {
                    cell.setCellValue((String) obj);
                } else if (obj instanceof Integer) {
                    cell.setCellValue((Integer) obj);
                } else if (obj instanceof Double) {
                    cell.setCellValue((Double) obj);
                }

                cellNum++;
            }
        }

        // Setăm formulele pentru coloanele G și H
        int totalDataRows= data.size()-1;//scadem 1 pentru header
        for (int i = 1; i <= totalDataRows; i++) {
            // Formula pentru Max (coloana G)
            Row row = sheet1.getRow(i);
            Cell cellMax = row.getCell(6);
            cellMax.setCellFormula("MAX(C" + (i + 1) + ":F" + (i + 1) + ")");

            // Formula pentru Average (coloana H)
            Cell cellAvg = row.getCell(7);
            cellAvg.setCellFormula("AVERAGE(C" + (i + 1) + ":F" + (i + 1) + ")");
        }

        // Ajustăm lățimea coloanelor
        for (int i = 0; i < 8; i++) {
            sheet1.autoSizeColumn(i);
        }

        try {
            // Scriem workbook-ul într-un fișier
            FileOutputStream out = new FileOutputStream("output8.xlsx");
            workbook1.write(out);  // Important: folosim workbook1, nu workbook
            out.close();
            System.out.println("Fișierul Excel a fost creat cu succes!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
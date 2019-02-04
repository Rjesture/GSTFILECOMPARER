package Book.Book;

import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileOutputStream;
import java.io.IOException;

public class Writer {
    private static String[] columns = {"GstNo", "Name", "Billno", "Date", "Total", "Tvalue", "Igst", "Cgst", "Sgst","Source"};
    public String Write(List<Entries> entries,String file) throws IOException, InvalidFormatException {
        // Create a Workbook
        Workbook workbook = new XSSFWorkbook();     // new HSSFWorkbook() for generating `.xls` file

        /* CreationHelper helps us create instances for various things like DataFormat,
           Hyperlink, RichTextString etc in a format (HSSF, XSSF) independent way */
//        CreationHelper createHelper = workbook.getCreationHelper();

        // Create a Sheet
        Sheet sheet = workbook.createSheet("Employee");

        // Create a Font for styling header cells
        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 14);
        headerFont.setColor(IndexedColors.RED.getIndex());


        // Create a CellStyle with the font
        CellStyle headerCellStyle = workbook.createCellStyle();
        headerCellStyle.setFont(headerFont);

//
        DataFormat format = workbook.createDataFormat();
        CellStyle dateStyle = workbook.createCellStyle();
        dateStyle.setDataFormat(format.getFormat("dd.mm.yyyy"));

        // Create a Row
        Row headerRow = sheet.createRow(0);

        // Creating cells
        for(int i = 0; i < columns.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(columns[i]);
            cell.setCellStyle(headerCellStyle);
        }
        // Create Other rows and cells with employees data
        int rowNum = 1;
        for(Entries entry: entries) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(9)
                    .setCellValue(entry.getSource());
            row.createCell(0)
                    .setCellValue(entry.getGstno());
            row.createCell(1)
                    .setCellValue(entry.getName());
            row.createCell(2)
                    .setCellValue(entry.getBillno());
            Cell C_Date=row.createCell(3);
                    C_Date.setCellStyle(dateStyle);
                    C_Date.setCellValue(entry.getDate());
            row.createCell(4)
                    .setCellValue(entry.getTotal());
            row.createCell(5)
                    .setCellValue(entry.getTvalue());
            row.createCell(6)
                    .setCellValue(entry.getIgst());
            row.createCell(7)
                    .setCellValue(entry.getCgst());
            row.createCell(8)
                    .setCellValue(entry.getSgst());
//            row.createCell(9)
//                    .setCellValue(entry.getSource());
        }
        // Resize all columns to fit the content size
        for(int i = 0; i < columns.length; i++) {
            sheet.autoSizeColumn(i);
        }
        // Write the output to a file
        FileOutputStream fileOut = new FileOutputStream(file+".xlsx");
        workbook.write(fileOut);
        fileOut.close();
        workbook.close();
        return file+".xlsx";
    }
}

package Book.Book;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Reader {
     int c,j=0;
    String gstno="null";
    String name="null";
    String billno="null";
    Date date = new Date();
    double total=0;
    double tvalue=0;
    double igst=0;
    double cgst=0;
    double sgst=0;
   public List<Entries> read(String excelFilePath, String sheet, List<Entries> entries) throws IOException {
       int i=0;
       c=2;
        //String excelFilePath = "C:\\Users\\Rjesture\\Desktop\\New Folder\\5.xlsx";
        FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet firstSheet = workbook.getSheetAt(0);
        Iterator<Row> iterator = firstSheet.iterator();
//        try {
            while (iterator.hasNext()) {
                Row nextRow = iterator.next();
                Iterator<Cell> cellIterator = nextRow.cellIterator();
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    i = cell.getRowIndex();
                    j = cell.getColumnIndex();
                    if (i > 0) {
                        switch (j){
                            case 0:
                                gstno = cell.getStringCellValue();
                                break;
                            case 1:
                                name = cell.getStringCellValue();
                                break;
                            case 2:
                                billno = cell.getStringCellValue();
                                break;
                            case 3:
                                date=cell.getDateCellValue();
                                break;
                            case 4:
                                total = cell.getNumericCellValue();
                                break;
                            case 5:
                                tvalue = cell.getNumericCellValue();
                                break;
                            case 6:
                                igst = cell.getNumericCellValue();
                                break;
                            case 7:
                                cgst = cell.getNumericCellValue();
                                break;
                            case 8:
                                sgst = cell.getNumericCellValue();
                                break;
                            default:
                                System.out.print("cell");
                        }
                    } else continue;
                }
                if(i>0) {
                    entries.add(new Entries(gstno,name,billno,date,total,tvalue,igst,cgst,sgst,sheet));
                    gstno="null";
                    name="null";
                    billno="null";
                    total=0;
                    tvalue=0;
                    igst=0;
                    cgst=0;
                    sgst=0;
                    c++;
                }
            }
        workbook.close();
        inputStream.close();
        return entries;

    }
}

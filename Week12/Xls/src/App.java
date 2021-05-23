import java.io.File;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class App {
    public static void main(String[] args) {
        try {
            File file = new File("src\\excel.xls");
            Workbook workbook = Workbook.getWorkbook(file);
            Sheet sheet = workbook.getSheet(0);
            int col = sheet.getColumns();
            int row = sheet.getRows();
            System.out.println("ÁÐ£º" + col + " ÐÐ£º" + row);
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    Cell cell = sheet.getCell(j, i);
                    String s = cell.getContents();
                    System.out.print(s + "\t");
                }
                System.out.println();
            }
            Cell cell = sheet.getCell(0, 2);
            System.out.println(cell);
            workbook.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

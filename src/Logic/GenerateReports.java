/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logic;

/**
 *
 * @author Anushka Lakshan
 */

import java.io.*;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import jxl.Workbook;
import jxl.write.*;
import jxl.write.Number;

public class GenerateReports {
    
    
    
    public void generate(JTable bookTable){
        JFileChooser fileChooser = new JFileChooser();
                int choice;
                choice = fileChooser.showSaveDialog(null);
                if (choice == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();
                    
                    // Append .xls extension to the file name if not present
                    String filePath = file.getAbsolutePath();
                    if (!filePath.endsWith(".xls")) {
                        file = new File(filePath + ".xls");
                    }
                    
                    try {
                        WritableWorkbook workbook = Workbook.createWorkbook(file);
                        WritableSheet sheet = workbook.createSheet("Report", 0);

                        // Get the table data
                        TableModel model = bookTable.getModel();
                        int rowCount = model.getRowCount();
                        int columnCount = model.getColumnCount();

                        // Create a bold font
                        WritableFont boldFont = new WritableFont(WritableFont.ARIAL, 12, WritableFont.BOLD);
                        WritableCellFormat boldFormat = new WritableCellFormat(boldFont);

                        // Write table headers with bold formatting
                        for (int column = 0; column < columnCount; column++) {
                            String columnName = model.getColumnName(column);
                            Label label = new Label(column, 0, columnName, boldFormat);
                            sheet.addCell(label);
                        }

                        // Write table data
                        for (int row = 0; row < rowCount; row++) {
                            for (int column = 0; column < columnCount; column++) {
                                Object value = model.getValueAt(row, column);
                                if (value instanceof Number) {
                                    Number num = new Number(column, row + 1, ((Number) value).getValue());
                                    sheet.addCell(num);
                                } else {
                                    Label label = new Label(column, row + 1, value.toString());
                                    sheet.addCell(label);
                                    
                                }
                            }
                        }

                        workbook.write();
                        workbook.close();

                        JOptionPane.showMessageDialog(null, "Report exported successfully!");
                    } catch (IOException | WriteException ex) {
                       
                        JOptionPane.showMessageDialog(null, "Report export failed!");
                    }
                }
            
    }
}

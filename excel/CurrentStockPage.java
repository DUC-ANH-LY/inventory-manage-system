/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inventory.UI;

import com.inventory.DAO.ProductDAO;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import java.sql.SQLException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author asjad
 */
public class CurrentStockPage extends javax.swing.JPanel {


    String username;
    /**
     * Creates new form CurrentStockPage
     */
    
    public CurrentStockPage(String username) {
        initComponents();
        this.username = username;
        loadDataSet();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        stockTable = new javax.swing.JTable();
        refreshButton = new javax.swing.JButton();
        ExportButton = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        jLabel1.setText("CURRENT STOCK");
        jLabel1.setToolTipText("");

        stockTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(stockTable);

        refreshButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        refreshButton.setText("REFRESH");
        refreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshButtonActionPerformed(evt);
            }
        });

        ExportButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        ExportButton.setText("EXPORT");
        ExportButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExportButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 701, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(refreshButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ExportButton)
                        .addGap(8, 8, 8)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(refreshButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ExportButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(88, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButtonActionPerformed
        loadDataSet();
    }//GEN-LAST:event_refreshButtonActionPerformed

    private void ExportButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExportButtonActionPerformed
        try
        {
        XSSFWorkbook wordbook = new XSSFWorkbook();
        XSSFSheet sheet=wordbook.createSheet("Current Stock");
        XSSFRow row =null;
        Cell cell=null;
        
        XSSFCellStyle borderStyle = wordbook.createCellStyle();
        borderStyle.setBorderTop(BorderStyle.THIN);
        borderStyle.setBorderBottom(BorderStyle.THIN);
        borderStyle.setBorderLeft(BorderStyle.THIN);
        borderStyle.setBorderRight(BorderStyle.THIN);
        
        row=sheet.createRow(3);
        
        cell=row.createCell(0,CellType.STRING);
        cell.setCellValue("STT");
        cell.setCellStyle(borderStyle);
        
        cell=row.createCell(1,CellType.STRING);
        cell.setCellValue("PRODUCTCODE");
        cell.setCellStyle(borderStyle);
        
        cell=row.createCell(2,CellType.STRING);
        cell.setCellValue("PRODUCTNAME");
        cell.setCellStyle(borderStyle);
        
        cell=row.createCell(3,CellType.STRING);
        cell.setCellValue("QUANTITY");
        cell.setCellStyle(borderStyle);
        
        cell=row.createCell(4,CellType.STRING);
        cell.setCellValue("COSTPRICE");
        cell.setCellStyle(borderStyle);
        
        cell=row.createCell(5,CellType.STRING);
        cell.setCellValue("CELLPRICE");
        cell.setCellStyle(borderStyle);
        
        int rowCount = stockTable.getRowCount();
        int colCount = stockTable.getColumnCount();

        for (int i = 0; i < rowCount; i++) {
            row = sheet.createRow(4+i);
            
            cell=row.createCell(0,CellType.NUMERIC);
            cell.setCellValue(i+1);
            cell.setCellStyle(borderStyle);
            
            for (int col = 0; col < colCount; col++) {
                cell = row.createCell(col + 1);
                Object cellValue = stockTable.getValueAt(i, col);
                if (cellValue instanceof String) {
                    cell.setCellValue((String) cellValue); // Đặt giá trị là chuỗi
                    cell.setCellStyle(borderStyle);
                } else if (cellValue instanceof Number) {
                    cell.setCellValue(((Number) cellValue).doubleValue()); // Đặt giá trị là số thực
                    cell.setCellStyle(borderStyle);
                }
            }
        }
        File f = showFileChooser();
        try 
        {
            FileOutputStream fis = new FileOutputStream(f);
            wordbook.write(fis);
            fis.close();
        }
        catch (FileNotFoundException ex) {
            ex.printStackTrace();
       
        }
        catch (IOException ex)
        {
          ex.printStackTrace();
        }
        
        
        JOptionPane.showMessageDialog(this, "Exported successfully!");
        
        }
        
        
        catch(Exception ex)
        {
            ex.printStackTrace();
              JOptionPane.showMessageDialog(this, "Error!");
        }
    }//GEN-LAST:event_ExportButtonActionPerformed

    private File showFileChooser() {
        JFileChooser fileChooser = new JFileChooser();

        // Thêm bộ lọc cho phép chọn tệp với phần mở rộng là ".xlsx"
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Excel Files (*.xlsx)", "xlsx");
        fileChooser.setFileFilter(filter);

        int option = fileChooser.showSaveDialog(this);

        if (option == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();

            // Kiểm tra nếu phần mở rộng là ".xlsx", nếu không, thêm nó vào
            String filePath = selectedFile.getAbsolutePath();
            if (!filePath.toLowerCase().endsWith(".xlsx")) {
                selectedFile = new File(filePath + ".xlsx");
            }

            return selectedFile;
        } else {
            return null;
        }
    }
    // Method to load data into the table
    public void loadDataSet() {
        try {
            ProductDAO productDAO = new ProductDAO();
            stockTable.setModel(productDAO.buildTableModel(productDAO.getCurrentStockInfo()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ExportButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton refreshButton;
    private javax.swing.JTable stockTable;
    // End of variables declaration//GEN-END:variables
}

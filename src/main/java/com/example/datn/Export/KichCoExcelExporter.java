package com.example.datn.Export;

import com.example.datn.Entity.KichCo;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

public class KichCoExcelExporter extends AbstractExporter{
    private XSSFWorkbook workbook;
    private Sheet sheet;

    public KichCoExcelExporter() {
        workbook = new XSSFWorkbook();
    }

    private void writeHeaderLine() {
        sheet = workbook.createSheet("Kích Cỡ");
        Row row = sheet.createRow(0);

        CellStyle cellStyle = workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setBold(true);
        font.setFontHeightInPoints((short) 16);
        cellStyle.setFont(font);

        createCell(row, 0, "Size ID", cellStyle);
        createCell(row, 1, "Name", cellStyle);
        createCell(row, 2, "Description", cellStyle);
        createCell(row, 3, "DateUpdated", cellStyle);
        createCell(row, 4, "Enabled", cellStyle);
    }

    private void createCell(Row row, int columnIndex, Object value, CellStyle style) {
        Cell cell = row.createCell(columnIndex);
        sheet.autoSizeColumn(columnIndex);

        if (value instanceof Integer) {
            cell.setCellValue((Integer) value);
        } else if (value instanceof Boolean) {
            cell.setCellValue((Boolean) value);
        }
        else if (value instanceof Date) {
            cell.setCellValue((Date) value);
        }
        else {
            cell.setCellValue(value.toString());
        }

        if (style != null) {
            cell.setCellStyle(style);
        }
    }

    public void export(List<KichCo> listKichCo, HttpServletResponse response) throws IOException {
        super.setResponseHeader(response, "application/octet-stream", ".xlsx","size_");

        writeHeaderLine();
        writeDataLines(listKichCo);

        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
    }

    private void writeDataLines(List<KichCo> listKichCo) {
        int rowIndex = 1;

        CellStyle cellStyle = workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setFontHeightInPoints((short) 14);
        cellStyle.setFont(font);

        for (KichCo KichCo : listKichCo) {
            Row row = sheet.createRow(rowIndex++);
            int columnIndex = 0;
            createCell(row, columnIndex++, KichCo.getIdKichCo(), cellStyle);
            createCell(row, columnIndex++, KichCo.getTenKichCo(), cellStyle);
            createCell(row, columnIndex++, KichCo.getMoTaKichCo(), cellStyle);
            createCell(row, columnIndex++, KichCo.getNgayTaoKichCo(), cellStyle);
            createCell(row, columnIndex++, KichCo.isEnabled(), cellStyle);
        }
    }
}

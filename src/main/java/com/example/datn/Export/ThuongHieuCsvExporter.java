package com.example.datn.Export;

import com.example.datn.Entity.ThuongHieu;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ThuongHieuCsvExporter extends AbstractExporter{
    public void export(List<ThuongHieu> listThuongHieu, HttpServletResponse response)throws IOException {
        super.setResponseHeader(response,"text/csv",".csv","brands_");

        ICsvBeanWriter csvBeanWriter = new CsvBeanWriter(response.getWriter(),
                CsvPreference.STANDARD_PREFERENCE);
        String[] csvHeader = {"ID","Name","Description","Enabled"};
        String[] filedMapping = {"idThuongHieu","tenThuongHieu","moTaThuongHieu","enabled"};

        csvBeanWriter.writeHeader(csvHeader);
        for (ThuongHieu thuongHieu: listThuongHieu){
            csvBeanWriter.write(thuongHieu,filedMapping);
        }
        csvBeanWriter.close();
    }
}

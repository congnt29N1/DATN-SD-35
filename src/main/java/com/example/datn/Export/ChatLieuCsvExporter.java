package com.example.datn.Export;

import com.example.datn.Entity.ChatLieu;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ChatLieuCsvExporter extends AbstractExporter {
    public void export(List<ChatLieu> listChatLieu, HttpServletResponse response)throws IOException {
        super.setResponseHeader(response,"text/csv",".csv","material_");

        ICsvBeanWriter csvBeanWriter = new CsvBeanWriter(response.getWriter(),
                CsvPreference.STANDARD_PREFERENCE);
        String[] csvHeader = {"ID","Name","Description","Enabled"};
        String[] filedMapping = {"idChatLieu","tenChatLieu","moTaChatLieu","enabled"};

        csvBeanWriter.writeHeader(csvHeader);
        for (ChatLieu chatLieu: listChatLieu){
            csvBeanWriter.write(chatLieu,filedMapping);
        }
        csvBeanWriter.close();
    }
}

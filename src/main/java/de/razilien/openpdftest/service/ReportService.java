package de.razilien.openpdftest.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;

@Service
public class ReportService {

    @Value("${exportdir}")
    private String exportDirectory;

    public void exportReport() throws IOException, JRException {
        try (OutputStream stream = new FileOutputStream(createDestinationFile())) {
            stream.write(JasperRunManager.runReportToPdf(getReport(), new HashMap<>(), new JREmptyDataSource()));
        }
    }

    private JasperReport getReport() throws IOException, JRException {
        final InputStream template = new ClassPathResource("reports/test.jrxml").getInputStream();
        return JasperCompileManager.compileReport(template);
    }

    private String createDestinationFile() {
        return new File(exportDirectory,
                LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS")).concat("_report.pdf"))
                        .getAbsolutePath();
    }

}

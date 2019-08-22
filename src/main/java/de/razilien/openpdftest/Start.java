package de.razilien.openpdftest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import de.razilien.openpdftest.service.ReportService;

@SpringBootApplication
public class Start implements CommandLineRunner {

    @Autowired
    private ReportService reportService;

    public static void main(final String[] args) {
        SpringApplication.run(Start.class, args);
    }

    @Override
    public void run(final String... args) throws Exception {
        reportService.exportReport();
    }

}

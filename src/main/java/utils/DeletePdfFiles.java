package utils;

import io.cucumber.java.After;
import io.cucumber.java.Before;

import java.io.File;

public class DeletePdfFiles {
    private static final String DOWNLOADED_PDF_FILES_PATH = "/Users/jortizf/Downloads";
    private static final String STATEMENT_FILE_NAME = "Tarifario-Cuentas-de-Depositos";

    @Before("@automatizacion")
    @After("@automatizacion")
    public static void statementsDownloaded() {
        File downloadsDirectory = new File(DOWNLOADED_PDF_FILES_PATH);
        for (File file : downloadsDirectory.listFiles()) {
            if (isAStatement(file.getName())) {
                file.delete();
            }
        }
    }

    private static boolean isAStatement(String fileName) {
        if (fileName.contains(STATEMENT_FILE_NAME)) {
            return true;
        }
        return false;
    }
}

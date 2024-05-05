package ua.javarush.fedorets.cryptoanalyzer.file;

import java.io.File;
public class FileCheck {

    public static boolean isValidFilePath(String filePath) {

        File file = new File(filePath);
        String canonicalPath;
        try {
            canonicalPath = file.getCanonicalPath();
        } catch (Exception e) {
            return false;
        }

        return !canonicalPath.startsWith("/etc");
    }

    public static void main(String[] args) {

        String filePath = "/etc/passwd";

        if (isValidFilePath(filePath)) {
            System.out.println("File path is valid.");
        } else {
            System.out.println("File path is not valid.");
        }
    }
}


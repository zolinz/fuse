package zoli.backend;

import org.springframework.util.ResourceUtils;

public class FileUtils extends org.apache.commons.io.FileUtils{
	 /**
     * Handy class to read file from class path 
     */
    public static String readFile(String reference) {
        try {
            return FileUtils.readFileToString(ResourceUtils.getFile("classpath:" + reference));
        } catch (Exception e) {
           throw new RuntimeException("Can read file: "+ reference);
        }
    }
}

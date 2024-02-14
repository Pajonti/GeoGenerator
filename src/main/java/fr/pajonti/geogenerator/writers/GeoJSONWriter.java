package fr.pajonti.geogenerator.writers;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class GeoJSONWriter {
    public static void writeToFile(String path, String file, String content) throws IOException {
        String pathName = path + "/" + file;
        Files.createDirectories(Paths.get(path));

        File f = new File(pathName);
        if(!f.exists()){
            Files.createFile(Paths.get(pathName));
        }

        FileWriter fw = new FileWriter(pathName, true);
        fw.write(content);
        fw.write("\n");
        fw.close();
    }
}

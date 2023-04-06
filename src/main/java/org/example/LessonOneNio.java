package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class LessonOneNio {
    public static void main(String[] args) throws IOException {
        //Path - обьект
        //Paths - содержит методы и создает обьекты
        Path file = Paths.get("folder\\text.txt");
        Path folder = Paths.get("C:\\Users\\pavel\\IdeaProjects\\MagazineCar");
        Path folder2 = Paths.get("C:\\Users\\pavel\\IdeaProjects\\MagazineCar\\newPackage");

//        System.out.println("folder\\text.txt" + "C:\\Users\\pavel\\IdeaProjects\\MagazineCar");
//        System.out.println(folder.resolve(file));
//        System.out.println(folder.relativize(folder2));

        Path filePath = Paths.get("text.txt");
        Path filePathTwo = Paths.get("C:\\Users\\pavel\\IdeaProjects\\MagazineCar\\src\\main\\java\\org\\example\\text.txt");
        Path folderPath = Paths.get("C:\\Users\\pavel\\IdeaProjects\\MagazineCar\\folder");

        System.out.println(filePath.getFileName());
        System.out.println(folderPath.getFileName());

        System.out.println(filePath.getParent());
        System.out.println(folderPath.getParent());

        System.out.println(filePath.getRoot());
        System.out.println(folderPath.getRoot());

        System.out.println(filePath.isAbsolute());
        System.out.println(folderPath.isAbsolute());

        System.out.println(filePath.toAbsolutePath());

        if (!filePath.isAbsolute()) {
            filePath = Paths.get(String.valueOf(filePath.toAbsolutePath()));
            System.out.println(filePath.isAbsolute());
        }

        System.out.println(Files.isReadable(filePath));
        System.out.println(Files.isWritable(filePath));
        System.out.println(Files.isExecutable(filePath));
        System.out.println(Files.isHidden(filePath));
        System.out.println(Files.isDirectory(filePath));

        System.out.println(Files.size(filePath));

        Map<String, Object> attribute = Files.readAttributes(filePath, "*");

        for (Map.Entry<String, Object> entry : attribute.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        System.out.println(Files.readAttributes(filePath, "creationTime"));

        // walkFileTree -> узнать, написать его
    }
}
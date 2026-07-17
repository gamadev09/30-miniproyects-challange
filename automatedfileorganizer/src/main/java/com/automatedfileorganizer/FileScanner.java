package com.automatedfileorganizer;
import java.io.File;
import java.util.Objects;

public class FileScanner {

    private final ExtensionMapper mapper;
    public FileScanner(ExtensionMapper mapper){
        this.mapper = Objects.requireNonNull(mapper);
    }

    public void scan(String path){
        File directory = new File(path);
        
        if(!directory.exists()){
            System.out.println("Directory does not exist. / El directorio no existe.");
        return;
        }

        File[] files = directory.listFiles();

        if (files == null) {
            System.out.println("Cannot read directory. / No se puede leer el directorio.");
            return;
        }


        for (File file : files) {
            if (file.isFile()) {
                System.out.println(file.getName() + " -> " + mapper.getCategory(file));
            }
        }
    }
}
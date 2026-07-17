package com.automatedfileorganizer;
import java.io.File;
import java.util.Objects;

public class FileScanner {

    private final ExtensionMapper mapper;
    private final FileOrganizer organizer;

    public FileScanner(
        ExtensionMapper mapper,
        FileOrganizer organizer
    ){
        this.mapper = Objects.requireNonNull(mapper)
        this.organizer = Objects.requireNonNull(organizer)
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
                String category = mapper.getCategory(file);

                System.out.println(
                    file.getName() + " -> " + category 
                );
                organizer.organize(file, category);
            }
        }
    }
}
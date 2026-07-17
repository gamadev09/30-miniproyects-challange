package com.automatedfileorganizer;
import java.io.File;
import java.util.Objects;

public class FileScanner {

    private final ExtensionMapper mapper;
    private final FileOrganizer organizer;
    private final Logger logger;

    public FileScanner(
        ExtensionMapper mapper,
        FileOrganizer organizer,
        Logger logger
    ){
        this.mapper = Objects.requireNonNull(mapper);
        this.organizer = Objects.requireNonNull(organizer);
        this.logger = Objects.requireNonNull(logger);
    }

    public void scan(String path){

        File directory = new File(path);
        
        if(!directory.exists()){

            String message =
                "Directory does not exist. / El directorio no existe.";

            System.out.println(message);
            logger.write(message);

            return;
        }

        scanDirectory(directory);
    }


    private void scanDirectory(File directory){

        File[] files = directory.listFiles();

        if(files == null){

            String message =
                "Cannot read directory. / No se puede leer el directorio.";

            System.out.println(message);
            logger.write(message);

            return;
        }


        for(File file : files){

            if(file.isDirectory()){

                scanDirectory(file);

            }
            else if(file.isFile()){

                String category = mapper.getCategory(file);

                String message =
                    file.getName() + " -> " + category;

                System.out.println(message);
                logger.write(message);

                organizer.organize(file, category);
            }
        }
    }
}
package com.automatedfileorganizer;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Objects;

public class FileOrganizer {

    private final Logger logger;

    public FileOrganizer(Logger logger){
        this.logger = Objects.requireNonNull(logger);
    }

    public void organize(File file, String category){

        if("unknown".equals(category)){

            String message =
                "Skipped unknown file. / Archivo desconocido omitido: "
                + file.getName();

            System.out.println(message);
            logger.write(message);

            return;
        }

        File parentFolder = file.getParentFile();

        if(parentFolder == null){

            String message =
                "Cannot find parent folder: "
                + file.getName();

            System.out.println(message);
            logger.write(message);

            return;
        }


        File categoryFolder = new File(
            parentFolder,
            category
        );


        if(!categoryFolder.exists()){
            categoryFolder.mkdirs();
        }


        File destination = new File(
            categoryFolder,
            file.getName()
        );


        if(destination.exists()){

            String message =
                "File already exists. / El archivo ya existe: "
                + file.getName();

            System.out.println(message);
            logger.write(message);

            return;
        }


        try {

            Files.move(
                file.toPath(),
                destination.toPath()
            );


            String message =
                file.getName()
                + " moved to / se movio a "
                + category;


            System.out.println(message);
            logger.write(message);


        } catch (IOException e){

            String message =
                "Cannot move / No se puede mover: "
                + file.getName();


            System.out.println(message);
            logger.write(message);

            logger.write(e.getMessage());
        }
    }
}
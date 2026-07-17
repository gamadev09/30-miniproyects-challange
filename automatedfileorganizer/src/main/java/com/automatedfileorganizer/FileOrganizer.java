package com.automatedfileorganizer;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class FileOrganizer {

    public void organize(File file, String category){

        if(category.equals("unknown")){
            System.out.println(
                "Skipped unknown file. / Archivo desconocido omitido: "
                + file.getName()
            );
            return;
        }

        File parentFolder = file.getParentFile();

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
            System.out.println(
                "File already exists. / El archivo ya existe: "
                + file.getName()
            );
            return;
        }

        try {

            Files.move(
                file.toPath(),
                destination.toPath(),
                StandardCopyOption.REPLACE_EXISTING
            );

            System.out.println(
                file.getName()
                + " moved to / se movio a "
                + category
            );

        } catch (IOException e){

            System.out.println(
                "Cannot move / No se puede mover: "
                + file.getName()
            );

            e.printStackTrace();
        }
    }
}
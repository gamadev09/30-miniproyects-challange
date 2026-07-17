package com.automatedfileorganizer;
import java.io.File;

public class FileOrganizer {

    public void organize(File file, String category){
        File parentFolder = file.getParentFile();

        File categoryFolder = new File(parentFolder, category);

        if(!categoryFolder.exists()){
            categoryFolder.mkdirs();
        }

        File destination = new File(
            categoryFolder,
            file.getName()
        );

        if(file.renameTo(destination)){
            System.out.println(
                file.getName() + " moved to. / se movio a. " + category
            );
        }
        else{
            System.out.println(
                "Cannot move. / No se puede mover. " + file.getName()
            );
        }
    }

}

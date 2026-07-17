package com.automatedfileorganizer;
import java.io.File;

public class FileOrganizer {

    public void organize(File file, String category){
        File parentfolder = file.getParentFile();

        File categoryfolder = new File(parentfolder, category);

        if(!categoryfolder.exists()){
            categoryfolder.mkdir();
        }

        File destination = new File(
            categoryfolder,
            file.getName()
        );

        if(file.renameTo(destination)){
            System.out.println(
                file.getName() + " moved to. / se movio a. " + category
            );
        }
        else{
            System.out.println(
                " Cannot move. / No se puede mover. " + file.getName()
            );
        }
    }

}

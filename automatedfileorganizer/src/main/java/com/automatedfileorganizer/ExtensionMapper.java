package com.automatedfileorganizer;
import java.io.File;


public class ExtensionMapper {
    public String getCategory(File file){
        
        String name = file.getName();
        
        int dotIndex = name.lastIndexOf(".");

        if(dotIndex == -1){
            return "unknown";
        }

        String extension = name.substring(dotIndex).toLowerCase();

    }
}

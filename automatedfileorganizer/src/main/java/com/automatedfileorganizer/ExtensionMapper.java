package com.automatedfileorganizer;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


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

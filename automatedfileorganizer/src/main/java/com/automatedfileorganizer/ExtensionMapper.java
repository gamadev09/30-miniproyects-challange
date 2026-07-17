package com.automatedfileorganizer;
import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Objects;


public class ExtensionMapper {

    private static final String UNKNOWN = "unknown";

    private final Map<String, List<String>> categories;

    public ExtensionMapper(Map<String, List<String>> categories){
        this.categories = Objects.requireNonNull(categories);
    }
    public String getCategory(File file){
        
        String name = file.getName();
        
        int dotIndex = name.lastIndexOf(".");

        if(dotIndex == -1){
            return UNKNOWN;
        }

        String extension = name.substring(dotIndex).toLowerCase();

        for(Map.Entry<String, List<String>> entry : categories.entrySet()){

            String category = entry.getKey();
            List<String> extensions = entry.getValue();
            
            if (extensions.contains(extension)) {
                return category;
            }
        }
        return UNKNOWN;
    }
}

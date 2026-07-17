package com.automatedfileorganizer;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConfigLoader {

    public Map<String, List<String>> loadcategories(){
        ObjectMapper mapper = new ObjectMapper();

    try {
        return mapper.readValue(
            new File("config/categories.json"),
            new TypeReference<Map<String, List<String>>>() {}
                
        );
    }
    catch(IOException e){
        System.out.println("Cannot load categories file. / No se encuentra archivo de categorias");
    }
    return null;
    }
}

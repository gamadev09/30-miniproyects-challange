package automatedfileorganization.src;
import java.io.File;

public class FileScanner {
    
    public void scan(String path){
        File directory = new File(path);
        
        if(!directory.exists()){
            System.out.println("Directory does not exist. / El directorio no existe.");
        return;
        }
        File[] files = directory.listFiles();
        if (files == null) {
            System.out.println("Cannot read directory.");
            return;
        }
        ExtensionMapper mapper = new ExtensionMapper();
        for (File file : files) {
            if (file.isFile()) {
                System.out.println(file.getName() + " -> " + mapper.getCategory(file));
            }
        }
    }
}
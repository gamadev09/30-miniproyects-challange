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
        
    }
}

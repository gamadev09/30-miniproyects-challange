package automatedfileorganizer.src.main.java.com.automatedfileorganizer;
import java.io.File;

public class ExtensionMapper {
    public String getCategory(File file){
        
        String name = file.getName();
        
        int dotIndex = name.lastIndexOf(".");

        if(dotIndex == -1){
            return "unknown";
        }

        String extension = name.substring(dotIndex).toLowerCase();

        switch(extension){
                        case ".jpg":
            case ".jpeg":
            case ".png":
                return "images";

            case ".psd":
                return "photoshop";

            case ".mp3":
            case ".wav":
                return "music";

            case ".mp4":
            case ".mkv":
                return "videos";

            case ".pdf":
            case ".docx":
            case ".txt":
                return "documents";

            default:
                return "unknown";
        }
    }
}

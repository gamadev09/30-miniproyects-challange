package com.automatedfileorganizer;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class logs {

    private final String logFile = "logs/organizer.log";

    public Logs(){
        createLogDirectory();
    }

    private void createLogDirectory(){

        java.io.File folder = new java.io.File("logs");

        if(!folder.exists()){
            folder.mkdirs();
        }
    }


    public void write(String message){

        try(FileWriter writer = new FileWriter(logFile, true)){

            writer.write(
                "[" + LocalDateTime.now() + "] "
                + message
                + System.lineSeparator()
            );

        }catch(IOException e){

            System.out.println(
                "Cannot write log."
            );

            e.printStackTrace();
        }
    }
}
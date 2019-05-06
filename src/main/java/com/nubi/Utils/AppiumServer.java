package com.nubi.Utils;

import java.io.IOException;

public class AppiumServer {

    //Procces para ejecutar en windows
    private static Process process;

    //Comando para iniciar el appium server
    private static String STARTSERVER = "appium";


    //Iniciar el appium server
    public static void start() throws IOException, InterruptedException{
        Runtime runtime = Runtime.getRuntime();
        process = runtime.exec(STARTSERVER);
        Thread.sleep(7000);
        if(process != null){
            System.out.println("Appium server started");
        }
    }

    //Detener appium server
    public static void stop() throws IOException{
        if (process != null){
            process.destroy();
        }

        System.out.println("Appium server was stopped");
    }
}

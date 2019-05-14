package com.nubi.main;

import io.appium.java_client.android.AndroidDriver;

import java.io.IOException;

public class TestStart {

   public static AndroidDriver driver;

    public static void main(String[] args) {

        String suite ="";
        try {

            if(args[0].toUpperCase().contentEquals("RE")){
                suite = "Regresion";
                System.out.println("Ejecutando suite: "+suite);
            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Error ejecutando suite: "+suite);
        }
     }
}

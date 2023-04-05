package com.kreitek.pets.utils;

public class Logger {
    private static volatile Logger instance = null;
    private static int counter = 0;
    private Logger() {
        if(instance != null){
            throw new RuntimeException("Usage getInstance() method to create");
        }
    }
    public static Logger getInstance(){
        if(instance == null){
            synchronized(Logger.class){
                if(instance == null){
                    instance = new Logger();
                }
            }
        }
        return instance;
    }

    public void debug(String message){
        counter++;
        System.out.println("[debug]["+ counter +"]"+ " - " + message);
    }
}

package com.appium.mobile;

import io.appium.java_client.service.local.AppiumServiceBuilder;

import java.io.File;


/**
 * Created by shebbar on 18/02/17.
 */
public class LaunchAppiumProgramatically {

    private static AppiumServiceBuilder service;

    public static void main(String[] args) {
        stopAppium();
        startAppium();
        stopAppium();
    }

    public static void startAppium() {
        System.out.println("starting appium");
        service = new AppiumServiceBuilder().usingDriverExecutable(new File("/usr/local/bin/node"))
                .withAppiumJS(new File("/Applications/Appium.app/Contents/Resources/node_modules/appium/build/lib/main.js"));
        service.build().start();
    }

    public static void stopAppium() {
        System.out.println("Stopping appium");
        try {
            service.build().stop();
        } catch (Exception e){
            System.out.println("Appium is already stopped");
        }
    }


}

package com.mahagan.test;

import com.mahagan.config.ApplicationConfig;
import com.mahagan.dao.IOTDeviceImpl;
import com.mahagan.model.IOTDevice;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext= new AnnotationConfigApplicationContext(ApplicationConfig.class);
        com.mahagan.dao.IOTDevice iotDevice= applicationContext.getBean(com.mahagan.dao.IOTDevice.class);

        System.out.println("List of  device is::::");
        for (IOTDevice iotDevice1 : iotDevice.getAllDevice()) {
            System.out.println(iotDevice1);
        }
        System.out.println("Get Device to Id 1 or 2");
        //*************
        IOTDevice deviceById = iotDevice.getDeviceById(12);
        System.out.println(deviceById);
        //===========================================================
        System.out.println("Created IOD device is:");
        IOTDevice device = new IOTDevice(36, "abhi", "pune", "Robotic");
        System.out.println(device);
        iotDevice.createIotDevice(device);
        System.out.println("List of person is:");
        //***********************************************************


        for (IOTDevice iotDevice1 : iotDevice.getAllDevice()) {
            System.out.println(iotDevice1);
        }
        System.out.println("Get device to id 1 or 2");
        //=========================================================
        iotDevice.deleteDevice(deviceById);
        System.out.println(" Deleting the device with ID 2");
        //=========================================================
        System.out.println("update device with id 6");
        IOTDevice ddevice = iotDevice.getDeviceById(13);
        ddevice.setDeviceName("ppppppp");
        ddevice.setDeviceLocation("Robot");
        ddevice.setDeviceFunction("ghulewadi");


        //ddevice.setId(4);
        iotDevice.updateDevice(ddevice);
        System.out.println("Update device");
        //***********************************************
        System.out.println("List of device is");
        for(IOTDevice iotDeviceNew: iotDevice.getAllDevice()){
            System.out.println(iotDeviceNew);
        }
        applicationContext.close();
    }
}
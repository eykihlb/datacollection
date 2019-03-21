package com.mydao.datacollection.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.DecimalFormat;

@RestController
public class RecvController {

    @PostMapping("/recvdata")
    public void recvdata(@RequestParam String data){
        System.out.println(data);
    }

    public static void main(String[] args){
        String a = "2.20";
        String b = "3";
        DecimalFormat df = new DecimalFormat("#.000");
        System.out.println(df.format(Double.parseDouble(a)));
        System.out.println(df.format(Double.parseDouble(b)));
    }
}

package com.practice.helper;

import org.apache.commons.io.FileUtils;
import sun.net.www.protocol.file.FileURLConnection;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.StringJoiner;
import java.util.stream.Stream;

public class RandomGenerator {


    public static void main(String args[]){
        generateRandomInt(20, 200);
    }
    public static void generateRandomInt(int dataSize, int upperLimit){
        String tempStr = "";
        Random rg = new Random();
        StringJoiner strJoin = new StringJoiner(",");
        for(int i=0;i<dataSize;i++){
            strJoin.add(String.valueOf(rg.nextInt(upperLimit)));
        }
        try {
            System.out.println(strJoin.toString());
            FileUtils.write(new File("integer.data"), strJoin.toString());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}

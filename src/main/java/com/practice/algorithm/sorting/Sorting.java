package com.practice.algorithm.sorting;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Sorting {

    public static String[] readData(){
        File file = new File("sorting.data");
        try {
            List lines = FileUtils.readLines(file, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void sort(){

    }
}

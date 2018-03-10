package com.practice.algorithm.sorting;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sorting {

    static String[] data;
    public static void main(String[] args){
        readData();
        List<String> list = quickSort(Arrays.asList(data));
        for(String s : list){
            System.out.println(s);
        }
        printSortedData();
    }
    public static String[] readData(){
        File file = new File("integer.data");
        try {
            data = FileUtils.readFileToString(file).split(",");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void selectionSort(){
        for(int indexI=0;indexI<data.length;indexI++){
            int min_index = indexI;
            for(int indexJ = indexI+1; indexJ<data.length;indexJ++){
                if(Integer.parseInt(data[indexJ])<Integer.parseInt(data[min_index])){
                    min_index =indexJ;
                }
                String tempStr = data[indexI];
                data[indexI] = data[min_index];
                data[min_index] = tempStr;
            }
            printSortedData();
        }
    }

    public static void bubbleSort(){
        do{
            int index=0;
            boolean swap=true;
            while(index <data.length-1){
                if(Integer.parseInt(data[index])>Integer.parseInt(data[index+1])){
                    String tempStr = data[index];
                    data[index] = data[index+1];
                    data[index+1] = tempStr;
                    swap=false;
                }
                index++;
            }
            if(swap){
                break;
            }
        }while(true);

    }

    public static void insertionSort(){
        for(int i =0;i<data.length;i++) {
            String insStr = data[i];
            int j = i-1;
            while(j>=0 && Integer.parseInt(data[j])>Integer.parseInt(insStr)){
                data[j+1]=data[j];
                j=j-1;
            }
            data[j+1]=insStr;
        }
    }

    public static List<String> quickSort(List<String> list) {
        if(list.size()<2){
            return list;
        }
        String pivot = list.get(0);
        List<String> lower = new ArrayList<>();
        List<String> higher = new ArrayList<>();
        for (int i = 1; i < list.size(); i++) {
            if (Integer.parseInt(list.get(i)) < Integer.parseInt(pivot)) {
                lower.add(list.get(i));
            } else {
                higher.add(list.get(i));
            }
        }
        List<String> sortedList =  quickSort(lower);
        sortedList.add(pivot);
        sortedList.addAll(quickSort(higher));
        return sortedList;
    }

    public static void printSortedData(){
        for(String s: data){
            System.out.print(s+" ");
        }
        System.out.println();
    }
}

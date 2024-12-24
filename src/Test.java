import java.awt.event.*;
import java.io.*;

import javax.swing.*;  
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Test {
    public static boolean bruh;
    static String response = "none";
    public static void main(String[] args){

        /* int[] array = {2,34,235,6,0};
        for (int element : array){
            System.out.println("the initial list: " + element);
        }
        System.out.println("target: " + 6 + " / found index: " + BinarySearch.search(array, 0, array.length-1, 6)); */

        //System.out.println("length: " + (("").length()));

        int[] array = {-1,3,5,2,23,-1,234,5,23,4,-1};
        for (int x : array){
            System.out.println("initial array: " + x);
        }
        array = SeeCargoHistoryPage.sendEmptiesToTheEnd(array);
        for (int x : array){
            System.out.println("second array: " + x);
        }

    }

    public static int[] mergeSort(int[] arrayToSort, int firstIndexToSort, int lastIndexToSort){
        if (firstIndexToSort == lastIndexToSort){
            int[] arrayToReturn = {arrayToSort[firstIndexToSort]}; 
            return (arrayToReturn);
        } else {
            int numberOfElementsToSort = lastIndexToSort-firstIndexToSort+1;
            int numberOfElementsToSortInTheFirstHalf = numberOfElementsToSort/2;
            int numberOfElementsToSortInTheSecondHalf = numberOfElementsToSort-numberOfElementsToSortInTheFirstHalf;
            int[] firstHalfSorted = mergeSort(arrayToSort, firstIndexToSort, firstIndexToSort+numberOfElementsToSortInTheFirstHalf-1);
            int[] secondHalfSorted = mergeSort(arrayToSort, lastIndexToSort-numberOfElementsToSortInTheSecondHalf+1, lastIndexToSort);

            return mergeArrays(firstHalfSorted,secondHalfSorted);
        }
    }

    public static int[] mergeArrays(int[] firstArray, int[] secondArray){
        int firstArrayCursor = 0;
        int secondArrayCursor = 0;
        int[] arrayToReturn = new int[firstArray.length + secondArray.length];
        while (firstArrayCursor<firstArray.length && secondArrayCursor<secondArray.length){
            if (firstArray[firstArrayCursor] < secondArray[secondArrayCursor]){
                arrayToReturn[firstArrayCursor+secondArrayCursor] = firstArray[firstArrayCursor];
                firstArrayCursor++;
            } else {
                arrayToReturn[firstArrayCursor+secondArrayCursor] = secondArray[secondArrayCursor];
                secondArrayCursor++;
            }
        }
        while (firstArrayCursor<firstArray.length){
            arrayToReturn[firstArrayCursor+secondArrayCursor] = firstArray[firstArrayCursor];
            firstArrayCursor++;
        }
        while (secondArrayCursor<secondArray.length){
            arrayToReturn[secondArrayCursor+firstArrayCursor] = secondArray[secondArrayCursor];
            secondArrayCursor++;
        }
        return arrayToReturn;
    }

    public static void wait(int delay){
        try{ 
            Thread.sleep(delay); 
        }catch(InterruptedException e){}
    }

    /* public static String readLineFromFile(int lineIndex, String directory){
        String out = "error";
        try {
            FileReader fR = new FileReader(directory);
            BufferedReader bR = new BufferedReader(fR);
            try {
                while (lineIndex != 1){
                    bR.readLine();
                    lineIndex--;
                }
                out = bR.readLine();
                bR.close();
                return out;
            } catch (IOException f){
                System.out.println("io exception");
                f.printStackTrace();
            }
        } catch (FileNotFoundException e){
            System.out.println("file not found exception");
            e.printStackTrace();
        }
        return out;
    }

    public static void writeOnFile(String content, String directory){
        try{
            FileWriter wr = new FileWriter(directory);
            wr.write(content);
            wr.close();
        } catch (IOException e) {
            System.out.println("io exception");
            e.printStackTrace();
        }
        
    }

    public static void editFileLine(String directory, int lineIndex, String content){
        try {

            FileReader fR;
            BufferedReader bR;
            FileWriter fW;
            BufferedWriter bW;

            String currentLine;
            String fileContents = "";
            fR = new FileReader(directory);
            bR = new BufferedReader(fR);

            try {

                for (int currentLineIndex = 0; (currentLine = bR.readLine()) != null; currentLineIndex++){
                    if (currentLineIndex == lineIndex){
                        fileContents += content;
                    } else {
                        fileContents += currentLine;
                    }

                    fileContents += "\n";
                }

                fW = new FileWriter(directory);
                bW = new BufferedWriter(fW);
                bW.write(fileContents);

                bR.close();
                fR.close();
                bW.close();
                fW.close();

            } catch (IOException f) {
                System.out.println("io exception");
                f.printStackTrace();
            }
            
        } catch (FileNotFoundException e){
            System.out.println("file not found exception");
            e.printStackTrace();
        }
    } */

    
}

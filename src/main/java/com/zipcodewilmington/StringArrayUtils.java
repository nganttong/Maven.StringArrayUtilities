package com.zipcodewilmington;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by leon on 1/29/18.
 */
public class StringArrayUtils {
//    public static void main(String[] args) {
//        String[] array = {"m", "o", "o", "n", "m", "a", "n"};
//        String[] outputPackedArray;
//        String concatDups = array[0];
//        for (int i = 1; i < array.length; i++) {
//            if (array[i].equals(array[i - 1])) {
//                concatDups = concatDups + array[i];
//            } else {
//                concatDups = concatDups + " " + array[i];
//            }
//        }
//        outputPackedArray = concatDups.split(" ");  //"moonman" "m", "oo"
//        System.out.println(concatDups);
//    }
    /**
     * @param array array of String objects
     * @return first element of specified array
     */ // TODO
    public static String getFirstElement(String[] array) {

        return array[0];
    }

    /**
     * @param array array of String objects
     * @return second element in specified array
     */
    public static String getSecondElement(String[] array) {

        return array[1];
    }

    /**
     * @param array array of String objects
     * @return last element in specified array
     */ // TODO
    public static String getLastElement(String[] array) {

        return array[array.length - 1];
    }

    /**
     * @param array array of String objects
     * @return second to last element in specified array
     */ // TODO
    public static String getSecondToLastElement(String[] array) {

        return array[array.length - 2];
    }

    /**
     * @param array array of String objects
     * @param value value to check array for
     * @return true if the array contains the specified `value`
     */ // TODO
    public static boolean contains(String[] array, String value) {
        for (int i = 0; i < array.length; i++) {
            String arrayAtThisPoint = array[i];
            if (arrayAtThisPoint.contains(value)) {
                return true;
            }
        }
        return false;
    }

    /**
     * @param array of String objects
     * @return an array with identical contents in reverse order
     */ // TODO
    public static String[] reverse(String[] array) {
        String[] reverseOrder = new String[array.length];
        for (int i = array.length - 1, j = 0; i >= 0; i--, j++) {
            reverseOrder[j] = array[i];
        }
        return reverseOrder;
    }

    /**
     * @param array array of String objects
     * @return true if the order of the array is the same backwards and forwards
     */ // TODO
    public static boolean isPalindromic(String[] array) {
//        String[] reverseArray = reverse(array);
//            return Arrays.equals(reverseArray, array); //easier way/shortest code way to do it
        String[] reverseArray = reverse(array);
        for (int i = 0; i < array.length; i++) {
            if (!array[i].equals(reverseArray[i])) {
                return false;
            }
        }
        return true;
    }

    /**
     * @param array array of String objects
     * @return true if each letter in the alphabet has been used in the array
     */ // TODO
    public static boolean isPangramic(String[] array) {
        //have an array, its a string
        //i need ot make sure every letter of the alphabet is in it
        String tracksLetters = "";
        for (int i = 0; i < array.length; i++) {
            String lowerInput = array[i].toLowerCase();
//            if (array[i].contains("a") && tracksLetters != 1) {
//                tracksLetters++;
//            }
            //using the ascii table
            for (int j = 'a'; j <= 'z'; j++) {
                String letter = Character.toString((char)j);
                if (lowerInput.contains(letter) && !tracksLetters.contains(letter)) {
                    tracksLetters = tracksLetters + letter;
                }
                if (tracksLetters.length() == 26) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * @param array array of String objects
     * @param value value to check array for
     * @return number of occurrences the specified `value` has occurred
     */ // TODO
    public static int getNumberOfOccurrences(String[] array, String value) {
        //has to loop through the array and check if that value is equal to the array, then store that number of occurences
        int counter = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(value)) {
                counter++;
            }
        }
        return counter;
    }

    /**
     * @param array         array of String objects
     * @param valueToRemove value to remove from array
     * @return array with identical contents excluding values of `value`
     */ // TODO
    public static String[] removeValue(String[] array, String valueToRemove) {
        int outputArraySize = array.length-getNumberOfOccurrences(array, valueToRemove);
        String[] outputArray = new String[outputArraySize];
        int outputIndex = 0;
        for (int i = 0; i < array.length; i++) {
            if (!array[i].equals(valueToRemove)) {
                outputArray[outputIndex] = array[i];
                outputIndex++;
            }
        }
        return outputArray;
    }

    /**
     * @param array array of chars
     * @return array of Strings with consecutive duplicates removes
     */ // TODO
    public static String[] removeConsecutiveDuplicates(String[] array) {
        //i want it to go through all the elements in that array, then return a new array
        //with my original string without consecutive duplicates
//        ArrayList<String> newArrayWithOutDups = new ArrayList<String>();
//        newArrayWithOutDups.add(array[1]);
//        for (int i = 1; i < array.length; i++) {
//            if (!array[i].equals(array[i-1])) {
//            newArrayWithOutDups.add(array[i]);
//            }
//        }
//        return newArrayWithOutDups.toArray(new String[0]); //using ArrayLists
        String[] outputDupelessArray;
        String removeDups = array[0];
        for (int i = 1; i < array.length; i++) {
            if (!array[i].equals(array[i - 1])) {
                removeDups = removeDups + " " + array[i];
            }
        }
        outputDupelessArray = removeDups.split(" ");
        return outputDupelessArray;
    }


    /**
     * @param array array of chars
     * @return array of Strings with each consecutive duplicate occurrence
     * concatenated as a single string in an array of Strings
     */ // TODO
    public static String[] packConsecutiveDuplicates(String[] array) {
        String[] outputPackedArray;
        String concatDups = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i].equals(array[i - 1])) {
                concatDups = concatDups + array[i];
            } else {
                concatDups = concatDups + " " + array[i];
            }
        }
        outputPackedArray = concatDups.split(" ");
        return outputPackedArray;
    }
}

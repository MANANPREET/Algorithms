package com.easy.myImplementation;

/*
Problem Statement
Two Number Sum

        Write a function that takes in a non-empty array of distinct integers and an integer representing a target sum.
        If any two numbers in the input array sum up to the target sum, the function should return them in an array,
        in sorted order. If no two numbers sum up to the target sum, the function should return an empty array.
        Assume that there will be at most one pair of numbers summing up to the target sum.

        Sample input: [3, 5, -4, 8, 11, 1, -1, 6], 10
        Sample output: [-1, 11]
*/


import java.util.Arrays;
import java.util.Hashtable;

public class P1_TwoNumbersSum {
    public static void main(String args[]) {

        int[] arr = new int[]{3, 5, -4, 8, 11, 1, -1, 6};
        /*int[] arr = new int[]{2, 3, 6, 5, 2, 1, 1, 0};*/
        int[] res = twoNumberSum2(arr,10);
        System.out.println(Arrays.toString(res));
    }
    // Optimal Solution
    // a + b = targetSum; b = targetSum - a; Optimal Solution
    public static int[] twoNumberSum2(int[] array, int targetSum) {
        Hashtable ht = new Hashtable();
        for(int i=0; i < array.length; i++) {
            if(ht.contains(targetSum-array[i])) {
                if(targetSum-array[i] < array[i]) {
                    return new int[]{targetSum - array[i], array[i]};
                }
                else {
                    return new int[]{array[i], targetSum - array[i]};
                }
            }
            else {
                ht.put(i, array[i]);
            }
        }
        return new int[0];
    }
    public static int[] twoNumberSum(int[] array, int targetSum) {
        int[] res = new int[2];
        boolean flag = false;
        for(int i = 0; i < array.length; i++) {

            for(int j = i+1; j < array.length; j++){
                if(array[i] + array[j] == targetSum) {
                    flag = true;
                    if(array[i] < array[j]) {
                        res[0] = array[i];
                        res[1] = array[j];
                    }
                    else {
                        res[0] = array[j];
                        res[1] = array[i];
                    }
                    break;
                }
            }
            if(flag) {
                break;
            }
        }

        if(!flag) {
            return new int[0];
        }
        else {
            return res;
        }
    }
}


  /*  int[] output = {};
    int a, b = 0;
    Set<Integer> set = new HashSet<>();
		for (int i = 0; i < array.length; i++) {
        if (set.contains(array[i])) {
        output = new int[2];
        b = array[i];
        a = targetSum - b;
        if (a > b) {
        output[0] = b;
        output[1] = a;
        } else {
        output[0] = a;
        output[1] = b;
        }
        } else {
        set.add(targetSum - array[i]);
        }
        }
        return output;
        */
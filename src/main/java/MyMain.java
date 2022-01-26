import java.util.ArrayList;

public class MyMain {
    // **************************
    // In-class Practice Problems
    // **************************

    // Write a method that uses recursion to search for a value in
    // an array using binary search!

    // Examples:
    // binarySearch([5, 2, 4, 3], 4) => true
    // binarySearch([6, 7, 1, 2, 8], 5) => false

    // Wrapper Method
    public static boolean binarySearch(int[] arr, int num) {
        return binarySearchTR(arr, num, 0, arr.length-1);
    }

    // Tail recursive method:
    public static boolean binarySearchTR(int[] arr, int num, int lowerBound, int upperBound) {
        // YOUR CODE HERE
//        return false;
        int middleIndex = lowerBound + (upperBound - lowerBound)/2;

        if (lowerBound > upperBound) {
            return false;
        }
        else if (arr[middleIndex] < num) {
            return binarySearchTR(arr, num, middleIndex+1, upperBound);
        }
        else if (arr[middleIndex] > num) {
            return binarySearchTR(arr, num, lowerBound, middleIndex-1);
        }
        else {
            return true;
        }
    }





    // ********************
    // Methods for homework:
    // ********************

    // This method does not use recursion!

    // Write a method takes two sorted arrays as input and combines them
    // into one large combined arrays.

    // Here is the pseudocode for merge:
    // * Create a new big output array
    // * Start at the beginning of both input arrays
    // * Take the smaller of the two values and add it to the output array
    // * Repeat until we’ve gone through all the values in one of the arrays
    // * Copy the remaining values from the other array into the output array

    // Here's an example of how it looks in action:
    // arr1 = [1, 4, 5, 8]       arr2 = [2, 6, 7, 10]      output = [                         ]
    //         ^                         ^                           ^
    //     idx1 = 0                  idx2 = 0                   outputIdx = 0

    // The current value in arr1 (1) is smaller than the current value
    // in arr2 (2). So we copy 1 into the output array. Then we increment
    // both idx1 and outputIdx:

    // arr1 = [1, 4, 5, 8]       arr2 = [2, 6, 7, 10]      output = [1,                       ]
    //            ^                      ^                              ^
    //        idx1 = 1               idx2 = 0                      outputIdx = 1

    // The current value in arr1 (4) is larger than the current value
    // in arr2 (2). So we copy 2 into the output array. Then we increment
    // both idx2 and outputIdx:

    // arr1 = [1, 4, 5, 8]       arr2 = [2, 6, 7, 10]      output = [1, 2,                     ]
    //            ^                         ^                              ^
    //        idx1 = 1                  idx2 = 1                      outputIdx = 2

    // We continue on until one of the arrays is empty
    // Then we need to copy the rest of the array

    public static int[] merge(int[] arr1, int[] arr2) {
        // YOUR CODE HERE
//        return null;

        // Indices to keep track of location in input and output arrays
        int idx1 = 0;
        int idx2 = 0;
        int outputIdx = 0;

        int[] output = new int[arr1.length + arr2.length];

        // While we have two values left to compare...
        // * Copy the smaller value into the output array
        // * Increment the appropriate indexes
        while (idx1 < arr1.length && idx2 < arr2.length)
        {
            if (arr2[idx2] < arr1[idx1]) {
                output[outputIdx] = arr2[idx2];
                idx2++;
            }
            else {
                output[outputIdx] = arr1[idx1];
                idx1++;
            }
            outputIdx++;
        }

        // Copy rest of array A if array arr2 finished first
        while (idx1 < arr1.length) {
            output[outputIdx] = arr1[idx1];
            idx1++;
            outputIdx++;
        }

        // Copy rest of array arr2 if array A finished first
        while (idx2 < arr2.length) {
            output[outputIdx] = arr2[idx2];
            idx2++;
            outputIdx++;
        }

        return output;
    }
}

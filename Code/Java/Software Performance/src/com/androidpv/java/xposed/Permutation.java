package com.androidpv.java.xposed;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Erin on 4/5/16.
 */
public class Permutation {

    private List<int[]> anonOptions = new ArrayList<>();
    private int[] nArray;


    public Permutation(int nAnon, int end) {
        nArray = new int[nAnon];
        for (int nIter = 0; nIter < nArray.length; nIter++) {
            nArray[nIter] = nIter+1;
        }
        getPermutations(nArray, end);
    }


    public List<int[]> getAnonOptions() {
        return anonOptions;
    }

    public int[] getBasicArray() {
        return nArray;
    }

    private void getPermutations(int[] input, int end) {
        permute(input, 0, end);
    }


    private void permute(int[] inputArray, int startIndex, int end) {
        if (end == startIndex) {
            anonOptions.add(Arrays.copyOfRange(inputArray, 0, end));
        }
        else {
            for (int i = startIndex; i < inputArray.length; i++) {
                int[] input2 = inputArray.clone();
                int temp = input2[i];
                input2[i] = input2[startIndex];
                input2[startIndex] = temp;
                permute(input2, startIndex + 1, end);

            }
        }
    }

    public List<int[]> getSubsections(int subSize) {
        List<int[]> subsectionsList = new ArrayList<>();

        for (int[] perm : anonOptions) {
            int start = 0;
            for (int end = subSize; end <= perm.length; end++) {
                int[] subsection = Arrays.copyOfRange(perm, start, end);
                start += 1;

                if (!subsectionsList.contains(subsection)) {
                    subsectionsList.add(subsection);
                }
            }
        }
        return subsectionsList;
    }
}

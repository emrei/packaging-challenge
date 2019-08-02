package com.yemre;

import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.yemre.model.Case;

public class Application {

    public static void main(String[] args) {
//	int arr[] = { 1, 2, 3, 4, 5 };
//	int r = 3;
//	int n = arr.length;
//	printCombination(arr, n, r);
	String string = "abbaacdeefg";
	System.out.println(getUniques(string));
	

    }

    static void combinationUtil(int arr[], int data[], int start, int end, int index, int r) {
	//System.out.println("combination util starts...");
// Current combination is ready to be printed, print it 
	if (index == r) {
	    for (int j = 0; j < r; j++)
		System.out.print(data[j] + " ");
	    System.out.println("");
	    return;
	}

// replace index with all possible elements. The condition 
// "end-i+1 >= r-index" makes sure that including one element 
// at index will make a combination with remaining elements 
// at remaining positions 
	//System.out.println("for starts...");
	for (int i = start; i <= end; i++) {
	    data[index] = arr[i];
	    System.out.println("start: " + start + " i: " + i + " index: " + index);
	    combinationUtil(arr, data, i + 1, end, index + 1, r);
	}
	//System.out.println("for ends...");
    }

// The main function that prints all combinations of size r 
// in arr[] of size n. This function mainly uses combinationUtil() 
    static void printCombination(int arr[], int n, int r) {
// A temporary array to store all combination one by one 
	int data[] = new int[r];

// Print all combination using temprary array 'data[]' 
	combinationUtil(arr, data, 0, n - 1, 0, r);
    }
    
    class WordFrequency{
        String word;
        long frequency;
        public WordFrequency(String word, long frequency) {
            this.word = word;
            this.frequency = frequency;
        }
        @Override
        public String toString() {
            // TODO Auto-generated method stub
            return word;
        }
	public String getWord() {
	    return word;
	}
	public long getFrequency() {
	    return frequency;
	}
        
    }
    
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Long> frequencyMap = Arrays.stream(words).collect(
                Collectors.groupingBy(Function.identity(), Collectors.counting()));
            List<WordFrequency> sortedWords = frequencyMap.entrySet().stream()
                .map(e-> new WordFrequency(e.getKey(), e.getValue())).collect(Collectors.toList());
            System.out.println(sortedWords);
            //return sortedWords.stream().sorted().limit(k).collect(Collectors.toList());
            return sortedWords.stream().sorted(Comparator.comparing(WordFrequency::getFrequency).reversed()
                                               .thenComparing(WordFrequency::getWord))
        	    .limit(k).map(e-> e.getWord()).collect(Collectors.toList());
    }
    
    public static List<String> getUniques(String string){
	List<String> uniqueList = new ArrayList();
	int uniqueIndex = 0;
	int tempIndex = 0;
	int startIndex = 0;
	for(int i=0; i<string.length(); i++) {
	    for(int j=i+1; j<string.length(); j++) {
		if(string.charAt(i) == string.charAt(j)) {
		    if(tempIndex == 0) {
			tempIndex = j; 
			uniqueIndex = j; 
		    }else {
			tempIndex = j; 
		    }
		    
		}
	    }
	    System.out.println("temp: " + tempIndex + " unique: " + uniqueIndex + " i: " + i);
	    if(tempIndex >= uniqueIndex && i <= uniqueIndex) {
		uniqueIndex = tempIndex;
	    }
	    if(i > uniqueIndex) {
		uniqueList.add(string.substring(startIndex, i));
		uniqueIndex = 0;
		tempIndex = 0;
		startIndex = i;
	    }
	    
	}
	
	
	return uniqueList;
	
    }

}

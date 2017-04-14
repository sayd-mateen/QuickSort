
/* 
*
*
*	Name: Sayd Mateen
*   Class: CSC140
*   
*/


import java.util.*;

public class QuickSort{
	public static void main(String[] args) {
		Random r = new Random();
		int size = 100;
		long time;
		long overhead;
		time = System.nanoTime();
		int A[] = new int[size];
		int B[] = new int[size];
		for(int i =0; i<size; i++){
			int num = r.nextInt();
			A[i] = num;
		}

		for (int k = 0; k < size; k++) {
			time = System.nanoTime();
			for (int f=0; f < size; f++) {
				B[f] = A[f];
			}
			overhead = System.nanoTime() - time;	
			time = System.nanoTime();
			for (int f=0; f < size; f++ ) {
				B[f] = A[f];
				QuickInsertSort1(B, 0, B.length-1, k);
			}
			time = System.nanoTime() - time - overhead;
			System.out.println(time);
		}

		System.out.println("**************************");

		for (int k = 0; k < size; k++) {
			time = System.nanoTime();
			for (int f=0; f < size; f++) {
				B[f] = A[f];
			}
			overhead = System.nanoTime() - time;	
			time = System.nanoTime();
			for (int f=0; f < size; f++ ) {
				B[f] = A[f];
				QuickInsertSort2(B, 0, B.length-1, k); // Since there is chunks left unosorted 
				InsertionSort(B, 1, B.length); // This insertion sort finshes up the Chunks 
			}
			time = System.nanoTime() - time - overhead;
			System.out.println(time);
		}

		/*
		QuickInsertSort1(B, 0, B.length-1, k);

		QuickInsertSort2(B, 0, B.length-1, k); // Since there is chunks left unosorted 
		InsertionSort(B, 1, B.length); // This insertion sort finshes up the Chunks 

		for (int i = 0; i < size; i++ ) {
			System.out.println(A[i] + " Sort 1 " + i);
		}
		for (int j = 0; j < size; j++ ) {
			System.out.println(B[j] + " Sort 2 " + j);
		}*/
	}

	public static void QuickInsertSort1(int[] A, int p, int r, int k){
		if(r-p <= k){
			InsertionSort(A, p, r+1);
		}else{
			if(p < r){
				int q;
				q = partition(A, p, r);
				QuickInsertSort1(A, p, q-1, k);
				QuickInsertSort1(A, q+1, r, k);
			}
		}
	}

	public static void QuickInsertSort2(int[] A, int p, int r, int k){
		if(r-p <= k){
			// Chucks Left Unsorted 
		}else{
			if(p < r){
				int q;
				q = partition(A, p, r);
				QuickInsertSort2(A, p, q-1, k);
				QuickInsertSort2(A, q+1, r, k);
			}
		}
	}

	public static int partition(int[] A, int p, int r){
		int x = A[r];
		int i = p - 1;
		for (int j = p; j <= r-1; j++) {
			if (A[j] <= x){
				i = i + 1;
				int temp = A[i];
				A[i] = A[j];
				A[j] = temp; 
			}
		}
		int temp2 = A[i+1];
		A[i+1] = A[r];
		A[r] = temp2;
		return i+1;
	}

	public static void InsertionSort(int[] A, int start, int end){
		int i;
		for (int j = start; j < end; j++){
			int key = A[j];
			i = j - 1;
			while(i > -1 && A[i] > key){
				A[i+1] = A[i];
				i = i - 1;
			}
			A[i+1] = key;
		}
	}

}



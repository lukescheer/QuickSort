import java.util.*;

/*
*  Quicksort Implementation with Five Pivot Choice techniques
*  and
*  Input Sequence Data Generator
* */


public class QuickSort
{

    public static int compares = 0;

    private static int partition(int[] a, int low, int high, int indexPivot){
        int pivot = a[indexPivot];
        a[indexPivot] = a[high];
        a[high] = pivot;
        int pFinal = low;
        int temp;
        for(int i = low; i < high; i++){
            compares++;
            if(a[i] <= pivot){
                temp = a[i];
                a[i] = a[pFinal];
                a[pFinal] = temp;
                pFinal++;
            }
        }
        a[high] = a[pFinal];
        a[pFinal] = pivot;
        return pFinal;
    }
    public static void insertionSort(int[] arr, int low, int n) {

        for (int i = low + 1; i <= n; i++){
            int value = arr[i];
            int j = i;

            if(j > low){
                compares++;
            }
            while (j > low && arr[j - 1] > value) {
                arr[j] = arr[j - 1];
                j--;
                if(j > low){
                    compares++;
                }
            }
            arr[j] = value;
        }
    }

    public int QuickSortPivotA(int [] array)
    {
        /*
        The quicksort implementation with pivot as the last element of the sequence.
        The method to sort array in place in ascending order
        the method is to return the number of comparisons required to complete the sorting.
        */
        compares = 0;
        int high = array.length - 1;
        if(array.length < 6){
           insertionSort(array, 0, high);
        }
        else{
            sortA(array,0, high);
        }
        return compares;
    }
    private static void sortA(int array[], int low, int high){
        if(high <= low){
            return;
        }
        int n = high - low + 1;
        if(n < 6){
            insertionSort(array, low, high);
        }
        else{
            int j = partition(array, low, high, high);
            sortA(array, low, j-1);
            sortA(array, j+1, high);
        }
    }


    public int QuickSortPivotB(int [] array)
    {
        /*
        Implement the quicksort with pivot as the first element of the sequence.
        The method to sort array in place in ascending order
        the method is to return the number of comparisons required to complete the sorting.
        */
        compares = 0;
        int high = array.length - 1;
        if(array.length < 6){
           insertionSort(array, 0, high);
        }
        else{
            sortB(array,0, high);
        }
        return compares;
    }
    private static void sortB(int array[], int low, int high){
        if(high <= low){
            return;
        }
        int n = high - low + 1;
        if(n < 6){
            insertionSort(array, low, high);
        }
        else{
            int j = partition(array, low, high, low);
            sortB(array, low, j-1);
            sortB(array, j+1, high);
        }
    }

    public int QuickSortPivotC(int [] array)
    {
        /*
        Implement the quicksort with pivot as the middle element of the sequence.
        The method to sort array in place in ascending order
        the method is to return the number of comparisons required to complete the sorting.
        */
        compares = 0;
        int high = array.length - 1;
        if(array.length < 6){
            insertionSort(array, 0, high);
        }
        else{
            sortC(array,0, high);
        }
        return compares;
    }
    private static void sortC(int array[], int low, int high){
        if(high <= low){
            return;
        }
        int n = high - low + 1;
        if(n < 6){
            insertionSort(array, low, high);
        }
        else{
            int pivot = n / 2 + low;
            int j = partition(array, low, high, pivot);
            //System.out.println("pivot index before sort: " + pivot + " pivot index after sort: " + j );
            //for(int i = low; i <= high; i++){
              //  System.out.print(array[i] + " ");
            //}
            //System.out.println();
            sortC(array, low, j-1);
            sortC(array, j+1, high);
        }
    }

    public static int insertionSort2(int[] arr, int low, int n, int indeces[]){
/*        System.out.println("  original array:");
        for(int i = 0; i < 3; i++){
             System.out.print(arr[i] + " ");
        }
        System.out.println();
        System.out.println("original indeces:");
        for(int i = 0; i < 3; i++){
            System.out.print(indeces[i] + " ");
        }
        System.out.println();*/
        int len = n - low + 1;
        for (int i = low + 1; i <= n; i++){
            int value = arr[i];
            int index = indeces[i];
            int j = i;

            if(j > low){
                compares++;
            }
            while (j > low && arr[j - 1] > value) {
                arr[j] = arr[j - 1];
                indeces[j] = indeces[j - 1];
                j--;
                if(j > low){
                    compares++;
                }
            }
            arr[j] = value;
            indeces[j] = index;
        }
   /*     System.out.println("end array:");
        for(int i = 0; i < 3; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        System.out.println("end indeces:");
        for(int i = 0; i < 3; i++){
              System.out.print(indeces[i] + " ");
        }
        //System.out.println();*/
        return indeces[len/2];
    }

    public int QuickSortPivotD(int [] array)
    {
        /*
        Implement the quicksort with pivot as the median of the first, middle and last elements of the sequence.
        The method to sort array in place in ascending order
        the method is to return the number of comparisons required to complete the sorting.
        */
        compares = 0;
        int high = array.length - 1;
        if(array.length < 6){
            insertionSort(array, 0, high);
        }
        else{
            sortD(array,0, high);
        }
        return compares;
    }
    private static void sortD(int array[], int low, int high){
        if(high <= low){
            return;
        }
        int n = high - low + 1;
        if(n < 6){
            insertionSort(array, low, high);
        }
        else{
            int mid = n / 2 + low;
            int indeces[] = {low, mid, high};
            int values[] = {array[low], array[mid], array[high]};
            int pivot = insertionSort2(values, 0, 2, indeces);
            //System.out.println("pivot: " + pivot);
            int j = partition(array, low, high, pivot);
            //System.out.println("pivot location after sorting: " + j);
            sortD(array, low, j-1);
            sortD(array, j+1, high);
        }
    }

    public int QuickSortPivotE(int [] array)
    {
        /*
        Implement the quicksort with pivot as the median of five elements of the sequence, chosen to be roughly 10%,
         30%, 50%, 70% and 90% of the way through the sequence.
        The method to sort array in place in ascending order
        the method is to return the number of comparisons required to complete the sorting.
        */
        compares = 0;
        int high = array.length - 1;
        if(array.length < 6){
            insertionSort(array, 0, high);
        }
        else{
            sortE(array,0, high);
        }
        return compares;
    }
    private static void sortE(int array[], int low, int high){
        if(high <= low){
            return;
        }
        int n = high - low + 1;
        if(n < 6){
            insertionSort(array, low, high);
        }
        else{
            int indeces[] = {n/10 + low, (n*3)/10 + low, (n*5)/10 + low, (n*7)/10 + low, (n*9)/10 + low};
            int values[] = new int[5];
            for(int i = 0; i < 5; i++){
                values[i] = array[indeces[i]];
            }
            int pivot = insertionSort2(values, 0, 4, indeces);
            //System.out.println("pivot: " + pivot);
            int j = partition(array, low, high, pivot);
            //System.out.println("pivot location after sorting: " + j);
            sortE(array, low, j-1);
            sortE(array, j+1, high);
        }
    }

    /*
    *
    * Implement the rest of the functions required to do the quicksort for every variation.
    * */


    public int[] GenerateInputSequence1(int N)
    {
        /*
        * return an array with the sequence 1, 2, 3, ..., N (in increasing order).
        * For example, if N = 1000, then the sequence would be: 1, 2, 3, 4, 5, ..., 1000
        * */
        int array[] = new int[N];
        for(int i = 1; i < (N+1); i++){
            array[i-1] = i;
        }
        return array;

    }

    public int[] GenerateInputSequence2(int N)
    {
        /*
         * return an array with The sequence N, N-1, ..., 2, 1 (in decreasing order).
         * For example, if N = 1000, then the sequence would be: 1000, 999, ..., 2, 1
         * */
        int array[] = new int[N];
        for(int i = 0; i < N; i++){
            array[i] = N-i;
        }
        return array;
    }

    public int[] GenerateInputSequence3(int N)
    {
        /*
         * return an array with The sequence 1, 3, 5, ..., N-1, 2, 4, 6, ..., N.
         * For example,  if N = 1000, then the sequence would be: 1, 3, 5, ..., 999, 2, 4, 6, ..., 1000
         * */
        int array[] = new int[N];
        for(int i = 0; i < (N/2); i++){
            array[i] = (i+1)*2-1;
        }
        for(int i = 0; i < (N/2); i++){
            array[N/2 + i] = (i+1)*2;
        }
        return array;
    }

    public int[] GenerateInputSequence4(int N)
    {
        /*
         * return an array with the sequence 1, 3, 5, ..., N-3, N-1, N, N-2, N-4, ..., 4, 2.
          * For example,  if N = 1000, then the sequence would be: 1,3,5 ...,997,999,1000,998,996, ..., 4,2
         * */
        int array[] = new int[N];
        for(int i = 0; i < (N/2); i++){
            array[i] = (i+1)*2-1;
        }
        for(int i = 0; i < (N/2); i++){
            array[N/2 + i] = N-2*i;
        }
        return array;
    }

    public int[] GenerateInputSequence5(int N)
    {
        /*
         * return an array with sequence 1, N, 2, N-1, 3, N-2, 4, N-3, ..., N/2, (N/2)+1.
         * For example,  if N = 1000, then the sequence would be: 1, 1000, 2, 999, 3, 998, 4, 997, ..., 500, 501
         * */
        int array[] = new int[N];
        for(int i = 0; i < (N/2); i++){
            array[i*2] = (i+1);
        }
        for(int i = 0; i < (N/2); i++){
            array[i*2+1] = N-i;
        }
        return array;
    }


    public int[] GenerateInputSequence6(int N)
    {
        /*
         * return an array with the sequence: Each number is (7 + the previous number) mod N.
         * That is, a(i) = (7 + a(i-1)) mod N, a(0)=0
         * For example,  if N = 1000, then the sequence would be: 0, 7, 14, ..., 994, 1, 8, ..., 993
         */
        int array[] = new int[N];
        array[0] = 0;
        for(int i = 1; i < N; i++){
            array[i] = (7 + array[i-1]) % N;
        }
        return array;
    }


    public int[] GenerateInputSequence7(int N)
    {
        /*
         * return an array with The sequence: The first N Fibonacci numbers modulo N:
         * a(0) = 0; a(1) = 1; a(i) = (a(i-1) + a(i-2)) mod N for 1 < i < N.         *
         * */
        int array[] = new int[N];
        array[0] = 0;
        array[1] = 1;
        for(int i = 2; i < N; i++){
            array[i] = (array[i-1] + array[i-2]) % N;
        }
        return array;
    }


    public int[] GenerateInputSequence8(int N)
    {
        /*
         * return an array with The sequence The first N powers of 2 modulo N:
         * a(0) = 1; a(i) = (2*a(i-1)) mod N for 0 < i < N.
         * */
        int array[] = new int[N];
        array[0] = 1;
        for(int i = 1; i < N; i++){
            array[i] = (2 * array[i-1]) % N;
        }
        return array;
    }


    public int[] GenerateInputSequence9(int N)
    {
        /*
         * return an array with The sequence: The first N powers of 3 modulo N:
         * a(0) = 1; a(i) = (3*a(i-1)) mod N for 0 < i < N.
         * */
        int array[] = new int[N];
        array[0] = 1;
        for(int i = 1; i < N; i++){
            array[i] = (3 * array[i-1]) % N;
        }
        return array;
    }


    public int[] GenerateInputSequence10(int N, int RNG_Seed)
    {
        /*
         * A random sequence using the methods in java.util.Random: Use setSeed(long seed) to set the seed using
         * a nine-digit which will be an input to your method. Use nextInt()%10000 N times to get N random integers
          * between -9999 and 9999.  Use these in the order generated as the sequence.
          * Example:Random generator = new Random();
          * generator.setSeed(123456789);   // 123456789 is example, seed will be input
          * int num = generator.nextInt()%10000; // will be called N times to complete the sequence
          * */
        int array[] = new int[N];
        Random generator = new Random();
        generator.setSeed(RNG_Seed);
        for(int i = 0; i < N; i++){
            array[i] = generator.nextInt() % 10000;
        }
        return array;
    }


    public static void main(String[] args)
    {
        QuickSort qs = new QuickSort();
        // Set N: Size of input sequence
        int n=40;

        int[] array = qs.GenerateInputSequence7(n);
        int[] array2 = qs.GenerateInputSequence7(n);

        //int [] array = {1,2,3,4,1,2,4};
        //int [] array2 ={1,2,3,4,1,2,4};
        int compareCount = qs.QuickSortPivotD(array2);
        System.out.println("original array:");
        for(int i = 0; i < n; i++){
            System.out.print(array[i] + " ");
        }
        System.out.println("sorted array:");
        for(int i = 0; i < n; i++){
            System.out.print(array2[i] + " ");
        }
        System.out.println();
        System.out.println("compare count: " + compareCount);
        /*
        You can test you implementation of the quicksort here.
        Please do not change the function names as we will use them to
        grade your work.
        */
    }
}
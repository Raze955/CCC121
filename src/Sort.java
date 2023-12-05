import java.util.Arrays;

public class Sort {


    public static int[] bubble(int []obj){
        int[] arr = obj.clone();
        int n = obj.length;
        int i, j, temp;
        boolean swapped;
        for (i = 0; i < n - 1; i++) {
            swapped = false;
            for (j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {

                    // Swap arr[j] and arr[j+1]
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

            // If no two elements were
            // swapped by inner loop, then break
            if (!swapped)
                break;
        }

        return arr;
    }
    public static int[] insertion(int []obj){
        int[] sorted = obj.clone();

        int n = sorted.length;
        for (int i = 1; i < n; ++i) {
            int key = sorted[i];
            int j = i - 1;

            /* Move elements of sorted[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && sorted[j] > key) {
                sorted[j + 1] = sorted[j];
                j = j - 1;
            }
            sorted[j + 1] = key;
        }

        return sorted;
    }

    public static int[] merge(int []obj){
        int[] sorted = obj.clone();

        class Merge{
            // Merges two subarrays of arr[].
            // First subarray is arr[l..m]
            // Second subarray is arr[m+1..r]
            private static void merge(int[] arr, int l, int m, int r)
            {
                // Find sizes of two subarrays to be merged
                int n1 = m - l + 1;
                int n2 = r - m;

                // Create temp arrays
                int[] L = new int[n1];
                int[] R = new int[n2];

                // Copy data to temp arrays
                System.arraycopy(arr, l + 0, L, 0, n1);
                for (int j = 0; j < n2; ++j)
                    R[j] = arr[m + 1 + j];

                // Merge the temp arrays

                // Initial indices of first and second subarrays
                int i = 0, j = 0;

                // Initial index of merged subarray array
                int k = l;
                while (i < n1 && j < n2) {
                    if (L[i] <= R[j]) {
                        arr[k] = L[i];
                        i++;
                    }
                    else {
                        arr[k] = R[j];
                        j++;
                    }
                    k++;
                }

                // Copy remaining elements of L[] if any
                while (i < n1) {
                    arr[k] = L[i];
                    i++;
                    k++;
                }

                // Copy remaining elements of R[] if any
                while (j < n2) {
                    arr[k] = R[j];
                    j++;
                    k++;
                }
            }

            // Main function that sorts arr[l..r] using
            // merge()
            static void sort(int[] arr, int l, int r)
            {
                if (l < r) {

                    // Find the middle point
                    int m = l + (r - l) / 2;

                    // Sort first and second halves
                    sort(arr, l, m);
                    sort(arr, m + 1, r);

                    // Merge the sorted halves
                    merge(arr, l, m, r);
                }
            }
        }
        Merge.sort(sorted,0, sorted.length-1);
        return sorted;
    }

    public static int[] selection(int[] obj){
        int[] sorted = obj.clone();
        int n = sorted.length;

        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n-1; i++)
        {
            // Find the minimum element in unsorted array
            int min_idx = i;
            for (int j = i+1; j < n; j++)
                if (sorted[j] < sorted[min_idx])
                    min_idx = j;

            // Swap the found minimum element with the first
            // element
            int temp = sorted[min_idx];
            sorted[min_idx] = sorted[i];
            sorted[i] = temp;
        }
        return sorted;
    }

    public static int[] quick(int[] obj){
        int[] sorted = obj.clone();
        class Quick{
            // A utility function to swap two elements
            static void swap(int[] arr, int i, int j)
            {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }

            // This function takes last element as pivot,
            // places the pivot element at its correct position
            // in sorted array, and places all smaller to left
            // of pivot and all greater elements to right of pivot
            static int partition(int[] arr, int low, int high)
            {
                // Choosing the pivot
                int pivot = arr[high];

                // Index of smaller element and indicates
                // the right position of pivot found so far
                int i = (low - 1);

                for (int j = low; j <= high - 1; j++) {

                    // If current element is smaller than the pivot
                    if (arr[j] < pivot) {

                        // Increment index of smaller element
                        i++;
                        swap(arr, i, j);
                    }
                }
                swap(arr, i + 1, high);
                return (i + 1);
            }

            // The main function that implements QuickSort
            // arr[] --> Array to be sorted,
            // low --> Starting index,
            // high --> Ending index
            static void quickSort(int[] arr, int low, int high)
            {
                if (low < high) {

                    // pi is partitioning index, arr[p]
                    // is now at right place
                    int pi = partition(arr, low, high);

                    // Separately sort elements before
                    // partition and after partition
                    quickSort(arr, low, pi - 1);
                    quickSort(arr, pi + 1, high);
                }
            }
        }
        Quick.quickSort(sorted, 0, sorted.length-1);
        return sorted;
    }

    public static int[] heap(int[] obj){
        int[] sorted = obj.clone();
        class HeapSort {
            public static void sort(int[] arr) {
                int N = arr.length;

                // Build heap (rearrange array)
                for (int i = N / 2 - 1; i >= 0; i--)
                    heapify(arr, N, i);

                // One by one extract an element from heap
                for (int i = N - 1; i > 0; i--) {
                    // Move current root to end
                    int temp = arr[0];
                    arr[0] = arr[i];
                    arr[i] = temp;

                    // call max heapify on the reduced heap
                    heapify(arr, i, 0);
                }
            }

            // To heapify a subtree rooted with node i which is
            // an index in arr[]. n is size of heap
            private static void heapify(int[] arr, int N, int i) {
                int largest = i; // Initialize largest as root
                int l = 2 * i + 1; // left = 2*i + 1
                int r = 2 * i + 2; // right = 2*i + 2

                // If left child is larger than root
                if (l < N && arr[l] > arr[largest])
                    largest = l;

                // If right child is larger than largest so far
                if (r < N && arr[r] > arr[largest])
                    largest = r;

                // If largest is not root
                if (largest != i) {
                    int swap = arr[i];
                    arr[i] = arr[largest];
                    arr[largest] = swap;

                    // Recursively heapify the affected subtree
                    heapify(arr, N, largest);
                }
            }
        }
        HeapSort.sort(sorted);
        return sorted;
    }

    public static int[] radix(int[] obj){
        int[] sorted = obj.clone();
        class Radix {

            // A utility function to get maximum value in arr[]
            static int getMax(int[] arr, int n) {
                int mx = arr[0];
                for (int i = 1; i < n; i++)
                    if (arr[i] > mx)
                        mx = arr[i];
                return mx;
            }

            // A function to do counting sort of arr[] according to
            // the digit represented by exp.
            static void countSort(int[] arr, int n, int exp) {
                int[] output = new int[n]; // output array
                int i;
                int[] count = new int[10];
                Arrays.fill(count, 0);

                // Store count of occurrences in count[]
                for (i = 0; i < n; i++)
                    count[(arr[i] / exp) % 10]++;

                // Change count[i] so that count[i] now contains
                // actual position of this digit in output[]
                for (i = 1; i < 10; i++)
                    count[i] += count[i - 1];

                // Build the output array
                for (i = n - 1; i >= 0; i--) {
                    output[count[(arr[i] / exp) % 10] - 1] = arr[i];
                    count[(arr[i] / exp) % 10]--;
                }

                // Copy the output array to arr[], so that arr[] now
                // contains sorted numbers according to current
                // digit
                for (i = 0; i < n; i++)
                    arr[i] = output[i];
            }

            // The main function to that sorts arr[] of
            // size n using Radix Sort
            static void radixSort(int[] arr, int n) {
                // Find the maximum number to know number of digits
                int m = getMax(arr, n);

                // Do counting sort for every digit. Note that
                // instead of passing digit number, exp is passed.
                // exp is 10^i where i is current digit number
                for (int exp = 1; m / exp > 0; exp *= 10)
                    countSort(arr, n, exp);
            }
        }
        Radix.radixSort(sorted, sorted.length);
        return sorted;
    }

}

public class QuickSort {

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);

            quickSort(arr, low, pi - 1);  // Sort left part
            quickSort(arr, pi + 1, high); // Sort right part
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                // Swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Swap arr[i+1] and arr[high] (pivot)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    public static void main(String[] args) {
        int[] arr = {9, 6, 8, 3, 6, 5, 7, 2};

        System.out.println("Unsorted data:");
        for (int x : arr) {
            System.out.print(x + " ");
        }

        quickSort(arr, 0, arr.length - 1);

        System.out.println("\nAfter sorting:");
        for (int x : arr) {
            System.out.print(x + " ");
        }
    }
}
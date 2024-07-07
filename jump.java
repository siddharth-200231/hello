import java.util.Arrays;

public class jump {
    public static void main(String[] args) {
        int arr[] = {12,23,21,45,76,12,45};
        int p = 0, r = arr.length - 1;

        mergesort(arr, p, r);

        System.out.println(Arrays.toString(arr));
    }

    public static void mergesort(int arr[], int p, int r) {
        if (p < r) {
            int q = (p + r) / 2;
            mergesort(arr, p, q);
            mergesort(arr, q + 1, r);
            merge(arr, p, q, r);
        }
    }

    public static void merge(int arr[], int p, int q, int r) {
        int a1[] = new int[q - p + 1 + 1]; // +1 for the sentinel value
        int a2[] = new int[r - q + 1]; // +1 for the sentinel value
        
        // Fill the temporary arrays
        for (int i = 0; i < q - p + 1; i++) {
            a1[i] = arr[p + i];
        }
        for (int i = 0; i < r - q; i++) {
            a2[i] = arr[q + 1 + i];
        }

        // Add sentinel values
        a1[q - p + 1] = Integer.MAX_VALUE;
        a2[r - q] = Integer.MAX_VALUE;

        int i = 0, j = 0;
        for (int k = p; k <= r; k++) {
            if (a1[i] <= a2[j]) {
                arr[k] = a1[i++];
            } else {
                arr[k] = a2[j++];
            }
        }
    }
}

/*3. Implement Greedy search algorithm for any of the following application: I. Selection Sort II. Minimum Spanning Tree III. Single-Source Shortest Path Problem IV. Job Scheduling Problem V. Prim's Minimal Spanning Tree Algorithm VI. Kruskal's Minimal Spanning Tree Algorithm VII. Dijkstra's Minimal Spanning Tree Algorithm */

import java.util.Scanner;

public class Selection {
    void sort(int arr[]) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int min_idx = i;
            for (int j = i + 1; j < n; j++)
                if (arr[j] < arr[min_idx])
                    min_idx = j;

            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
    }

    void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        Selection s = new Selection();

        System.out.print("Enter the number of elements: ");
        int size = scanner.nextInt();
        int arr[] = new int[size];

        System.out.println("Enter the elements:");
        for (int i = 0; i < size; i++) {
            arr[i] = scanner.nextInt();
        }
        scanner.close();

        System.out.println("Original array:");
        s.printArray(arr);

        s.sort(arr);
        System.out.println("Sorted array:");
        s.printArray(arr);
    }
}

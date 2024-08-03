/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.Arrays;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author ESTUDIANTE
 */
public class Vector {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        int vector[], size;
        size = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el tamaño del vector"));
        vector = new int[size];

        fillVector(vector);
        JOptionPane.showMessageDialog(null, Arrays.toString(vector));

//        sorting:
//        bubbleSort(vector);
//        selectSort(vector);
//        quickSort(vector, 0, size - 1);
        heapSort(vector);
        System.out.println(Arrays.toString(vector));

//        searching:
        int data, index;
        System.out.println("Ingrese el dato a buscar: ");
        data = kb.nextInt();

//        index = linearSearch(vector, data);
        index = binarySearch(vector, data);
        System.out.println("Índice del dato: " + index);
    }

    private static void fillVector(int[] vector) {
        for (int i = 0; i < vector.length; i++) {
            vector[i] = (int) (Math.random() * 1000);
        }
    }

    private static void bubbleSort(int[] vector) {
        for (int i = 0; i < vector.length; i++) {
            for (int j = 0; j < vector.length - 1; j++) {
                if (vector[j] > vector[j + 1]) {
                    swap(vector, j, j + 1);
                }
            }
        }
    }

    private static void selectSort(int[] vector) {
        int minIndex;

        for (int i = 0; i < vector.length; i++) {
            minIndex = i;
            for (int j = i + 1; j < vector.length; j++) {
                if (vector[j] < vector[minIndex]) {
                    minIndex = j;
                }
            }

            swap(vector, i, minIndex);
        }
    }

    private static void quickSort(int[] vector, int left, int right) {
        int pivot = vector[(left + right) / 2],
                i = left, j = right;

        while (i < j) {
            while (vector[i] < pivot) {
                i++;
            }

            while (vector[j] > pivot) {
                j--;
            }

            if (i <= j) {
                swap(vector, i++, j--);
            }
        }

        if (left < j) {
            quickSort(vector, left, j);
        }

        if (i < right) {
            quickSort(vector, i, right);
        }
    }

    private static void heapify(int[] vector, int n, int i) {
        int largest,
                left = 2 * i + 1,
                right = 2 * i + 2;

        if (left > n) {
            return;
        }

        if (right > n || vector[left] > vector[right]) {
            largest = left;
        } else {
            largest = right;
        }

        if (vector[i] < vector[largest]) {
            swap(vector, i, largest);
            heapify(vector, n, largest);
        }
    }

    private static void heapSort(int[] vector) {
        for (int i = vector.length / 2; i >= 0; i--) {
            heapify(vector, vector.length - 1, i);
        }

        for (int i = vector.length - 1; i >= 0; i--) {
            swap(vector, 0, i);
            heapify(vector, i - 1, 0);
        }
    }

    private static void swap(int[] vector, int i, int j) {
        int temp = vector[i];
        vector[i] = vector[j];
        vector[j] = temp;
    }

    private static int linearSearch(int[] vector, int data) {
        for (int i = 0; i < vector.length; i++) {
            if (vector[i] == data) {
                return i;
            }
        }

        return -1;
    }

    private static int binarySearch(int[] vector, int data) {
        int mid, low = 0, high = vector.length - 1;

        while (high >= low) {
            mid = (high + low) / 2;

            if (vector[mid] == data) {
                return mid;
            }

            if (vector[mid] > data) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }
}

import java.util.Arrays;

class Q5 {

    static void printArray(int[] array) {
        System.out.println(Arrays.toString(array));
    }

    static void reverseArray(int[] array) {
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
    }

    static int[] copyArray(int[] array) {
        int[] copy = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            copy[i] = array[i];
        }
        return copy;
    }

    static int findSecondLargest(int[] array) {
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;

        for (int num : array) {
            if (num > first) {
                second = first;
                first = num;
            } else if (num > second && num < first) {
                second = num;
            }
        }

        return second;
    }

    public static void main(String[] args) {
        int[] data = {3, 7, 1, 9, 4, 6, 8, 2, 5};

        System.out.print("原始陣列: ");
        printArray(data);

        int[] copy = copyArray(data);
        System.out.print("陣列副本: ");
        printArray(copy);

        reverseArray(data);
        System.out.print("反轉後的陣列: ");
        printArray(data);

        int secondLargest = findSecondLargest(copy);
        System.out.println("第二大的數值: " + secondLargest);
    }
}

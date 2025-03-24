import java.util.Arrays;

class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Arrays.sort(arr); // Sort the array to group the same numbers together
        int[] freq = new int[arr.length]; // Maximum possible size of different numbers
        int index = 0, count = 1;

        // Step 1: Count occurrences
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1]) {
                count++;
            } else {
                freq[index++] = count;
                count = 1;
            }
        }
        freq[index++] = count; // Store last counted value

        // Step 2: Check if frequencies are unique
        Arrays.sort(freq, 0, index); // Sort only the used part of the array
        for (int i = 1; i < index; i++) {
            if (freq[i] == freq[i - 1]) {
                return false;
            }
        }

        return true;
    }
}
class Solution {
    public String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>(); // Stack to store repeat counts
        Stack<StringBuilder> stringStack = new Stack<>(); // Stack to store previous strings
        StringBuilder currentStr = new StringBuilder(); // Stores the current decoded string
        int k = 0; // To store the current repeat count

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                // Build the number for k (handle multi-digit numbers)
                k = k * 10 + (c - '0');
            } else if (c == '[') {
                // Push the current count and string to stacks
                countStack.push(k);
                stringStack.push(currentStr);
                // Reset for next substring
                k = 0;
                currentStr = new StringBuilder();
            } else if (c == ']') {
                // Pop values from stacks
                int repeat = countStack.pop();
                StringBuilder decodedString = stringStack.pop();
                // Repeat the current string and append to previous
                for (int i = 0; i < repeat; i++) {
                    decodedString.append(currentStr);
                }
                // Update current string
                currentStr = decodedString;
            } else {
                // Normal character, add to current string
                currentStr.append(c);
            }
        }

        return currentStr.toString();
    }
}
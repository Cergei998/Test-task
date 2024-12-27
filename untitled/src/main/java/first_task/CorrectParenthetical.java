package first_task;

import java.util.Stack;

/**
 *  Scanner scanner = new Scanner(System.in);
 *  "N вводится с клавиатуры". I don`t understood,
 *  should I enter something from keyboard or no.
 */

public class CorrectParenthetical {

    public int numberOfValidParentheses(String string) {
        Stack<Character> stack = new Stack<>();
        int count = 0;
        // convert input string to character array, and iterate
        for (char ch : string.toCharArray()) {
            if (ch == '(') {   // check the opening parenthesis
                stack.push(ch); // if true -> add to Stack
            }
            if (ch == ')') {   // check the closing parenthesis
                // check if there is anything in Stack,
                // if Stack isn`t empty -> check availability opening parenthesis
                if (!stack.isEmpty() && stack.peek() == '(') {
                    // if both conditions true -> remove the "top" element from Stack
                    stack.pop();
                    count++; // plus one matching
                }
            }
        }
        return count;
    }
}
/*      Test in main() method:
        CorrectParenthetical parenthetical = new CorrectParenthetical();
        String example1 = ",f)p<6(p&)<(@%&(.4"; // 1
        String example2 = "y / ((a - 2) + x(128 + 15)) = 0"; // 3
        String example3 = "Qw#(-B)+(!*)k/3@(3e%)"; // 3
        String example4 = "((())()))("; // 4
        System.out.println(parenthetical.numberOfValidParentheses(example1));
        System.out.println(parenthetical.numberOfValidParentheses(example2));
        System.out.println(parenthetical.numberOfValidParentheses(example3));
        System.out.println(parenthetical.numberOfValidParentheses(example4));
 */

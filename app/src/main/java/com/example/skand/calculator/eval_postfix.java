package com.example.skand.calculator;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by Skand on 1/26/2017.
 */

public class eval_postfix {
    ArrayList<String> in;
    double ans;
    private Stack<String> stack;

    public eval_postfix(ArrayList<String> input) {
        in = input;
        ans = 0;
        stack = new Stack<String>();

    }

    public double eval() {

        double n1, n2;
        String o1, o2;
        for (int i = 0; i < in.size(); i++) {
            String ch = in.get(i);
            if (ch.charAt(0) > '0' && ch.charAt(0) < '9') {
                stack.push(ch);
            } else {
                n1 = Double.parseDouble("" + stack.pop());

                n2 = Double.parseDouble("" + stack.pop());
                switch (ch) {
                    case "+":
                        stack.push(Double.toString(n1 + n2));
                        break;
                    case "-":
                        stack.push(Double.toString(n1 - n2));
                        break;
                    case "*":
                        stack.push(Double.toString(n1 * n2));
                        break;
                    case "/":
                        stack.push(Double.toString(n1 / n2));
                        break;

                    default:
                }
            }
        }

        ans = Double.parseDouble("" + stack.pop());
        return ans;
    }
}


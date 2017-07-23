package com.example.skand.calculator;
import java.lang.*;
import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by Skand on 1/26/2017.
 */

public class
infix2postfix {

    ArrayList<String> in;
    ArrayList<String> out;
    private Stack<String> stack;
    infix2postfix(ArrayList<String> input)
    {
        in=input;

        //int stackSize=in.size();
        out= new ArrayList<>();
        stack = new Stack<String>();

    }
     ArrayList<String> trans()
    {
        int i;
        for(i=0;i<in.size();i++)
        {
            String s= in.get(i);
            switch(s)
            {
                case "+" :
                          getop(s,1);
                           break;
                case "-" :
                           getop(s,1);
                           break;
                case "/" :
                          getop(s,2);
                          break;
                case "*" :
                          getop(s,2);
                           break;
                case "(" :stack.push(s);
                          break;
                case ")" : gotParen(s);
                           break;
                default: out.add(s);




            }
        }
        while(!stack.isEmpty())
        {
            out.add(stack.pop());
        }

      return out;
    }
    private void getop(String op, int prec)
    {
        while(!stack.isEmpty())
        {
            String opTop = stack.pop();
            if(opTop.equals("("))
            {
                stack.push(opTop);
                break;
            }
            else
            {
                int prec2;
                if(opTop.equals("+")||opTop.equals("-")) {
                    prec2 = 1;
                }
                else
                {prec2=2;
                }
                if(prec2<prec)
                    stack.push(opTop);
                else
                    out.add(opTop);

            }

        }

     stack.push(op);
    }
    private void gotParen(String ch)
    {
    while(!stack.isEmpty())
    {
        String c=stack.pop();
        if(c.equals("("))
            break;
        else
            out.add(c);

    }


    }






}

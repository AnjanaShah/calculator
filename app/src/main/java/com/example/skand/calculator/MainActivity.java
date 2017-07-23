package com.example.skand.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
//import java.util.Objects;


public class
MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView textView; // null
    String op="";
    ArrayList<String> arr=new ArrayList<String>();
    int last_op=0;
   // int decimalf=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button b1,b2,b3,b4,plus,be,b5,b6,b7,b8,b9,b0,ac,c,bopen,bclose,div,mul,sub,decimal;
        textView=(TextView)findViewById(R.id.textView2) ;
         b1 = (Button)findViewById(R.id.b1);
                 b1.setOnClickListener(this);
         b2 = (Button)findViewById(R.id.b2);
                 b2.setOnClickListener(this);
         b3 = (Button)findViewById(R.id.b3);
                b3.setOnClickListener(this);
         b4 = (Button)findViewById(R.id.b4);
                b4.setOnClickListener(this);
        b5 = (Button)findViewById(R.id.b5);
              b5.setOnClickListener(this);
        b6 = (Button)findViewById(R.id.b6);
              b6.setOnClickListener(this);
        b7 = (Button)findViewById(R.id.b7);
               b7.setOnClickListener(this);
        b8 = (Button)findViewById(R.id.b8);
              b8.setOnClickListener(this);

        b9 = (Button)findViewById(R.id.b9);
              b9.setOnClickListener(this);
        b0 = (Button)findViewById(R.id.b0);
              b0.setOnClickListener(this);
        ac = (Button)findViewById(R.id.ac);
             ac.setOnClickListener(this);
        c = (Button)findViewById(R.id.c);
              c.setOnClickListener(this);

        bclose = (Button)findViewById(R.id.bclose);
           bclose.setOnClickListener(this);
        bopen = (Button)findViewById(R.id.bopen);
             bopen.setOnClickListener(this);

        div = (Button)findViewById(R.id.div);
             div.setOnClickListener(this);
        mul = (Button)findViewById(R.id.mul);
              mul.setOnClickListener(this);
        sub = (Button)findViewById(R.id.sub);
              sub.setOnClickListener(this);
        plus = (Button)findViewById(R.id.plus);
                plus.setOnClickListener(this);
        decimal = (Button)findViewById(R.id.decimal);
            decimal.setOnClickListener(this);
        be = (Button)findViewById(R.id.be);
              be.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id= v.getId();
        if(id == R.id.b1) {
            op = op + "1";
            last_op++;
            textView.setText(op);
        }
        //2
        if(id == R.id.b2) {
            op=op+"2";
            last_op++;
            textView.setText(op);

        }

        //3
        if(id == R.id.b3) {
            op=op+"3";
            last_op++;
            textView.setText(op);

        }
        //4
        if(id == R.id.b4) {
            op=op+"4";
            last_op++;
            textView.setText(op);

        }
        //5
        if(id == R.id.b5) {
            op = op + "5";
            last_op++;
            textView.setText(op);
        }
        //6
        if(id == R.id.b6) {
            op = op + "6";
            last_op++;
            textView.setText(op);
        }
        //7
        if(id == R.id.b7) {
            op = op + "7";
            last_op++;
            textView.setText(op);
        }
        //8
        if(id == R.id.b8) {
            op = op + "8";
            last_op++;
            textView.setText(op);
        }
        //9
        if(id == R.id.b9) {
            op = op + "9";
            last_op++;
            textView.setText(op);
        }
        //0
        if(id == R.id.b0) {
            op = op + "0";
            last_op++;
            textView.setText(op);
        }
        //plus
        if(id== R.id.plus) {
            int l= op.length();
            char c=op.charAt(l-1);
            if(c>='0'&&c<='9')
            {    op=op+"+";
                textView.setText(op);}
            else
                textView.setText("error");
            arr.add(op.substring(l-last_op,l-1));
            arr.add("+");
            last_op=0;

        }
        //sub
        if(id == R.id.sub) {
            int l= op.length();
            char c=op.charAt(l-1);
            if(c>='0'&&c<='9')
            {   op=op+"-";
                textView.setText(op);}

            else
                textView.setText("error");
            arr.add(op.substring(l-last_op,l-1));
            arr.add("-");
            last_op=0;

        }
        //mul
        if(id == R.id.mul) {
            int l= op.length();
            char c=op.charAt(l-1);
            if(c>='0'&&c<='9')
            {   op=op+"*";
                textView.setText(op);}
            else
                textView.setText("error");
            //textView.setText(op);
            arr.add(op.substring(l-last_op,l));
            arr.add("*");
            last_op=0;
        }
        //div
        if(id == R.id.div) {
            int l= op.length();
            char c=op.charAt(l-1);
            if(c>='0'&&c<='9')
            {  op=op+"/";
                textView.setText(op);}
            else
                textView.setText("error");
            textView.setText(op);
            arr.add(op.substring(l-last_op,l-1));
            arr.add("/");
            last_op=0;
        }

        //decimal
        if(id == R.id.decimal) {

            op = op + ".";
            textView.setText(op);
            last_op++;
        }
        //bopen
        if(id == R.id.bopen) {
            op = op + "(";
            textView.setText(op);
        }
        //bclose
        if(id == R.id.bclose) {
            op = op + ")";
            textView.setText(op);
        }
        //ac
        if(id == R.id.ac) {
            op = "";
            textView.setText(op);
        }
        //c
        if(id == R.id.c) {
            //op = op ;
            op=op.substring(0,op.length()-1);
            textView.setText(op);
        }
        //equal
        if(id==R.id.be)
        {


            infix2postfix o=new infix2postfix(arr);
            ArrayList<String> post=o.trans();
            eval_postfix p=new eval_postfix(post);
            Double ans= p.eval();
            String a= Double.toString(ans);
            textView.setText(a);



        }


    }
}

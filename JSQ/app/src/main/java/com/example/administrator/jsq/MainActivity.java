package com.example.administrator.jsq;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //定义按钮，输出及清除位
    Button btn_0, btn_1, btn_2, btn_3, btn_4, btn_5,
            btn_6, btn_7, btn_8, btn_9, btn_equal,
            btn_point, btn_clean, btn_del, btn_plus,
            btn_minus, btn_multiply, btn_divide;
    EditText et_input;
    boolean clear_flag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //按钮初始化
        btn_0 = (Button) findViewById(R.id.btn_0);
        btn_1 = (Button) findViewById(R.id.btn_1);
        btn_2 = (Button) findViewById(R.id.btn_2);
        btn_3 = (Button) findViewById(R.id.btn_3);
        btn_4 = (Button) findViewById(R.id.btn_4);
        btn_5 = (Button) findViewById(R.id.btn_5);
        btn_6 = (Button) findViewById(R.id.btn_6);
        btn_7 = (Button) findViewById(R.id.btn_7);
        btn_8 = (Button) findViewById(R.id.btn_8);
        btn_9 = (Button) findViewById(R.id.btn_9);
        btn_clean = (Button) findViewById(R.id.btn_clean);
        btn_equal = (Button) findViewById(R.id.btn_equal);
        btn_minus = (Button) findViewById(R.id.btn_minus);
        btn_multiply = (Button) findViewById(R.id.btn_multiplay);
        btn_plus = (Button) findViewById(R.id.btn_plus);
        btn_point = (Button) findViewById(R.id.btn_point);
        btn_del = (Button) findViewById(R.id.btn_del);
        btn_divide = (Button) findViewById(R.id.btn_divide);
        et_input = (EditText) findViewById(R.id.et_input);

        //设置点击监听
        btn_0.setOnClickListener(this);
        btn_1.setOnClickListener(this);
        btn_2.setOnClickListener(this);
        btn_3.setOnClickListener(this);
        btn_4.setOnClickListener(this);
        btn_5.setOnClickListener(this);
        btn_6.setOnClickListener(this);
        btn_7.setOnClickListener(this);
        btn_8.setOnClickListener(this);
        btn_9.setOnClickListener(this);
        btn_equal.setOnClickListener(this);
        btn_minus.setOnClickListener(this);
        btn_multiply.setOnClickListener(this);
        btn_divide.setOnClickListener(this);
        btn_del.setOnClickListener(this);
        btn_point.setOnClickListener(this);
        btn_plus.setOnClickListener(this);
        btn_clean.setOnClickListener(this);
        et_input.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String str = et_input.getText().toString();
        switch (v.getId()) {
            case R.id.btn_0:
            case R.id.btn_1:
            case R.id.btn_2:
            case R.id.btn_3:
            case R.id.btn_4:
            case R.id.btn_5:
            case R.id.btn_6:
            case R.id.btn_7:
            case R.id.btn_8:
            case R.id.btn_9:
            case R.id.btn_point:
                if (clear_flag) {
                    clear_flag = false;
                    str = "";
                    et_input.setText("");
                }
                et_input.setText(str + ((Button) v).getText());
                break;

            case R.id.btn_plus:
            case R.id.btn_minus:
            case R.id.btn_multiplay:
            case R.id.btn_divide:
                if (clear_flag) {
                    clear_flag = false;
                    str = "";
                    et_input.setText("");
                }
                et_input.setText(str + " " + ((Button) v).getText() + " ");
                break;
            case R.id.btn_clean:
                clear_flag = false;

                et_input.setText("");
                break;

            case R.id.btn_del:
                if (clear_flag) {
                    clear_flag = false;
                    et_input.setText("");
                } else if (str != null && !str.equals("")) {
                    et_input.setText(str.substring(0, str.length() - 1));
                }
            case R.id.btn_equal:
                getResult();
                break;

            default:
                break;
        }
    }

    private void getResult() {
        String exp = et_input.getText().toString();

        //equals是判断字符串的是不是相等，contains是包含的意思
        if(exp==null||exp.equals("")){
            return;
        }
        if(!exp.contains(" ")){
            return;
        }
        if(clear_flag){
            clear_flag=false;
            return ;
        }
        clear_flag = true;
        double result = 0;
        String s1 = exp.substring(0, exp.indexOf(" "));
        String op = exp.substring(exp.indexOf(" ") + 1, exp.indexOf(" ") + 2);
        String s2 = exp.substring(exp.indexOf(" ") + 3);
        if (!s1.equals("") && !s2.equals("")) {

            //字符串转换为Double
            double d1 = Double.parseDouble(s1);
            double d2 = Double.parseDouble(s2);

            if (op.equals("+")) {
                result = d1 + d2;
            } else if (op.equals("-")) {
                result = d1 - d2;
            } else if (op.equals("*")) {
                result = d1 * d2;
            } else if (op.equals("/")) {
                if (d2 == 0) {
                    result = 0;
                } else {
                    result = d1 / d2;
                }
            }
            if (!s1.contains(".") && !s2.contains(".") && !op.equals("/")) {
                int r = (int) result;
                et_input.setText(r + "");
            } else {
                et_input.setText(result + "");
            }
        }

        else if(!s1.equals("")&&s2.equals("")){
            et_input.setText(exp);
        }
        else if(s1.equals("")&&!s2.equals("")){
            double d2=Double.parseDouble(s2);
            if(op.equals("+")){
                result=0+d2;
            }else if(op.equals("-")){
                result=0-d2;
            }else if(op.equals("*")){
                result=0;
            }else if(op.equals("/")){
                result = 0;
            }
            if(!s2.contains(".")){
                int r=(int) result;
                et_input.setText(r+" ");
            } else{
                et_input.setText(result+" ");
            }
        }else{
            et_input.setText("");
        }

    }
}
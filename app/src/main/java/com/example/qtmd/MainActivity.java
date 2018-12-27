package com.example.qtmd;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class
MainActivity extends AppCompatActivity {
    private EditText qtmd;
    private Button button_sin;          //sin
    private Button button_cos;          //cos
    private Button button_tan;          //tan
    private Button button_jiecheng;     //阶乘
    private Button button_seven;        // 7
    private Button button_eight;        //8
    private Button button_nine;         //9
    private Button button_jia;          //加法
    private Button button_CE;       //导数
    private Button button_four;         //4
    private Button button_five;         //5
    private Button button_six;          //6
    private Button button_jian;         //减法
    private Button button_pingfang;     //平方
    private Button button_one;          //1
    private Button button_two;          //2
    private Button button_three;        //3
    private Button button_cheng;        //乘法
    private Button button_kaifang;      //开方
    private Button button_zero;         //0
    private Button button_point;        //.
    private Button button_chu;          //除法
    private Button button_C;
    private Button button_dengyv;
    private  Button button_daoshu;
    private TextView shuru;
    private TextView shuchu;
    private StringBuilder str1 = new StringBuilder();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        qtmd=(EditText) findViewById(R.id.shuru);
        shuchu = (EditText) findViewById(R.id.shuchu);
        shuru=(EditText)findViewById(R.id.shuru);
        button_dengyv=(Button)findViewById(R.id.dengyv);
//        button_dengyv.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                str1=str1.;
//                qtmd.setText(str1);
//            }
//        });
        button_C=(Button)findViewById(R.id.C);
        button_C.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str1=str1.delete(0,str1.length());
                qtmd.setText(str1);
            }
        });
        button_sin = (Button) findViewById(R.id.sin);
        button_sin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (str1.length() > 0) {
                    if (str1.charAt(str1.length() - 1) == '+' || str1.charAt(str1.length() - 1) == '-' || str1.charAt(str1.length() - 1) == '*' || str1.charAt(str1.length() - 1) == '/') {
                        str1.append("sin");
                        shuru.setText(str1);
                    } else {
                        shuru.setText("error,not complete");
                    }
                } else {
                    str1.append("sin");
                    shuru.setText(str1);
                }
            }
        });
        button_C=(Button)findViewById(R.id.C);
     /*   button_C.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
//        });*/
//        button_daoshu=(Button)findViewById(R.id.daoshu);
//        button_daoshu.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                str1=str1.append("1/");
//                qtmd.setText(str1);
//            }
//        });
        button_cos = (Button) findViewById(R.id.cos);
        button_cos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (str1.length() > 0) {
                    if (str1.charAt(str1.length() - 1) == '+' || str1.charAt(str1.length() - 1) == '-' || str1.charAt(str1.length() - 1) == '*' || str1.charAt(str1.length() - 1) == '/') {
                        str1.append("cos");
                        shuru.setText(str1);
                    } else {
                        shuru.setText("error,not complete");
                    }
                } else {
                    str1.append("cos");
                    shuru.setText(str1);
                }
            }
        });
        button_tan = (Button) findViewById(R.id.tan);
        button_tan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (str1.length() > 0) {
                    if (str1.charAt(str1.length() - 1) == '+' || str1.charAt(str1.length() - 1) == '-' || str1.charAt(str1.length() - 1) == '*' || str1.charAt(str1.length() - 1) == '/') {
                        str1.append("tan");
                        shuru.setText(str1);
                    } else {
                        shuru.setText("error,not complete");
                    }
                } else {
                    str1.append("tan");
                    shuru.setText(str1);
                }

            }
        });
        button_jiecheng = (Button) findViewById(R.id.jiecheng);
        button_jiecheng.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                Double number;
                if (str1.length() > 0) {
                    String jieguo = new String(str1);
                    if (jieguo.contains("/0")) {
                        shuchu.setText("error,no/0");
                        str1 = str1.delete(0, str1.length());
                    } else {

                        if (str1.charAt(str1.length() - 1) == '+' || str1.charAt(str1.length() - 1) == '-' || str1.charAt(str1.length() - 1) == '*' || str1.charAt(str1.length() - 1) == '/') {
                            shuchu.setText("error,not complete");
                            str1 = str1.delete(0, str1.length());
                        } else {
                            jieguo = jisuan(str1);
                            if (jieguo.length() > 1) {
                                if (jieguo.charAt(jieguo.length() - 1) == '0' && jieguo.charAt(jieguo.length() - 2) == '.') {
                                    number = jiecheng(jieguo);
                                    if (number == -1.0) {
                                        shuchu.setText("error!input <0");

                                    }
                                    jieguo = DoubleToString(number);
                                    shuchu.setText(jieguo);
                                    str1 = str1.delete(0, str1.length());
                                    str1.append(jieguo);
                                } else {
                                    if (isInteger(jieguo)) {
                                        number = jiecheng(jieguo);
                                        if (number == -1.0) {
                                            shuchu.setText("error!input <0");

                                        }
                                        jieguo = DoubleToString(number);
                                        shuchu.setText(jieguo);
                                        str1 = str1.delete(0, str1.length());
                                        str1.append(jieguo);
                                    } else {
                                        shuchu.setText("not Integer!");
                                        str1 = str1.delete(0, str1.length());
                                        str1.append("");
                                    }
                                }
                            } else {
                                if (isInteger(jieguo)) {
                                    number = jiecheng(jieguo);
                                    if (number == -1.0) {
                                        shuchu.setText("error!input <0");
                                    }
                                    jieguo = DoubleToString(number);
                                    shuchu.setText(jieguo);
                                    str1 = str1.delete(0, str1.length());
                                    str1.append(jieguo);
                                } else {
                                    shuchu.setText("not Integer!");
                                    str1 = str1.delete(0, str1.length());
                                    str1.append("");
                                }
                            }
                        }
                    }
                }
            }
        });
        button_seven = (Button) findViewById(R.id.seven);
        button_seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str1 = str1.append("7");
                qtmd.setText(str1);
            }
        });
        button_eight = (Button) findViewById(R.id.eight);
        button_eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str1 = str1.append("8");
                qtmd.setText(str1);
            }
        });
        button_nine = (Button) findViewById(R.id.nine);
        button_nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str1 = str1.append("9");
                qtmd.setText(str1);
            }
        });
        button_jia = (Button) findViewById(R.id.jia);
        button_jia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (str1.length() == 0) {
                    shuru.setText(str1);
                } else {
                    if (str1.charAt(str1.length() - 1) == '+' || str1.charAt(str1.length() - 1) == '-' || str1.charAt(str1.length() - 1) == '*' || str1.charAt(str1.length() - 1) == '/' || str1.charAt(str1.length() - 1) == '.') {
                        shuru.setText(str1);
                    } else {
                        str1.append("+");
                        shuru.setText(str1);
                    }
                }
            }
        });
        button_CE = (Button) findViewById(R.id.tuiwei);
        button_CE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (str1.length() > 0) {
                    str1.delete(str1.length() - 1, str1.length());
                    shuru.setText(str1);
                } else {
                    shuru.setText(str1);
                }
            }
        });

        button_four = (Button) findViewById(R.id.four);
        button_four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str1 = str1.append("4");
                qtmd.setText(str1);
            }
        });
        button_five = (Button) findViewById(R.id.five);
        button_five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str1 = str1.append("5");
                qtmd.setText(str1);
            }
        });
        button_six = (Button) findViewById(R.id.six);
        button_six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str1 = str1.append("6");
                qtmd.setText(str1);
            }
        });
        button_jian = (Button) findViewById(R.id.jian);
        button_jian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (str1.length() == 0) {
                    shuru.setText(str1);
                } else {
                    if (str1.charAt(str1.length() - 1) == '+' ||str1.charAt(str1.length() - 1) == '-' || str1.charAt(str1.length() - 1) == '*' || str1.charAt(str1.length() - 1) == '/' || str1.charAt(str1.length() - 1) == '.') {
                        shuru.setText(str1);
                    } else {
                        str1.append("-");
                        shuru.setText(str1);
                    }
                }
            }
        });
        button_pingfang = (Button) findViewById(R.id.pingfang);
        button_pingfang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (str1.length() > 0) {
                    String jieguo = new String(str1);
                    if (jieguo.contains("/0")) {
                        shuchu.setText("error,no/0");
                        str1 = str1.delete(0, str1.length());
                    } else {
                        if (str1.charAt(str1.length() - 1) == '+' || str1.charAt(str1.length() - 1) == '-' || str1.charAt(str1.length() - 1) == '*' || str1.charAt(str1.length() - 1) == '/') {
                            shuchu.setText("error,not complete");
                            str1 = str1.delete(0, str1.length());
                        } else {
                            jieguo = jisuan(str1);
                            jieguo = DoubleToString(Math.pow(StringtoDouble(jieguo),2));
                            shuchu.setText(jieguo);
                            str1 = str1.delete(0, str1.length());
                            str1.append(jieguo);
                        }
                    }
                }




            }
        });
        button_one = (Button) findViewById(R.id.one);
        button_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str1 = str1.append("1");
                qtmd.setText(str1);
            }
        });
        button_two = (Button) findViewById(R.id.two);
        button_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str1 = str1.append("2");
                qtmd.setText(str1);
            }
        });
        button_three = (Button) findViewById(R.id.three);
        button_three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str1 = str1.append("3");
                qtmd.setText(str1);
            }
        });
        button_cheng = (Button) findViewById(R.id.cheng);
        button_cheng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (str1.length() == 0) {
                    shuru.setText(str1);
                } else {
                    if (str1.charAt(str1.length() - 1) == '+' || str1.charAt(str1.length() - 1) == '-' || str1.charAt(str1.length() - 1) == '*' || str1.charAt(str1.length() - 1) == '/' || str1.charAt(str1.length() - 1) == '.') {
                        shuru.setText(str1);
                    } else {
                        str1.append("*");
                        shuru.setText(str1);
                    }
                }
            }
        });
        button_kaifang = (Button) findViewById(R.id.kaifang);
        button_kaifang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (str1.length() > 0) {
                    String jieguo = new String(str1);
                    if (jieguo.contains("/0")) {
                        shuchu.setText("error,no/0");
                        str1 = str1.delete(0, str1.length());
                    } else {
                        if (str1.charAt(str1.length() - 1) == '+' || str1.charAt(str1.length() - 1) == '-' || str1.charAt(str1.length() - 1) == '*' || str1.charAt(str1.length() - 1) == '/') {
                            shuchu.
                                    setText("error,not complete");
                            str1 = str1.delete(0, str1.length());
                        } else {
                            jieguo = jisuan(str1);
                            jieguo = DoubleToString(Math.sqrt(StringtoDouble(jieguo)));
                            shuchu.setText(jieguo);
                            str1 = str1.delete(0, str1.length());
                            str1.append(jieguo);
                        }
                    }
                }
            }
        });
        button_zero = (Button) findViewById(R.id.zero);
        button_zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str1 = str1.append("0");
                qtmd.setText(str1);
            }
        });
        button_point = (Button) findViewById(R.id.point);
        button_point.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(str1.length()==0){
                    str1.append(".");
                    shuru.setText(str1);
                }else {
                    if(!Character.isDigit(str1.charAt(str1.length()-1))){
                        str1.append("0");
                        shuru.setText(str1);
                    }
                    if (str1.charAt(str1.length() - 1) == '+' || str1.charAt(str1.length() - 1) == '-' || str1.charAt(str1.length() - 1) == '*' || str1.charAt(str1.length() - 1) == '/' || str1.charAt(str1.length() - 1) == '.') {
                        shuru.setText(str1);
                    } else {
                        String temp = new String(str1);
                        boolean flag = false;
                        ArrayList<String> cuttemp = cutString(temp);
                        for (int j = 0; j < cuttemp.get(cuttemp.size() - 1).length(); j++) {
                            if (cuttemp.get(cuttemp.size() - 1).charAt(j) == '.') {
                                flag = true;
                            }
                        }
                        if (flag == true) {
                            shuru.setText(str1);
                        } else {
                            str1.append(".");
                            shuru.setText(str1);
                        }
                    }
                }
            }
        });
        button_chu = (Button) findViewById(R.id.chu);
        button_chu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (str1.length() == 0) {
                    shuru.setText(str1);
                } else {
                    if (str1.charAt(str1.length() - 1) == '+' || str1.charAt(str1.length() - 1) == '-' || str1.charAt(str1.length() - 1) == '*' || str1.charAt(str1.length() - 1) == '/' || str1.charAt(str1.length() - 1) == '.') {
                        shuru.setText(str1);
                    } else {
                        str1.append("/");
                        shuru.setText(str1);
                    }
                }
            }
        });
    }

    final public String easyjisuan(String numa, int fuhao, String numb) {
        double num1 = new Double(numa);
        double num2 = new Double(numb);
        double num3;
        switch (fuhao) {
            case 1:
                num3 = num1 + num2;
                return "" + num3;
            case 2:
                num3 = num1 - num2;
                return "" + num3;
            case 3:
                num3 = num1 * num2;
                return "" + num3;
            case 4:
                num3 = num1 / num2;
                return "" + num3;
            default:
                return "error";
        }
    }

    public String jisuan(StringBuilder n) {
        String str1 = "" + n;
        ArrayList<String> str1_aftercut = new ArrayList<String>();
        int cixu[] = new int[99];                       //运算符次序控制数组
        int cixujug = 0;                                //运算符次序位置控制
        str1_aftercut = cutString(str1);
        ArrayList<String> smallnum =
                new ArrayList<String>();
        smallnum = str1_aftercut;
        /**
         * TODO 无法进行连续三角函数运算
         */
        for (int i = 0; i < n.length(); i++) {
            if (str1.charAt(i) == 's') {
                cixu[cixujug] = 1;
                cixujug++;
            }
            if (str1.charAt(i) == 'c') {
                cixu[cixujug] = 2;
                cixujug++;

            }
            if (str1.charAt(i) == 't') {
                cixu[cixujug] = 3;
                cixujug++;

            }
            if (str1.charAt(i) == '+') {
                cixu[cixujug] = 0;                  //加法
                cixujug++;

            }
            if (str1.charAt(i) == '-') {
                cixu[cixujug] = 0;                  //减法
                cixujug++;

            }
            if (str1.charAt(i) == '*') {
                cixu[cixujug] = 0;                  //乘法
                cixujug++;

            }
            if (str1.charAt(i) == '/') {
                cixu[cixujug] = 0;                  //除法
                cixujug++;
            }
        }
        //8-sin9-6
        //sin9+9+sin6+cos5
        //cixu[]==1,0,0,1,2
        //smallnum[]==9,9,6,5//每两个0跳过一次
        for (int i = 0; i < cixujug; i++) {         //三角函数最优先计算

            if (cixu[i] == 1) {
                smallnum.set(i, DoubleToString(Math.sin(SCTStringToDouble(smallnum.get(i)))));
                cixu[i] = 0;
                i++;
            }
            if (cixu[i] == 2) {
                smallnum.set(i, DoubleToString(Math.cos(SCTStringToDouble(smallnum.get(i)))));
                cixu[i] = 0;
                i++;
            }
            if (cixu[i] == 3) {
                smallnum.set(i, DoubleToString(Math.tan(SCTStringToDouble(smallnum.get(i)))));
                cixu[i] = 0;
                i++;
            }
        }

        cixu = new int[99];
        cixujug = 0;
        if (str1.charAt(0) != '-') {            //开始计算数列
            for (int i = 0; i < n.length(); i++) {                           //2+4*5-8/7
                if (str1.charAt(i) == '+') {
                    cixu[cixujug] = 1;                  //加法
                    cixujug++;
                }
                if (str1.charAt(i) == '-') {
                    cixu[cixujug] = 2;                  //减法
                    cixujug++;

                }
                if (str1.charAt(i) == '*') {
                    cixu[cixujug] = 3;                  //乘法
                    cixujug++;

                }
                if (str1.charAt(i) == '/') {
                    cixu[cixujug] = 4;                  //除法
                    cixujug++;
                }
                if (str1.charAt(i) == 's') {
                    i = i + 2;
                }
                if (str1.charAt(i) == 'c') {
                    i = i + 2;
                }
                if (str1.charAt(i) == 't') {
                    i = i + 2;
                }
            }
        } else {
            for (int i = 0; i < str1.length(); i++) {
                if (str1.charAt(i) == '+') {
                    cixu[cixujug] = 1;                  //加法
                }
                if (str1.charAt(i) == '-') {
                    cixu[cixujug] = 2;                  //减法
                    cixujug++;
                }
                if (str1.charAt(i) == '*') {
                    cixu[cixujug] = 3;                  //乘法
                    cixujug++;
                }
                if (str1.charAt(i) == '/') {
                    cixu[cixujug] = 4;                  //除法
                    cixujug++;
                }
                if (str1.charAt(i) == 's') {
                    i = i + 2;
                }
                if (str1.charAt(i) == 'c') {
                    i = i + 2;
                }
                if (str1.charAt(i) == 't') {
                    i = i + 2;
                }
            }
        }

        for (int i = 0; i < cixujug; i++) {         //乘除法优先计算
            if (cixu[i] == 3) {
                smallnum.set(i + 1, easyjisuan(smallnum.get(i), cixu[i], smallnum.get(i + 1)));
                smallnum.set(i, "0");
                cixu[i] = 1;
                if (i > 0) {
                    if (cixu[i - 1] == 2) {
                        cixu[i] = 2;
                    }
                }
            }
            if (cixu[i] == 4) {
                smallnum.set(i + 1, easyjisuan(smallnum.get(i), cixu[i], smallnum.get(i + 1)));
                smallnum.set(i, "0");
                cixu[i] = 1;
                if (i > 0) {
                    if (cixu[i - 1] == 2) {
                        cixu[i] = 2;
                    }
                }
            }
        }
        for (int i = 0; i < cixujug; i++) {
            if (cixu[i] == 1) {
                smallnum.set(i + 1, easyjisuan(smallnum.get(i), cixu[i], smallnum.get(i + 1)));
                smallnum.set(i, "0");
                cixu[i] = 1;
            }
            if (cixu[i] == 2) {
                smallnum.set(i + 1, easyjisuan(smallnum.get(i), cixu[i], smallnum.get(i + 1)));
                smallnum.set(i, "0");
                cixu[i] = 1;
            }
        }
        return smallnum.get(smallnum.size() - 1);
    }

    public ArrayList<String> cutString(String needTocut) {
        ArrayList<String> cut = new ArrayList<String>();
        String temp = "";
        int mark = 0;
        for (int i = 0; i < needTocut.length(); i++) {
            if (needTocut.charAt(i) != '+' && needTocut.charAt(i) != '-' && needTocut.charAt(i) != '*' && needTocut.charAt(i) != '/') {
                temp = temp + needTocut.charAt(i);
            } else {
                cut.add(temp);
                temp = "";
                mark = i + 1;
            }
        }//3+sin3//sin3+sin3
        temp = "";
        for (int i = mark; i < needTocut.length(); i++) {
            temp = temp + needTocut.charAt(i);
        }

        cut.add(temp);
        return cut;
    }

    public String DoubleToString(Double num) {
        String temp = "" + num;
        return temp;

    }

    public Double SCTStringToDouble(String num) {
        String temp = num.substring(3, num.length());
        Double number = new Double(temp);
        return number;
    }

    public Double StringtoDouble(String num) {
        Double number = new Double(num);
        return number;
    }

    public Double jiecheng(String num) {
        Double number = new Double(num);
        if (number < 0) {
            return -1.0;
        }
        if (number == 0) {
            return 1.0;
        }
        for (Double i = number - 1; i > 0; i--) {
            number = number * i;
        }
        return number;
    }

    public static boolean isInteger(String num) {
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        return pattern.matcher(num).matches();
    }

    public void caonimade(View View){
        if (str1.length() > 0) {
            String jieguo = new String(str1);
            if (jieguo.contains("/0")) {
                shuchu.setText("error");
                str1 = str1.delete(0, str1.length());
            } else {
                if (str1.charAt(str1.length() - 1) == '+' || str1.charAt(str1.length() - 1) == '-' || str1.charAt(str1.length() - 1) == '*' || str1.charAt(str1.length() - 1) == '/') {
                    shuchu.setText("not complete");
                    str1 = str1.delete(0, str1.length());
                } else {
                    jieguo = jisuan(str1);
                    shuchu.setText(jieguo);
                    str1 = str1.delete(0, str1.length());
                    str1.append(jieguo);
                }
            }
        }
    }
}

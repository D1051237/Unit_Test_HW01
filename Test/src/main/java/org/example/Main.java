package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

// Class triangle
class triangle {
    public static void main(String args[]){
        triangle t = new triangle();int a,b,c;
        for (int i = 0; i < 5; i++){
            try {
                Scanner sc = new Scanner(System.in);
                System.out.print("輸入a邊長: ");a = sc.nextInt();
                System.out.print("輸入b邊長: ");b = sc.nextInt();
                System.out.print("輸入c邊長: ");c = sc.nextInt();

                int r = t.checkTriangle(a,b,c);
                switch (r){
                    case 0:
                        System.out.printf("正三角形 三邊為(%d,%d,%d)\n",a,b,c);
                        break;
                    case 1:
                        System.out.printf("等腰直角三角形 三邊為(%d,%d,%d)\n",a,b,c);
                        break;
                    case 2:
                        System.out.printf("等腰三角形 三邊為(%d,%d,%d)\n",a,b,c);
                        break;
                    case 3:
                        System.out.printf("直角三角形 三邊為(%d,%d,%d)\n",a,b,c);
                        break;
                    case 4:
                        System.out.printf("一般三角形 三邊為(%d,%d,%d)\n",a,b,c);
                        break;
                }
            } catch (InputMismatchException ex){
                System.out.println("輸入型態錯誤!! ,請重新輸入!!");
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }

    // "正三角形" 0
    // "等腰直角三角形" 1
    // "等腰三角形" 2
    // "直角三角形" 3
    // "一般三角形" 4
    public int checkTriangle(int a, int b, int c) throws Exception{
        boolean zero = (a == 0 || b == 0 || c == 0);
        if(zero){
            throw new Exception("Zero Edge");
        }
        boolean negative = (a < 0 || b < 0 || c < 0);
        if(negative){
            throw new Exception("Negative Edge");
        }
        boolean fine = (a+b>c && b+c>a && a+c>b);
        if(!fine){
            throw new TriangleException(a,b,c);
        }

        if(a == b && b == c){
            return 0;// "正三角形" 0
        }
        else if(a == b || b == c || a == c){
            if(a*a + b*b == c*c) return 1;// "等腰直角三角形" 1
            else return 2;// "等腰三角形" 2
        }
        else if(a*a + b*b == c*c){
            return 3;// "直角三角形" 3
        }
        else{
            assert a!=b ;
            assert a!=c ;
            assert b!=c ;
            return 4;// "一般三角形" 4
        }
    }

    class TriangleException extends Exception {
        public TriangleException(int a, int b, int c) {
            super("Not allowed triangle");
        }
    }
}

// Class Person
class Person{
    String Name;
    int Birth_y;
    int age;
    float height;
    float weight;
    float BMI;

    public Person(String name, int birth_y){
        this.Name = name;
        this.Birth_y = birth_y;
    }

    public Person(String name, int birth_y, float height, float weight) throws Exception {
        this.Name = name;
        this.Birth_y = birth_y;
        this.age = 2023 - birth_y;
        if(age < 0 || age > 100){
            throw new Exception("invalid age");
        }
        setHW(height, weight);
    }

    public void setHW(float height, float weight) throws Exception {
        if (height > 2.2) {
            throw new Exception("invalid height");
        }
        this.height = height;
        this.weight = weight;
        this.BMI = weight / (height * height);
    }

    public float getBMI(){
        assert (this.BMI > 10 && this.BMI <= 50) : "invalid BMI";
        return this.BMI;
    }

    public int getAge(){
        return this.age;
    }

    public static void main(String args[]){
        Person King = new Person("King", 2003);
        float bmi;
        try {
            King.setHW(1.7f, 1000);
            bmi = King.getBMI();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        System.out.printf("%s's BMI: %.2f\n",King.Name,bmi);

        Person Joe = null;
        try {
            Joe = new Person("Joe", 1998, 1.7f, 60);
        } catch (Exception e){
            throw new RuntimeException(e);
        }
        bmi = Joe.getBMI();
        System.out.printf("%s's BMI: %.2f\n",Joe.Name,bmi);
    }
}
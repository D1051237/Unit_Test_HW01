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
    String Name; //姓名
    int Birth_y; //生日年
    int age; //年齡
    float height; //身高
    float weight; //體重
    float BMI;

    public Person(String name, int birth_y) throws Exception {
        this.Name = name;this.Birth_y = birth_y;
        this.age = 2023 - birth_y;
        if(age < 0 || age > 100){ //年齡超過100歲或少於0歲的情況
            throw new Exception("invalid age"); //拋出非法年齡
        }
    }

    public Person(String name, int birth_y, float height, float weight) throws Exception {
        this.Name = name;
        this.Birth_y = birth_y;
        this.age = 2023 - birth_y;
        if(age < 0 || age > 100){ //年齡超過100歲或少於0歲的情況
            throw new Exception("invalid age"); //拋出非法年齡
        }
        setHW(height, weight);
    }

    public void setHW(float height, float weight) throws Exception {
        if (height > 220 || height < 73) { //身高大於220公分或低於73公分的情況
            throw new Exception("invalid height"); //拋出非法身高
        }
        if (weight > 635 || weight < 0) { //體重大於635公斤或低於0公斤的情況
            throw new Exception("invalid weight"); //拋出非法體重
        }
        this.height = height;
        this.weight = weight;
        this.BMI = weight / (height/100 * height/100);
    }

    public float getBMI() throws Exception {
        if(this.BMI < 10 || this.BMI > 50){ // BMI小於10或大於50的情況
            throw new Exception("invalid BMI"); //拋出非法BMI
        }
        else{
            return this.BMI;
        }
    }
    public int getAge(){
        return this.age;
    }

    public static void main(String args[]){
        String name;int birth_y;float height;float weight;
        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("輸入名字: ");name = sc.nextLine();
            System.out.print("輸入生日年: ");birth_y = sc.nextInt();
            System.out.print("輸入身高(公分): ");height = sc.nextFloat();
            System.out.print("輸入體重(公斤): ");weight = sc.nextFloat();
            Person p = new Person(name,birth_y,height,weight);
            float bmi = p.getBMI();
            System.out.printf("---[%s's health information]---\n",p.Name);
            System.out.printf("\t%s is %d years old now.\n",p.Name,p.getAge());
            System.out.printf("\tThe BMI of %s is %.2f\n",p.Name,bmi);
        } catch (InputMismatchException ex){
            System.out.println("輸入型態錯誤!! ,請重新輸入!!");
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
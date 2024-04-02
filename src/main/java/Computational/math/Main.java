package Computational.math;

import Computational.math.Functions.Functions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        FabricMethods fabricMethods = new FabricMethods();
        try(BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))){
            do {
                System.out.println("Введите нумер одного из методов в списке: ");
                System.out.println("------------------------------------------");
                System.out.println("1. Метод половинного деления");
                System.out.println("2. Метод секущих");
                System.out.println("3. Метод простой итерации");
                System.out.println("4. Метод Ньютона");
                System.out.print(">>> ");
                String data = bf.readLine();

                if(data.equals("exit")) System.exit(1);
                try {
                    if (Integer.parseInt(data) <= 4 && Integer.parseInt(data) >= 1){

                        System.out.println("Выберите одно уравнение и введите его нумер: ");
                        Functions.printAllFunctions();
                        System.out.print(">>> ");
                        int numberOfChosenFunction = Integer.parseInt(bf.readLine());

                        System.out.println("Введите левую границу");
                        System.out.print(">>> ");
                        double a = Double.parseDouble(bf.readLine());
                        System.out.println("Введите правую границу");
                        System.out.print(">>> ");
                        double b = Double.parseDouble(bf.readLine());

                        if(a >= b){
                            System.out.println("левая граница должна быть меньше");
                            continue;
                        }

                        Functions functions = new Functions(numberOfChosenFunction);
                        if(functions.getValueOfChosenFunction(a) *functions.getValueOfChosenFunction(b) >= 0){
                            System.out.println("На промежутке ["+a+","+b+"] нет корней или их больше, чем один");
                            continue;
                        }
                        System.out.println("Введите точность");
                        System.out.print(">>> ");

                        float epsilon = Float.parseFloat(bf.readLine());
                        MethodName methodName = MethodName.values()[Integer.parseInt(data) - 1];
                        fabricMethods.executeMethod(methodName,a,b,epsilon,numberOfChosenFunction);
                        System.out.println();
                    }
                }catch (NumberFormatException e){
                    System.err.println("Введите нумер метода");
                }
            }while (true);

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }


    //   todo Вынести всю эту логику в отдельный класс?
    public static MethodName whichIsChosen(String data){
        switch (data){
            case "1":
                System.out.println("Выбран метод 1: ");
                break;
            case "2":
                System.out.println("Выбран метод 2");
                break;
            case "3":
                System.out.println("Выбран метод 3");
                break;
            case "4":
                System.out.println("Выбран метод 4");
                break;
            default:
                System.out.println("Получен не валидный ввод: " + data);
                break;
        }
        return MethodName.NEWTON_METHOD;
    }
}
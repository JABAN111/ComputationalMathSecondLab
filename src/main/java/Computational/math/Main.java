package Computational.math;

import Computational.math.Methods.HalfDivision.HalfDivision;

public class Main {
    public static void main(String[] args) {
        HalfDivision hf = new HalfDivision(-2.5,-2,0.01f,2);
        hf.solve();
//        try(BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))){
//            do {
//                System.out.println("Введите нумер одного из методов в списке: ");
//                System.out.println("------------------------------------------");
//                System.out.println("1. Метод половинного деления");
//                System.out.println("2. Метод секущих");
//                System.out.println("3. Метод простой итерации");
//                System.out.println("4. Метод Ньютона");
//                String data = bf.readLine();
//                whichIsChosen(data);
//
//
//                if(data.equals("exit")) System.exit(1);
//            }while (true);
//
//        } catch (IOException e) {
//            System.err.println(e.getMessage());
//        }
    }
   //todo Вынести всю эту логику в отдельный класс?
    public static void whichIsChosen(String data){
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
    }
}
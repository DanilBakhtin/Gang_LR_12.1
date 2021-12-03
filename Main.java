package Main;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.print("Внедрение агента в банду(1 - да, любое другое - нет): ");
        String choice = in.nextLine();

        boolean agent = false;
        if (choice.equals("1")) agent = true;

        //Создаем банду
        Gang gang = new Gang(agent);
        //Наблюдение
        gang.observation();
        //Старт ограбления
        gang.robbery();

    }
}

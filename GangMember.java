package Main;

import java.util.Observable;
import java.util.Observer;

//Абстрактный класс член банды
abstract class GangMember extends Observable implements Observer {

    //Имя члена банды
    private String name;

    //Сообщение от члена банды
    private String message;

    //Арестован или нет
    private boolean arrested = false;

    //Конструктор
    public GangMember(String name) {
        this.name = name;
    }

    //Метод интерфейса Observer
    @Override
    public void update(Observable o, Object arg) {

        //Если сообщение от главаря
        if (o.getClass() == Boss.class) {
            //Если идем грабить
            if (arg.equals("Идем грабить банк!"))
                System.out.println(name + " : Готов!");
            //Если арестованы
            else if (!arg.equals("Ограбление состоялось!"))
                arrest();
        }
    }

    public void arrest() {
        arrested = true;
        System.out.println(name + " : * арестован *");
    }

    public String getMessage() {
        System.out.println(name + " : " + message);
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
        setChanged();
    }

}

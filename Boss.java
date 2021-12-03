package Main;

import java.util.Observable;

// Класс главарь
public class Boss extends GangMember {


    public Boss(String name) {
        super(name);
    }

    //Переопределение метода суперкласса
    public void update(Observable o, Object arg) {

        //Если сообщение от носильщика(агента)
        if (o.getClass() == Porter.class) {
            //Если носильщик агент
            if(((Porter) o).isAgent()) {
                arrest();
                setMessage("Ограбление НЕ состоится!");
            }
            else setMessage("Ограбление состоялось!");
            //Отправка сообщений банде
            notifyObservers(getMessage());
        }
    }

}

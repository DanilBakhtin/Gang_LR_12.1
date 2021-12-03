package Main;

import java.util.Observable;

// Класс носильщик(агент)
class Porter extends GangMember {

    //Агент или нет
    private boolean isAgent;

    public Porter(String name,boolean isAgent) {
        super(name);
        this.isAgent = isAgent;
    }

    @Override
    public void update(Observable o, Object arg) {

        //Если сообщение получено от босса
        if (o.getClass() == Boss.class && arg.equals("Идем грабить банк!")) {
            //Если агент
            if (isAgent)
                setMessage("Полиция! Вы арестованы");
            else setMessage("Готов!");
            notifyObservers(getMessage());
        }
    }

    public boolean isAgent() {
        return isAgent;
    }
}

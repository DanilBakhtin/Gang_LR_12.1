package Main;

public class Gang {

    //Главарь
    private GangMember boss;
    //Взломщик
    private GangMember cracker;
    //Водитель
    private GangMember driver;
    //Носильщик(агент)
    private GangMember porter;

    /**
     * Конструктор с вводом полицеского агента
     * @param agent - будет агент в банде или нет
     */
    public Gang(boolean agent) {
        boss = new Boss("Главарь");
        cracker = new Cracker("Взломщик");
        driver = new Driver("Водитель");
        if (agent)
            porter = new Porter("Агент",true);
        else porter = new Porter("Носильщик",false);
    }

    //Метод для установки наблюдения
    public void observation(){
        boss.addObserver(porter);
        boss.addObserver(cracker);
        boss.addObserver(driver);

        porter.addObserver(cracker);
        porter.addObserver(driver);
        porter.addObserver(boss);
    }

    //Метод начала ограбления
    public void robbery(){
        //Главарь сообщает о ограблении банка
        boss.setMessage("Идем грабить банк!");
        //Сообщение отправляется наблюдателям
        boss.notifyObservers(boss.getMessage());
    }
}

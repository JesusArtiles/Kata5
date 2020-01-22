package kata5;

public class Main {

    public static void main(String[] args) {
        String URL = new String("jdbc:sqlite:/C:/Users/Jesús Artiles/IdeaProjects/Kata5/sqlite/Kata5.db");
        DataBase db = new DataBase(URL);
        db.open();
        db.selectPeople();
        People pepe = new People("Pablo", "Artiles", "DEO");
        db.insertPeople(pepe);
        System.out.println("----------------------------------------------");
        db.selectPeople();
        db.close();
    }
    
}

package kata5;

import java.sql.*;

class DataBase {
    private String URL;
    private Connection connection;
    
    public DataBase(String URL) {
        this.URL = URL;
    }

    void open() {
        try{
            if (connection == null) {
                connection = DriverManager.getConnection(URL);
                System.out.println("connection stablished");
            }            
        } catch(SQLException ex) {
            System.out.println("Conection fail: " + ex.getMessage());
        }
    }

    void close() {
        try {
            if (connection != null) {
                connection.close();
                System.out.println("You have been disconnected from the db successfully");
            }            
        } catch (SQLException ex) {
            System.out.println("Desconection fail: " + ex.getMessage());
        }
    }

    void selectPeople() {
        String SQL = "SELECT * FROM PEOPLE";
        try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(SQL);
            System.out.println("ID\tNAME\tSURNAME\tDEPARTMENT");
            while (result.next()) {                
                System.out.println(result.getInt("Id") + "\t" + 
                                   result.getString("Name") + "\t" +
                                   result.getString("Surname") + "\t" +
                                   result.getString("Department") + "\t");
            }
        } catch (SQLException ex) {
            System.out.println("Fail select from: " + ex.getMessage());
        }
    }

    void insertPeople(People people) {
        String SQL = "INSERT INTO PEOPLE(NAME, SURNAME, DEPARTMENT) VALUES(?, ?, ?)";
        try {
            PreparedStatement prepareStatement = this.connection.prepareStatement(SQL);
            prepareStatement.setString(1, people.getName());
            prepareStatement.setString(2, people.getSurname());
            prepareStatement.setString(3, people.getDepartment());
            prepareStatement.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("fail inserting people: " + ex.getMessage());
        }
    }

}

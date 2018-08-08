package Services.DAO;
import Models.Client.Client;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ClientDao {
    private Connection connection;
    // CREATE TABLE client (ID INT PRIMARY KEY, NAME VARCHAR(255), SURNAME VARCHAR(255), AGE INT);

    public ClientDao() {
        try {
            Class.forName("org.h2.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:h2:~/myDb",
                    "", "");
            isAbsentClientDao();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    private void isAbsentClientDao() {
        String sql = "SELECT * FROM INFORMATION_SCHEMA.TABLES";
        try (PreparedStatement ps = connection.prepareStatement(sql);
        ) {
            ResultSet rs = ps.executeQuery();
            boolean isAbsentClientDao = true;
            while (rs.next()) {
                if (Objects.equals(rs.getString("TABLE_NAME"), "CLIENT")) {
                    isAbsentClientDao = false;
                    break;
                }
            }
            if(isAbsentClientDao) {
                sql ="CREATE TABLE CLIENT (ID BIGINT AUTO_INCREMENT PRIMARY KEY, NAME VARCHAR(100), SURNAME VARCHAR (100), AGE INTEGER(2))";
                try (Statement st = connection.createStatement()) {
                    st.execute(sql);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addClient(Client client){
        try(PreparedStatement ps =
        connection.prepareStatement("INSERT INTO client (id, name, surname, age) VALUES (? , ?, ?, ?)")){
            ps.setInt(1, client.getId());
            ps.setString(2, client.getName());
            ps.setString(3, client.getSurname());
            ps.setInt(4, client.getAge());
            ps.execute();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public List<Client> getAll(){
            try(PreparedStatement ps =
            connection.prepareStatement("SELECT * FROM client")){
              ResultSet resultSet = ps.executeQuery();
              List<Client> clients = new ArrayList<>();
              while (resultSet.next()) {
                  int id = resultSet.getInt("id");
                  String name = resultSet.getString("name");
                  String surname = resultSet.getString("surname");
                  int age = resultSet.getInt("age");
                  clients.add(new Client(id, name, surname, age));
              }
            }catch (Exception e){
                e.printStackTrace();
            }
            return new ArrayList<>();
    }
    public void updateClient(Client client){
        try (PreparedStatement ps = connection.prepareStatement(
            "UPDATE client SET name = ?, surname = ?, age = ? WHERE id = ?")){
            ps.setString(1, client.getName());
            ps.setString(2, client.getSurname());
            ps.setInt(3, client.getAge());
            ps.setLong(4, client.getId());
            ps.executeUpdate();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void removeClient(int id){
        try(PreparedStatement ps = connection.prepareStatement(
                "DELETE FROM client WHERE id = " + id)){
            ps.executeUpdate();

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

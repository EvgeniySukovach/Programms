package Services.DAO;
import Models.Client.Client;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientDao {
    private Connection connection;

    public ClientDao() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/mydbtest?useUnicode=true&useSSL=true&useJDBCCompliantTimezoneShift=true\" +\n" +
                            "                    \"&useLegacyDatetimeCode=false&serverTimezone=UTC",
                    "root", "root");
        } catch (Exception e){
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

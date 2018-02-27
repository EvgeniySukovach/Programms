package Services.DAO;
import Models.Product.Product;
import java.sql.DriverManager;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {
    private Connection connection;

    public ProductDao() {
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
    public List<Product> getAll(){
        try(PreparedStatement ps = connection.prepareStatement(
                "SELECT * FROM product")){
            ResultSet resultSet = ps.executeQuery();
            List<Product> products = new ArrayList<>();
            while (resultSet.next()){
                int articl = resultSet.getInt("articl");
                String productName = resultSet.getString("productName");
                String brandName = resultSet.getString("brandName");
                int price = resultSet.getInt("price");
                products.add(new Product(articl, productName, brandName, price));
            }
        }catch (Exception e){
            e.printStackTrace();
        } return new ArrayList<>();
    }

    public void addProduct(Product product){
        try(PreparedStatement ps = connection.prepareStatement(
                "INSERT INTO product (articl, productName, brandName, price) VALUES (?, ?, ?, ?) ")){
            ps.setInt(1, product.getArticl());
            ps.setString(2, product.getProductName());
            ps.setString(3, product.getBrandName());
            ps.setLong(4, product.getPrice());
            ps.execute();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void updateProduct (Product product){
        try (PreparedStatement ps = connection.prepareStatement(
                "UPDATE product SET productName = ?, brandName = ?, price = ? WHERE articl = ?")){
            ps.setString(1, product.getProductName());
            ps.setString(2, product.getBrandName());
            ps.setInt(3, product.getPrice());
            ps.setLong(4, product.getArticl());
            ps.executeUpdate();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void removeProduct(int articl){
        try(PreparedStatement ps = connection.prepareStatement(
                "DELETE FROM product" + " WHERE articl =  " + articl)){

            ps.executeUpdate();

        }catch(Exception e){
            e.printStackTrace();
        }

    }
}

package Services.DAO;
import Models.Product.Product;
import java.sql.DriverManager;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ProductDao {
    private Connection connection;

    public ProductDao() {
        try {
            Class.forName("org.h2.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:h2:~/myDb", "", "");
            isAbsentProductDao();
        } catch (Exception e){
           e.printStackTrace();
        }
    }

    private void isAbsentProductDao() {
        String sql = "SELECT * FROM INFORMATION_SCHEMA.TABLES";
        try (PreparedStatement ps = connection.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            boolean isAbsentProductDao = true;
            while (rs.next()) {
                if (Objects.equals(rs.getString("TABLE_NAME"), "PRODUCT")) {
                    isAbsentProductDao = false;
                    break;
                }
            }
            if(isAbsentProductDao) {
                sql ="CREATE TABLE PRODUCT (articl BIGINT AUTO_INCREMENT PRIMARY KEY, productName VARCHAR(100), brandName VARCHAR(100), price NUMERIC(11,2))";
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

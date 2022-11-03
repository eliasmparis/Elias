/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Elias
 */
public class Produto {
    
    private String nome;
    private int sku;
    private int price;
    private int quantity;
    private String categories;
    private String description;

    /**
     * @return the name
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param name the name to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the sku
     */
    public int getSku() {
        return sku;
    }

    /**
     * @param sku the sku to set
     */
    public void setSku(int sku) {
        this.sku = sku;
    }

    /**
     * @return the preco
     */
    public int getPrice() {
        return price;
    }

    /**
     * @param preco the preco to set
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * @return the categories
     */
    public String getCategories() {
        return categories;
    }

    /**
     * @param categories the categories to set
     */
    public void setCategories(String categories) {
        this.categories = categories;
    }
    
     public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public void inserir() throws Exception {
        Connection con = null;
        PreparedStatement pstmt = null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lojas", "root", "");

            pstmt = con.prepareStatement("insert into produtos (nome,sku,price,quantity,categories,description) value (?, ?, ?, ?, ?, ?)");
            pstmt.setString(1, this.nome);
            pstmt.setInt(2, this.sku);
            pstmt.setInt(3, this.price);
            pstmt.setInt(4, this.quantity);
            pstmt.setString(5, this.categories);
            pstmt.setString(6,this.description);
            pstmt.execute();
        } catch (Exception e) {
            throw e;
        } finally {
            if (pstmt != null) pstmt.close();
            if (con != null) con.close();
        }
    }
    
     public void atualizar() throws Exception {
        Connection con = null;
        PreparedStatement pstmt = null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lojas", "root", "");

            pstmt = con.prepareStatement("update produtos set sku = ?, price = ?, quantity = ?, categories = ? description = ? where nome = ?");
           
            pstmt.setString(1, this.nome);
            pstmt.setInt(2, this.sku);
            pstmt.setInt(3, this.price);
            pstmt.setInt(4, this.quantity);
            pstmt.setString(5, this.categories);
            pstmt.setString(6, this.description);
            pstmt.execute();
        } catch (Exception e) {
            throw e;
        } finally {
            if (pstmt != null) pstmt.close();
            if (con != null) con.close();
        }
    }
    
     public Produto[] consultar() throws Exception {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Produto> produtos = new ArrayList();
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lojas", "root", "");

            pstmt = con.prepareStatement("select * from produtos where nome like ?");
            pstmt.setString(1, this.getNome());
            
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Produto prod = new Produto();
                
                prod.setNome(rs.getString("nome"));
                prod.setSku(Integer.parseInt(rs.getString("sku")));
                prod.setPrice(Integer.parseInt(rs.getString("price")));
                prod.setQuantity(Integer.parseInt(rs.getString("quantity")));
                prod.setCategories(rs.getString("categories"));
                prod.setCategories(rs.getString("description"));
                produtos.add(prod);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if (pstmt != null) pstmt.close();
            if (con != null) con.close();
        }
        
        return produtos.toArray(new Produto[0]);
    }
     
     public void excluir() throws Exception {
        Connection con = null;
        PreparedStatement pstmt = null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lojas", "root", "");

            pstmt = con.prepareStatement("delete from produtos where nome = ?");
            pstmt.setString(1, this.nome);
            
            pstmt.execute();
        } catch (Exception e) {
            throw e;
        } finally {
            if (pstmt != null) pstmt.close();
            if (con != null) con.close();
        }
    }
     
     public void consultarPorNome() throws Exception {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lojas", "root", "");

            pstmt = con.prepareStatement("select * from produtos where nome = ?");
            pstmt.setString(1, this.getNome());
            
            rs = pstmt.executeQuery();
            if (rs.next()) {
                this.setNome(rs.getString("nome"));
                this.setSku(Integer.parseInt(rs.getString("sku")));
                this.setPrice(Integer.parseInt(rs.getString("price")));
                this.setQuantity(Integer.parseInt(rs.getString("quantity")));
                this.setCategories(rs.getString("categories"));
                this.setDescription(rs.getString("description"));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if (pstmt != null) pstmt.close();
            if (con != null) con.close();
        }
    }   

    void setCodigo(int parseInt) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}    


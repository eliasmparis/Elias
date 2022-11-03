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
public class Categoria {
        private int codigo;
        private String nome;

    /**
     * @return the code
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * @param code the code to set
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the Nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param Nome the Nome to set
     */
    public void setNome(String Nome) {
        this.nome = Nome;
    }

public void inserir() throws Exception {
        Connection con = null;
        PreparedStatement pstmt = null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lojas", "root", "");

            pstmt = con.prepareStatement("insert into categorias (nome,codigo) value (?, ?)");
            pstmt.setString(1, this.nome);
            pstmt.setInt(2, this.codigo);
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

            pstmt = con.prepareStatement("update categorias set codigo = ? where nome = ?");
           
            pstmt.setString(1, this.nome);
            pstmt.setInt(2, this.codigo);
            pstmt.execute();
        } catch (Exception e) {
            throw e;
        } finally {
            if (pstmt != null) pstmt.close();
            if (con != null) con.close();
        }
    }
    
     public Categoria[] consultar() throws Exception {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Categoria> categorias = new ArrayList();
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lojas", "root", "");

            pstmt = con.prepareStatement("select * from categorias where nome like ?");
            pstmt.setString(1, this.getNome());
            
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Categoria cat = new Categoria();
                
                cat.setNome(rs.getString("nome"));
                cat.setCodigo(Integer.parseInt(rs.getString("codigo")));
                categorias.add(cat);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if (pstmt != null) pstmt.close();
            if (con != null) con.close();
        }
        return categorias.toArray(new Categoria[0]);
    }
     
     public void excluir() throws Exception {
        Connection con = null;
        PreparedStatement pstmt = null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lojas", "root", "");

            pstmt = con.prepareStatement("delete from categorias where nome = ?");
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

            pstmt = con.prepareStatement("select * from categorias where nome = ?");
            pstmt.setString(1, this.getNome());
            
            rs = pstmt.executeQuery();
            if (rs.next()) {
                this.setNome(rs.getString("nome"));
                this.setCodigo(Integer.parseInt(rs.getString("codigo")));
                
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if (pstmt != null) pstmt.close();
            if (con != null) con.close();
        }
    }
}
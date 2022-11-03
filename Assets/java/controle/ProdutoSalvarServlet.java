/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controle;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Produto;

/**
 *
 * @author Elias
 */
@WebServlet(name = "ProdutoSalvarServlet", urlPatterns = {"/ProdutoSalvarServlet"})
public class ProdutoSalvarServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ProdutoSalvarServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProdutoSalvarServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
   @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String botao = request.getParameter("botao");
            if (botao.equals("Salvar")) {
               Produto prod = new Produto();

                prod.setNome(request.getParameter("nome"));
                prod.setSku(Integer.parseInt(request.getParameter("sku")));
                prod.setPrice(Integer.parseInt(request.getParameter("price")));
                prod.setQuantity(Integer.parseInt(request.getParameter("quantity")));
                prod.setCategories(request.getParameter("categories"));
                prod.setDescription(request.getParameter("description"));
                prod.inserir();
               
                request.setAttribute("msg", "Produto foi salvo com sucesso!!!!");
            }
            RequestDispatcher despachar = request.getRequestDispatcher("products.jsp");
            despachar.forward(request, response);  
        } catch (Exception e) {
            request.setAttribute("msg", e.getMessage());
            RequestDispatcher despachar = request.getRequestDispatcher("erros.jsp");
            despachar.forward(request, response);  
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

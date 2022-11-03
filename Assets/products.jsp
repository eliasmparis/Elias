<%@page import="modelo.Produto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>Webjump | Backend Test | Products</title>
  <meta charset="utf-8">

<link  rel="stylesheet" type="text/css"  media="all" href="css/style.css" />
<link href="https://fonts.googleapis.com/css?family=Open+Sans:400,800" rel="stylesheet">
<meta name="viewport" content="width=device-width,minimum-scale=1">
<style amp-boilerplate>body{-webkit-animation:-amp-start 8s steps(1,end) 0s 1 normal both;-moz-animation:-amp-start 8s steps(1,end) 0s 1 normal both;-ms-animation:-amp-start 8s steps(1,end) 0s 1 normal both;animation:-amp-start 8s steps(1,end) 0s 1 normal both}@-webkit-keyframes -amp-start{from{visibility:hidden}to{visibility:visible}}@-moz-keyframes -amp-start{from{visibility:hidden}to{visibility:visible}}@-ms-keyframes -amp-start{from{visibility:hidden}to{visibility:visible}}@-o-keyframes -amp-start{from{visibility:hidden}to{visibility:visible}}@keyframes -amp-start{from{visibility:hidden}to{visibility:visible}}</style><noscript><style amp-boilerplate>body{-webkit-animation:none;-moz-animation:none;-ms-animation:none;animation:none}</style></noscript>
<script async src="https://cdn.ampproject.org/v0.js"></script>
<script async custom-element="amp-fit-text" src="https://cdn.ampproject.org/v0/amp-fit-text-0.1.js"></script>
<script async custom-element="amp-sidebar" src="https://cdn.ampproject.org/v0/amp-sidebar-0.1.js"></script></head>
  <!-- Header -->
<amp-sidebar id="sidebar" class="sample-sidebar" layout="nodisplay" side="left">
  <div class="close-menu">
    <a on="tap:sidebar.toggle">
      <img src="images/bt-close.png" alt="Close Menu" width="24" height="24" />
    </a>
  </div>
  <a href="dashboard.jsp"><img src="images/menu-go-jumpers.png" alt="Welcome" width="200" height="43" /></a>
  <div>
    <ul>
      <li><a href="index.jsp" class="link-menu">Home</a></li>
      <li><a href="categories.jsp" class="link-menu">Categorias</a></li>
      <li><a href="products.jsp" class="link-menu">Produtos</a></li>
    </ul>
  </div>
</amp-sidebar>
<header>
  <div class="go-menu">
    <a on="tap:sidebar.toggle">☰</a>
    <a href="dashboard.jsp" class="link-logo"><img src="images/go-logo.png" alt="Welcome" width="69" height="430" /></a>
  </div>
  <div class="right-box">
    <span class="go-title">Administration Panel</span>
  </div>    
</header>  
<!-- Header --><body>
  <!-- Main Content -->
  <main class="content">
       <div class="row">
    <div class="header-list-page">
      <form action="ProdutoConsultaServlet" id="formulario" method="get">
      <h1 class="title">Products</h1>
      <a href="addProduct.jsp" class="btn-action">Add new Product</a>
       <%
                    String msg = (String)request.getAttribute("msg");
                    if (msg != null && !msg.equals("")) {
                %>
                  <p style="color:red;"><%= msg%></p>
                    <%
                        }
                    %>
                    <div class="form-group col-8">
                    <label for="nome">Nome:</label>
                    <input name="nome" id="nome" value="" type="text" class="form-control " />
                    <input type="submit" id="acao" name="acao" class="" value="Filtrar" onclick="javascript: ProdutoConsultaServlet">
            </div>
        </div>

        <br>
              <form action="ProdutoServlet" method="post">
              <input type="submit" name="acao" value="inserir">
              <input type="submit" name="acao" value="atualizar">
              <input type="submit" name="acao" value="excluir">
                    
    </div>
    <table class="data-grid">
      <tr class="data-row">
        <th class="data-grid-th">
            <span class="data-grid-cell-content">Selecao</span>
        </th>
        <th class="data-grid-th">
            <span class="data-grid-cell-content">Nome</span>
        </th>
        <th class="data-grid-th">
            <span class="data-grid-cell-content">SKU</span>
        </th>
        <th class="data-grid-th">
            <span class="data-grid-cell-content">Price</span>
        </th>
        <th class="data-grid-th">
            <span class="data-grid-cell-content">Quantity</span>
        </th>
        <th class="data-grid-th">
            <span class="data-grid-cell-content">Categories</span>
        </th>
        <th class="data-grid-th">
            <span class="data-grid-cell-content">Description</span>
        </th>
        </tr>
        <%
                     Produto produtos[] = (Produto[])request.getAttribute("produto");

                     if (produtos == null) produtos = new Produto[0];

                     for (int i=0; i<produtos.length; i++) {
        %>
                     
                <tr>
                    <td> <input type="radio" name="selecao" value="<%= produtos[i].getNome()%>"></td>
                    <td><%= produtos[i].getNome()%></td>
                    <td><%= produtos[i].getSku()%></td>
                    <td><%= produtos[i].getPrice()%></td>
                    <td><%= produtos[i].getQuantity()%></td>
                    <td><%= produtos[i].getCategories()%></td>
                    <td><%= produtos[i].getDescription()%></td>
                </tr>
                <%
                    }
                %>
    </form>
    </table>
  </main>
  <!-- Main Content -->

  <!-- Footer -->
<footer>
	<div class="footer-image">
	  <img src="images/go-jumpers.png" width="119" height="26" alt="Go Jumpers" />
	</div>
	<div class="email-content">
	  <span>go@jumpers.com.br</span>
	</div>
</footer>
 <!-- Footer --></body>
</html>

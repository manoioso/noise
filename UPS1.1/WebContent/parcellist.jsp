<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="mongodb.model.Tracking"%>
<%@page import="mongodb.dao.TrackingDao"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>


<%


    String errmsg = "";
    
    TrackingDao productDao = new TrackingDao();

    List<Tracking> products = productDao.getList();
    if (products == null || products.size() == 0) {
        errmsg = "There is no product!";
    }
    
    pageContext.setAttribute("errmsg", errmsg);
    pageContext.setAttribute("products", products);
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>>UPS Global Shipping</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<jsp:include page="header.jsp" />

<div class="container">
  <h2>Current parcel in transit</h2>
  
  <table class="table">
    <thead>
      <tr>
        <th>Tracking Number</th>
        <th>Parcel Name</th>
        <th>Value estimate</th>
        <th>Operations</th>
      </tr>
    </thead>
    <tbody>
      <c:choose>
        <c:when test="${not empty errmsg}">
          <tr style='color:red'><td>${errmsg}</td></tr>
        </c:when>
        <c:otherwise>
          
          <%
                    
                     Iterator <Tracking> iterator = products.iterator(); 
                              	while (iterator.hasNext()) {    
                              		Tracking p = iterator.next();
                    %>
            <tr>
              <td> <% out.print( p.getTrackingNumber()); %> </td >
              <td> <% out.print( p.getName()); %> </td>
              <td> <% out.print( p.getPrice()); %> </td>
              <td><a class="btn btn-success"> view tracking history</a>&nbsp;<a class="btn btn-danger" onclick="return confirm('Are you sure to delete this tracking history?')">Delete</a></td>
            </tr>
          <%} %>  
            
         
        </c:otherwise>
      </c:choose>
    </tbody>
  </table>
  
</div>
</body>
</html>
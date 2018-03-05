<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@page import="com.cart.Cart"%>
<%@page import="com.cart.CartItem"%>

<jsp:useBean id="update" class="com.cart.Cart"/>
   <jsp:setProperty name="update" property="*"/>
   
    <% 
   try
   {
   String str[]=request.getParameterValues("action"); 
   String quantity[]=request.getParameterValues("quantity");
   ArrayList al=(ArrayList)application.getAttribute("cartdetail");
  
  for(int i=0;i<str.length;i++)
  {
  int check=Integer.parseInt(str[i]);
  int q=Integer.parseInt(quantity[check-1]);
  
  CartItem ci=(CartItem)al.get(check-1);
  String ss=String.valueOf(q);
  
  al=update.update_cart(q,check-1,al);
 application.setAttribute("cartdetail",al);
  
  }
   
  }
  catch(Exception e)
  {
 out.println(e);
  }
  
   response.sendRedirect("showcart.jsp");
 
    %>

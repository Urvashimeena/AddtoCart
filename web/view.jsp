<%@page import="java.sql.*"%>
<%@page import="com.dbconnection.LoadConnection"%>
<%try
    {
        Connection con=LoadConnection.getConnection();
        PreparedStatement ps=con.prepareStatement("select * from product");
        ResultSet rs=ps.executeQuery();
        while(rs.next())
        {%>
            
        <div style="float: left;margin-left: 5px;">
                <img src="../img/<%=rs.getString("image")%>" style="height: 200px;width: 200px;"/><br/>
                <span style="color:green;">Price: <%=rs.getString("price")%>     </span>
                <a href="addcart.jsp?name=<%=rs.getString("name")%>&model=<%=rs.getString("model")%>&price=<%=rs.getInt("price")%>&desc=<%=rs.getString("description")%>&img=<%=rs.getString("image")%>" 
                   style="background-color: #008DB8;height: 42px;border-radius: 5px;">Add To Cart</a>
            </div>
        <%}
        
    }catch(Exception e)
    {
            out.println(e);
    }
    %>
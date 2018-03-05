package com.connect;

import java.sql.Connection;
import java.sql.DriverManager;


public class DBConnection 
{
   static Connection con=null;
    public static Connection getConnection()
    {
       try
        {
        String driver=System.getProperty("dbdriver");
        String url=System.getProperty("dburl");
        String user=System.getProperty("dbuser");
        String password=System.getProperty("dbpassword");

        if(con==null)
        {
        Class.forName(driver);
        con=DriverManager.getConnection(url,user,password);
        }
        return con;
        }catch(Exception e)
        {
            return con;
        }

    }
}

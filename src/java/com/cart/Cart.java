package com.cart;
import java.util.*;
import java.sql.*;
import com.connect.DBConnection;

public class Cart 
{
	private String name;
	private String model;
	private int price;
        private String image;
	private String description;
	private int[] action;
	private ArrayList<CartItem> al;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
	
	
	public ArrayList<CartItem> addtocart(CartItem items, ArrayList<CartItem> al)
	{
		if(al.isEmpty())
		{
			al=new ArrayList<CartItem>();			
		}
		boolean b=al.add(items);
		System.out.println("cart is added :"+b);
		setCart(al);
		return al;				
	}
	
	
	public ArrayList removecart(int index,ArrayList al)
	{
		al.remove(index);
		return al;
		
	}

	public ArrayList<CartItem> update_cart(int quantity, int index,ArrayList<CartItem> al)
	{
		CartItem ci=al.get(index);
	
		al.set(index, ci);
		return al;

	}
	
	
	public void setCart(ArrayList<CartItem> al)
	{
		if(al.isEmpty())
		{
			al=new ArrayList<CartItem>();			
		}
		this.al=al;		
	}
	
	public ArrayList<CartItem> getCart()
	{
		
		return al;
	}


	
	public boolean savecart(ArrayList<CartItem> al,String email)
	{
		try
		{
			System.out.println(name);
			System.out.println("method call save cart");
			Connection con=DBConnection.getConnection();
			Statement st=con.createStatement();
			
			Iterator it=al.iterator();
			ResultSet rs=st.executeQuery("select * from cart where email='"+name+"'");
			
		
			
			String id=email;
			
			/*while(rs.next())
			{
				String username=rs.getString("name");
				id=rs.getString("email");
				String address=rs.getString("address");
			}
			*/
			
			//System.out.println(username);
			//System.out.println(id);
			//System.out.println(address);
			
			while(it.hasNext())
			{
				System.out.println("saving data");
				CartItem ci=(CartItem)it.next();
				
				int n=st.executeUpdate("insert into cart values('"+name+"','"+model+"','"+ci.getName()+"','"+ci.getModel()+"',"+ci.getPrice()+") ");
				
				
				System.out.println("n="+n);
				
				/*ps1.setString(1,username);
				ps1.setString(2,id);
				ps1.setString(3,address);
				ps1.setString(4,ci.getName());
				ps1.setString(5,ci.getCategory());
				ps1.setDouble(6,ci.getPrice());
				*/
				
				
			}
			
			return true;
			
			
			
		}
		catch(Exception e)
		{
			System.out.println(e);
			return false;
		}
		
		
	}
public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getModel() {
		return model;
	}


	public void setModel(String model) {
		this.model = model;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public ArrayList<CartItem> getAl() {
		return al;
	}


	public void setAl(ArrayList<CartItem> al) {
		this.al = al;
	}


	public void setAction(int[] action) {
		this.action = action;
	}


	public int[] getAction() {
		return action;
	}

}

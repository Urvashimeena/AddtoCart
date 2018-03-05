
        <div style=" font-size: 15; float: right;height:500; width: 30%">
            <form action="addproduct.jsp" method="post" enctype="multipart/form-data" >
               Product Name <input type="text" name="name" required=""><br><br>
               Model<input type="text" name="model" required=""><br><br>
               category
               <select name="cat">
                   <option value="shirt">shirt</option>
                   <option value="pent">pent</option>
               </select><br/><br/>
                price<input type="text" name="price" required=""><br><br>
                Image <input type="file" name="image" required=""><br><br>
                description <input type="text" name="desc" required=""><br><br>
                 
              <input type="submit" name="submit" value="Submit"> 
                 
            </form>   
         
           
        </div>

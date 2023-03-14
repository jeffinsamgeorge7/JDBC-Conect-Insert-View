import java.awt.Component;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

#Coonection code!!!!
  
 public static Connection myConnection()
    {
     Connection con = null;

     try{
      Class.forName("com.mysql.cj.jdbc.Driver");
      String connectionUrl="jdbc:mysql://localhost:3306/db_name?"+"user=root&password=root";
       con = DriverManager.getConnection(connectionUrl);
       }  
        catch (ClassNotFoundException ex) {
            Logger.getLogger(logframe.class.getName()).log(Level.SEVERE, null, ex);
          }  
     catch (SQLException ex)
     {
     Logger.getLogger(logframe.class.getName()).log(Level.SEVERE, null, ex);
     }
      return con;
     }

#Action button!!!!
  
 private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                        
                   Connection con = myConnection();
       try{
           String sql="INSERT INTO table_name(`id`,`username`,`password`,`email`) VALUES (?,?,?,?)";
         

           PreparedStatement prest,prest2;
           prest = con.prepareStatement(sql);
         
           prest.setString(1,text1.getText());
           prest.setString(2,text2.getText());
           prest.setString(3,text3.getText());
           prest.setString(4,text4.getText());
           prest.executeUpdate();
           con.close();
         } catch (SQLException ex) {
            Logger.getLogger(logframe.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

#Table view!!!!
  
public void setpersontabledate(){
      Connection con=myConnection();
      try{
           PreparedStatement prest;
           String sql ="select * from table_name";
           prest= con.prepareStatement(sql);
           ResultSet rs =prest.executeQuery(sql);
           
           
           while(rs.next()){
           String id =String.valueOf(rs.getInt("id"));
           String username=rs.getString("username");
           String password=rs.getString("password");
           String email=rs.getString("email");
           String tbData[]={id,username,password,email};
           DefaultTableModel tblModel=(DefaultTableModel)tabledb.getModel();//table variable name
            tblModel.addRow(tbData);

           }
           
      }
      catch (SQLException ex) {
            Logger.getLogger(logframe.class.getName()).log(Level.SEVERE, null, ex);
        }

     }

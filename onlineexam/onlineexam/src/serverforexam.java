
import com.vmm.JHTTPServer;
import java.io.IOException;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class serverforexam extends JHTTPServer {

    public serverforexam(int port) throws IOException {
        super(port);
    }

    /**
     * This is the common function which will receive the client's request and
     * will serve the response accordingly. for e.g 1. if request is for
     * /GetResource( image preview / any file download ) call
     * sendCompleteFile(uri) 2. if request is for /StreamMedia ( stream audio /
     * video ) call streamFile(uri,method,header) 3. in case of any other custom
     * request prepare your own response and return
     *
     * NOTE: In case of File upload (client to server) call any of the two
     * functions 1. saveFileOnServerWithOriginalName(files,parms,name,abspath)
     * 1. saveFileOnServerWithRandomName(files,parms,name,abspath)
     *
     *
     * @param uri will contain the extracted uri from the complete URL for e.g
     * (/GetResource/c1.jpg) (/GetResource/one.mp3) (/StreamMedia/ome.mp4)
     * @param method contains GET,POST,HEAD
     * @param header contains the extra header data (range, user-agent etc)
     * @param parms contains the query string parameters to extract text data
     * e.g String email = parms.getProperty("email");
     *
     * @param files contains the files in form of file upload(POST request)
     * filename = saveFileOnServerWithRandomName(files, parms, field_name,
     * abs_path);
     * @return
     */
    @Override
    public Response serve(String uri, String method, Properties header, Properties parms, Properties files) {

        Response res = null;

        System.out.println("URI "+uri);
        
        if (uri.contains("/GetResource")) //request should be of the form /GetResource/one.jpg
        {
            uri = uri.substring(1);
            uri = uri.substring(uri.indexOf("/") + 1);
            System.out.println(uri +" *** " );
            res = sendCompleteFile(uri);
        } 
        else if (uri.contains("/StreamMedia")) //request should be of the form /GetResource/one.jpg
        {
            uri = uri.substring(1);
            uri = uri.substring(uri.indexOf("/") + 1);
            System.out.println(uri +" *** " );
            res = streamFile(uri, method, header);
        } 
        
        else if (uri.contains("/AdminLogin")) //any custom logic , except downloading and streaming 
        {
            String username = parms.getProperty("username");
            String password = parms.getProperty("password");
                 ResultSet rs = DBLoader.executeQuery("select *from admin where username = '" + username + "' and password = '" + password + "'");
                 String ans = "";
                 try
                 {
                     if(rs.next())
                     {
                         ans = "success";
                     }
                     else
                     {
                         ans = "failed";
                     }
                 }
                 catch(SQLException ex)
                 {
                     Logger.getLogger(serverforexam.class.getName()).log(Level.SEVERE,null,ex);
                 }
                      
            res = new Response(HTTP_OK, "text/plain", ans);
            }
         else if (uri.contains("/adminchangepassword")) //any custom logic , except downloading and streaming 
        {
            String username = parms.getProperty("username");
            String oldpass = parms.getProperty("oldpass");
            String newpass = parms.getProperty("newpass");
                 ResultSet rs = DBLoader.executeQuery("select *from admin where username = '" + username + "' and password = '" + oldpass + "'");
                 String ans = "";
                 try
                 {
                     if(rs.next())
                     {
                      rs.updateString("password",newpass);
                      rs.updateRow();
                         ans = "success";
                     }
                     else
                     {
                         ans = "failed";
                     }
                 }
                 catch(SQLException ex)
                 {
                     Logger.getLogger(serverforexam.class.getName()).log(Level.SEVERE,null,ex);
                 }
                  res = new Response(HTTP_OK, "text/plain", ans);
         }
          else if (uri.contains("/addcategory")) //any custom logic , except downloading and streaming 
        {
            String catname = parms.getProperty("catname");
            String Description = parms.getProperty("Description");
            String photo = saveFileOnServerWithRandomName(files, parms,"photo","src/pictures");
                 ResultSet rs = DBLoader.executeQuery("select * from add_category where catname = \'" +catname +"\' ");
                 String ans = "";
                 try
                 {
                     if(rs.next())
                     {
                     ans = "failed";                    
                     }
                     else
                     {
                         rs.moveToInsertRow();
                      rs.updateString("catname",catname);
                      rs.updateString("Description",Description);
                      rs.updateString("photo","src/pictures/"+photo);
                      rs.insertRow();
                      
                         ans = "success";

                     }
                 }
                 catch(SQLException ex)
                 {
                     Logger.getLogger(serverforexam.class.getName()).log(Level.SEVERE,null,ex);
                 }
                  res = new Response(HTTP_OK, "text/plain", ans);
         }
           else if (uri.contains("/usersignup")) //any custom logic , except downloading and streaming 
        {
            String Username = parms.getProperty("Username");
            String Password = parms.getProperty("Password");
            String Email = parms.getProperty("Email");
            String Phone_no = parms.getProperty("Phone_no");
            String Photo = saveFileOnServerWithRandomName(files, parms,"Photo","src/pictures");
                 ResultSet rs = DBLoader.executeQuery("select * from user where Username = \'" +Username +"\' ");
                 String ans = "";
                 try
                 {
                     if(rs.next())
                     {
                     ans = "failed";                    
                     }
                     else
                     {
                         rs.moveToInsertRow();
                      rs.updateString("Username",Username);
                      rs.updateString("Password",Password);
                      rs.updateString("Email",Email);
                      rs.updateString("Phone_no",Phone_no);
                      rs.updateString("Photo","src/pictures/"+Photo);
                      rs.insertRow();
                      
                         ans = "success";

                     }
                 }
                 catch(SQLException ex)
                 {
                     Logger.getLogger(serverforexam.class.getName()).log(Level.SEVERE,null,ex);
                 }
                  res = new Response(HTTP_OK, "text/plain", ans);
         }
              else if (uri.contains("/userLogin")) //any custom logic , except downloading and streaming 
        {
            String Username = parms.getProperty("Username");
            String Password = parms.getProperty("Password");
                 ResultSet rs = DBLoader.executeQuery("select *from user where Username = '" + Username + "' and Password = '" + Password + "'");
                 String ans = "";
                 try
                 {
                     if(rs.next())
                     {
                         ans = "success";
                     }
                     else
                     {
                         ans = "failed";
                     }
                 }
                 catch(SQLException ex)
                 {
                     Logger.getLogger(serverforexam.class.getName()).log(Level.SEVERE,null,ex);
                 }
                      
            res = new Response(HTTP_OK, "text/plain", ans);
            }
          else if(uri.contains("/Load"))
                  {
                      String ans = "";
                      try
                      {
                          ResultSet rs = DBLoader.executeQuery("select * from add_category");
                          
                          while(rs.next())
                          {
                              String catname = rs.getString("catname");
                              String Description = rs.getString("Description");
                              String photo = rs.getString("photo");
                              String row = catname + "~" + Description + "~" + photo;
                              ans = ans+ row + ";;"; 
                          }
                      }
                          catch(Exception ex)
                                  {
                                  ex.printStackTrace();
                                  }
     
                           res = new Response(HTTP_OK, "text/plain", ans);   
                  }
           else if(uri.contains("/uload"))
                  {
                      String Username = parms.getProperty("Username");
                      String ans = "";
                      try
                      {
                          ResultSet rs = DBLoader.executeQuery("select * from user Where Username = '"+ Username +"' ");
                          
                          if(rs.next())
                          {
                              String Photo = rs.getString("Photo");
                              ans =  Photo;
                          }
                      }
                          catch(Exception ex)
                                  {
                                  ex.printStackTrace();
                                  }
     
                           res = new Response(HTTP_OK, "text/plain", ans);   
                  }
            else if (uri.contains("/userchangepassword")) //any custom logic , except downloading and streaming 
        {
            String Username = parms.getProperty("Username");
            String oldpass = parms.getProperty("oldpass");
            String newpass = parms.getProperty("newpass");
                 ResultSet rs = DBLoader.executeQuery("select *from user where username = '" + Username + "' and Password = '" + oldpass + "'");
                 String ans = "";
                 try
                 {
                     if(rs.next())
                     {
                      rs.updateString("password",newpass);
                      rs.updateRow();
                         ans = "success";
                     }
                     else
                     {
                         ans = "failed";
                     }
                 }
                 catch(SQLException ex)
                 {
                     Logger.getLogger(serverforexam.class.getName()).log(Level.SEVERE,null,ex);
                 }
                  res = new Response(HTTP_OK, "text/plain", ans);
         }
           else if(uri.contains("/Getquestion"))
                  {
                      String category = parms.getProperty("category");
                      String ans = "";
                      try
                      {
                          ResultSet rs = DBLoader.executeQuery("select * from question where Category='"+category+"'");
                          
                          while(rs.next())
                          {
                              String Qid = rs.getString("Qid");
                              String Question = rs.getString("Question");
                              String OptionA = rs.getString("OptionA");
                              String OptionB = rs.getString("OptionB");
                              String OptionC = rs.getString("OptionC");
                              String OptionD = rs.getString("OptionD");
                              String Correctanswer = rs.getString("Correctanswer");


                              String row = Qid + "#!~" + Question + "#!~" +  OptionA + "#!~" + OptionB + "#!~" + OptionC + "#!~" + OptionD + "#!~" + Correctanswer  ;
                              ans = ans+ row + ";;@"; 
                          }
                          System.out.println(ans);
                      }
                          catch(Exception ex)
                                  {
                                  ex.printStackTrace();
                                  }
     
                           res = new Response(HTTP_OK, "text/plain", ans);   
                  }
          else if(uri.contains("/Deletecategory"))
          {
               String catname = parms.getProperty("index");
                String ans = "";
                      try
                      {
                          ResultSet rs = DBLoader.executeQuery("select * from add_category where catname = \'" + catname +"\'" );
                          if(rs.next())
                          {
                              rs.deleteRow();
                              ans = "success";
                          }
                          else
                          {
                              ans = "failed";
                          }
                      }
                          catch(Exception ex)
                                  {
                                  ex.printStackTrace();
                                  }
     
                           res = new Response(HTTP_OK, "text/plain", ans);   
          }
           else if(uri.contains("/Deletequestion"))
          {
               String Qid = parms.getProperty("Qid");
                String ans = "";
                      try
                      {
                          ResultSet rs = DBLoader.executeQuery("select * from question where Qid = \'" + Qid +"\'" );
                          if(rs.next())
                          {
                              rs.deleteRow();
                              ans = "success";
                          }
                          else
                          {
                              ans = "failed";
                          }
                      }
                          catch(Exception ex)
                                  {
                                  ex.printStackTrace();
                                  }
     
                           res = new Response(HTTP_OK, "text/plain", ans);   
          }
             else if (uri.contains("/addquestion")) //any custom logic , except downloading and streaming 
        {
            
            String Question = parms.getProperty("Question");
            String OptionA = parms.getProperty("OptionA");
            String OptionB = parms.getProperty("OptionB");
            String OptionC = parms.getProperty("OptionC");
            String OptionD = parms.getProperty("OptionD");
            String Correctanswer = parms.getProperty("Correctanswer");
            String Category = parms.getProperty("Category");
                 ResultSet rs = DBLoader.executeQuery("select * from question");
                 String ans = "";
                 try
                 {
                    
                      rs.moveToInsertRow();    
                      rs.updateString("Question",Question);
                      rs.updateString("OptionA",OptionA);
                      rs.updateString("OptionB",OptionB);
                      rs.updateString("OptionC",OptionC);
                      rs.updateString("OptionD",OptionD);
                      rs.updateString("Correctanswer", Correctanswer);
                      rs.updateString("Category",Category );
                      rs.insertRow();
                      
                         ans = "success";
                 }
                 catch(SQLException ex)
                 {
                     Logger.getLogger(serverforexam.class.getName()).log(Level.SEVERE,null,ex);
                 }
                  res = new Response(HTTP_OK, "text/plain", ans);
         }
             else if (uri.contains("/Getcategory"))
             {   String ans ="";
       
                 try
                 {
                      ResultSet rs = DBLoader.executeQuery("select * from add_category");
                     while(rs.next())
                             {
                         
                     String Name = rs.getString("catname");
                     ans = ans + Name + "~";
                                 System.out.println(ans);
                     }
                      
                 }
                 
                 catch(SQLException ex)
                 {
                     Logger.getLogger(serverforexam.class.getName()).log(Level.SEVERE,null,ex);
                 }
                  res = new Response(HTTP_OK, "text/plain", ans);
             }

        else if (uri.contains("SignUp")) {
            String email = parms.getProperty("email");
            String pass = parms.getProperty("pass");
            String name = parms.getProperty("name");

            String filename = "";
//            filename = saveFileOnServerWithOriginalName(files, parms, "photo", "E:\\megha\\uploaded_files");
            filename = saveFileOnServerWithRandomName(files, parms, "photo", "src/uploaded_pics");

            String ans = "";
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/abc", "root", "system");
                Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                ResultSet rs = stmt.executeQuery("select * from users where email='" + email + "'");
                if (rs.next()) {
                    ans = "User Already Exists";
                } else {
                    rs.moveToInsertRow();
                    rs.updateString("email", email);
                    rs.updateString("name", name);
                    rs.updateString("pass", pass);
                    rs.updateString("photo", "src/uploaded_pics/" + filename);
                    rs.insertRow();
                    ans = "Signup successfull";
                }
                res = new Response(HTTP_OK, "text/plain", ans);
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (uri.contains("/FetchProfile")) {
            String email = parms.getProperty("email");
            String result = "";
            try {

                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/abc", "root", "system");
                Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                ResultSet rs = stmt.executeQuery("select * from users where email='" + email + "'");
                if (rs.next()) {
                    String name = rs.getString("name");
                    String password = rs.getString("pass");
                    String photo = rs.getString("photo");

                    result = result + name + ";#" + password + ";#" + photo;

                } else {
                    result = "No Such User";
                }

                res = new Response(HTTP_OK, "text/plain", result);

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (uri.contains("/UploadMultipleFiles")) {
            String title = parms.getProperty("title");
            String desc = parms.getProperty("desc");

            String ans = "";
            ans = ans + " title : " + title + "\n";
            ans = ans + " desc : " + desc + "\n";
            String filename = "";

//            ****This is the first way to get multiple files (one by one manually)*****             
//            filename = saveFileOnServerWithRandomName(files, parms, "wide_photo", "src/uploaded_pics");
//
//            ans = ans +" wide photo : "+filename+"\n";
//            
//            filename = saveFileOnServerWithRandomName(files, parms, "square_photo", "src/uploaded_pics");
//
//            ans = ans +" square photo : "+filename+"\n";
            /// ******* Second Method(General Method) *******
            Enumeration e = files.propertyNames();
            while (e.hasMoreElements()) {
                String name_of_1_file = e.nextElement().toString();

                filename = saveFileOnServerWithRandomName(files, parms, name_of_1_file, "src/uploaded_pics");

                ans = ans + name_of_1_file + " : " + filename + "\n";

            }
            res = new Response(HTTP_OK, "text/plain", "Files Uploaded successfully\n" + ans);

            return res;
        }
          else if(uri.contains("/FetchQuestionCategorywise"))   
             {
            try {
                String ans ="";
                String catname = parms.getProperty("catname");
                ResultSet rs = DBLoader.executeQuery("select * from question where Category ='"+catname+"' ORDER BY rand() LIMIT 0,15");
                while (rs.next()) {
                    String Qid =rs.getString("Qid");
                    String Question = rs.getString("Question");
                    String OptionA = rs.getString("OptionA");
                    String OptionB = rs.getString("OptionB");
                    String OptionC = rs.getString("OptionC");
                    String OptionD = rs.getString("OptionD");
                    String Correctanswer = rs.getString("Correctanswer");
                    String row = Qid + "~" + Question + "~" + OptionA+ "~" + OptionB+ "~" + OptionC+ "~" + OptionD+ "~" + Correctanswer;
                    ans = ans + row + ";;";
                  
                }
                System.out.println(ans);
                res = new Response(HTTP_OK, "text/plain", ans);
            } catch (SQLException ex) {
                Logger.getLogger(serverforexam.class.getName()).log(Level.SEVERE, null, ex);
            }
             }
          else if (uri.contains("/Result")) //any custom logic , except downloading and streaming 
        {
            String Username = parms.getProperty("Username");
            String Category = parms.getProperty("Category");
            String Total =    parms.getProperty("Total");
            String Obtained =    parms.getProperty("Obtained");
            String Percentage =    parms.getProperty("Percentage");
                 ResultSet rs = DBLoader.executeQuery("select * from result");
                 String ans = "";
                 try
                 {
                         rs.moveToInsertRow();
                      rs.updateString("Username",Username);
                      rs.updateString("Category",Category);
                      rs.updateString("Total",Total);
                      rs.updateString("Obtained",Obtained);
                      rs.updateString("Percentage",Percentage);
                      rs.insertRow();
                      
                         ans = "success";

                     }
                 catch(SQLException ex)
                 {
                     Logger.getLogger(serverforexam.class.getName()).log(Level.SEVERE,null,ex);
                 }
                  res = new Response(HTTP_OK, "text/plain", ans);
         }
           else if(uri.contains("viewresult"))
                  {
                      String ans = "";
                      String Username = parms.getProperty("Username");
                      String Category = parms.getProperty("Category");
                      try
                      {
                          ResultSet rs = DBLoader.executeQuery("select * from result where Username ='"+Username+"' and Category ='"+Category+"'");
                          
                          while(rs.next())
                          {
                              String Resultid = rs.getString("Resultid");
                              String Total = rs.getString("Total");
                              String Obtained = rs.getString("Obtained");
                              String Percentage = rs.getString("Percentage");
                              String row =Resultid+"~"+ Total + "~" + Obtained + "~" + Percentage + "~" ;
                              ans = ans+ row + ";;"; 
                          }
                      }
                          catch(Exception ex)
                                  {
                                  ex.printStackTrace();
                                  }
     
                           res = new Response(HTTP_OK, "text/plain", ans);   
                  }
        else {
            res = new Response(HTTP_OK, "text/html", "<body style='background: #D46A6A; color: #fff'><center><h1>Hello</h1><br> <h3>Welcome To JHTTP Server (Version 1.0)</h3></body></center>");
        }

        return res;
    }

}

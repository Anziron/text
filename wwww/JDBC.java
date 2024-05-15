package com.JDBC;

import java.sql.*;
import java.util.ArrayList;

import com.mode.FileMode;

public class JDBC {
	

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";    
    static final String DB_URL = "jdbc:mysql://localhost:3306/personnel?useSSL=false&serverTimezone=UTC&characterEncoding=utf8";  
   
    // 数据库的用户名与密码，需要根据自己的设置  
    static final String USER = "root";  
    static final String PASS = "230306";  
      
    
   
    

    public static ArrayList<FileMode> selectall(){
    	
    	   Connection conn = null;  
           Statement stmt = null;  
           ArrayList<FileMode> list = new  ArrayList<FileMode>(); 
           
           
           try{  
               // 注册 JDBC 驱动  
               Class.forName(JDBC_DRIVER);  
             
               // 打开链接  
               System.out.println("连接数据库...");  
               conn = DriverManager.getConnection(DB_URL,USER,PASS);  
               stmt = conn.createStatement();
               String sql = "select id ,filename ,fileurl , filesize , fileuser from FileMode";
               
               ResultSet rs = stmt.executeQuery(sql);
               while(rs.next()){
            	   FileMode temp = new FileMode();

                   temp.setId(rs.getString("id"));  
                   temp.setFilename(rs.getString("filename"));  
                   temp.setFileurl(rs.getString("fileurl"));  
                   temp.setFilesize(rs.getString("filesize"));  
                   temp.setFileuser(rs.getString("fileuser"));  
            	   

                   list.add(temp);  
                   }
               
               rs.close();
               stmt.close();
               conn.close();
            
              }catch(SQLException se){  
                   // 处理 JDBC 错误  
                   se.printStackTrace();  
               }catch(Exception e){  
                   // 处理 Class.forName 错误  
                   e.printStackTrace();  
               }finally{  
                   // 关闭资源  
                   try{  
                       if(stmt!=null) stmt.close();  
                   }catch(SQLException se2){  
                   }// 什么都不做  
                   try{  
                       if(conn!=null) conn.close();  
                   }catch(SQLException se){  
                       se.printStackTrace();  
                   }  
               }  
               System.out.println("Goodbye!");  
               
               return list;
                
           
       	
       }
    	
    	
    
    
    
    
    public static void inst(FileMode filemode){
    	

        Connection conn = null;  
        Statement stmt = null;  
        
        try{  
            // 注册 JDBC 驱动  
            Class.forName(JDBC_DRIVER);  
          
            // 打开链接  
            System.out.println("连接数据库...");  
            conn = DriverManager.getConnection(DB_URL,USER,PASS);  
            String sql = "insert into FileMode (filename, fileurl,filesize,fileuser) values(?,?,?,?)";  
            
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, filemode.getFilename());
            pst.setString(2, filemode.getFileurl());
            pst.setString(3, filemode.getFilesize());
            pst.setString(4, filemode.getFileuser());
            pst.executeUpdate();
           }catch(SQLException se){  
                // 处理 JDBC 错误  
                se.printStackTrace();  
            }catch(Exception e){  
                // 处理 Class.forName 错误  
                e.printStackTrace();  
            }finally{  
                // 关闭资源  
                try{  
                    if(stmt!=null) stmt.close();  
                }catch(SQLException se2){  
                }// 什么都不做  
                try{  
                    if(conn!=null) conn.close();  
                }catch(SQLException se){  
                    se.printStackTrace();  
                }  
            }  
            System.out.println("Goodbye!");  
            
             
        
    	
    }
    
    

    
    public static void del(String  id){
    	

        Connection conn = null;  
        Statement stmt = null;  
        
        try{  
            // 注册 JDBC 驱动  
            Class.forName(JDBC_DRIVER);  
          
            // 打开链接  
            System.out.println("连接数据库...");  
            conn = DriverManager.getConnection(DB_URL,USER,PASS);  
            String sql = "delete from FileMode where id = "+id;  
            
            PreparedStatement pst = conn.prepareStatement(sql);
         
            pst.executeUpdate();
           }catch(SQLException se){  
                // 处理 JDBC 错误  
                se.printStackTrace();  
            }catch(Exception e){  
                // 处理 Class.forName 错误  
                e.printStackTrace();  
            }finally{  
                // 关闭资源  
                try{  
                    if(stmt!=null) stmt.close();  
                }catch(SQLException se2){  
                }// 什么都不做  
                try{  
                    if(conn!=null) conn.close();  
                }catch(SQLException se){  
                    se.printStackTrace();  
                }  
            }  
            System.out.println("Goodbye!");  
            
             
        
    	
    }


}

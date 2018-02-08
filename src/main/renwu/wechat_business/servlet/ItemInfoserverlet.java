//package asd;/********************************************************************
// /**
// * @Project: dfasf
// * @Package asd
// * @author HL
// * @date 2018/1/31 17:38
// * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
// * @version V1.0
// */
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * @author huanglei
// * @ClassName serverlet
// * @Description 类描述
// * @date 2018/1/31
// */
//public class serverlet extends HttpServlet {
//    public  void init(){
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//    }
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        Connection conn = null;
//        PreparedStatement ps = null;
//        ResultSet rs = null;
//        try {
//            List<User> userList = new ArrayList<>();
//            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java", "root", "123456");
//            ps = conn.prepareStatement("INSERT INTO item_info (NAME ,NUMBER ) VALUES (?,? )");
//            rs = ps.executeQuery();
//            while(rs.next()){
//                String name = rs.getString("userName");
//                String number = rs.getString("userNum");
//                User user = new User(name, number);
//                userList.add(user);
//            }
//            req.setAttribute("userList", userList);
//            req.getRequestDispatcher("GoodInfo.jsp").forward(req, resp);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }finally {
//            try {
//                if(rs != null){
//                    rs.close();
//                }
//                if(ps!=null){
//                    ps.close();
//                }
//                if(conn!=null){
//                    conn.close();
//                }
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        doGet(req, resp);
//    }
//
//}
//
//

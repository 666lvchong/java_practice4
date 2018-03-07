package wechat_business.servlet;

import wechat_business.dao.OrderDetailDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * *****************************************************************
 * /**
 *
 * @author hehongju
 * @version V1.0
 * @Project: Team4
 * @Package ${PACKAGE_NAME}
 * @date 2018/1/30 17:14
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 */
@WebServlet(name = "DelShoppingCartServlet")
public class DelShoppingCartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // response.sendRedirect("ShoppingCartServlet");

        String id=request.getParameter("id");
        String buyer=null;
        OrderDetailDao orderDetailDao = new OrderDetailDao();
        try {
            buyer=orderDetailDao.findById(Long.valueOf(id)).getTaobaoAccountId().toString();
            System.out.println("删除个数"+orderDetailDao.deleteById((Long.valueOf(id))));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("ShoppingCartServlet").forward(request,response);
    }
}

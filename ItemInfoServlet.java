package wechat_business.servlet;/********************************************************************
 /**
 * @Project: Team4
 * @Package wechat_business.servlet
 * @author HL
 * @date 2018/2/4 16:42
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import wechat_business.service.ItemInfoServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @author
 * @ClassName ItemInfoServlet
 * @Description 类描述
 * @date 2018/2/4
 */
public class ItemInfoServlet  extends HttpServlet {

    /**
     * @Title: doGet
     * @Description: 继承父类
     * @author huanglei
     * @date 2018/1/30
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Long  id=1l;
        request.getParameter("id");
        id=Long.parseLong("1");
        ItemInfoServiceImpl itemInfoService=new ItemInfoServiceImpl();
        try {
            System.out.print(itemInfoService.findById(id));
            request.setAttribute("item",itemInfoService.findById(id));
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            itemInfoService.release();
        }
        request.getRequestDispatcher("/jsp/GoodsInfo.jsp").forward(request,response);
    }
    /**
     * @Title: doPost
     * @Description: 继承父类
     * @author huanglei
     * @date 2018/1/30
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doGet(request, response);
        }
}

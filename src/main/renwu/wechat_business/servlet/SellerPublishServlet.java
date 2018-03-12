package wechat_business.servlet;

import wechat_business.dao.ItemInfoDao;
import wechat_business.dao.ItemRelationDao;
import wechat_business.entity.*;
import wechat_business.service.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@WebServlet(name = "SellerPublishServlet")
/********************************************************************
 /**
 * @Project: Team4
 * @Package wechat_business.servlet
 * @author wangjunjie
 * @date 2018/2/1 23:38
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

/********************************************************************
 /**
 * @Project: Team4
 * @Package wechat_business.servlet
 * @author wangjunjie
 * @date 2018/1/31 8:52
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

public class SellerPublishServlet extends HttpServlet {
    public SellerPublishServlet() {
        super();
    }

    /**
     * @Title: doGet
     * @Description: 继承父类方法
     * @author lvchong
     * @params @param null
     * @date 2018-01-27
     * @throw YnCorpSysException
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        doGet(request, response);
        request.getRequestDispatcher("jsp/publish_commodity.jsp").forward(request, response);
    }

    /**
     * @Title: doPost
     * @Description: 继承父类方法
     * @author wangjunjie
     * @params @param null
     * @date 2018-01-31
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //设置字符集编码格式
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        //定义响应输出
        PrintWriter out = response.getWriter();
        //方法实例化
        ItemInfoDao itemInfoDao=new ItemInfoDao();
        ItemRelationDao itemRelationDao=new ItemRelationDao();
        //定义卖家发布商品条件
        Map<String, Object> mapItemInfo = new HashMap<String, Object>();
        Map<String, Object> mapItemRelation = new HashMap<String, Object>();
        //获取卖家发布商品请求参数值
        String name = request.getParameter("NAME");
        String price=request.getParameter("PRICE");
        String inventory = request.getParameter("INVENTORY");

        //判断卖家发布商品是否为空
        if (name == null || price==null|| inventory==null) {
            out.print("<script language='javaScript'> alert('商品信息不正确，请重新输入');</script>");
            request.getRequestDispatcher("jsp/publish_commodity.jsp").forward(request, response);
        } else {
            //将参数放入map对象
            mapItemInfo.put("NAME", name);
            try {
                //根据用户名和密码查询
                List<ItemInfo> listItem = itemInfoDao.findByCondtion(mapItemInfo);
                //保存查询结果
                request.setAttribute("listItem", listItem);
                //判断查询结果是否存在，是返回错误信息
                if (listItem.size()>0) {
                    System.out.println("发布失败,商品已存在");
                    out.print("<script language='javaScript'> alert('发布失败,商品已存在');</script>");
                }else{
                    ItemInfo itemInfo =new ItemInfo();
                    itemInfo.setName(name);
                    ItemRelation itemRelation=new ItemRelation();
                    itemRelation.setPrice(Double.valueOf(price));
                    itemRelation.setInventory(Double.valueOf(inventory));
                    mapItemInfo.put("NAME", name);
                    mapItemRelation.put("PRICE", price);
                    mapItemRelation.put("INVENTLATORY", inventory);
                    itemInfoDao.save(itemInfo);
                    itemRelationDao.save(itemRelation);
                    System.out.println("发布成功");
                    out.print("<script language='javaScript'> alert('发布成功');</script>");
                    //转发页面
                    request.getRequestDispatcher("jsp/publish_commodity.jsp").forward(request, response);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}




package wechat_business.servlet;/********************************************************************
 /**
 * @Project: Team4
 * @Package wechat_business.servlet
 * @author caixing
 * @date 2018/2/5 10:44
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import wechat_business.dao.OrderStatementInfoDao;
import wechat_business.dao.PaypalInfoDaoImpl;
import wechat_business.entity.OrderStatementInfo;
import wechat_business.entity.PaypalInfo;
import wechat_business.entity.TaobaoAccount;
import wechat_business.service.OrderStatementInfoServiceImp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author caixing
 * @ClassName BillFlowServlet
 * @Description 类描述 字符流水Servlet
 * @date 2018/2/5
 */
public class BillFlowServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        //在支付宝信息表中通过淘宝账号外键查询支付宝账号
        TaobaoAccount taobaoAccount= (TaobaoAccount) request.getSession().getAttribute("TaobaoAccount");
        //定义条件查询
        Map<String, Object> mapSeller = new HashMap<String, Object>();
        //添加条件
        mapSeller.put("TAOBAO_ACCOUNT_ID",taobaoAccount.getId());
        //获取返回集合
        List<PaypalInfo> list=null;
        //支付宝信息DaoImpl类
        PaypalInfoDaoImpl paypalInfoDao=new PaypalInfoDaoImpl();
        try {
            list= paypalInfoDao.findByCondtion(mapSeller);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            paypalInfoDao.close();
        }
        //获取支付宝id
        Long longs=list.get(0).getId();
        //在订单支付流水信息表中通过支付宝id查询所有支付支付流水
        //定义条件查询
        Map<String, Object> mapSeller1 = new HashMap<String, Object>();
        //添加条件
        mapSeller1.put("PAYPAL_INFO_ID", longs);
        //获取返回集合
        List<OrderStatementInfo> list1=null;
        //支付流水信息DaoImpl类
        OrderStatementInfoDao orderStatementInfoDao=new OrderStatementInfoDao();
        try {
          list1 =  orderStatementInfoDao.findByCondtion(mapSeller1);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            orderStatementInfoDao.release();
        }
        request.setAttribute("list1",list1);
        request.getRequestDispatcher("jsp/billFlow.jsp").forward(request,response);
    }
}

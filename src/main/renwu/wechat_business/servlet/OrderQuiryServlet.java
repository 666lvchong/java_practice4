package wechat_business.servlet;

import wechat_business.dao.OrderInfoDao;
import wechat_business.entity.OrderInfo;
import wechat_business.entity.TaobaoAccount;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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
 * *****************************************************************
 * /**
 *
 * @author hehongju
 * @version V1.0
 * @Project: Team4
 * @Package ${PACKAGE_NAME}
 * @date 2018/1/30 10:00
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 */
@WebServlet(name = "OrderQuiryServlet")
public class OrderQuiryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Object buyer=request.getSession().getAttribute("TaobaoAccount");
        TaobaoAccount taobaoAccount;
        taobaoAccount= (TaobaoAccount) buyer;
        Map<String,Object> stringObjectMap=new HashMap<String, Object>();
        stringObjectMap.put("TAOBAO_ACCOUNT_ID",taobaoAccount.getId());
        List<OrderInfo> orderInfoServiceList=new ArrayList<OrderInfo>();
        OrderInfoDao orderInfoDao = new OrderInfoDao();
        int index=0;

        try {
            //获取当前用户的订单信息
            orderInfoServiceList=orderInfoDao.findByCondtion(stringObjectMap);
            index=orderInfoServiceList.size();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("list",orderInfoServiceList);
        request.setAttribute("index",index);
        request.setAttribute("buyer",taobaoAccount.getPersonnelAccount().toString());
        request.getRequestDispatcher("jsp/order_quiry.jsp").forward(request,response);
    }
}

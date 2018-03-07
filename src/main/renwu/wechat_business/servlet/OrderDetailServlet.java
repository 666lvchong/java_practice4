package wechat_business.servlet;

import wechat_business.dao.ItemInfoDao;
import wechat_business.dao.OrderDetailDao;
import wechat_business.dao.OrderInfoDao;
import wechat_business.entity.ItemInfo;
import wechat_business.entity.OrderDetail;
import wechat_business.entity.OrderInfo;

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
 * @date 2018/1/30 18:58
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 */
@WebServlet(name = "OrderDetailServlet")
public class OrderDetailServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String orderInfoId=request.getParameter("id");
        OrderInfoDao orderInfoDao=new OrderInfoDao();
        OrderInfo orderInfo=new OrderInfo();

        Map<String,Object> stringObjectMap=new HashMap<String, Object>();
        List<OrderDetail> orderDetailList=new ArrayList<OrderDetail>();
        OrderDetailDao orderDetailDao=new OrderDetailDao();

        ItemInfo itemInfo;
        ItemInfoDao itemInfoDao=new ItemInfoDao();
        List itemInfos=new ArrayList<String>();
        try {
            //根据orderInfoId获取订单信息
            orderInfo=orderInfoDao.findById(Long.valueOf(orderInfoId));
            stringObjectMap.put("TAOBAO_ACCOUNT_ID",orderInfo.getTaobaoAccountId());
            stringObjectMap.put("ORDER_INFO_ID",orderInfo.getId());
            //根据获取订单详情
            orderDetailList=orderDetailDao.findByCondtion(stringObjectMap);
            //获取商品名
            for (int i=0;i<orderDetailList.size();i++){
               itemInfo= itemInfoDao.findById(orderDetailList.get(i).getItemInfoId());
                itemInfos.add(i, itemInfo.getName());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("list",orderDetailList);
        request.setAttribute("money",orderInfo.getOrderTotalAmount());
        request.setAttribute("listName",itemInfos );
        request.setAttribute("orderInfoId",orderInfoId);
        request.setAttribute("pay",orderDetailList.get(0).getOrderStatus());
        request.getRequestDispatcher("jsp/order_detail.jsp").forward(request,response);
    }
}

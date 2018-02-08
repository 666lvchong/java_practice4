package wechat_business.servlet;

import wechat_business.dao.ItemInfoDao;
import wechat_business.dao.OrderDetailDaoImpl;
import wechat_business.dao.OrderInfoDaoImpl;
import wechat_business.entity.ItemInfo;
import wechat_business.entity.OrderInfo;
import wechat_business.entity.TaobaoAccount;
import wechat_business.service.ItemInfoServiceImpl;
import wechat_business.service.OrderDetailServiceImpl;
import wechat_business.service.OrderInfoServiceImpl;
import wechat_business.util.FormatUtils;

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
        OrderInfoDaoImpl orderInfoDao=new OrderInfoDaoImpl();
        OrderInfoServiceImpl orderInfoService=new OrderInfoServiceImpl();

        Map<String,Object> stringObjectMap=new HashMap<String, Object>();
        List<OrderDetailServiceImpl> orderDetailServiceList=new ArrayList<OrderDetailServiceImpl>();
        OrderDetailDaoImpl orderDetailDao = new OrderDetailDaoImpl();

        ItemInfo itemInfo;
        ItemInfoDao itemInfoDao=new ItemInfoDao();
        List itemInfos=new ArrayList<String>();
        try {
            //根据orderInfoId获取订单信息
            orderInfoService=orderInfoDao.findById(Long.valueOf(orderInfoId));
            stringObjectMap.put("TAOBAO_ACCOUNT_ID",orderInfoService.getTaobaoAccountId());
            stringObjectMap.put("ORDER_INFO_ID",orderInfoService.getId());
            //根据获取订单详情
            orderDetailServiceList=orderDetailDao.findByCondtion(stringObjectMap);
            //获取商品名
            for (int i=0;i<orderDetailServiceList.size();i++){
               itemInfo= itemInfoDao.findById(orderDetailServiceList.get(i).getItemInfoId());
                itemInfos.add(i, itemInfo.getName());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("list",orderDetailServiceList);
        request.setAttribute("money",orderInfoService.getOrderTotalAmount());
        request.setAttribute("listName",itemInfos );
        request.setAttribute("orderInfoId",orderInfoId);
        request.setAttribute("pay",orderDetailServiceList.get(0).getOrderStatus());
        request.getRequestDispatcher("jsp/order_detail.jsp").forward(request,response);
    }
}

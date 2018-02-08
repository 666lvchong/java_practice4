package wechat_business.servlet;

import wechat_business.dao.ItemInfoDao;
import wechat_business.dao.OrderDetailDaoImpl;
import wechat_business.dao.OrderInfoDaoImpl;
import wechat_business.entity.ItemInfo;
import wechat_business.entity.TaobaoAccount;
import wechat_business.service.OrderDetailServiceImpl;
import wechat_business.service.OrderInfoServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

/**
 * *****************************************************************
 * /**
 *
 * @author hehongju
 * @version V1.0
 * @Project: Team4
 * @Package ${PACKAGE_NAME}
 * @date 2018/1/31 14:01
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 */
@WebServlet(name = "CreateOrderServlet")
public class CreateOrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Object buyer=request.getSession().getAttribute("TaobaoAccount");
        String moneystr=request.getParameter("money");
        TaobaoAccount taobaoAccount;
        taobaoAccount= (TaobaoAccount) buyer;
        Map<String,Object> stringObjectMap=new HashMap<String, Object>();
        stringObjectMap.put("TAOBAO_ACCOUNT_ID",taobaoAccount.getId());
        stringObjectMap.put("ORDER_INFO_ID",0);
        List<OrderDetailServiceImpl> orderDetailServiceList=new ArrayList<OrderDetailServiceImpl>();
        OrderDetailDaoImpl orderDetailDao = new OrderDetailDaoImpl();

        ItemInfo itemInfo=new ItemInfo();
        ItemInfoDao itemInfoDao=new ItemInfoDao();

        //生成订单编号
        String orderNum=new Date().getTime()+""+new Random().nextInt(10000)+""+new Date().getTime();
        try{
            //创建订单信息
            OrderInfoServiceImpl orderInfoService=new OrderInfoServiceImpl();
            OrderInfoDaoImpl orderInfoDao=new OrderInfoDaoImpl();
            Long buyerId=Long.valueOf(taobaoAccount.getId());
            Double money=Double.valueOf(moneystr);
            orderInfoService=orderInfoService.crateOrderInfo(orderNum,buyerId,money);
            System.out.println(orderInfoDao.saveOrUpdate(orderInfoService));
            //取id
            Map<String,Object> stringObjectMap0=new HashMap<String, Object>();
            stringObjectMap0.put("ORDER_NUM",orderNum);
            List<OrderInfoServiceImpl> orderInfoServiceList=new ArrayList<OrderInfoServiceImpl>();
            orderInfoServiceList= orderInfoDao.findByCondtion(stringObjectMap0);
            //删除购物车的数据创建订单
            orderDetailServiceList=orderDetailDao.findByCondtion(stringObjectMap);
            for (int i=0;i<orderDetailServiceList.size();i++){
                OrderDetailServiceImpl orderDetailService=new OrderDetailDaoImpl();
                orderDetailService.setId(orderDetailServiceList.get(i).getId());
                orderDetailService.setOrderInfoId(orderInfoServiceList.get(0).getId());
                orderDetailDao.saveOrUpdate(orderDetailService);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("OrderQuiryServlet").forward(request,response);
    }
}

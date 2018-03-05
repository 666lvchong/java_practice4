package wechat_business.servlet;


import wechat_business.dao.ItemInfoDao;
import wechat_business.dao.OrderDetailDaoImpl;
import wechat_business.entity.Address;
import wechat_business.entity.ItemInfo;
import wechat_business.entity.TaobaoAccount;
import wechat_business.service.AddressServiceImpl;
import wechat_business.service.OrderDetailServiceImpl;

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
 * @date 2018/1/30 15:07
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 */
@WebServlet(name = "ShoppingCartServlet")
public class ShoppingCartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Object buyer=request.getSession().getAttribute("TaobaoAccount");
        TaobaoAccount taobaoAccount;
        taobaoAccount= (TaobaoAccount) buyer;
        Map<String,Object> stringObjectMap=new HashMap<String, Object>();
        stringObjectMap.put("TAOBAO_ACCOUNT_ID",taobaoAccount.getId());
        stringObjectMap.put("ORDER_INFO_ID",0);
        List<OrderDetailServiceImpl> orderDetailServiceList=new ArrayList<OrderDetailServiceImpl>();
        OrderDetailDaoImpl orderDetailDao = new OrderDetailDaoImpl();

        Map<String,Object> stringObjectMapAddress=new HashMap<String, Object>();
        stringObjectMapAddress.put("ADDRESS_TYPE",(byte)1);
        stringObjectMapAddress.put("TAOBAO_ACCOUNT_ID",taobaoAccount.getId());

        AddressServiceImpl addressServices=new AddressServiceImpl();
        List<Address> addressList=new ArrayList<Address>();
        int index=0;
        try {
            addressList=addressServices.findByCondtion(stringObjectMapAddress);
            index=addressList.size();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        ItemInfo itemInfo=new ItemInfo();
        ItemInfoDao itemInfoDao=new ItemInfoDao();
        List itemInfos=new ArrayList<String>();
        Double money=0d;
        try {
            //获取无订单编号订单详情
            orderDetailServiceList=orderDetailDao.findByCondtion(stringObjectMap);
            for (int i=0;i<orderDetailServiceList.size();i++){
                itemInfo= itemInfoDao.findById(orderDetailServiceList.get(i).getItemInfoId());
                System.out.println(orderDetailServiceList.get(i).getItemInfoId());
                System.out.println("name" + itemInfo.getName());
                itemInfos.add(i,itemInfo.getName());
                //计算总金额
                money+=orderDetailServiceList.get(i).getAmount()*orderDetailServiceList.get(i).getItemNumber();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(money);
        request.setAttribute("list",orderDetailServiceList);
        request.setAttribute("listName", itemInfos);
        request.setAttribute("money",money);
        request.setAttribute("listAddress",addressList);
        request.setAttribute("index",index);
        request.getRequestDispatcher("jsp/shopping_cart.jsp").forward(request, response);
        System.out.println(orderDetailServiceList.size());
    }
}

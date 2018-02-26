package wechat_business.servlet;

import javafx.collections.ObservableList;
import wechat_business.dao.OrderDetailDaoImpl;
import wechat_business.dao.OrderInfoDaoImpl;
import wechat_business.dao.PaypalInfoDaoImpl;
import wechat_business.entity.OrderStatementInfo;
import wechat_business.entity.PaypalInfo;
import wechat_business.service.OrderDetailServiceImpl;
import wechat_business.service.OrderInfoServiceImpl;
import wechat_business.service.OrderStatementInfoServiceImp;
import wechat_business.service.PaypalInfoServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
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
 * @date 2018/2/7 9:48
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 */
@WebServlet(name = "PayServlet")
public class PayServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String orderInfoId=request.getParameter("orderInfoId");
        String pwd=request.getParameter("pwd");
        System.out.println("支付");
        OrderInfoDaoImpl orderInfoDao=new OrderInfoDaoImpl();
        OrderInfoServiceImpl orderInfoService=new OrderInfoServiceImpl();

        List<PaypalInfo> paypalInfoList=new ArrayList<PaypalInfo>();
        PaypalInfoDaoImpl paypalInfoDao=new PaypalInfoDaoImpl();

        Long id=Long.valueOf(orderInfoId);
        try {
            //获取订单信息
            orderInfoService=orderInfoDao.findById(id);
            //获取支付宝账户
            Map<String,Object> stringObjectMap=new HashMap<String, Object>();
            stringObjectMap.put("TAOBAO_ACCOUNT_ID",orderInfoDao.getTaobaoAccountId());
            paypalInfoList=paypalInfoDao.findByCondtion(stringObjectMap);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //生成订单编号
        String serialNum=new java.util.Date().getTime()+""+new Random().nextInt(100);

        //创建流水
        OrderStatementInfo orderStatementInfo=new OrderStatementInfo();
        orderStatementInfo.setSerialNumber(serialNum);
        orderStatementInfo.setOrderInfoId(orderInfoService.getId());
        orderStatementInfo.setPaypalInfoId(paypalInfoList.get(0).getId());
        orderStatementInfo.setFlowRecordType((byte) 2);
        orderStatementInfo.setIsPayStatus((byte) 1);
        orderStatementInfo.setAmounts(orderInfoService.getOrderTotalAmount());
        orderStatementInfo.setLaunchTime(new Date(System.currentTimeMillis()));
        orderStatementInfo.setFinshTime(new Date(System.currentTimeMillis()));
        OrderStatementInfoServiceImp orderStatementInfoServiceImp=new OrderStatementInfoServiceImp();
        try {
            orderStatementInfoServiceImp.saveOrUpdate(orderStatementInfo);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //支付宝账户支付
        PaypalInfoServiceImpl paypalInfoService=new PaypalInfoServiceImpl();
        System.out.println(pwd);
        System.out.println(paypalInfoList.get(0).getPayPassword().toString());
        if(paypalInfoList.get(0).getPayPassword().toString().equals(pwd.toString())){
            if(paypalInfoList.get(0).getBalance()>=orderInfoService.getOrderTotalAmount()){
                paypalInfoService.pay(paypalInfoList.get(0),orderInfoService.getOrderTotalAmount());
                //订单状态改变
                OrderDetailDaoImpl orderDetailDao=new OrderDetailDaoImpl();
                List<OrderDetailServiceImpl> orderDetailList;
                Map<String,Object> stringObjectMap0=new HashMap<String, Object>();
                stringObjectMap0.put("TAOBAO_ACCOUNT_ID", orderInfoService.getTaobaoAccountId());
                stringObjectMap0.put("ORDER_INFO_ID",orderInfoService.getId());
                try {
                    orderDetailList=orderDetailDao.findByCondtion(stringObjectMap0);
                    for(int i=0;i<orderDetailList.size();i++){
                        orderDetailList.get(i).setOrderStatus((byte)2);
                        orderDetailDao.saveOrUpdate(orderDetailList.get(i));
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                //跳转到流水
                System.out.println("支付成功！返回订单详情");
                response.setContentType("text/html; charset=UTF-8"); //转码
                PrintWriter out = response.getWriter();
                out.flush();
                out.println("<script>");
                out.println("alert('支付成功！返回订单详情：');");
                out.println("var path='OrderDetailServlet?id="+orderInfoId+"';");
                out.println("window.document.location.href=path;");
                out.println("</script>");
            }else{
                //余额不足，支付失败
                System.out.println("余额不足，支付失败");
                response.setContentType("text/html; charset=UTF-8"); //转码
                PrintWriter out = response.getWriter();
                out.flush();
                out.println("<script>");
                out.println("alert('账户余额不足，支付失败！返回订单详情：');");
                out.println("var path='OrderDetailServlet?id="+orderInfoId+"';");
                out.println("window.document.location.href=path;");
                out.println("</script>");
            }
        }else {
            //支付密码错误，返回订单详情
            System.out.println("支付密码错误，返回订单详情");
            response.setContentType("text/html; charset=UTF-8"); //转码
            PrintWriter out = response.getWriter();
            out.flush();
            out.println("<script>");
            out.println("alert('支付密码错误，支付失败！返回订单详情：');");
            out.println("var path='OrderDetailServlet?id="+orderInfoId+"';");
            out.println("window.document.location.href=path;");
            out.println("</script>");

        }
    }
}

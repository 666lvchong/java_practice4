package wechat_business.servlet;

import wechat_business.dao.OrderDetailDao;
import wechat_business.dao.OrderInfoDao;
import wechat_business.dao.PaypalInfoDao;
import wechat_business.entity.OrderDetail;
import wechat_business.entity.OrderInfo;
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
        OrderInfoDao orderInfoDao=new OrderInfoDao();
        OrderInfo orderInfo=new OrderInfo();

        List<PaypalInfo> paypalInfoList=new ArrayList<PaypalInfo>();
        PaypalInfoDao paypalInfoDao=new PaypalInfoDao();

        Long id=Long.valueOf(orderInfoId);
        try {
            //获取订单信息
            orderInfo=orderInfoDao.findById(id);
            //获取支付宝账户
            Map<String,Object> stringObjectMap=new HashMap<String, Object>();
            stringObjectMap.put("TAOBAO_ACCOUNT_ID",orderInfo.getTaobaoAccountId());
            paypalInfoList=paypalInfoDao.findByCondtion(stringObjectMap);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //生成订单编号
        String serialNum=new java.util.Date().getTime()+""+new Random().nextInt(100);

        //创建流水
        OrderStatementInfo orderStatementInfo=new OrderStatementInfo();
        orderStatementInfo.setSerialNumber(serialNum);
        orderStatementInfo.setOrderInfoId(orderInfo.getId());
        orderStatementInfo.setPaypalInfoId(paypalInfoList.get(0).getId());
        orderStatementInfo.setFlowRecordType((byte) 2);
        orderStatementInfo.setIsPayStatus((byte) 1);
        orderStatementInfo.setAmounts(orderInfo.getOrderTotalAmount());
        orderStatementInfo.setLaunchTime(new Date(System.currentTimeMillis()));
        orderStatementInfo.setFinshTime(new Date(System.currentTimeMillis()));
        OrderStatementInfoServiceImp orderStatementInfoServiceImp=new OrderStatementInfoServiceImp();
        try {
            orderStatementInfoServiceImp.save(orderStatementInfo);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //支付宝账户支付
        PaypalInfoServiceImpl paypalInfoService=new PaypalInfoServiceImpl();
        System.out.println(pwd);
        System.out.println(paypalInfoList.get(0).getPayPassword().toString());
        if(paypalInfoList.get(0).getPayPassword().toString().equals(pwd.toString())){
            if(paypalInfoList.get(0).getBalance()>=orderInfo.getOrderTotalAmount()){
                paypalInfoService.pay(paypalInfoList.get(0),orderInfo.getOrderTotalAmount());
                //订单状态改变
                OrderDetailDao orderDetailDao=new OrderDetailDao();
                List<OrderDetail> orderDetailList;
                Map<String,Object> stringObjectMap0=new HashMap<String, Object>();
                stringObjectMap0.put("TAOBAO_ACCOUNT_ID", orderInfo.getTaobaoAccountId());
                stringObjectMap0.put("ORDER_INFO_ID",orderInfo.getId());
                try {
                    orderDetailList=orderDetailDao.findByCondtion(stringObjectMap0);
                    for(int i=0;i<orderDetailList.size();i++){
                        orderDetailList.get(i).setOrderStatus((byte)2);
                        orderDetailDao.update(orderDetailList.get(i));
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

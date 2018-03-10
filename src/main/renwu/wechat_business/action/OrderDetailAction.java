package wechat_business.action;/********************************************************************
 /**
 * @Project: Team4
 * @Package wechat_business.action
 * @author hehongju
 * @date 2018/3/9 9:55
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import com.opensymphony.xwork2.ActionContext;
import org.apache.struts2.convention.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import wechat_business.entity.OrderDetail;
import wechat_business.entity.OrderInfo;
import wechat_business.entity.PaypalInfo;
import wechat_business.service.OrderDetailServiceImpl;
import wechat_business.service.OrderInfoServiceImpl;
import wechat_business.service.PaypalInfoServiceImpl;

import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hehongju
 * @ClassName OrderDetailAction
 * @Description 类描述
 * @date 2018/3/9
 */
@Action(value = "orderDetailAction")
@Results({
        @Result(name = "orderDetail",location = "/jsp/order_detail.jsp")
})
public class OrderDetailAction extends BaseAction {
    @Autowired
    private OrderDetailServiceImpl orderDetailService;
    @Autowired
    private OrderInfoServiceImpl orderInfoService;
    @Autowired
    private PaypalInfoServiceImpl paypalInfoService;

    private OrderDetail orderDetail;
    private OrderInfo orderInfo;
    private PaypalInfo paypalInfo;
    private List<OrderDetail> orderDetailList;
    private List<PaypalInfo> paypalInfoList;
    private Double money = 0d;
    private String pwd="123456";
    private String strId;
    ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
    public void orderDetailAction(){
        System.out.println("订单详情");
    }
    /**
     * @Title:
     * @Description: 订单详情加载
     * @author hehongju
     * @date 2018-03-09
     */
    public String open(){
        Long orederInfoId=Long.valueOf(strId);

        Map<String,Object> stringObjectMap=new HashMap<String, Object>();
        stringObjectMap.put("ORDER_INFO_ID",orederInfoId);
        orderDetailService=(OrderDetailServiceImpl)applicationContext.getBean("orderDetailService");
        try {
            orderDetailList=orderDetailService.findByCondtion(stringObjectMap);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("订单详情："+orderDetailList.size());
        ActionContext.getContext().put("list", orderDetailList);
        ActionContext.getContext().put("money", money);
        ActionContext.getContext().put("pay", orderDetailList.get(0).getOrderStatus());
//        request.setAttribute("list",orderDetailList);
//        request.setAttribute("money",orderInfo.getOrderTotalAmount());
//        request.setAttribute("listName",itemInfos );
//        request.setAttribute("orderInfoId",orderInfoId);
//        request.setAttribute("pay",orderDetailList.get(0).getOrderStatus());

        return "orderDetail";
    }
    /**
     * @Title:
     * @Description: 支付金额
     * @author hehongju
     * @date 2018-03-09
     */
    public void pay(){
        pwd="123456";
        money=50d;
        Long orderInfoId=1l;
        Long taoBaoAccountId=1l;

        //获取支付宝账户
        Map<String,Object> stringObjectMapPay=new HashMap<String, Object>();
        stringObjectMapPay.put("TAOBAO_ACCOUNT_ID",taoBaoAccountId);
        paypalInfoService=(PaypalInfoServiceImpl)applicationContext.getBean("paypalInfoService");
        try {
            paypalInfoList=paypalInfoService.findByCondtion(stringObjectMapPay);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(paypalInfoList.size()==0){
            System.out.println("没有账户");

//            open();
        }else {
            //判断密码
            if(paypalInfoList.get(0).getPayPassword().toString().equals(pwd)){
                //判断余额
                if(paypalInfoList.get(0).getBalance()>=money){
                    //支付金额
                    paypalInfo=paypalInfoList.get(0);
                    paypalInfo.setBalance(paypalInfo.getBalance().doubleValue()-money.doubleValue());
                    try {
                        paypalInfoService.update(paypalInfo);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    //订单状态改变
                    orderDetailService = (OrderDetailServiceImpl)applicationContext.getBean("orderDetailService");
                    Map<String,Object> stringObjectMapOD=new HashMap<String, Object>();
                    stringObjectMapOD.put("TAOBAO_ACCOUNT_ID",taoBaoAccountId);
                    stringObjectMapOD.put("ORDER_INFO_ID",orderInfoId);
                    try {
                        orderDetailList=orderDetailService.findByCondtion(stringObjectMapOD);
                        for(int i=0;i<orderDetailList.size();i++){
                            orderDetailList.get(i).setOrderStatus((byte)2);
                            orderDetailService.update(orderDetailList.get(i));
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    System.out.println("支付成功");

                    open();
                }else {
                    //余额不足，支付失败
                    System.out.println("余额不足，支付失败");
//                    response.setContentType("text/html; charset=UTF-8"); //转码
//                    PrintWriter out = response.getWriter();
//                    out.flush();
//                    out.println("<script>");
//                    out.println("alert('账户余额不足，支付失败！返回订单详情：');");
//                    out.println("var path='OrderDetailServlet?id="+orderInfoId+"';");
//                    out.println("window.document.location.href=path;");
//                    out.println("</script>");
                }
            }else {
                //支付密码错误，返回订单详情
                System.out.println("支付密码错误，返回订单详情");
//                response.setContentType("text/html; charset=UTF-8"); //转码
//                PrintWriter out = response.getWriter();
//                out.flush();
//                out.println("<script>");
//                out.println("alert('支付密码错误，支付失败！返回订单详情：');");
//                out.println("var path='OrderDetailServlet?id="+orderInfoId+"';");
//                out.println("window.document.location.href=path;");
//                out.println("</script>");
            }
        }
    }
    /**
     * @Title:
     * @Description: 收货
     * @author hehongju
     * @date 2018-03-09
     */
    public void Receiving(){
        Long orderDetailId=Long.valueOf(strId);

        orderDetailService=(OrderDetailServiceImpl)applicationContext.getBean("orderDetailService");
        orderInfoService=(OrderInfoServiceImpl)applicationContext.getBean("orderInfoService");
        try {
            //确认收货
            orderDetail=orderDetailService.findById(orderDetailId);
            orderDetail.setOrderStatus((byte)5);
            orderDetail.setIsReturned(true);
            orderDetail.setReturnedTime(new Date());
            orderDetailService.save(orderDetail);
            //订单成功
            orderInfo=orderInfoService.findById(orderDetail.getOrderInfoId());
            orderInfo.setIsSuccess(true);
            orderInfo.setTradingTime(new Date());
            orderInfoService.save(orderInfo);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("收货");

        open();

    }
    /**
     * @Title:
     * @Description: 申请退货
     * @author hehongju
     * @date 2018-03-09
     */
    private void returning(){
        Long orderDetailId=Long.valueOf(strId);

        orderDetailService=(OrderDetailServiceImpl)applicationContext.getBean("orderDetailService");
        try {
            //申请退货
            orderDetail=orderDetailService.findById(orderDetailId);
            orderDetail.setOrderStatus((byte)6);
            orderDetailService.save(orderDetail);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("申请退货");

        open();

    }
    /**
     * @Title:
     * @Description: 退货
     * @author hehongju
     * @date 2018-03-09
     */
    public void returned(){
        Long orderDetailId=Long.valueOf(strId);

        orderDetailService=(OrderDetailServiceImpl)applicationContext.getBean("orderDetailService");
        orderInfoService=(OrderInfoServiceImpl)applicationContext.getBean("orderInfoService");
        try {
            //确认退货
            orderDetail=orderDetailService.findById(orderDetailId);
            orderDetail.setOrderStatus((byte)7);
            orderDetail.setIsReturned(true);
            orderDetail.setReturnedTime(new Date());
            orderDetailService.save(orderDetail);
            //订单失败
            orderInfo=orderInfoService.findById(orderDetail.getOrderInfoId());
            orderInfo.setIsSuccess(false);
            orderInfo.setTradingTime(new Date());
            orderInfoService.save(orderInfo);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("确认退货");

        open();
    }

    public String getStrId() {
        return strId;
    }

    public void setStrId(String strId) {
        this.strId = strId;
    }
}
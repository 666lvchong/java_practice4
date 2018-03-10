package wechat_business.action;/********************************************************************
 /**
 * @Project: Team4
 * @Package wechat_business.action
 * @author hehongju
 * @date 2018/3/9 9:54
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import com.opensymphony.xwork2.ActionContext;
import org.apache.struts2.convention.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import wechat_business.entity.Address;
import wechat_business.entity.ItemInfo;
import wechat_business.entity.OrderDetail;
import wechat_business.entity.OrderInfo;
import wechat_business.service.*;

import java.sql.SQLException;
import java.util.*;

/**
 * @author hehongju
 * @ClassName ShoppingCartAction
 * @Description 类描述
 * @date 2018/3/9
 */
@Action(value = "shoppingCartAction")
@Results({
        @Result(name = "shoppingCart" ,location = "/jsp/shopping_cart.jsp")
//        @Result(name = "orderInfoAc",location = "orderQuiryAction!open.do",type = "redirect"),
//        @Result(name="orderQuiry",location = "/jsp/order_quiry.jsp")
})
public class ShoppingCartAction extends BaseAction{
    private List<Address> addressList;
    private List<OrderDetail> orderDetailList;
    private ItemInfo itemInfo;
    private OrderInfo orderInfo;
    private Double money = 0d;
    private int index=0;
    private String strId;
    private String moneys;

    @Autowired
    private AddressServiceImpl addressService;
    @Autowired
    private OrderDetailServiceImpl orderDetailService;
    @Autowired
    private ItemInfoServiceImpl itemInfoService;
    @Autowired
    private OrderInfoServiceImpl orderInfoService;

    ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");

    private ShoppingCartAction(){
        System.out.println("购物车");
        addressService= (AddressServiceImpl) applicationContext.getBean("addressService");
        orderDetailService=(OrderDetailServiceImpl)applicationContext.getBean("orderDetailService");
        itemInfoService=(ItemInfoServiceImpl)applicationContext.getBean("itemInfoService");
    }
    /**
     * @Title:
     * @Description: 购物车加载
     * @author hehongju
     * @date 2018-03-09
     */
    public String open(){
        //查询出当前账户的收货地址
        Map<String,Object> stringObjectMapAddress=new HashMap<String, Object>();
        stringObjectMapAddress.put("ADDRESS_TYPE",(byte)1);
//        stringObjectMap.put("TAOBAO_ACCOUNT_ID",taobaoAccount.getId());
        stringObjectMapAddress.put("TAOBAO_ACCOUNT_ID",(long)2);
        try {
            //根据条件查询出地址
            addressList=addressService.findByCondtion(stringObjectMapAddress);
            index=addressList.size();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("地址个数:"+addressList.size());

        //查询出当前账户的购物车信息（未创建订的详情信息）
        Map<String,Object> stringObjectMap=new HashMap<String, Object>();
        stringObjectMap.put("ORDER_INFO_ID",0);
//        stringObjectMap.put("TAOBAO_ACCOUNT_ID",taobaoAccount.getId());
        stringObjectMap.put("TAOBAO_ACCOUNT_ID",(long)2);
        try {
            //根据条件查询出购物车信息
            orderDetailList=orderDetailService.findByCondtion(stringObjectMap);
            for (int i=0;i<orderDetailList.size();i++){
//                itemInfo=itemInfoService.findById(orderDetailList.get(i).getId());
//                itemInfos.add(i,itemInfo.getName());
                //计算总金额
                money+=orderDetailList.get(i).getAmount()*orderDetailList.get(i).getItemNumber();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
//        request.setAttribute("list",orderDetailList);
//        request.setAttribute("listName", itemInfos);
//        request.setAttribute("money",money);
//        request.setAttribute("listAddress",addressList);
//        request.setAttribute("index",index);
        System.out.println("购物车信息记录："+orderDetailList.size());
        ActionContext.getContext().put("list", orderDetailList);
        ActionContext.getContext().put("listAddress",addressList);
        ActionContext.getContext().put("money",money);
        ActionContext.getContext().put("index",index);

        return "shoppingCart";
    }
    /**
     * @Title:
     * @Description: 取消订单
     * @author hehongju
     * @date 2018-03-09
     */
    public void del(){
        //取id
        Long orderDetailId=Long.valueOf(strId);
        try {
            orderDetailService.deleteById(orderDetailId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("删除id:"+orderDetailId);
        open();
    }
    /**
     * @Title:
     * @Description: 购买
     * @author hehongju
     * @date 2018-03-09
     */
    public String buy(){
//        Long taobaoAccountId=2l;
//        money=Double.valueOf(moneys);
//        //取收货地址id
//        Long addressId=1l;
//        // 生成订单编号
//        String orderNum=new Date().getTime()+""+new Random().nextInt(10000)+""+new Date().getTime();
//        orderInfo=orderInfoService.crateOrderInfo(orderNum,taobaoAccountId,money);
//        orderInfo.setAddressId(addressId);
//        try {
//            //创建订单
//            orderInfoService.save(orderInfo);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        //查询出当前账户的购物车信息（未创建订的详情信息）
//        Map<String,Object> stringObjectMap=new HashMap<String, Object>();
//        stringObjectMap.put("ORDER_INFO_ID",0l);
////        stringObjectMap.put("TAOBAO_ACCOUNT_ID",taobaoAccount.getId());
//        stringObjectMap.put("TAOBAO_ACCOUNT_ID",taobaoAccountId);
//        //取订单信息id
//        Map<String,Object> stringObjectMap0=new HashMap<String, Object>();
//        stringObjectMap0.put("ORDER_NUM",orderNum);
//
//        try {
//            //根据条件查询出购物车信息
//            orderDetailList=orderDetailService.findByCondtion(stringObjectMap);
//            for (int i=0;i<orderDetailList.size();i++){
//                orderDetailList.get(i).setOrderStatus((byte)1);
//                orderDetailList.get(i).setOrderInfoId(orderInfoService.findByCondtion(stringObjectMap0).get(0).getId());
//                orderDetailService.update(orderDetailList.get(i));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        System.out.println("创建订单");

        return "orderInfoAc";
    }

    public String getMoneys() {
        return moneys;
    }

    public void setMoneys(String moneys) {
        this.moneys = moneys;
    }

    public String getStrId() {
        return strId;
    }

    public void setStrId(String strId) {
        this.strId = strId;
    }
}
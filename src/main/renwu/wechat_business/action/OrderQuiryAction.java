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
import wechat_business.entity.Address;
import wechat_business.entity.OrderInfo;
import wechat_business.service.AddressServiceImpl;
import wechat_business.service.OrderInfoServiceImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hehongju
 * @ClassName OrderQuiryAction
 * @Description 类描述
 * @date 2018/3/9
 */
@Action(value = "orderQuiryAction")
@Results({
        @Result(name="orderQuiry",location = "/jsp/order_quiry.jsp")
})
public class OrderQuiryAction extends BaseAction{
    @Autowired
    private OrderInfoServiceImpl orderInfoService;
    @Autowired
    private AddressServiceImpl addressService;

    private List<OrderInfo> orderInfoList;
    private List users;
    private Address address;
    private int index=0;
    private String taoBaoId;
    ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");

    public void orderQuiryAction(){
        System.out.println("订单信息");
    }
    /**
     * @Title:
     * @Description: 订单信息加载
     * @author hehongju
     * @date 2018-03-09
     */
    public String open(){
        Long taobaoAccountId=Long.valueOf(taoBaoId);

        Map<String,Object> stringObjectMap=new HashMap<String, Object>();
        stringObjectMap.put("TAOBAO_ACCOUNT_ID",taobaoAccountId);
        orderInfoService=(OrderInfoServiceImpl)applicationContext.getBean("orderInfoService");
        try {
            orderInfoList=orderInfoService.findByCondtion(stringObjectMap);
            users=new ArrayList();
            for(int i=0;i<orderInfoList.size();i++){
                //地址查询,获取收货人
                address=addressService.findById(orderInfoList.get(i).getAddressId());
                users.add(i,address.getLinkmanContacts());
            }
            index=orderInfoList.size();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("订单信息：" + orderInfoList.size());
        ActionContext.getContext().put("index",index);
        ActionContext.getContext().put("list",orderInfoList);
        ActionContext.getContext().put("users",users);
        ActionContext.getContext().put("taoBaoId",taoBaoId);

        return "orderQuiry";
    }

    public String getTaoBaoId() {
        return taoBaoId;
    }

    public void setTaoBaoId(String taoBaoId) {
        this.taoBaoId = taoBaoId;
    }
}
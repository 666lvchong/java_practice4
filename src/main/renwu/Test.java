/**
 * @Project: java_practice
 * @Package PACKAGE_NAME
 * @author lvchong
 * @date 2018/1/22 0:54
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */


import wechat_business.entity.OrderInfo;
import wechat_business.entity.OrderStatementInfo;
import wechat_business.entity.PaypalInfo;
import wechat_business.service.OrderStatementInfoServiceImp;

import java.sql.Date;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

/**
 * @author lvchong
 * @ClassName Test
 * @Description 类描述
 * @date 2018/1/22
 */
public class Test {
    public static void main(String[] args) {
        OrderStatementInfoServiceImp orderStatementInfoServiceImp = new OrderStatementInfoServiceImp();
        try {
            System.out.println("删除5 6 两条数据"+orderStatementInfoServiceImp.deleteByIds(new Long[]{11l,12l}));
            System.out.println(orderStatementInfoServiceImp.deleteById(2l)>0?"删除成功":"删除失败");
            OrderInfo orderInfo = new OrderInfo();
            PaypalInfo paypalInfo = new PaypalInfo();
            paypalInfo.setId(1l);
            orderInfo.setId(1l);
            byte b = 1;
            OrderStatementInfo orderStatementInfo = new OrderStatementInfo( "1",orderInfo , paypalInfo, b, b, 32.3, new Date(2017,02,02),new Date(2017,02,02));
            System.out.println(orderStatementInfo.getId());
            System.out.println(orderStatementInfoServiceImp.saveOrUpdate(orderStatementInfo)>0?"添加成功":"添加失败");
            List<OrderStatementInfo> list = orderStatementInfoServiceImp.findByCondtion(new HashMap<String, Object>());
            List<OrderStatementInfo> list1 = orderStatementInfoServiceImp.findByCondtionForPage(new HashMap<String, Object>(), 0, 5);
            System.out.println("查全部"+list.size());
            System.out.println(list.get(0).getId());
            System.out.println("重第一条开始查后面5条"+list1.size());
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                orderStatementInfoServiceImp.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
    }
}

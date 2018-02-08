package wechat_business.dao;/********************************************************************
 /**
 * @Project: java_practice
 * @Package com.wechat_business.dao
 * @author hehongju
 * @date 2018/1/22 5:47
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import wechat_business.service.OrderDetailServiceImpl;
import wechat_business.common.util.JdbcUtils;
import wechat_business.util.FormatUtils;

import java.sql.*;
import java.util.*;

/**
 * @author hehongju
 * @ClassName OrderDetailDaoImpl
 * @Description 订单详情数据库业务类
 * @date 2018/1/22
 */
public class OrderDetailDaoImpl extends OrderDetailServiceImpl implements OrderDetailDao {
    String sql=null;
    Connection connection= JdbcUtils.getConnection();
    PreparedStatement preparedStatement=null;
    ResultSet resultSet=null;
    List<OrderDetailServiceImpl> list =new ArrayList<OrderDetailServiceImpl>();
    /**
     * @Title: deleteById
     * @Description: 根据Id删除数据
     * @author hehongju
     * @date 2018-01-22
     * @throws java.sql.SQLException
     * @param id 主键ID
     */
    @Override
    public Integer deleteById(Long id) throws SQLException {
        sql="DELETE FROM ORDER_DETAIL WHERE ID="+id;
        preparedStatement=connection.prepareStatement(sql);
        int rows=preparedStatement.executeUpdate();
        preparedStatement.close();
        return rows;
    }
    /**
     * @Title: deleteByIds
     * @Description: 根据Id删除多个
     * @author hehongju
     * @date 2018-01-22
     * @throws java.sql.SQLException
     * @param  ids 主键ID数组
     */
    @Override
    public Integer deleteByIds(Long[] ids) throws SQLException{
        Integer index=0;
        sql="DELETE FROM ORDER_DETAIL ";
        //判断需要删除的个数添加条件
        for(int i=0; i<ids.length;i++){
            if(index==0){
                sql += " WHERE ID=" + ids[i];
                index++;
            }else {
                sql += " OR ID=" + ids[i];
            }

        }
        preparedStatement=connection.prepareStatement(sql);
        int rows=preparedStatement.executeUpdate();
        preparedStatement.close();
        return rows;
    }

    /**
     * @Title: saveOrUpdate
     * @Description: 添加或者修改
     * @author hehongju
     * @date 2018-01-22
     * @throws java.sql.SQLException
     */
    @Override
    public Integer saveOrUpdate(OrderDetailServiceImpl impl) throws SQLException{
        int rows=0;
        if (impl.getId() != null){
            sql="SELECT ID, ORDER_INFO_ID,TAOBAO_ACCOUNT_ID, ITEM_INFO_ID, ITEM_NUMBER, AMOUNT, ORDER_STATUS, IS_SENT, IS_RECEIVED, IS_RETURNED, SENT_TIME, RECEIVED_TIME, RETURNED_TIME  FROM ORDER_DETAIL  WHERE ID="+impl.getId();
            resultSet=connection.prepareStatement(sql).executeQuery();
            //判定id是否存在
            if(resultSet.first()){
                //判定不更新的值
                if(impl.getOrderInfoId()==null){
                    impl.setOrderInfoId(resultSet.getLong(2));
                }
                if(impl.getTaobaoAccountId()==null){
                    impl.setTaobaoAccountId(resultSet.getLong(3));
                }
                if(impl.getItemInfoId()==null){
                    impl.setItemInfoId(resultSet.getLong(4));
                }
                if (impl.getItemNumber()==null){
                    impl.setItemNumber(resultSet.getDouble(5));
                }
                if(impl.getAmount()==null){
                    impl.setAmount(resultSet.getDouble(6));
                }
                if (impl.getOrderStatus()==null){
                    impl.setOrderStatus(resultSet.getByte(7));
                }
                if (impl.getIsSent()==null){
                    impl.setIsSent(resultSet.getBoolean(8));
                }
                if(impl.getIsReceived()==null){
                    impl.setIsReceived(resultSet.getBoolean(9));
                }
                if(impl.getIsReturned()==null){
                    impl.setIsReturned(resultSet.getBoolean(10));
                }
                if(impl.getSentTime()==null){
                    impl.setSentTime(resultSet.getTimestamp(11));
                }
                if (impl.getReceivedTime()==null){
                    impl.setReceivedTime(resultSet.getTimestamp(12));
                }
                if (impl.getReturnedTime()==null){
                    impl.setReturnedTime(resultSet.getTimestamp(13));
                }

                //根据ID更新订单详情
                sql="UPDATE ORDER_DETAIL SET ORDER_INFO_ID=?,ITEM_INFO_ID=?,ITEM_NUMBER=?," +
                        "AMOUNT=?,ORDER_STATUS=?,IS_SENT=?," +
                        "IS_RECEIVED =?,IS_RETURNED=?,SENT_TIME=?," +
                        "RECEIVED_TIME=?,RETURNED_TIME=?,TAOBAO_ACCOUNT_ID=?" +
                        " WHERE ID=?";
                preparedStatement=connection.prepareStatement(sql);
                preparedStatement.setLong(1,impl.getOrderInfoId());
                preparedStatement.setLong(2, impl.getItemInfoId());
                preparedStatement.setDouble(3, impl.getItemNumber());
                preparedStatement.setDouble(4, impl.getAmount());
                preparedStatement.setByte(5, impl.getOrderStatus());
                preparedStatement.setBoolean(6, impl.getIsSent());
                preparedStatement.setBoolean(7,impl.getIsReceived());
                preparedStatement.setBoolean(8,impl.getIsReturned());
                preparedStatement.setString(9, FormatUtils.dateTimeFormat(impl.getSentTime()));
                preparedStatement.setString(10, FormatUtils.dateTimeFormat(impl.getReceivedTime()));
                preparedStatement.setString(11, FormatUtils.dateTimeFormat(impl.getReturnedTime()));
                preparedStatement.setLong(12,impl.getTaobaoAccountId());
                preparedStatement.setLong(13, impl.getId());
                rows=preparedStatement.executeUpdate();
            }else {
                //根据ID插入订单详情
                sql="INSERT INTO ORDER_DETAIL(ID,ORDER_INFO_ID, ITEM_INFO_ID, ITEM_NUMBER, AMOUNT, ORDER_STATUS, IS_SENT, IS_RECEIVED, IS_RETURNED, SENT_TIME, RECEIVED_TIME, RETURNED_TIME,TAOBAO_ACCOUNT_ID) " +
                        "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
                preparedStatement=connection.prepareStatement(sql);
                preparedStatement.setLong(1, impl.getId());
                preparedStatement.setLong(2,impl.getOrderInfoId());
                preparedStatement.setLong(3, impl.getItemInfoId());
                preparedStatement.setDouble(4, impl.getItemNumber());
                preparedStatement.setDouble(5, impl.getAmount());
                preparedStatement.setByte(6, impl.getOrderStatus());
                preparedStatement.setBoolean(7, impl.getIsSent());
                preparedStatement.setBoolean(8, impl.getIsReceived());
                preparedStatement.setBoolean(9, impl.getIsReturned());
                preparedStatement.setString(10, wechat_business.util.FormatUtils.dateTimeFormat(impl.getSentTime()));
                preparedStatement.setString(11, wechat_business.util.FormatUtils.dateTimeFormat(impl.getReceivedTime()));
                preparedStatement.setString(12, wechat_business.util.FormatUtils.dateTimeFormat(impl.getReturnedTime()));
                preparedStatement.setLong(13,impl.getTaobaoAccountId());
                 rows=preparedStatement.executeUpdate();
            }

        }else {
            //默认自增主键ID插入订单详情
            sql="INSERT INTO ORDER_DETAIL(ID,ORDER_INFO_ID, ITEM_INFO_ID, ITEM_NUMBER, AMOUNT, ORDER_STATUS, IS_SENT, IS_RECEIVED, IS_RETURNED, SENT_TIME, RECEIVED_TIME, RETURNED_TIME,TAOBAO_ACCOUNT_ID)  " +
                    "VALUES (DEFAULT,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setLong(1,impl.getOrderInfoId());
            preparedStatement.setLong(2, impl.getItemInfoId());
            preparedStatement.setDouble(3,impl.getItemNumber());
            preparedStatement.setDouble(4, impl.getAmount());
            preparedStatement.setByte(5, impl.getOrderStatus());
            preparedStatement.setBoolean(6,impl.getIsSent());
            preparedStatement.setBoolean(7,impl.getIsReceived());
            preparedStatement.setBoolean(8,impl.getIsReturned());
            preparedStatement.setString(9, wechat_business.util.FormatUtils.dateTimeFormat(impl.getSentTime()));
            preparedStatement.setString(10, wechat_business.util.FormatUtils.dateTimeFormat(impl.getReceivedTime()));
            preparedStatement.setString(11, wechat_business.util.FormatUtils.dateTimeFormat(impl.getReturnedTime()));
            preparedStatement.setLong(12,impl.getTaobaoAccountId());
            rows=preparedStatement.executeUpdate();
        }
        preparedStatement.close();
        return rows;
    }
    /**
     * @Title: findById
     * @Description: 更具Id查询数据
     * @author lhehongju
     * @date 2018-01-22
     * @throws java.sql.SQLException
     * @param id 主键ID
     */
    @Override
    public OrderDetailServiceImpl findById(Long id) throws SQLException{
        sql="SELECT ID, ORDER_INFO_ID, ITEM_INFO_ID, ITEM_NUMBER, AMOUNT, ORDER_STATUS, IS_SENT, IS_RECEIVED, IS_RETURNED, SENT_TIME, RECEIVED_TIME, RETURNED_TIME,TAOBAO_ACCOUNT_ID" +
                " FROM ORDER_DETAIL WHERE ID="+id;
        resultSet=connection.prepareStatement(sql).executeQuery();
        OrderDetailServiceImpl orderDetailService=new OrderDetailServiceImpl();
        while (resultSet.next()){
            //赋值
            orderDetailService.setId(id);
            orderDetailService.setOrderInfoId(resultSet.getLong(2));
            orderDetailService.setItemInfoId(resultSet.getLong(3));
            orderDetailService.setItemNumber(resultSet.getDouble(4));
            orderDetailService.setAmount(resultSet.getDouble(5));
            orderDetailService.setOrderStatus(resultSet.getByte(6));
            orderDetailService.setIsSent(resultSet.getBoolean(7));
            orderDetailService.setIsReceived(resultSet.getBoolean(8));
            orderDetailService.setIsReturned(resultSet.getBoolean(9));
            orderDetailService.setSentTime(resultSet.getTimestamp(10));
            orderDetailService.setReceivedTime(resultSet.getTimestamp(11));
            orderDetailService.setReturnedTime(resultSet.getTimestamp(12));
            orderDetailService.setTaobaoAccountId(resultSet.getLong(13));
        }
        resultSet.close();
        return orderDetailService;
    }
    /**
     * @Title: findByCondtion
     * @Description: 条件查询数据
     * @author hehongju
     * @date 2018-01-22
     * @throws java.sql.SQLException
     * @param stringObjectMap 条件键值对
     */
    @Override
    public List<OrderDetailServiceImpl> findByCondtion(Map<String, Object> stringObjectMap) throws SQLException {
        list.clear();
        sql="SELECT ID, ORDER_INFO_ID, ITEM_INFO_ID, ITEM_NUMBER, AMOUNT, ORDER_STATUS, IS_SENT, IS_RECEIVED, IS_RETURNED, SENT_TIME, RECEIVED_TIME, RETURNED_TIME ,TAOBAO_ACCOUNT_ID" +
                " FROM ORDER_DETAIL ";
        //判定条件是否为空
        if(stringObjectMap != null) {
            Set<Map.Entry<String, Object>> set = stringObjectMap.entrySet();
            Iterator<Map.Entry<String, Object>> iterator = set.iterator();
            int index=0;
            while (iterator.hasNext()) {
                Map.Entry<String, Object> map = iterator.next();
                if(index==0){
                    sql += "WHERE " + map.getKey() + " = " + map.getValue();
                    index++;
                }else {
                    sql += " AND " + map.getKey() + " = " + map.getValue();
                }
            }
        }
        resultSet=connection.prepareStatement(sql).executeQuery();
        while (resultSet.next()){
            //赋值
            OrderDetailServiceImpl orderDetailService=new OrderDetailServiceImpl();
            orderDetailService.setId(resultSet.getLong(1));
            orderDetailService.setOrderInfoId(resultSet.getLong(2));
            orderDetailService.setItemInfoId(resultSet.getLong(3));
            orderDetailService.setItemNumber(resultSet.getDouble(4));
            orderDetailService.setAmount(resultSet.getDouble(5));
            orderDetailService.setOrderStatus(resultSet.getByte(6));
            orderDetailService.setIsSent(resultSet.getBoolean(7));
            orderDetailService.setIsReceived(resultSet.getBoolean(8));
            orderDetailService.setIsReturned(resultSet.getBoolean(9));
            orderDetailService.setSentTime(resultSet.getTimestamp(10));
            orderDetailService.setReceivedTime(resultSet.getTimestamp(11));
            orderDetailService.setReturnedTime(resultSet.getTimestamp(12));
            orderDetailService.setTaobaoAccountId(resultSet.getLong(13));
            list.add(orderDetailService);
        }
        resultSet.close();
        return list;
    }
    /**
     * @Title: findByCondtionForPage
     * @Description: 根据条件分页查询数据
     * @author hehongju
     * @date 2018-01-22
     * @throws java.sql.SQLException
     * @param stringObjectMap 条件键值对
     * @param startRows 分页开始值
     * @param size 分页大小
     */
    @Override
    public List<OrderDetailServiceImpl> findByCondtionForPage(Map<String, Object> stringObjectMap, Integer startRows, Integer size) throws SQLException{
        list.clear();
        sql="SELECT ID, ORDER_INFO_ID, ITEM_INFO_ID, ITEM_NUMBER, AMOUNT, ORDER_STATUS, IS_SENT, IS_RECEIVED, IS_RETURNED, SENT_TIME, RECEIVED_TIME, RETURNED_TIME,TAOBAO_ACCOUNT_ID " +
                " FROM ORDER_DETAIL ";
        //判定条件是否为空
        if(stringObjectMap != null) {
            Set<Map.Entry<String, Object>> set = stringObjectMap.entrySet();
            Iterator<Map.Entry<String, Object>> iterator = set.iterator();
            int index=0;
            while (iterator.hasNext()) {
                Map.Entry<String, Object> map = iterator.next();
                if(index==0){
                    sql += "WHERE " + map.getKey() + " = " + map.getValue();
                    index++;
                }else {
                    sql += " AND " + map.getKey() + " = " + map.getValue();
                }
            }
        }
        sql+=" LIMIT "+startRows+", "+size;
        resultSet=connection.prepareStatement(sql).executeQuery();
        while (resultSet.next()){
            //赋值
            OrderDetailServiceImpl orderDetailService=new OrderDetailServiceImpl();
            orderDetailService.setId(resultSet.getLong(1));
            orderDetailService.setOrderInfoId(resultSet.getLong(2));
            orderDetailService.setItemInfoId(resultSet.getLong(3));
            orderDetailService.setItemNumber(resultSet.getDouble(4));
            orderDetailService.setAmount(resultSet.getDouble(5));
            orderDetailService.setOrderStatus(resultSet.getByte(6));
            orderDetailService.setIsSent(resultSet.getBoolean(7));
            orderDetailService.setIsReceived(resultSet.getBoolean(8));
            orderDetailService.setIsReturned(resultSet.getBoolean(9));
            orderDetailService.setSentTime(resultSet.getTimestamp(10));
            orderDetailService.setReceivedTime(resultSet.getTimestamp(11));
            orderDetailService.setReturnedTime(resultSet.getTimestamp(12));
            orderDetailService.setTaobaoAccountId(resultSet.getLong(13));
            list.add(orderDetailService);
        }
        resultSet.close();
        return list;
    }
}
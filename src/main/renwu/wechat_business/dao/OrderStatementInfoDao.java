package wechat_business.dao;
/**
 * @Project: java_practice
 * @Package wechat_business.dao
 * @author lvchong
 * @date 2018/1/21 23:40
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import wechat_business.entity.OrderStatementInfo;
import wechat_business.entity.SellerInfo;

import java.sql.SQLException;
import java.util.*;

/**
 * @author lvchong
 * @ClassName OrderStatementInfo
 * @Description 类描述
 * @date 2018/1/21
 */
public class OrderStatementInfoDao extends Dao<OrderStatementInfo> {
    private String sql = null;
    private Integer result;
    @Override
    /**
     * @Title: deleteById
     * @Description: 根据Id删除数据
     * @author lvchong
     * @date 2018-01-19
     */
    public Integer deleteById(Long id) throws SQLException {
        sql ="DELETE FROM ORDER_STATEMENT_INFO WHERE ID = ?";
        preparedStatement = getPreparedStatement(sql);
        preparedStatement.setLong(1,id);
        result = preparedStatement.executeUpdate();
        commit();
        return result;
    }
    /**
     * @Title: deleteByIds
     * @Description: 根据Id删除多个
     * @author lvchong
     * @date 2018-01-19
     */
    @Override
    public Integer deleteByIds(Long[] ids) throws SQLException {
        int results = 0;
        if (ids.length > 0){
            for (int i = 0; i <ids.length ; i++) {
                results+=deleteById(ids[i]);
            }
        }
        return results;
    }
    /**
     * @Title: saveOrUpdate
     * @Description: 添加或者修改
     * @author lvchong
     * @date 2018-01-19
     */
    @Override
    public Integer saveOrUpdate(OrderStatementInfo test) throws SQLException {
        if (test.getId() != null){
            sql ="UPDATE order_statement_info " +
                    "SET " +
                    " SERIAL_NUMBER = ?," +
                    " ORDER_INFO_ID = ?," +
                    " PAYPAL_INFO_ID = ?," +
                    " FLOW_RECORD_TYPE = ?," +
                    " IS_PAY_STATUS = ?," +
                    " AMOUNTS = ?," +
                    " LAUNCH_TIME = ?," +
                    " FINSH_TIME = ? " +
                    "WHERE ID = ?";
            preparedStatement = getPreparedStatement(sql);
            preparedStatement.setString(1, test.getSerialNumber());
            preparedStatement.setLong(2,test.getOrderInfoId());
            preparedStatement.setLong(3,test.getPaypalInfoId());
            preparedStatement.setByte(4, test.getFlowRecordType());
            preparedStatement.setByte(5, test.getIsPayStatus());
            preparedStatement.setDouble(6, test.getAmounts());
            preparedStatement.setDate(7, test.getLaunchTime());
            preparedStatement.setDate(8,test.getFinshTime());
            preparedStatement.setLong(9,test.getId());
            result = preparedStatement.executeUpdate();
            commit();
        }else{
            sql = "INSERT INTO order_statement_info" +
                    "(ID,SERIAL_NUMBER,ORDER_INFO_ID,PAYPAL_INFO_ID,FLOW_RECORD_TYPE,IS_PAY_STATUS,AMOUNTS,LAUNCH_TIME,FINSH_TIME)" +
                    "VALUES(DEFAULT,?,?,?,?,?,?,?,?);";
            preparedStatement = getPreparedStatement(sql);
            preparedStatement.setString(1, test.getSerialNumber());
            preparedStatement.setLong(2,test.getOrderInfoId());
            preparedStatement.setLong(3,test.getPaypalInfoId());
            preparedStatement.setByte(4, test.getFlowRecordType());
            preparedStatement.setByte(5, test.getIsPayStatus());
            preparedStatement.setDouble(6, test.getAmounts());
            preparedStatement.setDate(7, test.getLaunchTime());
            preparedStatement.setDate(8,test.getFinshTime());
            result = preparedStatement.executeUpdate();
            commit();
        }
        return result;
    }
    /**
     * @Title: findById
     * @Description: 更具Id查询数据
     * @author lvchong
     * @date 2018-01-19
     */
    @Override
    public OrderStatementInfo findById(Long id) throws SQLException {
        sql = " SELECT " +
                " ID, SERIAL_NUMBER, ORDER_INFO_ID, PAYPAL_INFO_ID, " +
                " FLOW_RECORD_TYPE, IS_PAY_STATUS, AMOUNTS, LAUNCH_TIME, FINSH_TIME " +
                " FROM order_statement_info WHERE ID = ?";
        preparedStatement = getPreparedStatement(sql);
        preparedStatement.setLong(1,id);
        resultSet = preparedStatement.executeQuery();
        OrderStatementInfo orderStatementInfo = null;
        if (resultSet.next()){
            orderStatementInfo = new OrderStatementInfo();
            orderStatementInfo.setId(resultSet.getLong(1));
            orderStatementInfo.setSerialNumber(resultSet.getString(2));
            orderStatementInfo.setOrderInfoId(resultSet.getLong(3));
            orderStatementInfo.setPaypalInfoId(resultSet.getLong(4));
            orderStatementInfo.setFlowRecordType(resultSet.getByte(5));
            orderStatementInfo.setIsPayStatus(resultSet.getByte(6));
            orderStatementInfo.setAmounts(resultSet.getDouble(7));
            orderStatementInfo.setLaunchTime(resultSet.getDate(8));
            orderStatementInfo.setFinshTime(resultSet.getDate(9));
        }
        return orderStatementInfo;
    }
    /**
     * @Title: findByCondtion
     * @Description: 条件查询数据
     * @author lvchong
     * @date 2018-01-19
     * @param stringObjectMap
     */
    @Override
    public List<OrderStatementInfo> findByCondtion(Map<String, Object> stringObjectMap) throws SQLException {
        List<OrderStatementInfo> list = new ArrayList<OrderStatementInfo>();
        if(stringObjectMap != null){
            sql = " SELECT " +
                    " ID, SERIAL_NUMBER, ORDER_INFO_ID, PAYPAL_INFO_ID, " +
                    " FLOW_RECORD_TYPE, IS_PAY_STATUS, AMOUNTS, LAUNCH_TIME, FINSH_TIME " +
                    " FROM order_statement_info  ";
            Set<Map.Entry<String, Object>> set = stringObjectMap.entrySet();
            Iterator<Map.Entry<String, Object>> iterator = set.iterator();
            if(iterator.hasNext()){
                Map.Entry<String, Object> map = iterator.next();
                sql += "WHERE " + map.getKey()+" = '"+map.getValue()+"'";
            }
            while (iterator.hasNext()){
                Map.Entry<String, Object> map = iterator.next();
                sql += "and "+map.getKey()+" = '"+map.getValue()+"'";
            }
            preparedStatement = getPreparedStatement(sql);
            resultSet = preparedStatement.executeQuery();
            OrderStatementInfo orderStatementInfo = null;
            while (resultSet.next()){
                orderStatementInfo = new OrderStatementInfo();
                orderStatementInfo.setId(resultSet.getLong(1));
                orderStatementInfo.setSerialNumber(resultSet.getString(2));
                orderStatementInfo.setOrderInfoId(resultSet.getLong(3));
                orderStatementInfo.setPaypalInfoId(resultSet.getLong(4));
                orderStatementInfo.setFlowRecordType(resultSet.getByte(5));
                orderStatementInfo.setIsPayStatus(resultSet.getByte(6));
                orderStatementInfo.setAmounts(resultSet.getDouble(7));
                orderStatementInfo.setLaunchTime(resultSet.getDate(8));
                orderStatementInfo.setFinshTime(resultSet.getDate(9));
                list.add(orderStatementInfo);
            }
        }
        return list;
    }
    /**
     * @Title: findByCondtionForPage
     * @Description: 根据条件分页查询数据
     * @author lvchong
     * @date 2018-01-19
     */
    @Override
    public List<OrderStatementInfo> findByCondtionForPage(Map<String, Object> stringObjectMap, Integer startRows, Integer size) throws SQLException {
        List<OrderStatementInfo> list = new ArrayList<OrderStatementInfo>();
        if(stringObjectMap != null){
            sql = " SELECT " +
                    " ID, SERIAL_NUMBER, ORDER_INFO_ID, PAYPAL_INFO_ID, " +
                    " FLOW_RECORD_TYPE, IS_PAY_STATUS, AMOUNTS, LAUNCH_TIME, FINSH_TIME " +
                    " FROM order_statement_info  ";
            Set<Map.Entry<String, Object>> set = stringObjectMap.entrySet();
            Iterator<Map.Entry<String, Object>> iterator = set.iterator();
            if(iterator.hasNext()){
                Map.Entry<String, Object> map = iterator.next();
                sql += "WHERE " + map.getKey()+" = '"+map.getValue()+"'";
            }
            while (iterator.hasNext()){
                Map.Entry<String, Object> map = iterator.next();
                sql += "and "+map.getKey()+" = '"+map.getValue()+"'";
            }
            sql += " LIMIT "+startRows+", "+size;
            preparedStatement = getPreparedStatement(sql);
            resultSet = preparedStatement.executeQuery();
            OrderStatementInfo orderStatementInfo = null;
            while (resultSet.next()){
                orderStatementInfo = new OrderStatementInfo();
                orderStatementInfo.setId(resultSet.getLong(1));
                orderStatementInfo.setSerialNumber(resultSet.getString(2));
                orderStatementInfo.setOrderInfoId(resultSet.getLong(3));
                orderStatementInfo.setPaypalInfoId(resultSet.getLong(4));
                orderStatementInfo.setFlowRecordType(resultSet.getByte(5));
                orderStatementInfo.setIsPayStatus(resultSet.getByte(6));
                orderStatementInfo.setAmounts(resultSet.getDouble(7));
                orderStatementInfo.setLaunchTime(resultSet.getDate(8));
                orderStatementInfo.setFinshTime(resultSet.getDate(9));
                list.add(orderStatementInfo);
            }
        }
        return list;
    }


}

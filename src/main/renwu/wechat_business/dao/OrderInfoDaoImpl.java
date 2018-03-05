package wechat_business.dao;/********************************************************************
 /**
 * @Project: java_practice
 * @Package com.wechat_business.dao
 * @author hehongju
 * @date 2018/1/22 5:48
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */



import wechat_business.common.util.JdbcUtils;
import wechat_business.service.OrderInfoServiceImpl;

import java.sql.*;
import java.util.*;

/**
 * @author hehongju
 * @ClassName OrderInfoDaoImpl
 * @Description 订单信息数据库业务类
 * @date 2018/1/22
 */
public class OrderInfoDaoImpl extends wechat_business.service.OrderInfoServiceImpl implements wechat_business.dao.OrderInfoDao {
    String sql=null;
    Connection connection= JdbcUtils.getConnection();
    PreparedStatement preparedStatement=null;
    Statement statement=null;
    ResultSet resultSet=null;
    List<OrderInfoServiceImpl> list =new ArrayList<OrderInfoServiceImpl>();
    /**
     * @Title: deleteById
     * @Description: 根据Id删除数据
     * @author hehongju
     * @date 2018-01-22
     * @throws java.sql.SQLException
     * @param id 主键ID
     */
    @Override
    public Integer deleteById(Long id) throws SQLException{
        sql="DELETE FROM ORDER_INFO WHERE ID="+id;
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
        sql="DELETE FROM ORDER_INFO ";
        //判断删除的需要个数添加条件
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
    public Integer saveOrUpdate(wechat_business.service.OrderInfoServiceImpl impl) throws SQLException {
        int rows=0;
        if (impl.getId() != null){
            sql="SELECT ID, ORDER_NUM, TAOBAO_ACCOUNT_ID, ORDER_TOTAL_AMOUNT, CREATION_TIME, TRADING_TIME, IS_SUCCESS  FROM ORDER_INFO  WHERE ID="+impl.getId();
            resultSet=connection.prepareStatement(sql).executeQuery();
            //判定id是否存在
            if(resultSet.first()){
                //判定不更新的值
                if(impl.getOrderNum()==null){
                    impl.setOrderNum(resultSet.getString(2));
                }
                if (impl.getTaobaoAccountId()==null){
                    impl.setTaobaoAccountId(resultSet.getLong(3));
                }
                if (impl.getOrderTotalAmount()==null){
                    impl.setOrderTotalAmount(resultSet.getDouble(4));
                }
                if (impl.getCreationTime()==null){
                    impl.setCreationTime(resultSet.getTimestamp(5));
                }
                if (impl.getTradingTime()==null){
                    impl.setTradingTime(resultSet.getTimestamp(6));
                }
                if (impl.getIsSuccess()==null){
                    impl.setIsSuccess(resultSet.getBoolean(7));
                }
                //根据ID更新订单信息
                sql="UPDATE ORDER_INFO SET ORDER_NUM=?,TAOBAO_ACCOUNT_ID=?,ORDER_TOTAL_AMOUNT=?," +
                        "CREATION_TIME=?,TRADING_TIME=?,IS_SUCCESS=?" +
                        " WHERE ID = ?";
                preparedStatement=connection.prepareStatement(sql);
                preparedStatement.setString(1,impl.getOrderNum());
                preparedStatement.setLong(2, impl.getTaobaoAccountId());
                preparedStatement.setDouble(3, impl.getOrderTotalAmount());
                preparedStatement.setString(4, wechat_business.util.FormatUtils.dateTimeFormat(impl.getCreationTime()));
                preparedStatement.setString(5, wechat_business.util.FormatUtils.dateTimeFormat(impl.getTradingTime()));
                preparedStatement.setBoolean(6,impl.getIsSuccess());
                preparedStatement.setLong(7, impl.getId());
                rows=preparedStatement.executeUpdate();
            }else {
                //根据ID插入订单信息
                sql="INSERT INTO ORDER_INFO( ID, ORDER_NUM, TAOBAO_ACCOUNT_ID, ORDER_TOTAL_AMOUNT, CREATION_TIME, TRADING_TIME, IS_SUCCESS) " +
                        "VALUES (?,?,?,?,?,?,?)";
                preparedStatement=connection.prepareStatement(sql);
                preparedStatement.setLong(1, impl.getId());
                preparedStatement.setString(2,impl.getOrderNum());
                preparedStatement.setLong(3, impl.getTaobaoAccountId());
                preparedStatement.setDouble(4, impl.getOrderTotalAmount());
                preparedStatement.setString(5, wechat_business.util.FormatUtils.dateTimeFormat(impl.getCreationTime()));
                preparedStatement.setString(6, wechat_business.util.FormatUtils.dateTimeFormat(impl.getTradingTime()));
                preparedStatement.setBoolean(7,impl.getIsSuccess());
                rows=preparedStatement.executeUpdate();
            }
            resultSet.close();
        }else {
            //默认自增主键ID插入订单信息
            sql="INSERT INTO ORDER_INFO( ID, ORDER_NUM, TAOBAO_ACCOUNT_ID, ORDER_TOTAL_AMOUNT, CREATION_TIME, IS_SUCCESS) " +
                    "VALUES (DEFAULT ,?,?,?,?,?)";
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,impl.getOrderNum());
            preparedStatement.setLong(2, impl.getTaobaoAccountId());
            preparedStatement.setDouble(3, impl.getOrderTotalAmount());
            preparedStatement.setString(4, wechat_business.util.FormatUtils.dateTimeFormat(impl.getCreationTime()));
            preparedStatement.setBoolean(5, impl.getIsSuccess());
            rows=preparedStatement.executeUpdate();
        }
        preparedStatement.close();
        return rows;
    }
    /**
     * @Title: findById
     * @Description: 更具Id查询数据
     * @author hehongju
     * @date 2018-01-22
     * @throws java.sql.SQLException
     * @param id 主键ID
     */
    @Override
    public wechat_business.service.OrderInfoServiceImpl findById(Long id) throws SQLException{
        sql="SELECT ID, ORDER_NUM, TAOBAO_ACCOUNT_ID, ORDER_TOTAL_AMOUNT, CREATION_TIME, TRADING_TIME, IS_SUCCESS  FROM ORDER_INFO  " +
                "WHERE ID="+id;
        resultSet=connection.prepareStatement(sql).executeQuery();
        OrderInfoServiceImpl orderInfoService=new OrderInfoServiceImpl();
        while (resultSet.next()){
            //赋值
            orderInfoService.setId(id);
            orderInfoService.setOrderNum(resultSet.getString(2));
            orderInfoService.setTaobaoAccountId(resultSet.getLong(3));
            orderInfoService.setOrderTotalAmount(resultSet.getDouble(4));
            orderInfoService.setCreationTime(resultSet.getTimestamp(5));
            orderInfoService.setTradingTime(resultSet.getTimestamp(6));
            orderInfoService.setIsSuccess(resultSet.getBoolean(7));
        }
        resultSet.close();
        return orderInfoService;
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
    public List<wechat_business.service.OrderInfoServiceImpl> findByCondtion(Map<String, Object> stringObjectMap) throws SQLException{
        list.clear();
        sql="SELECT ID, ORDER_NUM, TAOBAO_ACCOUNT_ID, ORDER_TOTAL_AMOUNT, CREATION_TIME, TRADING_TIME, IS_SUCCESS " +
                " FROM ORDER_INFO  " ;

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
                    sql += " ANd " + map.getKey() + " = " + map.getValue();
                }
            }
        }
        resultSet=connection.prepareStatement(sql).executeQuery();
        while (resultSet.next()){
            //赋值
            OrderInfoServiceImpl orderInfoService=new OrderInfoServiceImpl();
            orderInfoService.setId(resultSet.getLong(1));
            orderInfoService.setOrderNum(resultSet.getString(2));
            orderInfoService.setTaobaoAccountId(resultSet.getLong(3));
            orderInfoService.setOrderTotalAmount(resultSet.getDouble(4));
            orderInfoService.setCreationTime(resultSet.getTimestamp(5));
            orderInfoService.setTradingTime(resultSet.getTimestamp(6));
            orderInfoService.setIsSuccess(resultSet.getBoolean(7));
            list.add(orderInfoService);
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
    public List<wechat_business.service.OrderInfoServiceImpl> findByCondtionForPage(Map<String, Object> stringObjectMap, Integer startRows, Integer size) throws SQLException{
        list.clear();
        sql="SELECT ID, ORDER_NUM, TAOBAO_ACCOUNT_ID, ORDER_TOTAL_AMOUNT, CREATION_TIME, TRADING_TIME, IS_SUCCESS " +
                " FROM ORDER_INFO  " ;
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
            OrderInfoServiceImpl orderInfoService=new OrderInfoServiceImpl();
            orderInfoService.setId(resultSet.getLong(1));
            orderInfoService.setOrderNum(resultSet.getString(2));
            orderInfoService.setTaobaoAccountId(resultSet.getLong(3));
            orderInfoService.setOrderTotalAmount(resultSet.getDouble(4));
            orderInfoService.setCreationTime(resultSet.getTimestamp(5));
            orderInfoService.setTradingTime(resultSet.getTimestamp(6));
            orderInfoService.setIsSuccess(resultSet.getBoolean(7));
            list.add(orderInfoService);
        }
        resultSet.close();
        return list;
    }

}
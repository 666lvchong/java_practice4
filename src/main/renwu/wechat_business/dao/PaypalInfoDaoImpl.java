package wechat_business.dao;/********************************************************************
 /**
 * @Project: java_practice
 * @Package dao
 * @author caixing
 * @date 2018/1/20 16:54
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */
import org.springframework.stereotype.Repository;
import wechat_business.common.util.JdbcUtils;
import wechat_business.entity.PaypalInfo;

import java.sql.*;
import java.sql.Date;
import java.util.*;

/**
 * @author caixing
 * @ClassName PaypalInfoDaoImpl
 * @Description 类描述 支付宝信息Dao实现
 * @date 2018/1/20
 */
@Repository
public class PaypalInfoDaoImpl implements PaypalInfoDao {
    //定义字符串保存sql语句
    String sql=null;
    //连接数据库创建Connection对象
    Connection connection= JdbcUtils.getConnection();
    PreparedStatement preparedStatement=null;
    ResultSet resultSet=null;
    List list=new ArrayList();
    //创建支付宝信息对象用于保存查询出来的信息
    PaypalInfo paypalInfo=null;
    //定义修改状态  1--修改成功 0--修改状态
    int rows;

    @Override
    /**
     * @Title: deleteById
     * @Description: 方法描述 根据Id删除数据
     * @author caixing
     * @date 2018/1/19
     * @throw SQLException
     */
    public Integer deleteById(Long id) throws SQLException {
        sql="DELETE FROM paypal_info WHERE ID="+id;
        preparedStatement=connection.prepareStatement(sql);
        int rows=preparedStatement.executeUpdate();
        return rows;
    }
    @Override
    /**
     * @Title: deleteByIds
     * @Description: 方法描述 根据多个id删除多条数据
     * @author caixing
     * @date 2018/1/19
     * @throw SQLException
     */
    public Integer deleteByIds(Long[] ids) throws SQLException {
        for (Long longs: ids){
            sql="DELETE FROM paypal_info WHERE Id="+longs;
            preparedStatement=connection.prepareStatement(sql);
            rows=preparedStatement.executeUpdate();
        }
        return rows;
    }

    @Override
    /**
     * @Title: saveOrUpdate
     @Description: 方法描述 添加或者修改
      * @author caixing
     * @date 2018/1/19
     * @throw SQLException
     */
    public Integer saveOrUpdate(PaypalInfo paypalInfo) throws SQLException {
        if (paypalInfo.getId()==null) {
            sql = "INSERT INTO paypal_info  VALUES(DEFAULT,?,?,?,?,?,?,?,?,?)";
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1, paypalInfo.getAccount());
            preparedStatement.setString(2, paypalInfo.getPassword());
            preparedStatement.setDouble(3, paypalInfo.getBalance());
            preparedStatement.setDate(4, (Date) paypalInfo.getRegisterDate());
            preparedStatement.setInt(5, paypalInfo.getPayPassword());
            preparedStatement.setByte(6, paypalInfo.getIsFreezen());
            preparedStatement.setByte(7, paypalInfo.getIsCancel());
            preparedStatement.setByte(8,paypalInfo.getIsDelete());
            preparedStatement.setLong(9,paypalInfo.getTaobaoAccountId());
            rows=preparedStatement.executeUpdate();
        }else{
            sql = "UPDATE paypal_info SET ACCOUNT=?,PASSWORD=?,BALANCE=?,REGISTER_DATE=?,PAY_PASSWORD=?" +
                    ",IS_FREEZEN=?,IS_CANCEL=?,IS_DELETE=?,TAOBAO_ACCOUNT_ID=?, WHERE ID=?";
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1, paypalInfo.getAccount());
            preparedStatement.setString(2,paypalInfo.getPassword());
            preparedStatement.setDouble(3, paypalInfo.getBalance());
            preparedStatement.setDate(4, (Date) paypalInfo.getRegisterDate());
            preparedStatement.setInt(5, paypalInfo.getPayPassword());
            preparedStatement.setByte(6, paypalInfo.getIsFreezen());
            preparedStatement.setByte(7, paypalInfo.getIsCancel());
            preparedStatement.setByte(8,paypalInfo.getIsDelete());
            preparedStatement.setLong(9, paypalInfo.getTaobaoAccountId());
            preparedStatement.setLong(10, paypalInfo.getId());
            rows=preparedStatement.executeUpdate();
        }
        return rows;
    }

    @Override
    /**
     * @Title: findById
     @Description: 方法描述 根据Id查询数据
      * @author caixing
     * @date 2018/1/19
     * @throw SQLException
     */
    public PaypalInfo findById(Long id) throws SQLException {
        PaypalInfo paypalInfo1=new PaypalInfo();
        sql="SELECT ID,ACCOUNT,PASSWORD,BALANCE,REGISTER_DATE,PAY_PASSWORD,IS_FREEZEN,IS_CANCEL,IS_DELETE,TAOBAO_ACCOUNT_ID FROM paypal_info WHERE Id="+id;
        preparedStatement=connection.prepareStatement(sql);
        ResultSet resultSet1=preparedStatement.executeQuery();
        if (resultSet1.next()) {
            paypalInfo = new PaypalInfo();
            paypalInfo.setId(resultSet1.getLong(1));
            paypalInfo.setAccount(resultSet1.getString(2));
            paypalInfo.setPassword(resultSet1.getString(3));
            paypalInfo.setBalance(resultSet1.getDouble(4));
            paypalInfo.setRegisterDate(resultSet1.getDate(5));
            paypalInfo.setPayPassword(resultSet1.getInt(6));
            paypalInfo.setIsFreezen(resultSet1.getByte(7));
            paypalInfo.setIsCancel(resultSet1.getByte(8));
            paypalInfo.setIsDelete(resultSet1.getByte(9));
            paypalInfo.setTaobaoAccountId(resultSet1.getLong(10));
            return paypalInfo;
        }
        return  null;
    }

    @Override
    /**
     * @Title: findByCondtion
     * @Description: 方法描述 条件查询数据
     * @author caixing
     * @date 2018/1/19
     * @throw SQLException
     */
    public  List<PaypalInfo> findByCondtion(Map<String, Object> stringObjectMap) throws SQLException {
        List<PaypalInfo> list=new ArrayList<PaypalInfo>();
        if(stringObjectMap != null){
            sql="SELECT ID,ACCOUNT,PASSWORD,BALANCE,REGISTER_DATE,PAY_PASSWORD,IS_FREEZEN,IS_CANCEL,IS_DELETE,TAOBAO_ACCOUNT_ID FROM paypal_info  WHERE 1 = 1 ";
            Set<Map.Entry<String, Object>> set=stringObjectMap.entrySet();
            Iterator<Map.Entry<String, Object>> iterator = set.iterator();
            while (iterator.hasNext()){
                Map.Entry<String, Object> map = iterator.next();
                sql += "or "+map.getKey()+" = "+map.getValue();
            }
            preparedStatement=connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            PaypalInfo paypalInfo1 = null;
            while (resultSet.next()){
                paypalInfo1 = new PaypalInfo();
                paypalInfo1.setId(resultSet.getLong(1));
                paypalInfo1.setAccount(resultSet.getString(2));
                paypalInfo1.setPassword(resultSet.getString(3));
                paypalInfo1.setBalance(resultSet.getDouble(4));
                paypalInfo1.setRegisterDate(resultSet.getDate(5));
                paypalInfo1.setPayPassword(resultSet.getInt(6));
                paypalInfo1.setIsFreezen(resultSet.getByte(7));
                paypalInfo1.setIsCancel(resultSet.getByte(8));
                paypalInfo1.setIsDelete(resultSet.getByte(9));
                paypalInfo1.setTaobaoAccountId(resultSet.getLong(10));
                list.add(paypalInfo1);
            }
        }
        return list;
    }

    @Override
    /**
     * @Title: findByCondtionForPage
     * @Description: 方法描述 根据条件分页查询数据
     * @author caixing
     * @date 2018/1/19
     * @throw SQLException
     */
    public List<PaypalInfo> findByCondtionForPage(Map<String, Object> stringObjectMap, Integer startRows, Integer size)throws SQLException {
        List<PaypalInfo> list = new ArrayList<PaypalInfo>();
        if(stringObjectMap != null){
            sql="SELECT ID,ACCOUNT,PASSWORD,BALANCE,REGISTER_DATE,PAY_PASSWORD,IS_FREEZEN,IS_CANCEL,IS_DELETE ,TAOBAO_ACCOUNT_ID FROM paypal_info  WHERE 1 = 1 ";
            Set<Map.Entry<String, Object>> set = stringObjectMap.entrySet();
            Iterator<Map.Entry<String, Object>> iterator = set.iterator();
            while (iterator.hasNext()){
                Map.Entry<String, Object> map = iterator.next();
                sql += "or "+map.getKey()+" = "+map.getValue();
            }
            sql += " LIMIT "+startRows+", "+size;
            preparedStatement=connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            PaypalInfo paypalInfo1 = null;
            while (resultSet.next()){
                paypalInfo1.setId(resultSet.getLong(1));
                paypalInfo1.setAccount(resultSet.getString(2));
                paypalInfo1.setPassword(resultSet.getString(3));
                paypalInfo1.setBalance(resultSet.getDouble(4));
                paypalInfo1.setRegisterDate(resultSet.getDate(5));
                paypalInfo1.setPayPassword(resultSet.getInt(6));
                paypalInfo1.setIsFreezen(resultSet.getByte(7));
                paypalInfo1.setIsCancel(resultSet.getByte(8));
                paypalInfo1.setIsDelete(resultSet.getByte(9));
                paypalInfo1.setTaobaoAccountId(resultSet.getLong(10));
                list.add(paypalInfo1);
            }
        }
        return list;
    }

    /**
     * @Title: close()
     * @Description: 方法描述 关闭数据库连接
     * @author caixing
     * @date 2018/1/23
     * @throw SQLException
     */

    public  void close(){
        JdbcUtils.release(connection,preparedStatement,resultSet);
    }



}


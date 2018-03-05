package wechat_business.dao;
/**
 * @Project: wechat_business
 * @Package wechat_business.dao
 * @author wangjunjie
 * @date 2018/1/21 23:40
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import org.springframework.stereotype.Repository;
import wechat_business.entity.SellerInfo;


import  java.sql.Date;
import java.sql.SQLException;
import java.util.*;

/**
 * @author wangjunjie
 * @ClassName SellerInfoDao
 * @Description 卖家信息连接数据库
 * @date 2018/1/21
 */
@Repository
public class SellerInfoDao extends Dao<SellerInfo> {
    private String sql = null;
    private Integer result;
    @Override
    /**
     * @Title: deleteById
     * @Description: 根据Id删除数据
     * @author wangjunjie
     * @throws java.sql.SQLException
     * @date 2018-01-19
     */
    public Integer deleteById(Long id) throws SQLException {
        //定义sql删除语句
        sql ="DELETE FROM SELLER_INFO WHERE ID = ?";
        //获取预编译对象
        preparedStatement = getPreparedStatement(sql);
        //设值参考符的值
        preparedStatement.setLong(1,id);
        //执行sql语句，并获得结果集
        result = preparedStatement.executeUpdate();
        //提交
        commit();
        //返回受影响的行数
        return result;
    }
    /**
     * @Title: deleteByIds
     * @Description: 根据Id删除多个
     * @author wangjunjie
     * @throws java.sql.SQLException
     * @date 2018-01-19
     */
    @Override
    public Integer deleteByIds(Long[] ids) throws SQLException {

        if (ids.length > 0){
            //定义sql语句
            sql ="DELETE FROM SELLER_INFO ";
            for (int i = 0; i <ids.length ; i++) {
                sql += "or id = "+ids[i];
            }
            //获取预编译对象
            preparedStatement = getPreparedStatement(sql);
            //执行sql语句，并获得结果集
            result = preparedStatement.executeUpdate();
            //提交
            commit();
        }
        //返回受影响的行数
        return result;
    }


    /**
     * @Title: saveOrUpdate
     * @Description: 删除或修改
     * @author wangjunjie
     * @date 2018-01-19
     * @throws java.sql.SQLException
     */
    @Override
    public Integer saveOrUpdate(SellerInfo sellerInfo) throws SQLException {
            //判断根据id查询结果是否为空，不为空，执行更新，反之执行插入语句
            if(sellerInfo.getId()!=null){
                //定义sql语句
                sql = "UPDATE seller_info SET SHOP_NAME=?,SHOP_NUMBER=?,SHOP_TYPE=?TAOBAO_ACCOUNT_ID=?," +
                        "REGISTRATION_TIME=? ,ADDRESS=?,EMAIL=?,AFFILIATED_COMPANY=?," +
                        "COMMERCIAL_REGISTRATION_NUM=?,UPDATE_TIME=?,DEPOSIT=?,CREDITWORTHINESS=? WHERE ID=?";
                //获取预编译对象
                preparedStatement = getPreparedStatement(sql);
                //设置占位符的值
                preparedStatement.setString(1, sellerInfo.getShopName());
                preparedStatement.setString(2, sellerInfo.getShopNumber());
                preparedStatement.setString(3, sellerInfo.getShopType());
                preparedStatement.setLong(4, sellerInfo.getTaobaoAccountId());
                preparedStatement.setString(5,  sellerInfo.getRegistrationTime());
                preparedStatement.setString(6, sellerInfo.getAddress());
                preparedStatement.setString(7, sellerInfo.getEmail());
                preparedStatement.setString(8, sellerInfo.getAffiltaedCompany());
                preparedStatement.setString(9, sellerInfo.getCommercialRegistrationNum());
                preparedStatement.setString(10,  sellerInfo.getUpdateTime());
                preparedStatement.setDouble(11, sellerInfo.getDeposit());
                preparedStatement.setDouble(12, sellerInfo.getCreditworthiness());
                preparedStatement.setLong(13, sellerInfo.getId());
                //执行sql语句，并获得结果集
                result = preparedStatement.executeUpdate();
                //提交
                commit();

            }else{
                //定义sql语句
                sql = "INSERT INTO SELLER_INFO (ID,SHOP_NAME,SHOP_NUMBER,SHOP_TYPE,TAOBAO_ACCOUNT_ID,"
                        + "REGISTRATION_TIME ,ADDRESS,EMAIL,AFFILIATED_COMPANY," +
                        "COMMERCIAL_REGISTRATION_NUM,UPDATE_TIME) VALUES" +
                        "(DEFAULT,?,?,?,?,?,?,?,?,?,?)";

                //获取预编译对象
                preparedStatement = getPreparedStatement(sql);
                //preparedStatement.setLong(1, sellerInfo.getId());
                //设置占位符的值
                preparedStatement.setString(1, sellerInfo.getShopName());
                preparedStatement.setString(2, sellerInfo.getShopNumber());
                preparedStatement.setString(3, sellerInfo.getShopType());
                preparedStatement.setLong(4, sellerInfo.getTaobaoAccountId());
                preparedStatement.setString(5, sellerInfo.getRegistrationTime());
                preparedStatement.setString(6, sellerInfo.getAddress());
                preparedStatement.setString(7, sellerInfo.getEmail());
                preparedStatement.setString(8, sellerInfo.getAffiltaedCompany());
                preparedStatement.setString(9, sellerInfo.getCommercialRegistrationNum());
                preparedStatement.setString(10, sellerInfo.getUpdateTime());
                sellerInfo.setDeposit(resultSet.getDouble(12));
                sellerInfo.setCreditworthiness(resultSet.getLong(13));
                //执行sql语句并取得受影响的行数
                result = preparedStatement.executeUpdate();
                //提交
                commit();

            }

        //返回受影响的行数
        return result;
    }
    /**
     * @Title: findById
     * @Description: 根据Id查询单个
     * @author wangjunjie
     * @date 2018-01-19
     * @throws java.sql.SQLException
     */
    @Override
    public SellerInfo findById(Long id) throws SQLException {
        //定义sql语句
        sql="SELECT ID,SHOP_NAME,SHOP_NUMBER,SHOP_TYPE,TAOBAO_ACCOUNT_ID,REGISTRATION_TIME," +
                "ADDRESS,EMAIL,AFFILIATED_COMPANY,COMMERCIAL_REGISTRATION_NUM,UPDATE_TIME," +
                "DEPOSIT,CREDITWORTHINESS FROM SELLER_INFO WHERE Id=?";
        //获取预编译对象
        preparedStatement = getPreparedStatement(sql);
        //设置参考符的值
        preparedStatement.setLong(1,id);
        //执行sql语句，并获得结果集
        resultSet = preparedStatement.executeQuery();
        //定义卖家人员对象
        SellerInfo sellerInfo = null;
        //判断结果的下一个是否存在
        if (resultSet.next()){

            sellerInfo = new SellerInfo();
            sellerInfo.setId(resultSet.getLong(1));
            sellerInfo.setShopName(resultSet.getString(2));
            sellerInfo.setShopNumber(resultSet.getString(3));
            sellerInfo.setShopType(resultSet.getString(4));
            sellerInfo.setTaobaoAccountId(resultSet.getLong(5));
            sellerInfo.setRegistrationTime(resultSet.getString(6));
            sellerInfo.setAddress(resultSet.getString(7));
            sellerInfo.setEmail(resultSet.getString(8));
            sellerInfo.setAffiltaedCompany(resultSet.getString(9));
            sellerInfo.setCommercialRegistrationNum(resultSet.getString(10));
            sellerInfo.setUpdateTime(resultSet.getString(11));
            sellerInfo.setDeposit(resultSet.getDouble(12));
            sellerInfo.setCreditworthiness(resultSet.getLong(13));
            return sellerInfo;
        }
    return  sellerInfo;
    }


    /**
     * @Title: findByCondtion
     * @Description: 根据条件查询多个个
     * @author wangjunjie
     * @date 2018-01-19
     * @param stringObjectMap
     */
    @Override
    public List<SellerInfo> findByCondtion(Map<String, Object> stringObjectMap) throws SQLException {
        //定卖家人员集合
        List<SellerInfo> list = new ArrayList<SellerInfo>();
        //判断卖家人员map对象是否为null
        if(stringObjectMap != null){
            //定义sql语句
            sql="SELECT ID,SHOP_NAME,SHOP_NUMBER,SHOP_TYPE,TAOBAO_ACCOUNT_ID," +
                    "REGISTRATION_TIME,ADDRESS,EMAIL,AFFILIATED_COMPANY," +
                    "COMMERCIAL_REGISTRATION_NUM,UPDATE_TIME,DEPOSIT FROM SELLER_INFO" +" ";
            //定义Map.Entry对象
            Set<Map.Entry<String, Object>> set = stringObjectMap.entrySet();
            //迭代
            Iterator<Map.Entry<String, Object>> iterator = set.iterator();
            if(iterator.hasNext()){
                Map.Entry<String, Object> map = iterator.next();
                sql += " WHERE " + map.getKey()+" = '"+map.getValue()+"'";
            }
            while (iterator.hasNext()){
                Map.Entry<String, Object> map = iterator.next();
                sql += "and "+map.getKey()+" = '"+map.getValue()+"'";
            }
            //获取预编译对象
            preparedStatement = getPreparedStatement(sql);
            //执行sql语句，并获得结果集
            resultSet = preparedStatement.executeQuery();
            //定义卖家人员信息对象
            SellerInfo sellerInfo = null;
            //存值
            while (resultSet.next()){
                sellerInfo = new SellerInfo();
                sellerInfo.setId(resultSet.getLong(1));
                sellerInfo.setShopName(resultSet.getString(2));
                sellerInfo.setShopNumber(resultSet.getString(3));
                sellerInfo.setShopType(resultSet.getString(4));
                sellerInfo.setTaobaoAccountId(resultSet.getLong(5));
                sellerInfo.setRegistrationTime(resultSet.getString(6));
                sellerInfo.setAddress(resultSet.getString(7));
                sellerInfo.setEmail(resultSet.getString(8));
                sellerInfo.setAffiltaedCompany(resultSet.getString(9));
                sellerInfo.setCommercialRegistrationNum(resultSet.getString(10));
                sellerInfo.setUpdateTime(resultSet.getString(11));
                sellerInfo.setDeposit(resultSet.getDouble(12));
                sellerInfo.setCreditworthiness(resultSet.getLong(13));
                list.add(sellerInfo);
            }
        }
        return list;
    }
    /**
     * @Title: findByCondtionForPage
     * @Description: 根据多个Id查询多个并分页
     * @author wangjunjie
     * @date 2018-01-19
     */
    @Override
    public List<SellerInfo> findByCondtionForPage(Map<String, Object> stringObjectMap, Integer startRows, Integer size) throws SQLException {
        //定义人员集合
        List<SellerInfo> list = new ArrayList<SellerInfo>();
        //判断人员map对象是否为null
        if(stringObjectMap != null){
            //定义sql语句
            sql="SELECT ID,SHOP_NAME,SHOP_NUMBER,SHOP_TYPE,TAOBAO_ACCOUNT_ID," +
                    "REGISTRATION_TIME,ADDRESS,EMAIL,AFFILIATED_COMPANY," +
                    "COMMERCIAL_REGISTRATION_NUM,UPDATE_TIME,DEPOSIT FROM SELLER_INFO";
            //定义Map.Entry对象
            Set<Map.Entry<String, Object>> set = stringObjectMap.entrySet();
            //迭代
            Iterator<Map.Entry<String, Object>> iterator = set.iterator();
            while (iterator.hasNext()){
                Map.Entry<String, Object> map = iterator.next();
                sql += "or "+map.getKey()+" = '"+map.getValue()+"'";
            }
            sql += " LIMIT "+startRows+", "+size;
            //获取预编译对象
            preparedStatement = getPreparedStatement(sql);
            //执行sql语句，获得结果集
            resultSet = preparedStatement.executeQuery();
            SellerInfo sellerInfo = null;
            while (resultSet.next()){
                sellerInfo = new SellerInfo();
                sellerInfo.setId(resultSet.getLong(1));
                sellerInfo.setShopName(resultSet.getString(2));
                sellerInfo.setShopNumber(resultSet.getString(3));
                sellerInfo.setShopType(resultSet.getString(4));
                sellerInfo.setTaobaoAccountId(resultSet.getLong(5));
                sellerInfo.setRegistrationTime(resultSet.getString(6));
                sellerInfo.setAddress(resultSet.getString(7));
                sellerInfo.setEmail(resultSet.getString(8));
                sellerInfo.setAffiltaedCompany(resultSet.getString(9));
                sellerInfo.setCommercialRegistrationNum(resultSet.getString(10));
                sellerInfo.setUpdateTime(resultSet.getString(11));
                sellerInfo.setDeposit(resultSet.getDouble(12));
                sellerInfo.setCreditworthiness(resultSet.getLong(13));
                list.add(sellerInfo);
            }
        }
        return list;
    }


}

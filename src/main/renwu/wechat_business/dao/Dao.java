package wechat_business.dao;

/**
 * @Project: java_practice
 * @Package  wechat_business.dao
 * @author lvchong
 * @date 2018/1/19 16:43
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import  wechat_business.common.util.JdbcUtils;
import wechat_business.entity.SellerInfo;

import java.sql.*;
import java.util.List;
import java.util.Map;

/**
 * @author lvchong
 * @ClassName Dao
 * @Description dao工具类
 * @date 2018/1/19
 */
public abstract class Dao<E> {
    protected Connection connection = null;
    protected PreparedStatement preparedStatement = null;
    protected ResultSet resultSet = null;
    public Connection getConnection() throws SQLException {
        if(connection == null){
            connection = JdbcUtils.getConnection();
        }
        connection.setAutoCommit(false);
        return connection;
    }
    public void commit() throws SQLException {
        connection.commit();
    }
    public void rollback() throws SQLException {
        connection.rollback();
    }
    /**
     * @param sql
     * @return PreparedStatement
     * @throws java.sql.SQLException
     * @throws ClassNotFoundException
     */
    public PreparedStatement getPreparedStatement(String sql) throws SQLException {
        preparedStatement = getConnection().prepareStatement(sql);
        return preparedStatement;
    }

    /**
     * 释放资源
     */
    public void release(){
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    /**
     * @Title: deleteById
     * @Description: 根据Id删除数据
     * @author lvchong
     * @date 2018-01-19
     */
    public abstract Integer deleteById(Long id) throws SQLException;

    /**
     * @Title: deleteByIds
     * @Description: 根据Id删除多个
     * @author lvchong
     * @date 2018-01-19
     */
    public abstract Integer deleteByIds(Long[] ids) throws SQLException;
    /**
     * @Title: saveOrUpdate
     * @Description: 添加或者修改
     * @author lvchong
     * @date 2018-01-19
     */
    public abstract Integer saveOrUpdate(E test) throws SQLException;
    /**
     * @Title: findById
     * @Description: 更具Id查询数据
     * @author lvchong
     * @date 2018-01-19
     */
    public abstract E findById(Long id) throws SQLException;
    /**
     * @Title: findByCondtion
     * @Description: 条件查询数据
     * @author lvchong
     * @date 2018-01-19
     * @param stringObjectMap
     */
    public abstract List<E> findByCondtion(Map<String, Object> stringObjectMap) throws SQLException;
    /**
     * @Title: findByCondtionForPage
     * @Description: 根据条件分页查询数据
     * @author lvchong
     * @date 2018-01-19
     */
    public abstract List<E> findByCondtionForPage(Map<String, Object> stringObjectMap, Integer startRows, Integer size) throws SQLException;


}

package wechat_business.dao;

/**
 * @Project: java_practice
 * @Package  wechat_business.dao
 * @author lvchong
 * @date 2018/1/19 16:43
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import org.apache.ibatis.session.RowBounds;
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
public class Dao<E> extends BaseDaoImpl<E> {
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
    public Integer deleteById(Long id) throws SQLException{
        return super.sqlSessionTemplate.delete(getMybaitsNameSpace()+"deleteById",id);
    };

    /**
     * @Title: deleteByIds
     * @Description: 根据Id删除多个
     * @author lvchong
     * @date 2018-01-19
     */
    public Integer deleteByIds(Long[] ids) throws SQLException{
        return super.sqlSessionTemplate.delete(getMybaitsNameSpace()+"deleteByIds",ids);
    };
    /**
     * @Title: save
     * @Description: 添加
     * @author lvchong
     * @date 2018-01-19
     */
    public  Integer save(E test) throws SQLException{
        return super.sqlSessionTemplate.update(getMybaitsNameSpace() + "save", test);
    };

    /**
     * @Title: update
     * @Description: 修改
     * @author lvchong
     * @date 2018-01-19
     */
    public  Integer update(E test) throws SQLException{
        return super.sqlSessionTemplate.update(getMybaitsNameSpace() + "update", test);
    };
    /**
     * @Title: findById
     * @Description: 更具Id查询数据
     * @author lvchong
     * @date 2018-01-19
     */
    public E findById(Long id) throws SQLException{
        return (E)super.sqlSessionTemplate.selectOne(getMybaitsNameSpace()+ "findById", id);
    };
    /**
     * @Title: findByCondtion
     * @Description: 条件查询数据
     * @author lvchong
     * @date 2018-01-19
     * @param stringObjectMap
     */
    public List<E> findByCondtion(Map<String, Object> stringObjectMap) throws SQLException{
        return super.sqlSessionTemplate.selectList(getMybaitsNameSpace() + "findByCondtion", stringObjectMap);
    };
    /**
     * @Title: findByCondtionForPage
     * @Description: 根据条件分页查询数据
     * @author lvchong
     * @date 2018-01-19
     */
    public List<E> findByCondtionForPage(Map<String, Object> stringObjectMap, Integer startRows, Integer size) throws SQLException{
        RowBounds rowBounds = new RowBounds(startRows,size);
        return super.sqlSessionTemplate.selectList(getMybaitsNameSpace() + "findByCondtionForPage", stringObjectMap, rowBounds);
    };


}

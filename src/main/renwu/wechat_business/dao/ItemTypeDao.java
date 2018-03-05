package wechat_business.dao;
/**
 * @Project: Team4
 * @Package wechat_business.dao
 * @author lvchong
 * @date 2018/1/31 11:52
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import wechat_business.entity.ItemType;

import java.sql.SQLException;
import java.util.*;

/**
 * @author lvchong
 * @ClassName ItemTypeDao
 * @Description 类描述
 * @date 2018/1/31
 */
public class ItemTypeDao extends Dao<ItemType> {
   /*
   private String sql = null;
    private Integer result;

    @Override
    *//**
     * @Title: deleteById
     * @Description: 根据Id删除数据
     * @author lvchong
     * @date 2018-01-19
     *//*
    public Integer deleteById(Long id) throws SQLException {
        sql = "DELETE FROM ITEM_TYPE WHERE ID = ?";
        preparedStatement = getPreparedStatement(sql);
        preparedStatement.setLong(1, id);
        result = preparedStatement.executeUpdate();
        commit();
        return result;
    }

    *//**
     * @Title: deleteByIds
     * @Description: 根据Id删除多个
     * @author lvchong
     * @date 2018-01-19
     *//*
    @Override
    public Integer deleteByIds(Long[] ids) throws SQLException {
        int results = 0;
        if (ids.length > 0) {
            for (int i = 0; i < ids.length; i++) {
                results += deleteById(ids[i]);
            }
        }
        return results;
    }

    *//**
     * @Title: saveOrUpdate
     * @Description: 添加或者修改
     * @author lvchong
     * @date 2018-01-19
     *//*
    @Override
    public Integer saveOrUpdate(ItemType test) throws SQLException {
        if (test.getId() != null) {
            sql = " UPDATE ITEM_TYPE " +
                    " SET  " +
                    " NAME = ?," +
                    " DESCRIPTION = ? " +
                    " WHERE  " +
                    " (ID = ?) ";
            preparedStatement = getPreparedStatement(sql);
            preparedStatement.setString(1, test.getName());
            preparedStatement.setString(2, test.getDescription());
            preparedStatement.setLong(3, test.getId());
            result = preparedStatement.executeUpdate();
            commit();
        } else {
            sql = "INSERT INTO ITEM_TYPE (ID, `NAME`, DESCRIPTION) " +
                    " VALUES (?,?,?) ";
            preparedStatement = getPreparedStatement(sql);
            preparedStatement.setLong(1, test.getId());
            preparedStatement.setString(2, test.getName());
            preparedStatement.setString(3, test.getDescription());
            result = preparedStatement.executeUpdate();
            commit();
        }
        return result;
    }

    *//**
     * @Title: findById
     * @Description: 更具Id查询数据
     * @author lvchong
     * @date 2018-01-19
     *//*
    @Override
    public ItemType findById(Long id) throws SQLException {
        sql = "SELECT   ID,`NAME`,DESCRIPTION FROM  ITEM_TYPE WHERE ID = ?";
        preparedStatement = getPreparedStatement(sql);
        preparedStatement.setLong(1, id);
        resultSet = preparedStatement.executeQuery();
        ItemType itemType = null;
        if (resultSet.next()) {
            itemType = new ItemType();
            itemType.setId(resultSet.getLong(1));
            itemType.setName(resultSet.getString(2));
            itemType.setDescription(resultSet.getString(3));
        }
        return itemType;
    }
    *//**
     * @Title: findByCondtion
     * @Description: 条件查询数据
     * @author lvchong
     * @date 2018-01-19
     * @param stringObjectMap
     *//*
    @Override
    public List<ItemType> findByCondtion (Map < String, Object > stringObjectMap)throws SQLException {
        List<ItemType> list = new ArrayList<ItemType>();
        if (stringObjectMap != null) {
            sql = "SELECT   ID,`NAME`,DESCRIPTION FROM  ITEM_TYPE ";
            Set<Map.Entry<String, Object>> set = stringObjectMap.entrySet();
            Iterator<Map.Entry<String, Object>> iterator = set.iterator();
            if (iterator.hasNext()) {
                Map.Entry<String, Object> map = iterator.next();
                sql += "WHERE " + map.getKey() + " = '" + map.getValue() + "'";
            }
            while (iterator.hasNext()) {
                Map.Entry<String, Object> map = iterator.next();
                sql += "and " + map.getKey() + " = '" + map.getValue() + "'";
            }
            preparedStatement = getPreparedStatement(sql);
            resultSet = preparedStatement.executeQuery();
            ItemType itemType = null;
            while (resultSet.next()) {
                itemType = new ItemType();
                itemType.setId(resultSet.getLong(1));
                itemType.setName(resultSet.getString(2));
                itemType.setDescription(resultSet.getString(3));
                list.add(itemType);
            }
        }
        return list;
    }
    *//**
     * @Title: findByCondtionForPage
     * @Description: 根据条件分页查询数据
     * @author lvchong
     * @date 2018-01-19
     *//*
    @Override
    public List<ItemType> findByCondtionForPage (Map < String, Object > stringObjectMap, Integer startRows, Integer
            size)throws SQLException {
        List<ItemType> list = new ArrayList<ItemType>();
        if (stringObjectMap != null) {
            sql = "  SELECT   ID,`NAME`,DESCRIPTION FROM  ITEM_TYPE ";
            Set<Map.Entry<String, Object>> set = stringObjectMap.entrySet();
            Iterator<Map.Entry<String, Object>> iterator = set.iterator();
            if (iterator.hasNext()) {
                Map.Entry<String, Object> map = iterator.next();
                sql += "WHERE " + map.getKey() + " = '" + map.getValue() + "'";
            }
            while (iterator.hasNext()) {
                Map.Entry<String, Object> map = iterator.next();
                sql += "and " + map.getKey() + " = '" + map.getValue() + "'";
            }
            sql += " LIMIT " + startRows + ", " + size;
            preparedStatement = getPreparedStatement(sql);
            resultSet = preparedStatement.executeQuery();
            ItemType itemType = null;
            while (resultSet.next()) {
                itemType = new ItemType();
                itemType.setId(resultSet.getLong(1));
                itemType.setName(resultSet.getString(2));
                itemType.setDescription(resultSet.getString(3));
                list.add(itemType);
            }
        }
        return list;
    }
    */
}
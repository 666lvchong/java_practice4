package wechat_business.dao;/********************************************************************
 /**
 * @Project: java_practice
 * @Package wechat_business.dao
 * @author HL
 * @date 2018/1/25 22:46
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import wechat_business.entity.ItemInfo;
import wechat_business.service.ItemTypeServiceImpl;

import java.sql.SQLException;
import java.util.*;

/**
 * @author huanglei
 * @ClassName ItemInfoDao
 * @Description 商品Dao
 * @date 2018/1/25
 */
public class ItemInfoDao extends Dao<ItemInfo> {
    ItemTypeServiceImpl service = new ItemTypeServiceImpl();
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
        sql ="DELETE FROM ITEM_INFO WHERE ID = ?";
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
    public Integer saveOrUpdate(ItemInfo test) throws SQLException {
        if (test.getId() != null){
            sql ="UPDATE  ITEM_INFO  " +
                    "  NAME  = ?, " +
                    "  NUMBER  = ?, " +
                    "  ITEM_TYPE_ID  = ?, " +
                    "  IN_TIME  = ?, " +
                    "  UPDATE_TIME  = ?, " +
                    "  MAKER  = ?, " +
                    "  ADDR  = ?, " +
                    "  MAKE_TIME  = ?, " +
                    "  EXPIRATION  = ?, " +
                    "  ORIGIN  = ?, " +
                    "  DESCRIPTION  = ?, " +
                    "  DISCOUNT  = ? " +
                    " WHERE " +
                    "  ID  = ?";;
            preparedStatement = getPreparedStatement(sql);
            preparedStatement.setString(1, test.getName());
            preparedStatement.setString(2, test.getNumber());
            preparedStatement.setLong(3, test.getItemType().getId());
            preparedStatement.setDate(4, test.getInTime());
            preparedStatement.setDate(5, test.getUpdateTimel());
            preparedStatement.setString(6, test.getMaker());
            preparedStatement.setString(7,test.getAddr());
            preparedStatement.setDate(8, test.getMakeTime());
            preparedStatement.setDate(9, test.getExpiration());
            preparedStatement.setString(10, test.getOrigin());
            preparedStatement.setString(11,test.getDescription());
            preparedStatement.setFloat(12, test.getDiscount());
            preparedStatement.setLong(13, test.getId());
            result = preparedStatement.executeUpdate();
            commit();
        }else{
            sql = "INSERT INTO  ITEM_INFO  (NAME ,  NUMBER ,  ITEM_TYPE_ID ,  IN_TIME ,  UPDATE_TIME ,  " +
                    "MAKER ,  ADDR ,  MAKE_TIME ,  EXPIRATION ,  ORIGIN ,  DESCRIPTION ,  DISCOUNT , ID) VALUES (?, " +
                    "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, DEFAULT);";
            preparedStatement = getPreparedStatement(sql);
            preparedStatement.setString(1, test.getName());
            preparedStatement.setString(2, test.getNumber());
            preparedStatement.setLong(3, test.getItemType().getId());
            preparedStatement.setDate(4, test.getInTime());
            preparedStatement.setDate(5, test.getUpdateTimel());
            preparedStatement.setString(6, test.getMaker());
            preparedStatement.setString(7,test.getAddr());
            preparedStatement.setDate(8, test.getMakeTime());
            preparedStatement.setDate(9,test.getExpiration());
            preparedStatement.setString(10, test.getOrigin());
            preparedStatement.setString(11,test.getDescription());
            preparedStatement.setFloat(12, test.getDiscount());
            preparedStatement.setLong(13, test.getId());
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
    public ItemInfo findById(Long id) throws SQLException {
        sql = "SELECT\n" +
                " ID,\n" +
                " `NAME`,\n" +
                " NUMBER,\n" +
                " ITEM_TYPE_ID,\n" +
                " IN_TIME,\n" +
                " UPDATE_TIME,\n" +
                " MAKER,\n" +
                " ADDR,\n" +
                " MAKE_TIME,\n" +
                " EXPIRATION,\n" +
                " ORIGIN,\n" +
                " DESCRIPTION,\n" +
                " DISCOUNT\n" +
                "FROM\n" +
                "ITEM_INFO  WHERE ID = ?";
        preparedStatement = getPreparedStatement(sql);
        preparedStatement.setLong(1,id);
        resultSet = preparedStatement.executeQuery();
        ItemInfo itemInfo = null;
        if (resultSet.next()){
            itemInfo = new ItemInfo();
            itemInfo.setId(resultSet.getLong(1));
            itemInfo.setName(resultSet.getString(2));
            itemInfo.setNumber(resultSet.getString(3));
            itemInfo.setItemType(service.findById(resultSet.getLong(4)));
            itemInfo.setInTime(resultSet.getDate(5));
            itemInfo.setUpdateTimel(resultSet.getDate(6));
            itemInfo.setMaker(resultSet.getString(7));
            itemInfo.setAddr(resultSet.getString(8));
            itemInfo.setMakeTime(resultSet.getDate(9));
            itemInfo.setExpiration(resultSet.getDate(10));
            itemInfo.setOrigin(resultSet.getString(11));
            itemInfo.setDescription(resultSet.getString(12));
            itemInfo.setDiscount(resultSet.getFloat(13));
        }
        return itemInfo;
    }
    /**
     * @Title: findByCondtion
     * @Description: 条件查询数据
     * @author lvchong
     * @date 2018-01-19
     * @param stringObjectMap
     */
    @Override
    public List<ItemInfo> findByCondtion(Map<String, Object> stringObjectMap) throws SQLException {
        List<ItemInfo> list = new ArrayList<ItemInfo>();
        if(stringObjectMap != null){
            sql = "SELECT\n" +
                    " ID,\n" +
                    " `NAME`,\n" +
                    " NUMBER,\n" +
                    " ITEM_TYPE_ID,\n" +
                    " IN_TIME,\n" +
                    " UPDATE_TIME,\n" +
                    " MAKER,\n" +
                    " ADDR,\n" +
                    " MAKE_TIME,\n" +
                    " EXPIRATION,\n" +
                    " ORIGIN,\n" +
                    " DESCRIPTION,\n" +
                    " DISCOUNT\n" +
                    "FROM\n" +
                    "ITEM_INFO  ";
            Set<Map.Entry<String, Object>> set = stringObjectMap.entrySet();
            Iterator<Map.Entry<String, Object>> iterator = set.iterator();
            if(iterator.hasNext()){
                Map.Entry<String, Object> map = iterator.next();
                sql += "WHERE " + map.getKey()+" like '%"+map.getValue()+"%'";
            }
            while (iterator.hasNext()){
                Map.Entry<String, Object> map = iterator.next();
                sql += "and "+map.getKey()+" like '%"+map.getValue()+"%'";
            }
            preparedStatement = getPreparedStatement(sql);
            resultSet = preparedStatement.executeQuery();
            ItemInfo itemInfo = null;
            while (resultSet.next()){
                itemInfo = new ItemInfo();
                itemInfo.setId(resultSet.getLong(1));
                itemInfo.setName(resultSet.getString(2));
                itemInfo.setNumber(resultSet.getString(3));
                itemInfo.setItemType(service.findById(resultSet.getLong(4)));
                itemInfo.setInTime(resultSet.getDate(5));
                itemInfo.setUpdateTimel(resultSet.getDate(6));
                itemInfo.setMaker(resultSet.getString(7));
                itemInfo.setAddr(resultSet.getString(8));
                itemInfo.setMakeTime(resultSet.getDate(9));
                itemInfo.setExpiration(resultSet.getDate(10));
                itemInfo.setOrigin(resultSet.getString(11));
                itemInfo.setDescription(resultSet.getString(12));
                itemInfo.setDiscount(resultSet.getFloat(13));
                list.add(itemInfo);
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
    public List<ItemInfo> findByCondtionForPage(Map<String, Object> stringObjectMap, Integer startRows, Integer size) throws SQLException {
        List<ItemInfo> list = new ArrayList<ItemInfo>();
        if(stringObjectMap != null){
            sql = "SELECT\n" +
                    " ID,\n" +
                    " `NAME`,\n" +
                    " NUMBER,\n" +
                    " ITEM_TYPE_ID,\n" +
                    " IN_TIME,\n" +
                    " UPDATE_TIME,\n" +
                    " MAKER,\n" +
                    " ADDR,\n" +
                    " MAKE_TIME,\n" +
                    " EXPIRATION,\n" +
                    " ORIGIN,\n" +
                    " DESCRIPTION,\n" +
                    " DISCOUNT\n" +
                    "FROM\n" +
                    "ITEM_INFO  ";
            Set<Map.Entry<String, Object>> set = stringObjectMap.entrySet();
            Iterator<Map.Entry<String, Object>> iterator = set.iterator();
            if(iterator.hasNext()){
                Map.Entry<String, Object> map = iterator.next();
                sql += "WHERE " + map.getKey()+" like '%"+map.getValue()+"%'";
            }
            while (iterator.hasNext()){
                Map.Entry<String, Object> map = iterator.next();
                sql += "and "+map.getKey()+" like '%"+map.getValue()+"%'";
            }
            sql += " LIMIT "+startRows+", "+size;
            preparedStatement = getPreparedStatement(sql);
            resultSet = preparedStatement.executeQuery();
            ItemInfo itemInfo = null;
            while (resultSet.next()){
                itemInfo = new ItemInfo();
                itemInfo.setId(resultSet.getLong(1));
                itemInfo.setName(resultSet.getString(2));
                itemInfo.setNumber(resultSet.getString(3));
                itemInfo.setItemType(service.findById(resultSet.getLong(4)));
                itemInfo.setInTime(resultSet.getDate(5));
                itemInfo.setUpdateTimel(resultSet.getDate(6));
                itemInfo.setMaker(resultSet.getString(7));
                itemInfo.setAddr(resultSet.getString(8));
                itemInfo.setMakeTime(resultSet.getDate(9));
                itemInfo.setExpiration(resultSet.getDate(10));
                itemInfo.setOrigin(resultSet.getString(11));
                itemInfo.setDescription(resultSet.getString(12));
                itemInfo.setDiscount(resultSet.getFloat(13));
                list.add(itemInfo);
            }
        }
        return list;
    }
}

package wechat_business.dao;
/**
 * @Project: Team4
 * @Package wechat_business.dao
 * @author lvchong
 * @date 2018/1/31 10:50
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import org.springframework.stereotype.Repository;
import wechat_business.entity.ItemRelation;
import wechat_business.service.ItemInfoServiceImpl;
import wechat_business.service.SellerInfoServiceImpl;

import java.sql.SQLException;
import java.util.*;

/**
 * @author lvchong
 * @ClassName ItemRelationDao
 * @Description 类描述
 * @date 2018/1/31
 */
@Repository
public class ItemRelationDao extends Dao<ItemRelation> {
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
        sql ="DELETE FROM ITEM_RELATION WHERE ID = ?";
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
    public Integer saveOrUpdate(ItemRelation test) throws SQLException {
        if (test.getId() != null){
            sql ="UPDATE  ITEM_RELATION \n" +
                    "SET  \n" +
                    "  SELLER_INFO_ID  = ?,\n" +
                    "  ITEM_INFO_ID  = ?,\n" +
                    "  INVENTORY  = ?,\n" +
                    "  PRICE  = ?,\n" +
                    "  IMG_ADDR  = ?\n" +
                    "WHERE\n" +
                    " ID  = ? ";
            preparedStatement = getPreparedStatement(sql);
            preparedStatement.setLong(1,test.getSellerInfo().getId());
            preparedStatement.setLong(2,test.getItemInfo().getId());
            preparedStatement.setDouble(3,test.getInventory());
            preparedStatement.setDouble(4, test.getPrice());
            preparedStatement.setString(5, test.getImgAddr());
            preparedStatement.setLong(6,test.getId());
            result = preparedStatement.executeUpdate();
            commit();
        }else{
            sql = " INSERT INTO ITEM_RELATION  (\n" +
                    "  ID ,\n" +
                    "  SELLER_INFO_ID ,\n" +
                    "  ITEM_INFO_ID ,\n" +
                    "  INVENTORY ,\n" +
                    "  PRICE ,\n" +
                    "  IMG_ADDR \n" +
                    ")\n" +
                    "VALUES\n" +
                    " (\n" +
                    "  NULL,\n" +
                    "  ?,\n" +
                    "  ?,\n" +
                    "  ?,\n" +
                    "  ?,\n" +
                    "  ?\n" +
                    " );";
            preparedStatement = getPreparedStatement(sql);
            preparedStatement.setLong(1,test.getId());
            preparedStatement.setLong(2,test.getSellerInfo().getId());
            preparedStatement.setLong(3,test.getItemInfo().getId());
            preparedStatement.setDouble(4,test.getInventory());
            preparedStatement.setDouble(5, test.getPrice());
            preparedStatement.setString(6, test.getImgAddr());
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
    public ItemRelation findById(Long id) throws SQLException {
        SellerInfoServiceImpl sellerInfoServiceImpl = new SellerInfoServiceImpl();
        ItemInfoServiceImpl itemInfoServiceImpl= new ItemInfoServiceImpl();
        sql = "SELECT ID,SELLER_INFO_ID,ITEM_INFO_ID,INVENTORY,PRICE" +
                " FROM" +
                " ITEM_RELATION WHERE ID=?";
        preparedStatement = getPreparedStatement(sql);
        preparedStatement.setLong(1,id);
        resultSet = preparedStatement.executeQuery();
        commit();
        ItemRelation itemRelation = null;
        if (resultSet.next()){
            itemRelation = new ItemRelation();
            itemRelation.setId(resultSet.getLong(1));
            itemRelation.setSellerInfo(sellerInfoServiceImpl.findById(resultSet.getLong(2)));
            itemRelation.setItemInfo(itemInfoServiceImpl.findById(resultSet.getLong(3)));
            itemRelation.setInventory(resultSet.getDouble(4));
            itemRelation.setPrice(resultSet.getDouble(5));
        }
        return itemRelation;
    }
    /**
     * @Title: findByCondtion
     * @Description: 条件查询数据
     * @author lvchong
     * @date 2018-01-19
     * @param stringObjectMap
     */
    @Override
    public List<ItemRelation> findByCondtion(Map<String, Object> stringObjectMap) throws SQLException {
        SellerInfoServiceImpl sellerInfoServiceImpl = new SellerInfoServiceImpl();
        ItemInfoServiceImpl itemInfoServiceImpl= new ItemInfoServiceImpl();
        List<ItemRelation> list = new ArrayList<ItemRelation>();
        if(stringObjectMap != null){
            sql = "SELECT ID, SELLER_INFO_ID, ITEM_INFO_ID, INVENTORY, PRICE, IMG_ADDR\n" +
                    " FROM\n" +
                    " ITEM_RELATION ";
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
            ItemRelation itemRelation = null;
            while (resultSet.next()){
                itemRelation = new ItemRelation();
                itemRelation.setId(resultSet.getLong(1));
                itemRelation.setSellerInfo(sellerInfoServiceImpl.findById(resultSet.getLong(2)));
                itemRelation.setItemInfo(itemInfoServiceImpl.findById(resultSet.getLong(3)));
                itemRelation.setInventory(resultSet.getDouble(4));
                itemRelation.setPrice(resultSet.getDouble(5));
                itemRelation.setImgAddr(resultSet.getString(6));
                list.add(itemRelation);
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
    public List<ItemRelation> findByCondtionForPage(Map<String, Object> stringObjectMap, Integer startRows, Integer size) throws SQLException {
        SellerInfoServiceImpl sellerInfoServiceImpl = new SellerInfoServiceImpl();
        ItemInfoServiceImpl itemInfoServiceImpl= new ItemInfoServiceImpl();
        List<ItemRelation> list = new ArrayList<ItemRelation>();
        if(stringObjectMap != null){
            sql = " SELECT ID, SELLER_INFO_ID, ITEM_INFO_ID, INVENTORY, PRICE, IMG_ADDR\n" +
                    "FROM\n" +
                    "ITEM_RELATION";
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
            ItemRelation itemRelation = null;
            while (resultSet.next()){
                itemRelation = new ItemRelation();
                itemRelation.setId(resultSet.getLong(1));
                itemRelation.setSellerInfo(sellerInfoServiceImpl.findById(resultSet.getLong(2)));
                itemRelation.setItemInfo(itemInfoServiceImpl.findById(resultSet.getLong(3)));
                itemRelation.setInventory(resultSet.getDouble(4));
                itemRelation.setPrice(resultSet.getDouble(5));
                itemRelation.setImgAddr(resultSet.getString(6));
                list.add(itemRelation);
            }
        }
        return list;
    }


}

package wechat_business.dao;

import wechat_business.entity.Address;
import wechat_business.util.FormatUtils;

import java.sql.SQLException;
import java.util.*;

/**
 * Created by Lenovo on 2018/2/17.
 */
public  class AddressDao extends Dao<Address> {
    private String sql = null;
    private Integer result;

    @Override
    /**
     * @Title: deleteById
     * @Description: 方法描述
     * @author hehongju
     * @date 2018-03-01
     * @throw YnCorpSysException
     */
    public Integer deleteById(Long id) throws SQLException {
        sql="DELETE FROM ADDRESS WHERE ID=?";
        preparedStatement=getPreparedStatement(sql);
        preparedStatement.setLong(1,id);
        result=preparedStatement.executeUpdate();
        commit();
        return result;
    }

    @Override
    /**
     * @Title: deleteByIds
     * @Description: 方法描述
     * @author hehongju
     * @date 2018-03-01
     * @throw YnCorpSysException
     */
    public Integer deleteByIds(Long[] ids) throws SQLException {
        if (ids.length>0){
            sql ="DELETE FROM ADDRESS WHERE ID=?";
            for(int i=0; i<ids.length;i++){
                sql += "or id = " + ids[i];
            }
            preparedStatement = getPreparedStatement(sql);
            result = preparedStatement.executeUpdate();
            commit();
        }
        return result;
    }

    @Override
   /**
    * @Title: saveOrUpdate
    * @Description: 方法描述
    * @author hehongju
    * @date 2018-03-01
    * @throw YnCorpSysException
    */
    public Integer saveOrUpdate(Address test) throws SQLException {
        if (test.getId() != null){
            sql="SELECT ID,TAOBAO_ACCOUNT_ID,ADDRESS_TYPE,ADDRESS,LINKMAN_CONTACTS,TELEPHONE,CREATE_TIME,UPDATE_TIME,IS_DEFAULT FROM ADDRESS WHERE ID=?";
            preparedStatement=getPreparedStatement(sql);
            preparedStatement.setLong(1,test.getId());
            resultSet=preparedStatement.executeQuery();
            //判定id是否存在
            if(resultSet.first()){
                //判定不更新的值
                if(test.getTaobaoAccountID()==null){
                    test.setTaobaoAccountID(resultSet.getLong(2));
                }
                if(test.getAddressType()==null){
                    test.setAddressType(resultSet.getByte(3));
                }
                if(test.getAddress()==null){
                    test.setAddress(resultSet.getString(4));
                }
                if(test.getLinkmanContacts()==null){
                    test.setLinkmanContacts(resultSet.getString(5));
                }
                if(test.getTelephone()==null){
                    test.setTelephone(resultSet.getString(6));
                }
                if(test.getCreateTime()==null){
                    test.setCreateTime(resultSet.getTimestamp(7));
                }
                if(test.getUpdateTime()==null){
                    test.setUpdateTime(resultSet.getTimestamp(8));
                }
                if(test.getIsDefault()==null){
                    test.setIsDefault(resultSet.getBoolean(9));
                }
                //根据ID更新地址信息
                sql="UPDATE ADDRESS SET TAOBAO_ACCOUNT_ID=?,ADDRESS_TYPE=?,ADDRESS=?,LINKMAN_CONTACTS=?,TELEPHONE=?,CREATE_TIME=?,UPDATE_TIME=?,IS_DEFAULT=?"+
                        " WHERE ID = ?";
                preparedStatement=getPreparedStatement(sql);
                preparedStatement.setLong(1,test.getTaobaoAccountID());
                preparedStatement.setByte(2,test.getAddressType());
                preparedStatement.setString(3,test.getAddress());
                preparedStatement.setString(4,test.getLinkmanContacts());
                preparedStatement.setString(5,test.getTelephone());
                preparedStatement.setString(6, FormatUtils.dateTimeFormat(test.getCreateTime()));
                preparedStatement.setString(7,FormatUtils.dateTimeFormat(test.getUpdateTime()));
                preparedStatement.setBoolean(8, test.getIsDefault());
                preparedStatement.setLong(9,test.getId());
                result=preparedStatement.executeUpdate();
                commit();
            }else {
                //根据ID插入地址信息
                sql="INSERT INTO ADDRESS( ID,TAOBAO_ACCOUNT_ID,ADDRESS_TYPE,ADDRESS,LINKMAN_CONTACTS,TELEPHONE,CREATE_TIME,UPDATE_TIME,IS_DEFAULT) " +
                        "VALUES (?,?,?,?,?,?,?,?,?)";
                preparedStatement=getPreparedStatement(sql);
                preparedStatement.setLong(1,test.getId());
                preparedStatement.setLong(2,test.getTaobaoAccountID());
                preparedStatement.setByte(3, test.getAddressType());
                preparedStatement.setString(4, test.getAddress());
                preparedStatement.setString(5, test.getLinkmanContacts());
                preparedStatement.setString(6,test.getTelephone());
                preparedStatement.setString(7, FormatUtils.dateTimeFormat(test.getCreateTime()));
                preparedStatement.setString(8,FormatUtils.dateTimeFormat(test.getUpdateTime()));
                preparedStatement.setBoolean(9,test.getIsDefault());
                result=preparedStatement.executeUpdate();
                commit();
            }
        }else {
            //默认自增主键ID插入地址信息
            sql="INSERT INTO ADDRESS( ID,TAOBAO_ACCOUNT_ID,ADDRESS_TYPE,ADDRESS,LINKMAN_CONTACTS,TELEPHONE,CREATE_TIME,UPDATE_TIME,IS_DEFAULT) " +
                    "VALUES (DEFAULT,?,?,?,?,?,?,?,?)";
            preparedStatement=getPreparedStatement(sql);
            preparedStatement.setLong(1,test.getTaobaoAccountID());
            preparedStatement.setByte(2,test.getAddressType());
            preparedStatement.setString(3,test.getAddress());
            preparedStatement.setString(4,test.getLinkmanContacts());
            preparedStatement.setString(5,test.getTelephone());
            preparedStatement.setString(6, FormatUtils.dateTimeFormat(test.getCreateTime()));
            preparedStatement.setString(7,FormatUtils.dateTimeFormat(test.getUpdateTime()));
            preparedStatement.setBoolean(8,test.getIsDefault());
            result=preparedStatement.executeUpdate();
            commit();
        }
        return result;
    }

    @Override
    /**
     * @Title: findById
     * @Description: 方法描述
     * @author hehongju
     * @date 2018-03-01
     * @throw YnCorpSysException
     */
    public Address findById(Long id) throws SQLException {
        sql="SELECT ID,TAOBAO_ACCOUNT_ID,ADDRESS_TYPE,ADDRESS,LINKMAN_CONTACTS,TELEPHONE,CREATE_TIME,UPDATE_TIME,IS_DEFAULT FROM ADDRESS WHERE ID=?";
        preparedStatement=getPreparedStatement(sql);
        preparedStatement.setLong(1,id);
        resultSet=preparedStatement.executeQuery();
        Address address=new Address();
        while (resultSet.next()){
            address.setId(id);
            address.setTaobaoAccountID(resultSet.getLong(2));
            address.setAddressType(resultSet.getByte(3));
            address.setAddress(resultSet.getString(4));
            address.setLinkmanContacts(resultSet.getString(5));
            address.setTelephone(resultSet.getString(6));
            address.setCreateTime(resultSet.getTimestamp(7));
            address.setUpdateTime(resultSet.getTimestamp(8));
            address.setIsDefault(resultSet.getBoolean(9));
        }

        return address;
    }

    @Override
    /**
     * @Title: findByCondtion
     * @Description: 方法描述
     * @author hehongju
     * @date 2018-03-01
     * @throw YnCorpSysException
     */
    public List<Address> findByCondtion(Map<String, Object> stringObjectMap) throws SQLException {
        List<Address> list= new ArrayList<Address>();
        if (stringObjectMap !=null){
            sql="SELECT  ID,TAOBAO_ACCOUNT_ID,ADDRESS_TYPE,ADDRESS,LINKMAN_CONTACTS,TELEPHONE,CREATE_TIME,UPDATE_TIME,IS_DEFAULT  FROM ADDRESS WHERE 1=1";
            Set<Map.Entry<String,Object>>set=stringObjectMap.entrySet();
            Iterator<Map.Entry<String, Object>> iterator = set.iterator();
            while (iterator.hasNext()){
                Map.Entry<String, Object> map = iterator.next();
                sql += " AND "+map.getKey()+" = '"+map.getValue()+"'";
            }
            preparedStatement=getPreparedStatement(sql);
            resultSet=preparedStatement.executeQuery();
            Address address=null;
            while (resultSet.next()){
                address=new Address();
                address.setId(resultSet.getLong(1));
                address.setTaobaoAccountID(resultSet.getLong(2));
                address.setAddressType(resultSet.getByte(3));
                address.setAddress(resultSet.getString(4));
                address.setLinkmanContacts(resultSet.getString(5));
                address.setTelephone(resultSet.getString(6));
                address.setCreateTime(resultSet.getTimestamp(7));
                address.setUpdateTime(resultSet.getTimestamp(8));
                address.setIsDefault(resultSet.getBoolean(9));
                list.add(address);
            }
        }

        return list;
    }


    @Override
    /**
     * @Title:
     * @Description: 方法描述
     * @author hehongju
     * @date 2018-03-01
     * @throw YnCorpSysException
     */
    public List<Address> findByCondtionForPage(Map<String, Object> stringObjectMap, Integer startRows, Integer size) throws SQLException {
        List<Address> list=new ArrayList<Address>();
        if (stringObjectMap !=null){
            sql="SELECT ID,TAOBAO_ACCOUNT_ID,ADDRESS_TYPE,ADDRESS,LINKMAN_CONTACTS,TELEPHONE,CREATE_TIME,UPDATE_TIME,IS_DEFAULT FROM ADDRESS WHERE 1=1";
            Set<Map.Entry<String,Object>>set=stringObjectMap.entrySet();
            Iterator<Map.Entry<String,Object>>iterator=set.iterator();
            while (iterator.hasNext()){
                Map.Entry<String,Object>map =iterator.next();
                sql+=" AND "+map.getKey()+"=,"+map.getValue()+",";
            }
        }
        sql +=" LIMIT"+startRows+","+size;
        preparedStatement=getPreparedStatement(sql);
        resultSet=preparedStatement.executeQuery();
        Address address=null;
        while (resultSet.next()){
            address=new Address();
            address.setId(resultSet.getLong(1));
            address.setTaobaoAccountID(resultSet.getLong(2));
            address.setAddressType(resultSet.getByte(3));
            address.setAddress(resultSet.getString(4));
            address.setLinkmanContacts(resultSet.getString(5));
            address.setTelephone(resultSet.getString(6));
            address.setCreateTime(resultSet.getTimestamp(7));
            address.setUpdateTime(resultSet.getTimestamp(8));
            address.setIsDefault(resultSet.getBoolean(9));
            list.add(address);
        }
        return list;
    }

}

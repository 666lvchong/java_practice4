package wechat_business.dao;

import wechat_business.entity.Address;

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
     * @Description: 根据Id删除数据
     * @author huangpai
     * @date 2018-02-17
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
     * @Title: deleteById
     * @Description: 根据Id删除多个数据
     * @author huangpai
     * @date 2018-02-17
     */
    public Integer deleteByIds(Long[] ids) throws SQLException {
        if (ids.length>0){
            sql ="DELETE FROM ADDRESS WHERE ID=?";
            for(int i=0; i<ids.length;i++){
                sql += "or id = " + ids[i];
            }preparedStatement = getPreparedStatement(sql);
            result = preparedStatement.executeUpdate();
            commit();
        }
        return result;
    }

    @Override
    /**
     * @Title: saveOrUpdate
     * @Description: 添加或者删除
     * @author huangpai
     * @date 2018-02-17
     */
    public Integer saveOrUpdate(Address test) throws SQLException {
        if (test.getId()!=0){
            sql="UPDATE ADDRESS"+
                    "SET"+
                    "MY_ADDRESS=?,"+
                    "TAOBAO_ACCOUNT_ID=?," +
                    "WHERE ID=?";
            preparedStatement=getPreparedStatement(sql);
            preparedStatement.setString(1,test.getMyaddress());
            preparedStatement.setString(2, String.valueOf(test.getTaobaoaccount()));
            preparedStatement.setLong(3,test.getId());
            result = preparedStatement.executeUpdate();
            commit();
        }else {
            sql="INSERT INTO ADDRESS(ID,MY_ADDRESS,TAOBAO_ACCOUNT_ID"+
                    "VALUES(DEFAULT,?,?)";
            preparedStatement=getPreparedStatement(sql);
            preparedStatement.setString(1,test.getMyaddress());
            preparedStatement.setString(2, String.valueOf(test.getTaobaoaccount()));
            preparedStatement.setLong(3,test.getId());
            result =preparedStatement.executeUpdate();
            commit();
        }
        return result;
    }

    @Override
    /**
     * @Title: findById
     * @Description: 根据id查找数据
     * @author huangpai
     * @date 2018-02-17
     */
    public Address findById(Long id) throws SQLException {
        sql="SELECT ID,MY_ADDRESS,TAOBAO_ACCOUNT_ID FROM ADDRESS WHERE ID=?";
        preparedStatement=getPreparedStatement(sql);
        preparedStatement.setLong(1,id);
        resultSet=preparedStatement.executeQuery();
        Address address=new Address();
        while (resultSet.next()){
            address.setId(id);
            address.setMyaddress(resultSet.getString(4));
            address.setTaobaoaccount(resultSet.getShort(2));
        }

        return address;
    }

    @Override
    /**
     * @Title: findByCondtion
     * @Description: 根据表查询数据
     * @author huangpai
     * @date 2018-01-19
     */
    public List<Address> findByCondtion(Map<String, Object> stringObjectMap) throws SQLException {
        List<Address> list= new ArrayList<Address>();
        if (stringObjectMap !=null){
            sql="SELECT ID,MY_ADDRESS,TAOBAO_ACCOUNT_ID FROM ADDRESS WHERE 1=1";
            Set<Map.Entry<String,Object>>set=stringObjectMap.entrySet();
            Iterator<Map.Entry<String, Object>> iterator = set.iterator();
            while (iterator.hasNext()){
                Map.Entry<String, Object> map = iterator.next();
                sql += " OR "+map.getKey()+" = '"+map.getValue()+"'";
            }
            preparedStatement=getPreparedStatement(sql);
            resultSet=preparedStatement.executeQuery();
            Address address=null;
            while (resultSet.next()){
                address=new Address();
                address.setId(resultSet.getLong(1));
                address.setMyaddress(resultSet.getString(2));
                address.setTaobaoaccount(resultSet.getShort(3));
                list.add(address);
            }
        }

        return list;
    }


    @Override
    public List<Address> findByCondtionForPage(Map<String, Object> stringObjectMap, Integer startRows, Integer size) throws SQLException {
        List<Address> list=new ArrayList<Address>();
        if (stringObjectMap !=null){
            sql="SELECT ID,MY_ADDRESS,TAOBAO_ACCOUNT_ID FROM ADDRESS WHERE 1=1";
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
            address.setMyaddress(resultSet.getString(2));
            address.setTaobaoaccount(resultSet.getShort(3));
            list.add(address);
        }
        return list;
    }

}

package wechat_business.dao;/********************************************************************
     /**
     * @Project: java_wechat_business
     * @Package main.java.dao
     * @author dengchao
     * @date 2018/1/22 18:46
     * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
     * @version V1.0
     */

import org.springframework.stereotype.Repository;
import wechat_business.entity.PeopleInfo;

import java.sql.SQLException;
import java.util.*;

/**
 * @author dengchao
 * @ClassName PeopleInfoDao
 * @Description 人员信息操作Dao
 * @date 2018/1/22
 */
@Repository
public class PeopleInfoDao extends Dao<PeopleInfo> {
    //定义sql语句
    public String sqlStr=null;
    //定义受影响行数
    public Integer rows=null;

    /**
     * @Title: deletePeopleById
     * @Description: 删除指定id的人员信息
     * @author dengchao
     * @date 2018/1/21
     * @param: id 指定id
     * @throws java.sql.SQLException
     * @return: 受影响行数
     */
    @Override
    public Integer deleteById(Long id) throws SQLException {
        return super.sqlSessionTemplate.delete(getMybaitsNameSpace()+"deleteById",id);
//        //定义sql删除语句
//        sqlStr="DELETE FROM people_info WHERE ID=?";
//        //获取预编译对象
//        preparedStatement=getPreparedStatement(sqlStr);
//        //设值参考符的值
//        preparedStatement.setLong(1,id);
//        //执行sql语句
//        rows=preparedStatement.executeUpdate();
//        //提交
//        commit();
//        //返回受影响行数
//        return rows;
    }

    /**
     * @Title: deleteByIds
     * @Description: 根据多个id删除人员信息
     * @author dengchao
     * @date 2018/1/22
     * @param ids 要删除的多个人员id
     * @throws java.sql.SQLException
     * @return 返回受影响行数
     */
    @Override
    public Integer deleteByIds(Long[] ids) throws SQLException {
        return super.sqlSessionTemplate.delete(getMybaitsNameSpace()+"deleteByIds",ids);
//        if (ids.length > 0){
//            //定义sql删除语句
//            sqlStr="DELETE FROM people_info WHERE 1=1";
//            for (int i = 0; i < ids.length; i++) {
//                //设值id的值
//                sqlStr+=" OR ID="+ids[i];
//            }
//            //获取预编译对象
//            preparedStatement=getPreparedStatement(sqlStr);
//            //执行sql语句
//            rows=preparedStatement.executeUpdate();
//            //提交
//            commit();
//        }
//        //返回受影响行数
//        return rows;
    }

    /**
     * @Title: saveOrUpdate
     * @Description: 保存或修改信息
     * @author dengchao
     * @date 2018/1/22
     * @param people 人员对象
     * @throws java.sql.SQLException
     * @return 返回受影响行数
     */
    @Override
    public Integer saveOrUpdate(PeopleInfo people) throws SQLException {
        //判断人员id是否为null，若是则修改,否则保存
        if (people.getId() != null){
            return super.sqlSessionTemplate.update(getMybaitsNameSpace()+"update",people);
//            //定义sql语句
//            sqlStr="UPDATE people_info  "+
//                    "SET"+
//                    " NAME=?,"+
//                    " SEX=?,"+
//                    " AGE=?,"+
//                    " NATION=?,"+
//                    " BIRTHDATE=?,"+
//                    " ID_NUMBER=?,"+
//                    "MOBILE_PHONE"+
//                    "NATIVE_PLACE"+
//                    "MAILBOX"+
//                    "PERMANENT_ADDRESS"+
//                    "PROFESSION"+
//                    "WORK_UNIT"+
//                    " CREATE_TIME=?,"+
//                    " UPDATE_TIME=?"+
//                    " WHERE ID=?";
//            //获取预编译对象
//            preparedStatement=getPreparedStatement(sqlStr);
//            //设值参考符的值
//            preparedStatement.setString(1,people.getName());
//            preparedStatement.setByte(2, people.getSex());
//            preparedStatement.setInt(3, people.getAge());
//            preparedStatement.setString(4, people.getNation());
//            preparedStatement.setDate(5, (Date) people.getBirthdate());
//            preparedStatement.setString(6,people.getIdNumber());
//            preparedStatement.setString(7,people.getMobilePhone());
//            preparedStatement.setString(8,people.getNativePlace());
//            preparedStatement.setString(9,people.getMailBox());
//            preparedStatement.setString(10,people.getPermanentAdress());
//            preparedStatement.setString(11,people.getProfession());
//            preparedStatement.setString(12,people.getWorkUnit());
//            preparedStatement.setDate(13, (Date) people.getCreateTime());
//            preparedStatement.setDate(14, (Date) people.getUpdateTime());
//            preparedStatement.setLong(15,people.getId());
//            //执行sql语句
//            rows=preparedStatement.executeUpdate();
//            //提交
//            commit();
        }else {
            return super.sqlSessionTemplate.insert(getMybaitsNameSpace()+"save",people);
//            //定义sql语句
//            sqlStr="INSERT INTO people_info (ID,`NAME`,SEX,AGE,NATION,BIRTHDATE,ID_NUMBER,MOBILE_PHONE,NATIVE_PLACE,MAILBOX,PERMANENT_ADDRESS,PROFESSION,WORK_UNIT,CREATE_TIME,UPDATE_TIME)" +
//                    " VALUES(DEFAULT,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
//            //获取预编译对象
//            preparedStatement=getPreparedStatement(sqlStr);
//            //设值参考符的值
//            preparedStatement.setString(1,people.getName());
//            preparedStatement.setByte(2, people.getSex());
//            preparedStatement.setInt(3, people.getAge());
//            preparedStatement.setString(4, people.getNation());
//            preparedStatement.setDate(5, (Date) people.getBirthdate());
//            preparedStatement.setString(6, people.getIdNumber());
//            preparedStatement.setString(7,people.getMobilePhone());
//            preparedStatement.setString(8, people.getNativePlace());
//            preparedStatement.setString(9,people.getMailBox());
//            preparedStatement.setString(10,people.getPermanentAdress());
//            preparedStatement.setString(11,people.getProfession());
//            preparedStatement.setString(12,people.getWorkUnit());
//            preparedStatement.setDate(13, (Date) people.getCreateTime());
//            preparedStatement.setDate(14, (Date) people.getUpdateTime());
//            //执行sql语句
//            rows=preparedStatement.executeUpdate();
//            //提交
//            commit();
        }
//        return rows;
    }

    /**
     * @Title: findById
     * @Description: 通过指定id查找人员
     * @author dengchao
     * @date 2018/1/22
     * @throws: SQLException
     * @param: id 要查询的指定人员id
     * @throws java.sql.SQLException
     * @return: 人员对象
     */
    @Override
    public PeopleInfo findById(Long id) throws SQLException {

        return super.sqlSessionTemplate.selectOne(getMybaitsNameSpace()+"findById",id);
//        //定义sql语句
//        sqlStr="SELECT ID,NAME,SEX,AGE,MOBILE_PHONE FROM people_info WHERE ID=?";
//        //获取查询数据库的Statement对象
//        preparedStatement=getPreparedStatement(sqlStr);
//        //设置id的值
//        preparedStatement.setLong(1,id);
//        //执行sql语句，并获得结果集
//        resultSet=preparedStatement.executeQuery();
//        //提交
//        commit();
//        //定义人员对象
//        PeopleInfo peopleInfo=new PeopleInfo();
//        //获取人员信息
//        while (resultSet.next()){
//            peopleInfo.setId(resultSet.getLong(1));
//            peopleInfo.setName(resultSet.getString(2));
//            peopleInfo.setSex(resultSet.getByte(3));
//            peopleInfo.setAge(resultSet.getInt(4));
//            peopleInfo.setMobilePhone(resultSet.getString(5));
//        }
//        return peopleInfo;
    }

    /**
     * @Title: findByCondtion
     * @Description: 根据条件查询
     * @author dengchao
     * @date 2018/1/22
     * @param stringObjectMap map对象，查询条件
     * @throws java.sql.SQLException
     * @return 返回查询人员对象集合
     */
    @Override
    public List<PeopleInfo> findByCondtion(Map<String, Object> stringObjectMap) throws SQLException {
        return super.sqlSessionTemplate.selectList(getMybaitsNameSpace()+"findByCondtion",stringObjectMap);
//        //定义人员集合
//        List<PeopleInfo> list=new ArrayList<PeopleInfo>();
//        //判断人员map对象是否为null
//        if (stringObjectMap != null){
//            //定义sql语句
//            sqlStr="SELECT ID,NAME,SEX,AGE,MOBILE_PHONE,ID_NUMBER,CREATE_TIME FROM people_info WHERE 1=1";
//            //定义Map.Entry对象
//            Set<Map.Entry<String, Object>> set=stringObjectMap.entrySet();
//            //迭代
//            Iterator<Map.Entry<String, Object>> iterator=set.iterator();
//            //获取判断条件
//            while (iterator.hasNext()){
//                Map.Entry<String, Object> mapEntry=iterator.next();
//                sqlStr+=" OR "+mapEntry.getKey()+" = '"+mapEntry.getValue()+" '";
//            }
//            //获取预编译对象
//            preparedStatement=getPreparedStatement(sqlStr);
//            //执行sql语句，并放进结果集
//            resultSet=preparedStatement.executeQuery();
//            //提交
//            commit();
//            //定义人员信息对象
//            PeopleInfo peopleInfo=null;
//            //存值
//            while (resultSet.next()){
//                peopleInfo=new PeopleInfo();
//                peopleInfo.setId(resultSet.getLong(1));
//                peopleInfo.setName(resultSet.getString(2));
//                peopleInfo.setSex(resultSet.getByte(3));
//                peopleInfo.setAge(resultSet.getInt(4));
//                peopleInfo.setMobilePhone(resultSet.getString(5));
//                peopleInfo.setIdNumber(resultSet.getString(6));
//                peopleInfo.setCreateTime(resultSet.getDate(7));
//                list.add(peopleInfo);
//            }
//        }
//        return list;
    }

    /**
     * @Title: findByCondtionForPage
     * @Description: 根据条件分页查询
     * @author dengchao
     * @date 2018/1/22
     * @param stringObjectMap 查询条件
     * @param startRows 开始页数
     * @param size 分页页数
     * @throws java.sql.SQLException
     * @return 返回查询到的人员集合
     */
    @Override
    public List<PeopleInfo> findByCondtionForPage(Map<String, Object> stringObjectMap, Integer startRows, Integer size) throws SQLException {
        return super.sqlSessionTemplate.selectList(getMybaitsNameSpace()+"findByCondtionForPage",stringObjectMap);
//        //定义人员集合
//        List<PeopleInfo> list=new ArrayList<PeopleInfo>();
//        //判断人员map对象是否为null
//        if (stringObjectMap != null) {
//            //定义sql语句
//            sqlStr = "SELECT ID,NAME,SEX,AGE,MOBILE_PHONE,ID_NUMBER,CREATE_TIME FROM people_info WHERE 1=1 ";
//            //定义Map.Entry对象
//            Set<Map.Entry<String, Object>> set=stringObjectMap.entrySet();
//            //迭代
//            Iterator<Map.Entry<String, Object>> iterator=set.iterator();
//            //获取判断条件
//            while (iterator.hasNext()){
//                Map.Entry<String, Object> mapEntry=iterator.next();
//                sqlStr+=" OR "+mapEntry.getKey()+" = '"+mapEntry.getValue()+"'";
//            }
//            sqlStr += " LIMIT "+startRows+" , "+size;
//            //获取预编译
//            preparedStatement=getPreparedStatement(sqlStr);
//            //执行sql语句
//            resultSet=preparedStatement.executeQuery();
//            //提交
//            commit();
//            //定义人员信息对象
//            PeopleInfo peopleInfo=null;
//            while (resultSet.next()){
//                peopleInfo=new PeopleInfo();
//                peopleInfo.setId(resultSet.getLong(1));
//                peopleInfo.setName(resultSet.getString(2));
//                peopleInfo.setSex(resultSet.getByte(3));
//                peopleInfo.setAge(resultSet.getInt(4));
//                peopleInfo.setMobilePhone(resultSet.getString(5));
//                peopleInfo.setIdNumber(resultSet.getString(6));
//                peopleInfo.setCreateTime(resultSet.getDate(7));
//                list.add(peopleInfo);
//            }
//        }
//        return list;
    }
}

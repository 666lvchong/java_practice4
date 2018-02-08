package wechat_business.dao;/********************************************************************
 /**
 * @Project: Team4
 * @Package wechat_business.dao
 * @author dengchao
 * @date 2018/1/31 11:55
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import wechat_business.entity.Grade;

import java.sql.SQLException;
import java.util.*;

/**
 * @author dengchao
 * @ClassName AdministratorDao
 * @Description 管理者dao类
 * @date 2018/1/29
 */
public class GradeDao extends Dao<Grade> {
    //定义sql语句
    public String sqlStr=null;
    //定义受影响行数
    public Integer rows=null;

    /**
     * @Title: deleteById
     * @Description: 根据指定id删除
     * @author dengchao
     * @date 2018/1/29
     * @param id 指定id
     * @return 返回受影响行数
     */
    @Override
    public Integer deleteById(Long id) throws SQLException {
        //定义sql删除语句
        sqlStr="DELETE FROM GRADE WHERE ID=?";
        //获取预编译对象
        preparedStatement=getPreparedStatement(sqlStr);
        //设值参考符的值
        preparedStatement.setLong(1,id);
        //执行sql语句
        rows=preparedStatement.executeUpdate();
        //提交
        commit();
        //返回受影响行数
        return rows;
    }

    /**
     * @Title: deleteByIds
     * @Description: 根据多个id删除
     * @author dengchao
     * @date 2018/1/22
     * @param ids 要删除的等级权限id
     * @throws java.sql.SQLException
     * @return 返回受影响行数
     */
    @Override
    public Integer deleteByIds(Long[] ids) throws SQLException {
        if (ids.length > 0){
            //定义sql删除语句
            sqlStr="DELETE FROM GRADE WHERE 1=1";
            for (int i = 0; i < ids.length; i++) {
                //设值id的值
                sqlStr+=" OR ID="+ids[i];
            }
            //获取预编译对象
            preparedStatement=getPreparedStatement(sqlStr);
            //执行sql语句
            rows=preparedStatement.executeUpdate();
            //提交
            commit();
        }
        //返回受影响行数
        return rows;
    }

    /**
     * @Title: saveOrUpdate
     * @Description: 保存或修改信息
     * @author dengchao
     * @date 2018/1/22
     * @param grade 等级权限对象
     * @throws java.sql.SQLException
     * @return 返回受影响行数
     */
    @Override
    public Integer saveOrUpdate(Grade grade) throws SQLException {
        //判断人员id是否为null，若是则修改,否则保存
        if (grade.getId() != null){
            //定义sql语句
            sqlStr="UPDATE GRADE  "+
                    "SET"+
                    " GRADE_NUMBER=?,"+
                    " GRADE_NAME=?,"+
                    " WHERE ID=?";
            //获取预编译对象
            preparedStatement=getPreparedStatement(sqlStr);
            //设值参考符的值
            preparedStatement.setByte(1,grade.getGradeNumber());
            preparedStatement.setString(2,grade.getGradeName());
            preparedStatement.setLong(3,grade.getId());
            //执行sql语句
            rows=preparedStatement.executeUpdate();
            //提交
            commit();
        }else {
            //定义sql语句
            sqlStr="INSERT INTO GRADE (ID,GRADE_NUMBER,GRADE_NAME)" +
                    " VALUES(DEFAULT,?,?)";
            //获取预编译对象
            preparedStatement=getPreparedStatement(sqlStr);
            //设值参考符的值
            preparedStatement.setByte(1,grade.getGradeNumber());
            preparedStatement.setString(2,grade.getGradeName());
            //执行sql语句
            rows=preparedStatement.executeUpdate();
            //提交
            commit();
        }
        return rows;
    }


    /**
     * @Title: findById
     * @Description: 通过指定id查找等级权限
     * @author dengchao
     * @date 2018/1/22
     * @throws: SQLException
     * @param: id 要查询的指定等级权限id
     * @throws java.sql.SQLException
     * @return: 等级权限对象
     */
    @Override
    public Grade findById(Long id) throws SQLException {
        //定义sql语句
        sqlStr="SELECT ID,GRADE_NUMBER,GRADE_NAME FROM GRADE WHERE ID=?";
        //获取查询数据库的Statement对象
        preparedStatement=getPreparedStatement(sqlStr);
        //设置id的值
        preparedStatement.setLong(1,id);
        //执行sql语句，并获得结果集
        resultSet=preparedStatement.executeQuery();
        //提交
        commit();
        //定义人员对象
        Grade grade=new Grade();
        //获取人员信息
        while (resultSet.next()){
            grade.setId(id);
            grade.setGradeNumber(resultSet.getByte(1));
            grade.setGradeName(resultSet.getString(2));
        }
        return grade;
    }

    /**
     * @Title: findByCondtion
     * @Description: 根据条件查询
     * @author dengchao
     * @date 2018/1/22
     * @param stringObjectMap map对象，查询条件
     * @throws java.sql.SQLException
     * @return 返回查询等级对象集合
     */
    @Override
    public List<Grade> findByCondtion(Map<String, Object> stringObjectMap) throws SQLException {
        //定义人员集合
        List<Grade> list=new ArrayList<Grade>();
        //判断人员map对象是否为null
        if (stringObjectMap != null){
            //定义sql语句
            sqlStr="SELECT ID,GRADE_NUMBER,GRADE_NAME FROM GRADE WHERE 1=1";
            //定义Map.Entry对象
            Set<Map.Entry<String, Object>> set=stringObjectMap.entrySet();
            //迭代
            Iterator<Map.Entry<String, Object>> iterator=set.iterator();
            //获取判断条件
            while (iterator.hasNext()){
                Map.Entry<String, Object> mapEntry=iterator.next();
                sqlStr+=" OR "+mapEntry.getKey()+" = '"+mapEntry.getValue()+" '";
            }
            //获取预编译对象
            preparedStatement=getPreparedStatement(sqlStr);
            //执行sql语句，并放进结果集
            resultSet=preparedStatement.executeQuery();
            //提交
            commit();
            //定义人员信息对象
            Grade grade=null;
            //存值
            while (resultSet.next()){
                grade=new Grade();
                grade.setId(resultSet.getLong(1));
                grade.setGradeNumber(resultSet.getByte(2));
                grade.setGradeName(resultSet.getString(3));
                list.add(grade);
            }
        }
        return list;
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
     * @return 返回查询到的等级集合
     */
    @Override
    public List<Grade> findByCondtionForPage(Map<String, Object> stringObjectMap, Integer startRows, Integer size) throws SQLException {
        //定义人员集合
        List<Grade> list=new ArrayList<Grade>();
        //判断人员map对象是否为null
        if (stringObjectMap != null) {
            //定义sql语句
            sqlStr="SELECT ID,GRADE_NUMBER,GRADE_NAME FROM GRADE WHERE 1=1";
            //定义Map.Entry对象
            Set<Map.Entry<String, Object>> set=stringObjectMap.entrySet();
            //迭代
            Iterator<Map.Entry<String, Object>> iterator=set.iterator();
            //获取判断条件
            while (iterator.hasNext()){
                Map.Entry<String, Object> mapEntry=iterator.next();
                sqlStr+=" AND "+mapEntry.getKey()+"='"+mapEntry.getValue()+"'";
            }
            sqlStr += " LIMIT "+startRows+","+size;
            //获取预编译
            preparedStatement=getPreparedStatement(sqlStr);
            //执行sql语句
            resultSet=preparedStatement.executeQuery();
            //提交
            commit();
            //定义等级对象
            Grade grade=null;
            while (resultSet.next()){
                grade=new Grade();
                grade.setId(resultSet.getLong(1));
                grade.setGradeNumber(resultSet.getByte(2));
                grade.setGradeName(resultSet.getString(3));
                list.add(grade);
            }
        }
        return list;
    }
}
package wechat_business.dao;/********************************************************************
 /**
 * @Project: Team4
 * @Package wechat_business.dao
 * @author dengchao
 * @date 2018/2/12 0:03
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import org.springframework.stereotype.Repository;
import wechat_business.entity.ActivityInfo;

import java.sql.SQLException;
import java.util.*;

/**
 * @author dengchao
 * @ClassName ActivityInfoDao
 * @Description 活动信息dao
 * @date 2018/2/12
 */
@Repository
public class ActivityInfoDao extends Dao<ActivityInfo>{
    //定义sql语句
    public String sqlStr;
    //定义受影响行数
    public Integer rows;

    /**
     * @Title: deleteById
     * @Description: 根据id删除
     * @author dengchao
     * @date 2018/2/12
     * @param id 要删除的id
     */
    @Override
    public Integer deleteById(Long id) throws SQLException {
        return super.sqlSessionTemplate.delete(getMybaitsNameSpace()+"deleteById",id);
//       //获取sql删除语句
//        sqlStr="DELETE FROM ACTIVITY_INFO WHERE ID=?";
//        //获取预编译对象
//        preparedStatement=getPreparedStatement(sqlStr);
//        //设置参考符的值
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
     * @Description: 根据id删除多个
     * @author dengchao
     * @date 2018/2/12
     * @param ids 要删除的id数组
     */
    @Override
    public Integer deleteByIds(Long[] ids) throws SQLException {
        return super.sqlSessionTemplate.delete(getMybaitsNameSpace()+"deleteByIds",ids);
//        if (ids.length > 0){
//            sqlStr="DELETE FROM ACTIVITY_INFO WHERE 1=1";
//            for (int i = 0; i < ids.length; i++) {
//                //设置id的值
//                sqlStr+=" AND ID="+ids[i];
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
     * @Description: 保存或修改
     * @author dengchao
     * @date 2018/2/12
     * @param activityInfo 活动信息对象
     * @return 返回受影响行数
     */

    @Override
    public Integer saveOrUpdate(ActivityInfo activityInfo) throws SQLException {
        //判断id是否为null,是则保存，否则修改
        if (activityInfo.getId() != null){
            return super.sqlSessionTemplate.update(getMybaitsNameSpace()+"update",activityInfo);
//            //定义sql语句
//            sqlStr="UPDATE ACTIVITY_INFO "+
//                    "SET"+
//                    " DISCOUNT=?,"+
//                    " ACTIVITY_NAME=?,"+
//                    " ACTIVITY_START_TIME=?,"+
//                    " ACTIVITY_END_TIME=?"+
//                    " WHERE ID=?";
//            //获取预编译对象
//            preparedStatement=getPreparedStatement(sqlStr);
//            //设置参考符的值
//            preparedStatement.setDouble(1,activityInfo.getDiscount());
//            preparedStatement.setString(2,activityInfo.getActivityName());
//            preparedStatement.setDate(3, (Date) activityInfo.getActivityStartTime());
//            preparedStatement.setDate(4, (Date) activityInfo.getActivityEndTime());
//            preparedStatement.setLong(5,activityInfo.getId());
//            //执行修改
//            rows=preparedStatement.executeUpdate();
//            //提交
//            commit();
        }else {
            return super.sqlSessionTemplate.insert(getMybaitsNameSpace()+"save",activityInfo);
//            //定义sql语句
//            sqlStr="INSERT INTO ACTIVITY_INFO (ID,DISCOUNT,ACTIVITY_NAME,ACTIVITY_START_TIME,ACTIVITY_END_TIME)" +
//                    " VALUES(DEFAULT,?,?,?,?)";
//            //获取预编译对象
//            preparedStatement=getPreparedStatement(sqlStr);
//            //设置参考符的值
//            preparedStatement.setDouble(1,activityInfo.getDiscount());
//            preparedStatement.setString(2,activityInfo.getActivityName());
//            preparedStatement.setDate(3, (Date) activityInfo.getActivityStartTime());
//            preparedStatement.setDate(4, (Date) activityInfo.getActivityEndTime());
//            //执行保存
//            rows=preparedStatement.executeUpdate();
//            //提交
//            commit();
        }
//        return rows;
    }

    /**
     * @Title: findById
     * @Description: 根据id查询
     * @author dengchao
     * @date 2018/2/12
     * @param id 查询id
     * @return 返回查询对象
     */
    @Override
    public ActivityInfo findById(Long id) throws SQLException {
        return super.sqlSessionTemplate.selectOne(getMybaitsNameSpace()+"findById",id);
//        //定义sql语句
//        sqlStr="SELECT ID,DISCOUNT,ACTIVITY_NAME,ACTIVITY_START_TIME,ACTIVITY_END_TIME FROM ACTIVITY_INFO WHERE ID=?";
//        //获取预编译对象
//        preparedStatement=getPreparedStatement(sqlStr);
//        //设置id的值
//        preparedStatement.setLong(1,id);
//        //执行查询
//        resultSet=preparedStatement.executeQuery();
//        //提交
//        commit();
//        //定义活动信息对象
//        ActivityInfo activityInfo=null;
//        //获取对象
//        while (resultSet.next()){
//            activityInfo=new ActivityInfo();
//            activityInfo.setId(resultSet.getLong(1));
//            activityInfo.setDiscount(resultSet.getDouble(2));
//            activityInfo.setActivityName(resultSet.getString(3));
//            activityInfo.setActivityStartTime(resultSet.getDate(4));
//            activityInfo.setActivityEndTime(resultSet.getDate(5));
//        }
//        return activityInfo;
    }

    /**
     * @Title: findByCondtion
     * @Description: 按条件查询
     * @author dengchao
     * @date 2018/2/12
     * @param stringObjectMap 查询条件
     * @return 返回查询结果集合
     */
    @Override
    public List<ActivityInfo> findByCondtion(Map<String, Object> stringObjectMap) throws SQLException {
        return super.sqlSessionTemplate.selectList(getMybaitsNameSpace()+"findByCondtion",stringObjectMap);
//        //定义活动信息集合
//        List<ActivityInfo> list=new ArrayList<ActivityInfo>();
//        //定义sql语句
//        sqlStr="SELECT ID,DISCOUNT,ACTIVITY_NAME,ACTIVITY_START_TIME,ACTIVITY_END_TIME FROM ACTIVITY_INFO WHERE 1=1";
//       //定义map.Entry对象
//        Set<Map.Entry<String,Object>> set=stringObjectMap.entrySet();
//        //迭代
//        Iterator<Map.Entry<String,Object>> iterator=set.iterator();
//        if (stringObjectMap != null) {
//            //获取判断条件
//            while (iterator.hasNext()) {
//                Map.Entry<String, Object> mapEntry = iterator.next();
//                sqlStr += " AND " + mapEntry.getKey() + " ='" + mapEntry.getValue() + "'";
//            }
//            //获取预编译对象
//            preparedStatement = getPreparedStatement(sqlStr);
//            //执行查询
//            resultSet = preparedStatement.executeQuery();
//            //提交
//            commit();
//            //定义活动信息对象
//            ActivityInfo activityInfo = null;
//            //将查询出来的结果存入对象
//            while (resultSet.next()) {
//                activityInfo=new ActivityInfo();
//                activityInfo.setId(resultSet.getLong(1));
//                activityInfo.setDiscount(resultSet.getDouble(2));
//                activityInfo.setActivityName(resultSet.getString(3));
//                activityInfo.setActivityStartTime(resultSet.getDate(4));
//                activityInfo.setActivityEndTime(resultSet.getDate(5));
//                list.add(activityInfo);
//            }
//        }
//        return list;
    }

    /**
     * @Title: findByCondtionForPage
     * @Description: 按条件分页查询
     * @author dengchao
     * @date 2018/2/12
     * @param stringObjectMap 查询条件
     * @param startRows 分页开始页数
     * @param size 分页页数
     * @return 返回查询结果集
     */
    @Override
    public List<ActivityInfo> findByCondtionForPage(Map<String, Object> stringObjectMap, Integer startRows, Integer size) throws SQLException {
        return super.sqlSessionTemplate.selectList(getMybaitsNameSpace()+"findByCondtionForPage",stringObjectMap);
//        //定义活动信息集合
//        List<ActivityInfo> list=new ArrayList<ActivityInfo>();
//        //定义sql语句
//        sqlStr="SELECT ID,DISCOUNT,ACTIVITY_NAME,ACTIVITY_START_TIME,ACTIVITY_END_TIME FROM ACTIVITY_INFO WHERE 1=1";
//        //定义map.Entry对象
//        Set<Map.Entry<String,Object>> set=stringObjectMap.entrySet();
//        //迭代
//        Iterator<Map.Entry<String,Object>> iterator=set.iterator();
//        if (stringObjectMap != null) {
//            //获取判断条件
//            while (iterator.hasNext()) {
//                Map.Entry<String, Object> mapEntry = iterator.next();
//                sqlStr += " AND " + mapEntry.getKey() + " ='" + mapEntry.getValue() + "'";
//            }
//            sqlStr+=" LIMIT "+startRows+","+size;
//            //获取预编译对象
//            preparedStatement = getPreparedStatement(sqlStr);
//            //执行查询
//            resultSet = preparedStatement.executeQuery();
//            //提交
//            commit();
//            //定义活动信息对象
//            ActivityInfo activityInfo = null;
//            //将查询出来的结果存入对象
//            while (resultSet.next()) {
//                activityInfo=new ActivityInfo();
//                activityInfo.setId(resultSet.getLong(1));
//                activityInfo.setDiscount(resultSet.getDouble(2));
//                activityInfo.setActivityName(resultSet.getString(3));
//                activityInfo.setActivityStartTime(resultSet.getDate(4));
//                activityInfo.setActivityEndTime(resultSet.getDate(5));
//                list.add(activityInfo);
//            }
//        }
//        return list;
    }
}
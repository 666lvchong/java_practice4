package wechat_business.dao;/********************************************************************
 /**
 * @Project: Team4
 * @Package wechat_business.dao
 * @author dengchao
 * @date 2018/2/12 22:14
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import org.springframework.stereotype.Repository;
import wechat_business.entity.ActivityRelation;

/**
 * @author dengchao
 * @ClassName ActivityRelationDao
 * @Description 活动关系表dao
 * @date 2018/2/12
 */
@Repository
public class ActivityRelationDao extends Dao<ActivityRelation> {
    /*//定义sql语句
    public String sqlStr;
    //定义受影响行数
    public Integer rows;
    *//**
     * @Title: deleteById
     * @Description: 根据id删除
     * @author dengchao
     * @date 2018/2/12
     * @param id 删除id
     * @return 返回受影响行数
     *//*
    @Override
    public Integer deleteById(Long id) throws SQLException {
        //获取sql删除语句
        sqlStr="DELETE FROM ACTIVITY_RELATION WHERE ID=?";
        //获取预编译对象
        preparedStatement=getPreparedStatement(sqlStr);
        //设置参考符的值
        preparedStatement.setLong(1,id);
        //执行sql语句
        rows=preparedStatement.executeUpdate();
        //提交
        commit();
        //返回受影响行数
        return rows;
    }

    *//**
     * @Title: deleteByIds
     * @Description: 根据id删除多个
     * @author dengchao
     * @date 2018/2/12
     * @param ids 删除id数组
     * @return 返回受影响行数
     *//*
    @Override
    public Integer deleteByIds(Long[] ids) throws SQLException {
        if (ids.length > 0){
            sqlStr="DELETE FROM ACTIVITY_RELATION WHERE 1=1";
            for (int i = 0; i < ids.length; i++) {
                //设置id的值
                sqlStr+=" AND ID="+ids[i];
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

    *//**
     * @Title: saveOrUpdate
     * @Description: 保存或修改
     * @author dengchao
     * @date 2018/2/12
     * @param activityRelation 活动关系对象
     * @return 返回受影响行数
     *//*
    @Override
    public Integer saveOrUpdate(ActivityRelation activityRelation) throws SQLException {
        //判断id是否为null,是则保存，否则修改
        if (activityRelation.getId() != null){
            //定义sql语句
            sqlStr="UPDATE ACTIVITY_RELATION "+
                    "SET"+
                    " ITEM_RELATION_ID=?,"+
                    " ACTIVITY_INFO_ID=?"+
                    " WHERE ID=?";
            //获取预编译对象
            preparedStatement=getPreparedStatement(sqlStr);
            //设置参考符的值
            preparedStatement.setLong(1,activityRelation.getItemRelationId().getId());
            preparedStatement.setLong(2,activityRelation.getActivityInfoId().getId());
            preparedStatement.setLong(3,activityRelation.getId());
            //执行修改
            rows=preparedStatement.executeUpdate();
            //提交
            commit();
        }else {
            //定义sql语句
            sqlStr="INSERT INTO ACTIVITY_RELATION (ID,ITEM_RELATION_ID,ACTIVITY_INFO_ID)" +
                    " VALUES(DEFAULT,?,?)";
            //获取预编译对象
            preparedStatement=getPreparedStatement(sqlStr);
            //设置参考符的值
            preparedStatement.setLong(1,activityRelation.getItemRelationId().getId());
            preparedStatement.setLong(2,activityRelation.getActivityInfoId().getId());
            //执行保存
            rows=preparedStatement.executeUpdate();
            //提交
            commit();
        }
        return rows;
    }

    *//**
     * @Title: findById
     * @Description: 根据id查询
     * @author dengchao
     * @date 2018/2/12
     * @param id 查询id
     * @return 返回查询对象
     *//*
    @Override
    public ActivityRelation findById(Long id) throws SQLException {
        ItemRelationService itemRelationService=new ItemRelationServiceImpl();
        ActivityInfoService activityInfoService=new ActivityInfoServiceImpl();
        //定义sql语句
        sqlStr="SELECT ID,ITEM_RELATION_ID,ACTIVITY_INFO_ID FROM ACTIVITY_RELATION WHERE ID=?";
        //获取预编译对象
        preparedStatement=getPreparedStatement(sqlStr);
        //设置id的值
        preparedStatement.setLong(1,id);
        //执行查询
        resultSet=preparedStatement.executeQuery();
        //提交
        commit();
        //定义活动信息对象
        ActivityRelation activityRelation=null;
        //获取对象
        while (resultSet.next()){
            activityRelation=new ActivityRelation();
            activityRelation.setId(resultSet.getLong(1));
            activityRelation.setItemRelationId(itemRelationService.findById(resultSet.getLong(2)));
            activityRelation.setActivityInfoId(activityInfoService.findById(resultSet.getLong(3)));
        }
        return activityRelation;
    }

    *//**
     * @Title: findByCondtion
     * @Description: 按条件查询
     * @author dengchao
     * @date 2018/2/12
     * @param stringObjectMap 查询条件
     * @return 返回查询结果集合
     *//*
    @Override
    public List<ActivityRelation> findByCondtion(Map<String, Object> stringObjectMap) throws SQLException {
        //定义活动信息集合
        List<ActivityRelation> list=new ArrayList<ActivityRelation>();
        if (stringObjectMap != null) {
            //定义sql语句
            sqlStr = "SELECT ID,ITEM_RELATION_ID,ACTIVITY_INFO_ID FROM ACTIVITY_RELATION WHERE 1=1";
            //定义map.Entry对象
            Set<Map.Entry<String, Object>> set = stringObjectMap.entrySet();
            //迭代
            Iterator<Map.Entry<String, Object>> iterator = set.iterator();
            if (stringObjectMap != null) {
                //获取判断条件
                while (iterator.hasNext()) {
                    Map.Entry<String, Object> mapEntry = iterator.next();
                    sqlStr += " AND " + mapEntry.getKey() + " ='" + mapEntry.getValue() + "'";
                }
            }
                //获取预编译对象
                preparedStatement = getPreparedStatement(sqlStr);
                //执行查询
                resultSet = preparedStatement.executeQuery();
                //提交
                commit();
                ItemRelationServiceImpl itemRelationService = new ItemRelationServiceImpl();
                ActivityInfoServiceImpl activityInfoService = new ActivityInfoServiceImpl();
                //定义活动信息对象
                ActivityRelation activityRelation = null;
                //将查询出来的结果存入对象
                while (resultSet.next()) {
                    activityRelation = new ActivityRelation();
                    activityRelation.setId(resultSet.getLong(1));
                    activityRelation.setItemRelationId(itemRelationService.findById(resultSet.getLong(2)));
                    activityRelation.setActivityInfoId(activityInfoService.findById(resultSet.getLong(3)));
                    list.add(activityRelation);
                }
        }
        return list;
    }

    *//**
     * @Title: findByCondtionForPage
     * @Description: 按条件分页查询
     * @author dengchao
     * @date 2018/2/12
     * @param stringObjectMap 查询条件
     * @param startRows 分页开始页数
     * @param size 分页页数
     * @return 返回查询结果集
     *//*
    @Override
    public List<ActivityRelation> findByCondtionForPage(Map<String, Object> stringObjectMap, Integer startRows, Integer size) throws SQLException {
        //定义活动信息集合
        List<ActivityRelation> list=new ArrayList<ActivityRelation>();
        //定义sql语句
        sqlStr="SELECT ID,ITEM_RELATION_ID,ACTIVITY_INFO_ID FROM ACTIVITY_RELATION WHERE 1=1";
        //定义map.Entry对象
        Set<Map.Entry<String,Object>> set=stringObjectMap.entrySet();
        //迭代
        Iterator<Map.Entry<String,Object>> iterator=set.iterator();
        if (stringObjectMap != null) {
            //获取判断条件
            while (iterator.hasNext()) {
                Map.Entry<String, Object> mapEntry = iterator.next();
                sqlStr += " AND " + mapEntry.getKey() + " = '" + mapEntry.getValue() + "'";
            }
            sqlStr+=" LIMIT "+startRows+","+size;
            //获取预编译对象
            preparedStatement = getPreparedStatement(sqlStr);
            //执行查询
            resultSet = preparedStatement.executeQuery();
            //提交
            commit();
            ItemRelationService itemRelationService=new ItemRelationServiceImpl();
            ActivityInfoService activityInfoService=new ActivityInfoServiceImpl();
            //定义活动信息对象
            ActivityRelation activityRelation = null;
            //将查询出来的结果存入对象
            while (resultSet.next()) {
                activityRelation=new ActivityRelation();
                activityRelation.setId(resultSet.getLong(1));
                activityRelation.setItemRelationId(itemRelationService.findById(resultSet.getLong(2)));
                activityRelation.setActivityInfoId(activityInfoService.findById(resultSet.getLong(3)));
                list.add(activityRelation);
            }
        }
        return list;
    }*/
}
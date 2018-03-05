package wechat_business.service;/********************************************************************
 /**
 * @Project: Team4
 * @Package wechat_business.service
 * @author dengchao
 * @date 2018/2/12 22:31
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import org.springframework.stereotype.Service;
import wechat_business.dao.ActivityInfoDao;
import wechat_business.entity.ActivityInfo;

/**
 * @author dengchao
 * @ClassName ActivityInfoServiceImpl
 * @Description 活动信息表实现类
 * @date 2018/2/12
 */
@Service("activityInfoService")
public class ActivityInfoServiceImpl extends ServiceUtil<ActivityInfoDao,ActivityInfo>{
   /* //定义静态对象
    @Autowired
    public static ActivityInfoDao activityInfoDao;
    //定义受影响行数
    static Integer rows=null;
    *//**
     * @Title: deleteById
     * @Description: 根据id删除
     * @author dengchao
     * @date 2018/2/12
     * @param id 要删除的id
     *//*
    @Override
    public Integer deleteById(Long id) throws SQLException {
        //连接数据库
//        activityInfoDao.getConnection();
        //执行数据库操作
        rows=activityInfoDao.deleteById(id);
        return rows;
    }

    *//**
     * @Title: deleteByIds
     * @Description: 根据id删除多个
     * @author dengchao
     * @date 2018/2/12
     * @param ids 要删除的id数组
     *//*
    @Override
    public Integer deleteByIds(Long[] ids) throws SQLException {
        //连接数据库
//        activityInfoDao.getConnection();
        //执行数据库操作
        rows=activityInfoDao.deleteByIds(ids);
        return rows;
    }

    *//**
     * @Title: saveOrUpdate
     * @Description: 保存或修改
     * @author dengchao
     * @date 2018/2/12
     * @param activityInfo 活动信息对象
     * @return 返回受影响行数
     *//*
    @Override
    public Integer saveOrUpdate(ActivityInfo activityInfo) throws SQLException {
        //连接数据库
//        activityInfoDao.getConnection();
        //执行数据库操作
        if(activityInfo.getId()!=null){
            rows=activityInfoDao.update(activityInfo);
        }else{
            rows=activityInfoDao.save(activityInfo);
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
    public ActivityInfo findById(Long id) throws SQLException {
        //连接数据库
//        activityInfoDao.getConnection();
        //执行数据库操作
        return activityInfoDao.findById(id);
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
    public List<ActivityInfo> findByCondtion(Map<String, Object> stringObjectMap) throws SQLException {
        //连接数据库
//        activityInfoDao.getConnection();
        //执行数据库操作
        return activityInfoDao.findByCondtion(stringObjectMap);
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
    public List<ActivityInfo> findByCondtionForPage(Map<String, Object> stringObjectMap, Integer startRows, Integer size) throws SQLException {
        //连接数据库
//        activityInfoDao.getConnection();
        //执行数据库操作
        return activityInfoDao.findByCondtionForPage(stringObjectMap,startRows,size);
    }*/
}
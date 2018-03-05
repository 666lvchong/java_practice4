package wechat_business.service;/********************************************************************
 /**
 * @Project: Team4
 * @Package wechat_business.service
 * @author dengchao
 * @date 2018/2/12 23:12
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import org.springframework.stereotype.Service;
import wechat_business.dao.ActivityRelationDao;
import wechat_business.entity.ActivityRelation;

/**
 * @author dengchao
 * @ClassName ActivityRelationServiceImpl
 * @Description 类描述
 * @date 2018/2/12
 */
@Service("activityRelationService")
public class ActivityRelationServiceImpl extends ServiceUtil<ActivityRelationDao,ActivityRelation> {
//    //定义静态对象
//    @Autowired
//    public static ActivityRelationDao activityRelationDao;
//    //定义受影响行数
//    static Integer rows=null;
//
//    /**
//     * @Title: deleteById
//     * @Description: 根据id删除
//     * @author dengchao
//     * @date 2018/2/12
//     * @param id 要删除的id
//     */
//    @Override
//    public Integer deleteById(Long id) throws SQLException {
//        //连接数据库
////        activityRelationDao.getConnection();
//        //执行数据库操作
//        rows=activityRelationDao.deleteById(id);
//        return rows;
//    }
//
//    /**
//     * @Title: deleteByIds
//     * @Description: 根据id删除多个
//     * @author dengchao
//     * @date 2018/2/12
//     * @param ids 要删除的id数组
//     */
//    @Override
//    public Integer deleteByIds(Long[] ids) throws SQLException {
//        //连接数据库
////        activityRelationDao.getConnection();
//        //执行数据库操作
//        rows=activityRelationDao.deleteByIds(ids);
//        return rows;
//    }
//
//    /**
//     * @Title: saveOrUpdate
//     * @Description: 保存或修改
//     * @author dengchao
//     * @date 2018/2/12
//     * @param activityRelation 活动信息对象
//     * @return 返回受影响行数
//     */
//    @Override
//    public Integer saveOrUpdate(ActivityRelation activityRelation) throws SQLException {
//        if(activityRelation.getId()!=null){
//            rows=activityRelationDao.update(activityRelation);
//        }else{
//            rows=activityRelationDao.save(activityRelation);
//        }
//        return rows;
//    }
//
//    /**
//     * @Title: findById
//     * @Description: 根据id查询
//     * @author dengchao
//     * @date 2018/2/12
//     * @param id 查询id
//     * @return 返回查询对象
//     */
//    @Override
//    public ActivityRelation findById(Long id) throws SQLException {
//        //连接数据库
////        activityRelationDao.getConnection();
//        //执行数据库操作
//        return activityRelationDao.findById(id);
//    }
//
//    /**
//     * @Title: findByCondtion
//     * @Description: 按条件查询
//     * @author dengchao
//     * @date 2018/2/12
//     * @param stringObjectMap 查询条件
//     * @return 返回查询结果集合
//     */
//    @Override
//    public List<ActivityRelation> findByCondtion(Map<String, Object> stringObjectMap) throws SQLException {
//        //连接数据库
////        activityRelationDao.getConnection();
//        //执行数据库操作
//        return activityRelationDao.findByCondtion(stringObjectMap);
//    }
//
//    /**
//     * @Title: findByCondtionForPage
//     * @Description: 按条件分页查询
//     * @author dengchao
//     * @date 2018/2/12
//     * @param stringObjectMap 查询条件
//     * @param startRows 分页开始页数
//     * @param size 分页页数
//     * @return 返回查询结果集
//     */
//    @Override
//    public List<ActivityRelation> findByCondtionForPage(Map<String, Object> stringObjectMap, Integer startRows, Integer size) throws SQLException {
//        //连接数据库
////        activityRelationDao.getConnection();
//        //执行数据库操作
//        return activityRelationDao.findByCondtionForPage(stringObjectMap,startRows,size);
//    }
}
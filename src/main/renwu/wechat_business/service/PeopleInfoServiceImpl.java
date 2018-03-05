package wechat_business.service;/********************************************************************
 /**
 * @Project: java_wechat_business
 * @Package main.java.service
 * @author dengchao
 * @date 2018/1/21 20:57
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import org.springframework.stereotype.Service;
import wechat_business.dao.PeopleInfoDao;
import wechat_business.entity.PeopleInfo;

/**
 * @author dengchao
 * @ClassName PeopleInfoServiceImpl
 * @Description 类描述
 * @date 2018/1/21
 */
@Service("peopleInfoService")
public class PeopleInfoServiceImpl extends ServiceUtil<PeopleInfoDao,PeopleInfo> {
//    //定义一个静态对象，方便调用方法
//    @Autowired
//   public static PeopleInfoDao peopleInfoDao;
//    //定义受影响行数
//    static Integer rows=null;
//
//    /**
//     * @Title: deletePeopleById
//     * @Description: 删除指定id 的人员信息
//     * @author dengchao
//     * @date 2018-01-21
//     * @param: id 要删除的指定人员的id
//     * @return: rows 受影响行数
//     */
//    @Override
//    public Integer deleteById(Long id) throws SQLException {
//        //连接数据库
////        peopleInfoDao.getConnection();
//        //删除指定id的人员信息
//        rows=peopleInfoDao.deleteById(id);
//        return rows;
//    }
//
//    /**
//     * @Title: deletePeopleByIds
//     * @Description: 根据多个id删除多个人员信息
//     * @author dengchao
//     * @date 2018/1/22
//     * @param ids 要删除的多个人员id
//     * @return rows 返回受影响行数
//     */
//    @Override
//    public Integer deleteByIds(Long[] ids) throws SQLException {
//        //连接数据库
////        peopleInfoDao.getConnection();
//        //根据多个id删除多个人员信息
//        rows=peopleInfoDao.deleteByIds(ids);
//        return rows;
//    }
//
//    /**
//     * @Title: saveOrUpdate
//     * @Description: 添加或者修改
//     * @author dengchao
//     * @date 2018/1/22
//     * @param people 要操作的人员信息
//     * @return rows 返回受影响行数
//     */
//    @Override
//    public Integer saveOrUpdate(PeopleInfo people) throws SQLException {
//    /*    //连接数据库
//        peopleInfoDao.getConnection();
//        //添加或者修改
//        rows=peopleInfoDao.saveOrUpdate(people);*/
//        if(people.getId()!=null){
//            rows=peopleInfoDao.update(people);
//        }else{
//            rows=peopleInfoDao.save(people);
//        }
//        return rows;
//    }
//
//    /**
//     * @Title: findById
//     * @Description: 根据id查询数据
//     * @author dengchao
//     * @date 2018/1/22
//     * @param id 要查询的人员id
//     * @return peopleInfo 返回查询到的人员信息
//     */
//    @Override
//    public PeopleInfo findById(Long id) throws SQLException {
//        //连接数据库
////        peopleInfoDao.getConnection();
////        //定义一个人员对象用来接收查询到的人员信息
////        PeopleInfo peopleInfo=new PeopleInfo();
//        //根据id查询人员信息
//        return peopleInfoDao.findById(id);
//        //输出人员姓名
////        System.out.println("该人员姓名："+peopleInfo.getName());
////        return peopleInfo;
//    }
//
//    /**
//     * @Title: findByCondtion
//     * @Description: 根据条件查询数据
//     * @author dengchao
//     * @date 2018/1/22
//     * @param stringObjectMap 查询条件
//     * @return 返回查询人员对象集合
//     */
//    @Override
//    public List<PeopleInfo> findByCondtion(Map<String, Object> stringObjectMap) throws SQLException {
//        //连接数据库
////        peopleInfoDao.getConnection();
//        return peopleInfoDao.findByCondtion(stringObjectMap);
//    }
//
//    /**
//     * @Title: findByCondtionForPage
//     * @Description: 根据条件分页查询数据
//     * @author dengchao
//     * @date 2018/1/22
//     * @param stringObjectMap 查询条件
//     * @param startRows 分页开始页数
//     * @param size 分页页数
//     * @return 返回查询人员对象集合
//     */
//    @Override
//    public List<PeopleInfo> findByCondtionForPage(Map<String, Object> stringObjectMap, Integer startRows, Integer size) throws SQLException {
//        //连接数据库
////        peopleInfoDao.getConnection();
//        return peopleInfoDao.findByCondtionForPage(stringObjectMap,startRows,size);
//    }
}
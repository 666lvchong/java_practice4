package wechat_business.service;/********************************************************************
 /**
 * @Project: src
 * @Package wechat_business.service
 * @author dengchao
 * @date 2018/1/29 20:46
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import org.springframework.stereotype.Service;
import wechat_business.dao.GradeDao;
import wechat_business.entity.Grade;

/**
 * @author dengchao
 * @ClassName GradeServiceImpl
 * @Description 类描述
 * @date 2018/1/29
 */
@Service("gradeService")
public class GradeServiceImpl extends ServiceUtil<GradeDao,Grade> {
//    //定义一个静态对象，方便调用方法
//    @Autowired
//    public static GradeDao gradeDao;
//    //定义受影响行数
//    static Integer rows=null;
//
//    /**
//     * @Title: deleteById
//     * @Description: 删除指定id 的等级权限
//     * @author dengchao
//     * @date 2018-01-21
//     * @param: id 要删除的指定人员的id
//     * @return: rows 受影响行数
//     */
//    @Override
//    public Integer deleteById(Long id) throws SQLException {
//        //获取连接
////        gradeDao.getConnection();
//        //删除指定id的等级权限
//        rows=gradeDao.deleteById(id);
//        return rows;
//    }
//
//    /**
//     * @Title: deleteByIds
//     * @Description: 根据多个id删除多个等级权限
//     * @author dengchao
//     * @date 2018/1/22
//     * @param ids 要删除的多个权限id
//     * @return rows 返回受影响行数
//     */
//    @Override
//    public Integer deleteByIds(Long[] ids) throws SQLException {
//        //获取连接
////        gradeDao.getConnection();
//        //根据多个id删除多个等级权限
//        rows=gradeDao.deleteByIds(ids);
//        return rows;
//    }
//
//    /**
//     * @Title: saveOrUpdate
//     * @Description: 添加或者修改
//     * @author dengchao
//     * @date 2018/1/22
//     * @param grade 要操作的等级权限
//     * @return rows 返回受影响行数
//     */
//    @Override
//    public Integer saveOrUpdate(Grade grade) throws SQLException {
//       /* //获取连接
//        gradeDao.getConnection();
//        //添加或者修改*/
//        if(grade.getId()!=null){
//            rows=gradeDao.update(grade);
//        }else{
//            rows=gradeDao.save(grade);
//        }
//        return rows;
//    }
//
//    /**
//     * @Title: findById
//     * @Description: 根据id查询数据
//     * @author dengchao
//     * @date 2018/1/22
//     * @param id 要查询的权限id
//     * @return peopleInfo 返回查询到的等级信息
//     */
//    @Override
//    public Grade findById(Long id) throws SQLException {
////        //获取连接
////        gradeDao.getConnection();
////        //定义一个人员对象用来接收查询到的人员信息
////        Grade grade=new Grade();
//        //根据id查询人员信息
//        return gradeDao.findById(id);
////        //输出人员姓名
////        System.out.println("该人员等级权限："+grade.getGradeName());
////        return grade;
//    }
//
//    /**
//     * @Title: findByCondtion
//     * @Description: 根据条件查询数据
//     * @author dengchao
//     * @date 2018/1/22
//     * @param stringObjectMap 查询条件
//     * @return 返回查询等级对象集合
//     */
//    @Override
//    public List<Grade> findByCondtion(Map<String, Object> stringObjectMap) throws SQLException {
//        //获取连接
////        gradeDao.getConnection();
//        return gradeDao.findByCondtion(stringObjectMap);
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
//     * @return 返回查询等级对象集合
//     */
//    @Override
//    public List<Grade> findByCondtionForPage(Map<String, Object> stringObjectMap, Integer startRows, Integer size) throws SQLException {
//        //获取连接
////        gradeDao.getConnection();
//        return gradeDao.findByCondtionForPage(stringObjectMap,startRows,size);
//    }
}
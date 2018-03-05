package wechat_business.service;/********************************************************************
 /**
 * @Project: java_practice
 * @Package wechat_business.service
 * @author HL
 * @date 2018/1/26 9:21
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import org.apache.struts2.convention.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wechat_business.dao.ItemInfoDao;
import wechat_business.entity.ItemInfo;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @author guohongjin
 * @ClassName ItemInfoServiceImpl
 * @Description 类描述
 * @date 2018/1/26
 */
@Service("itemInfoServiceImpl")
public class ItemInfoServiceImpl implements ItemInfoService {
    //定义一个静态对象，方便调用方法
    @Autowired
    private ItemInfoDao itemInfoDao;
    /**
     * @Title: deletePeopleById
     * @Description: 删除指定id 的人员信息
     * @author huanglei
     * @date 2018-01-21
     * @param: id 指定id
     * @return: 受影响行数
     */
    @Override
    public Integer deleteById(Long id) throws SQLException {
        return itemInfoDao.deleteById(id);
    }

    /**
     * @Title: deletePeopleByIds
     * @Description: 根据id删除多个
     * @author huanglei
     * @date 2018/1/22
     * @param ids 指定的多个id
     * @return 返回受影响行数
     */
    @Override
    public Integer deleteByIds(Long[] ids) throws SQLException {
        return itemInfoDao.deleteByIds(ids);

    }
    /**
     * @Title: saveOrUpdate
     * @Description: 添加或者修改
     * @author huanglei
     * @date 2018/1/22
     */
    @Override
    public Integer saveOrUpdate(ItemInfo itemInfo) throws SQLException {
        //定义受影响行数
        Integer rows=itemInfoDao.saveOrUpdate(itemInfo);
        System.out.println("受影响行数"+rows);
        return rows;

    }
    /**
     * @Title: findById
     * @Description: 根据id查询数据
     * @author huanglei
     * @date 2018/1/22
     */
    @Override
    public ItemInfo findById(Long id) throws SQLException {
        return itemInfoDao.findById(id);
    }
    /**
     * @Title: findByCondtion
     * @Description: 条件查询数据
     * @author huanglei
     * @date 2018/1/22
     */
    @Override
    public List<ItemInfo> findByCondtion(Map<String, Object> stringObjectMap) throws SQLException {
        return itemInfoDao.findByCondtion(stringObjectMap);
    }
    /**
     * @Title: findByCondtionForPage
     * @Description: 根据条件分页查询数据
     * @author huanglei
     * @date 2018/1/22
     */
    @Override
    public List<ItemInfo> findByCondtionForPage(Map<String, Object> stringObjectMap, Integer startRows, Integer size) throws SQLException {
        return itemInfoDao.findByCondtionForPage(stringObjectMap,startRows,size);
    }
    /**
     * @Title: rollback
     * @Description: 回滚
     * @author lvchong
     * @params * @param null
     * @date 2018-01-29
     * @throw YnCorpSysException
     */
    public void rollback() throws SQLException {
        itemInfoDao.rollback();
    }

    /**
     * @Title: release
     * @Description: 释放资源
     * @author lvchong
     * @date 2018-02-01
     * @throw YnCorpSysException
     */
    public void release(){
        itemInfoDao.release();
    }
}

package wechat_business.service;/********************************************************************
 /**
 * @Project: java_practice
 * @Package wechat_business.service
 * @author HL
 * @date 2018/1/26 9:15
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import wechat_business.entity.ItemInfo;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @author huanglei
 * @InterfaceName ItemInfoService
 * @Description 接口描述
 * @date 2018/1/26
 */
public interface ItemInfoService {
    /**
     * @Title: deleteById
     * @Description: 根据Id删除数据
     * @author haunglei
     * @date 2018/1/22
     */
    public abstract Integer deleteById(Long id) throws SQLException;

    /**
     * @Title: deleteByIds
     * @Description: 根据Id删除多个
     * @author haunglei
     * @date 2018/1/22
     */
    public abstract Integer deleteByIds(Long[] ids) throws SQLException;
    /**
     * @Title: saveOrUpdate
     * @Description: 添加或者修改
     * @author huanglei
     * @date 2018/1/22
     */
    public abstract Integer saveOrUpdate(ItemInfo itemInfo) throws SQLException;
    /**
     * @Title: findById
     * @Description: 根据id查询数据
     * @author dengchao
     * @date 2018/1/22
     */
    public abstract ItemInfo findById(Long id) throws SQLException;
    /**
     * @Title: findByCondtion
     * @Description: 条件查询数据
     * @author huanglei
     * @date 2018/1/22
     */
    public abstract List<ItemInfo> findByCondtion(Map<String, Object> stringObjectMap) throws SQLException;
    /**
     * @Title: findByCondtionForPage
     * @Description: 根据条件分页查询数据
     * @author huanglei
     * @date 2018/1/22
     */
    public abstract List<ItemInfo> findByCondtionForPage(Map<String, Object> stringObjectMap, Integer startRows, Integer size) throws SQLException;

}


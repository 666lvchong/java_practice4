package wechat_business.util;/********************************************************************
 /**
 * @Project: java_practice
 * @Package com.wechat_business.util
 * @author hehongju
 * @date 2018/1/19 16:28
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import java.sql.*;
import java.util.List;
import java.util.Map;

/**
 * @author hehongju
 * @InterfaceName DaoUtil
 * @Description 数据库导入帮助接口
 * @date 2018/1/19
 */
public interface DaoUtil<E> {
    /**
     * @Title: deleteById
     * @Description: 根据Id删除数据
     * @author hehongju
     * @date 2018-01-19
     * @throws java.sql.SQLException
     * @param id 主键ID
     */
    public Integer deleteById(Long id) throws SQLException;
    /**
     * @Title: deleteByIds
     * @Description: 根据Id删除多个
     * @author hehongju
     * @date 2018-01-19
     * @throws java.sql.SQLException
     * @param  ids 主键ID数组
     */
    public  Integer deleteByIds(Long[] ids) throws SQLException;
    /**
     * @Title: saveOrUpdate
     * @Description: 添加或者修改
     * @author hehongju
     * @date 2018-01-19
     * @throws java.sql.SQLException
     */
    public  Integer saveOrUpdate(E impl) throws SQLException;
    /**
     * @Title: findById
     * @Description: 更具Id查询数据
     * @author lhehongju
     * @date 2018-01-19
     * @throws java.sql.SQLException
     * @param id 主键ID
     */
    public E findById(Long id) throws SQLException;
    /**
     * @Title: findByCondtion
     * @Description: 条件查询数据
     * @author hehongju
     * @date 2018-01-19
     * @throws java.sql.SQLException
     * @param stringObjectMap 条件键值对
     */
    public abstract List<E> findByCondtion(Map<String, Object> stringObjectMap) throws SQLException;
    /**
     * @Title: findByCondtionForPage
     * @Description: 根据条件分页查询数据
     * @author hehongju
     * @date 2018-01-19
     * @throws java.sql.SQLException
     * @param stringObjectMap 条件键值对
     * @param startRows 分页开始值
     * @param size 分页大小
     */
    public abstract List<E> findByCondtionForPage(Map<String, Object> stringObjectMap, Integer startRows, Integer size) throws SQLException;
}
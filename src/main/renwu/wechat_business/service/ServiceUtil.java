package wechat_business.service;
/**
 * @Project: Team4
 * @Package wechat_business.service
 * @author lvchong
 * @date 2018/3/5 15:39
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import org.springframework.beans.factory.annotation.Autowired;
import wechat_business.dao.Dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @author lvchong
 * @ClassName ServiceUtil
 * @Description 类描述
 * @date 2018/3/5
 */
public class ServiceUtil<E extends Dao,A> {
    @Autowired
    protected E dao;
    /**
     * @Title: deleteById
     * @Description: 根据Id删除数据
     * @author lvchong
     * @date 2018-01-19
     */
    public Integer deleteById(Long id) throws SQLException {
        return dao.deleteById(id);
    }

    ;

    /**
     * @Title: deleteByIds
     * @Description: 根据Id删除多个
     * @author lvchong
     * @date 2018-01-19
     */
    public Integer deleteByIds(Long[] ids) throws SQLException{
        return dao.deleteByIds(ids);
    };
    /**
     * @Title: save
     * @Description: 添加
     * @author lvchong
     * @date 2018-01-19
     */
    public  Integer save(A test) throws SQLException{
        return dao.save(test);
    };

    /**
     * @Title: update
     * @Description: 修改
     * @author lvchong
     * @date 2018-01-19
     */
    public  Integer update(A test) throws SQLException{
        return dao.update(test);
    };
    /**
     * @Title: findById
     * @Description: 更具Id查询数据
     * @author lvchong
     * @date 2018-01-19
     */
    public A findById(Long id) throws SQLException{
        return (A)dao.findById(id);
    };
    /**
     * @Title: findByCondtion
     * @Description: 条件查询数据
     * @author lvchong
     * @date 2018-01-19
     * @param stringObjectMap
     */
    public List<A> findByCondtion(Map<String, Object> stringObjectMap) throws SQLException{
        return dao.findByCondtion(stringObjectMap);
    };
    /**
     * @Title: findByCondtionForPage
     * @Description: 根据条件分页查询数据
     * @author lvchong
     * @date 2018-01-19
     */
    public List<A> findByCondtionForPage(Map<String, Object> stringObjectMap, Integer startRows, Integer size) throws SQLException{
        return dao.findByCondtionForPage(stringObjectMap,startRows,size);
    };

}

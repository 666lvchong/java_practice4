package wechat_business.service;
/**
 * @Project: java_practice
 * @Package wechat_business.service
 * @author lvchong
 * @date 2018/1/22 9:02
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import wechat_business.entity.OrderStatementInfo;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @author lvchong
 * @InterfaceName OrderStatementInfoService
 * @Description 接口描述
 * @date 2018/1/22
 */
public interface OrderStatementInfoService {
    /**
     * @Title: deleteById
     * @Description: 根据Id删除数据
     * @author lvchong
     * @date 2018-01-19
     */
    public abstract Integer deleteById(Long id) throws SQLException;

    /**
     * @Title: deleteByIds
     * @Description: 根据Id删除多个
     * @author lvchong
     * @date 2018-01-19
     */
    public abstract Integer deleteByIds(Long[] ids) throws SQLException;
    /**
     * @Title: saveOrUpdate
     * @Description: 添加或者修改
     * @author lvchong
     * @date 2018-01-19
     */
    public abstract Integer saveOrUpdate(OrderStatementInfo test) throws SQLException;
    /**
     * @Title: findById
     * @Description: 更具Id查询数据
     * @author lvchong
     * @date 2018-01-19
     */
    public abstract OrderStatementInfo findById(Long id) throws SQLException;
    /**
     * @Title: findByCondtion
     * @Description: 条件查询数据
     * @author lvchong
     * @date 2018-01-19
     */
    public abstract List<OrderStatementInfo> findByCondtion(Map<String, Object> stringObjectMap) throws SQLException;
    /**
     * @Title: findByCondtionForPage
     * @Description: 根据条件分页查询数据
     * @author lvchong
     * @date 2018-01-19
     */
    public abstract List<OrderStatementInfo> findByCondtionForPage(Map<String, Object> stringObjectMap, Integer startRows, Integer size) throws SQLException;
}

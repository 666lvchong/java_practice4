package wechat_business.service;

import wechat_business.entity.Address;
import wechat_business.entity.Grade;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Created by Lenovo on 2018/2/17.
 */
public interface AddressService {
    /**
     * @Title: deleteById
     * @Description: 根据Id删除数据
     * @author dengchao
     * @date 2018/1/22
     */
    public abstract Integer deleteById(Long id) throws SQLException;

    /**
     * @Title: deleteByIds
     * @Description: 根据Id删除多个
     * @author dengchao
     * @date 2018/1/22
     */
    public abstract Integer deleteByIds(Long[] ids) throws SQLException;
    /**
     * @Title: saveOrUpdate
     * @Description: 添加或者修改
     * @author dengchao
     * @date 2018/1/22
     */
    public abstract Integer saveOrUpdate(Address test) throws SQLException;
    /**
     * @Title: findById
     * @Description: 根据id查询数据
     * @author dengchao
     * @date 2018/1/22
     */
    public abstract Address findById(Long id) throws SQLException;
    /**
     * @Title: findByCondtion
     * @Description: 条件查询数据
     * @author dengchao
     * @date 2018/1/22
     */
    public abstract List<Address> findByCondtion(Map<String, Object> stringObjectMap) throws SQLException;
    /**
     * @Title: findByCondtionForPage
     * @Description: 根据条件分页查询数据
     * @author dengchao
     * @date 2018/1/22
     */
    public abstract List<Address> findByCondtionForPage(Map<String, Object> stringObjectMap, Integer startRows, Integer size) throws SQLException;
}


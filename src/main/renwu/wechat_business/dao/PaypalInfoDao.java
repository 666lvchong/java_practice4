package wechat_business.dao;/********************************************************************
 /**
 * @Project: java_practice
 * * @Package dao
 * @author caixing
 * @date 2018/1/20 16:53
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */
import wechat_business.entity.PaypalInfo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
/**
 * @author caixing
 *@interfceName PaypalInfoDao
 *@Description 支付宝信息Dao
 *@date 2018/1/20
 * */
public interface  PaypalInfoDao{
 /**
     * @Title: deleteById
     * @Description: 方法描述 根据Id删除数据
     * @author caixing
     * @date 2018/1/19
     * @throw SQLException
     */
    public Integer deleteById(Long id) throws SQLException;

    /**
     * @Title: deleteByIds
     * @Description: 方法描述 根据多个id删除多条数据
     * @author caixing
     * @date 2018/1/19
     * @throw SQLException
     * */
    public Integer deleteByIds(Long[] ids)throws SQLException;
    /**
     * @Title: saveOrUpdate
     @Description: 方法描述 添加或者修改
      * @author caixing
     * @date 2018/1/19
     * @throw SQLException
     */
    public Integer saveOrUpdate(PaypalInfo itemInfo) throws SQLException;
    /**
     * @Title: findById
     @Description: 方法描述 根据Id查询数据
      * @author caixing
     * @date 2018/1/19
     * @throw SQLException
     */
    public PaypalInfo findById(Long id) throws SQLException;

    /**
     * @Title: findByCondtion
     * @Description: 方法描述 条件查询数据
     * @author caixing
     * @date 2018/1/19
     * @throw SQLException
     */
    public List<PaypalInfo> findByCondtion(Map<String, Object> stringObjectMap) throws SQLException;

    /**
     * @Title: findByCondtionForPage
     * @Description: 方法描述 根据条件分页查询数据
     * @author caixing
     * @date 2018/1/19
     * @throw SQLException
     */

    public List<PaypalInfo> findByCondtionForPage(Map<String, Object> stringObjectMap, Integer startRows, Integer size)throws SQLException;
}

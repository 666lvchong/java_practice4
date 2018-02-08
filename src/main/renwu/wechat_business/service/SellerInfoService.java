package wechat_business.service;
/**
 * @Project: wechat_business
 * @Package wechat_business.service
 * @author wangjunjie
 * @date 2018/1/22 9:02
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import wechat_business.dao.ItemInfoDao;
import wechat_business.entity.ItemInfo;
import wechat_business.entity.OrderDetail;
import wechat_business.entity.PeopleInfo;
import wechat_business.entity.SellerInfo;


import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @author wangjunjie
 * @InterfaceName SellerInfoService
 * @Description 接口描述
 * @date 2018/1/22
 */
public interface SellerInfoService {
    /**
     * @Title: deleteById
     * @Description: 根据Id删除数据
     * @author wangjunjie
     * @date 2018-01-19
     */
    public abstract Integer deleteById(Long id) throws SQLException;

    /**
     * @Title: deleteByIds
     * @Description: 根据Id删除多个
     * @author wangjunjie
     * @date 2018-01-19
     */
    public abstract Integer deleteByIds(Long[] ids) throws SQLException;
    /**
     * @Title: saveOrUpdate
     * @Description: 添加或者修改
     * @author wangjunjie
     * @date 2018-01-19
     */
    public abstract Integer saveOrUpdate(SellerInfo sellerInfo) throws SQLException;
    /**
     * @Title: findById
     * @Description: 更具Id查询数据
     * @author wangjunjie
     * @date 2018-01-19
     */
    public abstract SellerInfo findById(Long id) throws SQLException;
    /**
     * @Title: findByCondtion
     * @Description: 条件查询数据
     * @author wangjunjie
     * @date 2018-01-19
     */
    public abstract List<SellerInfo> findByCondtion(Map<String, Object> stringObjectMap) throws SQLException;
    /**
     * @Title: findByCondtionForPage
     * @Description: 根据条件分页查询数据
     * @author wangjunjie
     * @date 2018-01-19
     */
    public abstract List<SellerInfo> findByCondtionForPage(Map<String, Object> stringObjectMap, Integer startRows, Integer size) throws SQLException;


    void stock(ItemInfo itemInfo, PeopleInfo sellerInfo, Double stockGoodsNum) throws RuntimeException;

    void sell(ItemInfo itemInfo, PeopleInfo sellerInfo, Double sellGoodsNum) throws RuntimeException;

    void shipment(PeopleInfo sellerInfo, OrderDetail orderDetail) throws RuntimeException;
}

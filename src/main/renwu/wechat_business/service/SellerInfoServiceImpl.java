package wechat_business.service;
/**
 * @Project: java_practice
 * @Package wechat_business.service
 * @author lvchong
 * @date 2018/1/22 9:03
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wechat_business.dao.Dao;
import wechat_business.dao.ItemInfoDao;
import wechat_business.dao.OrderDetailDaoImpl;
import wechat_business.dao.SellerInfoDao;
import wechat_business.entity.ItemInfo;
import wechat_business.entity.OrderDetail;
import wechat_business.entity.PeopleInfo;
import wechat_business.entity.SellerInfo;
import wechat_business.service.SellerInfoService;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author lvchong
 * @ClassName SellerInfoServiceImpl
 * @Description 类描述
 * @date 2018/1/22
 */
@Service("sellerInfoServiceImpl")
public class SellerInfoServiceImpl implements SellerInfoService {
    @Autowired
    SellerInfoDao sellerInfoDao;
    /**
     * @Title: deleteById
     * @Description: 根据Id删除数据
     * @author wangjunjie
     * @date 2018-01-19
     */
    @Override
    public Integer deleteById(Long id) throws SQLException {
        return sellerInfoDao.deleteById(id);

    }
    /**
     * @Title: deleteByIds
     * @Description: 根据Id删除多个
     * @author wangjunjie
     * @date 2018-01-19
     */
    @Override
    public Integer deleteByIds(Long[] ids) throws SQLException {
        return sellerInfoDao.deleteByIds(ids);

    }
    /**
     * @Title: saveOrUpdate
     * @Description: 添加或者修改
     * @author wangjunjie
     * @date 2018-01-19
     */
    @Override
    public Integer saveOrUpdate(SellerInfo sellerInfo) throws SQLException {
        return sellerInfoDao.saveOrUpdate(sellerInfo);

    }
    /**
     * @Title: findById
     * @Description: 更具Id查询数据
     * @author wangjunjie
     * @date 2018-01-19
     */
    @Override
    public SellerInfo findById(Long id) throws SQLException {
        return sellerInfoDao.findById(id);

    }
    /**
     * @Title: findByCondtion
     * @Description: 条件查询数据
     * @author wangjunjie
     * @date 2018-01-19
     */
    @Override
    public List<SellerInfo> findByCondtion(Map<String, Object> stringObjectMap) throws SQLException {
        return sellerInfoDao.findByCondtion(stringObjectMap);

    }
    /**
     * @Title: findByCondtionForPage
     * @Description: 根据条件分页查询数据
     * @author wangjunjie
     * @date 2018-01-19
     */
    @Override
    public List<SellerInfo> findByCondtionForPage(Map<String, Object> stringObjectMap, Integer startRows, Integer size) throws SQLException {
        return sellerInfoDao.findByCondtionForPage(stringObjectMap,startRows,size);

    }
    /**
     * @Title: rollback
     * @Description: 释放资源
     * @author wangjunjie
     * @date 2018-02-01
     * @throw YnCorpSysException
     */
    public void rollback() throws SQLException {
        sellerInfoDao.rollback();
    }

    /**
     * @Title: release
     * @Description: 释放资源
     * @author wangjunjie
     * @date 2018-02-01
     * @throw YnCorpSysException
     */
    public void release(){
        sellerInfoDao.release();
    }
    /**
     * @Title:
     * @Description: 进货
     * @author wangjunjie
     * @date 2018/1/18
     * @throw RuntimeException
     */
    @Override
    public void stock(ItemInfo itemInfo, PeopleInfo sellerInfo, Double stockGoodsNum) throws RuntimeException {
    }
    /**
     * @Title: sell
     * @Description: 售货
     * @author wangjunjie
     * @date 2018/1/10
     * @param sellGoodsNum  售卖商品数量
     */
    @Override
     public void sell(ItemInfo itemInfo, PeopleInfo sellerInfo, Double sellGoodsNum) throws RuntimeException {
    }
    /**
     * @Title: shipment
     * @Description: 发货
     * @author wangjunjie
     * @date 2018/1/10
     */
    @Override
    public void shipment(PeopleInfo sellerInfo, OrderDetail orderDetail) throws RuntimeException {

    }

}


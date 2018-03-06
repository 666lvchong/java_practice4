package wechat_business.service;
/**
 * @Project: java_practice
 * @Package wechat_business.service
 * @author lvchong
 * @date 2018/1/25 9:53
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import org.springframework.stereotype.Service;
import wechat_business.dao.TaobaoAccountDao;
import wechat_business.entity.TaobaoAccount;

/**
 * @author lvchong
 * @ClassName BuyerInfoServiceImp
 * @Description 类描述
 * @date 2018/1/25
 */
@Service("taobaoAccountService")
public class TaobaoAccountServicelmpl  extends ServiceUtil<TaobaoAccountDao,TaobaoAccount> {
//    TaobaoAccountDao dao = new TaobaoAccountDao();
//    @Override
//    public Integer deleteById(Long id) throws SQLException {
//        return dao.deleteById(id);
//    }
//
//    @Override
//    public Integer deleteByIds(Long[] ids) throws SQLException {
//        return dao.deleteByIds(ids);
//    }
//
//    @Override
//    public Integer saveOrUpdate(TaobaoAccount test) throws SQLException {
//        return dao.saveOrUpdate(test);
//    }
//
//    @Override
//    public TaobaoAccount findById(Long id) throws SQLException {
//        return dao.findById(id);
//    }
//
//    @Override
//    public List<TaobaoAccount> findByCondtion(Map<String, Object> stringObjectMap) throws SQLException {
//        return dao.findByCondtion(stringObjectMap);
//    }
//
//    @Override
//
//    public List<TaobaoAccount> findByCondtionForPage(Map<String, Object> stringObjectMap, Integer startRows, Integer size) throws SQLException {
//        return dao.findByCondtionForPage(stringObjectMap,startRows,size);
//    }
}

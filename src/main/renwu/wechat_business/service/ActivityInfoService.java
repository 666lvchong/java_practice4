package wechat_business.service;/********************************************************************
 /**
 * @Project: Team4
 * @Package wechat_business.service
 * @author dengchao
 * @date 2018/2/12 22:26
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */
import wechat_business.entity.ActivityInfo;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @author dengchao
 * @ClassName ActivityInfoService
 * @Description 活动信息表service
 * @date 2018/2/12
 */
public interface ActivityInfoService {
    /**
     * @Title: deleteById
     * @Description: 根据id删除
     * @author dengchao
     * @date 2018/2/12
     * @param id 要删除的id
     */
    public Integer deleteById(Long id) throws SQLException;

    /**
     * @Title: deleteByIds
     * @Description: 根据id删除多个
     * @author dengchao
     * @date 2018/2/12
     * @param ids 要删除的id数组
     */
    public abstract Integer deleteByIds(Long[] ids) throws SQLException;

    /**
     * @Title: saveOrUpdate
     * @Description: 保存或修改
     * @author dengchao
     * @date 2018/2/12
     * @param activityInfo 活动信息对象
     * @return 返回受影响行数
     */
    public abstract Integer saveOrUpdate(ActivityInfo activityInfo) throws SQLException;

    /**
     * @Title: findById
     * @Description: 根据id查询
     * @author dengchao
     * @date 2018/2/12
     * @param id 查询id
     * @return 返回查询对象
     */
    public abstract ActivityInfo findById(Long id) throws SQLException;

    /**
     * @Title: findByCondtion
     * @Description: 按条件查询
     * @author dengchao
     * @date 2018/2/12
     * @param stringObjectMap 查询条件
     * @return 返回查询结果集合
     */
    public abstract List<ActivityInfo> findByCondtion(Map<String, Object> stringObjectMap) throws SQLException;

    /**
     * @Title: findByCondtionForPage
     * @Description: 按条件分页查询
     * @author dengchao
     * @date 2018/2/12
     * @param stringObjectMap 查询条件
     * @param startRows 分页开始页数
     * @param size 分页页数
     * @return 返回查询结果集
     */
    public abstract List<ActivityInfo> findByCondtionForPage(Map<String, Object> stringObjectMap, Integer startRows, Integer size) throws SQLException;

}
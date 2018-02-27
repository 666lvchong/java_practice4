package wechat_business.dao;
/**
 * @Project: Team4
 * @Package wechat_business.dao
 * @author lvchong
 * @date 2018/2/26 14:05
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import org.mybatis.spring.SqlSessionTemplate;

import javax.annotation.Resource;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author lvchong
 * @ClassName BaseDaoImpl
 * @Description 类描述
 * @date 2018/2/26
 */
public class BaseDaoImpl<T> {
    @Resource
    protected SqlSessionTemplate sqlSessionTemplate;
    //获取T的Class对象是关键，看构造方法
    private Class<T> cls = null;
    public BaseDaoImpl() {
        Class cla=this.getClass();
        ParameterizedType type= (ParameterizedType) cla.getGenericSuperclass();
        Type[] types=type.getActualTypeArguments();
        cls= (Class<T>) types[0];
    }
    /**
     * @Title: getMybaitsNameSpace
     * @Description: 命名空间+“.”+id
     * @author guohongjin
     * @date 2017-10-20
     */
    public String getMybaitsNameSpace(){
        return cls.getName()+".";
    }
}

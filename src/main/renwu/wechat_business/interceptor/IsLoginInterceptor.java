package wechat_business.interceptor;
/**
 * @Project: Team4
 * @Package wechat_business.interceptor
 * @author lvchong
 * @date 2018/3/2 10:01
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

/**
 * @author lvchong
 * @ClassName IsLoginInterceptor
 * @Description 类描述
 * @date 2018/3/2
 */
public class IsLoginInterceptor implements Interceptor {
    @Override
    public void destroy() {

    }

    @Override
    public void init() {

    }

    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        System.out.println("拦截成功");
        return actionInvocation.invoke();
    }
}

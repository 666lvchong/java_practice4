package wechat_business.action;/********************************************************************
 /**
 * @Project: zyht_web
 * @Package com.base
 * @author guohongjin
 * @date 2017/9/30 11:37
 * @Copyright: 2017 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.util.ServletContextAware;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author guohongjin
 * @ClassName BaseAction
 * @Description 类描述
 * @date 2017/9/30
 */
public class BaseAction extends ActionSupport implements ServletContextAware,ServletResponseAware,ServletRequestAware {

    protected HttpServletResponse response;

    protected HttpServletRequest request;

    protected ServletContext servletContext;

    @Override
    public void setServletContext(ServletContext context) {
        this.servletContext=context;
    }

    @Override
    public void setServletRequest(HttpServletRequest request) {
        this.request=request;
    }

    @Override
    public void setServletResponse(HttpServletResponse response) {
        this.response=response;
    }
}

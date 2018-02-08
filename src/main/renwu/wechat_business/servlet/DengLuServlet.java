package wechat_business.servlet;
/**
 * @Project: Team4
 * @Package wechat_business.servlet
 * @author lvchong
 * @date 2018/2/1 9:53
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import wechat_business.entity.ItemInfo;
import wechat_business.entity.ItemRelation;
import wechat_business.entity.TaobaoAccount;
import wechat_business.service.ItemInfoServiceImpl;
import wechat_business.service.ItemRelationServiceImpl;
import wechat_business.service.TaobaoAccountServicelmpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lvchong
 * @ClassName dengluServlet
 * @Description 类描述
 * @date 2018/2/1
 */
public class DengLuServlet extends HttpServlet {
    /**
     * @Title: doGet
     * @Description: 继承父类方法
     * @author lvchong
     * @params @param null
     * @date 2018-01-27
     * @throw YnCorpSysException
     */
    public void doGet(HttpServletRequest httpServletRequest , HttpServletResponse httpServletResponse)  throws ServletException, IOException {
        String username = httpServletRequest.getParameter("username");
        String password = httpServletRequest.getParameter("password");
        TaobaoAccountServicelmpl taobaoAccountServicelmpl = new TaobaoAccountServicelmpl();
        Map<String,Object> map = new HashMap<String, Object>();
        try {
            map.put(" PERSONNEL_ACCOUNT ",username);
            map.put(" PASSWORD ",password);

            List<TaobaoAccount> list = taobaoAccountServicelmpl.findByCondtion(map);
            if(list.size()>0){
                byte grade = 6;
                if (list.get(0).getGrade().getGradeNumber()==grade){
                    httpServletRequest.getRequestDispatcher("userInfoServlet.do").forward(httpServletRequest, httpServletResponse);
                    httpServletRequest.getSession().setAttribute("TaobaoAccount",list.get(0));
                }else{
                    httpServletRequest.getRequestDispatcher("findByItemInfo.do").forward(httpServletRequest, httpServletResponse);
                    httpServletRequest.getSession().setAttribute("TaobaoAccount",list.get(0));
                }
            }else{
                //转发到主页面
                httpServletRequest.getRequestDispatcher("jsp/administrator_login.jsp").forward(httpServletRequest, httpServletResponse);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /**
     * @Title: doPost
     * @Description: 继承父类方法
     * @author lvchong
     * @params @param null
     * @date 2018-01-27
     * @throw YnCorpSysException
     */
    public void doPost(HttpServletRequest httpServletRequest , HttpServletResponse httpServletResponse) throws ServletException, IOException{
        doGet(httpServletRequest,httpServletResponse);
    }
}

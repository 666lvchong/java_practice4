package wechat_business.action;/********************************************************************
 /**
 * @Project: Team4
 * @Package wechat_business.controller.action
 * @author dengchao
 * @date 2018/3/6 15:50
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import com.opensymphony.xwork2.ActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;
import wechat_business.entity.TaobaoAccount;
import wechat_business.service.TaobaoAccountServicelmpl;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author dengchao
 * @ClassName UserInfoAction
 * @Description 类描述
 * @date 2018/3/6
 */
@Action(value = "userInfo")
@Results({
        @Result(name = "userInfo",location = "/jsp/user_info.jsp")
})
public class UserInfoAction extends BaseAction {
    /**
     * i 定义一个常量
     */
    private int i=0;
    /**
     * keyword 接收页面传递过来的参数
     */
    private String keyword;
    /**
     * method 接收页面传递过来的参数
     */
    private String method;
    /**
     * id 接收页面传递过来的参数
     */
    private String id;
    /**
     * 注入taobaoAccountService实例bean
     */
    @Autowired
    private TaobaoAccountServicelmpl taobaoAccountService;


    /**
     * @Title: doPost
     * @Description: 控制层方法，处理页面数据
     * @author dengchao
     * @date 2018/3/6
     */
    public void doPost() throws UnsupportedEncodingException, SQLException {
        //设置请求/响应编码格式
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        //判断是否需要删除
        if ("del".equals(method)){
            del();
        }
        Map<String,Object> stringObjectMap= new HashMap<String, Object>();
        //判断输入搜索关键字是否为空
            if (keyword != null && keyword != ""){
                //将获取到的关键字（淘宝账号）存入map中
            stringObjectMap.put("PERSONNEL_ACCOUNT",keyword);
        }
        //调用服务方法
        List<TaobaoAccount> listResult=taobaoAccountService.findByCondtion(stringObjectMap);
        //保存查询结果 将action方法中产生的数据存入request域中的方式 第一种
        ActionContext.getContext().put("listResult",listResult);
//        //将action方法中产生的数据存入request域中的方式 第二种
//        ServletActionContext.getRequest().setAttribute("listResult",listResult);

//        //使用ajax传递数据
//        try {
//            JsonObject jsonObject= (JsonObject) SpringContextUtil.getBean("jsonObject");
//            for (TaobaoAccount taobao:listResult){
//                jsonObject.addProperty("outTaobaoId",taobao.getId());
//                jsonObject.addProperty("outTaobaoAccount",taobao.getPersonnelAccount());
//                jsonObject.addProperty("outPeopleName",taobao.getPeopleInfo().getName());
//                jsonObject.addProperty("outAddTime", String.valueOf(taobao.getAddTime()));
//                jsonObject.addProperty("outGradeName",taobao.getGrade().getGradeName());
//            }
//            JsonObject obj= (JsonObject) SpringContextUtil.getBean("jsonObject");
//            obj.add("obj",jsonObject);
//            response.getWriter().print(obj.toString());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        return "userInfo";
    }

    private void del(){
        try {
            taobaoAccountService.deleteById(Long.valueOf(id));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
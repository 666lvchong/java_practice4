package wechat_business.action;/********************************************************************
 /**
 * @Project: Team4
 * @Package wechat_business.action
 * @author dengchao
 * @date 2018/3/8 22:02
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;
import wechat_business.entity.ActivityInfo;
import wechat_business.entity.ActivityRelation;
import wechat_business.service.ActivityInfoServiceImpl;
import wechat_business.service.ActivityRelationServiceImpl;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author dengchao
 * @ClassName ActivityInfoAction
 * @Description 活动发布页面的Action
 * @date 2018/3/8
 */
@Action(value = "activity")
@Results({
        @Result(name = "activity",location = "/jsp/activity_info.jsp")
})
public class ActivityInfoAction extends BaseAction {
    /**
     * keyword 用于接收页面传递过来的参数
     */
    private String keyword;
    /**
     * 注入实例bean
     */
    @Autowired
    private ActivityInfoServiceImpl activityInfoService;
    @Autowired
    private ActivityRelationServiceImpl activityRelationService;

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    /**
     * @Title: doPost
     * @Description: 后台处理方法
     * @author dengchao
     * @date 2018/3/9
     */
    public String findInfo() throws UnsupportedEncodingException {
        //设置编码字符集
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        Map<String, Object> mapInfo = new HashMap<String, Object>();
        Map<String, Object> mapRelation = new HashMap<String, Object>();

        //判断页面输入内容是否为空
        if (this.keyword != null && !("".equals(this.keyword))) {//若无搜索条件
            mapInfo.put("ACTIVITY_NAME", keyword);
            //按条件查询
            try {
                List<ActivityInfo> activityInfoList = activityInfoService.findByCondtion(mapInfo);
                //再次将查询结果放入map
                for (ActivityInfo activityInfo : activityInfoList) {
                    mapRelation.put("ACTIVITY_INFO_ID", activityInfo.getId());
                }
                //查询
                List<ActivityRelation> listActivityRelation = activityRelationService.findByCondtion(mapRelation);
                //保存结果 将action方法中产生的数据存入request域中的方式 第二种
                ServletActionContext.getRequest().setAttribute("listActivityRelation", listActivityRelation);
            } catch (SQLException e) {
                e.printStackTrace();
            }

//            return "activity";
        }else {
            try {
                List<ActivityRelation> listActivityRelation = activityRelationService.findByCondtion(mapRelation);
                //保存结果 将action方法中产生的数据存入request域中的方式 第二种
                ServletActionContext.getRequest().setAttribute("listActivityRelation", listActivityRelation);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return "activity";
    }

}
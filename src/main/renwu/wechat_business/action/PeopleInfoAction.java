package wechat_business.action;
/**
 * @Project: Team4
 * @Package wechat_business.action
 * @author lvchong
 * @date 2018/3/10 16:45
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import org.apache.struts2.convention.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import wechat_business.entity.PeopleInfo;
import wechat_business.entity.TaobaoAccount;
import wechat_business.service.PeopleInfoServiceImpl;
import wechat_business.service.TaobaoAccountServicelmpl;

import java.sql.Date;
import java.sql.SQLException;

/**
 * @author lvchong
 * @ClassName PeoPleAction
 * @Description 类描述
 * @date 2018/3/10
 */
@Action("peopleInfoAction")
@Results({
        @Result(name = "success",location = "/jsp/administrator_login.jsp"),
        @Result(name = "failure",location = "/jsp/en_roll.jsp")
})
public class PeopleInfoAction extends BaseAction {
    @Autowired
    private PeopleInfoServiceImpl peopleInfoService;
    @Autowired
    private TaobaoAccountServicelmpl taobaoAccountService;

    private PeopleInfo peopleInfo;
    private TaobaoAccount taobaoAccount;
    private String result;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public TaobaoAccount getTaobaoAccount() {
        return taobaoAccount;
    }

    public void setTaobaoAccount(TaobaoAccount taobaoAccount) {
        this.taobaoAccount = taobaoAccount;
    }



    public PeopleInfo getPeopleInfo() {
        return peopleInfo;
    }

    public void setPeopleInfo(PeopleInfo peopleInfo) {
        this.peopleInfo = peopleInfo;
    }

    public String addPeople(){
        String ret = "failure";
        try {
            //rs 受影响行数
            int rsPeopleInfo = peopleInfoService.save(peopleInfo);
            taobaoAccount.setPeopleInfo(peopleInfo);
            int rsTaobaoAccount = taobaoAccountService.save(taobaoAccount);
            if(rsPeopleInfo>0 && rsTaobaoAccount>0){
                ret="success";
                result="添加成功";
            }else{
                ret="failure";
                result="添加失败";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ret;
    }
}

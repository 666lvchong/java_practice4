package wechat_business.action;
/**
 * @Project: Team4
 * @Package wechat_business.action
 * @author lvchong
 * @date 2018/3/2 9:53
 * @Copyright: 2018 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import wechat_business.entity.ItemInfo;
import wechat_business.entity.ItemRelation;
import wechat_business.entity.TaobaoAccount;
import wechat_business.service.ItemInfoServiceImpl;
import wechat_business.service.ItemRelationServiceImpl;
import wechat_business.service.TaobaoAccountServicelmpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lvchong
 * @ClassName TaobaoAccountAction
 * @Description 淘宝Action
 * @date 2018/3/2
 */
@Action(value = "taobaoAccount")
@Results({
        @Result(name = "chenggong",location = "../jsp/home_page.jsp"),
        @Result(name = "zhuye",location = "../jsp/administrator_login.jsp")
})
public class TaobaoAccountAction extends ActionSupport {
    public TaobaoAccountAction(){
        System.out.println("创建");
    }
    private TaobaoAccount taobaoAccount;
    private ItemInfo itemInfo;
    private ItemRelation itemRelation;
    private List<ItemRelation> itemRelationList;
    @Autowired
    private ItemInfoServiceImpl itemInfoServiceImpl;
    @Autowired
    private ItemRelationServiceImpl itemRelationServiceImpl;
    @Autowired
    private TaobaoAccountServicelmpl taobaoAccountServicelmpl;

    public String denLu(){
        Map<String,Object> map = new HashMap<String, Object>();
        String ret = "";
        try {
            map.put(" PERSONNEL_ACCOUNT ",taobaoAccount.getPersonnelAccount());
            map.put(" PASSWORD ",taobaoAccount.getPassword());
            List<TaobaoAccount> list = taobaoAccountServicelmpl.findByCondtion(map);
            if(list.size()>0){
                byte grade = 6;
                if (list.get(0).getGrade().getGradeNumber()==grade){
                    taobaoAccount = list.get(0);
                    ret="gly";
                }else{
                    taobaoAccount = list.get(0);
                    zhuYe();
                }
            }else{
                //转发到主页面
                ret = "zhuye";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ret;
    }
    public String zhuYe(){
        //创建一个条件的map key值条件字段名  value值 条件的值.
        Map<String,Object> map =null;
        List<ItemInfo> itemInfoList =null;
        //判断传过来的条件是否存在 如果存在则添加到map中
        try {
            map = new HashMap<String, Object>();
            if (itemInfo.getName()!=null){
                map.put("name",itemInfo.getName());
            }
            itemInfoList = itemInfoServiceImpl.findByCondtion(map);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            //通过service的分页条件查询 获得商品关系表中的数据
            itemRelationList = new ArrayList<ItemRelation>();
            for (ItemInfo item :itemInfoList){
                map = new HashMap<String, Object>();
                map.put("ITEM_INFO_ID",item.getId());
                itemRelationList.addAll(itemRelationServiceImpl.findByCondtion(map));
                map=null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "chenggong";
    }

    public List<ItemRelation> getItemRelationList() {
        return itemRelationList;
    }

    public void setItemRelationList(List<ItemRelation> itemRelationList) {
        this.itemRelationList = itemRelationList;
    }
    public ItemInfo getItemInfo() {
        return itemInfo;
    }

    public void setItemInfo(ItemInfo itemInfo) {
        this.itemInfo = itemInfo;
    }

    public ItemRelation getItemRelation() {
        return itemRelation;
    }

    public void setItemRelation(ItemRelation itemRelation) {
        this.itemRelation = itemRelation;
    }

    public TaobaoAccount getTaobaoAccount() {
        return taobaoAccount;
    }

    public void setTaobaoAccount(TaobaoAccount taobaoAccount) {
        this.taobaoAccount = taobaoAccount;
    }
}

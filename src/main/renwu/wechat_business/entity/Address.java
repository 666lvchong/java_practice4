package wechat_business.entity;

/**
 * Created by Lenovo on 2018/2/17.
 */
public class Address {

    /**
     * id 主键id
     */
    private Long id;

    /**
     * my_address 收货地址
     */
    private String myaddress;

    /**
     * taovao_account_id 淘宝id
     */
    private short taobaoaccount;


    /**
     * get 和 set 方法
     */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMyaddress() {
        return myaddress;
    }

    public void setMyaddress(String myaddress) {
        this.myaddress = myaddress;
    }

    public short getTaobaoaccount() {
        return taobaoaccount;
    }

    public void setTaobaoaccount(short taobaoaccount) {
        this.taobaoaccount = taobaoaccount;
    }

    public void setTaobaoaccount(String parameter) {
    }
}

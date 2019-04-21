package com.bdwk.pinyougou.pojo;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * 商家实体类
 */
@TableName("tb_seller")
@Data
@NoArgsConstructor
@ToString
@Accessors(chain = true)
public class TbSeller extends Model<TbSeller> {

    private static final long serialVersionUID = -9218312627742588495L;
    //用户id
    @TableId(value = "seller_id",type = IdType.INPUT)
    private String sellerId;
    //公司名称
    private String name;
    //店铺名称
    private String nickName;
    //密码
    private String password;
    //邮箱
    private String email;
    //移动电话
    private String mobile;
    //座机号
    private String telephone;
    //状态
    private String status;
    //详细地址
    private String addressDetail;
    //联系人姓名
    private String linkmanName;
    //联系人qq
    private String linkmanQq;
    //联系人电话
    private String linkmanMobile;
    //联系人邮箱
    private String linkmanEmail;
    //营业执照号
    private String licenseNumber;
    //税务登记证号
    private String taxNumber;
    //组织机构代码
    private String orgNumber;
    //公司地址
    private Long address;
    //公司LOGO图
    private String logoPic;
    //简介
    private String brief;
    //创建时间
    private Date createTime;
    //法定代表人
    private String legalPerson;
    //法定代表人身份证
    private String legalPersonCardId;
    //银行开户账号
    private String bankUser;
    //开户行
    private String bankName;
    @Override
    protected Serializable pkVal() {
        return this.sellerId;
    }
}

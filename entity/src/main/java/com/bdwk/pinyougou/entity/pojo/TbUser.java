package com.bdwk.pinyougou.entity.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 用户实体类
 */
@TableName("tb_user")
@Data
@NoArgsConstructor
@ToString
@Accessors(chain = true)
public class TbUser extends Model<TbUser> {

    private static final long serialVersionUID = 8440782295407300034L;
    //用户id
    @TableId(value = "id",type = IdType.AUTO)
    private Long id;
    //用户名
    private String username;
    //密码
    private String password;
    //注册手机号
    private String phone;
    //注册邮箱号
    private String email;
    //创建时间
    private Date created;
    //更新时间
    private Date updated;
    //会员来源：1:PC，2：H5，3：Android，4：IOS，5：WeChat
    private String sourceType;
    //昵称
    private String nickName;
    //真实姓名
    private String name;
    //状态
    private String  status;
    //头像地址
    private String headPic;
    //qq号码
    private String qq;
    //账户余额
    private BigDecimal accountBalance;
    //手机是否通过验证
    private String isMobileCheck;
    //邮箱是否通过验证
    private String isEmailCheck;
    //性别
    private String sex;
    //会员等级
    private Integer userLevel;
    //积分
    private Integer points;
    //经验值
    private Integer experienceValue;
    //生日
    private Date birthday;
    //最后登录时间
    private Date lastLoginTime;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}

package com.bdwk.pinyougou.shopweb.controller;
import com.alibaba.dubbo.config.annotation.Reference;
import com.bdwk.pinyougou.common.enums.ResultEnum;
import com.bdwk.pinyougou.common.http.R;
import com.bdwk.pinyougou.entity.pojo.TbSeller;
import com.bdwk.pinyougou.sellergoods.service.ISellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/seller")
public class SellerController extends BaseController{

    @Reference(version = DUBBO_REFERENCE_VERSION,url =DUBBO_REFERENCE_URL)
    private ISellerService sellerService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * 添加
     * @param seller
     * @return
     */
    @RequestMapping("/add")
    public R add(@RequestBody TbSeller seller){
        //加密存储密码
        seller.setPassword(passwordEncoder.encode(seller.getPassword()));
        return sellerService.add(seller);
    }

    /**
     * 修改
     * @param seller
     * @return
     */
    @RequestMapping("/update")
    public R update(@RequestBody TbSeller seller){
        return R.create(ResultEnum.OK);
    }
}

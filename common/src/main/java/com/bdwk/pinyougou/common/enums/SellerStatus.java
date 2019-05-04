package com.bdwk.pinyougou.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum  SellerStatus {
    HAS_NOT_CHECK("0","未审核"),
    HAS_CHECKED("1","已审核"),
    CHECK_FAILED("2","审核未通过"),
    CHECK_CLOSED("3","关闭");

    private String status;
    private String statusName;

    boolean eq(SellerStatus sellerStatus,String status){
        return sellerStatus.getStatus().equals(status);
    }
}

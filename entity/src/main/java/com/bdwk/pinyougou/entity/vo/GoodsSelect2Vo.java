package com.bdwk.pinyougou.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 商品所需的下拉列表数据
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class GoodsSelect2Vo implements Serializable {
    private static final long serialVersionUID = 2351198688513321207L;
    //一级分类
    private List<Map> level1List;
    //二级分类
    private List<Map> level2List;
    //三级分类
    private List<Map> level3List;
    //商品模板
    private List<Map> tempList;
    //品牌
    private List<Map> brandList;

}

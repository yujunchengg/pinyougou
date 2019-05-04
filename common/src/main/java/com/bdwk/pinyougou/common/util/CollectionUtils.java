package com.bdwk.pinyougou.common.util;

import java.util.Collection;

public class CollectionUtils {

    public static boolean isNotEmpty(Collection collection){
        return !isEmpty(collection);
    }

    public static boolean isEmpty(Collection collection){
        return null==collection || collection.size()<=0;
    }
}

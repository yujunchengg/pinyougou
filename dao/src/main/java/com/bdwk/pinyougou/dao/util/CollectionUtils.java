package com.bdwk.pinyougou.dao.util;
import java.util.List;

public class CollectionUtils {

    /**
     *
     * @param ids
     * @param symbol
     * @return
     */
    public static String join(List<Integer> ids,String symbol){
        if(null==ids || ids.size()<=0){
            return null;
        }else {
            if(ids.size()==1){
                return String.valueOf(ids.get(0));
            }else {
                StringBuilder sb=new StringBuilder();
                for (int i=0;i<ids.size();i++){
                    if(i==ids.size()-1){
                        sb.append(ids.get(i));
                        break;
                    }
                    sb.append(ids.get(i)).append(symbol);
                }
                return sb.toString();
            }
        }
    }
}

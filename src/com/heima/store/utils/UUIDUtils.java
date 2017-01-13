package com.heima.store.utils;

import java.util.UUID;

/**
 * Created by Feng on 2017/1/11.
 */
public class UUIDUtils {
    public static String getUUID(){
        return UUID.randomUUID().toString().replace("-","");
    }
}

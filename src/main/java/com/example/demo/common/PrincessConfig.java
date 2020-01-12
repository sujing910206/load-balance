package com.example.demo.common;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * *模拟配置
 * 
 * @author sullivan
 *
 */
public class PrincessConfig {

    /**
     * *所有妃子集合
     */
    public static final List<String> PRINCESS_LIST = Arrays.asList("令妃", "娴妃", "高贵妃", "纯妃");

    /**
     * *所有妃子集合
     */
    public static final Map<String, Integer> PRINCESS_MAP = new LinkedHashMap<String, Integer>() {
        {
            put("令妃", 5);
            put("娴妃", 1);
            put("高贵妃", 3);
            put("纯妃", 2);
        }
    };
    
    /**
     * *所有服务器集合
     */
    public static final List<String> SERVER_IP_LIST = Arrays.asList("192.168.1.10", "192.168.2.20", "192.168.3.30", "192.168.4.40");

}

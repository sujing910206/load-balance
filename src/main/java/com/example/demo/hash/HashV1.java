package com.example.demo.hash;

import java.util.Arrays;
import java.util.List;

import com.example.demo.common.PrincessConfig;

/**
 * *源地址hash取模
 * 
 * *只要服务器列表不变，同一客户端每次请求的服务器都是同一台
 * 
 * *但是如果服务器列表变化，则客户端请求的服务器将可能都会受影响
 * 
 * @author sullivan
 *
 */
public class HashV1 {

    /**
     * *客户端ip
     */
    public static final List<String> CLIENT_IP_LIST = Arrays.asList("113.88.97.173", "106.11.154.33", "207.46.13.149",
            "42.156.137.120", "203.208.60.0", "119.39.47.182", "171.34.179.4", "111.175.58.52", "124.235.138.199",
            "175.184.166.184");

    public static void main(String[] args) {
        for (String clientIp : CLIENT_IP_LIST) {
            int index = Math.abs(getHash(clientIp)) % PrincessConfig.SERVER_IP_LIST.size();
            String serverIp = PrincessConfig.SERVER_IP_LIST.get(index);
            System.out.println(clientIp + "请求的服务器ip为" + serverIp);
        }
    }

    private static int getHash(String str) {
        final int p = 16777619;
        int hash = (int) 2166136261L;
        for (int i = 0; i < str.length(); i++) {
            hash = (hash ^ str.charAt(i)) * p;
        }
        hash += hash << 13;
        hash ^= hash >> 7;
        hash += hash << 3;
        hash ^= hash >> 17;
        hash += hash << 5;

        if (hash < 0) {
            hash = Math.abs(hash);
        }
        return hash;
    }
}

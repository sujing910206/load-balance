package com.example.demo.hash;

import java.util.Arrays;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

import com.example.demo.common.PrincessConfig;

/**
 * *一致性hash
 * 
 * *可以减少因节点变化带来的影响，但是服务器hash分布可能分布不均
 * 
 * @author sullivan
 *
 */
public class HashV2 {

    /**
     * *客户端ip
     */
    public static final List<String> CLIENT_IP_LIST = Arrays.asList("113.88.97.173", "106.11.154.33", "207.46.13.149",
            "42.156.137.120", "203.208.60.0", "119.39.47.182", "171.34.179.4", "111.175.58.52", "124.235.138.199",
            "175.184.166.184");

    public static void main(String[] args) {

        System.out.println(Integer.MAX_VALUE);
        // 建立hash与服务器的映射关系
        TreeMap<Integer, String> nodeMap = new TreeMap<Integer, String>();
        for (String serverIp : PrincessConfig.SERVER_IP_LIST) {
            System.out.println("服务器" + serverIp + "对应的hashcode为" + getHash(serverIp));
            nodeMap.put(getHash(serverIp), serverIp);
        }

        for (String clientIp : CLIENT_IP_LIST) {
            SortedMap<Integer, String> subMap = nodeMap.tailMap(getHash(clientIp));
            Integer firstKey = null;
            try {
                firstKey = subMap.firstKey();
            } catch (Exception e) {
            }

            if (firstKey == null) {
                firstKey = nodeMap.firstKey();
            }
            System.out.println("请求的服务器ip为" + nodeMap.get(firstKey));
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

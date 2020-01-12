package com.example.demo.hash;

import java.util.Arrays;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

import com.example.demo.common.PrincessConfig;

/**
 * *一致性hash+虚拟节点
 * 
 * *多个虚拟结点散列均匀，负载更加均衡
 * 
 * @author sullivan
 *
 */
public class HashV3 {

    /**
     * *客户端ip
     */
    public static final List<String> CLIENT_IP_LIST = Arrays.asList("113.88.97.173", "106.11.154.33", "207.46.13.149",
            "42.156.137.120", "203.208.60.0", "119.39.47.182", "171.34.179.4", "111.175.58.52", "124.235.138.199",
            "175.184.166.184");
    //虚拟结点数量100
    private static final Integer VIRTUAL_NODES = 100;

    public static void main(String[] args) {

        // 遍历服务器ip，生成对应的虚拟结点，存储在TreeMap的数据结构中
        TreeMap<Integer, String> nodeMap = new TreeMap<Integer, String>();
        for (String serverIp : PrincessConfig.SERVER_IP_LIST) {
            for (int i = 0; i < VIRTUAL_NODES; i++) {
                nodeMap.put(getHash(serverIp + "VN" + i), serverIp);
            }
        }

        for (String clientIp : CLIENT_IP_LIST) {
            // 这里利用的TreeMap的特性
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

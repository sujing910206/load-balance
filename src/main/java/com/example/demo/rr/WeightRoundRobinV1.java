package com.example.demo.rr;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.common.PrincessConfig;

/**
 * *权重轮询实现一
 * 
 * @author sullivan
 *
 */
public class WeightRoundRobinV1 {

    // 记录循环的位置
    private static Integer index = 0;

    public static void main(String[] args) {
        for (int i = 0; i < 11; i++) {
            System.out.println(getPrincess1());
        }
    }

    private static String getPrincess1() {

        // 遍历map放入到list中
        List<String> princessList = new ArrayList<String>();
        for (String princess : PrincessConfig.PRINCESS_MAP.keySet()) {
            int weight = PrincessConfig.PRINCESS_MAP.get(princess);
            // 根据权重值重复放入到一个list中
            for (int i = 0; i < weight; i++) {
                princessList.add(princess);
            }
        }

        if (index >= princessList.size()) {
            index = 0;
        }
        String princess = princessList.get(index);

        index++;

        return princess;
    }
}

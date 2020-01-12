package com.example.demo.rr;

import com.example.demo.common.PrincessConfig;

/**
 * *权重轮询实现二
 * 
 * @author sullivan
 *
 */
public class WeightRoundRobinV2 {

    // 记录循环的位置
    private static Integer indexInteger = 0;

    public static void main(String[] args) {
        for (int i = 0; i < 11; i++) {
            System.out.println(getPrincess2());
        }
    }

    private static String getPrincess2() {
        //记录总权重值
        int totalWeight = 0;
        for (String princess : PrincessConfig.PRINCESS_MAP.keySet()) {
            int weight = PrincessConfig.PRINCESS_MAP.get(princess);
            totalWeight += weight;
        }

        // 归零
        if (indexInteger >= totalWeight) {
            indexInteger = 0;
        }

        int index = indexInteger;
        String result = null;
        for (String princess : PrincessConfig.PRINCESS_MAP.keySet()) {
            int weight = PrincessConfig.PRINCESS_MAP.get(princess);

            // 落在当前区间 直接返回
            if (index < weight) {

                result = princess;
                break;
            }

            // 没有落在当前区间 继续循环
            index = index - weight;

        }

        indexInteger++;
        return result;
    }
}

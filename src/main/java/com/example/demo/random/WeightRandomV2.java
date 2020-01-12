package com.example.demo.random;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.example.demo.common.PrincessConfig;

/**
 * *权重随机实现二
 * 
 * @author sullivan
 *
 */
public class WeightRandomV2 {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(getPrincess2());
        }
    }

    /**
     * *可以把权重值计算成占比方式
     *  50-10-20-30 
     *  0_____50_60__80__110
     * 
     * *这样可以随机一个0-110之间的数字 看随机数落在哪个区间
     * 
     * @return
     */
    private static String getPrincess2() {

        List<String> princessList = new ArrayList<String>();
        int totalWeight = 0;
        for (String princess : PrincessConfig.PRINCESS_MAP.keySet()) {
            int weight = PrincessConfig.PRINCESS_MAP.get(princess);
            totalWeight += weight;
            for (int i = 0; i < weight; i++) {
                princessList.add(princess);
            }
        }

        Random rd = new Random();
        int index = rd.nextInt(totalWeight);

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
        return result;
    }
}

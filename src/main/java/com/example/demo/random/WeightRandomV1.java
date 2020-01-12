package com.example.demo.random;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.example.demo.common.PrincessConfig;

/**
 * *权重随机实现一
 * 
 * @author sullivan
 *
 */
public class WeightRandomV1 {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(getPrincess());
        }
    }

    /**
     * *实际开发中权重值一般会配置比较大，如100、200等，这样会更灵活。如果按照这种方式需要往临时集合里面增加很多数据，影响内存占用和性能。
     * 
     * @return
     */
    private static String getPrincess() {

        List<String> princessList = new ArrayList<String>();
        for (String princess : PrincessConfig.PRINCESS_MAP.keySet()) {
            int weight = PrincessConfig.PRINCESS_MAP.get(princess);

            for (int i = 0; i < weight; i++) {
                princessList.add(princess);
            }
        }

        Random rd = new Random();
        int index = rd.nextInt(princessList.size());
        return princessList.get(index);
    }
}

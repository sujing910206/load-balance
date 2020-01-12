package com.example.demo.random;

import java.util.Random;

import com.example.demo.common.PrincessConfig;

/**
 * *普通随机
 * 
 * *普通随机存在的问题就是无法考虑机器性能
 * 
 * @author sullivan
 *
 */
public class RandomV1 {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(getPrincess());
        }
    }

    /**
     *  *随机获取侍寝妃子
     * @return
     */
    private static String getPrincess() {
        Random rd = new Random();
        int index = rd.nextInt(PrincessConfig.PRINCESS_LIST.size());
        return PrincessConfig.PRINCESS_LIST.get(index);
    }
}

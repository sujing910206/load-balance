package com.example.demo.rr;

import com.example.demo.common.PrincessConfig;

/**
 * *普通轮询
 * 
 * *普通轮询存在的问题就是无法考虑机器性能
 * 
 * @author sullivan
 *
 */
public class RoundRobinV1 {

    // 记录循环的位置
    private static Integer index = 0;

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(getPrincess());
        }
    }

    private static String getPrincess() {
        // 超过数组大小需要归零（每次获取前判断，防止配置变化导致索引越界）
        if (index >= PrincessConfig.PRINCESS_LIST.size()) {
            index = 0;
        }

        String princess = PrincessConfig.PRINCESS_LIST.get(index);

        index++;

        return princess;
    }
}

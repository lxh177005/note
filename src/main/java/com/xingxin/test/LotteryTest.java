package com.xingxin.test;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * @author liuxh
 * @date 2021/11/25
 */
public class LotteryTest {
    public static void main(String[] args) {


        List<Pack> packs = Arrays.asList(
                new Pack("A", 60),
                new Pack("B", 10),
                new Pack("C", 1)
        );

        ArrayList<Pack> result = new ArrayList<>();
        for (int j = 0; j < 10000000; j++) {
            Pack pack = chooseLottery(packs);
            if (pack != null) {
                result.add(pack);
            }
        }
        result.stream().collect(Collectors.groupingBy(Pack::getPackName, Collectors.counting()))
                .forEach((k, v) -> System.out.println(k + "=" + v));
        System.out.println(result.size());

    }

    private static Pack chooseLottery(List<Pack> packs) {
        Integer totalProbability = packs.stream().map(Pack::getProbability).reduce(Integer::sum).orElse(0);
        Random random = new Random();
        // 1-100随机数
        int rand = random.nextInt(100) + 1;
        // 未中奖区间
        if (rand > totalProbability) {
            return null;
        }
        // 初始化中奖率区间
        int endProbability = 0;
        for (Pack pack : packs) {
            endProbability += pack.getProbability();
            if (rand <= endProbability) {
                return pack;
            }
        }
        return null;
    }

}

@Data
@AllArgsConstructor
class Pack {
    private String packName;
    private Integer probability;
}
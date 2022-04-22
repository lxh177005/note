package com.xingxin.test;

import com.xingxin.entity.Bin;
import org.apache.poi.ss.formula.functions.Roman;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

/**
 * @author liuxh
 * @date 2022/2/19
 */
public class ChhTest {
    public static void main(String[] args) {
        BigDecimal bigDecimal = new BigDecimal(2).divide(new BigDecimal(3), 2, RoundingMode.HALF_DOWN);
        System.out.println("bigDecimal = " + bigDecimal);

        Random random = new Random();
    }
}

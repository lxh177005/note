package com.xingxin.test;







import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import lombok.ToString;
import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author liuxh
 * @date 2021/8/24
 */
public class bsTest {
    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1, 2, 3);
        List<Integer> list2 = Arrays.asList(2, 5, 8);
        ArrayList<Object> list3 = new ArrayList<>();
        System.out.println(CollectionUtils.containsAny(list1, list2));
        System.out.println(CollectionUtils.containsAny(list1, list3));
        System.out.println(CollectionUtils.containsAny(list3, list1));
        System.out.println(CollectionUtils.containsAny(list3, list3));

        String str =  "2w2RYE45iahnF4aiaJ7pHKCJ3Hwnbgnq2PH3AfpQVyWZNHKS9wNgAAOUfCVt9XZMetogNHwc";
        System.out.println(str.length());

        List<Integer> collect = list1.stream().filter(as -> as > 3).collect(Collectors.toList());
        boolean empty = collect.isEmpty();
        System.out.println("empty = " + empty);
        System.out.println("collect = " + collect);
        collect.forEach(System.out::print);

//        Integer i = null;
//        System.out.println( 1 == i);
        String json = "{\"hasUserPickUp\":true, \"hasShopDelivery\": true}";
        DeliveryModeVO deliveryModeVO = JSONObject.parseObject(json, DeliveryModeVO.class);
        System.out.println("deliveryModeVO = " + deliveryModeVO);

        String str1 = "asdfdsadgdagsdf \n sdfdsgagsd";
        System.out.println("str1 = " + str1);

        double a = 1.0;
        int b = 1;
        double c = Double.parseDouble(String.valueOf(b));
        System.out.println(Objects.equals(a, c));

        String string = "1,1";
        List<String> strings = Arrays.asList(string.split(","));
        System.out.println("strings = " + strings);

        double d = 0.0;
        boolean b1 = d % 2 == 0;
        System.out.println("b1 = " + b1);
        System.out.println(d / 2);

        int i = 3;
        System.out.println( 99 /2);

        String s = "123";
        String[] split = s.split(",");
        System.out.println("split = " + Arrays.toString(split));
        List<String> strings1 = Arrays.asList(split);
        System.out.println("strings1 = " + strings1);
        boolean empty1 = strings1.isEmpty();
        System.out.println("empty1 = " + empty1);

        int ii = 1;
        System.out.println(ii /2);

        Integer integer = null;

        Integer integer1 = 1;
        System.out.println(Objects.equals(integer1, integer));

        double d1 = 3.00;
        double ceil = Math.ceil(d1);
        System.out.println("ceil = " + ceil);
        int ceil1 = (int) ceil;
        System.out.println("ceil1 = " + ceil1);


    }

    @Data
    @ToString
    public static class DeliveryModeVO {
        private Boolean hasUserPickUp = false;
        private Boolean hasShopDelivery  = false;
        private Boolean hasCityDelivery  = false;
        private Boolean hasNoDelivery = false;
    }
}

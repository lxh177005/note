package com.xingxin.test;







import com.alibaba.fastjson.JSONObject;
import com.xingxin.enums.YesOrNoEnum;
import lombok.Data;
import lombok.ToString;
import ma.glasnost.orika.impl.util.StringUtil;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author liuxh
 * @date 2021/8/24
 */
public class bsTest {
    public static void main(String[] args) {

//        {"time":"1636983109000"}
        LocalDateTime localDateTime = LocalDateTime.ofEpochSecond(1636983109, 0, ZoneOffset.ofHours(8));
        System.out.println("localDateTime = " + localDateTime);


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

        String str2 = " afsadf\n\n\n  sfdas  ";
        String replace = str2.replace("\n", "");
        System.out.println("replace = " + replace);
        String trim = str2.trim();
        System.out.println("trim = " + trim);
        String s1 = StringUtils.trimToEmpty(str1);
        System.out.println("s1 = " + s1);
        String s2 = str2.replaceFirst(" ", "");
        System.out.println("s2 = " + s2);

        String s3 = str2.trim().replaceAll("\\s*|\t|\r|\n", "");
        System.out.println(s3);

        String s5 = "   AA \n BB \n CC \n ";
        System.out.println("s5 = " + s5);
        String trim1 = s5.trim().replace("\n", "");
        System.out.println(trim1);

        List<Integer> l3 = Arrays.asList(1, 2, 3);
        List<String> l4 = new ArrayList<>();

        System.out.println("l4 = " + l4);

        Integer value = YesOrNoEnum.YES.value();
        System.out.println("value = " + value);
        Integer value1 = YesOrNoEnum.NO.value();
        System.out.println("value1 = " + value1);


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

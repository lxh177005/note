package com.xingxin.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xingxin.enums.SendPrizeEnum;
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

        List<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(3);
        integers.add(5);
        List<Integer> integers2 = new ArrayList<>();
        integers2.add(1);
        integers2.add(3);
        integers2.add(5);
        integers.removeAll(integers2);
        System.out.println("integers2 = " + JSON.toJSONString(integers));



        Long shopId = null;
        boolean equals = Objects.equals(shopId, 1L);
        System.out.println("equals = " + equals);


        String abc = "您已签到${signDaysCount}天，再签到${nextSignDay}天立享";
        StringUtils.replace(abc, "${signDaysCount}", "1");
        System.out.println("abc = " + abc);


        String s324 = "{\"stream\":\"lottery.award\",\"id\":{\"sequence\":0,\"value\":\"1638090804524-0\",\"timestamp\":1638090804524},\"value\":{\"awardLogIds\":\"[106]\"}}";


        String s123 = "{\"amount\":\"0\",\"body\":\"{\\\"id\\\":\\\"274800476405383168\\\",\\\"transactionNumber\\\":\\\"274800476405383169\\\",\\\"amount\\\":\\\"0\\\",\\\"transactionDate\\\":\\\"2021-11-28T15:19:36.1416225+08:00\\\",\\\"transactionType\\\":\\\"pointsConversion\\\",\\\"hotel\\\":{\\\"code\\\":\\\"000001\\\",\\\"name\\\":\\\"浙江宝盛酒店管理公司\\\"},\\\"place\\\":{\\\"code\\\":\\\"0004\\\",\\\"name\\\":\\\"悦活商城\\\"},\\\"description\\\":\\\"抽奖活动奖励积分\\\",\\\"got\\\":{\\\"pointsAccountHistory\\\":[{\\\"id\\\":\\\"274800476405383171\\\",\\\"type\\\":\\\"UD_Sign\\\",\\\"points\\\":\\\"88\\\",\\\"isFee\\\":\\\"False\\\",\\\"description\\\":\\\"抽奖活动奖励积分\\\"}]},\\\"used\\\":{\\\"pointsAccountHistory\\\":[]}}\",\"httpCode\":200,\"id\":\"274800476405383168\",\"success\":true,\"transactionDate\":\"2021-11-28T15:19:36.1416225+08:00\",\"transactionNumber\":\"274800476405383169\",\"transactionType\":\"pointsConversion\"}";
        System.out.println(s123.length());

        String str111 = "{\n" +
                                "    \"amount\":\"50.00\",\n" +
                                "    \"body\":\"{\\\"id\\\":\\\"274795840915128320\\\",\\\"transactionNumber\\\":\\\"274795837484187648\\\",\\\"amount\\\":\\\"50.00\\\",\\\"transactionDate\\\":\\\"2021-11-28T15:01:11.007+08:00\\\",\\\"transactionType\\\":\\\"topup\\\",\\\"hotel\\\":{\\\"code\\\":\\\"000001\\\",\\\"name\\\":\\\"浙江宝盛酒店管理公司\\\"},\\\"place\\\":{\\\"code\\\":\\\"0004\\\",\\\"name\\\":\\\"悦活商城\\\"},\\\"description\\\":\\\"抽奖活动奖励会员余额\\\",\\\"got\\\":{\\\"storedValueAccountHistory\\\":[{\\\"id\\\":\\\"274795841573634048\\\",\\\"accountId\\\":\\\"240761571083567104\\\",\\\"membershipCardId\\\":\\\"230213441594343424\\\",\\\"type\\\":\\\"renewalFee\\\",\\\"amount\\\":\\\"50.00\\\",\\\"lastBalance\\\":\\\"806.69\\\",\\\"thisBalance\\\":\\\"856.69\\\",\\\"description\\\":\\\"本次业务单操作会员卡id:230213441594343424 本次共充值:50，会员卡 990188295381 充值:50，账户 赠送账户 充值:50 备注：抽奖活动奖励会员余额\\\",\\\"historyId\\\":\\\"\\\",\\\"revenueType\\\":\\\"other\\\",\\\"isVoid\\\":false,\\\"sourceCode\\\":\\\"JTWEC\\\"}],\\\"pointsAccountHistory\\\":[],\\\"couponTransactionHistory\\\":[],\\\"mileagesHistory\\\":[],\\\"giftCardHistory\\\":[],\\\"privilegeHistory\\\":[]},\\\"used\\\":{\\\"storedValueAccountHistory\\\":[],\\\"pointsAccountHistory\\\":[],\\\"couponTransactionHistory\\\":[],\\\"mileagesHistory\\\":[],\\\"giftCardHistory\\\":[],\\\"privilegeHistory\\\":[]}}\",\n" +
                                "    \"httpCode\":200,\n" +
                                "    \"id\":\"274795840915128320\",\n" +
                                "    \"success\":true,\n" +
                                "    \"transactionDate\":\"2021-11-28T15:01:11.007+08:00\",\n" +
                                "    \"transactionNumber\":\"274795837484187648\",\n" +
                                "    \"transactionType\":\"topup\"\n" +
                                "}";
        System.out.println(str111.length());

        String impl = SendPrizeEnum.getImpl(6);
        System.out.println(impl + "123");


//        {"time":"1636983109000"}
        LocalDateTime localDateTime = LocalDateTime.ofEpochSecond(1641798000, 0, ZoneOffset.ofHours(8));
        System.out.println("localDateTime = " + localDateTime);


        List<Integer> list1 = Arrays.asList(1, 2, 3);
        List<Integer> list2 = Arrays.asList(2, 5, 8);
        ArrayList<Object> list3 = new ArrayList<>();
        System.out.println(CollectionUtils.containsAny(list1, list2));
        System.out.println(CollectionUtils.containsAny(list1, list3));
        System.out.println(CollectionUtils.containsAny(list3, list1));
        System.out.println(CollectionUtils.containsAny(list3, list3));


        String string1 = JSON.toJSONString(list1);
        System.out.println("string1 = " + string1);
        List<Integer> list = JSONObject.parseArray(string1, Integer.class);
        System.out.println("list = " + list);

        String str = "2w2RYE45iahnF4aiaJ7pHKCJ3Hwnbgnq2PH3AfpQVyWZNHKS9wNgAAOUfCVt9XZMetogNHwc";
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
        System.out.println(99 / 2);

        String s = "123";
        String[] split = s.split(",");
        System.out.println("split = " + Arrays.toString(split));
        List<String> strings1 = Arrays.asList(split);
        System.out.println("strings1 = " + strings1);
        boolean empty1 = strings1.isEmpty();
        System.out.println("empty1 = " + empty1);

        int ii = 1;
        System.out.println(ii / 2);

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
        private Boolean hasShopDelivery = false;
        private Boolean hasCityDelivery = false;
        private Boolean hasNoDelivery = false;
    }
}

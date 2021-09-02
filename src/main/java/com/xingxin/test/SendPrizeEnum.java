package com.xingxin.test;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author liuxh
 * @date 2021/8/26
 */
@Getter
@AllArgsConstructor
public enum SendPrizeEnum {
    SCORE(1, "sendScorePrizeTemplate", "积分"),
    COUPON(2, "sendCouponPrizeTemplate", "优惠券"),
    VIRTUAL_COUPON(3, "sendVirtualCouponPrizeTemplate", "西软卡券"),
    VIP_AMOUNT(4, "sendVipAmountPrizeTemplate", "会员余额"),
    CASH(5, "sendCashPrizeTemplate", "现金红包");

    private final Integer prizeType;
    private final String impl;
    private final String desc;

    public static String getImpl(Integer prizeType) {
        SendPrizeEnum[] enums = values();
        for (SendPrizeEnum typeEnum : enums) {
            if (typeEnum.prizeType.equals(prizeType)) {
                return typeEnum.impl;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        String impl = SendPrizeEnum.getImpl(1);
        String impl2 = SendPrizeEnum.getImpl(5);
        System.out.println("impl2 = " + impl2);
        System.out.println("impl = " + impl);
        String str = "{\"id\":\"241176814800617472\",\"transactionNumber\":\"241176812518916096\",\"amount\":\"10.00\",\"transactionDate\":\"2021-08-27T20:35:30.98+08:00\",\"transactionType\":\"topup\",\"hotel\":{\"code\":\"000001\",\"name\":\"浙江宝盛酒店管理公司\"},\"place\":{\"code\":\"0004\",\"name\":\"悦活商城\"},\"description\":\"签到奖励会员余额\",\"got\":{\"storedValueAccountHistory\":[{\"id\":\"241176815337488384\",\"accountId\":\"240761571083567104\",\"membershipCardId\":\"230213441594343424\",\"type\":\"renewalFee\",\"amount\":\"10.00\",\"lastBalance\":\"10.00\",\"thisBalance\":\"20.00\",\"description\":\"本次业务单操作会员卡id:230213441594343424 本次共充值:10，会员卡 990188295381 充值:10，账户 赠送账户 充值:10 备注：签到奖励会员余额\",\"historyId\":\"\",\"revenueType\":\"other\",\"isVoid\":false,\"sourceCode\":\"JTWEC\"}],\"pointsAccountHistory\":[],\"couponTransactionHistory\":[],\"mileagesHistory\":[],\"giftCardHistory\":[],\"privilegeHistory\":[]},\"used\":{\"storedValueAccountHistory\":[],\"pointsAccountHistory\":[],\"couponTransactionHistory\":[],\"mileagesHistory\":[],\"giftCardHistory\":[],\"privilegeHistory\":[]}}";
        System.out.println(str.length());

    }
}

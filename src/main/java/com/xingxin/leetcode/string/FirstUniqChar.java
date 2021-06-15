package com.xingxin.leetcode.string;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liuxh
 * @date 2021/5/28
 *
 * 字符串中的第一个唯一字符
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 * 示例：
 * s = "leetcode"
 * 返回 0
 * s = "loveleetcode"
 * 返回 2
 */
public class FirstUniqChar {

    /**
     * java api 处理 建议
     *
     * @param str
     * @return int
     */
    public static int firstUniqChar(String str) {
        for (int i = 0; i < str.length(); i++) {
            //charAt 返回下表处的字符
            //indexOf 返回字符第一次出现的位置
            //lastIndexOf 返回字符串最后一次出现的位置
            // 如果第一次出现和最后一次出现的位置相同，说明字符唯一，反之不唯一
            if (str.indexOf(str.charAt(i)) == str.lastIndexOf(str.charAt(i))) {
                return i;
            }
        }
        return -1;
    }

    /**
     * hash表记录重复
     * 时间复杂度 O(N) 空间复杂度O(n)
     * @param str
     * @return int
     */
    public static int firstUniqChar1(String str) {
        int length = str.length();
        Map<String, Integer> map = new HashMap<>(length);
        for (int i = 0; i < length; i++) {
            String key = String.valueOf(str.charAt(i));
            //如果存在就把value+1
            if (map.containsKey(key)) {
                map.put(key, map.get(key) + 1);
            }else {
                //不存在添加
                map.put(key, 1);
            }
        }
        //遍历，取第一个value=1的返回
        for (int i = 0; i < length; i++) {
             if ( map.get( String.valueOf(str.charAt(i))) ==1) {
                 return i;
             }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(firstUniqChar("leetcode"));
        System.out.println(firstUniqChar("loveleetcode"));
        System.out.println("---------------------------");
        System.out.println(firstUniqChar1("leetcode"));
        System.out.println(firstUniqChar1("loveleetcode"));
    }
}

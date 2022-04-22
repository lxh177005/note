package com.xingxin.leetcode.leetcode;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 *  
 *
 * 示例 1：
 *
 * 输入：s = "()"
 * 输出：true
 * 示例 2：
 *
 * 输入：s = "()[]{}"
 * 输出：true
 * 示例 3：
 *
 * 输入：s = "(]"
 * 输出：false
 * 示例 4：
 *
 * 输入：s = "([)]"
 * 输出：false
 * 示例 5：
 *
 * 输入：s = "{[]}"
 * 输出：true
 *
 * @author liuxh
 * @date 2021/6/29
 */
public class IsValid {

    private static boolean isValid(String s) {
        //先把特殊字符存入map中
        HashMap<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        // 利用栈 先进后出，判断
        LinkedList<Character> stack = new LinkedList<>();
        for (Character c : s.toCharArray()) {
            if (map.containsKey(c)) {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }else {
                stack.push(c);
            }
        }

        return false;
    }

    public static void main(String[] args) {
    }
}

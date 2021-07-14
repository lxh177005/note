package com.xingxin.test;

/**
 * 枚举的使用
 * @author liuxh
 * @date 2021/7/14
 */
public enum ColorEnum {
    RED, GREEN, BLANK, YELLOW
}

class Test {
    public static void main(String[] args) {
//        Color color = Color.RED;
//        String s = color.toString();
//        System.out.println("s = " + s);
        ColorEnum color = ColorEnum.valueOf("RED");
        chooseColor(color);
    }

    private static void chooseColor(ColorEnum color) {
        switch (color){
            case RED:
                System.out.println("red");
                break;
            case BLANK:
                System.out.println("blank");
                break;
            default:
                System.out.println("other");
                break;
        }
    }
}

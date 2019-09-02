package com.fxn.compilejar;

public class toolUtils {
    //当前项目类型
    public static String getTypeWith(String type) {
        String typeString = "";
        switch (type) {
            case "0":
                typeString = "未提交";
                break;
            case "1":
                typeString = "未审核";
                break;
            case "2":
                typeString = "已驳回";
                break;
            case "4":
                typeString = "进行中";
                break;
            case "5":
                typeString = "已挂起";
                break;
            case "6":
                typeString = "已解挂";
                break;
            case "8":
                typeString = "已终止";
                break;
            case "9":
                typeString = "已完成";
                break;
        }
        return typeString;
    }
}

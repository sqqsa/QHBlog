package com.qing.enums;

public enum AppHttpCodeEnum {
    // 成功
    SUCCESS(200,"操作成功"),
    // 登录
    NEED_LOGIN(401,"需要登录后操作"),
    NO_OPERATOR_AUTH(403,"无权限操作"),
    SYSTEM_ERROR(500,"出现错误"),
    USERNAME_EXIST(501,"用户名已存在"),
    PHONENUMBER_EXIST(502,"手机号已存在"), EMAIL_EXIST(503, "邮箱已存在"),
    REQUIRE_USERNAME(504, "必需填写用户名"),
    USERNAME_NOT_NULL(508, "用户名不能为空"),
    NICKNAME_NOT_NULL(509, "昵称不能为空"),
    PASSWORD_NOT_NULL(510, "密码不能为空"),
    EMAIL_NOT_NULL(511, "邮箱不能为空"),
    NICKNAME_EXIST(512, "昵称已存在"),
    LOGIN_ERROR(505,"用户名或密码错误"),
    CONTENT_NOT_NULL(506,"评论为空"),

    TAGNAME_NOT_NULL(601,"标签名称为空"),
    TAGNAME_EXIST(602,"标签名称已存在"),

    MENUNAME_NOT_NULL(603,"菜单名称为空"),
    MENUNAME_EXIST(604,"菜单名称已存在"),

    MENUCOMPONENT_NOT_NULL(605,"菜单路径为空"),
    MENUCOMPONENT_EXIST(606,"菜单路径已存在"),

    MENUICON_NOT_NULL(607,"菜单图标为空"),
    MENUICON_EXIST(608,"菜单图标已存在"),

    MENUNAME_ERROR(609,"父级菜单名称不能为当前菜单");

    int code;
    String msg;

    AppHttpCodeEnum(int code, String errorMessage){
        this.code = code;
        this.msg = errorMessage;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}

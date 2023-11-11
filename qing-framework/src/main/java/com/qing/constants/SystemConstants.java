package com.qing.constants;

public class SystemConstants
{

    public static  String STATUS_NORMAL = "0";
    /**
     *  文章是草稿
     */
    public static final int ARTICLE_STATUS_DRAFT = 1;
    /**
     *  文章是正常分布状态
     */
    public static final int ARTICLE_STATUS_NORMAL = 0;
    /*
    * 正常状态的分类
    * */
    public static  String CATEGORY_STATUS_NORMAL = "0";

    /*
    * 友情链接已经审核
    * */
    public static  String LINK_STATUS_NORMAL = "0";

    public static  int COMMENT_STATUS_ROOT = -1;

    /*
     * 文章评论
     * */
    public static  String ARTICLE_COMMENT = "0";

    /*
     * 友链评论
     * */
    public static  String LINK_COMMENT = "1";
    //博客id和浏览量
    public static  String ARTICLE_VIEWCOUNT = "article:viewCount";

    public static final String MENU = "C";
    public static final String BUTTON = "F";

    /*
     * 父级菜单
     * */
    public static  final int  MENU_COMMENT = 0;

    /*
    * 删除状态
    * */
    public static String DEL_FLAG = "1";
}
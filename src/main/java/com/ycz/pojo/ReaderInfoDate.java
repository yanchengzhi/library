package com.ycz.pojo;

/**
 * 
 * @ClassName ReaderInfoDate
 * @Description TODO(此类处理读者出生日期)
 * @author Administrator
 * @Date 2020年3月28日 下午5:07:23
 * @version 1.0.0
 */
public class ReaderInfoDate extends ReaderInfo {

    /**
     * @Field @serialVersionUID : TODO(这里用一句话描述这个类的作用)
     */
    private static final long serialVersionUID = 1L;
    
    private String birthStr;//只有一个字段，读者出生日期字符串形式

    
    public String getBirthStr() {
        return birthStr;
    }

    
    public void setBirthStr(String birthStr) {
        this.birthStr = birthStr;
    }
    
}

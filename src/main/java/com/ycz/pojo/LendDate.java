package com.ycz.pojo;

/**
 * 
 * @ClassName LendDate
 * @Description TODO(借归日期类，此类继承Lend类)
 * @author Administrator
 * @Date 2020年3月28日 下午4:57:51
 * @version 1.0.0
 */
public class LendDate extends Lend {
    
    /**
     * @Field @serialVersionUID : TODO(这里用一句话描述这个类的作用)
     */
    private static final long serialVersionUID = 1L;
    
    
    private String lendDatestr;//借出日期，字符串表示
    private String backDateStr;//归还日期，字符串表示
    
    public String getLendDatestr() {
        return lendDatestr;
    }
    
    public void setLendDatestr(String lendDatestr) {
        this.lendDatestr = lendDatestr;
    }
    
    public String getBackDateStr() {
        return backDateStr;
    }
    
    public void setBackDateStr(String backDateStr) {
        this.backDateStr = backDateStr;
    }
    
    

}

package com.ycz.pojo;

/**
 * 
 * @ClassName LendDate
 * @Description TODO(��������࣬����̳�Lend��)
 * @author Administrator
 * @Date 2020��3��28�� ����4:57:51
 * @version 1.0.0
 */
public class LendDate extends Lend {
    
    /**
     * @Field @serialVersionUID : TODO(������һ�仰��������������)
     */
    private static final long serialVersionUID = 1L;
    
    
    private String lendDatestr;//������ڣ��ַ�����ʾ
    private String backDateStr;//�黹���ڣ��ַ�����ʾ
    
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

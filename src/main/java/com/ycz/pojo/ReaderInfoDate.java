package com.ycz.pojo;

/**
 * 
 * @ClassName ReaderInfoDate
 * @Description TODO(���ദ����߳�������)
 * @author Administrator
 * @Date 2020��3��28�� ����5:07:23
 * @version 1.0.0
 */
public class ReaderInfoDate extends ReaderInfo {

    /**
     * @Field @serialVersionUID : TODO(������һ�仰��������������)
     */
    private static final long serialVersionUID = 1L;
    
    private String birthStr;//ֻ��һ���ֶΣ����߳��������ַ�����ʽ

    
    public String getBirthStr() {
        return birthStr;
    }

    
    public void setBirthStr(String birthStr) {
        this.birthStr = birthStr;
    }
    
}

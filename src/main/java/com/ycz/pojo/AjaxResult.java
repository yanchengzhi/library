package com.ycz.pojo;

/**
 * 
 * @ClassName AjaxResult
 * @Description TODO(这个类用来代表后端的处理结果)
 * @author Administrator
 * @Date 2020年3月27日 下午9:07:40
 * @version 1.0.0
 */
public class AjaxResult {
	
	private boolean success;
	private Object data;

    public Object getData() {
        return data;
    }

    
    public void setData(Object data) {
        this.data = data;
    }

    public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}
	
}

package com.ycz.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ycz.pojo.AjaxResult;
import com.ycz.pojo.Lend;
import com.ycz.pojo.Page;
import com.ycz.service.LendService;

/**
 * 
 * @ClassName LendController
 * @Description TODO(�軹��־������)
 * @author Administrator
 * @Date 2020��3��31�� ����5:26:57
 * @version 1.0.0
 */
@Controller
@RequestMapping("/lend/")
public class LendController {
    
    @Autowired
    private LendService lService;
    
    /**
     * 
     * @Description (�����軹��־ҳ��)
     * @return
     */
    @RequestMapping("lendList")
    public String lendList() {
        return "admin_lend_list";
    }
    
    /**
     * 
     * @Description (��ҳ��ѯ�軹��־)
     * @param queryText
     * @param page
     * @param pageSize
     * @return
     */
    @ResponseBody
    @RequestMapping("queryLendPaged")
    public AjaxResult queryLendPaged(
            @RequestParam(value="queryText",required = false) String queryText,
            @RequestParam(value="page",required = false,defaultValue = "1") Integer page,
            @RequestParam(value="pageSize",required = false,defaultValue = "10") Integer pageSize
            ) {
        AjaxResult result = new AjaxResult();
        try {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("start", (page - 1) * pageSize);
            map.put("size", pageSize);
            map.put("queryText",queryText);
            List <Lend> lends = lService.queryLendPaged(map);
            //��ȡ�ܼ�¼����
            int totalSize = lService.countLends(map);
            //��ȡ���ҳ����
            int maxPage = totalSize%pageSize==0?totalSize/pageSize:(totalSize/pageSize)+1;
            //ʹ�÷�ҳ�����װ
            Page<Lend> lendPage = new Page<>();
            lendPage.setDatas(lends);
            lendPage.setTotalSize(totalSize);
            lendPage.setMaxPage(maxPage);
            lendPage.setPage(page);
            //��װ��result������
            result.setData(lendPage);
            result.setSuccess(true);
        } catch (Exception e) {
            e.printStackTrace();
            result.setSuccess(false);
        }
        return result;
    }
    
    /**
     * 
     * @Description (ɾ���軹��¼)
     * @param serNum
     * @return
     */
    @ResponseBody
    @RequestMapping("deleteLend")
    public AjaxResult deleteLend(long serNum) {
        AjaxResult result = new AjaxResult();
        try {
            lService.deleteLend(serNum);
            result.setSuccess(true);
        } catch (Exception e) {
            e.printStackTrace();
            result.setSuccess(false);
        }
        return result;
    }
    
    @RequestMapping("readerLendList")
    public ModelAndView readerLendList(long readerId) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("readerId",readerId);
        mav.setViewName("reader_lend_list");
        return mav;
    }

}

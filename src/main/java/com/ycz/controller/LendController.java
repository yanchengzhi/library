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
 * @Description TODO(借还日志控制器)
 * @author Administrator
 * @Date 2020年3月31日 下午5:26:57
 * @version 1.0.0
 */
@Controller
@RequestMapping("/lend/")
public class LendController {
    
    @Autowired
    private LendService lService;
    
    /**
     * 
     * @Description (跳往借还日志页面)
     * @return
     */
    @RequestMapping("lendList")
    public String lendList() {
        return "admin_lend_list";
    }
    
    /**
     * 
     * @Description (分页查询借还日志)
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
            //获取总记录条数
            int totalSize = lService.countLends(map);
            //获取最大页码数
            int maxPage = totalSize%pageSize==0?totalSize/pageSize:(totalSize/pageSize)+1;
            //使用分页对象封装
            Page<Lend> lendPage = new Page<>();
            lendPage.setDatas(lends);
            lendPage.setTotalSize(totalSize);
            lendPage.setMaxPage(maxPage);
            lendPage.setPage(page);
            //封装进result对象里
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
     * @Description (删除借还记录)
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

package com.ycz.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ycz.pojo.AjaxResult;
import com.ycz.pojo.Page;
import com.ycz.pojo.ReaderCard;
import com.ycz.pojo.ReaderInfo;
import com.ycz.service.ReaderService;

/**
 * 
 * @ClassName ReaderController
 * @Description TODO(���߿�����)
 * @author Administrator
 * @Date 2020��3��30�� ����9:00:43
 * @version 1.0.0
 */
@Controller
@RequestMapping("/reader/")
public class ReaderController {
    
    @Autowired
    private ReaderService rService;
    
    /**
     * 
     * @Description (����������߽���)
     * @return
     */
    @RequestMapping("adminReader")
    public String adminReader() {
        return "admin_reader";
    }
    
    /**
     * 
     * @Description (��ҳ��ѯ����)
     * @param queryText
     * @param page
     * @param pageSize
     * @return
     */
    @ResponseBody
    @RequestMapping("queryReaderPaged")
    public AjaxResult queryReaderPaged(
            @RequestParam(value="queryText",required = false) String queryText,
            @RequestParam(value="page",required = false,defaultValue = "1") Integer page,
            @RequestParam(value="pageSize",required = false,defaultValue = "6") Integer pageSize
            ) {
        AjaxResult result = new AjaxResult();
        try {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("start", (page - 1) * pageSize);
            map.put("size", pageSize);
            map.put("queryText",queryText);
            List<ReaderInfo> readers = rService.queryReadersPaged(map);
            //��ȡ�ܼ�¼����
            int totalSize = rService.countReaders(map);
            //��ȡ���ҳ����
            int maxPage = totalSize%pageSize==0?totalSize/pageSize:(totalSize/pageSize)+1;
            //ʹ�÷�ҳ�����װ
            Page<ReaderInfo> readerPage = new Page<>();
            readerPage.setDatas(readers);
            readerPage.setTotalSize(totalSize);
            readerPage.setMaxPage(maxPage);
            readerPage.setPage(page);
            //��װ��result�����У�����ǰ��
            result.setData(readerPage);
            result.setSuccess(true);
        } catch (Exception e) {
            e.printStackTrace();
            result.setSuccess(false);
        }
        return result;
    }
    
    /**
     * 
     * @Description (�������߱༭ҳ��)
     * @param request
     * @return
     */
    @RequestMapping("adminEditReader")
    public ModelAndView adminEditReader(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        Long readerId = Long.parseLong(request.getParameter("readerId"));
        //������ID��ѯ
        ReaderInfo reader = rService.queryReader(readerId);
        mav.addObject("reader",reader);
        mav.setViewName("admin_edit_reader");
        return mav;
    }
    
    /**
     * 
     * @Description (�޸Ķ�����Ϣ)
     * @param birthStr
     * @param reader
     * @return
     */
    @ResponseBody
    @RequestMapping("editReaderInfo")
    public AjaxResult editReaderInfo(String birthStr, ReaderInfo reader) {
        try {
            reader.setBirth(new SimpleDateFormat("yyyy-MM-dd").parse(birthStr));
        } catch (ParseException e1) {
            e1.printStackTrace();
        }
        AjaxResult result = new AjaxResult();
        try {
            rService.editReader(reader);
            result.setSuccess(true);
        } catch (Exception e) {
            result.setSuccess(false);
        }
        return result;
    }
    
    /**
     * 
     * @Description (ɾ������)
     * @param readerId
     * @return
     */
    @ResponseBody
    @RequestMapping("deleteReader")
    public AjaxResult deleteReader(long readerId) {
        AjaxResult result = new AjaxResult();
        try {
            rService.deleteReader(readerId);
            rService.deleteReaderCard(readerId);
            result.setSuccess(true);
        } catch (Exception e) {
           e.printStackTrace();
           result.setSuccess(false);
        }
        return result;
    }
    
    /**
     * 
     * @Description (�����������ҳ��)
     * @return
     */
    @RequestMapping("adminReaderAdd")
    public String adminReaderAdd() {
        return "admin_reader_add";
    }
    
    @ResponseBody
    @RequestMapping("addReaderInfo")
    public AjaxResult addReaderInfo(String password,String birthStr,ReaderInfo reader) {
        try {
            reader.setBirth(new SimpleDateFormat("yyyy-MM-dd").parse(birthStr));
        } catch (ParseException e1) {
            e1.printStackTrace();
        }
        reader.setAddTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        AjaxResult result = new AjaxResult();
        try {
            rService.addReaderInfo(reader);
            ReaderCard rCard = new ReaderCard();
            rCard.setUsername(reader.getName());
            rCard.setPassword(password);
            rService.addReaderCard(rCard);
            result.setSuccess(true);
        } catch (Exception e) {
            result.setSuccess(false);
        }
        return result;
    }

}

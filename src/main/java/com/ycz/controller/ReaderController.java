package com.ycz.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import com.ycz.pojo.Book;
import com.ycz.pojo.Lend;
import com.ycz.pojo.Page;
import com.ycz.pojo.ReaderCard;
import com.ycz.pojo.ReaderInfo;
import com.ycz.pojo.ResultData;
import com.ycz.service.BookService;
import com.ycz.service.LendService;
import com.ycz.service.ReaderService;

/**
 * 
 * @ClassName ReaderController
 * @Description TODO(读者控制器)
 * @author Administrator
 * @Date 2020年3月30日 下午9:00:43
 * @version 1.0.0
 */
@Controller
@RequestMapping("/reader/")
public class ReaderController {
    
    @Autowired
    private ReaderService rService;
    
    @Autowired
    private BookService bService;
    
    @Autowired
    private LendService lService;
    
    /**
     * 
     * @Description (跳往管理读者界面)
     * @return
     */
    @RequestMapping("adminReader")
    public String adminReader() {
        return "admin_reader";
    }
    
    /**
     * 
     * @Description (分页查询读者)
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
            //获取总记录条数
            int totalSize = rService.countReaders(map);
            //获取最大页码数
            int maxPage = totalSize%pageSize==0?totalSize/pageSize:(totalSize/pageSize)+1;
            //使用分页对象封装
            Page<ReaderInfo> readerPage = new Page<>();
            readerPage.setDatas(readers);
            readerPage.setTotalSize(totalSize);
            readerPage.setMaxPage(maxPage);
            readerPage.setPage(page);
            //封装进result对象中，传给前端
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
     * @Description (跳往读者编辑页面)
     * @param request
     * @return
     */
    @RequestMapping("adminEditReader")
    public ModelAndView adminEditReader(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        Long readerId = Long.parseLong(request.getParameter("readerId"));
        //按传的ID查询
        ReaderInfo reader = rService.queryReader(readerId);
        mav.addObject("reader",reader);
        mav.setViewName("admin_edit_reader");
        return mav;
    }
    
    /**
     * 
     * @Description (修改读者信息)
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
     * @Description (删除读者)
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
     * @Description (跳往读者添加页面)
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
    
    /**
     * 
     * @Description (跳往读者书籍页面)
     * @return
     */
    @RequestMapping("readerBooks")
    public ModelAndView readerBooks() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("reader_books");
        return mav;
    }
    
    /**
     * 
     * @Description (分页查询指定读者借阅的书籍)
     * @param page
     * @param pageSize
     * @param queryText
     * @return
     */
    @ResponseBody
    @RequestMapping("queryLend")
    public AjaxResult queryLendPaged(
            @RequestParam(value="readerId",required = true) long readerId
            ) {
        AjaxResult result = new AjaxResult();
        try {
            //查出所有书籍
            List<Book> books = bService.queryAllBooks();
            //查出读者对应借阅的所有书籍id
            List<Long> bookIds = lService.queryAllBookId(readerId);
            //查出读者对应的所有借还记录
            List<Lend> lends = lService.queryAllLends(readerId);
            //用于封装
            List<ResultData> datas = new ArrayList<>();
            for(Book b:books) {
                for(long bookId:bookIds) {
                    for(Lend l:lends) {
                        if(b.getBookId()==bookId && l.getBookId()==bookId) {
                            ResultData data = new ResultData();
                            data.setBookId(bookId);
                            data.setName(b.getName());
                            data.setLendDateStr(l.getLendDateStr());
                            data.setBackDateStr(l.getBackDateStr());
                            datas.add(data);
                        }
                    }
                }
            }
            result.setData(datas);
            result.setSuccess(true);
        } catch (Exception e) {
            e.printStackTrace();
            result.setSuccess(false);
        }
        return result;
    }
    
    /**
     * 
     * @Description (查询读者信息)
     * @param readerId
     * @return
     */
    @RequestMapping("readerInfo")
    public ModelAndView readerInfo(long readerId) {
        ModelAndView mav = new ModelAndView();
        ReaderInfo reader = rService.queryReader(readerId);
        mav.addObject("currentReader",reader);
        mav.setViewName("reader_info");
        return mav;
    }
    
    /**
     * 
     * @Description (跳往读者修改页面)
     * @return
     */
    @RequestMapping("readerEditSelf")
    public ModelAndView readerEditSelf(long readerId) {
        ModelAndView mav = new ModelAndView();
        ReaderInfo reader = rService.queryReader(readerId);
        mav.addObject("currentReader",reader);
        mav.setViewName("reader_info_edit");
        return mav;
    }
    
    @RequestMapping("readerBookDetail")
    public ModelAndView readerBookDetail(HttpServletRequest request) {
        // 获取要查询书籍的ID
        long bookId = Long.parseLong(request.getParameter("bookId"));
        Book book = bService.queryBook(bookId);
        ModelAndView mav = new ModelAndView();
        mav.addObject("book", book);
        mav.setViewName("reader_book_detail");
        return mav;
    }

}

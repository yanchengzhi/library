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
import com.ycz.pojo.Book;
import com.ycz.pojo.Page;
import com.ycz.service.BookService;

/**
 * @ClassName BookController
 * @Description TODO(图书管理控制器)
 * @author Administrator
 * @Date 2020年3月28日 下午10:15:36
 * @version 1.0.0
 */
@Controller
@RequestMapping("/book/")
public class BookController {

    @Autowired
    private BookService bService;

    /**
     * @Description (跳转到管理员书籍管理界面)
     * @return
     */
    @RequestMapping("adminBook")
    public String adminBook() {
        return "admin_book";
    }

    /**
     * @Description (分页查询书籍)
     * @param queryText
     *            关键字
     * @param page
     *            页码
     * @param pageSize
     *            页记录条数
     * @return
     */
    @ResponseBody
    @RequestMapping("queryBooksPaged")
    public AjaxResult queryBooksPaged(@RequestParam(value = "queryText", required = false) String queryText,
            @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
            @RequestParam(value = "pageSize", required = false, defaultValue = "5") Integer pageSize) {
        AjaxResult result = new AjaxResult();
        try {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("start", (page - 1) * pageSize);
            map.put("size", pageSize);
            map.put("queryText", queryText);
            List<Book> books = bService.queryBooksPaged(map);
            // 获取总记录条数
            int totalSize = bService.countBooks(map);
            // 获取最大页码数
            int maxPage = totalSize % pageSize == 0 ? totalSize / pageSize : (totalSize / pageSize) + 1;
            // 分页对象
            Page<Book> bookPage = new Page<>();
            bookPage.setDatas(books);
            bookPage.setTotalSize(totalSize);
            bookPage.setMaxPage(maxPage);
            bookPage.setPage(page);
            // 封装进result对象中
            result.setData(bookPage);
            result.setSuccess(true);
        } catch (Exception e) {
            e.printStackTrace();
            result.setSuccess(false);
        }
        return result;
    }

    /**
     * @Description (按id查找书籍)
     * @param request
     * @return
     */
    @RequestMapping("adminBookDetail")
    public ModelAndView adminBookDetail(HttpServletRequest request) {
        // 获取要查询书籍的ID
        long bookId = Long.parseLong(request.getParameter("bookId"));
        Book book = bService.queryBook(bookId);
        ModelAndView mav = new ModelAndView();
        mav.addObject("book", book);
        mav.setViewName("admin_book_detail");
        return mav;
    }

    /**
     * @Description (跳转到添加书籍页面)
     * @return
     */
    @RequestMapping("addBook")
    public ModelAndView addBook() {
        return new ModelAndView("admin_add_book");
    }

    /**
     * @Description (添加书籍)
     * @param pubDateStr
     *            前端传过来的数据
     * @param book
     *            前端传过来的数据封装
     * @return
     */
    @ResponseBody
    @RequestMapping("addBookInfo")
    public AjaxResult addBookInfo(String pubDateStr, Book book) {
        try {
            book.setPubDate(new SimpleDateFormat("yyyy-MM-dd").parse(pubDateStr));
        } catch (ParseException e1) {
            e1.printStackTrace();
        }
        book.setAddTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        AjaxResult result = new AjaxResult();
        try {
            bService.addBook(book);
            result.setSuccess(true);
        } catch (Exception e) {
            result.setSuccess(false);
        }
        return result;
    }

    /**
     * @Description (跳往管理员书籍编辑页面)
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping("adminEditBook")
    public ModelAndView adminEditBook(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        Long bookId = Long.parseLong(request.getParameter("bookId"));
        Book book = bService.queryBook(bookId);
        mav.addObject("book", book);
        mav.setViewName("admin_edit_book");
        return mav;
    }

    /**
     * @Description (编辑书籍)
     * @param pubDateStr
     * @param book
     * @return
     */
    @ResponseBody
    @RequestMapping("editBookInfo")
    public AjaxResult editBookInfo(String pubDateStr, Book book) {
        try {
            book.setPubDate(new SimpleDateFormat("yyyy-MM-dd").parse(pubDateStr));
        } catch (ParseException e1) {
            e1.printStackTrace();
        }
        AjaxResult result = new AjaxResult();
        try {
            bService.editBook(book);
            result.setSuccess(true);
        } catch (Exception e) {
            result.setSuccess(false);
        }
        return result;
    }

    @ResponseBody
    @RequestMapping("deleteBook")
    public AjaxResult deleteBook(long bookId) {
        AjaxResult result = new AjaxResult();
        try {
            bService.deleteBook(bookId);
            result.setSuccess(true);
        } catch (Exception e) {
            e.printStackTrace();
            result.setSuccess(false);
        }
        return result;
    }

}

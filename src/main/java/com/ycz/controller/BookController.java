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
 * @Description TODO(ͼ����������)
 * @author Administrator
 * @Date 2020��3��28�� ����10:15:36
 * @version 1.0.0
 */
@Controller
@RequestMapping("/book/")
public class BookController {

    @Autowired
    private BookService bService;

    /**
     * @Description (��ת������Ա�鼮�������)
     * @return
     */
    @RequestMapping("adminBook")
    public String adminBook() {
        return "admin_book";
    }

    /**
     * @Description (��ҳ��ѯ�鼮)
     * @param queryText
     *            �ؼ���
     * @param page
     *            ҳ��
     * @param pageSize
     *            ҳ��¼����
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
            // ��ȡ�ܼ�¼����
            int totalSize = bService.countBooks(map);
            // ��ȡ���ҳ����
            int maxPage = totalSize % pageSize == 0 ? totalSize / pageSize : (totalSize / pageSize) + 1;
            // ��ҳ����
            Page<Book> bookPage = new Page<>();
            bookPage.setDatas(books);
            bookPage.setTotalSize(totalSize);
            bookPage.setMaxPage(maxPage);
            bookPage.setPage(page);
            // ��װ��result������
            result.setData(bookPage);
            result.setSuccess(true);
        } catch (Exception e) {
            e.printStackTrace();
            result.setSuccess(false);
        }
        return result;
    }

    /**
     * @Description (��id�����鼮)
     * @param request
     * @return
     */
    @RequestMapping("adminBookDetail")
    public ModelAndView adminBookDetail(HttpServletRequest request) {
        // ��ȡҪ��ѯ�鼮��ID
        long bookId = Long.parseLong(request.getParameter("bookId"));
        Book book = bService.queryBook(bookId);
        ModelAndView mav = new ModelAndView();
        mav.addObject("book", book);
        mav.setViewName("admin_book_detail");
        return mav;
    }

    /**
     * @Description (��ת������鼮ҳ��)
     * @return
     */
    @RequestMapping("addBook")
    public ModelAndView addBook() {
        return new ModelAndView("admin_add_book");
    }

    /**
     * @Description (����鼮)
     * @param pubDateStr
     *            ǰ�˴�����������
     * @param book
     *            ǰ�˴����������ݷ�װ
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
     * @Description (��������Ա�鼮�༭ҳ��)
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
     * @Description (�༭�鼮)
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

package com.ycz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ycz.pojo.Book;
import com.ycz.service.BookService;

/**
 * @ClassName BookController
 * @Description TODO(图书管理控制器)
 * @author Administrator
 * @Date 2020年3月28日 下午10:15:36
 * @version 1.0.0
 */
@Controller
@RequestMapping("book")
public class BookController {

    @Autowired
    private BookService bService;

    /**
     * @Description (分页查询书籍)
     * @param mav
     * @param page
     * @param pageSize
     * @return
     */
    @RequestMapping("queryBooksPaged")
    public ModelAndView getAllBooks(@RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
            @RequestParam(value = "pageSize", required = false, defaultValue = "5") Integer pageSize) {
        // 获取总记录条数
        int totalSize = bService.countBooks();
        // 获取最大页码数
        int maxPage = totalSize % pageSize == 0 ? totalSize / pageSize : (totalSize / pageSize) + 1;
        ModelAndView mav = new ModelAndView();
        List<Book> books = bService.queryBooksPaged(page, pageSize);// 查询所有书籍
        mav.addObject("page",page);
        mav.addObject("pageSize",pageSize);
        mav.addObject("totalSize",totalSize);
        mav.addObject("maxPage",maxPage);
        mav.addObject("books", books);// 将结果存进去
        mav.setViewName("admin_book");// 设置视图名称
        return mav;
    }

}

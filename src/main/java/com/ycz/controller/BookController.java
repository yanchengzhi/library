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
 * @Description TODO(ͼ����������)
 * @author Administrator
 * @Date 2020��3��28�� ����10:15:36
 * @version 1.0.0
 */
@Controller
@RequestMapping("book")
public class BookController {

    @Autowired
    private BookService bService;

    /**
     * @Description (��ҳ��ѯ�鼮)
     * @param mav
     * @param page
     * @param pageSize
     * @return
     */
    @RequestMapping("queryBooksPaged")
    public ModelAndView getAllBooks(@RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
            @RequestParam(value = "pageSize", required = false, defaultValue = "5") Integer pageSize) {
        // ��ȡ�ܼ�¼����
        int totalSize = bService.countBooks();
        // ��ȡ���ҳ����
        int maxPage = totalSize % pageSize == 0 ? totalSize / pageSize : (totalSize / pageSize) + 1;
        ModelAndView mav = new ModelAndView();
        List<Book> books = bService.queryBooksPaged(page, pageSize);// ��ѯ�����鼮
        mav.addObject("page",page);
        mav.addObject("pageSize",pageSize);
        mav.addObject("totalSize",totalSize);
        mav.addObject("maxPage",maxPage);
        mav.addObject("books", books);// ��������ȥ
        mav.setViewName("admin_book");// ������ͼ����
        return mav;
    }

}

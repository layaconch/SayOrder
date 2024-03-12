package com.wlld.myjecs.controller;

import com.github.pagehelper.PageInfo;
import com.wlld.myjecs.business.QuestionService;
import com.wlld.myjecs.sqlEntity.Qa;
import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author : Laowang
 * @create 2024/3/12
 */
@Controller
@RequestMapping("/question")
@Api(tags = "问答")
public class QuestionController {
    @Resource
    private QuestionService questionService;

    @RequestMapping("/getPage")
    public String getAll(Model model,
                         @RequestParam(value = "pageIndex", required = false, defaultValue = "1") Integer pageIndex,
                         @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize) {
        PageInfo<Qa> all = questionService.findAll(pageIndex, pageSize);
        model.addAttribute("page", all);
        model.addAttribute("path", "/question/getPage?pageIndex=");
        return "question";
    }

}

package com.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by mingook on 2016년9월 21일 (수).
 */
@Controller
@RequestMapping("/join")
public class JoinController {

    public String join() {
        return "/member/join";
    }
}

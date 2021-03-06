package com.hell.board.controller;

import com.hell.board.controller.board.BoardDetailCommand;
import com.hell.board.controller.board.BoardListCommand;
import com.hell.board.controller.board.WriteBoardCommand;
import com.hell.board.controller.board.WriteBoardPageCommand;
import com.hell.board.controller.common.AlertCommand;
import com.hell.board.controller.member.JoinCommand;
import com.hell.board.controller.member.JoinPageCommand;
import com.hell.board.controller.member.LoginCommand;
import com.hell.board.controller.member.LogoutCommand;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by mingook on 2016년8월 2일 (화).
 */
public class Controller extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Command command = null;

        switch (request.getRequestURI()) {
            case "/":
            case "/board.do":
                command = new BoardListCommand(request, response);
                break;
            case "/join.do":
                command = new JoinPageCommand(request, response);
                break;
            case "/writeBoard.do":
                command = new WriteBoardPageCommand(request, response);
                break;
            case "/logout.do":
                command = new LogoutCommand(request, response);
                break;
            case "/alert.do":
                command = new AlertCommand(request, response);
                break;
            case "/boardDetail.do":
                command = new BoardDetailCommand(request, response);
                break;
        }

        if (command != null) {
            command.execute();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Command command = null;

        switch (request.getRequestURI()) {
            case "/alert.do":
                // TODO alert.do의 경우 get, post 양쪽에 있는데, 이렇게 안하려면 어떻게 하면 좋을까?
                command = new AlertCommand(request, response);
                break;
            case "/login.do":
                command = new LoginCommand(request, response);
                break;
            case "/join.do":
                command = new JoinCommand(request, response);
                break;
            case "/writeBoard.do":
                command = new WriteBoardCommand(request, response);
                break;
        }

        if (command != null) {
            command.execute();
        }
    }
}

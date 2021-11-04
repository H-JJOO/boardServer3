package com.koreait.server;

import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/list")
public class SelBoardListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        List<BoardVO> list = BoardDAO.selBoardList();//BoardDAO 의 seBoardList 메소드 가져오기
        Gson gson = new Gson();//GSON
        String json = gson.toJson(list);

        res.setContentType("text/plain;;charset=UTF-8");//한글 깨지지 않게 하기

        PrintWriter out = res.getWriter();
        out.print(json);


    }
}

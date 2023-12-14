package sbs.jsp.board.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import sbs.jsp.board.Rq;

import java.io.IOException;

@WebServlet("/home/main")
public class HomeMainServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Rq rq = new Rq(req, resp);

        HttpSession session = req.getSession();

        boolean isLogined = false;
        int loginedMemberId = -1;
        String loginedMemberName = "";
        if (session.getAttribute("loginedMemberId") != null) {
            loginedMemberId = (int) session.getAttribute("loginedMemberId");
            loginedMemberName = (String) session.getAttribute("loginedMemberName");
            isLogined = true;
        }

        rq.setAttr("isLogined", isLogined);
        rq.setAttr("loginedMemberId", loginedMemberId);
        rq.setAttr("loginedMemberName", loginedMemberName);

        rq.jsp("home/main");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}

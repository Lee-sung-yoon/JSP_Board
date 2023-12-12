package sbs.jsp.board.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sbs.jsp.board.Rq;
import sbs.jsp.board.util.MysqlUtil;
import sbs.jsp.board.util.SecSql;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet("/usr/article/detail")
public class UsrArticleDetailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MysqlUtil.setDBInfo("localhost", "qna", "qna1234", "jspboard");
        MysqlUtil.setDevMode(true);

        Rq rq = new Rq(req, resp);

        int id = rq.getIntParam("id", 0);

        if (id == 0) {
            resp.getWriter().append("<script>alert('잘못된 요청입니다.'); history.back(); </script>");
            return;
        }

        SecSql sql = new SecSql();
        sql.append("SELECT A.*");
        sql.append("FROM article AS A");
        sql.append("WHERE A.id = ?", id);

        Map<String, Object> articleRow = MysqlUtil.selectRow(sql);

        rq.setAttr("articleRow", articleRow);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/article/detail.jsp");
        requestDispatcher.forward(req, resp);
    }
}
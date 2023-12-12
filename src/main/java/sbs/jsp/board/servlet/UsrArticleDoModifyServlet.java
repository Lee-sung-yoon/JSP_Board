package sbs.jsp.board.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sbs.jsp.board.Rq;
import sbs.jsp.board.util.MysqlUtil;
import sbs.jsp.board.util.SecSql;

import java.io.IOException;

@WebServlet("/usr/article/doModify")
public class UsrArticleDoModifyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MysqlUtil.setDBInfo("localhost", "qna", "qna1234", "jspboard");
        MysqlUtil.setDevMode(true);

        Rq rq = new Rq(req, resp);

        String title = rq.getParam("title", "");
        String content = rq.getParam("content", "");

        int id = rq.getIntParam("id", 0);
        if (title.length() == 0) {
            rq.appendBody("""
                    <script>
                        alert('제목을 입력해주세요')
                        history.back();
                    </script>
                    """);
        }

        if (content.length() == 0) {
            rq.appendBody("""
                    <script>
                        alert('내용을 입력해주세요')
                        history.back();
                    </script>
                    """);
        }

        SecSql sql = new SecSql();
        sql.append("UPDATE article");
        sql.append("SET updateDate = NOW()");
        sql.append(", title = ?", title);
        sql.append(", content = ?", content);
        sql.append("WHERE id = ?", id);
        
        MysqlUtil.update(sql);
        
        rq.appendBody("""
                    <script>
                        alert('%d번의 글이 수정되었습니다.')
                        location.replace('detail?id=%d');
                    </script>
                    """.formatted(id, id));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}

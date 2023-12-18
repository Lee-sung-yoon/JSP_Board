package sbs.jsp.board.repository;

import sbs.jsp.board.util.MysqlUtil;
import sbs.jsp.board.util.SecSql;

import java.util.List;
import java.util.Map;

public class ArticleRepository {

    public int getTotalCount() {
        SecSql sql = new SecSql();
        sql.append("SELECT COUNT(*)");
        sql.append("FROM article");

        int totalCount = MysqlUtil.selectRowIntValue(sql);

        return totalCount;
    }


    public List<Map<String, Object>> getArticleRows(int itemInAPage, int limitFrom) {
        SecSql sql = new SecSql();
        sql.append("SELECT A.*, M.name AS writerName");
        sql.append("FROM article AS A");
        sql.append("INNER JOIN `member` AS M");
        sql.append("ON A.memberId = M.id");
        sql.append("ORDER BY id DESC");
        sql.append("LIMIT ?, ?", limitFrom, itemInAPage);

        List<Map<String, Object>> articleRows = MysqlUtil.selectRows(sql);

        return articleRows;
    }
}

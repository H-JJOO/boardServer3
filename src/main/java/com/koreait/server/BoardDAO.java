package com.koreait.server;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BoardDAO {

    public static List<BoardVO> selBoardList() {
        List<BoardVO> list = new ArrayList();

        Connection con = null;//연결
        PreparedStatement ps = null;//쿼리문실행, ? 값 넣어주기
        ResultSet rs = null;//SELECT 결과물 담아두는 역할

        String sql = " SELECT iboard, title, writer, rdt " +
                    " FROM t_board " +
                    " ORDER BY iboard DESC ";

        try {
            con = DbUtils.getCon();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                BoardVO vo = new BoardVO();//값 넣기위해서
                vo.setIboard(rs.getInt("iboard"));
                vo.setTitle(rs.getString("title"));
                vo.setWriter(rs.getString("writer"));
                vo.setRdt(rs.getString("rdt"));
                list.add(vo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DbUtils.close(con, ps, rs);
        }
        return list;
    }
}

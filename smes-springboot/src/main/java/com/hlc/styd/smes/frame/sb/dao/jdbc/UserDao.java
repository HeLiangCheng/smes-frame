package com.hlc.styd.smes.frame.sb.dao.jdbc;

import com.hlc.styd.smes.frame.sb.entity.Db_User;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Liang on 2018/11/27
 *  jdbc实现的数据库操作
 */
@Repository
public class UserDao implements IUserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void save(Db_User user) {
        String insertSql = "INSERT INTO `user`(NAME,username,PASSWORD,gander,birthday) VALUES(?,?,?,?,?)";
        int count = jdbcTemplate.update(insertSql, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setString(1, user.getName());
                ps.setString(2, user.getUsername());
                ps.setString(3, user.getPassword());
                ps.setString(4, user.getGander());
                ps.setDate(5, new Date(user.getBirthday().getTime()));
            }
        });
    }

    @Override
    public void update(Db_User user) {
        String updateSql = "update `user` set name=? username=?  password=? gander=? birthday=? where id=?";
        int count = jdbcTemplate.update(updateSql, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setString(1, user.getName());
                ps.setString(2, user.getUsername());
                ps.setString(3, user.getPassword());
                ps.setString(4, user.getGander());
                ps.setDate(5, new Date(user.getBirthday().getTime()));
                ps.setInt(6, user.getId());
            }
        });
    }

    @Override
    public void delete(Db_User user) {
        String deleteSql = "delete from `user` where id=?";
        int count = jdbcTemplate.update(deleteSql, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setInt(1, user.getId());
            }
        });
    }

    @Override
    public int count(Db_User user) {
        StringBuilder sb = new StringBuilder("select count(*) from `user` ");
        List<String> querystr = new ArrayList<String>();
        List<Object> paramval = new ArrayList<Object>();
        if (StringUtils.isEmpty(user.getUsername())) {
            querystr.add(" username like ? ");
            paramval.add("%" + user.getUsername() + "%");
        }
        if (StringUtils.isEmpty(user.getName())) {
            querystr.add(" name like ? ");
            paramval.add("%" + user.getName() + "%");
        }
        if (StringUtils.isEmpty(user.getGander())) {
            querystr.add(" gander = ? ");
            paramval.add(user.getGander());
        }
        //构造sql语句
        if (querystr.size() > 0) {
            sb.append(" where ");
            sb.append(StringUtils.join(querystr, " and "));
        }
        int count = jdbcTemplate.queryForObject(sb.toString(), Integer.TYPE, paramval);
        return count;
    }

    @Override
    public List<Db_User> findAll() {
        String selectSql = "select * from `user`";
        List<Db_User> dbUserList = jdbcTemplate.query(selectSql, new RowMapper<Db_User>() {
            @Nullable
            @Override
            public Db_User mapRow(ResultSet rs, int rowNum) throws SQLException {
                Db_User t = new Db_User();
                t.setId(rs.getInt("id"));
                t.setUsername(rs.getString("username"));
                t.setName(rs.getString("name"));
                t.setGander(rs.getString("gander"));
                t.setBirthday(rs.getDate("birthday"));
                return t;
            }
        });
        return dbUserList;
    }

    @Override
    public Db_User findById(Integer id) {
        String selectSql = "select * from `user` where id=?";
        Db_User user = jdbcTemplate.queryForObject(selectSql, Db_User.class, id);
        return user;
    }

    @Override
    public List<Db_User> findByCriteria(Db_User user) {
        StringBuilder sb = new StringBuilder("select * from `user` ");
        List<String> querystr = new ArrayList<String>();
        List<Object> paramval = new ArrayList<Object>();
        if(user!=null) {
            if (StringUtils.isEmpty(user.getUsername())) {
                querystr.add(" username like ? ");
                paramval.add("%" + user.getUsername() + "%");
            }
            if (StringUtils.isEmpty(user.getName())) {
                querystr.add(" name like ? ");
                paramval.add("%" + user.getName() + "%");
            }
            if (StringUtils.isEmpty(user.getGander())) {
                querystr.add(" gander = ? ");
                paramval.add(user.getGander());
            }
        }
        //构造sql语句
        if (querystr.size() > 0) {
            sb.append(" where ");
            sb.append(StringUtils.join(querystr, " and "));
        }
        List<Db_User> dbUserList = jdbcTemplate.query(sb.toString(), paramval.toArray(), new RowMapper<Db_User>() {
            @Nullable
            @Override
            public Db_User mapRow(ResultSet rs, int rowNum) throws SQLException {
                Db_User t = new Db_User();
                t.setId(rs.getInt("id"));
                t.setUsername(rs.getString("username"));
                t.setName(rs.getString("name"));
                t.setGander(rs.getString("gander"));
                t.setBirthday(rs.getDate("birthday"));
                return t;
            }
        });
        return dbUserList;
    }

    @Override
    public List<Db_User> findByPage(int pageindex, int pagesize, Db_User user) {
        StringBuilder sb = new StringBuilder("select * from `user` ");
        List<String> querystr = new ArrayList<String>();
        List<Object> paramval = new ArrayList<Object>();
        if(user!=null) {
            if (StringUtils.isEmpty(user.getUsername())) {
                querystr.add(" username like ? ");
                paramval.add("%" + user.getUsername() + "%");
            }
            if (StringUtils.isEmpty(user.getName())) {
                querystr.add(" name like ? ");
                paramval.add("%" + user.getName() + "%");
            }
            if (StringUtils.isEmpty(user.getGander())) {
                querystr.add(" gander = ? ");
                paramval.add(user.getGander());
            }
        }
        //构造sql语句
        if (querystr.size() > 0) {
            sb.append(" where ");
            sb.append(StringUtils.join(querystr, " and "));
        }
        sb.append(" order by id limit ?,? ");
        paramval.add((pageindex - 1) * pagesize);
        paramval.add(pagesize);
        List<Db_User> dbUserList = jdbcTemplate.query(sb.toString(), paramval.toArray(), new RowMapper<Db_User>() {
            @Nullable
            @Override
            public Db_User mapRow(ResultSet rs, int rowNum) throws SQLException {
                Db_User t = new Db_User();
                t.setId(rs.getInt("id"));
                t.setUsername(rs.getString("username"));
                t.setName(rs.getString("name"));
                t.setGander(rs.getString("gander"));
                t.setBirthday(rs.getDate("birthday"));
                return t;
            }
        });
        return dbUserList;
    }

}

package com.devin.handler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyTypeHandler extends BaseTypeHandler<Date> {


    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, Date date, JdbcType jdbcType) throws SQLException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        String format = dateFormat.format(date);
        preparedStatement.setString(i,format);

    }

    @Override
    public Date getNullableResult(ResultSet resultSet, String s) throws SQLException {
        String date = resultSet.getString(s);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        Date parsee = null;
        try {
            //parse会抛出异常，需要try..catch
            parsee = dateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return parsee;
    }

    @Override
    public Date getNullableResult(ResultSet resultSet, int i) throws SQLException {
        return null;
    }

    @Override
    public Date getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        return null;
    }
}

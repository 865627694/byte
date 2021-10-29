package com.waymap.o2o.cloud.provider.amazon.ad.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 输入映射：String[] 👉  String
 * 输出映射: String 👉 String[]
 * json工具类：存储到数据库中，数组或其他类型的数据，以json字符串的形式存储
 */
@MappedTypes(String[].class)
@MappedJdbcTypes(JdbcType.VARCHAR)
public class StringArrayTypeHandler implements TypeHandler<String[]> {
    //jackson
    ObjectMapper objectMapper = new ObjectMapper();
    //输入映射过程
    @SneakyThrows
    @Override
    public void setParameter(PreparedStatement preparedStatement, int index, String[] strings, JdbcType jdbcType) throws SQLException {
        //strings 👉 String
        String value = objectMapper.writeValueAsString(strings);//Object 👉 String

        preparedStatement.setString(index,value);
    }

    //输出映射过程
    //result 👉 String[]
    @Override
    public String [] getResult(ResultSet resultSet, String columnName) throws SQLException {
        String result = resultSet.getString(columnName);
        return transfer(result);
    }

    @Override
    public String[] getResult(ResultSet resultSet, int columnIndex) throws SQLException {
        String result = resultSet.getString(columnIndex);
        return transfer(result);
    }

    @Override
    public String[] getResult(CallableStatement callableStatement, int index) throws SQLException {
        String result = callableStatement.getString(index);
        return transfer(result);
    }

    private String[] transfer(String result) {
        String[] strings = new String[0];
        try {
            strings = objectMapper.readValue(result, String[].class);
        } catch (JsonProcessingException e) {
            return new String[0];
            //e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return strings;
    }
}
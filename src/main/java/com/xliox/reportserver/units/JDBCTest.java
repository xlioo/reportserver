package com.xliox.reportserver.units;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;

import java.sql.*;

/**
 * Create by 一初 on 2019-11-10
 */
public class JDBCTest {

    public JSONObject getData() throws Exception {
        Connection connection = null;
        PreparedStatement prepareStatement = null;
        // 存放结果总数
        ResultSet rs = null;
        // 存放本次查询结果

        try {
            // 加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            // 获取连接
            String url = "jdbc:mysql://127.0.0.1:3306/report_db";
            String user = "xlioo";
            String password = "Xlioo@123";
            connection = DriverManager.getConnection(url, user, password);
            // 获取statement，preparedStatement
//            String sql = "select * from t_user where id=?";
            String sql = "select * from t_user ";
            System.out.println(sql);
            prepareStatement = connection.prepareStatement(sql);
            // 设置参数
//            prepareStatement.setLong(1, 1l);
            // 执行查询
            rs = prepareStatement.executeQuery();
            // ResultSet 转 JSON
            JSONObject rsjson = resultSetToJsonObject(rs);

            System.out.println(rsjson.toString());

            return rsjson;




        } finally {
            // 关闭连接，释放资源
            if (rs != null) {
                rs.close();
            }
            if (prepareStatement != null) {
                prepareStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }

    /**
     * 将resultSet转化为JSONObject
     * @param rs
     * @return
     * @throws SQLException
     * @throws JSONException
     *
     */
    public static JSONObject resultSetToJsonObject(ResultSet rs) throws SQLException, JSONException

    {

        // json数组,存放查询的数据,内容为rows
        JSONArray jsonArray = new JSONArray();

        // json对象,存放转化后的json对象，内容包括 rows，total，totalNotFiltered
        JSONObject jsonObject = new JSONObject();

        // 获取列数
        ResultSetMetaData metaData = rs.getMetaData();
        int columnCount = metaData.getColumnCount();
        int rowCount = rs.getRow();

        // 遍历ResultSet中的每条数据
        while(rs.next()) {

            // json对象
            JSONObject jsonObj = new JSONObject();

            // 遍历每一列
            for (int i = 1; i <= columnCount; i++) {
                String columnName =metaData.getColumnLabel(i);
                String value = rs.getString(columnName);
                jsonObj.put(columnName, value);
            }
            jsonArray.add(jsonObj);
        }

        //封装查询结果
        jsonObject.put("rows",jsonArray);
        jsonObject.put("total",rowCount);
        jsonObject.put("totalNotFiltered",rowCount);

        return jsonObject;
    }

}

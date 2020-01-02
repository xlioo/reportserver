# 报表系统
## 简介
报表系统核心分为两部分：
* 用户报表编辑器
* 报表展示服务平台

## 报表展示服务平台
大体流程如下：
1. 读取报表配置xml（Report Configuration Xml）文件，获取报表内容（包括SQL，库地址，表格配置等）。
2. 根据RCX文件生成HTML
3. 返回HTML给前端
4. 前端调用接口获取报表所需数据
5. 前端加载数据生成表格 

### 报表配置xml（Report Configuration Xml）
```xml
<RCX>
    <!--配置数据源信息,包括数据源名称/JDBC地址-->
    <dataSource>
        <dataSourceName>report_db</dataSourceName>
        <dataSourceJDBC>jdbc:mysql://127.0.0.1:3306/report_db</dataSourceJDBC>
    </dataSource>
    <!--获取数据集,包括数据集名称,数据源名称,SQL,数据生成插件-->
    <dataSets>
        <dataSet>
            <dataSetName>t_user</dataSetName>
            <dataSourceName>report_db</dataSourceName>
            <dataSQL>select * from t_user</dataSQL>
            <dataPlugInClass>jdbcTest</dataPlugInClass>
        </dataSet>
    </dataSets>
    <!--报表插件配置，报表是由多个报表插件组合而成(仅有插件).-->
    <!--插件基础属性为插件名称，插件布局位置，插件数据.-->
    <viewPlugIn>
        <plugInName>basics-table</plugInName>
        <plugInLocation>10px,10px</plugInLocation>
        <plugInData>t_user</plugInData>
    </viewPlugIn>
</RCX>
```

## 报表插件
报表插件有如下两类：
* 后台数据生成插件
* 前台报表插件

### 后台数据生成插件


### 前台报表插件




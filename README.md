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



# 新报表系统想法💡
关键性需求：数据存储在mysql/oracle/hive/kylin等数据库中，分析人员/决策者无法便捷查看这些数据。
角色分析：
    * 决策者/分析人员：每天需要看到同样逻辑统计后的结果数据。统计逻辑稳定后短时间内不会太大变动。
    * 报表开发人员：分析人员/决策者确定统计逻辑与展示样式后需要报表开发去实现。一般为图表等。优势是招人好招，且人员兴致高，学习的是通用技术。如果没有该类技术。现成的模版工具也可以傻瓜式进行开发。模版工具可以由报表开发团队统一维护。因为大部分都是页面模块化加载。
    * 报表平台（这里应该叫做数据提供平台）：不再生成HTML结果页面展示给用户，而是只提供JSON格式的数据接口。报表开发人员在数据提供平台上申请对应的json数据接口，审批通过后平台开放接口，并提供对应的鉴权信息。报表开发人员只需要具备前端技术能力，即可完成页面的开发，然后发布到nodejs服务器或者其他服务器上。用户访问后，页面加载异步/同步调用数据接口获取数据，完成页面渲染。该平台可以提供给任意功能人员使用。甚至APP开发人员，做到数据统一管理，性能统一维护。简化开发过程。
    * 页面服务器：无需使用java语言，无需重启，实时生效。存放报表开发
   
安全分析：
    * 数据平台：接口鉴权保障。
    * 页面服务器：这块没想好
    
    
    
    
    





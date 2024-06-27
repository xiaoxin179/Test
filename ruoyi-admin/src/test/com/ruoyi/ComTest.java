package com.ruoyi;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.alibaba.fastjson.JSONObject;
import com.ruoyi.common.utils.RandomValue;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.bean.BeanUtils;
import com.ruoyi.common.utils.http.HttpUtils;
import com.ruoyi.recruit.PositionEntity;
import com.ruoyi.recruit.domain.RecruitPosition;
import com.ruoyi.utils.HttpUtil;
import com.ruoyi.utils.TranslateUtil;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.stream.Collectors;

public class ComTest {
    @Test
    public void t1() throws Exception {
//        //1.加载配置文件
//        Properties pro = new Properties();
//        //使用ClassLoader加载配置文件，获取字节输入流
//        InputStream is = ComTest.class.getClassLoader().getResourceAsStream("druid.properties");
//        pro.load(is);
//
//        //2.初始化连接池对象
//        DataSource ds = DruidDataSourceFactory.createDataSource(pro);
//        JdbcTemplate template = new JdbcTemplate(ds);
//
//        String sql = "select * from position;";
//        List<PositionEntity> list = template.query(sql, new BeanPropertyRowMapper<>(PositionEntity.class));
//
//        list.forEach(positionEntity -> {
//            RecruitPosition recruitPosition = new RecruitPosition();
//            BeanUtils.copyBeanProp(recruitPosition,positionEntity);
//            recruitPosition.setName(positionEntity.getTitle());
//            recruitPosition.setValidDate(new Date());
//            recruitPosition.setPhonenumber("13147854123");
//            recruitPosition.setHrId(1L);
//            recruitPosition.setCategoryId((long) RandomValue.getNum(8, 17));
//            recruitPosition.setCompanyId((long) RandomValue.getNum(1, 6));
//        });
    }
    @Test
    void t5() throws IOException {
        String[] strings = ("nickname\n" +
                "date\n" +
                "courseId\n" +
                "userId\n").split("\n");
        String[] zhField = ("昵称\n" +
                "日期\n" +
                "课程id\n" +
                "用户id\n").split("\n");
        for (int i = 0; i < strings.length; i++) {
            String field = StringUtils.toUnderScoreCase(strings[i]);
            System.out.println(StringUtils.format("{} varchar(255) comment '{}',", field, zhField[i]));
        }
    }
    @Test
    void t3() throws IOException {
        String json="{\n" +
                "  \"appid\": \"wx42c31f892d61bdd3\",\n" +
                "  \"secret\": \"b0c04196af80a2fe373c7ec166f91363\",\n" +
                "  \"js_code\":  \"081Edk0w300FcW2HvN1w3l7Sfa0Edk0a\",\n" +
                "  \"grant_type\": \"authorization_code\"\n" +
                "}\n";
        Map<String, String> map=new HashMap<>();
        map.put("appid", "wx42c31f892d61bdd3");
        map.put("secret", "b0c04196af80a2fe373c7ec166f91363");
        map.put("js_code", "081Edk0w300FcW2HvN1w3l7Sfa0Edk0a");
        map.put("grant_type", "authorization_code");
//        String s = HttpUtils.sendGet("http://localhost:8080/test","appid=wx42c31f892d61bdd3&secret=b0c04196af80a2fe373c7ec166f91363&js_code=081Edk0w300FcW2HvN1w3l7Sfa0Edk0a&grant_type=authorization_code");
//        String s = HttpUtils.sendGet("https://api.weixin.qq.com/sns/jscode2session","appid=wx42c31f892d61bdd3&secret=b0c04196af80a2fe373c7ec166f91363&js_code=081egv100oVsyL1zdn300jCDF84egv1h&grant_type=authorization_code");
        String s = HttpClientUtil.doGet("http://localhost/dev-api/captchaImage");
        System.out.println(s);
    }
    @Test
    void t2() throws IOException {
        //表前缀
        String prefix = "";
        //表字段，第一个是表名
        String[] zhFields =("商品、标题、描述、材质、价格、发货地").split("、");
        getSql(prefix, zhFields);
    }

    private void getSql(String prefix, String[] zhFields) throws IOException {
        String tableName = prefix+TranslateUtil.getTransResult(zhFields[0]);
        String sql =  StringUtils.format("drop table if exists {};\n" +
                "create table {}\n(\nid    bigint(20) not null auto_increment comment 'ID',\n",tableName,tableName);
        List<String> rowList = Arrays.stream(zhFields).skip(1).map(zhField -> {
            String field="";
            try {
                Thread.sleep(800);
                String transResult = TranslateUtil.getTransResult(zhField);
                String[] s = transResult.split(" ");
                String collect = Arrays.stream(s).skip(1).map(StringUtils::capitalize).collect(Collectors.joining());
                field = StringUtils.uncapitalize(s[0])+collect;
//                field = Arrays.stream(transResult.split(" ")).map(StringUtils::uncapitalize).collect(Collectors.joining("_"));
            } catch (InterruptedException | IOException ex) {
                Thread.currentThread().interrupt();
            }
            return StringUtils.format("{} varchar(255) comment '{}'", field, zhField);
        }).collect(Collectors.toList());
        System.out.println(sql+String.join(",\n",rowList)+",\nprimary key (id)\n" +
                ") comment '"+zhFields[0]+"信息表';\n");
    }
}



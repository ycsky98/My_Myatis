package cn.mybatis.source.pojo;

public class MapperConfig {
    private String labe;//标签名
    private Object data;//传入的数据
    private String result;//返回的结果集
    private String sql;//sql语句

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getLabe() {
        return labe;
    }

    public void setLabe(String labe) {
        this.labe = labe;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    @Override
    public String toString() {
        return "MapperConfig{" +
                "labe='" + labe + '\'' +
                ", data=" + data +
                ", result='" + result + '\'' +
                ", sql='" + sql + '\'' +
                '}';
    }
}

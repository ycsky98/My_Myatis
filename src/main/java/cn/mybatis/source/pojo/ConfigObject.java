package cn.mybatis.source.pojo;

import java.util.Arrays;
import java.util.Map;

public class ConfigObject {
    private String namespace;//命名空间
    private Map<String,MapperConfig>[] idAndmapper;//标签对应的属性sql

    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    public Map<String, MapperConfig>[] getIdAndmapper() {
        return idAndmapper;
    }

    public void setIdAndmapper(Map<String, MapperConfig>[] idAndmapper) {
        this.idAndmapper = idAndmapper;
    }

    @Override
    public String toString() {
        return "ConfigObject{" +
                "namespace='" + namespace + '\'' +
                ", idAndmapper=" + Arrays.toString(idAndmapper) +
                '}';
    }
}

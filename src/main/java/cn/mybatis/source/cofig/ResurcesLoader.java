package cn.mybatis.source.cofig;

import cn.mybatis.source.pojo.ConfigObject;
import cn.mybatis.source.pojo.MapperConfig;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ResurcesLoader {
    private SAXReader saxReader;
    private Document document;
    private List<ConfigObject> list = new LinkedList<>();
    private ConfigObject configObject;

    public ResurcesLoader(){
        saxReader = new SAXReader();
        try {
            File file = new File(this.getClass().getClassLoader().getResource("mapper").getPath());
            File[] files = file.listFiles(new FileFilter() {
                @Override
                public boolean accept(File pathname) {
                    String filename = pathname.getName();
                    String xml = filename.substring(filename.lastIndexOf(".")+1,filename.length());
                    return xml.equals("xml");
                }
            });
            for (File f:files) {
                document = saxReader.read(f);
                list.add(ConfigObject());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private ConfigObject ConfigObject(){
        Element root = document.getRootElement();
        this.configObject = new ConfigObject();
        //装入命名空间
        this.configObject.setNamespace(root.attributeValue("namespace"));
        List<Element> elements = root.elements();
        Map<String, MapperConfig>[] mapperConfigMap = new HashMap[elements.size()];
        MapperConfig config = null;
        int i = 0;
        for (Element e: elements) {
            mapperConfigMap[i] = new HashMap<>();
            config = new MapperConfig();
            config.setLabe(e.getName());//标签名
            config.setData(e.attributeValue("data"));//传入的数据
            config.setSql(e.getText().trim());
            config.setResult(e.attributeValue("result"));
            mapperConfigMap[i].put(e.attributeValue("id"),config);
            i++;
        }
        configObject.setIdAndmapper(mapperConfigMap);
        return configObject;
    }

    public List<ConfigObject> GetConfigList(){
        return this.list;
    }
    public static void main(String[] args){
        ResurcesLoader loader = new ResurcesLoader();
        List<ConfigObject> list = loader.GetConfigList();
        System.out.println(list);
    }
}

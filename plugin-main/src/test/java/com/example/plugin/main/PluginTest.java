package com.example.plugin.main;

import com.example.plugin.api.model.Plugin;
import com.example.plugin.api.service.PluginService;
import com.example.plugin.main.util.PluginManager;
import com.example.plugin.main.util.XMLParse;
import org.dom4j.DocumentException;

import java.net.URLClassLoader;
import java.util.List;

public class PluginTest {

    public static void main(String[] args) {
        try {
            //xml的绝对路径
            List<Plugin> pluginList = XMLParse.parseXml("C:\\Users\\Kelly\\Desktop\\MyProject\\plugin-parent\\plugin-main\\src\\main\\resources\\plugin.xml");
            PluginManager pluginManager = new PluginManager(pluginList);
            System.out.println("------------插件启动中!----------------");
            pluginList.forEach(v -> {
                try {
                    PluginService instance = pluginManager.getInstance(v.getClassName());
                    instance.service();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            });
            System.out.println("------------ 插件执行完毕！------------");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

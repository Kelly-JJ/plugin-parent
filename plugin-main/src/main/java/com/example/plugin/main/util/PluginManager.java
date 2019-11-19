package com.example.plugin.main.util;

import com.example.plugin.api.model.Plugin;
import com.example.plugin.api.service.PluginService;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.List;

public class PluginManager {

    private URLClassLoader urlClassLoader;


    public PluginManager(List<Plugin> plugins) throws MalformedURLException {
        init(plugins);
    }

    private void init(List<Plugin> plugins) throws MalformedURLException {
        int size = plugins.size();
        if (size > 0) {
            URL[] urls = new URL[size];
            for (int i = 0; i < size; i++) {
                Plugin plugin = plugins.get(i);
                urls[i] = new URL("file:"+plugin.getJar());
            }
            urlClassLoader = new URLClassLoader(urls,Thread.currentThread().getContextClassLoader());
        } else {
            System.out.println("当前无插件！");
        }
    }


    public PluginService getInstance(String className) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        System.out.println(className);

        Class<?> aClass = urlClassLoader.loadClass(className);
        Object o = aClass.newInstance();
        System.out.println(o instanceof PluginService);
        return (PluginService)o ;
    }
}

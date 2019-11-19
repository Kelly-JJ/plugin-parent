package com.example.plugin.main.util;

import com.example.plugin.api.model.Plugin;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class XMLParse {

    public static List<Plugin> parseXml(String xmlName) throws DocumentException {
        List<Plugin> plugins = new ArrayList<>();
        SAXReader reader = new SAXReader();
        Document document = reader.read(new File(xmlName));
        Element root = document.getRootElement();
        for (Element element : root.elements()) {
            Plugin plugin = new Plugin();
            plugin.setClassName(element.elementText("className"));
            plugin.setJar(element.elementText("jar"));
            plugin.setName(element.elementText("name"));
            plugins.add(plugin);
        }
        return plugins;
    }
}

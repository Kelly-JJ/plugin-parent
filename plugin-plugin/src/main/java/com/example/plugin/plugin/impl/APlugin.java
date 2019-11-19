package com.example.plugin.plugin.impl;

import com.example.plugin.api.service.PluginService;
import org.springframework.stereotype.Service;

@Service
public class APlugin implements PluginService {
    @Override
    public void service() {
        System.out.println("这是插件A");
    }
}

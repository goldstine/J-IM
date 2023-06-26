package org.jim.server.demo;

import org.jim.server.config.ImServerConfig;
import org.jim.server.config.PropertyImServerConfigBuilder;

public class ImServerDemoStart {

    public static void main(String[] args) {
        ImServerConfig imServerConfig=new PropertyImServerConfigBuilder("config/jim.properties").build();

    }
}

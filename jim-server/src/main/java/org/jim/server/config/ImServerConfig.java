package org.jim.server.config;

import org.jim.core.ImHandler;
import org.jim.core.config.ImConfig;
import org.jim.core.listener.ImListener;

public class ImServerConfig extends ImConfig {
    @Override
    public ImHandler getImHandler() {
        return null;
    }

    @Override
    public ImListener getImListener() {
        return null;
    }
}

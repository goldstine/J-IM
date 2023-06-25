package org.jim.client.config;

import org.jim.core.ImHandler;
import org.jim.core.config.ImConfig;
import org.jim.core.listener.ImListener;

public class ImClientConfig extends ImConfig {
    @Override
    public ImHandler getImHandler() {
        return null;
    }

    @Override
    public ImListener getImListener() {
        return null;
    }
}

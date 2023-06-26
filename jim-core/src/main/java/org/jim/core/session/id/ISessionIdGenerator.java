package org.jim.core.session.id;

import org.jim.core.http.HttpConfig;

public interface ISessionIdGenerator {
    String sessionId(HttpConfig httpConfig);
}

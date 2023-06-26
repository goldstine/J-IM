package org.jim.core.session.id.impl;

import org.jim.core.http.HttpConfig;
import org.jim.core.session.id.ISessionIdGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;

public class UUIDSessionGenerator implements ISessionIdGenerator {

    private static Logger logger= LoggerFactory.getLogger(UUIDSessionGenerator.class);

    public final static UUIDSessionGenerator instance=new UUIDSessionGenerator();

    private UUIDSessionGenerator(){}

    @Override
    public String sessionId(HttpConfig httpConfig) {
        return UUID.randomUUID().toString().replace("-","");
    }

    public static void main(String[] args) {
        UUIDSessionGenerator uuidSessionGenerator=new UUIDSessionGenerator();
        String xx=uuidSessionGenerator.sessionId(null);
        System.out.println(xx);
        System.out.println(UUID.randomUUID().toString());
        logger.info(xx);
    }
}

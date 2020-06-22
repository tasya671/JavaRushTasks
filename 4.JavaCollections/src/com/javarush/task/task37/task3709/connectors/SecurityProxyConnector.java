package com.javarush.task.task37.task3709.connectors;

import com.javarush.task.task37.task3709.security.SecurityChecker;
import com.javarush.task.task37.task3709.security.SecurityCheckerImpl;

public class SecurityProxyConnector implements Connector {

    private SimpleConnector connector;
    private SecurityChecker securityChecker;

    public SecurityProxyConnector(String resourceString) {
        this.connector = new SimpleConnector(resourceString);
        this.securityChecker = new SecurityCheckerImpl();
    }

    @Override
    public void connect() {
        if(securityChecker.performSecurityCheck()){
            connector.connect();
        }

    }
}

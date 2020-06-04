package com.training.turkcell;

import java.util.ArrayList;
import java.util.List;

public class ErrorObj {

    private List<ErrorObj> subError;
    private String         message;
    private int            cause;
    private String         domain;
    private String         subdomain;
    private String         boundedContext;


    public ErrorObj() {
    }


    public ErrorObj(final String messageParam,
                    final int causeParam,
                    final String domainParam,
                    final String subdomainParam,
                    final String boundedContextParam) {
        super();
        this.message = messageParam;
        this.cause = causeParam;
        this.domain = domainParam;
        this.subdomain = subdomainParam;
        this.boundedContext = boundedContextParam;
    }

    public void add(final ErrorObj errorObjParam) {
        if (this.subError == null) {
            this.subError = new ArrayList<>();
        }
        this.subError.add(errorObjParam);
    }


    public List<ErrorObj> getSubError() {
        return this.subError;
    }

    public void setSubError(final List<ErrorObj> subErrorParam) {
        this.subError = subErrorParam;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(final String messageParam) {
        this.message = messageParam;
    }

    public int getCause() {
        return this.cause;
    }

    public void setCause(final int causeParam) {
        this.cause = causeParam;
    }

    public String getDomain() {
        return this.domain;
    }

    public void setDomain(final String domainParam) {
        this.domain = domainParam;
    }

    public String getSubdomain() {
        return this.subdomain;
    }

    public void setSubdomain(final String subdomainParam) {
        this.subdomain = subdomainParam;
    }

    public String getBoundedContext() {
        return this.boundedContext;
    }

    public void setBoundedContext(final String boundedContextParam) {
        this.boundedContext = boundedContextParam;
    }


}

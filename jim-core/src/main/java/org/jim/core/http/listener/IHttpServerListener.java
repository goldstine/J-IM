package org.jim.core.http.listener;

import org.jim.core.http.HttpRequest;
import org.jim.core.http.HttpResponse;
import org.jim.core.http.RequestLine;

public interface IHttpServerListener {

    public void doAfterHandler(HttpRequest packet, RequestLine requestLine, HttpResponse httpResponse);

    public HttpResponse doBeforeHandler(HttpRequest packet,RequestLine requestLine,HttpResponse httpResponseFromCache);
}

package org.jim.core.http.handler;

import org.jim.core.http.HttpRequest;
import org.jim.core.http.HttpResponse;
import org.jim.core.http.RequestLine;

public interface IHttpRequestHandler {

    public HttpResponse handler(HttpRequest packet, RequestLine requestLine);

    public HttpResponse resp404(HttpRequest request,RequestLine requestLine);

    public HttpResponse resp500(HttpRequest request,RequestLine requestLine,Throwable throwable);

    public void clearStaticResCache(HttpRequest request);

}

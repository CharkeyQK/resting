/*
 * Copyright (C) 2010 Google Code.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.resting.method.post;

import com.google.resting.component.EncodingTypes;
import com.google.resting.component.RequestParams;
import com.google.resting.component.ServiceContext;
import com.google.resting.component.content.ContentType;
import com.google.resting.component.impl.ServiceResponse;
import com.google.resting.component.impl.URLContext;
import com.google.resting.rest.client.HttpContext;
import com.google.resting.serviceaccessor.impl.ServiceAccessor;
import org.apache.http.Header;
import org.apache.http.entity.mime.content.ContentBody;

import java.io.File;
import java.util.List;
import java.util.Map;

/**
 * Helper class for HTTP PUT operation
 *
 * @author sujata.de
 * @since resting 0.2
 */
public class PostHelper {

    public final static ServiceResponse post(String url, int port, EncodingTypes encoding, RequestParams requestParams, List<Header> additionalHeaders, HttpContext httpContext) {
        URLContext urlContext = new URLContext(url, port);
        ServiceContext serviceContext = new PostServiceContext(urlContext, requestParams, encoding, additionalHeaders, httpContext);
        return ServiceAccessor.access(serviceContext);
    }//post

    public final static ServiceResponse post(String messageToPost, EncodingTypes encoding, String url, int port, List<Header> additionalHeaders, HttpContext httpContext) {
        URLContext urlContext = new URLContext(url, port);
        ServiceContext serviceContext = new PostServiceContext(urlContext, messageToPost, encoding, additionalHeaders, httpContext);
        return ServiceAccessor.access(serviceContext);
    }//post

    public final static ServiceResponse post(String messageToPost, EncodingTypes encoding, String url, int port, RequestParams requestParams, List<Header> additionalHeaders, ContentType messageContentType, HttpContext httpContext) {
        URLContext urlContext = new URLContext(url, port);
        ServiceContext serviceContext = new PostServiceContext(urlContext, requestParams, messageToPost, encoding, additionalHeaders, messageContentType, httpContext);
        return ServiceAccessor.access(serviceContext);
    }//post

    public final static ServiceResponse post(String url, int port, File file, RequestParams requestParams, EncodingTypes encoding, List<Header> additionalHeaders, ContentType contentType, HttpContext httpContext) {
        URLContext urlContext = new URLContext(url, port);
        ServiceContext serviceContext = new PostServiceContext(urlContext, requestParams, file, encoding, additionalHeaders, contentType, httpContext);
        return ServiceAccessor.access(serviceContext);
    }//post

    public static ServiceResponse post(String url, int port, Map<String, ContentBody> multipartBody, RequestParams requestParams, List<Header> additionalHeaders, ContentType fileContentType, HttpContext httpContext) {
        URLContext urlContext = new URLContext(url, port);
        ServiceContext serviceContext = new PostServiceContext(urlContext, requestParams, multipartBody, additionalHeaders, fileContentType, httpContext);
        return ServiceAccessor.access(serviceContext);
    }
}//PostHelper

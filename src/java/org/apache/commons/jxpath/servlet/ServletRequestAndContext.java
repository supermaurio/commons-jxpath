/*
 * Copyright 1999-2004 The Apache Software Foundation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.commons.jxpath.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Just a structure to hold a ServletRequest and ServletContext together.
 *
 * @author Dmitri Plotnikov
 * @version $Revision$ $Date$
 */
public class ServletRequestAndContext extends
        HttpSessionAndServletContext
{
    private ServletRequest request;

    public ServletRequestAndContext(ServletRequest request,
            ServletContext context) 
    {
        super(null, context);
        this.request = request;
    }

    
    public HttpSession getSession() {
        if (request instanceof HttpServletRequest) {
            return ((HttpServletRequest)request).getSession(false);
        }
        return null;
    }
    
    public ServletRequest getServletRequest() {
        return request;
    }
}
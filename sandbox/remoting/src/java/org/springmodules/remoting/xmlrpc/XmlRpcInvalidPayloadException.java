/* 
 * Created on Jul 4, 2005
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 *
 * Copyright @2005 the original author or authors.
 */
package org.springmodules.remoting.xmlrpc;

/**
 * <p>
 * Exception thrown when the given XML-RPC payload does not conform to the
 * specification.
 * </p>
 * 
 * @author Alex Ruiz
 * 
 * @version $Revision$ $Date$
 */
public class XmlRpcInvalidPayloadException extends XmlRpcServerException {

  public static final int FAULT_CODE = -32600;

  private static final long serialVersionUID = -2065698031713146751L;

  public XmlRpcInvalidPayloadException(String msg) {
    super(msg);
  }

  public XmlRpcInvalidPayloadException(String msg, Throwable nestedException) {
    super(msg, nestedException);
  }

  public int getCode() {
    return FAULT_CODE;
  }
}

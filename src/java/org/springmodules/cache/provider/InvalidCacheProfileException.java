/* 
 * Created on Nov 4, 2004
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
 * Copyright @2004 the original author or authors.
 */

package org.springmodules.cache.provider;

import org.springframework.core.NestedRuntimeException;

/**
 * <p>
 * Exception thrown when one or more properties of a
 * <code>{@link CacheProfile}</code> contain invalid values.
 * </p>
 * 
 * @author Alex Ruiz
 * 
 * @version $Revision$ $Date$
 */
public class InvalidCacheProfileException extends NestedRuntimeException {

  private static final long serialVersionUID = 7043423030105935558L;

  public InvalidCacheProfileException(String detailMessage) {
    super(detailMessage);
  }

  public InvalidCacheProfileException(String detailMessage,
      Throwable nestedException) {
    super(detailMessage, nestedException);
  }

}
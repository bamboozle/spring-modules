/*
 * Copyright 2002-2007 the original author or authors.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springmodules.lucene.index.document.handler.object;

import java.util.HashMap;

import junit.framework.TestCase;

import org.apache.lucene.document.Document;
import org.springframework.core.io.ClassPathResource;
import org.springmodules.lucene.index.DocumentHandlerException;

public class PropertiesDocumentHandlerTests extends TestCase {
	public void testGetDocument() throws Exception {
		PropertiesDocumentHandler documentHandler = new PropertiesDocumentHandler();
		documentHandler.setPropertiesFileName(new ClassPathResource(
				"/org/springmodules/lucene/index/document/handler/object/mapping.properties"));

		TestBean bean = new TestBean();
		bean.setField1("field1");
		bean.setField2(2);
		bean.setField3("field3");

		Document document = documentHandler.getDocument(new HashMap(), bean);

		assertEquals("field1", document.get("field1"));
		String typeField1 = document.getField("field1").toString();
		assertTrue(typeField1.startsWith("stored/uncompressed,indexed,tokenized<"));

		assertEquals("2", document.get("field2"));
		String typeField2 = document.getField("field2").toString();
		assertTrue(typeField2.startsWith("stored/uncompressed,indexed,tokenized<"));

		assertNull(document.get("field3"));
		assertEquals("field3", document.get("myField"));
		String typeField3 = document.getField("myField").toString();
		assertTrue(typeField3.startsWith("stored/uncompressed,indexed<"));
	}

	public void testClassNotSupported() throws Exception {
		PropertiesDocumentHandler documentHandler = new PropertiesDocumentHandler();
		documentHandler.setPropertiesFileName(new ClassPathResource(
				"/org/springmodules/lucene/index/support/handler/object/mapping.properties"));
		try {
			documentHandler.getDocument(new HashMap(), "test");
			fail();
		} catch (DocumentHandlerException ex) {
		}
	}
}

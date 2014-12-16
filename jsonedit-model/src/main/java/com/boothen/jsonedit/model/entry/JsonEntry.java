/*******************************************************************************
 * Copyright 2014 Boothen Technology Ltd.
 *
 * Licensed under the Eclipse Public License, Version 1.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *   
 * https://eclipse.org/org/documents/epl-v10.html
 *  
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package com.boothen.jsonedit.model.entry;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITypedRegion;

public class JsonEntry {

	private final ITypedRegion typedRegion;
	private String content;
	
	public JsonEntry(ITypedRegion typedRegion, String content) {
		super();
		this.typedRegion = typedRegion;
		this.content = content;
	}
	
	public static JsonEntry createJsonEntry(ITypedRegion typedRegion, IDocument document) {
		try {
			String content = document.get(typedRegion.getOffset(), typedRegion.getLength());
			return new JsonEntry(typedRegion, content);
		} catch (BadLocationException e) {
			return null;
		}
	}

	public String getContent() {
		return content;
	}

	public String getType() {
		return typedRegion.getType();
	}
	
	public int getOffset() {
		return typedRegion.getOffset();
	}
	
	public int getLength() {
		return typedRegion.getLength();
	}
}
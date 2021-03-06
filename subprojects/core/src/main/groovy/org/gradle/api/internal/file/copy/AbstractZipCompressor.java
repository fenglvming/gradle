/*
 * Copyright 2012 the original author or authors.
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
package org.gradle.api.internal.file.copy;

import org.apache.tools.zip.ZipOutputStream;
import org.gradle.api.UncheckedIOException;

import java.io.File;

abstract class AbstractZipCompressor implements ZipCompressor {

    abstract public int getCompressedMethod();

    public ZipOutputStream createArchiveOutputStream(File destination) {
        try {
            ZipOutputStream outStream = new ZipOutputStream(destination);
            outStream.setMethod(getCompressedMethod());
            return outStream;
        } catch (Exception e) {
            String message = String.format("Unable to create ZIP output stream for file %s.", destination);
            throw new UncheckedIOException(message, e);
        }
    }
}

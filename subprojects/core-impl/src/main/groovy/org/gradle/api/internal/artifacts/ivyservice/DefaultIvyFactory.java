/*
 * Copyright 2007-2008 the original author or authors.
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
package org.gradle.api.internal.artifacts.ivyservice;

import org.apache.ivy.Ivy;
import org.apache.ivy.core.settings.IvySettings;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Hans Dockter
 */
public class DefaultIvyFactory implements IvyFactory {
    private final Map<IvySettings, Ivy> instanceCache = new HashMap<IvySettings, Ivy>();
    
    public Ivy createIvy(IvySettings ivySettings) {
        Ivy ivy = instanceCache.get(ivySettings);
        if (ivy == null) {
            ivy = Ivy.newInstance(ivySettings);
            instanceCache.put(ivySettings, ivy);
        }
        return ivy;
    }
}

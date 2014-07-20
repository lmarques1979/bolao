/*
 * Copyright 2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.bertramlabs.plugins.karman

/** Provides a standardized interface for dealing with files stored in the cloud.
*/
abstract class CloudFile implements CloudFileInterface {
	StorageProvider provider
	String name

	Boolean isFile() {
		return true
	}

	CloudFile text(String content) {
		setText(content)
		return this
	}

	CloudFile contentType(String content) {
		setContentType(content)
		return this
	}

	Boolean isDirectory() {
		return false
	}

	String toString() {
		return name
	}


	def save() {
		save(provider.defaultFileACL)
	}
}
/**
 * Copyright 2011 Alex Yanchenko
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
package org.droidparts.adapter.array;

import java.util.List;

import org.droidparts.annotation.inject.InjectSystemService;
import org.droidparts.inject.Injector;

import android.R;
import android.content.Context;
import android.view.LayoutInflater;

public class ArrayAdapter<T> extends android.widget.ArrayAdapter<T> {

	@InjectSystemService
	protected LayoutInflater layoutInflater;

	public ArrayAdapter(Context ctx, List<T> objects) {
		this(ctx, R.layout.simple_list_item_1, objects);
	}

	protected ArrayAdapter(Context ctx, int textViewResourceId, List<T> objects) {
		super(ctx, textViewResourceId, objects);
		Injector.get().inject(ctx, this);
	}

	public void reset(List<T> list) {
		clear();
		for (T item : list) {
			add(item);
		}
	}
}
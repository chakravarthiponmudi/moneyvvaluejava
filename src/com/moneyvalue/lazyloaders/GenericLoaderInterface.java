package com.moneyvalue.lazyloaders;

import java.util.List;



public interface GenericLoaderInterface <T> {
	public List<T> get();
	public void add(T obj);

}

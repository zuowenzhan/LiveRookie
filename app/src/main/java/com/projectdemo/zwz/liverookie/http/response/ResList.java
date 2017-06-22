package com.projectdemo.zwz.liverookie.http.response;


import com.projectdemo.zwz.liverookie.http.IDontObfuscate;

import java.util.List;

/**
 * @description: 列表返回数据
 *
 * @author: Andruby
 * @time: 2016/11/2 18:07
 */
public class ResList<T>  extends IDontObfuscate {

	public int pageIndex;
	public int pageSize;

	public List<T> items;

	@Override
	public String toString() {
		return "ResList{" +
				"currentPage=" + pageIndex +
				", totalRow=" + pageSize +
				", totalPage="  +
				", items=" + items +
				'}';
	}
}

package org.study.spring.core.appCtx.beans;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class ListInputBean {

	private Properties props;
	private List<String> list;
	private Set<String> listSet;
	private Map<String, String> map;

	public ListInputBean(Properties props, List<String> list, Set<String> set, Map<String,String> m) {
		this.setProps(props);
		this.setList(list);
		this.setListSet(set);
		this.setMap(m);
		System.out.println("List bean constructor called");
	}
	
	public ListInputBean(Set<String> set) {
		this.setListSet(set);
	}

	public Properties getProps() {
		return props;
	}

	public void setProps(Properties props) {
		this.props = props;
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	public Set<String> getListSet() {
		return listSet;
	}

	public void setListSet(Set<String> listSet) {
		this.listSet = listSet;
	}

	public Map<String, String> getMap() {
		return map;
	}

	public void setMap(Map<String, String> map) {
		this.map = map;
	}
}

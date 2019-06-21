package model;

import javax.sql.DataSource;

public class testclass {
	
	int test;
private DataSource dataSource;
	
	public testclass (DataSource DTS){
		dataSource = DTS;
	}
	public testclass() {
		super();
		
	}

	public void printst()
	{
		System.out.println("RHNHK");
	}
}

package br.com.makersweb.enums;

public enum PagesEnum {
	
	Home("home"),
	Contact("contato");
	
	private String page;

	
	private PagesEnum(String page) {
		this.page = page;
	}

	public String getPage() {
		return page;
	}	
}

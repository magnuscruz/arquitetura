package br.unifor.arquitetura.boot.hello;
public class Greeting {

    private long id;
    private String content;
    public Greeting() {
    	
    }

    public Greeting(long id, String content) {
        this.setId(id);
        this.setContent(content);
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

	public void setId(long id) {
		this.id = id;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
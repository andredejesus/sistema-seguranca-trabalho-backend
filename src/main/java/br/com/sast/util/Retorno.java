package br.com.sast.util;

import java.util.List;

public class Retorno {

	private boolean temErro;
	private String msg;
	private List<String> msgsErro;
	
	
	public boolean isTemErro() {
		return temErro;
	}
	public void setTemErro(boolean temErro) {
		this.temErro = temErro;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public List<String> getMsgsErro() {
		return msgsErro;
	}
	public void setMsgsErro(List<String> msgsErro) {
		this.msgsErro = msgsErro;
	}
	
	
	
}

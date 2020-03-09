package br.com.jg.loucademia.application.utils;

public class Validation {
	
	public static void assertNotEmpty(Object obj){
		if(obj instanceof String) {
			String s = (String) obj;
			if(StringUtils.isEmpty(s)) {
				throw new ValidationException("O texto não pode ser nulo");
			}
			
			if(obj == null) {
				throw new ValidationException("Valor não pode ser nulo");
			}
		}
	}
	
	public static void rgRepetido(Object obj) {
		if(obj != null){
			throw new EntradaRepetidaException("RG já existe no BD");
		}
	}
}

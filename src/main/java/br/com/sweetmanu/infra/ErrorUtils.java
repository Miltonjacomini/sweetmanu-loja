package br.com.sweetmanu.infra;

import java.util.HashMap;
import java.util.Map;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.servlet.ModelAndView;

public class ErrorUtils {

	static Map<String, String> mapErros = new HashMap<String, String>();
	
	public static ModelAndView retornaErrosNaView(BindingResult bindingResult, ModelAndView modAndView){
		return adicionaErrosView(getErros(bindingResult), modAndView);
	}
	
	private static Map<String, String> getErros(BindingResult bindingResult){
		
		for (Object object : bindingResult.getAllErrors()) {
		    if(object instanceof FieldError) {
		        FieldError fieldError = (FieldError) object;
		        mapErros.put(fieldError.getCode(), fieldError.getDefaultMessage());
		    }

		    if(object instanceof ObjectError) {
		        ObjectError objectError = (ObjectError) object;
		        mapErros.put(objectError.getCode(), objectError.getDefaultMessage());
		    }
		}
		
		return mapErros;
	}
	
	private static ModelAndView adicionaErrosView(Map<String, String> erros, ModelAndView modAndView) {
		erros.forEach((code,message) -> {
			modAndView.addObject("messageError", message);
		});
		return modAndView;
	}
	
}

package br.com.fiap.coletaDeLixo.advice;

import org.hibernate.dialect.unique.CreateTableUniqueDelegate;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ApplicationExceptionHandler {

    public Map<String, String> handleInvalidArgument(MethodArgumentNotValidException error){
        Map<String, String> errorMap = new HashMap<>();
        List<FieldError> campos = error.getBindingResult().getFieldErrors();

        for(FieldError campo : campos){
            errorMap.put(campo.getField(), campo.getDefaultMessage());
        }
        return errorMap;
    }
}

package br.com.mariafernanda.todolist.utils;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.beans.PropertyDescriptor;
import java.util.HashSet;
import java.util.Set;

public class Utils {

    //copia as propriedades NÃO NULAS do source para o target
    public static void copyNonNullProperties(Object source, Object target) {
        BeanUtils.copyProperties(
                source, //da onde serão copiadas as propriedades
                target, //para onde será copiado
                getNullPropertyNames(source) //quais propriedades NÃO devem ser copiadas
        );
    }

    //retorna o nome de todas as propriedades que tem valor nulo
    public static String[] getNullPropertyNames(Object source) {

        final BeanWrapper src = new BeanWrapperImpl(source); //para acessar as propriedades
        PropertyDescriptor[] pds = src.getPropertyDescriptors(); //lista os descriptors da propriedade
        Set<String> emptyNames = new HashSet<>(); //lista das propriedades nulas

        //preenche as lista de propriedades
        for (PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName()); //valor da propriedade
            if (srcValue == null) {
                emptyNames.add(pd.getName()); //adiciona a emptyNames
            }
        }
        String[] result = new String[emptyNames.size()]; //array de string com o tamanho de propriedades nulas

        return emptyNames.toArray(result); //retorna emptyNames em forma de array de string
    }

}


// classe per gestione eccezzioni

package it.unica.eurospirri.exceptions;


public class InvalidParamException extends Exception {
    public InvalidParamException(String errorMessage){
        super(errorMessage);
    }
}

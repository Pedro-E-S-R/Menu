package com.example.Menu.Exceptions;

public class ResourceNotFoundExeception extends RuntimeException{

    public ResourceNotFoundExeception(Object tx){
            super("Objeto não encontrado: " + tx);
    }
}

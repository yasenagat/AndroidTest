package com.dgcy.http.base;


import java.io.Serializable;

public interface IResponseMsg<T> extends Serializable {
    public T getRes_Body();
}

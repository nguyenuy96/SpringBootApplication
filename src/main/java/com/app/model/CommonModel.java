package com.app.model;

public abstract class CommonModel<E, M> {
    public abstract M convertEntity2Model(E e);
}

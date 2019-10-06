package com.training.ServletLogin.utils;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;


public class Pagination<T> implements Serializable {
    public static final int LIMIT = 7;
    public static final int OFFSET= 0;
    private int numberOfPages;
    private List<T> list;


    public Pagination(int numberOfRecords, List<T> list) {
        this.list = list;
        this.numberOfPages = numberOfRecords/LIMIT;
    }


    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfRecords(int numberOfRecords) {
        this.numberOfPages = numberOfRecords;
    }


    /**
     * The limit for this pagination object. The limit determines the maximum amount of results to return.
     *
     * @return the limit
     */
    public int getLimit() {
        return LIMIT;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pagination<?> that = (Pagination<?>) o;
        return getNumberOfPages() == that.getNumberOfPages() &&
                Objects.equals(getList(), that.getList());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNumberOfPages(), getList());
    }
}
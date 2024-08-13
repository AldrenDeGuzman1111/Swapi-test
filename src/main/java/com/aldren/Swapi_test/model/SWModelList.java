package com.aldren.Swapi_test.model;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class SWModelList<People> implements Serializable {

    private static final long serialVersionUID = -5396859365428600886L;
	private int count;
    private String next;
    private String previous;
    private List<People> results;

    public boolean hasMore() {
        return (next != null && next.length() != 0);
    }

}

package com.Brafe.Brafe;

import com.Brafe.Brafe.adapter.in.model.Produto;

import java.util.Arrays;
import java.util.List;

public class MockObj {


    public List<Produto> produtos() {
        return Arrays.asList(
                new Produto(1L, "Produto1", 10.0, "test", 2, null)
        );
    }
}

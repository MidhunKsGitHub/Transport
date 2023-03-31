package com.midhun.hawkssolutions.transport.Response;

import com.google.gson.annotations.SerializedName;
import com.midhun.hawkssolutions.transport.Modal.ExpenseType;

import java.util.List;

public class ExpenseTypeApiModel {

    @SerializedName("types")
    List<ExpenseType> types;

    public ExpenseTypeApiModel(List<ExpenseType> types) {
        this.types = types;
    }

    public List<ExpenseType> getTypes() {
        return types;
    }

    public void setTypes(List<ExpenseType> types) {
        this.types = types;
    }
}

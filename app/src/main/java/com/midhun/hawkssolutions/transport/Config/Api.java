package com.midhun.hawkssolutions.transport.Config;

import com.midhun.hawkssolutions.transport.Modal.Login;
import com.midhun.hawkssolutions.transport.Modal.Status;
import com.midhun.hawkssolutions.transport.Response.ExpenseDetailsApiModel;
import com.midhun.hawkssolutions.transport.Response.ExpenseTypeApiModel;
import com.midhun.hawkssolutions.transport.Response.ProductApiModel;
import com.midhun.hawkssolutions.transport.Response.ProfileDetailsApiModel;
import com.midhun.hawkssolutions.transport.Response.TripDetailsApiModel;
import com.midhun.hawkssolutions.transport.Response.TripInfoApiModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface Api {

    @FormUrlEncoded
    @POST("getStatusData")
    @Headers("Content-Type: application/x-www-form-urlencoded")
    Call<ProductApiModel> getAllProducts(@Field("Authorization") String Authorization,
                                         @Header("Authorization") String authorization,
                                         @Field("table") String table,
                                         @Field("offset") String offset,
                                         @Field("pageLimit") String pageLimit

    );


    //login


    @FormUrlEncoded
    @POST("common/authenticate")
    @Headers("Content-Type: application/x-www-form-urlencoded")
    Call<List<Login>> luserLogin(@Header("Authorization") String authorization,
                                 @Field("username") String username,
                                 @Field("password") String password


    );

    @FormUrlEncoded
    @POST("employees/getAllTrips")
    @Headers("Content-Type: application/x-www-form-urlencoded")
    Call<TripDetailsApiModel> getTripInfo(@Field("Authorization") String Authorization,
                                          @Header("Authorization") String authorization,
                                          @Field("employee_id") String employee_id,
                                          @Field("date") String date


    );


    @FormUrlEncoded
    @POST("employees/getProfile")
    @Headers("Content-Type: application/x-www-form-urlencoded")
    Call<ProfileDetailsApiModel> getProfileDetails(@Field("Authorization") String Authorization,
                                                   @Header("Authorization") String authorization,
                                                   @Field("employee_id") String employee_id


    );


    @FormUrlEncoded
    @POST("trip/getDetails")
    @Headers("Content-Type: application/x-www-form-urlencoded")
    Call<TripInfoApiModel> getTripInfo(@Field("Authorization") String Authorization,
                                       @Header("Authorization") String authorization,
                                       @Field("trip_id") String trip_id


    );




    @FormUrlEncoded
    @POST("trip/updateKM")
    @Headers("Content-Type: application/x-www-form-urlencoded")
    Call<Status> updateKm(@Field("Authorization") String Authorization,
                          @Header("Authorization") String authorization,
                          @Field("id") String trip_id,
                          @Field("starting_km") String starting_km,
                          @Field("startingKmImageUrl") String startingKmImageUrl,
                          @Field("end_km") String end_km,
                          @Field("endingKmImageUrl") String endingKmImageUrl,
                          @Field("trip_status") String trip_status


    );


    @FormUrlEncoded
    @POST("trip/getExpenseTypes")
    @Headers("Content-Type: application/x-www-form-urlencoded")
    Call<ExpenseTypeApiModel> getExpenseType(@Field("Authorization") String Authorization,
                                             @Header("Authorization") String authorization,
                                             @Field("table") String expense_types


    );


    @FormUrlEncoded
    @POST("trip/addExpenseSingle")
    @Headers("Content-Type: application/x-www-form-urlencoded")
    Call<Status> addExpense(@Field("Authorization") String Authorization,
                            @Header("Authorization") String authorization,
                            @Field("expense_type_id") String expense_type_id,
                            @Field("expense") String expense,
                            @Field("quantity") String quantity,
                            @Field("amount") String amount,
                            @Field("expense_date") String expense_date,
                            @Field("note") String note,
                            @Field("trip_id") String trip_id


    );

    @FormUrlEncoded
    @POST("trip/expenses")
    @Headers("Content-Type: application/x-www-form-urlencoded")
    Call<ExpenseDetailsApiModel> getTripExpense(@Field("Authorization") String Authorization,
                                                @Header("Authorization") String authorization,
                                                @Field("trip_id") String trip_id


    );
}

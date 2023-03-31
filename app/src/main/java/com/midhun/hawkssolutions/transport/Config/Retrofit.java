package com.midhun.hawkssolutions.transport.Config;

import static com.midhun.hawkssolutions.transport.Config.Constants.BASE_URL;

import retrofit2.converter.gson.GsonConverterFactory;

public class Retrofit {
    retrofit2.Retrofit retrofit=new retrofit2.Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    public Api api=retrofit.create(Api.class);
}

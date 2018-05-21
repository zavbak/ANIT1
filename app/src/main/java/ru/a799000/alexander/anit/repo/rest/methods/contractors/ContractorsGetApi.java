package ru.a799000.alexander.anit.repo.rest.methods.contractors;

import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.QueryMap;
import ru.a799000.alexander.anit.repo.rest.BaseRsMod;


public interface ContractorsGetApi {
    @GET("contractors.get/")
    Single<BaseRsMod<ContractorsGetRsMod>> getData(
            @QueryMap Map<String, String> map,
            @Header("Authorization") String auth);
}

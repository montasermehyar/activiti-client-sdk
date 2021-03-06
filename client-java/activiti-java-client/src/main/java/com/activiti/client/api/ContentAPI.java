/*
 *  Copyright (C) 2005-2016 Alfresco Software Limited.
 *
 *  This file is part of Alfresco Activiti Client.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package com.activiti.client.api;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import rx.Observable;

import com.activiti.client.api.model.runtime.RelatedContentRepresentation;
import com.activiti.client.api.model.runtime.request.AddContentRelatedRepresentation;

/**
 * Created by jpascal on 11/12/2014.
 */
public interface ContentAPI
{

    @GET("api/enterprise/content/{contentId}")
    Call<RelatedContentRepresentation> getContent(@Path("contentId") String contentId);

    @GET("api/enterprise/content/{contentId}")
    Observable<RelatedContentRepresentation> getContentObservable(@Path("contentId") String contentId);

    @Headers({ "Content-type: application/json" })
    @POST("api/enterprise/content")
    Call<RelatedContentRepresentation> createTemporaryRelatedContent(
            @Body AddContentRelatedRepresentation representation);

    @Headers({ "Content-type: application/json" })
    @POST("api/enterprise/content")
    Observable<RelatedContentRepresentation> createTemporaryRelatedContentObservable(
            @Body AddContentRelatedRepresentation representation);

    @Multipart
    @POST("api/enterprise/content/raw")
    Call<RelatedContentRepresentation> createTemporaryRawRelatedContent(@Part("file") RequestBody body);

    @Multipart
    @POST("api/enterprise/content/raw")
    Observable<RelatedContentRepresentation> createTemporaryRawRelatedContentObservable(@Part("file") RequestBody body);

    @DELETE("api/enterprise/content/{contentId}")
    Call<Void> deleteContent(@Path("contentId") String contentId);

    @DELETE("api/enterprise/content/{contentId}")
    Observable<Void> deleteContentObservable(@Path("contentId") String contentId);

    @GET("api/enterprise/content/{contentId}/raw")
    Call<ResponseBody> getRawContent(@Path("contentId") String contentId);

    @GET("api/enterprise/content/{contentId}/raw")
    Observable<ResponseBody> getRawContentObservable(@Path("contentId") String contentId);

    @GET("api/enterprise/content/{contentId}/rendition/{renditionType}")
    Call<ResponseBody> getContentRendition(@Path("contentId") String contentId,
            @Path("renditionType") String renditionType);

    @GET("api/enterprise/content/{contentId}/rendition/{renditionType}")
    Observable<ResponseBody> getContentRenditionObservable(@Path("contentId") String contentId,
            @Path("renditionType") String renditionType);
}

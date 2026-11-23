package com.study.demo;

public record ApiResponse<T>(Boolean success, T data,  String message) {
    public static <T> ApiResponse<T> okay (T data){
        return new ApiResponse<>(true, data, null);
    }

    public static <T> ApiResponse<T> error (String message){
        return new ApiResponse<>(false, null, message);
    }


}


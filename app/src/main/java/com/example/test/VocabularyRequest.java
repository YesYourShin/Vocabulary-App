package com.example.test;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class VocabularyRequest extends StringRequest {

    // 서버 URL 설정
    final static private String URL = "ehrl827.dothome.co.kr/Register.php";
    private Map<String, String> map;


    public VocabularyRequest(String kanji, String hatsuon, String imi, Response.Listener<String> listener) {
        super(Method.POST, URL, listener, null);

        map = new HashMap<>();
        map.put("kanji", kanji);
        map.put("hatsuon", hatsuon);
        map.put("imi", imi);

    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return map;
    }
}

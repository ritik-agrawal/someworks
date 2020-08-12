package com.hackathon.chatbox;

import com.google.gson.Gson;
import com.hackathon.chatbox.exception.DisplayMessageException;
import com.hackathon.chatbox.utils.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Service;

import java.util.Date;

@Slf4j
public abstract class AbstractApi<I,O> {

    private static final String suppressedJson = "{\"log\": \"suppressed\"}";
    @Autowired private Gson gson;

    public abstract O callApi(I in);

    protected  boolean logInput(){return true;}
    protected boolean logOutput(){return true;}

    public O executeApi(I in){
        long startTime = new Date().getTime();
        O out = null;
        try {
            callPreApi(in);
            out = callApi(in);
            callPostApi(in,out,startTime);
            return out;
        } catch (Exception e) {
            if (e instanceof DisplayMessageException) {
                log.error("Api DisplayMessageException: {}", e.getMessage());
            } else {
                String msg = "Api Exception: " + e.getMessage();
                if(e != null)
                    e.printStackTrace();
                log.error(msg, e);
            }
            throw e;
        }finally {
            long totalTime = new Date().getTime() - startTime;
            String apiName = getApiName();
            String input = logInput() ? obj2str(in) : suppressedJson;
            String output = out == null ? "null" :  new Gson().toJson(out);
            log.info(String.format("ApiFinished=%s Input=%s Output=%s Time=%sms.", apiName, input, output, totalTime));
        }
    }

    private void callPreApi(I in) {
        //log.info("ApiStarted={} MTAppPC={} MTReqId={}", getApiName(), HttpUtil.getMtPartnerCode(), HttpUtil.getMtRequestId());
    }

    private void callPostApi(I in, O out, long startTime) {}

    private String getApiName(){
        Service apiName = AnnotationUtils.findAnnotation(this.getClass(), Service.class);
        if (null == apiName){
            return "";
        }
        return StringUtils.hasText(apiName.value()) ? apiName.value() : this.getClass().getName();
    }

    private String obj2str(Object object){return gson.toJson(object);}
}

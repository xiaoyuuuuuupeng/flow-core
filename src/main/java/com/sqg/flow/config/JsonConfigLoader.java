package com.sqg.flow.config;

import com.envconfig.common.utils.JsonUtil;

import java.io.*;

public class JsonConfigLoader implements ConfigLoader{
    @Override
    public FlowConfig load(String path) {
        InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream(path);


        try {
            assert resourceAsStream != null;
            BufferedReader streamReader = new BufferedReader(new InputStreamReader(resourceAsStream, "UTF-8"));
            StringBuilder responseStrBuilder = new StringBuilder();

            String inputStr;
            while ((inputStr = streamReader.readLine()) != null)
                responseStrBuilder.append(inputStr);
            return JsonUtil.toObject(responseStrBuilder.toString(), FlowConfig.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

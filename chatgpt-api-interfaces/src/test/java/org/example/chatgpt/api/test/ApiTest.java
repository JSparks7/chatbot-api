package org.example.chatgpt.api.test;


import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class ApiTest {

    @Test
    public void query_unanswered_question() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpGet get = new HttpGet("https://api.zsxq.com/v2/groups/28885518425541/topics?scope=all&count=20");

        get.addHeader("cookie",
                "zsxq_access_token=9C4ACB0A-0BDB-AD3C-64DE-C3B23C55B421_C4C2F0783087B5EE; abtest_env=product; zsxqsessionid=feb1c47b04df117271f84bfa90e9b324; sajssdk_2015_cross_new_user=1; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22818255412585852%22%2C%22first_id%22%3A%221890506be3933b-0aa61cb2a7a2d6-26031d51-1328640-1890506be3a1603%22%2C%22props%22%3A%7B%7D%2C%22%24device_id%22%3A%221890506be3933b-0aa61cb2a7a2d6-26031d51-1328640-1890506be3a1603%22%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMTg5MDUwNzc1MjkzZmItMDVhMDI2MzRmNGIxNDRjLTI2MDMxZDUxLTEzMjg2NDAtMTg5MDUwNzc1MmExYzQ1IiwiJGlkZW50aXR5X2xvZ2luX2lkIjoiODE4MjU1NDEyNTg1ODUyIn0%3D%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%24identity_login_id%22%2C%22value%22%3A%22818255412585852%22%7D%7D");
        get.addHeader("Content-Type", "application/json;charset=utf8");

        CloseableHttpResponse response = httpClient.execute(get);
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        } else System.out.println(response.getStatusLine().getStatusCode());
        httpClient.close();
    }

    @Test
    public void answer() throws IOException  {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpPost post = new HttpPost("https://api.zsxq.com/v2/topics/181115821121822/comments");

        post.addHeader("cookie",
                "zsxq_access_token=9C4ACB0A-0BDB-AD3C-64DE-C3B23C55B421_C4C2F0783087B5EE; abtest_env=product; zsxqsessionid=feb1c47b04df117271f84bfa90e9b324; sajssdk_2015_cross_new_user=1; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22818255412585852%22%2C%22first_id%22%3A%221890506be3933b-0aa61cb2a7a2d6-26031d51-1328640-1890506be3a1603%22%2C%22props%22%3A%7B%7D%2C%22%24device_id%22%3A%221890506be3933b-0aa61cb2a7a2d6-26031d51-1328640-1890506be3a1603%22%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMTg5MDUwNzc1MjkzZmItMDVhMDI2MzRmNGIxNDRjLTI2MDMxZDUxLTEzMjg2NDAtMTg5MDUwNzc1MmExYzQ1IiwiJGlkZW50aXR5X2xvZ2luX2lkIjoiODE4MjU1NDEyNTg1ODUyIn0%3D%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%24identity_login_id%22%2C%22value%22%3A%22818255412585852%22%7D%7D");
        post.addHeader("Content-Type", "application/json;charset=utf8");
        String paramJson = "{\n" +
                "  \"req_data\": {\n" +
                "    \"text\": \"新测试啦！\\n\",\n" +
                "    \"image_ids\": [],\n" +
                "    \"mentioned_user_ids\": []\n" +
                "  }\n" +
                "}";

        StringEntity stringEntity = new StringEntity(paramJson, ContentType.create("text/json", "UTF-8"));
        post.setEntity(stringEntity);
        CloseableHttpResponse response = httpClient.execute(post);
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        } else System.out.println(response.getStatusLine().getStatusCode());
        httpClient.close();
    }
}
package alex.pol.controllers;

/**
 * Created by Abashkin Aleksandr on 12.06.2016.
 */

import alex.pol.util.ClassNameUtil;
import org.apache.http.HttpEntity;
import org.apache.http.client.cache.HttpCacheContext;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.cache.CacheConfig;
import org.apache.http.impl.client.cache.CachingHttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class AdRestController {
    private final CacheConfig cacheConfig = CacheConfig.custom()
            .setMaxCacheEntries(1000)
            .setMaxObjectSize(8192)
            .build();
    private final RequestConfig requestConfig = RequestConfig.custom()
            .setConnectTimeout(30000)
            .setSocketTimeout(30000)
            .build();
    private final CloseableHttpClient cachingClient = CachingHttpClients.custom()
            .setCacheConfig(cacheConfig)
            .setDefaultRequestConfig(requestConfig)
            .build();
    private final HttpCacheContext context = HttpCacheContext.create();


    private static final Logger log = Logger.getLogger(ClassNameUtil.getCurrentClassName());

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/api/test/{id}")
    public ResponseEntity showRest(@PathVariable("id") int id) throws IOException {
        String url = "http://localhost:8081/admins/" + id;
        HttpGet httpget = new HttpGet(url);


        try (CloseableHttpResponse response = cachingClient.execute(httpget, context)) {
            HttpEntity entity;
            if (response.getStatusLine().getStatusCode() == 200) {
                entity = response.getEntity();
                if (entity != null && entity.getContentLength() != -1) {
                    String body = EntityUtils.toString(entity);
                    return ResponseEntity.ok().body(body);
                }
            }
        }
        return null;
    }
}


package alex.pol.util.Redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
public class RedisController {

    @Autowired
    private RedisTemplate< String, Object> template;

    //@Autowired private HashOperations hashOps;

    @RequestMapping("/redis")
    public String saveKeyValuePair() throws InterruptedException {
        ///hashOps = template.opsForHash();
        ///template.
        String key="name";
        //hashOps.put(key,key,"dima");
        template.opsForValue().set( key, "Dima" );
        template.expire( key, 10, TimeUnit.SECONDS);
        String outputString =(String) template.opsForValue().get(key);
        //Thread.sleep(10000L);
        //outputString+=(String) template.opsForValue().get(key);
        return  outputString;
    }

    @RequestMapping("/redis1")
    public String getValueByKey() throws InterruptedException {
        String key="name";
        String outputString =(String) template.opsForValue().get(key);
        return  outputString;
    }
}

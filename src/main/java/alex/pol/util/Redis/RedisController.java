package alex.pol.util.Redis;

import alex.pol.util.restServerInteraction.TokenGenerator;
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

    /*
    @RequestMapping("/redis")
    public String saveKeyValuePair() throws InterruptedException {
        String key="name";
        template.opsForValue().set( key, "Dima" );
        template.expire( key, 10, TimeUnit.SECONDS);
        String outputString =(String) template.opsForValue().get(key);
        return  outputString;
    }

    @RequestMapping("/redis1")
    public String getValueByKey() throws InterruptedException {
        String key="name";
        String outputString =(String) template.opsForValue().get(key);
        return  outputString;
    }*/

    @RequestMapping("/putTokenToRedis")
    public String saveKeyValuePairRemote() throws InterruptedException {
        //String key="name";
        //template.opsForValue().set( key, "Dima" );
        String key = "token";
        template.opsForValue().set(key, new String(TokenGenerator.generateRandomCharArray(10)));
        template.expire( key, 3 , TimeUnit.DAYS);
        String outputString =(String) template.opsForValue().get(key);
        return  outputString;
    }

    @RequestMapping("/getTokenFromRedis")
    public String getValueByKeyRemote() throws InterruptedException {
        String key="token";
        String outputString =(String) template.opsForValue().get(key);
        return  outputString;
    }

    @RequestMapping("/putCharArrayToRedis")
    public String saveKeyValuePairAsCharArray() throws InterruptedException {
        String key = "token";
        char [] tokenArray =TokenGenerator.generateRandomCharArray(10);
        template.opsForValue().set(key, tokenArray);
        template.expire( key, 2 , TimeUnit.MINUTES);
        char [] outputCharArray = (char[]) template.opsForValue().get(key);
        return "sent token = " + new String(tokenArray) +
                ", token received from redis = " + new String(outputCharArray);
    }
}
//
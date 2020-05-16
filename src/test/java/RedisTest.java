import org.junit.Test;
import redis.clients.jedis.Jedis;

public class RedisTest {

    @Test
    public void redisTest(){
        Jedis jedis = new Jedis("localhost",6379);
        String result = jedis.ping();
        System.out.println(result);
        jedis.set("aa","abv");
        jedis.set("ba","aba");
        jedis.set("ca","aba");
        jedis.set("da","aba");
        jedis.set("ea","aba");
        jedis.set("fa","aba");


        jedis.close();

    }
}

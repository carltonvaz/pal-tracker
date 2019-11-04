package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class EnvController {

    @Value("${port:NOT SET}")
    private String PORT;

    @Value("${memory.limit:NOT SET}")
    private String MEMORY_LIMIT;

    @Value("${cf.instance.index:NOT SET}")
    private String CF_INSTANCE_INDEX;

    @Value("${cf.instance.index:NOT SET}")
    private String CF_INSTANCE_ADDR;

    public EnvController(@Value("${port:NOT SET}")String port,
                         @Value("${memory.limit:NOT SET}")String memory_limit,
                         @Value("${cf.instance.index:NOT SET}")String cf_instance_index,
                         @Value("${cf.instance.addr: NOT SET}")String cf_instance_addr) {
        PORT = port;
        MEMORY_LIMIT = memory_limit;
        CF_INSTANCE_INDEX = cf_instance_index;
        CF_INSTANCE_ADDR = cf_instance_addr;
    }

    @GetMapping("/env")
    public Map<String, String> getEnv(){
        Map<String, String> myMap = new HashMap<>();
        myMap.put("PORT", PORT);
        myMap.put("MEMORY_LIMIT", MEMORY_LIMIT);
        myMap.put("CF_INSTANCE_INDEX", CF_INSTANCE_INDEX);
        myMap.put("CF_INSTANCE_ADDR", CF_INSTANCE_ADDR);

        return myMap;
    }
}


//    EnvController controller = new EnvController(
//            "8675",
//            "12G",
//            "34",
//            "123.sesame.street"
//    );
//
//    Map<String, String> env = controller.getEnv();
//
//    assertThat(env.get("PORT")).isEqualTo("8675");
//        assertThat(env.get("MEMORY_LIMIT")).isEqualTo("12G");
//        assertThat(env.get("CF_INSTANCE_INDEX")).isEqualTo("34");
//        assertThat(env.get("CF_INSTANCE_ADDR")).isEqualTo("123.sesame.street");